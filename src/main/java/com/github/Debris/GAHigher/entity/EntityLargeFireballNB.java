package com.github.Debris.GAHigher.entity;

import net.minecraft.*;

public class EntityLargeFireballNB extends EntityLargeFireball {
    public EntityLargeFireballNB(World world, EntityLivingBase shooter, Vec3 target, float initial_distance) {
        super(world, shooter, target, initial_distance);
    }

    protected void onImpact(RaycastCollision rc) {
        if (!this.worldObj.isRemote) {
            if (rc.isEntity())
                rc.getEntityHit().attackEntityFrom(new Damage(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0F));
            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, this.field_92057_e, this.field_92057_e, true, getWorld().isTheNether());
            setDead();
        }
    }
}
