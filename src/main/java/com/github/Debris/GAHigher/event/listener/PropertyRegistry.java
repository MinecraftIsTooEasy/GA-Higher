package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.GAStart;
import com.github.Debris.GAHigher.api.GAItem;
import com.github.Debris.GAHigher.api.GAPlugin;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.registry.GARegistryImpl;
import com.github.Debris.GAHigher.registry.GAVanillaPlugin;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.FishModLoader;

import java.io.File;
import java.util.List;

public class PropertyRegistry implements Runnable {
    @Override
    public void run() {

        preRegisterPrice();

        GARegistryImpl gaRegistry = new GARegistryImpl();
        new GAVanillaPlugin().register(gaRegistry);
        FishModLoader.getEntrypointContainers("ga-higher", GAPlugin.class)
                .forEach(container -> container.getEntrypoint().register(gaRegistry));

        postRegisterPrice();

    }

    @SuppressWarnings("unchecked")
    private static void preRegisterPrice() {
        for (Item item : Item.itemsList) {
            if (item != null)
                if (item.getHasSubtypes()) {
                    List<ItemStack> subs = item.getSubItems();
                    for (ItemStack itemStack : subs) {
                        int sub = itemStack.getItemSubtype();
                        ((GAItem) item).registerSoldPrice(sub, 0.0D);
                        ((GAItem) item).registerBuyPrice(sub, 0.0D);
                    }
                } else {
                    ((GAItem) item).registerSoldPrice(0, 0.0D);
                    ((GAItem) item).registerBuyPrice(0, 0.0D);
                }
        }
    }

    public static void postRegisterPrice() {
        String shopConfigFilePath = "config" + File.separator + GAStart.MOD_ID + "-shop.cfg";
        Configs.loadFromFile(shopConfigFilePath, Configs::readShopConfigFromFile, Configs::generateShopConfigFile);
    }
}
