package com.github.Debris.GAHigher.block;

import com.github.Debris.GAHigher.block.entity.TileEntityItemDuper;
import net.minecraft.*;

import java.util.Random;

public class BlockItemDuper extends BlockContainer {

    private final Random rand = new Random();

    public BlockItemDuper(int id) {
        super(id, Material.iron, new BlockConstants());
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityItemDuper(this, Item.seeds);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offset_x, float offset_y, float offset_z) {
        if (player.onServer()) {
            TileEntityItemDuper tileEntityCrate = (TileEntityItemDuper) world.getBlockTileEntity(x, y, z);
            if (tileEntityCrate != null) {
                player.displayGUIChest(x, y, z, tileEntityCrate);
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int block_id, int metadata) {
        TileEntityItemDuper tileEntityCrate = (TileEntityItemDuper) world.getBlockTileEntity(x, y, z);
        if (tileEntityCrate != null) {
            for (int i = 0; i < tileEntityCrate.getSizeInventory(); i++) {
                ItemStack stackInSlot = tileEntityCrate.getStackInSlot(i);
                if (stackInSlot != null) {
                    float dx = this.rand.nextFloat() * 0.8F + 0.1F;
                    float dy = this.rand.nextFloat() * 0.8F + 0.1F;
                    float dz = this.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem var14 = new EntityItem(world, (float) x + dx, (float) y + dy, (float) z + dz, stackInSlot);
                    float var15 = 0.05F;
                    var14.motionX = (float) this.rand.nextGaussian() * var15;
                    var14.motionY = (float) this.rand.nextGaussian() * var15 + 0.2F;
                    var14.motionZ = (float) this.rand.nextGaussian() * var15;
                    world.spawnEntityInWorld(var14);
                }
            }
        }

        super.breakBlock(world, x, y, z, block_id, metadata);
    }

    @Override
    public boolean isFaceFlatAndSolid(int metadata, EnumFace face) {
        return false;
    }// for activating hoppers underneath

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
        return Container.calcRedstoneFromInventory((TileEntityItemDuper) par1World.getBlockTileEntity(par2, par3, par4));
    }

    @Override
    public boolean playerSwingsOnBlockActivated(boolean empty_handed) {
        return empty_handed;
    }
}
