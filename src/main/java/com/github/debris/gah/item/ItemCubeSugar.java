package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

public class ItemCubeSugar extends ItemFood {
    public ItemCubeSugar(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "cubesugar");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            float health = par3EntityPlayer.getHealth();
            if (health < 11.0F)
                par3EntityPlayer.setHealth(par3EntityPlayer.getHealth() + 2.0F, true, null);
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 4, true);
            par3EntityPlayer.setInsulinResistance(par3EntityPlayer.getInsulinResistance() + 19200);
        }
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+4的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+19200的糖分", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+2点生命(最多到10", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("不可多食", new Object[0]));
        }
    }
}