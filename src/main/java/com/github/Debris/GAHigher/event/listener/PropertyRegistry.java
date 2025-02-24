package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.api.GAPlugin;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.registry.GARegistryImpl;
import com.github.Debris.GAHigher.registry.GAVanillaPlugin;
import net.xiaoyu233.fml.FishModLoader;

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
        Configs.loadOrCreateFile(Configs.shopConfigFilePath, Configs::readShopConfigFromFile, Configs::generateShopConfigFile);
    }
}
