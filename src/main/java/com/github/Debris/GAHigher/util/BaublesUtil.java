package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.item.ItemRingKiller;
import com.github.Debris.GAHigher.screen.inventory.InventoryJewelry;
import com.github.Debris.GAHigher.unsafe.BaublesAccessor;
import net.minecraft.EntityPlayer;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BaublesUtil {
    public static boolean hasBaubleWorn(EntityPlayer player, Item item) {
        if (GAEntityPlayer.getInventoryJewelry(player).hasItem(item)) return true;

        if (ModCompat.HAS_BAUBLES && BaublesAccessor.isBaubleWorn(player, item)) return true;

        return false;
    }

    public static Optional<ItemRingKiller> getBestRingKiller(EntityPlayer player) {
        InventoryJewelry inventoryJewelry = GAEntityPlayer.getInventoryJewelry(player);
        List<ItemStack> stacks1 = inventoryJewelry.getRingKillers();
        List<ItemStack> stacks2 = BaublesAccessor.getStacksPredicate(player, stack -> stack.getItem() instanceof ItemRingKiller);
        return Stream.concat(stacks1.stream(), stacks2.stream())
                .map(ItemStack::getItem)
                .map(x -> (ItemRingKiller) x)
                .max(Comparator.comparingInt(ItemRingKiller::getLevel));
    }

}
