package com.github.debris.gah.entity;

import net.minecraft.*;

public class EntityTomato_Bad extends EntityThrowable {
    private Item item;

    public EntityTomato_Bad(World world, Item item) {
        super(world);
        this.item = item;
    }

    public EntityTomato_Bad(World world, EntityLivingBase thrower, Item item) {
        super(world, thrower);
        this.item = item;
    }

    public EntityTomato_Bad(World world, double pos_x, double pos_y, double pos_z, Item item) {
        super(world, pos_x, pos_y, pos_z);
        this.item = item;
    }

//    protected float e() {
//        return 0.07F;
//    }

    protected void onImpact(RaycastCollision rc) {
//        if (rc.isEntity())
//            rc.getEntityHit().attackEntityFrom(new Damage(DamageSource.a((Entity) this, (Entity) h()), 3.0F));
//        if (onServer() && rc.isBlock())
//            if (rc.getBlockHit() == Block.bv) {
//                this.q.destroyBlock(new BlockBreakInfo(this.q, rc.block_hit_x, rc.block_hit_y, rc.block_hit_z), true);
//            } else {
//                rc.getBlockHit().a(this.q, rc.block_hit_x, rc.block_hit_y, rc.block_hit_z, (Entity) this);
//            }
//        for (int var5 = 0; var5 < 8; var5++)
//            this.q.spawnParticle((this.item == Item.ca) ? EnumParticle.brickpoof_netherrack : EnumParticle.brickpoof, this.u, this.v, this.w, 0.0D, 0.0D, 0.0D);
//        if (!this.q.I)
//            x();
    }

    public Item getModelItem() {
        return this.item;
    }
}