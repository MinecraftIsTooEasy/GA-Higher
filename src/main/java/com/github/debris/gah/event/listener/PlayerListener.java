package com.github.debris.gah.event.listener;

import com.github.debris.gah.item.Items;
import moddedmite.rustedironcore.api.event.events.PlayerLoggedInEvent;
import moddedmite.rustedironcore.api.event.listener.IPlayerEventListener;
import net.minecraft.ItemStack;
import net.minecraft.Potion;
import net.minecraft.PotionEffect;
import net.minecraft.ServerPlayer;

public class PlayerListener implements IPlayerEventListener {
    @Override
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        ServerPlayer serverPlayer = event.player();
        if (event.firstLogin()) {
            serverPlayer.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 12000, 0));
            // TODO give newbee book
            serverPlayer.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Items.GABag, 1, 0));
        }
    }
}
