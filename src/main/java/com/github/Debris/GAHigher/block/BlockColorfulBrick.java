package com.github.Debris.GAHigher.block;

import net.minecraft.*;

public class BlockColorfulBrick extends Block implements IBlockWithSubtypes {
    private final BlockSubtypes subtypes = new BlockSubtypes(new String[]{
            "black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink",
            "lime", "yellow", "light_blue", "magenta", "orange", "white"});

    public BlockColorfulBrick(int par1, Material par2Material) {
        super(par1, par2Material, new BlockConstants());
        setMaxStackSize(64);
        setHardness(2.0F);
        setCushioning(1000.0F);
        setResistance(10.0F);
        setMinHarvestLevel(0);
        setStepSound(Block.soundStoneFootstep);
        setLightValue(0.7F);
    }

    public boolean isAlwaysReplaceable() {
        return false;
    }

    public boolean canBeReplacedBy(int metadata, Block other_block, int other_block_metadata) {
        return false;
    }

    public int getRenderBlockPass() {
        return 0;
    }

    public boolean isValidMetadata(int metadata) {
        return (metadata >= 0 && metadata < 16);
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata;
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.subtypes.setIcons(registerIcons(par1IconRegister, getTextures(), "colorful_brick/colorful_brick_"));
    }

    public Icon getIcon(int side, int metadata) {
        return this.subtypes.getIcon(getBlockSubtype(metadata));
    }

    public String[] getTextures() {
        return this.subtypes.getTextures();
    }

    public String[] getNames() {
        return this.subtypes.getNames();
    }
}
