package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemCreeper_Soul extends ItemFood {
    public ItemCreeper_Soul(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "creeper_soul");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10800, 3));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 4, true);
        }
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+4的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+540秒急迫IV", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("苦力之魂", new Object[0]));
        }
    }
}
