package com.github.debris.gah.util;

import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;

public class PlayerUtil {
    public static void addToInventoryOrDrop(EntityPlayer player, ItemStack stack) {
        player.inventory.addItemStackToInventoryOrDropIt(stack);
    }
}
