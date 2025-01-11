package com.github.Debris.GAHigher.trans.entity.mob;

import com.github.Debris.GAHigher.api.GABat;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityBat.class})
public class EntityBatTrans extends EntityAmbientCreature implements GABat {

    public EntityBatTrans(World par1World) {
        super(par1World);
    }

    @Override
    public int getExperienceValue() {
        if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue)
            dropItem(Items.manure);
        if (this.spawnedByWitch) return 0;
        int baseExp = 0;
        if (getClass().equals(EntityVampireBat.class)) {
            baseExp = 2;
        } else if (getClass().equals(EntityGiantVampireBat.class)) {
            baseExp = 4;
        } else if (getClass().equals(EntityNightwing.class)) {
            baseExp = 4;
        }
        int day = Math.max(getWorld().getDayOfWorld(), 1);
        int temp = baseExp * day;
        int exp1 = Math.min(temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        int level = 0;
        if (getLastHarmingEntity() instanceof net.minecraft.EntityPlayer)
            level = getLastHarmingEntity().getAsPlayer().getExperienceLevel();
        temp = baseExp * Math.max(level, 1);
        int exp2 = Math.min(temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        if (Configs.wenscConfig.ExpMod.ConfigValue.equals("1"))
            return exp1;
        return Configs.wenscConfig.ExpMod.ConfigValue.equals("2") ? exp2 : baseExp;
    }

    @Override
    public void markSpawnedByWitch() {
        this.spawnedByWitch = true;
    }

    @Inject(method = "readEntityFromNBT", at = @At("RETURN"))
    private void injectReadNBT(NBTTagCompound nbt, CallbackInfo callbackInfo) {
        if (nbt.hasKey("SpawnedByWitch")) {
            this.spawnedByWitch = nbt.getBoolean("SpawnedByWitch");
        }
    }

    @Unique
    private boolean spawnedByWitch = false;
}
