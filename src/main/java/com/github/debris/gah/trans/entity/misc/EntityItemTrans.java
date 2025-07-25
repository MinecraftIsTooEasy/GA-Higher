package com.github.debris.gah.trans.entity.misc;

import com.github.debris.gah.api.GAEntityItem;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.Entity;
import net.minecraft.EntityItem;
import net.minecraft.EntityPlayer;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EntityItem.class)
public abstract class EntityItemTrans extends Entity implements GAEntityItem {
    public EntityItemTrans(World par1World) {
        super(par1World);
    }

    @Unique
    private boolean attractedByMagnet;

    @Override
    public void setAttractedByMagnet() {
        this.attractedByMagnet = true;
    }

    @WrapOperation(method = "onCollideWithPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityPlayer;getFootPosY()D"))
    private double forceSuccess(EntityPlayer instance, Operation<Double> original) {
        if (this.attractedByMagnet) return this.posY;
        return original.call(instance);
    }
}
