package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.config.Configs;
import net.minecraft.ResourceLocation;

import java.util.Objects;
import java.util.Random;

public class Constant {
    public static final ResourceLocation JewelryInventory = new ResourceLocation("textures/gui/container/inventory_jewelry.png");

    public static Random GARandom = new Random();

    public static float getBossMobModifier(String method, int day) {
        if (Objects.equals(method, "Health"))
            return 1.0F + Math.min(day, Configs.wenscConfig.enhanceLimit.ConfigValue) / 80.0F * (Configs.wenscConfig.boostEnhance.ConfigValue ? 2.0F : 1.0F);
        if (Objects.equals(method, "Damage"))
            return 1.0F + Math.min(day, Configs.wenscConfig.enhanceLimit.ConfigValue) / 160.0F * (Configs.wenscConfig.boostEnhance.ConfigValue ? 2.0F : 1.0F);
        if (Objects.equals(method, "Speed"))
            return 1.0F + Math.min(day, Configs.wenscConfig.enhanceLimit.ConfigValue) / 2048.0F * (Configs.wenscConfig.boostEnhance.ConfigValue ? 2.0F : 1.0F);
        return 1.0F;
    }
}
