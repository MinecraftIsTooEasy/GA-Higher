package com.github.Debris.GAHigher.entity;

import com.github.Debris.GAHigher.api.GAWorld;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.Enchantment;
import net.minecraft.ItemStack;
import net.minecraft.SharedMonsterAttributes;
import net.minecraft.World;

import static net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit.*;

public class EntityFinalZombieBoss extends EntityZombieBoss {
    public EntityFinalZombieBoss(World par1World) {
        super(par1World);
    }

    @Override
    protected void addRandomEquipment() {
        ItemStack Weapon = new ItemStack(VIBRANIUM_BATTLE_AXE);
        Weapon.addEnchantment(Enchantment.sharpness, 7);
        Weapon.addEnchantment(Enchantment.unbreaking, 5);
        Weapon.addEnchantment(Enchantment.piercing, 5);
        Weapon.setItemDamage(0);
        setCurrentItemOrArmor(0, Weapon);
        setHelmet((new ItemStack(VIBRANIUM_HELMET)).setItemDamage(0));
        setCuirass((new ItemStack(VIBRANIUM_CHESTPLATE)).setItemDamage(0));
        setLeggings((new ItemStack(VIBRANIUM_LEGGINGS)).setItemDamage(0));
        setBoots((new ItemStack(VIBRANIUM_BOOTS)).setItemDamage(0));
        getBoots().addEnchantment(Enchantment.protection, 5);
        getBoots().addEnchantment(Enchantment.unbreaking, 5);
        getBoots().addEnchantment(Enchantment.featherFalling, 4);
        getBoots().addEnchantment(Enchantment.speed, 5);
        getLeggings().addEnchantment(Enchantment.protection, 5);
        getLeggings().addEnchantment(Enchantment.unbreaking, 5);
        getLeggings().addEnchantment(Enchantment.free_action, 4);
        getCuirass().addEnchantment(Enchantment.protection, 5);
        getCuirass().addEnchantment(Enchantment.unbreaking, 5);
        getCuirass().addEnchantment(Enchantment.thorns, 3);
        getCuirass().addEnchantment(Enchantment.regeneration, 5);
        getCuirass().addEnchantment(Enchantment.endurance, 4);
        getHelmet().addEnchantment(Enchantment.protection, 5);
        getHelmet().addEnchantment(Enchantment.respiration, 3);
        getHelmet().addEnchantment(Enchantment.aquaAffinity, 1);
        getHelmet().addEnchantment(Enchantment.unbreaking, 5);
    }

    protected boolean isFinal() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        int day = ((GAWorld) this.worldObj).getDayOfOverworld();
        setEntityAttribute(SharedMonsterAttributes.maxHealth, Math.min(1250.0F, 800.0F * Constant.getBossMobModifier("Health", day)));
    }
}
