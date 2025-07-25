package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

public class ItemLaTiao extends ItemFood {
    public ItemLaTiao(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "latiao");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 600, 0));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 8, true);
            par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutrition() + 4, true);
        }
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+8的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+4的饱食度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+饥饿半分钟", new Object[0]));
        }
    }
}