package com.github.Debris.GAHigher.unsafe;

import com.github.Debris.GAHigher.config.Configs;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Material;

import java.util.List;

import static com.github.Debris.GAHigher.item.Items.copperNugget;
import static com.github.Debris.GAHigher.item.Items.silverNugget;
import static com.github.Debris.GAHigher.item.Items.*;
import static net.xiaoyu233.mitemod.miteite.block.MITEITEBlockRegistryInit.blockVibranium;
import static net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit.*;
import static net.xiaoyu233.mitemod.miteite.item.Materials.vibranium;
import static net.xiaoyu233.mitemod.miteite.util.Configs.Item.ENCHANTED_GOLDEN_APPLE_EAT_TIME;

public class ITEAccessor {
    public static void registerCompatRecipes(CraftingRecipeRegisterEvent event) {
        registerSkirtRecipe(event, vibranium_skirt, VIBRANIUM_INGOT);
        if (Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue) {
            event.registerShapelessRecipe(new ItemStack(E_PICKAXE), true, D_PICKAXE, blockVibranium, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
        }
        event.registerShapelessRecipe(new ItemStack(Powder_JIN, 1, 0), true, new Object[]{copperNugget, silverNugget, Item.goldNugget, Item.ironNugget, Item.mithrilNugget, Item.adamantiumNugget, Item.ancientMetalNugget, VIBRANIUM_NUGGET, Gem_Blue});
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
}
