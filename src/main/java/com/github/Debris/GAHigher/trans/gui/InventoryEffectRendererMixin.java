package com.github.Debris.GAHigher.trans.gui;

import com.github.Debris.GAHigher.api.Condition;
import com.github.Debris.GAHigher.api.ConditionalMixin;
import com.github.Debris.GAHigher.compat.EmiSettingsCompat;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.config.GAConfigManyLib;
import net.minecraft.Container;
import net.minecraft.GuiContainer;
import net.minecraft.InventoryEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@ConditionalMixin(require = @Condition(value = ModCompat.EMI))
@Mixin(InventoryEffectRenderer.class)
public abstract class InventoryEffectRendererMixin extends GuiContainer {
    @Shadow
    private boolean field_74222_o;

    public InventoryEffectRendererMixin(Container par1Container) {
        super(par1Container);
    }

    @Inject(method = "initGui", at = @At("HEAD"))
    private void onInit(CallbackInfo ci) {
        if (this.shouldSkip()) return;
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
        if (this.shouldSkip()) return;
        EmiSettingsCompat.restore();
    }

    @Unique
    private boolean shouldSkip() {
        if (this.mc.gameSettings.guiScale != 0) return true;
        if (!GAConfigManyLib.OverrideEmi.getBooleanValue()) return true;
        return false;
    }
}
