package com.github.debris.gah.trans.gui;

import com.github.debris.gah.api.GAGuiIngame;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiIngame.class})
public class GuiIngameTrans extends Gui implements GAGuiIngame {
    @Shadow
    @Final
    private Minecraft mc;

    private String overlayMsg;

    private int overlayMsgColor;

    private int overlayMsgDisplayTime;

//    @Inject(method = "func_110327_a", at = @At("HEAD"))// what mod break this inject

    @Inject(method = "renderGameOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;inDevMode()Z", shift = At.Shift.BEFORE))
    private void injectRenderOverlayMessage(CallbackInfo c) {
        FontRenderer var8 = this.mc.fontRenderer;
        if (this.overlayMsgDisplayTime > 0) {
            ScaledResolution window = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
            int var25 = window.getScaledWidth();
            int var26 = window.getScaledHeight();
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            var8.drawString(this.overlayMsg, (var25 / 2) - var8.getStringWidth(this.overlayMsg) / 2, (var26 - 68) - 4, this.overlayMsgColor);
            GL11.glDisable(3042);
        }
    }

    @ModifyExpressionValue(method = {"func_110327_a(II)V"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/AttributeInstance;getAttributeValue()D"))
    private double redirectHealthLimit(double original) {
        return this.mc.thePlayer.getHealthLimit();
    }

    public void setOverlayMsg(String overlayMsg, int displayTime, int color) {
        this.overlayMsg = overlayMsg;
        this.overlayMsgColor = color;
        this.overlayMsgDisplayTime = displayTime;
    }

    @Inject(method = "updateTick", at = @At("TAIL"))
    private void updateCounter(CallbackInfo ci) {
        if (this.overlayMsgDisplayTime > 0) {
            this.overlayMsgDisplayTime -= 4;
        }
    }
}
