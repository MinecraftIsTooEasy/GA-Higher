package com.github.Debris.GAHigher.entity.player;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.enums.RingKillerImmune;
import com.github.Debris.GAHigher.item.ItemRingKiller;
import com.github.Debris.GAHigher.item.jewelry.ItemJewelry;
import com.github.Debris.GAHigher.util.BaublesUtil;
import net.minecraft.Damage;
import net.minecraft.DamageSource;
import net.minecraft.Entity;
import net.minecraft.EntityPlayer;

import java.util.List;
import java.util.Optional;

public class JewelryManager extends AbstractManager {
    ItemRingKiller itemRingKiller;

    private int surroundHurtCollDown = 20;

    public JewelryManager(EntityPlayer player) {
        super(player);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void tick() {
        Optional<ItemRingKiller> optional = BaublesUtil.getBestRingKiller(this.player);
        this.itemRingKiller = optional.orElse(null);
        if (this.itemRingKiller != null) {
            float range = this.itemRingKiller.getRingKillerSkillRange();
            int cooldownTime = this.itemRingKiller.getRingKillerSkillCoolDownTime();
            List<Entity> targets = this.player.getNearbyEntities(range, range);
            if (targets.size() > 0) {
                if (this.surroundHurtCollDown == cooldownTime) {
                    attackMonsters(targets);
                    this.surroundHurtCollDown--;
                } else {
                    this.surroundHurtCollDown--;
                    if (this.surroundHurtCollDown <= 0)
                        this.surroundHurtCollDown = cooldownTime;
                }
            } else if (this.surroundHurtCollDown < cooldownTime) {
                this.surroundHurtCollDown--;
                if (this.surroundHurtCollDown <= 0)
                    this.surroundHurtCollDown = cooldownTime;
            }
        }
        GAEntityPlayer.getInventoryJewelry(this.player).getJewelry().forEach(x -> ((ItemJewelry) x.getItem()).onTick(x, this.player.getAsEntityPlayerMP()));
    }

    public void attackMonsters(List<Entity> targets) {
        float damage = this.itemRingKiller.getRingKillerSkillDamage();
        for (Entity entity : targets) {
            if (RingKillerImmune.shouldApply(entity)) {
                entity.attackEntityFrom(new Damage(DamageSource.causePlayerDamage(this.player), damage));
            }
        }
    }
}
