package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

public class ItemEight_Hamburger extends ItemFood {
    public ItemEight_Hamburger(int par1) {
        super(par1, Material.bread, 1, 0, false, false, false, "eight_hamburger");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 900, 0));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 1, true);
        }
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+1的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+45秒饱和", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("奥利给", new Object[0]));
        }
    }
}