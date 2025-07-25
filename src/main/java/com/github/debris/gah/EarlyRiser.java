package com.github.debris.gah;

import com.github.debris.gah.material.EnumEquipmentMaterials;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class EarlyRiser implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        EnumEquipmentMaterials.register();
    }
}
