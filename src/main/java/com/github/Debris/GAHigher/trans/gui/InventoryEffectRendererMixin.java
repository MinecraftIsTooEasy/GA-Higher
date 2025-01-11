package com.github.Debris.GAHigher.trans.gui;

import com.github.Debris.GAHigher.compat.EmiSettingsCompat;
import com.github.Debris.GAHigher.config.GAConfigManyLib;
import net.minecraft.Container;
import net.minecraft.GuiContainer;
import net.minecraft.InventoryEffectRenderer;
import net.xiaoyu233.fml.FishModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryEffectRenderer.class)
public abstract class InventoryEffectRendererMixin extends GuiContainer {
    @Shadow
    private boolean field_74222_o;

    public InventoryEffectRendererMixin(Container par1Container) {
        super(par1Container);
    }

    @Inject(method = "initGui", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        if (!FishModLoader.hasMod("emi")) {
            return;
        }
        if (this.mc.gameSettings.guiScale != 0) return;
        if (!GAConfigManyLib.OverrideEmi.getBooleanValue()) return;
        EmiSettingsCompat.cacheColumn();
        if (this.field_74222_o) {
            EmiSettingsCompat.trySetColumn(GAConfigManyLib.OverrideEmiColumnWiden.getIntegerValue());
        } else {
            EmiSettingsCompat.trySetColumn(GAConfigManyLib.OverrideEmiColumn.getIntegerValue());
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (!FishModLoader.hasMod("emi")) {
            return;
        }
        if (this.mc.gameSettings.guiScale != 0) return;
        if (!GAConfigManyLib.OverrideEmi.getBooleanValue()) return;
        EmiSettingsCompat.restore();
    }
}
