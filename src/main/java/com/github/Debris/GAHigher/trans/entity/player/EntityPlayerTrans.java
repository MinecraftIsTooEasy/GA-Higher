package com.github.Debris.GAHigher.trans.entity.player;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.compat.KeepInventoryCompat;
import com.github.Debris.GAHigher.entity.player.BossManager;
import com.github.Debris.GAHigher.entity.player.JewelryManager;
import com.github.Debris.GAHigher.entity.player.MoneyManager;
import com.github.Debris.GAHigher.screen.inventory.InventoryEnderChestTrans;
import com.github.Debris.GAHigher.screen.inventory.InventoryJewelry;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(EntityPlayer.class)
public abstract class EntityPlayerTrans extends EntityLivingBase implements ICommandSender, GAEntityPlayer {
    @Unique
    private final Map<Entity, Integer> attackCountMap = new HashMap<>();
    @Shadow
    public InventoryPlayer inventory;
    @Shadow
    public float vision_dimming;
    @Unique
    public long StoneCount = 0L;
    @Unique
    private InventoryEnderChestTrans enderTrans = new InventoryEnderChestTrans();
    @Unique
    private final JewelryManager jewelryManager = new JewelryManager((EntityPlayer) (Object) this);
    @Unique
    private InventoryJewelry inventoryJewelry = new InventoryJewelry((EntityPlayer) (Object) this);
    @Unique
    private MoneyManager moneyManager = new MoneyManager((EntityPlayer) (Object) this);
    @Unique
    private BossManager bossManager = new BossManager((EntityPlayer) (Object) this);

    public EntityPlayerTrans(World par1World) {
        super(par1World);
    }

    @Shadow
    public abstract EntityDamageResult attackEntityFrom(Damage paramDamage);

    public InventoryEnderChestTrans ga$getInventoryEnderChestTrans() {
        return this.enderTrans;
    }

    public void ga$addStoneCount(long stoneCount) {
        this.StoneCount += stoneCount;
    }

    @Override
    public InventoryJewelry ga$getInventoryJewelry() {
        return this.inventoryJewelry;
    }

    @Override
    public MoneyManager ga$getMoneyManager() {
        return this.moneyManager;
    }

    @Override
    public BossManager ga$getBossManager() {
        return this.bossManager;
    }

    @Inject(method = "clonePlayer(Lnet/minecraft/EntityPlayer;Z)V", at = @At("RETURN"))
    public void clonePlayerInject(EntityPlayer oldPlayer, boolean par2, CallbackInfo callbackInfo) {
        this.enderTrans = ((GAEntityPlayer) oldPlayer).ga$getInventoryEnderChestTrans();
        if (par2 || KeepInventoryCompat.canKeepInventory(oldPlayer)) {
            this.inventoryJewelry.clone(oldPlayer);
        }
        this.moneyManager.clone(oldPlayer);
    }

    @Inject(method = "readEntityFromNBT(Lnet/minecraft/NBTTagCompound;)V", at = @At("RETURN"))
    public void injectReadNBT(NBTTagCompound par1NBTTagCompound, CallbackInfo ci) {
        this.StoneCount = par1NBTTagCompound.getLong("StoneCount");
        this.vision_dimming = par1NBTTagCompound.getFloat("vision_dimming");
        if (par1NBTTagCompound.hasKey("EnderTransItems")) {
            NBTTagList var3 = par1NBTTagCompound.getTagList("EnderTransItems");
            this.enderTrans.loadInventoryFromNBT(var3);
        }
        if (par1NBTTagCompound.hasKey("AttackCountMap")) {
            NBTTagList attackCountMap = par1NBTTagCompound.getTagList("AttackCountMap");
            int count = attackCountMap.tagCount();
            for (int i = 0; i < count; i++) {
                NBTTagCompound a = (NBTTagCompound) attackCountMap.tagAt(i);
                Entity attacker = getWorldServer().getEntityByID(a.getInteger("Attacker"));
                if (attacker != null)
                    this.attackCountMap.put(attacker, a.getInteger("Count"));
            }
        }
        if (par1NBTTagCompound.hasKey("InventoryJewelry")) {
            this.inventoryJewelry.readFromNBT(par1NBTTagCompound.getTagList("InventoryJewelry"));
        }
        this.moneyManager.read(par1NBTTagCompound);
        this.bossManager.read(par1NBTTagCompound);
    }


    @Inject(method = "writeEntityToNBT(Lnet/minecraft/NBTTagCompound;)V", at = @At("RETURN"))
    public void injectWriteNBT(NBTTagCompound par1NBTTagCompound, CallbackInfo callback) {
        par1NBTTagCompound.setLong("StoneCount", this.StoneCount);
        par1NBTTagCompound.setFloat("vision_dimming", this.vision_dimming);
        par1NBTTagCompound.setTag("EnderTransItems", this.enderTrans.saveInventoryToNBT());
        NBTTagList nbtTagList = new NBTTagList();
        for (Map.Entry<Entity, Integer> integerEntry : this.attackCountMap.entrySet()) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("Attacker", integerEntry.getKey().entityId);
            compound.setInteger("Count", integerEntry.getValue());
            nbtTagList.appendTag(compound);
        }
        par1NBTTagCompound.setTag("AttackCountMap", nbtTagList);
        par1NBTTagCompound.setTag("InventoryJewelry", this.inventoryJewelry.writeToNBT(new NBTTagList()));
        this.moneyManager.write(par1NBTTagCompound);
        this.bossManager.write(par1NBTTagCompound);
    }

    @Shadow
    protected abstract void fall(float paramFloat);

    @Shadow
    public abstract float getAIMoveSpeed();

    @Shadow
    public ItemStack getHeldItemStack() {
        return null;
    }

    @Shadow
    public void setHeldItemStack(ItemStack itemStack) {
    }

    @Shadow
    public ItemStack[] getWornItems() {
        return new ItemStack[0];
    }

    @Inject(method = "onLivingUpdate()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityLivingBase;onLivingUpdate()V", shift = At.Shift.AFTER))
    private void injectTick(CallbackInfo c) {
        this.inventory.decrementAnimations();
        if (!this.worldObj.isRemote) {
            this.jewelryManager.tick();
            this.bossManager.tick();
        }
    }

    @Shadow
    public boolean isWearing(ItemStack itemStack) {
        return false;
    }

    @Shadow
    public boolean setWornItem(int i, ItemStack itemStack) {
        return false;
    }
}
