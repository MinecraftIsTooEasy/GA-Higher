package com.github.debris.gah.compat;

import com.github.debris.gah.config.GAConfigManyLib;
import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class ModMenuImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return s -> GAConfigManyLib.getInstance().getConfigScreen(s);
    }
}
