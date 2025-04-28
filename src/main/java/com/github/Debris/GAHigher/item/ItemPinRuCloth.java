package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemPinRuCloth extends ItemGaArmor {
    public ItemPinRuCloth(int item_id, Material material, boolean is_chain_mail) {
        super(item_id, material, is_chain_mail);
    }

    public String getArmorType() {
        return "helmet";
    }

    public int getNumComponentsForDurability() {
        return 5;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("品如的衣服", new Object[0]));
        }
    }
}