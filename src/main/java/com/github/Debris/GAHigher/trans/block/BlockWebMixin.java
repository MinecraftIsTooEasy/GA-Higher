package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.api.Condition;
import com.github.Debris.GAHigher.api.ConditionalMixin;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.entity.EntityZombieBoss;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@ConditionalMixin(require = @Condition(value = ModCompat.ITE))
@Mixin(BlockWeb.class)
public abstract class BlockWebMixin extends Block {
    protected BlockWebMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @WrapWithCondition(method = "onEntityCollidedWithBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/Entity;setInWeb()V"))
    private boolean wrap(Entity instance) {
        if (instance instanceof EntityZombieBoss) return false;
        return true;
    }
}
