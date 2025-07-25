package com.github.debris.gah.event.listener;

import moddedmite.rustedironcore.api.event.listener.IGravelDropListener;
import net.minecraft.BlockBreakInfo;

public class GravelListener implements IGravelDropListener {
    @Override
    public float onDropAsGravelChanceModify(BlockBreakInfo info, float original) {
        return 0.5F;
    }

    @Override
    public float onDropAsFlintChanceModify(BlockBreakInfo info, float original) {
        return 0.5F;
    }

    @Override
    public float onDropFlintAsChipChanceModify(BlockBreakInfo info, float original) {
        return 0.0F;
    }
}
