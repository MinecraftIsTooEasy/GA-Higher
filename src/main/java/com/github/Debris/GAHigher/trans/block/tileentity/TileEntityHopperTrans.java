package com.github.Debris.GAHigher.trans.block.tileentity;

import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.item.Items;
import net.minecraft.Block;
import net.minecraft.ItemStack;
import net.minecraft.TileEntity;
import net.minecraft.TileEntityHopper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({TileEntityHopper.class})
public abstract class TileEntityHopperTrans extends TileEntity {
    @Shadow
    public abstract ItemStack getStackInSlot(int paramInt);

    @Inject(method = {"insertItemToInventory()Z"}, at = {@At("RETURN")}, cancellable = true)
    private void insertItemToInventoryInject(CallbackInfoReturnable<Boolean> callback) {
        Block blockAbove = this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
        if (blockAbove != null && blockAbove.blockID == Blocks.lavaStill.blockID) {
            ItemStack item = getStackInSlot(0);
            if (item == null || item.itemID != Items.lavaInPipes.itemID)
                setInventorySlotContents(0, new ItemStack(Items.lavaInPipes.itemID, 1));
        }
        callback.setReturnValue(Boolean.TRUE);
        callback.cancel();
    }

    @Shadow
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
    }
}
