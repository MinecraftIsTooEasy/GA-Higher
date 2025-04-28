package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemDrug_YD_B extends ItemFood {
    public ItemDrug_YD_B(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "drug_yd_b");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
//            par3EntityPlayer.c(new MobEffect(MobEffectList.s.H, 20, 2));
//            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.s.H, 20, 2));

//            par3EntityPlayer.c(new MobEffect(MobEffectList.u.H, 20, 2));
//            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.u.H, 20, 2));
            par3EntityPlayer.setInsulinResistance(par3EntityPlayer.getInsulinResistance() - 12800);
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 1, true);
            par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutrition() + 1, true);
        }
    }

    public boolean isHarmedByPepsin() {
        return false;
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+1的饱和度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+1的饱食度", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("-12800的血糖", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("移除“饥饿”效果", new Object[0]));
        }
    }
}