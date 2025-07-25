package com.github.debris.gah.material;

import com.chocohead.mm.api.ClassTinkerers;
import com.github.debris.gah.GAStart;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.EnumQuality;
import net.xiaoyu233.fml.util.EnumExtends;

public enum EnumEquipmentMaterials {
    MITEGA(5120.0F, 120, EnumQuality.fine, "mitega"),
    GOTCHA(5120.0F, 120, EnumQuality.fine, "gotcha"),
    ;

    public final String EnumName;
    public final float durability;
    public final int enchantability;
    public final EnumQuality max_quality;
    public final String name;

    EnumEquipmentMaterials(float durability, int enchantability, EnumQuality max_quality, String material_name) {
        this.EnumName = GAStart.NAMESPACE + "_" + this.name();
        this.durability = durability;
        this.enchantability = enchantability;
        this.max_quality = max_quality;
        this.name = material_name;
    }


    public static void register() {
        for (EnumEquipmentMaterials arg : values()) {
            EnumExtends.EQUIPMENT_MATERIAL.addEnum(arg.EnumName, () -> new Object[]{arg.durability, arg.enchantability, arg.max_quality, arg.name});
        }
    }

    public EnumEquipmentMaterial get() {
        return ClassTinkerers.getEnum(EnumEquipmentMaterial.class, this.EnumName);
    }
}
