package com.github.Debris.GAHigher.api;

import com.github.Debris.GAHigher.util.PriceItem;
import net.minecraft.ItemStack;

public interface GAItemStack {
    PriceItem ga$getPrice();

    void ga$setPrice(double soldPrice, double buyPrice);

    static PriceItem getPrice(ItemStack itemStack) {
        return ((GAItemStack) itemStack).ga$getPrice();
    }
}
