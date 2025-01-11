package com.github.Debris.GAHigher.block;

import net.minecraft.*;

public class BlockColorfulWall extends BlockWall {
    public static final String[] types = new String[]{
            "black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink",
            "lime", "yellow", "light_blue", "magenta", "orange", "white"};

    private BlockSubtypes subtypes = new BlockSubtypes(new String[]{
            "black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink",
            "lime", "yellow", "light_blue", "magenta", "orange", "white"});

    public BlockColorfulWall(int par1, Block par2Block, int par3) {
        super(par1, par2Block);
        setMaxStackSize(64);
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
        return metadata & 0xF;
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return dropBlockAsEntityItem(info, createStackedBlock(info.getMetadata()));
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.subtypes.setIcons(registerIcons(par1IconRegister, getTextures(), "colorful/colorful_"));
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
