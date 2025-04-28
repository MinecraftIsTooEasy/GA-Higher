package com.github.Debris.GAHigher.block;

import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

import java.util.Random;

/**
 * This class is based on BlockReed, or sugar cane.
 */
public class BlockBamboo extends Block {
    protected BlockBamboo(int par1) {
        super(par1, Material.plants, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
//        super(par1, Material.s, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
        float var2 = 0.275F;
        setBlockBoundsForAllThreads((0.5F - var2), 0.0D, (0.5F - var2), (0.5F + var2), 1.0D, (0.5F + var2));
//        b(true);
        setTickRandomly(true);
//        setStepSound(j);
        setStepSound(soundGrassFootstep);
        setHardness(BlockHardness.sand / 20.0F);
//        c(BlockHardness.sand / 20.0F);
        setLightValue(1.0F);
        setMinHarvestLevel(0);
    }

    //    public void a(World par1World, int par2, int par3, int par4, Entity par5Entity) {
    @Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        boolean isM = (par5Entity instanceof net.minecraft.EntityZombie || par5Entity instanceof net.minecraft.EntitySpider || par5Entity instanceof net.minecraft.EntityCreeper || par5Entity instanceof net.minecraft.EntitySkeleton);
        if (par1World.isWorldServer() && isM)
            if (Constant.GARandom.nextInt(300) == 1) {
                par1World.spawnEntityInWorld(new EntityLightningBolt(par1World, par2, par3, par4));
                if (par1World.isBlueMoon24HourPeriod())
                    par5Entity.dropItem(Items.Powder_Lei, 1);
            }
    }

    public String getMetadataNotes() {
        return "All bits used to track growth";
    }

    public boolean isValidMetadata(int metadata) {
        return (metadata >= 0 && metadata < 16);
    }

    public boolean updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (super.updateTick(par1World, par2, par3, par4, par5Random))
            return true;
        if (par5Random.nextFloat() > (par1World.getBiomeGenForCoords(par2, par4)).temperature - 0.2F)
            return false;
        if (par5Random.nextFloat() < 0.1F)
            return false;
        if (par1World.getBlockLightValue(par2, par3, par4) < 15)
            return false;
        if (canOccurAt(par1World, par2, par3 + 1, par4, 0)) {
            int metadata = par1World.getBlockMetadata(par2, par3, par4);
            if (++metadata > 8) {
                par1World.setBlock(par2, par3 + 1, par4, this.blockID);
                metadata = 0;
            }
            par1World.setBlockMetadataWithNotify(par2, par3, par4, metadata, 4);
            return true;
        }
        return false;
    }

    public boolean canOccurAt(World world, int x, int y, int z, int metadata) {
        return (world.canBlockSeeTheSky(x, y + 1, z) && super.canOccurAt(world, x, y, z, metadata));
    }

    public boolean isLegalAt(World world, int x, int y, int z, int metadata) {
        if (!super.isLegalAt(world, x, y, z, metadata))
            return false;
        if (world.getBlock(x, y - 1, z) == this) {
            y--;
            int height = 1;
            while (world.getBlock(x, --y, z) == this)
                height++;
            return (height < 16);
        }
        y--;
        return true;
    }

    public boolean isLegalOn(int metadata, Block block_below, int block_below_metadata) {
        if (block_below == this)
            return true;
        return block_below == grass || block_below == dirt || block_below == sand;
    }

    public boolean canBePlacedOnBlock(int metadata, Block block_below, int block_below_metadata, double block_below_bounds_max_y) {
        return (block_below == this || super.canBePlacedOnBlock(metadata, block_below, block_below_metadata, block_below_bounds_max_y));
    }

    public boolean canBeCarried() {
        return false;
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (info.wasNotLegal() || info.wasExploded())
            info.world.destroyBlock(info, false, true);
        if (info.wasExploded() || info.wasCrushed())
            return 0;
        return dropBlockAsEntityItem(info, Items.Bamboo);
    }

    public int d() {
        return 1;
    }

    public int d(World par1World, int par2, int par3, int par4) {
        return Items.Bamboo.itemID;
    }

    public boolean isSolid(boolean[] is_solid, int metadata) {
        return false;
    }

    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
        return false;
    }

    public boolean blocksFluids(boolean[] blocks_fluids, int metadata) {
        return true;
    }
}