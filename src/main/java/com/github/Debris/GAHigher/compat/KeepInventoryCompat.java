package com.github.Debris.GAHigher.compat;

import net.minecraft.EntityPlayer;
import net.xiaoyu233.fml.FishModLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeepInventoryCompat {
    public static boolean canKeepInventory(EntityPlayer player) {
        if (player.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) return true;
        if (canKeepInventoryMod(player)) return true;
        return false;
    }

    private static boolean canKeepInventoryMod(EntityPlayer player) {
        if (!FishModLoader.hasMod("keep-inventory-mod")) return false;
        try {
            Class<?> customEntityPlayer = Class.forName("ink.huix.keepInventoryMod.misc.CustomEntityPlayer");
            Method canKeepInventory = customEntityPlayer.getMethod("canKeepInventory");
            return (Boolean) canKeepInventory.invoke(player, new Object[0]);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            return false;
        }
    }
}
