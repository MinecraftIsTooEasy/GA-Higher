package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

public class ItemBadApple extends Item {
    public ItemBadApple(int par1) {
        super(par1, Material.seed, "bad_apple");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("BAD APPLE ! !", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("Lotus Land Story", new Object[0]));
        }
    }
}
