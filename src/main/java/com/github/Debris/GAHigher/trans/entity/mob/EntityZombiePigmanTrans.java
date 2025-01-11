package com.github.Debris.GAHigher.trans.entity.mob;

import com.github.Debris.GAHigher.config.Configs;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({EntityPigZombie.class})
public abstract class EntityZombiePigmanTrans extends EntityZombie implements IRangedAttackMob {

    public EntityZombiePigmanTrans(World par1World) {
        super(par1World);
    }

    @ModifyReturnValue(method = "getExperienceValue", at = @At("RETURN"))
    private int modifyExp(int original) {
        int day = Math.max(getWorld().getDayOfWorld(), 1);
        int Temp = original * day;
        int exp1 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue.intValue()) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        int level = 0;
        if (getLastHarmingEntity() instanceof EntityPlayer)
            level = getLastHarmingEntity().getAsPlayer().getExperienceLevel();
        Temp = original * Math.max(level, 1);
        int exp2 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue.intValue()) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        if (Configs.wenscConfig.ExpMod.ConfigValue.equals("1"))
            return exp1;
        return Configs.wenscConfig.ExpMod.ConfigValue.equals("2") ? exp2 : original;
    }
}
