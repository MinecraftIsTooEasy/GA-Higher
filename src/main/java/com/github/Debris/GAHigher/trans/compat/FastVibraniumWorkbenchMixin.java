package com.github.Debris.GAHigher.trans.compat;

import com.github.Debris.GAHigher.api.Condition;
import com.github.Debris.GAHigher.api.ConditionalMixin;
import com.github.Debris.GAHigher.compat.ModCompat;
import net.minecraft.ClientPlayer;
import net.minecraft.Container;
import net.minecraft.ContainerWorkbench;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.xiaoyu233.mitemod.miteite.block.Blocks.vibraniumWorkBench;

@ConditionalMixin(require = @Condition(value = ModCompat.ITE))
@Mixin(ClientPlayer.class)
public class FastVibraniumWorkbenchMixin {
    @Inject(method = "getBenchAndToolsModifier", at = @At(value = "INVOKE", target = "Lnet/minecraft/ContainerWorkbench;getSlot(I)Lnet/minecraft/Slot;"), cancellable = true)
    private void makeFast(Container container, CallbackInfoReturnable<Float> cir) {
        ContainerWorkbench workbench = (ContainerWorkbench) container;
        if (workbench.world.getBlock(workbench.x, workbench.y, workbench.z) == vibraniumWorkBench) {
            cir.setReturnValue(Float.MAX_VALUE);
        }
    }
}
