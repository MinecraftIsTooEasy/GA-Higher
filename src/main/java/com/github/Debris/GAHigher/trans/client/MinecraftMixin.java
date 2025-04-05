package com.github.Debris.GAHigher.trans.client;

import com.github.Debris.GAHigher.trans.container.ContainerPlayerTrans;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.ItemStack;
import net.minecraft.Minecraft;
import net.minecraft.PlayerControllerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    /**
     * the 8 is the slots I added at {@link ContainerPlayerTrans#addJewelrySlots(CallbackInfo)}
     */
    @WrapOperation(method = "clickMiddleMouseButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/PlayerControllerMP;sendSlotPacket(Lnet/minecraft/ItemStack;I)V"))
    private void fixSlotCount(PlayerControllerMP instance, ItemStack par1ItemStack, int slot, Operation<Void> original) {
        slot -= 8;
        original.call(instance, par1ItemStack, slot);
    }
}
