package com.github.debris.gah.trans.block;

import com.github.debris.gah.api.GAEntityPlayer;
import com.github.debris.gah.config.Configs;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.util.Constant;
import com.github.debris.gah.util.PickaxeHelper;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockStone.class, priority = 999)
public class BlockStoneTrans extends Block {

    protected BlockStoneTrans(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void setSize(int par1, CallbackInfo ci) {
        this.setMaxStackSize(64);
    }

    @WrapOperation(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockStone;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;Lnet/minecraft/Block;)I"))
    public int dropBlockAsEntityItem(BlockStone instance, BlockBreakInfo info, Block block, Operation<Integer> original) {
        EntityPlayer MMPlayer = null;
        try {
            MMPlayer = info.getHarvester().getAsEntityPlayerMP();
        } catch (Exception var18) {
            var18.printStackTrace();
        }
        if (!info.wasExploded() && MMPlayer != null) {
            int II = 0;
            int count = 0;
            int nowDamage = 0;
            int maxDamage = 0;
            try {
                II = (info.getHarvesterItem()).itemID;
                nowDamage = info.getHarvesterItemStack().getItemDamage();
                maxDamage = info.getHarvesterItemStack().getMaxDamage();
            } catch (Exception var17) {
                var17.printStackTrace();
            }
            if (nowDamage < 0.9D * maxDamage || !PickaxeHelper.isPreciousPickaxe(II)) {
                boolean highEnough = info.y >= MathHelper.floor_double(MMPlayer.posY - MMPlayer.yOffset);

                if (highEnough) {
                    count = PickaxeHelper.performPickaxe(MMPlayer, info, II, count);
                }

                int M1;
                for (M1 = 0; M1 <= count; M1++) {
                    if (Constant.GARandom.nextInt(100) == 0) {
                        if (Configs.wenscConfig.isDropBlueGem.ConfigValue) {
                            MMPlayer.dropItem(Items.Gem_Blue, 1);
                            MMPlayer.addExperience(100, true, true);
                        }
                        count--;
                    }
                }
                if (count > 0) {
                    M1 = Constant.GARandom.nextInt(100);
                    int M2 = Constant.GARandom.nextInt(80);
                    if (M1 == 0)
                        MMPlayer.addChatMessage("a_pickaxe.msg." + M2);
                    MMPlayer.tryDamageHeldItem(DamageSource.generic, count * 240);
                    GAEntityPlayer.getStoneCountManager(MMPlayer).addStoneCount(count);
                    MMPlayer.addExperience(count, true, true);
                }
            } else {
                MMPlayer.getWorld().playSoundAtEntity(MMPlayer, "imported.random.level_drain", 1.0F);
                MMPlayer.addChatMessage("a_pickaxe.msg.repair");
            }
        }
        if (Configs.wenscConfig.isDropBlueGem.ConfigValue && Configs.wenscConfig.isDropGAStones.ConfigValue) {
            if (Constant.GARandom.nextInt(100) == 0)
                return dropBlockAsEntityItem(info, Items.Gem_Blue.itemID);
            else return dropBlockAsEntityItem(info, Items.Stones.itemID);
        }
        if (Configs.wenscConfig.isDropBlueGem.ConfigValue) {
            if (Constant.GARandom.nextInt(100) == 0) {
                return dropBlockAsEntityItem(info, Items.Gem_Blue.itemID);
            }
        }
        if (Configs.wenscConfig.isDropGAStones.ConfigValue) {
            return dropBlockAsEntityItem(info, Items.Stones.itemID);
        }
        return original.call(instance, info, block);
    }
}
