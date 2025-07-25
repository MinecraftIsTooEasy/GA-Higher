package com.github.debris.gah.trans.entity.mob;

import com.github.debris.gah.config.Configs;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.util.Constant;
import net.minecraft.EntityBlaze;
import net.minecraft.EntityMob;
import net.minecraft.SharedMonsterAttributes;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityBlaze.class})
public class EntityBlazeTrans extends EntityMob {
    public EntityBlazeTrans(World par1World) {
        super(par1World);
    }

    @Inject(method = "applyEntityAttributes", at = @At("RETURN"))
    private void modify(CallbackInfo ci) {
        setEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(40.0D);
    }

    @Override
    public int getExperienceValue() {
        if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue.intValue())
            dropItem(Items.blazeRod, 3);
        int baseExp = 5;
        int day = Math.max(getWorld().getDayOfWorld(), 1);
        int Temp = baseExp * day;
        int exp1 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue.intValue()) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        int level = 0;
        if (getLastHarmingEntity() instanceof net.minecraft.EntityPlayer)
            level = getLastHarmingEntity().getAsPlayer().getExperienceLevel();
        Temp = baseExp * Math.max(level, 1);
        int exp2 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue.intValue()) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        if (Configs.wenscConfig.ExpMod.ConfigValue.equals("1"))
            return exp1;
        return Configs.wenscConfig.ExpMod.ConfigValue.equals("2") ? exp2 : baseExp;
    }
}
