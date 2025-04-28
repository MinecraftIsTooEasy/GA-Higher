package com.github.Debris.GAHigher.api;

import com.github.Debris.GAHigher.entity.player.HomeScrollManager;
import com.github.Debris.GAHigher.entity.player.StoneCountManager;
import com.github.Debris.GAHigher.screen.inventory.InventoryEnderChestTrans;
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
