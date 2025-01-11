package com.github.Debris.GAHigher.block.entity;

import com.github.Debris.GAHigher.block.BlockItemDuper;
import net.minecraft.*;

import java.util.Arrays;

public class TileEntityItemDuper extends TileEntity implements IInventory {

    private ItemStack[] itemStacks = new ItemStack[27];

    private Item toDupe = Item.seeds;

    public TileEntityItemDuper() {
    }

    public TileEntityItemDuper(Block block, Item toDupe) {
        this.setBlock(block);
        this.toDupe = toDupe;
    }

    @Override
    public int getSizeInventory() {
        return this.itemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.itemStacks[i];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        if (this.itemStacks[par1] != null) {
            if (this.itemStacks[par1].stackSize <= par2) {
                ItemStack var3 = this.itemStacks[par1];
                this.itemStacks[par1] = null;
                return var3;
            }
            ItemStack var3 = this.itemStacks[par1].splitStack(par2);
            if (this.itemStacks[par1].stackSize == 0) {
                this.itemStacks[par1] = null;
            }
            return var3;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {
        if (this.itemStacks[par1] != null) {
            ItemStack var2 = this.itemStacks[par1];
            this.itemStacks[par1] = null;
            return var2;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        this.itemStacks[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && entityPlayer.getDistanceSq((double) this.xCoord + 0.5, (double) this.yCoord + 0.5, (double) this.zCoord + 0.5) <= 64.0;
    }

    @Override
    public void openChest() {
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType().blockID);
    }

    public void closeChest() {
        if (this.getBlockType() != null && this.getBlockType() instanceof BlockItemDuper) {
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType().blockID);
        }
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return itemStack.getItem() == this.toDupe;
    }

    @Override
    public void destroyInventory() {
        Arrays.fill(this.itemStacks, null);
    }


    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.itemStacks = new ItemStack[this.getSizeInventory()];
        for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound) var2.tagAt(var3);
            int var5 = var4.getByte("Slot") & 0xFF;
            if (var5 < 0 || var5 >= this.itemStacks.length) continue;
            this.itemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList var2 = new NBTTagList();
        for (int var3 = 0; var3 < this.itemStacks.length; ++var3) {
            if (this.itemStacks[var3] == null) continue;
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setByte("Slot", (byte) var3);
            this.itemStacks[var3].writeToNBT(var4);
            var2.appendTag(var4);
        }
        par1NBTTagCompound.setTag("Items", var2);
    }

    @Override
    public String getUnlocalizedInvName() {
        return "container.itemDuper";
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack stackInSlot = this.getStackInSlot(i);
            if (stackInSlot == null) {
                this.setInventorySlotContents(i, new ItemStack(this.toDupe));
                return;
            }
            if (stackInSlot.getItem() == this.toDupe && stackInSlot.stackSize < stackInSlot.getMaxStackSize()) {
                this.setInventorySlotContents(i, new ItemStack(this.toDupe, stackInSlot.stackSize + 1));
                return;
            }
        }
    }

}
