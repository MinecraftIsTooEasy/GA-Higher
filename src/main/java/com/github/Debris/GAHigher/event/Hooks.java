package com.github.Debris.GAHigher.event;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.DamageSource;
import net.minecraft.EntityGhoul;
import net.minecraft.EntityLiving;
import net.minecraft.EntityShadow;

public class Hooks {
    public static void onMobDrop(EntityLiving entityLiving, boolean recentlyHitByPlayer, DamageSource damageSource) {
        if (entityLiving instanceof EntityShadow || entityLiving instanceof EntityGhoul) {
            if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
                entityLiving.dropItem(Items.Drug_YD);
            }
        }
    }
}
