package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.item.ItemRingKiller;
import com.github.Debris.GAHigher.screen.inventory.InventoryJewelry;
import com.github.Debris.GAHigher.unsafe.BaublesAccessor;
import net.minecraft.EntityPlayer;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BaublesUtil {
    public static boolean hasBaubleWorn(EntityPlayer player, Item item) {
        if (GAEntityPlayer.getInventoryJewelry(player).hasItem(item)) return true;

        if (ModCompat.HAS_BAUBLES && BaublesAccessor.isBaubleWorn(player, item)) return true;

        return false;
    }

    public static Optional<ItemRingKiller> getBestRingKiller(EntityPlayer player) {
        InventoryJewelry inventoryJewelry = GAEntityPlayer.getInventoryJewelry(player);
        List<ItemStack> stacks = new ArrayList<>(inventoryJewelry.getRingKillers());
        if (ModCompat.HAS_BAUBLES) {
            stacks.addAll(BaublesAccessor.getStacksPredicate(player, stack -> stack.getItem() instanceof ItemRingKiller));
        }
        return stacks.stream()
                .map(ItemStack::getItem)
                .map(x -> (ItemRingKiller) x)
                .max(Comparator.comparingInt(ItemRingKiller::getLevel));
    }

}
