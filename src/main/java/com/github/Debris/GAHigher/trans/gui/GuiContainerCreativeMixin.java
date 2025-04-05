package com.github.Debris.GAHigher.trans.gui;

import com.github.Debris.GAHigher.util.Constant;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiContainerCreative.class, priority = 99999)
public abstract class GuiContainerCreativeMixin extends InventoryEffectRenderer {
    public GuiContainerCreativeMixin(Container par1Container) {
        super(par1Container);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void modifyXSize(EntityPlayer par1EntityPlayer, CallbackInfo ci) {
        if (!(xSize > xSize + 32))
            xSize += 32;
    }

    @Inject(method = "drawGuiContainerBackgroundLayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/GuiInventory;func_110423_a(IIIFFLnet/minecraft/EntityLivingBase;)V"))
    private void drawJewelrySlots(float par1, int par2, int par3, CallbackInfo ci) {
        mc.mcProfiler.startSection("ga");
        int startX, startY, u, v;
        this.mc.getTextureManager().bindTexture(Constant.JewelryInventory);
        startX = 195 + this.guiLeft;
        startY = this.guiTop;
        u = 32;
        v = 0;
        this.drawTexturedModalRect(startX, startY, u, v, 32, 166);// draw the shop
        mc.mcProfiler.endSection();
    }

    @WrapOperation(method = "renderCreativeTab", at = @At(value = "FIELD", target = "Lnet/minecraft/GuiContainerCreative;xSize:I"))
    private int modifySearchTabPos(GuiContainerCreative instance, Operation<Integer> original) {
        return original.call(instance) - 32;
    }

    @WrapOperation(method = "func_74232_a", at = @At(value = "FIELD", target = "Lnet/minecraft/GuiContainerCreative;xSize:I"))
    private int modifySearchTabPos_1(GuiContainerCreative instance, Operation<Integer> original) {
        return original.call(instance) - 32;
    }

    @WrapOperation(method = "renderCreativeInventoryHoveringText", at = @At(value = "FIELD", target = "Lnet/minecraft/GuiContainerCreative;xSize:I"))
    private int modifySearchTabPos_2(GuiContainerCreative instance, Operation<Integer> original) {
        return original.call(instance) - 32;
    }

    @Redirect(method = "setCurrentCreativeTab", at = @At(value = "FIELD", target = "Lnet/minecraft/SlotCreativeInventory;xDisplayPosition:I", ordinal = 2))
    private void jewelryXDisplayPosition(SlotCreativeInventory instance, int value, @Local(name = "var8") int var8, @Local(name = "var5") int var5) {
        if (var5 == 52) instance.xDisplayPosition = 2000;
        else instance.xDisplayPosition = var5 < 45 ? 9 + var8 * 18 : 203;
    }
    @Redirect(method = "setCurrentCreativeTab", at = @At(value = "FIELD", target = "Lnet/minecraft/SlotCreativeInventory;yDisplayPosition:I", ordinal = 2))
    private void jewelryYDisplayPosition(SlotCreativeInventory instance, int value, @Local(name = "var9") int var9, @Local(name = "var8") int var8, @Local(name = "var5") int var5) {
        instance.yDisplayPosition = var5 < 45 ? (var5 >= 36 ? 112 : 54 + var9 * 18) : 6 + var8 * 18;
    }
}
