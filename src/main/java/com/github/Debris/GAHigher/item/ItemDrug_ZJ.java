package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemDrug_ZJ extends ItemFood {
    public ItemDrug_ZJ(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "drug_zj");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
        setCreativeTab(CreativeTabs.tabFood);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 1760, 8));
            par3EntityPlayer.setInsulinResistance(par3EntityPlayer.getInsulinResistance() - 12800);
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
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+88秒抗性提升VIII", new Object[0]));
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("-12800的血糖", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("伐毛洗髓!", new Object[0]));
        }
    }
}
