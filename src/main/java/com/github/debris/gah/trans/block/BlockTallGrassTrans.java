package com.github.debris.gah.trans.block;

import com.github.debris.gah.util.Constant;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockTallGrass.class)
public class BlockTallGrassTrans extends BlockPlant {
    protected BlockTallGrassTrans(int id) {
        super(id, Material.grass);
        float size = 0.4F;
        setBlockBoundsForAllThreads((0.5F - size), 0.0D, (0.5F - size), (0.5F + size), 0.800000011920929D, (0.5F + size));
    }

    @WrapOperation(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockTallGrass;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I"))
    private int modifyLoot(BlockTallGrass instance, BlockBreakInfo info, int blockId, int subType, int quantity, float chance, Operation<Integer> original) {
        int check = Constant.GARandom.nextInt(100);
        ServerPlayer serverPlayer = info.getResponsiblePlayer().getAsEntityPlayerMP();
        if (check == 0 || check == 1) {
            blockId = Item.pumpkinSeeds.itemID;
        }
        if (check == 3 && serverPlayer.hasFullHealth()) {
            serverPlayer.setHealth(serverPlayer.getHealthLimit() - 1.0F, true, null);
            serverPlayer.getWorld().playSoundAtEntity(serverPlayer, "imported.random.level_drain", 1.0F);
            serverPlayer.addChatMessage("grass.snake.msg");
        }
        chance = 1.0F;
        return original.call(instance, info, blockId, subType, quantity, chance);
    }
}
