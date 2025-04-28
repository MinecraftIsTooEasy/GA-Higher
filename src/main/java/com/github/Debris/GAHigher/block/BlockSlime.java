package com.github.Debris.GAHigher.block;

import net.minecraft.*;

public class BlockSlime extends BlockFalling {
    private float crafting_difficulty_as_component;

    public BlockSlime(int id) {
//    super(id, Material.p, (new BlockConstants()).setNeverConnectsWithFence().setUseNewSandPhysics());
        super(id, Material.slime, (new BlockConstants()).setNeverConnectsWithFence().setUseNewSandPhysics());
        this.crafting_difficulty_as_component = 0.0F;
        setMaxStackSize(64);
        setMinHarvestLevel(0);
        setHardness(BlockHardness.sand / 20.0F);
        setCushioning(1000.0F);
        setCraftingDifficultyAsComponent(1.0E-12F);
        setStepSound(soundSandFootstep);
    }

    public BlockSlime setCraftingDifficultyAsComponent(float difficulty) {
        this.crafting_difficulty_as_component = difficulty;
        return this;
    }

    public boolean isAlwaysReplaceable() {
        return false;
    }

    public boolean canBeReplacedBy(int metadata, Block other_block, int other_block_metadata) {
        return false;
    }

    public String getMetadataNotes() {
        return "Cactus kill count is kept in the sand beneath it, with a maximum value of 7";
    }

    public static final StepSound slime = new StepSound("slime", 1.0F, 1.0F);

    public void makeSoundWhenPlaced(World world, int x, int y, int z, int metadata) {
        super.makeSoundWhenPlaced(world, x, y, z, metadata);
    }

    public boolean isValidMetadata(int metadata) {
        return (metadata >= 0 && metadata <= BlockCactus.getKillCountBits());
    }
}