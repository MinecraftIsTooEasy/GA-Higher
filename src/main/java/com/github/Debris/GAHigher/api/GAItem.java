package com.github.Debris.GAHigher.api;

public interface GAItem {
    double ga$getSoldPrice(int subtype);

    double ga$getBuyPrice(int subtype);

    void ga$setSoldPrice(int subtype, double soldPrice);

    void ga$setBuyPrice(int subtype, double soldPrice);

    GAItem ga$setBuyPriceForAllSubs(double price);

    GAItem ga$setSoldPriceForAllSubs(double price);
}
