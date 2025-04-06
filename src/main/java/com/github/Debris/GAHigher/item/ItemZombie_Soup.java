package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.unsafe.ITEAccessor;
import net.minecraft.*;

import java.util.List;

public class ItemZombie_Soup extends ItemFood {
    public ItemZombie_Soup(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "zombie_soup");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
        setCreativeTab(CreativeTabs.tabFood);
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        if (ModCompat.HAS_ITE) {
            return ITEAccessor.getZombieSoupEatingDuration();
        }
        return super.getMaxItemUseDuration(par1ItemStack);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 300, 0));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 8, true);
            par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutrition() + 4, true);
        }
    }

    public boolean isHarmedByPepsin() {
        return false;
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+8的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+4的饱食度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+15秒瞬间回血", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("信春哥!", new Object[0]));
        }
    }
}
