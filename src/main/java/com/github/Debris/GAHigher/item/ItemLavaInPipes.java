package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemLavaInPipes extends Item {
    protected ItemLavaInPipes(int par1, Material par2Material) {
        super(par1, Material.lava.setDissolvesInWater(), "lava_in_pipes");
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabMaterials);
    }

    public int getBurnTime(ItemStack item_stack) {
        return 3200;
    }

    public int getHeatLevel(ItemStack item_stack) {
        return 3;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("请勿随身携带", new Object[0]));
            info.add(EnumChatFormatting.BLUE + Translator.getFormatted("烫烫烫烫烫烫", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("10S着火效果", new Object[0]));
        }
    }
}
