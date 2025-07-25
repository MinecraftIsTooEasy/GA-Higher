package com.github.debris.gah.unsafe;

import cn.wensc.mitemod.extreme.api.IEXPlayer;
import net.minecraft.EntityPlayer;
import net.minecraft.Item;

public class ExtremeAccessor {
    public static boolean isBaubleWorn(EntityPlayer player, Item item) {
        return IEXPlayer.getInventoryJewelryStatic(player).hasItem(item);
    }
}
