package com.github.Debris.GAHigher.api;

import com.github.Debris.GAHigher.entity.player.BossManager;
import com.github.Debris.GAHigher.entity.player.MoneyManager;
import com.github.Debris.GAHigher.screen.inventory.InventoryEnderChestTrans;
import com.github.Debris.GAHigher.screen.inventory.InventoryJewelry;

public interface GAEntityPlayer {
    InventoryEnderChestTrans getInventoryEnderChestTrans();

    void addStoneCount(long stoneCount);

    InventoryJewelry getInventoryJewelry();

    MoneyManager getMoneyManager();

    BossManager getBossManager();
}
