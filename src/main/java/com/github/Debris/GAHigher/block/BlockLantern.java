package com.github.Debris.GAHigher.block;

import net.minecraft.Block;
import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockConstants;
import net.minecraft.Material;

public class BlockLantern extends Block {
    BlockLantern(int par1, Material material) {
        super(par1, material, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
        setMaxStackSize(64);
        setLightValue(1.0F);
        setBounds(true);
    }

    private void setBounds(boolean for_all_threads) {
        float var1 = 0.375F;
        float var2 = var1 / 2.0F;
        setBlockBounds((0.5F - var2), 0.0D, (0.5F - var2), (0.5F + var2), 0.6875D, (0.5F + var2), for_all_threads);
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (!info.wasExploded() && !info.wasCrushed())
            return dropBlockAsEntityItem(info, Blocks.blockLantern);
        return 0;
    }

    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
        return false;
    }

    public void setBlockBoundsForItemRender(int item_damage) {
        setBounds(false);
    }
}
