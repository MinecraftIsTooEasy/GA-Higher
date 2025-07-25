package com.github.debris.gah.material;

import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Material;

public class MaterialGotcha extends Material {
    public MaterialGotcha(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
    }

    @Override
    public float getDamageVsEntity() {
        return 1.0F;
    }
}
