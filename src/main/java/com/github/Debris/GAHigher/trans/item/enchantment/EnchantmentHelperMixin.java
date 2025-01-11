package com.github.Debris.GAHigher.trans.item.enchantment;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.item.Items;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.EnchantmentHelper;
import net.minecraft.EntityLivingBase;
import net.minecraft.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({EnchantmentHelper.class})
public class EnchantmentHelperMixin {
    @ModifyReturnValue(method = "getFortuneModifier", at = @At("RETURN"))
    private static int moreFortune(int original, @Local(argsOnly = true) EntityLivingBase par0EntityLivingBase) {
        if (par0EntityLivingBase instanceof EntityPlayer player && ((GAEntityPlayer) player).getInventoryJewelry().hasJewelry(Items.lucky_clover)) {
            original += 1;
        }
        return original;
    }

    @ModifyReturnValue(method = "getLootingModifier", at = @At("RETURN"))
    private static int moreLoot(int original, @Local(argsOnly = true) EntityLivingBase par0EntityLivingBase) {
        if (par0EntityLivingBase instanceof EntityPlayer player && ((GAEntityPlayer) player).getInventoryJewelry().hasJewelry(Items.lucky_clover)) {
            original += 1;
        }
        return original;
    }

    @ModifyReturnValue(method = "getButcheringModifier", at = @At("RETURN"))
    private static int moreButcher(int original, @Local(argsOnly = true) EntityLivingBase par0EntityLivingBase) {
        if (par0EntityLivingBase instanceof EntityPlayer player && ((GAEntityPlayer) player).getInventoryJewelry().hasJewelry(Items.lucky_clover)) {
            original += 1;
        }
        return original;
    }
}