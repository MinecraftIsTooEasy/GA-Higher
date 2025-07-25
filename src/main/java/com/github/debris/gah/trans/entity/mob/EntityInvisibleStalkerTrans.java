package com.github.debris.gah.trans.entity.mob;

import com.github.debris.gah.config.Configs;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.util.Constant;
import net.minecraft.EntityInvisibleStalker;
import net.minecraft.EntityMob;
import net.minecraft.ItemStack;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({EntityInvisibleStalker.class})
public class EntityInvisibleStalkerTrans extends EntityMob {
    public EntityInvisibleStalkerTrans(World par1World) {
        super(par1World);
    }

    public int getExperienceValue() {
        if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue.intValue())
            dropItemStack(new ItemStack(Items.ColorBag.itemID, 1));
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
