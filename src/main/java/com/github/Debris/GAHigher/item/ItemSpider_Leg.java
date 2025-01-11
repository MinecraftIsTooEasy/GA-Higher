package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

import java.util.List;

public class ItemSpider_Leg extends ItemFood {
    public ItemSpider_Leg(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "spider_leg");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
        setCreativeTab(CreativeTabs.tabFood);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            int Buff = Constant.GARandom.nextInt(100);
            if (Buff < 25)
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 7200, 2));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 1, true);
        }
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+1的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+百分之25几率360秒急速", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("幽魂之地的特产", new Object[0]));
        }
    }
}
