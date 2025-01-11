package com.github.Debris.GAHigher.entity;

import com.github.Debris.GAHigher.api.GAWorld;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

public class EntityZombieDoor extends EntityZombie {
    private int spawnCounter;

    private int spawnSums;

    private boolean haveTryToSpawnExchanger = false;

    public EntityZombieDoor(World par1World) {
        super(par1World);
    }

    protected void addRandomEquipment() {
        int day = ((GAWorld) getWorld()).getDayOfOverworld();
        Item[] doorList = {Items.doorAdamantium, Items.doorWood, Items.doorGold, Items.doorSilver, Items.doorIron, Items.doorCopper, Items.doorGold};
        setCurrentItemOrArmor(0, (new ItemStack(doorList[Constant.GARandom.nextInt(doorList.length - 1)], 1)).randomizeForMob(this, false));
        addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2147483647, 0));
        if (day / 32 >= 1)
            addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2147483647, 0));
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
        setEntityAttribute(SharedMonsterAttributes.attackDamage, 4.0D + rate * 4.0D);
        setEntityAttribute(SharedMonsterAttributes.maxHealth, 10.0D + rate * 10.0D);
        setEntityAttribute(SharedMonsterAttributes.movementSpeed, 0.3D);
    }

    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player) {
            int day = ((GAWorld) getWorld()).getDayOfOverworld();
            int diamond_count = (day / 16 > 3) ? 3 : (day / 16);
            for (int i1 = 0; i1 < diamond_count; i1++)
                dropItem(Item.emerald);
        }
    }

    public boolean canCatchFire() {
        return false;
    }

    public void onUpdate() {
        super.onUpdate();
        if (!(getWorld()).isRemote) {
            EntityLivingBase target = getAttackTarget();
            if (target instanceof EntityPlayer) {
                if (this.spawnSums < 10)
                    if (this.spawnCounter < 200) {
                        this.spawnCounter++;
                    } else {
                        EntityZombie zombie = new EntityZombie(this.worldObj);
                        if (zombie.entityId == 207)
                            return;
                        zombie.setPosition(this.posX, this.posY, this.posZ);
                        zombie.refreshDespawnCounter(-9600);
                        this.worldObj.spawnEntityInWorld(zombie);
                        zombie.onSpawnWithEgg(null);
                        zombie.setAttackTarget(getTarget());
                        zombie.entityFX(EnumEntityFX.summoned);
                        this.spawnCounter = 0;
                        this.spawnSums++;
                    }
                if (!this.haveTryToSpawnExchanger) {
                    if (this.rand.nextInt(20) == 0) {
                        EntityExchanger entityExchanger = new EntityExchanger(this.worldObj);
                        entityExchanger.setPosition(this.posX, this.posY, this.posZ);
                        entityExchanger.refreshDespawnCounter(-9600);
                        this.worldObj.spawnEntityInWorld(entityExchanger);
                        entityExchanger.onSpawnWithEgg(null);
                        entityExchanger.setAttackTarget(getTarget());
                        entityExchanger.entityFX(EnumEntityFX.summoned);
                    }
                    this.haveTryToSpawnExchanger = true;
                }
            }
        }
    }
}
