package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({BlockCrops.class})
public abstract class BlockCropTrans extends BlockGrowingPlant {
    public BlockCropTrans(int block_id) {
        super(block_id);
    }

    @Overwrite
    public boolean fertilize(World world, int x, int y, int z, ItemStack item_stack) {
        Item item = item_stack.getItem();
        if (item != Item.dyePowder && item != Item.manure)
            return false;
        int metadata = world.getBlockMetadata(x, y, z);
        return (isBlighted(metadata) && world.setBlockMetadataWithNotify(x, y, z, setBlighted(metadata, false), 2));
    }

    @Shadow
    private boolean isBlighted(int metadata) {
        return false;
    }

    @Shadow
    private int setBlighted(int metadata, boolean b) {
        return 0;
    }

    @Shadow
    public abstract int dropBlockAsEntityItem(BlockBreakInfo info);

    @Inject(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockCrops;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I", ordinal = 1))
    private void addLoot(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir, @Local float harvesting_enchantment) {
        if (harvesting_enchantment > 0.0F && Constant.GARandom.nextInt(100) < harvesting_enchantment * 10.0F) {
            this.dropBlockAsEntityItem(info, Items.Powder_TU);
        }
    }
}
