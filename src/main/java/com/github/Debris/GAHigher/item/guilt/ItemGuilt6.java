package com.github.Debris.GAHigher.item.guilt;

import net.minecraft.*;

import java.util.List;

public class ItemGuilt6 extends Item {
    public ItemGuilt6(int par1) {
        super(par1, Material.diamond, "guilt6");
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMaterials);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("七罪其六", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("Diane", new Object[0]));
        }
    }
}