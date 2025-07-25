package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

public class ItemPowderShui extends Item {
    public ItemPowderShui(int par1) {
        super(par1, Material.seed, "powder_shui");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("Φ串Φ", new Object[0]));
        }
    }
}