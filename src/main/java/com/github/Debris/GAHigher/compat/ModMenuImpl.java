package com.github.Debris.GAHigher.compat;

import com.github.Debris.GAHigher.config.GAConfigManyLib;
import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class ModMenuImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return s -> GAConfigManyLib.getInstance().getConfigScreen(s);
    }
}
