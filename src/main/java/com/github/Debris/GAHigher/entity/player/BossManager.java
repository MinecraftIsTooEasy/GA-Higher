package com.github.Debris.GAHigher.entity.player;

import net.minecraft.EntityPlayer;
import net.minecraft.NBTTagCompound;
import net.minecraft.Potion;

public class BossManager extends AbstractManager {
    private int bossResetDamageBoostCounter;

    private int isAttackByBossCounter;

    public BossManager(EntityPlayer player) {
        super(player);
    }

    public void setBossResetDamageBoostCounter(int bossResetDamageBoostCounter) {
        this.bossResetDamageBoostCounter = bossResetDamageBoostCounter;
    }

    public void setIsAttackByBossCounter(int isAttackByBossCounter) {
        this.isAttackByBossCounter = isAttackByBossCounter;
    }

    public boolean canBeAttacked() {
        return this.isAttackByBossCounter <= 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void tick() {
//        ItemStack cuirass = this.player.getCuirass();
//        if (cuirass != null) {
//            int bulldozeLvl = (int) ArmorModifierTypes.BULLDOZE.getModifierValue(cuirass.stackTagCompound);
//            float range = (bulldozeLvl * 3);
//            List<Entity> targets = this.player.getNearbyEntities(range, range);
//            for (Entity target : targets) {
//                EntityLivingBase entityMonster = (target instanceof EntityMob || target instanceof EntityBat) ? (EntityLivingBase) target : null;
//                if (entityMonster != null && !(entityMonster instanceof EntityZombieBoss)) {
//                    entityMonster.addPotionEffect(new PotionEffect(Potion.weakness.id, 20, 1, true));
//                }
//            }
//        }
        if (this.isAttackByBossCounter > 0) {
            this.isAttackByBossCounter--;
        }
        if (this.bossResetDamageBoostCounter > 0) {
            this.bossResetDamageBoostCounter--;
            this.player.removePotionEffect(Potion.damageBoost.id);
        }
    }

    @Override
    public void write(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setInteger("bossResetDamageBoostCounter", this.bossResetDamageBoostCounter);
        nbtTagCompound.setInteger("isAttackByBossCounter", this.isAttackByBossCounter);
    }

    @Override
    public void read(NBTTagCompound nbtTagCompound) {
        if (nbtTagCompound.hasKey("isAttackByBossCounter")) {
            this.isAttackByBossCounter = nbtTagCompound.getInteger("isAttackByBossCounter");
        }
        if (nbtTagCompound.hasKey("bossResetDamageBoostCounter"))
            this.bossResetDamageBoostCounter = nbtTagCompound.getInteger("bossResetDamageBoostCounter");
    }
}
