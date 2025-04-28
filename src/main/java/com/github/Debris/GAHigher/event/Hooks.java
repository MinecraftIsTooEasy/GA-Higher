package com.github.Debris.GAHigher.event;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

public class Hooks {
    public static void onMobDrop(EntityLiving entityLiving, boolean recentlyHitByPlayer, DamageSource damageSource) {
        if (entityLiving instanceof EntityShadow || entityLiving instanceof EntityGhoul) {
            if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
                entityLiving.dropItem(Items.Drug_YD);
            }
        }
        if (entityLiving instanceof EntityEarthElemental) {
//            int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.CRIT, MMPlayer.getHeldItemStack());
//            if (k > 0 && Constant.GARandom.nextInt(100) < k * 5)
//                MMPlayer.dropItem(Items.Powder_HUO.cv, 1, 1.0F);
            if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
                entityLiving.dropItem(Items.Powder_HUO);
            }
        }
    }
}
