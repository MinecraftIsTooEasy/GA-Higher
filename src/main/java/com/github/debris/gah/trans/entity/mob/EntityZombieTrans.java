package com.github.debris.gah.trans.entity.mob;

import com.github.debris.gah.config.Configs;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.util.Constant;
import com.github.debris.gah.util.RandomUtil;
import net.minecraft.DamageSource;
import net.minecraft.EntityAnimalWatcher;
import net.minecraft.EntityZombie;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityZombie.class})
public abstract class EntityZombieTrans extends EntityAnimalWatcher {

    public EntityZombieTrans(World world) {
        super(world);
    }

    @Inject(method = "dropFewItems", at = @At("RETURN"))
    private void dropBrain(boolean recently_hit_by_player, DamageSource damage_source, CallbackInfo ci) {
        if (Configs.wenscConfig.isDropZombieBrain.ConfigValue && Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
            dropItem(Items.Zombie_Brain);
        }
        if (recently_hit_by_player) {
            RandomUtil.dropRandomJewelry(this);
        }
    }

    @Override
    public int getExperienceValue() {
        int baseExp = 5;
        int day = Math.max(getWorld().getDayOfWorld(), 1);
        int Temp = baseExp * day;
        int exp1 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        int level = 0;
        if (getLastHarmingEntity() instanceof net.minecraft.EntityPlayer)
            level = getLastHarmingEntity().getAsPlayer().getExperienceLevel();
        Temp = baseExp * Math.max(level, 1);
        int exp2 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        if (Configs.wenscConfig.ExpMod.ConfigValue.equals("1"))
            return exp1;
        return Configs.wenscConfig.ExpMod.ConfigValue.equals("2") ? exp2 : baseExp;
    }
}
