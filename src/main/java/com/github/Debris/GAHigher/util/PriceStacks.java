package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.api.GAItemStack;
import net.minecraft.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PriceStacks {
    private static final List<ItemStack> priceStackList = new ArrayList<>();
    public static int shopSize = 0;

    private static boolean loadingFlag = false;

    public static void beginLoading() {
        priceStackList.clear();
        loadingFlag = true;
    }

    public static void addStack(ItemStack itemStack) {
        if (loadingFlag) {
            priceStackList.add(itemStack);
        } else {
            throw new IllegalStateException("PriceStacks: not loading");
        }
    }

    public static void endLoading() {
        loadingFlag = false;
    }

    public static void sortList() {
        priceStackList.sort((o1, o2) -> {
            double offset;
            double o1Buy = (((GAItemStack) o1).getPrice()).buyPrice();
            double o2Buy = (((GAItemStack) o2).getPrice()).buyPrice();
            if (o2Buy > 0.0D && o1Buy > 0.0D) {
                offset = o1Buy - o2Buy;
            } else {
                offset = o2Buy - o1Buy;
            }
            return (offset > 0.0D) ? 1 : ((offset == 0.0D) ? 0 : -1);
        });
    }

    public static int getStackListSize() {
        return priceStackList.size();
    }

    public static List<ItemStack> subList(int from, int to) {
        return priceStackList.subList(from, to);
    }
}
