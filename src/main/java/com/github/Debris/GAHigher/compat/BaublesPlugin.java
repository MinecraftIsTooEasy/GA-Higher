package com.github.Debris.GAHigher.compat;

import baubles.api.BaubleType;
import baubles.api.IBaublePlugin;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.item.jewelry.ItemJewelry;
import net.minecraft.EntityLivingBase;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.ServerPlayer;

public class BaublesPlugin implements IBaublePlugin {
    @Override
    public boolean canPutBaubleSlot(ItemStack itemStack, BaubleType baubleType) {
        if (baubleType == BaubleType.AMULET) {
            Item item = itemStack.getItem();
            for (ItemJewelry jewelry : Items.jewelries) {
                if (jewelry == item) return true;
            }
        }
        return false;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (itemStack == null) return;
        Item item = itemStack.getItem();
        if (entity instanceof ServerPlayer serverPlayer) {
            if (item instanceof ItemJewelry itemJewelry) {
                itemJewelry.onTick(itemStack, serverPlayer);
            }
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }
}
