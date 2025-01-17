package com.github.Debris.GAHigher.entity;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.api.GAWorld;
import com.github.Debris.GAHigher.enums.Achievements;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.item.enchantment.Enchantments;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;
import net.minecraft.server.MinecraftServer;
import net.xiaoyu233.mitemod.miteite.api.ITEEnchantment;

import java.util.*;

import static net.xiaoyu233.mitemod.miteite.item.Items.*;
import static net.xiaoyu233.mitemod.miteite.item.enchantment.Enchantments.*;

public class EntityZombieBoss extends EntityZombie implements IBossDisplayData {
    private final Enchantment[] enhanceSpecialBookList = new Enchantment[]{
            Enchantment.protection, Enchantment.fireProtection, Enchantment.projectileProtection, Enchantment.blastProtection, Enchantment.sharpness, Enchantment.smite, Enchantment.baneOfArthropods, Enchantment.fireAspect, Enchantment.looting, Enchantment.knockback,
            Enchantment.fortune, Enchantment.harvesting, Enchantment.efficiency, Enchantment.unbreaking, Enchantment.power, Enchantment.punch, Enchantment.vampiric, Enchantment.butchering, Enchantment.featherFalling, Enchantment.arrow_recovery,
            Enchantment.fishing_fortune, Enchantment.stun, Enchantment.fertility, Enchantment.tree_felling, Enchantment.speed, Enchantment.regeneration, Enchantment.free_action, Enchantment.true_flight, Enchantment.quickness, Enchantment.aquaAffinity,
            Enchantment.poison, Enchantment.disarming, Enchantment.butchering, Enchantment.piercing, Enchantment.endurance, CRIT, EXTEND, CONQUEROR, Enchantments.CHAIN};

    private final Enchantment[] nonLevelsBookList = new Enchantment[]{Enchantments.STABLE, EMERGENCY, Enchantment.flame, Enchantment.respiration};

    private int thunderTick = 0;

    private int attackedCounter = 200;

    public Map<String, Float> attackDamageMap = new HashMap<>();

    public EntityZombieBoss(World par1World) {
        super(par1World);
    }

    protected void addRandomEquipment() {
        setCurrentItemOrArmor(0, (new ItemStack(VIBRANIUM_WAR_HAMMER, 1)).randomizeForMob(this, true));
        setCurrentItemOrArmor(1, (new ItemStack(VIBRANIUM_HELMET, 1)).randomizeForMob(this, true));
        setCurrentItemOrArmor(2, (new ItemStack(VIBRANIUM_CHESTPLATE, 1)).randomizeForMob(this, true));
        setCurrentItemOrArmor(3, (new ItemStack(VIBRANIUM_LEGGINGS, 1)).randomizeForMob(this, true));
        setCurrentItemOrArmor(4, (new ItemStack(VIBRANIUM_BOOTS, 1)).randomizeForMob(this, true));
    }

    public void addPotionEffect(PotionEffect par1PotionEffect) {
        if (par1PotionEffect.getPotionID() == 1 || par1PotionEffect.getPotionID() == 5)
            super.addPotionEffect(par1PotionEffect);
    }

    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player) {
//            dropItem(Items.gemBlue);
            broadcastDamage("僵尸BOSS挑战成功");
            MinecraftServer server = MinecraftServer.getServer();
            Iterator var4 = (server.getConfigurationManager()).playerEntityList.iterator();
            Item[] drops = {Item.netherQuartz, Item.netherQuartz, Item.emerald, Item.emerald, Item.diamond, Item.blazePowder, Item.ghastTear};
//            Item[] final_drops = {Item.diamond, Item.diamond, Item.diamond, Item.diamond, Item.diamond, Items.fancyRed, Items.fancyRed};
            Item[] final_drops = {Item.diamond, Item.diamond, Item.diamond, Item.diamond, Item.diamond};
            while (var4.hasNext()) {
                Object o = var4.next();
                EntityPlayer player = (EntityPlayer) o;
                if (this.attackDamageMap.containsKey(player.getEntityName())) {
                    float damage = this.attackDamageMap.get(player.getEntityName()).floatValue();
                    int nums = Math.round(damage) / 25;
                    while (nums-- > 0) {
                        player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(drops[this.rand.nextInt(drops.length)], 1));
                        if (isFinal()) {
                            player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(final_drops[this.rand.nextInt(final_drops.length)], 1));
                            player.triggerAchievement(Achievements.killZombieBoss);
                        }
                    }
                }
            }
            Enchantment dropEnchantment = this.nonLevelsBookList[this.rand.nextInt(this.nonLevelsBookList.length)];
            ItemStack stack = Item.enchantedBook.getEnchantedItemStack(new EnchantmentData(dropEnchantment, ((ITEEnchantment) dropEnchantment).getNumLevelsForVibranium()));
            if (this.rand.nextInt(4) == 0) {
                dropItemStack(stack);
                if (!isFinal())
                    return;
            }
            dropEnchantment = this.enhanceSpecialBookList[this.rand.nextInt(this.enhanceSpecialBookList.length)];
            stack = Item.enchantedBook.getEnchantedItemStack(new EnchantmentData(dropEnchantment, ((ITEEnchantment) dropEnchantment).getNumLevelsForVibranium()));
            dropItemStack(stack);

            this.dropItem(Items.jewelries[this.rand.nextInt(Items.jewelries.length)]);
            if (!isFinal()) {
                dropItem(Items.cracked_key);
//                dropItemStack(new ItemStack((Item) Items.itemEnhanceGem3, 1, this.rand.nextInt((GemModifierTypes.values()).length)));
            }
