package com.github.Debris.GAHigher.trans.entity.mob;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.DamageSource;
import net.minecraft.EntityAnimalWatcher;
import net.minecraft.EntityEarthElemental;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityEarthElemental.class})
public abstract class EntityEarthElementalTrans extends EntityAnimalWatcher {
    public EntityEarthElementalTrans(World world) {
        super(world);
    }

    @Inject(method = "dropFewItems", at = @At("RETURN"))
    private void addLoot(boolean recently_hit_by_player, DamageSource damage_source, CallbackInfo ci) {
        //            int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.CRIT, MMPlayer.getHeldItemStack());
//            if (k > 0 && Constant.GARandom.nextInt(100) < k * 5)
//                MMPlayer.dropItem(Items.Powder_HUO.cv, 1, 1.0F);
        if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
            this.dropItem(Items.Powder_HUO);
        }
    }

    public int getExperienceValue() {
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
