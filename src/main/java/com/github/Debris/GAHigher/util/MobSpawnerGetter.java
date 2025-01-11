package com.github.Debris.GAHigher.util;

import net.xiaoyu233.fml.util.Utils;

public class MobSpawnerGetter implements Utils.DangerConsumer<Class<?>> {
    public Class<?> dangerGet() throws Throwable {
        return Class.forName("net.minecraft.TileEntityMobSpawnerLogic");
    }
}
