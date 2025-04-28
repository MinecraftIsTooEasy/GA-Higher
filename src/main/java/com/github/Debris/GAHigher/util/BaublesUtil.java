package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.unsafe.BaublesAccessor;
import com.github.Debris.GAHigher.unsafe.ExtremeAccessor;
import net.minecraft.EntityPlayer;
import net.minecraft.Item;

public class BaublesUtil {
    public static boolean hasBaubleWorn(EntityPlayer player, Item item) {
        if (ModCompat.HAS_EXTREME && ExtremeAccessor.isBaubleWorn(player, item)) return true;

        if (ModCompat.HAS_BAUBLES && BaublesAccessor.isBaubleWorn(player, item)) return true;

        return false;
    }
}
