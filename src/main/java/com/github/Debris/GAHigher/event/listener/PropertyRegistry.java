package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.GAStart;
import com.github.Debris.GAHigher.api.GAPlugin;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.registry.GARegistryImpl;
import com.github.Debris.GAHigher.registry.GAVanillaPlugin;
import net.xiaoyu233.fml.FishModLoader;

import java.io.File;

public class PropertyRegistry implements Runnable {
    @Override
    public void run() {
        GARegistryImpl gaRegistry = new GARegistryImpl();
        new GAVanillaPlugin().register(gaRegistry);
        FishModLoader.getEntrypointContainers("ga-higher", GAPlugin.class)
                .forEach(container -> container.getEntrypoint().register(gaRegistry));

        postRegisterPrice();
    }

    public static void postRegisterPrice() {
        String shopConfigFilePath = "config" + File.separator + GAStart.MOD_ID + "-shop.cfg";
        Configs.loadFromFile(shopConfigFilePath, Configs::readShopConfigFromFile, Configs::generateShopConfigFile);
    }
}
