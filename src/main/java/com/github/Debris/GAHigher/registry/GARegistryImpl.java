package com.github.Debris.GAHigher.registry;

import com.github.Debris.GAHigher.api.GAItem;
import com.github.Debris.GAHigher.api.GARegistry;
import net.minecraft.Item;

public class GARegistryImpl implements GARegistry {
    @Override
    public void registerSoldPrice(Item item, double soldPrice) {
        ((GAItem) item).setSoldPrice(soldPrice);
    }

    @Override
    public void registerBuyPrice(Item item, double buyPrice) {
        ((GAItem) item).setBuyPrice(buyPrice);
    }

    @Override
    public void registerSoldPrice(Item item, int sub, double soldPrice) {
        ((GAItem) item).registerSoldPrice(sub, soldPrice);
    }

    @Override
    public void registerBuyPrice(Item item, int sub, double buyPrice) {
        ((GAItem) item).registerBuyPrice(sub, buyPrice);
    }
}
