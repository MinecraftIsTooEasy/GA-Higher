package com.github.Debris.GAHigher.entity.player;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.enums.RingKillerImmune;
import com.github.Debris.GAHigher.item.ItemRingKiller;
import com.github.Debris.GAHigher.item.jewelry.ItemJewelry;
import com.github.Debris.GAHigher.screen.inventory.InventoryJewelry;
import net.minecraft.*;

import java.util.List;

public class JewelryManager extends AbstractManager {

    ItemStack itemRingKiller;


    private int surroundHurtCollDown = 20;

    public JewelryManager(EntityPlayer player) {
        super(player);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void tick() {
        InventoryJewelry inventoryJewelry = ((GAEntityPlayer) this.player).getInventoryJewelry();
//        this.itemRingKiller = ((GAInventoryPlayer) this.player.inventory).getRingKiller();
        this.itemRingKiller = inventoryJewelry.getRingKiller();
        if (this.itemRingKiller != null) {
            float range = ((ItemRingKiller) this.itemRingKiller.getItem()).getRingKillerSkillRange();
            int cooldownTime = ((ItemRingKiller) this.itemRingKiller.getItem()).getRingKillerSkillCoolDownTime();
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
        inventoryJewelry.getJewelry().forEach(x -> ((ItemJewelry) x.getItem()).onTick(x, this.player.getAsEntityPlayerMP()));
    }

    @Override
    public void write(NBTTagCompound nbtTagCompound) {
        super.write(nbtTagCompound);
    }

    @Override
    public void read(NBTTagCompound nbtTagCompound) {
        super.read(nbtTagCompound);
    }


    public void attackMonsters(List<Entity> targets) {
        float damage = ((ItemRingKiller) this.itemRingKiller.getItem()).getRingKillerSkillDamage();
        for (Entity entity : targets) {
            if (RingKillerImmune.shouldApply(entity)) {
                entity.attackEntityFrom(new Damage(DamageSource.causePlayerDamage(this.player), damage));
            }
        }
    }
}
