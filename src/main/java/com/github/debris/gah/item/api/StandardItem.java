package com.github.debris.gah.item.api;

import net.minecraft.Item;
import net.minecraft.Material;

public class StandardItem extends Item {
    public StandardItem(int id, String texture) {
        super(id, texture);
    }

    public StandardItem(int par1, String texture, int num_subtypes) {
        super(par1, texture, num_subtypes);
    }

    public StandardItem(int id, Material material, String texture) {
        super(id, material, texture);
    }

    public StandardItem(int id, Material[] material_array, String texture) {
        super(id, material_array, texture);
    }
}
