package com.github.debris.gah.event.listener;

import com.github.debris.gah.config.Configs;
import moddedmite.rustedironcore.api.event.listener.IPlayerAttributeListener;
import net.minecraft.EntityPlayer;

public class PlayerAttributeListener implements IPlayerAttributeListener {
    @Override
    public float onHealthLimitModify(EntityPlayer player, float original) {
        if (!Configs.wenscConfig.BlnHealth.ConfigValue) return original;
        int max = Math.max(Math.min(6 + player.getExperienceLevel() / 5 * 2, 200), 6);
        return Math.max(max, (int) original);
    }

    @Override
    public int onLevelLimitModify(int original) {
        return Configs.wenscConfig.BlnHealth.ConfigValue ? Math.max(500, original) : original;
    }

    @Override
    public int onNutritionLimitModify(EntityPlayer player, int original) {
        return 1024000;
    }
}
