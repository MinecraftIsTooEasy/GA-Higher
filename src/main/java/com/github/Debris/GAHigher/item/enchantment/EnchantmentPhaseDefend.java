package com.github.Debris.GAHigher.item.enchantment;

import net.minecraft.CreativeTabs;
import net.minecraft.Enchantment;
import net.minecraft.EnumRarity;
import net.minecraft.Item;

public class EnchantmentPhaseDefend extends Enchantment {
    protected EnchantmentPhaseDefend(int id, EnumRarity rarity, int difficulty) {
        super(id, rarity, difficulty);
    }

    public int getNumLevels() {
        return 1;
    }

    public String getNameSuffix() {
        return "phase_defend";
    }

    public boolean canEnchantItem(Item item) {
        return (item instanceof net.minecraft.ItemArmor || item instanceof net.minecraft.ItemSword);
    }

    public boolean isOnCreativeTab(CreativeTabs var1) {
        return (var1 == CreativeTabs.tabCombat);
    }
}
