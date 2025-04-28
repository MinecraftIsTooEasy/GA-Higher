package com.github.Debris.GAHigher.trans.entity.mob;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.Items;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({EntityGhast.class})
public abstract class EntityGhastTrans extends EntityFlying implements IMob {

    public EntityGhastTrans(World world) {
        super(world);
    }

    @WrapOperation(method = "dropFewItems", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityGhast;dropItem(II)Lnet/minecraft/EntityItem;", ordinal = 0))
    private EntityItem changeLoot(EntityGhast instance, int id, int count, Operation<EntityItem> original) {
        return original.call(instance, Items.Ghast_ShiZuKu.itemID, count);
    }

    @Override
    public int getExperienceValue() {
        int baseExp = 50;
        int day = Math.max(getWorld().getDayOfWorld(), 1);
        int Temp = baseExp * day;
        int exp1 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        int level = 0;
        if (getLastHarmingEntity() instanceof EntityPlayer)
            level = getLastHarmingEntity().getAsPlayer().getExperienceLevel();
        Temp = baseExp * Math.max(level, 1);
        int exp2 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        if (Configs.wenscConfig.ExpMod.ConfigValue.equals("1"))
            return exp1;
        return Configs.wenscConfig.ExpMod.ConfigValue.equals("2") ? exp2 : baseExp;
    }
}
