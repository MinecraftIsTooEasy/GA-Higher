package com.github.Debris.GAHigher.trans.entity.base;

import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.BaublesUtil;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityLivingBase.class})
public abstract class EntityLivingBaseTrans extends Entity {
    public EntityLivingBaseTrans(World par1World) {
        super(par1World);
    }

    @Inject(method = "updateFallState", at = @At("HEAD"))
    private void refreshDoubleJump(double par1, boolean par3, CallbackInfo ci) {
        if (par3) {
            this.hasDoubleJumped = false;
        }
    }

    @Unique
    private boolean hasDoubleJumped = false;

    @ModifyExpressionValue(method = "onLivingUpdate", at = @At(value = "FIELD", target = "Lnet/minecraft/EntityLivingBase;onGround:Z"))
    private boolean forceJump(boolean original) {
        if (original) {
            this.jumpByCloud = false;
            return true;
        }
        if (!this.canDoubleJump()) return false;
        if (!this.hasDoubleJumped) {
            this.jumpByCloud = true;
            return true;
        }
        return false;
    }

    @Unique
    private boolean jumpByCloud = false;

    @Inject(method = "onLivingUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;jump()V"))
    private void mark(CallbackInfo ci) {
        if (this.jumpByCloud) {
            this.hasDoubleJumped = true;
        }
    }

    @Unique
    private boolean canDoubleJump() {
        return this.isEntityPlayer() && BaublesUtil.hasBaubleWorn(this.getAsPlayer(), Items.bottled_cloud);
    }
}
