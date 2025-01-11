package com.github.Debris.GAHigher.trans.util;

import com.github.Debris.GAHigher.item.enchantment.Enchantments;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.LinkedList;

@Mixin(ItemInWorldManager.class)
public abstract class ItemInWorldManagerMixin {

    @Shadow
    public ServerPlayer thisPlayerMP;

    @Shadow
    public abstract boolean tryHarvestBlock(int x, int y, int z);

    @Shadow
    public World theWorld;
    @Unique
    private boolean mining_in_progress;

    @Inject(method = "tryHarvestBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/Block;wood:Lnet/minecraft/BlockLog;", ordinal = 0))
    private void chain(int x, int y, int z, CallbackInfoReturnable<Boolean> cir, @Local Block block) {
        if (block instanceof net.minecraft.BlockOre && !this.mining_in_progress) {
            int mining = EnchantmentHelper.getEnchantmentLevel(Enchantments.CHAIN.effectId, this.thisPlayerMP.getHeldItemStack());
            this.mining_in_progress = true;
            startMining(this.theWorld, x, y, z, mining);
            this.mining_in_progress = false;
        }
//        if ((block instanceof net.minecraft.BlockStone || (block instanceof net.minecraft.BlockNetherrack && !this.mining_in_progress)) &&
//                this.thisPlayerMP.getHeldItem() instanceof ItemEnhancedPickaxe) {
//            int tier = ((ItemEnhancedPickaxe)this.thisPlayerMP.getHeldItem()).tier;
//            this.mining_in_progress = true;
//            crackStone(this.theWorld, x, y, z, tier);
//            this.mining_in_progress = false;
//        }
    }

    @Unique
    private void startMining(World world, int pos_x, int pos_y, int pos_z, int chaining) {
        boolean hasNest = true;
        LinkedList<int[]> hint = new LinkedList<>();
        hint.addLast(new int[]{0, 0, 0});
        while (hasNest) {
            int[] start = hint.getFirst();
            for (int y = start[1] + 1; y >= start[1] - 1; y--) {
                for (int x = start[0] - 1; x <= start[0] + 1; x++) {
                    for (int z = start[2] - 1; z <= start[2] + 1; z++) {
                        int[] next = {x, y, z};
                        boolean isOre = world.getBlock(pos_x + x, pos_y + y, pos_z + z) instanceof net.minecraft.BlockOre;
                        isOre = (isOre || world.getBlock(pos_x + x, pos_y + y, pos_z + z) instanceof net.minecraft.BlockRedstoneOre);
                        if (!hint.contains(next) && chaining >= 1 && isOre) {
                            hint.addLast(next);
                            this.tryHarvestBlock(pos_x + x, pos_y + y, pos_z + z);
                            chaining--;
                        }
                    }
                }
            }
            hint.removeFirst();
            if (hint.isEmpty())
                hasNest = false;
        }
    }
}
