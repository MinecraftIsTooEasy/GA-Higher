package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.config.Configs;
import net.minecraft.BlockNetherStalk;
import net.minecraft.BlockPlant;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin({BlockNetherStalk.class})
public class BlockNetherWartTrans extends BlockPlant {
    protected BlockNetherWartTrans(int par1) {
        super(par1);
    }

    public boolean updateTick(World world, int x, int y, int z, Random random) {
        if (super.updateTick(world, x, y, z, random))
            return true;
        int metadata = world.getBlockMetadata(x, y, z);
        if (metadata < 3 && random.nextInt(8 * Configs.wenscConfig.netherWartDifficulty.ConfigValue.intValue()) == 0) {
            metadata++;
            return world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
        }
        return false;
    }

    public boolean canBePlacedAt(World world, int x, int y, int z, int metadata) {
        return super.canBePlacedAt(world, x, y, z, metadata);
    }
}
