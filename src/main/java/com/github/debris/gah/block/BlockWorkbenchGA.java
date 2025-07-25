package com.github.debris.gah.block;

import com.github.debris.gah.material.Materials;
import moddedmite.rustedironcore.api.block.WorkbenchBlock;

public class BlockWorkbenchGA extends WorkbenchBlock {
    public BlockWorkbenchGA(int id) {
        super(id, Materials.mitega, Float.MAX_VALUE, Materials.getBestMaterial());
    }
}
