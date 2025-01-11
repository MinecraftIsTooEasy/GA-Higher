package com.github.Debris.GAHigher.trans.entity.misc;

import com.github.Debris.GAHigher.config.Configs;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityFishHook.class})
public abstract class EntityFishingHookTrans extends Entity {
    public EntityFishingHookTrans(World par1World) {
        super(par1World);
    }

    @Inject(method = "getFishType", at = @At("HEAD"), cancellable = true)
    private void test(CallbackInfoReturnable<Item> cir) {
        if (Configs.wenscConfig.isOpenGAFish.ConfigValue) {
            cir.setReturnValue(this.gaFishing());
        }
    }

    @Unique
    private Item gaFishing() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY - 0.20000000298023224D);
        int m = MathHelper.floor_double(this.posZ);
        long count = 0L;
        Item[] fishTypeListStage0 = {Item.appleRed, Item.potato, Item.banana, Item.bread, Item.carrot, Item.orange};
        Item[] fishTypeListStage1 = {Item.copperNugget, Item.silverNugget, Item.goldNugget, Item.ironNugget};
        Item[] fishTypeListStage2 = {Item.mithrilNugget, Item.ancientMetalNugget, Item.adamantiumNugget};
        for (int k = -16; k <= 16; k++) {
            for (int dz = -16; dz <= 16; dz++) {
                for (int dy = -3; dy <= 0; dy++) {
                    Block block = this.worldObj.getBlock(i + k, j + dy, m + dz);
                    if (block == Block.dirt || block == Block.grass || block == Block.sand)
                        count++;
                }
            }
        }
        if (this.worldObj.getBiomeGenForCoords(i, m) == BiomeGenBase.ocean && count == 0L && this.rand.nextInt(3) == 0)
            return Item.fishLargeRaw;
        if (this.rand.nextInt(3) == 0) {
            if (this.rand.nextInt(2) == 0)
                return fishTypeListStage0[this.rand.nextInt(6)];
            if (this.rand.nextInt(2) == 0)
                return fishTypeListStage1[this.rand.nextInt(4)];
            if (this.rand.nextInt(2) == 0)
                return fishTypeListStage2[this.rand.nextInt(3)];
        }
        return Item.fishRaw;
    }
}
