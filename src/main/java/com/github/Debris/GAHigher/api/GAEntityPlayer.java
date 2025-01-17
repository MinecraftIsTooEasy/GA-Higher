package com.github.Debris.GAHigher.api;

import com.github.Debris.GAHigher.entity.player.BossManager;
import com.github.Debris.GAHigher.entity.player.MoneyManager;
import com.github.Debris.GAHigher.screen.inventory.InventoryEnderChestTrans;
import com.github.Debris.GAHigher.screen.inventory.InventoryJewelry;
import net.minecraft.EntityPlayer;

public interface GAEntityPlayer {
    InventoryEnderChestTrans ga$getInventoryEnderChestTrans();

    void ga$addStoneCount(long stoneCount);

    InventoryJewelry ga$getInventoryJewelry();

    MoneyManager ga$getMoneyManager();

    BossManager ga$getBossManager();

    static MoneyManager getMoneyManager(EntityPlayer player) {
        return ((GAEntityPlayer) player).ga$getMoneyManager();
    }

    static InventoryJewelry getInventoryJewelry(EntityPlayer player) {
        return ((GAEntityPlayer) player).ga$getInventoryJewelry();
    }
}
