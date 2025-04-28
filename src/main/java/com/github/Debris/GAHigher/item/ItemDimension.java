package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemDimension extends Item {
    public ItemDimension(int par1, Material material) {
        super(par1, Material.diamond, "dimension");
        setMaxStackSize(1);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("终极武器", new Object[0]));
        }
    }
}