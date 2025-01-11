package com.github.Debris.GAHigher.item.enchantment;

import net.minecraft.Enchantment;
import net.minecraft.EnumRarity;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class Enchantments {

    public static final Enchantment STABLE = new EnchantmentStable(getNextEnchantmentID(), EnumRarity.rare, 15);

    public static final Enchantment CHAIN = new EnchantmentChain(getNextEnchantmentID(), EnumRarity.uncommon, 10);

    private static int getNextEnchantmentID() {
        return IdUtil.getNextEnchantmentID();
    }

    public static void init() {// for calling the static part
    }
}
