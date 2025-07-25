package com.github.debris.gah.trans.compat;

import com.github.debris.gah.compat.ModCompat;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static net.xiaoyu233.mitemod.miteite.block.MITEITEBlockRegistryInit.vibraniumWorkBench;

@Restriction(require = @Condition(value = ModCompat.ITE))
@Mixin(SlotCrafting.class)
public abstract class FastVibraniumWorkbenchMixin extends Slot {
    public FastVibraniumWorkbenchMixin(IInventory inventory, int slot_index, int display_x, int display_y) {
        super(inventory, slot_index, display_x, display_y);
    }

    @ModifyExpressionValue(method = "updatePlayerCrafting", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityClientPlayerMP;getCraftingPeriod(F)I"))
    private int makeFast(int original) {
        Container container = this.getContainer();
        if (container instanceof ContainerWorkbench workbench) {
            if (workbench.world.getBlock(workbench.x, workbench.y, workbench.z) == vibraniumWorkBench) {
                return Math.min(original, 25);
            }
        }
        return original;
    }
}
