package com.github.Debris.GAHigher.item;

import net.minecraft.CreativeTabs;
import net.minecraft.ItemLeggings;
import net.minecraft.Material;

public class ItemArmorSkirt extends ItemLeggings {
    private final String texture;

    public ItemArmorSkirt(int id, Material material, String texture) {
        super(id, material, false);// 2 is leggings slot
        this.texture = texture;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public String getArmorType() {
        return "skirt";
    }

    @Override
    public int getNumComponentsForDurability() {
        return 7;
    }


}
