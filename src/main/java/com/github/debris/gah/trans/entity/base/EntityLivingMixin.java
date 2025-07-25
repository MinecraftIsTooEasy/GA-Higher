package com.github.debris.gah.trans.entity.base;

import com.github.debris.gah.event.Hooks;
import net.minecraft.DamageSource;
import net.minecraft.EntityLiving;
import net.minecraft.EntityLivingBase;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLiving.class)
public abstract class EntityLivingMixin extends EntityLivingBase {
    public EntityLivingMixin(World par1World) {
        super(par1World);
    }

    @Inject(method = "dropFewItems", at = @At("RETURN"))
    private void dropDrugYD(boolean recently_hit_by_player, DamageSource damage_source, CallbackInfo ci) {
        Hooks.onMobDrop((EntityLiving) (Object) this, recently_hit_by_player, damage_source);
    }
}
