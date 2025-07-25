package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

/**
 * //TODO make it save item when playey dies, better than ga bag.
 */
public class ItemGotchaChest extends ItemGABag {
    public ItemGotchaChest(int par1) {
        super(par1, Material.seed);
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("身死道消", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("不可储存活物", new Object[0]));
        }
    }
}