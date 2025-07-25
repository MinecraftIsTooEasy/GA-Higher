package com.github.debris.gah.config;

import net.minecraft.Minecraft;

public class CallBacks {
    public static void init(Minecraft client) {
        GAConfigManyLib.OpenConfig.getKeybind().setCallback((keyAction, iKeybind) -> {
            client.displayGuiScreen(GAConfigManyLib.getInstance().getConfigScreen(null));
            return true;
        });
    }
}
