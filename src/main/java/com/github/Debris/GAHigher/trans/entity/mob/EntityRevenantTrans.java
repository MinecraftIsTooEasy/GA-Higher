package com.github.Debris.GAHigher.trans.entity.mob;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.EntityRevenant;
import net.minecraft.EntityZombie;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({EntityRevenant.class})
public class EntityRevenantTrans extends EntityZombie {
    public EntityRevenantTrans(World world) {
        super(world);
    }

    @Override
    public int getExperienceValue() {
        if (Configs.wenscConfig.isDropZombieBrain.ConfigValue &&
                Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue.intValue())
            dropItem(Items.Zombie_Brain);
        int baseExp = 25;
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
