package com.github.Debris.GAHigher.trans.world;

import com.github.Debris.GAHigher.config.Configs;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.EntityPlayer;
import net.minecraft.FoodStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({FoodStats.class})
public class FoodMetaDataTrans {
    @Shadow
    private EntityPlayer player;

    @ModifyReturnValue(method = "getNutritionLimit", at = @At("RETURN"))
    private int modify(int original) {
        return Configs.wenscConfig.BlnNutrition.ConfigValue ? Math.max(Math.min(6 + this.player.getExperienceLevel() / 5 * 2, 200), 6) : original;
    }
}
