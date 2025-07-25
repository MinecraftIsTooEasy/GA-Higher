package com.github.debris.gah.item;

import net.minecraft.ItemArmor;
import net.minecraft.Material;

public class ItemGaArmor extends ItemArmor {
    public ItemGaArmor(int item_id, Material material, boolean is_chain_mail) {
        super(item_id, material, 1, is_chain_mail);
    }

    public String getArmorType() {
        return "helmet";
    }

    public int getNumComponentsForDurability() {
        return 5;
    }
}
