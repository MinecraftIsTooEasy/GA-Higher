package com.github.Debris.GAHigher.trans.item.enchantment;

import com.github.Debris.GAHigher.item.enchantment.Enchantments;
import net.minecraft.Enchantment;
import net.minecraft.EnchantmentUntouching;
import net.minecraft.EnumRarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EnchantmentUntouching.class})
public abstract class EnchantmentSilkTouchTrans extends Enchantment {
    protected EnchantmentSilkTouchTrans(int id, EnumRarity rarity, int difficulty) {
        super(id, rarity, difficulty);
    }

    @Inject(method = "canApplyTogether", at = @At("HEAD"), cancellable = true)
    private void addChain(Enchantment par1Enchantment, CallbackInfoReturnable<Boolean> cir) {
        if (par1Enchantment == Enchantments.CHAIN) {
            cir.setReturnValue(false);
        }
    }
}
