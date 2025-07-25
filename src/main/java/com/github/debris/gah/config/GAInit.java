package com.github.debris.gah.config;

import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;
import net.minecraft.Minecraft;

public class GAInit implements IInitializationHandler {
    @Override
    public void registerModHandlers() {
        ConfigManager.getInstance().registerConfig(GAConfigManyLib.getInstance());
        CallBacks.init(Minecraft.getMinecraft());
    }
}
