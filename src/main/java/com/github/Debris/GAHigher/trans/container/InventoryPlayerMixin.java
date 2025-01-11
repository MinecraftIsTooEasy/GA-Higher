package com.github.Debris.GAHigher.trans.container;

import com.github.Debris.GAHigher.item.Items;
import net.minecraft.EntityPlayer;
import net.minecraft.InventoryPlayer;
import net.minecraft.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({InventoryPlayer.class})
public abstract class InventoryPlayerMixin {
    @Shadow
    public EntityPlayer player;

    @Shadow
    public abstract void setInventorySlotContents(int par1, ItemStack par2ItemStack);

    @Inject(method = "setInventorySlotContents", at = @At("HEAD"), cancellable = true)
    private void clearIllegal(int par1, ItemStack par2ItemStack, CallbackInfo ci) {
        if (par2ItemStack != null && par2ItemStack.getItem() == Items.lavaInPipes) {
            this.setInventorySlotContents(par1, null);
            ci.cancel();
        }
    }
}
