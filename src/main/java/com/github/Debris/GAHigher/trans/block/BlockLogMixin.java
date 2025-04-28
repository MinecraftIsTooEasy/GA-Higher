package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockLog.class)
public abstract class BlockLogMixin extends BlockRotatedPillar {
    protected BlockLogMixin(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Inject(method = "dropBlockAsEntityItem", at = @At("HEAD"))
    private void addLoot(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir) {
        int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.tree_felling, info.getHarvesterItemStack());
        if (k > 0 && Constant.GARandom.nextInt(100) < k) {
            dropBlockAsEntityItem(info, Items.Powder_MU.itemID);
        }
    }
}
