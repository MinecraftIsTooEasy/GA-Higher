package com.github.Debris.GAHigher.trans.entity.misc;

import com.github.Debris.GAHigher.api.GAEntityItem;
import com.github.Debris.GAHigher.item.Items;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityItem.class})
public abstract class EntityItemTrans extends Entity implements GAEntityItem {

    public EntityItemTrans(World par1World) {
        super(par1World);
    }

    @Shadow
    protected abstract boolean canTriggerWalking();

    @Shadow
    public abstract ItemStack getEntityItem();

    @Inject(method = "onUpdate", at = @At("RETURN"))
    private void removeIllegal(CallbackInfo ci) {
        if (!this.isDead && this.onServer()) {
            ItemStack entityItem = this.getEntityItem();
            if (entityItem != null && entityItem.getItem() == Items.lavaInPipes) {
                this.setDead();
            }
        }
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
