package com.github.debris.gah.trans.entity.mob;

import com.github.debris.gah.item.Items;
import net.minecraft.DamageSource;
import net.minecraft.EntityMob;
import net.minecraft.EntityWither;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityWither.class)
public abstract class EntityWitherMixin extends EntityMob {
    public EntityWitherMixin(World par1World) {
        super(par1World);
    }

    @Inject(method = "dropFewItems", at = @At("RETURN"))
    private void addLoot(boolean recently_hit_by_player, DamageSource damage_source, CallbackInfo ci) {
        this.dropItem(Items.Wither_Medal);
    }
}
