package com.github.debris.gah.compat;

import baubles.api.BaubleType;
import baubles.api.IBaublePlugin;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.item.jewelry.ItemBauble;
import net.minecraft.EntityLivingBase;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.ServerPlayer;

public class BaublesPlugin implements IBaublePlugin {
    @Override
    public boolean canPutBaubleSlot(ItemStack itemStack, BaubleType baubleType) {
        if (baubleType == BaubleType.AMULET) {
            Item item = itemStack.getItem();
            for (ItemBauble jewelry : Items.baubles) {
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
            if (item instanceof ItemBauble itemBauble) {
                itemBauble.onTick(itemStack, serverPlayer);
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
