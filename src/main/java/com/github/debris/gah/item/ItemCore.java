package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

public class ItemCore extends Item {
    public ItemCore(int par1) {
        super(par1, Material.diamond, "core");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("灵泉之眼所化", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("无限灵力之源", new Object[0]));
        }
    }
}