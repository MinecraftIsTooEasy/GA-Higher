package com.github.Debris.GAHigher.trans.entity.mob;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.DamageSource;
import net.minecraft.EntityMob;
import net.minecraft.EntityWight;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityWight.class})
public class EntityWightTrans extends EntityMob {
    public EntityWightTrans(World par1World) {
        super(par1World);
    }

    @Inject(method = "dropFewItems", at = @At("RETURN"))
    private void dropDrugYD(boolean recently_hit_by_player, DamageSource damage_source, CallbackInfo ci) {
        if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue)
            dropItem(Items.Drug_YD);
    }

    @SuppressWarnings("OverwriteAuthorRequired")
    @Overwrite
    public int getExperienceValue() {
        int baseExp = 10;
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
