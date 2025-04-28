package com.github.Debris.GAHigher.block;

import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

import java.util.Random;

public class BlockTomato extends BlockGrowingPlant {
    public static final int BLUEBERRY = 0;

    public static final String[] types = new String[]{"tomato"};

    private Icon[] icons;

    protected BlockTomato(int id) {
        super(id);
        float width = 0.22F;
        float height = 1.0F;
        setBlockBoundsForAllThreads((0.5F - width), 0.0D, (0.5F - width), (0.5F + width), height, (0.5F + width));
        setMaxStackSize(64);
        setStepSound(soundGrassFootstep);
    }

    @Override
    public void registerIcons(IconRegister icon_register) {
        this.icons = new Icon[types.length * 2];
        for (int i = 0; i < types.length; i++) {
            if (types[i] != null) {
                this.icons[i * 2] = icon_register.registerIcon(getTextureName() + "/" + types[i]);
                this.icons[i * 2 + 1] = icon_register.registerIcon(getTextureName() + "/" + types[i] + "_picked");
            }
        }
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.icons[getBlockSubtype(metadata) * 2 + (hasBerries(metadata) ? 0 : 1)];
    }

    public String getMetadataNotes() {
        return "Bits 1 and 2 used for subtype, bits 4 and 8 used to track berry growth";
    }

    public boolean isValidMetadata(int metadata) {
        return ((metadata & 0x3) < types.length);
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 0x3;
    }

    public int getItemSubtype(int metadata) {
        return setBerryGrowth(getBlockSubtype(metadata), getMaxBerryGrowth());
    }

    public static int getMaxBerryGrowth() {
        return 3;
    }

    public static boolean hasBerries(int metadata) {
        return (getBerryGrowth(metadata) == getMaxBerryGrowth());
    }

    public static int setBerryGrowth(int metadata, int growth) {
        return metadata & 0x3 | MathHelper.clamp_int(growth, 0, getMaxBerryGrowth()) << 2;
    }

    public static int getBerryGrowth(int metadata) {
        return metadata >> 2;
    }

    public static int incrementBerryGrowth(int metadata) {
        return setBerryGrowth(metadata, getBerryGrowth(metadata) + 1);
    }

    public static int setToMaximumBerryGrowth(int metadata) {
        return setBerryGrowth(metadata, getMaxBerryGrowth());
    }

    public static int getMetadataForBushWithBerries(int subtype) {
        return setToMaximumBerryGrowth(subtype);
    }

    public int getMinAllowedLightValue() {
        return 8;
    }

    public int getMaxAllowedLightValue() {
        return 15;
    }

    public boolean dropsAsSelfWhenTrampled(Entity entity) {
        return false;
    }

    public boolean isBiomeSuitable(BiomeGenBase biome, int metadata) {
        return true;
    }

    public boolean canBePlacedAt(World world, int x, int y, int z, int metadata) {
        return this.isBiomeSuitable(world.getBiomeGenForCoords(x, z), metadata) && world.canBlockSeeTheSky(x, y, z) && super.canBePlacedAt(world, x, y, z, metadata);
    }

    public int getPatchSize(BiomeGenBase biome) {
        return 64;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offset_x, float offset_y, float offset_z) {
        int metadata = world.getBlockMetadata(x, y, z);
        if (!hasBerries(metadata))
            return false;
        if (player.onServer()) {
            dropBlockAsEntityItem((new BlockBreakInfo(world, x, y, z)).setPickedBy(player), new ItemStack(Items.Tomato, Constant.GARandom.nextInt(3) + 1, 0));
            world.setBlock(x, y, z, this.blockID, setBerryGrowth(metadata, 0), 2);
        }
        return true;
    }

    public boolean fertilize(World world, int x, int y, int z, ItemStack item_stack) {
        Item item = item_stack.getItem();
        if (item == Item.dyePowder) {
            int metadata = world.getBlockMetadata(x, y, z);
            if (hasBerries(metadata))
                return false;
            if (!world.isRemote) {
                int growth_added = MathHelper.getRandomIntegerInRange(world.rand, 1, 2);
                while (growth_added-- > 0)
                    metadata = incrementBerryGrowth(metadata);
                world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
            }
            return true;
        }
        return false;
    }

    public int dropBlockAsItself(BlockBreakInfo info) {
        return dropBlockAsEntityItem(info, 178, 0);
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (hasBerries(info.getMetadata()) && (info.wasHarvestedByPlayer() || info.wasSelfDropped() || info.wasNotLegal()))
            return dropBlockAsEntityItem(info, new ItemStack(Items.Tomato, Constant.GARandom.nextInt(3) + 1, 0));
        return 0;
    }

    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
        return entity instanceof EntityPlayer && entity.getAsPlayer().inCreativeMode() ? item_stack.getItemSubtype() : setBerryGrowth(item_stack.getItemSubtype(), 0);
    }

    public float getGrowthRate(World world, int x, int y, int z) {
        float growth_rate = 0.1F;
        BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
        growth_rate *= this.getTemperatureGrowthRateModifier(biome.temperature);
        growth_rate *= this.getHumidityGrowthRateModifier(biome.isHighHumidity());
        growth_rate *= this.getGlobalGrowthRateModifierFromMITE();
        return growth_rate;
    }

    public boolean updateTick(World world, int x, int y, int z, Random rand) {
        if (super.updateTick(world, x, y, z, rand))
            return true;
        int metadata = world.getBlockMetadata(x, y, z);
        if (hasBerries(metadata))
            return false;
        int berry_growth = getBerryGrowth(metadata);
        float growth_rate = getGrowthRate(world, x, y, z);
        if (growth_rate == 0.0F)
            return false;
//        int blv = world.n(x, y + 1, z);
        int blv = world.getBlockLightValue(x, y + 1, z);
        if (isLightLevelSuitableForGrowth(blv) &&
                rand.nextFloat() < growth_rate) {
//            world.b(x, y, z, incrementBerryGrowth(metadata), 2);
            world.setBlockMetadataWithNotify(x, y, z, incrementBerryGrowth(metadata), 2);
            return true;
        }
        return false;
    }


    public float getLowestOptimalTemperature() {
        return BiomeGenBase.forestHills.temperature;
    }

    public float getHighestOptimalTemperature() {
        return BiomeGenBase.forest.temperature;
    }

//    public float getLowestOptimalTemperature() {
//        return BiomeGenBase.t.F;
//    }
//
//    public float getHighestOptimalTemperature() {
//        return BiomeGenBase.f.F;
//    }

    public float getHumidityGrowthRateModifier(boolean high_humidity) {
        return 1.0F;
    }
}