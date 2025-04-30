package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.BaublesUtil;
import moddedmite.rustedironcore.api.event.listener.ICombatListener;
import net.minecraft.*;

public class CombatListener implements ICombatListener {
    @Override
    public float onPlayerBlockReachModify(EntityPlayer player, Block block, int metadata, float original) {
        if (BaublesUtil.hasBaubleWorn(player, Items.pocket_piston)) {
            original += 1;
        }
        return original;
    }

    @Override
    public float onPlayerEntityReachModify(EntityPlayer player, EnumEntityReachContext context, Entity entity, float original) {
        if (BaublesUtil.hasBaubleWorn(player, Items.pocket_piston)) {
            original += 1;
        }
        return original;
    }

    @Override
    public float onEntityLivingFallDamageModify(EntityLivingBase instance, float fall_distance, BlockInfo block_landed_on_info, float original) {
        if (instance instanceof EntityPlayer player) {
            ItemStack itemStack = player.getHeldItemStack();
            if (itemStack == null) return original;
            if (itemStack.getItem() == Items.Fan) {
//                int adddamage = (int) Math.min(original / player.aN() * 10000.0F, 10000.0F);
                int adddamage = (int) Math.min(original / player.getHealth() * 10000.0F, 10000.0F);
                itemStack.setItemDamage(itemStack.getItemDamage() + adddamage);
                if (original > 1.0D)
                    player.addChatMessage("§d地精扇:§r §6啦啦啦……粉红的扇子飞舞§r");
                original = 0.0F;
            }
        }
        return original;
    }
}
