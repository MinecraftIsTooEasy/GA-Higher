package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemPowderLei extends Item {
    public ItemPowderLei(int par1) {
        super(par1, Material.seed, "powder_lei");
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
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("雷劫", new Object[0]));
        }
    }
}