package com.github.Debris.GAHigher.item.material;

import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.MapColor;
import net.minecraft.Material;

public class Materials extends Material {

    public static final Materials invincible = (Materials) (new Materials("misc")).setHarmedByLava(false).setHarmedByAcid(false).setHarmedByLava(false).setMetal(false).setFlammability(false, false, false);

    public Materials(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
    }

    public Materials(String name, MapColor map_color) {
        super(name, map_color);
    }

    public Materials(String name) {
        super(name);
    }
}
