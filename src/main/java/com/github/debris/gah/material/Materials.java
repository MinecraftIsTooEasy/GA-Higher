package com.github.debris.gah.material;

import com.github.debris.gah.compat.ModCompat;
import com.github.debris.gah.unsafe.ITEAccessor;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Material;

public abstract class Materials extends Material {
    public static final EnumEquipmentMaterial MITEGA = EnumEquipmentMaterials.MITEGA.get();
    public static final EnumEquipmentMaterial GOTCHA = EnumEquipmentMaterials.GOTCHA.get();

    public static final Material invincible = (new Material("misc")).setHarmedByLava(false).setHarmedByAcid(false).setHarmedByLava(false).setMetal(false).setFlammability(false, false, false);

    public static final Material mitega = (new MaterialGA(MITEGA)).setMetal(false).setHarmedByLava(false).setMinHarvestLevel(7);
    public static final Material gotchga = (new MaterialGotcha(GOTCHA)).setMetal(false).setHarmedByLava(false).setMinHarvestLevel(0);

    public Materials(String name) {
        super(name);
    }

    public static Material getBestMaterial() {
        if (ModCompat.HAS_ITE) {
            return ITEAccessor.getVibraniumMaterial();
        }
        return adamantium;
    }
}
