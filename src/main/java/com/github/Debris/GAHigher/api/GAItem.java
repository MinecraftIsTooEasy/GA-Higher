package com.github.Debris.GAHigher.api;

public interface GAItem {
    double getSoldPrice(int subtype);

    double getBuyPrice(int subtype);

    void registerSoldPrice(int subtype, double soldPrice);

    void registerBuyPrice(int subtype, double soldPrice);

    GAItem setBuyPrice(double price);

    GAItem setSoldPrice(double price);
}
