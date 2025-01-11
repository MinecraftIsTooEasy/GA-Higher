package com.github.Debris.GAHigher.entity;

import com.github.Debris.GAHigher.api.GAWorld;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.item.enchantment.Enchantments;
import net.minecraft.*;

public class EntityExchanger extends EntitySkeleton {
    private int teleportDelay;

    public EntityExchanger(World par1World) {
        super(par1World);
    }

    protected void addRandomEquipment() {
        setCurrentItemOrArmor(0, (new ItemStack(Items.enderPearl, 1)).randomizeForMob(this, false));
    }

    protected void applyEntityAttributes() {
        double rate;
        super.applyEntityAttributes();
        int day = ((GAWorld) getWorld()).getDayOfOverworld();
        if (day > 32) {
            rate = day / 16.0D;
        } else {
            rate = (day / 16);
        }
        setEntityAttribute(SharedMonsterAttributes.attackDamage, 2.0D + rate * 3.0D);
        setEntityAttribute(SharedMonsterAttributes.maxHealth, 10.0D + rate * 10.0D);
        setEntityAttribute(SharedMonsterAttributes.movementSpeed, 0.2572D);
    }

    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player) {
            int count = 3;
            for (int i1 = 0; i1 < count; i1++)
                dropItem(Item.arrowIron);
        }
    }

    protected EntityPlayer findPlayerToAttack(float max_distance) {
        EntityPlayer player = getClosestVulnerablePlayer(max_distance);
        return player;
    }

    public boolean canCatchFire() {
        return false;
    }

    public void exchangeSkill() {
        EntityPlayer target = (EntityPlayer) getEntityToAttack();
        if (target != null) {
            double entiX = target.posX;
            double entiY = target.posY;
            double entiZ = target.posZ;
            double currentX = this.posX;
            double currentY = this.posY;
            double currentZ = this.posZ;
            teleportToTarget(entiX, entiY, entiZ);
            target.setPositionAndUpdate(currentX, currentY, currentZ);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (!(getWorld()).isRemote) {
            for (int var6 = 0; var6 < 2; var6++)
                this.worldObj.spawnParticle(EnumParticle.portal_underworld, this.posX + (this.rand.nextDouble() - 0.5D) * this.width, this.posY + this.rand.nextDouble() * this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            if (this.entityToAttack == null) {
                this.entityToAttack = getClosestVulnerablePlayer(32.0D);
                if (this.entityToAttack instanceof EntityPlayer) {
                    ((EntityPlayer) this.entityToAttack).sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[转移骷髅] ").setColor(EnumChatFormatting.BLUE).appendComponent(ChatMessageComponent.createFromTranslationKey("你已被注视，3S后转移").setColor(EnumChatFormatting.RED)));
                } this.teleportDelay = 0;
            } else {
                if (this.entityToAttack.isDead || getDistanceToEntity(this.entityToAttack) > 32.0F) {
                    if (this.entityToAttack instanceof EntityPlayer)
                        ((EntityPlayer) this.entityToAttack).sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[转移骷髅] ").setColor(EnumChatFormatting.BLUE).appendComponent(ChatMessageComponent.createFromTranslationKey("已放弃注视").setColor(EnumChatFormatting.GREEN)));
                    this.entityToAttack = null;
                    return;
                }
                if (this.entityToAttack instanceof EntityPlayer) {
                    ItemStack[] var3 = ((EntityPlayer) this.entityToAttack).getWornItems();
                    for (ItemStack wornItem : var3) {
                        if (wornItem != null && wornItem.hasEnchantment(Enchantments.STABLE, false))
                            return;
                    }
                    if (this.teleportDelay < 70 && ++this.teleportDelay > 60) {
                        exchangeSkill();
                        this.teleportDelay = 70;
                    }
                }
            }
        }
    }

    public void teleportToTarget(double par1, double par3, double par5) {
        double var7 = this.posX;
        double var9 = this.posY;
        double var11 = this.posZ;
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        setPositionAndUpdate(this.posX, this.posY, this.posZ);
        int x = MathHelper.floor_double(this.posX);
        int y = MathHelper.floor_double(this.posY);
        int z = MathHelper.floor_double(this.posZ);
        double distance = World.getDistanceFromDeltas(this.posX - var7, this.posY - var9, this.posZ - var11);
        this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y, z, (new SignalData()).setByte(EnumParticle.portal_underworld.ordinal()).setShort((int) (8.0D * distance)).setApproxPosition(MathHelper.floor_double(var7), MathHelper.floor_double(var9), MathHelper.floor_double(var11)));
        this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y + 1, z, (new SignalData()).setByte(EnumParticle.portal_underworld.ordinal()).setShort((int) (8.0D * distance)).setApproxPosition(MathHelper.floor_double(var7), MathHelper.floor_double(var9 + 1.0D), MathHelper.floor_double(var11)));
        this.worldObj.playSoundEffect(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
    }
}
