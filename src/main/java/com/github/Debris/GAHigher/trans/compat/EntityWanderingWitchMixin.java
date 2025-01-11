package com.github.Debris.GAHigher.trans.compat;

import com.github.Debris.GAHigher.api.GABat;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.EntityBat;
import net.xiaoyu233.mitemod.miteite.entity.EntityWanderingWitch;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EntityWanderingWitch.class)
public class EntityWanderingWitchMixin {
    @WrapOperation(method = "summonWolvesITE", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityBat;setSpawnedByWitch(ZLnet/xiaoyu233/mitemod/miteite/entity/EntityWanderingWitch;)V"))
    private void onBatSpawn(EntityBat instance, boolean b, EntityWanderingWitch entityWanderingWitch, Operation<Void> original) {
        original.call(instance, b, entityWanderingWitch);
        ((GABat) instance).markSpawnedByWitch();
    }
}
