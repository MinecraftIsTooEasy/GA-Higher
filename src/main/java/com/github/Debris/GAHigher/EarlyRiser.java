package com.github.Debris.GAHigher;

import com.github.Debris.GAHigher.material.EnumEquipmentMaterials;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class EarlyRiser implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        EnumEquipmentMaterials.register();
    }
}
