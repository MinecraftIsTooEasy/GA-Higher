package com.github.Debris.GAHigher.item.enchantment;

import net.minecraft.*;

public class EnchantmentChain extends Enchantment {
    protected EnchantmentChain(int id, EnumRarity rarity, int difficulty) {
        super(id, rarity, difficulty);
    }

    public int getNumLevels() {
        return 5;
    }

    public boolean canApplyTogether(Enchantment par1Enchantment) {
        return (super.canApplyTogether(par1Enchantment) && par1Enchantment.effectId != silkTouch.effectId);
    }

    public String getNameSuffix() {
        return "chain";
    }

    public boolean canEnchantItem(Item item) {
        if (item instanceof ItemTool) {
            Material material = ((ItemTool) item).getToolMaterial();
            if (material.durability < Material.iron.durability) {
                return false;
            }
        }
        return (item instanceof net.minecraft.ItemPickaxe || item instanceof net.minecraft.ItemWarHammer);
    }

    public boolean isOnCreativeTab(CreativeTabs creative_tab) {
        return (creative_tab == CreativeTabs.tabTools);
    }
}
