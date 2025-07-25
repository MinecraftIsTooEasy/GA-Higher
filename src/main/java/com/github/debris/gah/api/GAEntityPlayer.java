package com.github.debris.gah.api;

import com.github.debris.gah.entity.player.HomeScrollManager;
import com.github.debris.gah.entity.player.StoneCountManager;
import com.github.debris.gah.screen.inventory.InventoryEnderChestTrans;
import net.minecraft.EntityPlayer;

public interface GAEntityPlayer {
    InventoryEnderChestTrans ga$getInventoryEnderChestTrans();

    StoneCountManager ga$getStoneCountManager();

    HomeScrollManager ga$getHomeScrollManager();

    static StoneCountManager getStoneCountManager(EntityPlayer player) {
        return ((GAEntityPlayer) player).ga$getStoneCountManager();
    }

    static HomeScrollManager getHomeScrollManager(EntityPlayer player) {
        return ((GAEntityPlayer) player).ga$getHomeScrollManager();
    }
}
