package com.github.Debris.GAHigher.enums;

import com.github.Debris.GAHigher.compat.ITECompat;
import com.github.Debris.GAHigher.entity.EntityZombieBoss;
import net.minecraft.Entity;
import net.minecraft.EntityEnderman;
import net.minecraft.EntityMob;
import net.minecraft.EntitySilverfish;

public class RingKillerImmune {
    public static boolean shouldApply(Entity entity) {
        if (!(entity instanceof EntityMob)) return false;// only mob take damage
        if (entity instanceof EntityEnderman) return false;
        if (entity instanceof EntitySilverfish) return false;
        if (ITECompat.HAS_ITE && entity instanceof EntityZombieBoss) return false;// these mobs won't take damage
        return true;
    }
}
