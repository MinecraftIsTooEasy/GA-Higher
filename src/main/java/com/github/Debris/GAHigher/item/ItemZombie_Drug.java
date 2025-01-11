package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemZombie_Drug extends ItemFood {
    public ItemZombie_Drug(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "zombie_drug");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
        setCreativeTab(CreativeTabs.tabFood);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 7200, 0));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 3, true);
            par3EntityPlayer.getAsEntityPlayerMP().setPhytonutrients(par3EntityPlayer.getAsEntityPlayerMP().getPhytonutrients() + 2700);
        }
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+3的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+360秒夜视", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("用了就离不开它", new Object[0]));
        }
    }
}
