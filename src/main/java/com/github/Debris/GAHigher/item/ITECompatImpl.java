package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.api.GAItem;
import com.github.Debris.GAHigher.config.Configs;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Material;

import java.util.List;

import static com.github.Debris.GAHigher.item.Items.*;
import static net.xiaoyu233.mitemod.miteite.block.Blocks.blockVibranium;
import static net.xiaoyu233.mitemod.miteite.item.Items.*;
import static net.xiaoyu233.mitemod.miteite.item.Materials.vibranium;
import static net.xiaoyu233.mitemod.miteite.util.Configs.Item.ENCHANTED_GOLDEN_APPLE_EAT_TIME;

public class ITECompatImpl {
    public static void registerCompatRecipes(CraftingRecipeRegisterEvent register) {
        registerSkirtRecipe(register, vibranium_skirt, VIBRANIUM_INGOT);
        if (Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(E_PICKAXE), true, D_PICKAXE, blockVibranium, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
        }
        register.registerShapelessRecipe(new ItemStack(final_key, 1), false, cracked_key, VIBRANIUM_NUGGET, VIBRANIUM_NUGGET, VIBRANIUM_NUGGET).difficulty(1.0F);

    }

    public static Material getVibraniumMaterial() {
        return vibranium;
    }

    public static int getZombieSoupEatingDuration() {
        return ENCHANTED_GOLDEN_APPLE_EAT_TIME.get();
    }

    public static void addIngotToList(List<Item> ingots) {
        ingots.add(VIBRANIUM_INGOT);
    }

    public static void addNuggetToList(List<Item> ingots) {
        ingots.add(VIBRANIUM_NUGGET);
    }

    public static Item getIconForKillZombieBoss() {
        return VIBRANIUM_WAR_HAMMER;
    }

    public static void registerPrices() {
        ((GAItem) VIBRANIUM_INGOT).ga$setSoldPriceForAllSubs(250.0D);
        ((GAItem) VIBRANIUM_NUGGET).ga$setSoldPriceForAllSubs(25.0D);
    }
}
