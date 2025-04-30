package com.github.Debris.GAHigher.material;

import huix.glacier.api.extension.material.IArmorMaterial;
import huix.glacier.api.extension.material.IToolMaterial;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Material;

public class MaterialGA extends Material implements IToolMaterial, IArmorMaterial {
    public MaterialGA(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
    }

    @Override
    public float getDamageVsEntity() {
        return 10.0F;
    }

    @Override
    public float getHarvestEfficiency() {
        return 4.0F;
    }

    @Override
    public int getProtection() {
        return 1;
    }
}
