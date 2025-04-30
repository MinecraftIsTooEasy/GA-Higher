package com.github.Debris.GAHigher.item.jewelry;

import moddedmite.rustedironcore.api.util.StringUtil;
import net.minecraft.*;

import java.util.List;

public class ItemJewelry extends Item {

    public ItemJewelry(int id, Material material, String texture) {
        super(id, material, texture);
        this.setMaxStackSize(1);
    }

    public void onTick(ItemStack itemStack, ServerPlayer player) {

    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        super.addInformation(item_stack, player, info, extended_info, slot);
        if (extended_info) {
            String key = this.getUnlocalizedName() + ".info";
            String translate = StringUtil.translate(key);
            if (!translate.equals(key)) {
                info.add(translate);
            }
        }
    }
}
