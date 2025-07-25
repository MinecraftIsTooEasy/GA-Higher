package com.github.debris.gah.block;

import net.minecraft.*;

public class BlockGotcha extends BlockBreakable implements IBlockWithSubtypes {
    public Material gotcha_metal;
    private final BlockSubtypes subtypes = new BlockSubtypes(new String[]{
            "black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray", "gray", "pink",
            "lime", "yellow", "light_blue", "magenta", "orange", "white"});

    public BlockGotcha(int par1, Material par2Material, boolean par3) {
        super(par1, "glass", par2Material, par3, (new BlockConstants()).setNeverHidesAdjacentFaces());
        setMaxStackSize(64);
        setHardness(0.0F);
        setCushioning(1000.0F);
        setMinHarvestLevel(0);
        setStepSound(Block.soundGlassFootstep);
        setLightValue(1.0F);
    }

    @Override
    public float getCraftingDifficultyAsComponent(int metadata) {
        return 1.0E-11F;
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
        this.subtypes.setIcons(registerIcons(par1IconRegister, getTextures(), "gotcha_"));
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
