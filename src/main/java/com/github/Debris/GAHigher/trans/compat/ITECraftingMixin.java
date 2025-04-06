package com.github.Debris.GAHigher.trans.compat;

import com.github.Debris.GAHigher.config.Configs;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.ItemStack;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.github.Debris.GAHigher.item.Items.ringKillerAdamantium;
import static com.github.Debris.GAHigher.item.Items.ringKillerVibranium;
import static net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit.VIBRANIUM_SWORD;

@Mixin(MITEITEItemRegistryInit.class)
public class ITECraftingMixin {
    @Inject(method = "registerRecipes", at = @At("RETURN"))
    private static void onReturn(CraftingRecipeRegisterEvent register, CallbackInfo ci) {
        if (Configs.wenscConfig.isRecipeRingKiller.ConfigValue) {
            register.registerShapedRecipe(new ItemStack(ringKillerVibranium, 1), true, "###", "#*#", "###", ('#'), VIBRANIUM_SWORD, ('*'), ringKillerAdamantium);
        }
    }
}
