package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.item.Items;
import moddedmite.rustedironcore.api.event.listener.ICombatListener;
import net.minecraft.Block;
import net.minecraft.Entity;
import net.minecraft.EntityPlayer;
import net.minecraft.EnumEntityReachContext;

public class CombatListener implements ICombatListener {
    @Override
    public float onPlayerBlockReachModify(EntityPlayer player, Block block, int metadata, float original) {
        if (GAEntityPlayer.getInventoryJewelry(player).hasJewelry(Items.pocket_piston)) {
            original += 1;
        }
        return original;
    }

    @Override
    public float onPlayerEntityReachModify(EntityPlayer player, EnumEntityReachContext context, Entity entity, float original) {
        if (GAEntityPlayer.getInventoryJewelry(player).hasJewelry(Items.pocket_piston)) {
            original += 1;
        }
        return original;
    }
}
