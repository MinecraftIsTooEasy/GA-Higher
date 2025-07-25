package com.github.debris.gah.trans.entity.misc;

import com.github.debris.gah.compat.ModCompat;
import com.github.debris.gah.config.Configs;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.unsafe.ITEAccessor;
import com.github.debris.gah.util.Constant;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = EntityFishHook.class, priority = 1001)
public abstract class EntityFishingHookTrans extends Entity {
    @Shadow
    public EntityPlayer angler;

    public EntityFishingHookTrans(World par1World) {
        super(par1World);
    }

    @Inject(method = "getFishType", at = @At("HEAD"), cancellable = true)
    private void gaFishing(CallbackInfoReturnable<Item> cir) {
        if (Configs.wenscConfig.isOpenGAFish.ConfigValue) {
            cir.setReturnValue(this.gaFishing());
        }
    }

    @Unique
    private Item gaFishing() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY - 0.2D);
        int m = MathHelper.floor_double(this.posZ);
        Random rand = (getWorld()).rand;
        long count = 0L;
        for (int n = -16; n <= 16; n++) {
            for (int dz = -16; dz <= 16; dz++) {
                for (int dy = -3; dy <= 0; dy++) {
                    Block block = this.worldObj.getBlock(i + n, j + dy, m + dz);
                    if (block == Block.dirt || block == Block.grass || block == Block.sand)
                        count++;
                }
            }
        }
        if (this.worldObj.getBiomeGenForCoords(i, m) == BiomeGenBase.ocean && count == 0L)
            return (Item) Item.fishLargeRaw;
        if (getWorld().isBlueMoon24HourPeriod() && rand.nextInt(10) == 0) {
            if (rand.nextInt(3) > 0)
                return Items.Guilt7;
            if (rand.nextInt(2) > 0)
                return Item.ingotCopper;
            if (rand.nextInt(2) > 0)
                return Item.ingotSilver;
            if (rand.nextInt(2) > 0)
                return Item.ingotGold;
            if (rand.nextInt(2) > 0)
                return Item.ingotIron;
            if (rand.nextInt(2) > 0)
                return Item.ingotMithril;
            if (rand.nextInt(2) > 0)
                return Item.ingotAdamantium;
            if (ModCompat.HAS_ITE && rand.nextInt(2) > 0)
                return ITEAccessor.getVibraniumIngot();
            if (rand.nextInt(2) > 0)
                return Items.MITEGA_INGOT;
        }
        int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.fishing_fortune, this.angler.getHeldItemStack());
        if (k > 0 && Constant.GARandom.nextInt(100) < k)
            this.angler.dropItem(Items.Powder_SHUI.itemID, 1, 1.0F);
        if (this.rand.nextFloat() < 0.1F)
            return Items.Tomato_Bad;
        if (this.rand.nextFloat() < 0.2F)
            return Items.Bamboo;
        return Item.fishRaw;


//        int i = MathHelper.floor_double(this.posX);
//        int j = MathHelper.floor_double(this.posY - 0.20000000298023224D);
//        int m = MathHelper.floor_double(this.posZ);
//        long count = 0L;
//        Item[] fishTypeListStage0 = {Item.appleRed, Item.potato, Item.banana, Item.bread, Item.carrot, Item.orange};
//        Item[] fishTypeListStage1 = {Item.copperNugget, Item.silverNugget, Item.goldNugget, Item.ironNugget};
//        Item[] fishTypeListStage2 = {Item.mithrilNugget, Item.ancientMetalNugget, Item.adamantiumNugget};
//        for (int k = -16; k <= 16; k++) {
//            for (int dz = -16; dz <= 16; dz++) {
//                for (int dy = -3; dy <= 0; dy++) {
//                    Block block = this.worldObj.getBlock(i + k, j + dy, m + dz);
//                    if (block == Block.dirt || block == Block.grass || block == Block.sand)
//                        count++;
//                }
//            }
//        }
//        if (this.worldObj.getBiomeGenForCoords(i, m) == BiomeGenBase.ocean && count == 0L && this.rand.nextInt(3) == 0)
//            return Item.fishLargeRaw;
//        if (this.rand.nextInt(3) == 0) {
//            if (this.rand.nextInt(2) == 0)
//                return fishTypeListStage0[this.rand.nextInt(6)];
//            if (this.rand.nextInt(2) == 0)
//                return fishTypeListStage1[this.rand.nextInt(4)];
//            if (this.rand.nextInt(2) == 0)
//                return fishTypeListStage2[this.rand.nextInt(3)];
//        }
//        return Item.fishRaw;
    }
}
