package com.github.Debris.GAHigher.trans.gui;

import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.Container;
import net.minecraft.GuiInventory;
import net.minecraft.InventoryEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiInventory.class})
public abstract class GuiPlayerInventoryTrans extends InventoryEffectRenderer {
    public GuiPlayerInventoryTrans(Container par1Container) {
        super(par1Container);
    }

//    @Inject(method = "<init>", at = @At("RETURN"))
//    private void sync(EntityPlayer par1EntityPlayer, CallbackInfo ci) {
//        GANetwork.sendToServer(new C2SSyncItems());
//    }

    @Inject(method = "drawGuiContainerBackgroundLayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/GuiInventory;func_110423_a(IIIFFLnet/minecraft/EntityLivingBase;)V"))
    private void drawSlots(float par1, int par2, int par3, CallbackInfo ci) {
        int startX, startY, u, v;
//        this.mc.getTextureManager().bindTexture(field_110408_a);
//        startX = 79 + this.guiLeft;
//        startY = 63 + this.guiTop;
//        u = 79;
//        v = 83;
//        this.drawTexturedModalRect(startX, startY, u, v, 90, 18);// draw a 90x18 rect from the source to the gui

        this.mc.getTextureManager().bindTexture(Constant.ExtremeInventory);
        startX = 176 + this.guiLeft;
        startY = this.guiTop;
        u = 176;
        v = 0;
        this.drawTexturedModalRect(startX, startY, u, v, 32, 166);// draw the shop
    }

    @Inject(method = "drawGuiContainerForegroundLayer", at = @At("RETURN"))
    private void emergencyInfo(int par1, int par2, CallbackInfo ci) {
//        String emergencyWords = (((GAEntityPlayer) (EntityPlayer) this.mc.thePlayer)).getEmergencyManager().getEmergencyInfo();
//        this.fontRenderer.drawString("紧急守备：" + emergencyWords, 87, 63, 4210752);
        this.fontRenderer.drawString("保护：" + String.format("%.2f", this.mc.thePlayer.getTotalProtection(null)), 87, 73, 4210752);
    }
}
