package com.github.Debris.GAHigher.trans.compat;

import com.github.Debris.GAHigher.api.Condition;
import com.github.Debris.GAHigher.api.ConditionalMixin;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.config.GAConfigManyLib;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.AbstractClientPlayer;
import net.minecraft.ClientPlayer;
import net.minecraft.ContainerWorkbench;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static net.xiaoyu233.mitemod.miteite.block.Blocks.vibraniumWorkBench;

@ConditionalMixin(require = @Condition(value = ModCompat.ITE))
@Mixin(ClientPlayer.class)
public abstract class FastVibraniumWorkbenchMixin extends AbstractClientPlayer {
    public FastVibraniumWorkbenchMixin(World par1World, String par2Str) {
        super(par1World, par2Str);
    }

    @ModifyReturnValue(method = "getCraftingPeriod", at = @At("RETURN"))
    private int makeFast(int original) {
        ContainerWorkbench workbench = (ContainerWorkbench) this.openContainer;
        if (workbench.world.getBlock(workbench.x, workbench.y, workbench.z) == vibraniumWorkBench) {
            return GAConfigManyLib.VibraniumWorkbenchSpeed.getIntegerValue();
        }
        return original;
    }
}
