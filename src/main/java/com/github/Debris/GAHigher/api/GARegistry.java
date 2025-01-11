package com.github.Debris.GAHigher.api;

import net.minecraft.Item;

public interface GARegistry {
    void registerSoldPrice(Item item, double soldPrice);

    void registerBuyPrice(Item item, double buyPrice);

    void registerSoldPrice(Item item, int sub, double soldPrice);

    void registerBuyPrice(Item item, int sub, double buyPrice);
}
