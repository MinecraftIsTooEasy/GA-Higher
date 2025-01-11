package com.github.Debris.GAHigher.api;

import com.github.Debris.GAHigher.util.PriceItem;

public interface GAItemStack {
    PriceItem getPrice();

    void setPrice(double soldPrice, double buyPrice);
}
