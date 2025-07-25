package com.github.debris.gah.trans.block;

import com.github.debris.gah.item.Items;
import com.github.debris.gah.util.Constant;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockMushroomCap.class)
public abstract class BlockMushroomCapMixin extends Block {

    @Shadow
    @Final
    private int mushroomType;

    @Shadow
    public abstract int dropBlockAsEntityItem(BlockBreakInfo info);

    protected BlockMushroomCapMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Inject(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockMushroomCap;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I"))
    private void addLoot(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir) {
        int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency, info.getHarvesterItemStack());
        boolean isOverWorld = info.world.isOverworld();
        if (k > 0 && isOverWorld && Constant.GARandom.nextInt(500) < k * (1 + this.mushroomType * 4)) {
            this.dropBlockAsEntityItem(info, Items.Powder_An.itemID);
        }
    }
}