//            else {
//                for (int i = 0; i < 3; i++)
//                    dropItem(Items.voucherCore);
//                dropItemStack(new ItemStack((Item) Items.itemEnhanceGem5, 1, this.rand.nextInt((GemModifierTypes.values()).length)));
//            }
        }
    }

    protected boolean isFinal() {
        return false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        int day = ((GAWorld) this.worldObj).getDayOfOverworld();
        setEntityAttribute(SharedMonsterAttributes.attackDamage, (15.0F * Constant.getBossMobModifier("Damage", day)));
        setEntityAttribute(SharedMonsterAttributes.maxHealth, (400.0F * Constant.getBossMobModifier("Health", day)));
        setEntityAttribute(SharedMonsterAttributes.movementSpeed, 0.3D);
    }

    @Override
    public void tryDamageArmor(DamageSource damage_source, float amount, EntityDamageResult result) {
    }

    public boolean isComfortableInLava() {
        return true;
    }

    public boolean getCanSpawnHere(boolean perform_light_check) {
        return true;
    }

    public boolean handleLavaMovement() {
        return false;
    }

    public boolean handleWaterMovement() {
        return false;
    }

    public boolean canBeDisarmed() {
        return false;
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isPushedByWater() {
        return false;
    }

    public boolean canNeverPickUpItem(Item item) {
        return true;
    }

    public boolean canBeKnockedBack() {
        return false;
    }

    public EntityDamageResult attackEntityFrom(Damage damage) {
        if ((damage.getSource()).damageType.equals("player") || (damage.getSource()).damageType.equals("mob")) {
            if (damage.getSource().getResponsibleEntity() instanceof EntityPlayer player) {
                player.removePotionEffect(Potion.damageBoost.id);
                ((GAEntityPlayer) player).ga$getBossManager().setBossResetDamageBoostCounter(200);
                this.attackedCounter = 200;
                damage.setAmount(damage.getAmount() * (isFinal() ? 0.3F : 0.75F));
                EntityDamageResult originDamage = super.attackEntityFrom(damage);
                try {
                    if (this.attackDamageMap.containsKey(player.getEntityName())) {
                        this.attackDamageMap.put(player.getEntityName(), Float.valueOf(this.attackDamageMap.get(player.getEntityName()).floatValue() + originDamage.getAmountOfHealthLost()));
                    } else {
                        this.attackDamageMap.put(player.getEntityName(), Float.valueOf(originDamage.getAmountOfHealthLost()));
                    }
                } catch (Exception e) {
                    Minecraft.setErrorMessage("BOSS伤害计算错误分析");
                    Minecraft.setErrorMessage(e.getMessage());
                }
                return originDamage;
            }
            return null;
        }
        return null;
    }

    public void broadcastDamage(String stateMessage) {
        MinecraftServer server = MinecraftServer.getServer();
        Iterator var4 = (server.getConfigurationManager()).playerEntityList.iterator();
        List<Map.Entry<String, Float>> list = new ArrayList<>(this.attackDamageMap.entrySet());
        Collections.sort(list, (e1, e2) -> (int) Math.floor((e2.getValue().floatValue() - e1.getValue().floatValue())));
        while (var4.hasNext()) {
            Object o = var4.next();
            EntityPlayer player = (EntityPlayer) o;
            for (int i = 0; i < Math.min(list.size(), 5); i++) {
                player.sendChatToPlayer(ChatMessageComponent.createFromText("--" + stateMessage + "-伤害排名--"));
                player.sendChatToPlayer(ChatMessageComponent.createFromText("第")
                        .appendComponent(ChatMessageComponent.createFromText("§6" + (i + 1)))
                        .appendComponent(ChatMessageComponent.createFromText("§r名: "))
                        .appendComponent(ChatMessageComponent.createFromText("§n" + ((Map.Entry) list.get(i)).getKey()))
                        .appendComponent(ChatMessageComponent.createFromText("§r - "))
                        .appendComponent(ChatMessageComponent.createFromText("§b" + String.format("%.2f", ((Map.Entry) list.get(i)).getValue()))).appendComponent(ChatMessageComponent.createFromText("§r点伤害")));
            }
        }
    }

    public EntityDamageResult attackEntityAsMob(Entity target) {
        if (target instanceof EntityPlayer player) {
            ((GAEntityPlayer) player).ga$getBossManager().setIsAttackByBossCounter(30);
        }
        return super.attackEntityAsMob(target);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("attackedCounter", (short) this.attackedCounter);
        par1NBTTagCompound.setShort("thunderTick", (short) this.thunderTick);
        NBTTagList nbtTagList = new NBTTagList();
        for (Map.Entry<String, Float> integerEntry : this.attackDamageMap.entrySet()) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("Attacker", integerEntry.getKey());
            compound.setFloat("Damage", integerEntry.getValue().floatValue());
            nbtTagList.appendTag(compound);
        }
        par1NBTTagCompound.setTag("AttackDamageMap", nbtTagList);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.attackedCounter = par1NBTTagCompound.getShort("attackedCounter");
        this.thunderTick = par1NBTTagCompound.getShort("thunderTick");
        if (par1NBTTagCompound.hasKey("AttackDamageMap")) {
            NBTTagList attackCountMap = par1NBTTagCompound.getTagList("AttackDamageMap");
            int count = attackCountMap.tagCount();
            for (int i = 0; i < count; i++) {
                NBTTagCompound a = (NBTTagCompound) attackCountMap.tagAt(i);
                this.attackDamageMap.put(a.getString("Attacker"), Float.valueOf(a.getFloat("Damage")));
            }
        }
    }

    public boolean isImmuneTo(DamageSource damage_source) {
        return (super.isImmuneTo(damage_source) && damage_source.isExplosion());
    }

    public void addThunderAttack(EntityPlayer player, float damage) {
        if (player != null) {
            WorldServer var20 = (WorldServer) this.worldObj;
            var20.addWeatherEffect(new EntityLightningBolt(var20, player.posX, player.posY, player.posZ));
            player.attackEntityFrom(new Damage(DamageSource.divine_lightning, damage));
        }
    }

    public boolean setSurroundingPlayersAsTarget() {
        setTarget(null);
        List<Entity> targets = getNearbyEntities(16.0F, 8.0F);
        if (!targets.isEmpty()) {
            int i = this.rand.nextInt(targets.size());
            if (targets.get(i) instanceof EntityPlayer player) {
                setRevengeTarget(player);
                return true;
            }
        }
        return false;
    }

    public boolean shockSurroundingPlayers() {
        boolean succeed = false;
        List<Entity> targets = getNearbyEntities(16.0F, 8.0F);
        for (int i = 0; i < targets.size(); i++) {
            if (targets.get(i) instanceof EntityPlayer player) {
                addThunderAttack(player, 4.0F);
                succeed = true;
            }
        }
        return succeed;
    }

    public void healAndBroadcast() {
        if (getHealth() < getMaxHealth()) {
            heal(getMaxHealth());
            broadcastDamage("僵尸BOSS挑战失败");
            this.attackDamageMap.clear();
        }
        if (isFinal())
            setDead();
    }

    public void enhance() {
        EntityZombieBoss entityZombieBoss = new EntityFinalZombieBoss(this.worldObj);
        entityZombieBoss.setPosition(this.posX, this.posY, this.posZ);
        entityZombieBoss.refreshDespawnCounter(-9600);
        entityZombieBoss.setAttackTarget(getTarget());
        entityZombieBoss.entityFX(EnumEntityFX.summoned);
        entityZombieBoss.onSpawnWithEgg(null);
        this.worldObj.spawnEntityInWorld(entityZombieBoss);
        setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        if (!(getWorld()).isRemote) {
            this.thunderTick++;
            if (this.attackedCounter <= 0) {
                healAndBroadcast();
            } else {
                this.attackedCounter--;
            }
            EntityLivingBase target = getTarget();
            if (!(target instanceof EntityPlayer))
                healAndBroadcast();
            if (this.thunderTick % 40 == 0) {
                if (target != null && target instanceof EntityPlayer player && (((GAEntityPlayer) player)).ga$getBossManager().canBeAttacked())
                    if (isFinal()) {
                        double currentX = this.posX;
                        double currentY = this.posY;
                        double currentZ = this.posZ;
                        target.setPositionAndUpdate(currentX, currentY, currentZ);
                        target.worldObj.createExplosion(this, currentX, currentY + (this.height / 4.0F), currentZ, 0.0F, 2.75F, true);
                    } else {
                        addThunderAttack((EntityPlayer) target, 6.0F);
                    }
                if (this.thunderTick == 60) {
                    if (isFinal())
                        shockSurroundingPlayers();
                    setSurroundingPlayersAsTarget();
                    this.thunderTick = 0;
                }
            }
        }
    }
}
