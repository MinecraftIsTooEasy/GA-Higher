package com.github.Debris.GAHigher.trans.world;

import com.github.Debris.GAHigher.api.GAWorld;
import net.minecraft.Block;
import net.minecraft.World;
import net.minecraft.WorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({World.class})
public abstract class WorldTrans implements GAWorld {
    @Shadow
    public WorldInfo worldInfo;

    @Shadow
    public static int getDayOfWorld(long unadjusted_tick) {
        return 0;
    }

    public int getDayOfOverworld() {
        return getDayOfWorld(this.worldInfo.getWorldTotalTime(0));
    }
    @Shadow
    public Block getBlock(int x, int y, int z) {
        return null;
    }
}
