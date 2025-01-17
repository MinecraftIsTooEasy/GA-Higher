package com.github.Debris.GAHigher.unsafe;

import baubles.api.BaublesApi;
import com.google.common.collect.ImmutableList;
import net.minecraft.EntityPlayer;
import net.minecraft.IInventory;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import java.util.List;
import java.util.function.Predicate;

public class BaublesAccessor {
    public static boolean isBaubleWorn(EntityPlayer player, Item item) {
        IInventory baubles = BaublesApi.getBaubles(player);
        for (int i = 0; i < baubles.getSizeInventory(); i++) {
            ItemStack stackInSlot = baubles.getStackInSlot(i);
            if (stackInSlot != null && stackInSlot.getItem() == item) return true;
        }
        return false;
    }

    public static List<ItemStack> getStacksPredicate(EntityPlayer player, Predicate<ItemStack> predicate) {
        ImmutableList.Builder<ItemStack> builder = ImmutableList.builder();
        IInventory baubles = BaublesApi.getBaubles(player);
        for (int i = 0; i < baubles.getSizeInventory(); i++) {
            ItemStack stackInSlot = baubles.getStackInSlot(i);
            if (stackInSlot != null && predicate.test(stackInSlot)) {
                builder.add(stackInSlot);
            }
        }
        return builder.build();
    }
}
