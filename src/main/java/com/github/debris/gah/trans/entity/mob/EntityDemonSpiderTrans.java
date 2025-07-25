package com.github.debris.gah.trans.entity.mob;

import com.github.debris.gah.config.Configs;
import net.minecraft.EntityAIGetOutOfLava;
import net.minecraft.EntityArachnid;
import net.minecraft.EntityDemonSpider;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({EntityDemonSpider.class})
public class EntityDemonSpiderTrans extends EntityArachnid {
    public EntityDemonSpiderTrans(World par1World) {
        super(par1World, 1.0F);
        this.tasks.addTask(4, new EntityAIGetOutOfLava(this, 1.0F));
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
