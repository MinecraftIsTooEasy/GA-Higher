package com.github.debris.gah.trans.entity.mob;

import com.github.debris.gah.config.Configs;
import net.minecraft.EntityPhaseSpider;
import net.minecraft.EntityWoodSpider;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({EntityPhaseSpider.class})
public class EntityPhaseSpiderTrans extends EntityWoodSpider {
    public EntityPhaseSpiderTrans(World world) {
        super(world);
    }

    /**
     * @author
     * @reason
     */
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
