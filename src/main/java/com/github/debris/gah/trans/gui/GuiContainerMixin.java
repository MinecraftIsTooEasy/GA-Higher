package com.github.debris.gah.trans.gui;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.GuiContainer;
import net.minecraft.GuiScreen;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GuiContainer.class)
public abstract class GuiContainerMixin extends GuiScreen {
    @ModifyExpressionValue(method = "mouseClicked", at = @At(value = "FIELD", target = "Lnet/minecraft/GuiContainer;xSize:I", opcode = Opcodes.GETFIELD))
    private int redirect(int original) {
        return original + 24;
    }// to make jewelry clickable

    @ModifyExpressionValue(method = "mouseMovedOrUp", at = @At(value = "FIELD", target = "Lnet/minecraft/GuiContainer;xSize:I", opcode = Opcodes.GETFIELD))
    private int redirect1(int original) {
        return original + 24;
    }

}
