package com.github.Debris.GAHigher.material;

import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Material;

public class MaterialGA extends Material {
    public MaterialGA(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
    }

    @Override
    public float getDamageVsEntity() {
        return 10.0F;
    }
}
