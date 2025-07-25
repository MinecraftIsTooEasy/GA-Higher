package com.github.debris.gah.item.jewelry;

import com.github.debris.gah.api.GAEntityItem;
import net.minecraft.*;

import java.util.List;

public class ItemMagnet extends ItemBauble {
    public ItemMagnet(int id) {
        super(id, Material.iron, "magnet");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onTick(ItemStack itemStack, ServerPlayer player) {
//        if (itemStack.stackTagCompound.hasKey("enabled") && !itemStack.stackTagCompound.getBoolean("enabled")) return;
        List<Entity> nearbyEntities = player.getNearbyEntities(9.0F, 9.0F);
        for (Entity nearbyEntity : nearbyEntities) {
            if (nearbyEntity instanceof EntityItem entityItem) {
                if (entityItem.isDead) continue;
                ((GAEntityItem) entityItem).setAttractedByMagnet();
                entityItem.onCollideWithPlayer(player);
            }
        }
    }
}
