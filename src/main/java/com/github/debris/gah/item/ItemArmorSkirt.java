package com.github.debris.gah.item;

import net.minecraft.ItemLeggings;
import net.minecraft.Material;

public class ItemArmorSkirt extends ItemLeggings {
    private final String texture;

    public ItemArmorSkirt(int id, Material material, String texture) {
        super(id, material, false);// 2 is leggings slot
        this.texture = texture;
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
