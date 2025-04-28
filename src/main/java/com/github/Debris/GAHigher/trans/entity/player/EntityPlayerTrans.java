package com.github.Debris.GAHigher.trans.entity.player;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.entity.player.HomeScrollManager;
import com.github.Debris.GAHigher.entity.player.StoneCountManager;
import com.github.Debris.GAHigher.screen.inventory.InventoryEnderChestTrans;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public abstract class EntityPlayerTrans extends EntityLivingBase implements ICommandSender, GAEntityPlayer {
    @Unique
    private InventoryEnderChestTrans enderTrans = new InventoryEnderChestTrans();
    @Unique
    private final StoneCountManager stoneCountManager = new StoneCountManager(this.getAsPlayer());
    @Unique
    private final HomeScrollManager homeScrollManager = new HomeScrollManager(this.getAsPlayer());

    public EntityPlayerTrans(World par1World) {
        super(par1World);
    }

    @Shadow
    public abstract EntityDamageResult attackEntityFrom(Damage paramDamage);

    public InventoryEnderChestTrans ga$getInventoryEnderChestTrans() {
        return this.enderTrans;
    }

    @Override
    public StoneCountManager ga$getStoneCountManager() {
        return this.stoneCountManager;
    }

    @Override
    public HomeScrollManager ga$getHomeScrollManager() {
        return this.homeScrollManager;
    }

    @Inject(method = "clonePlayer(Lnet/minecraft/EntityPlayer;Z)V", at = @At("RETURN"))
    public void clonePlayerInject(EntityPlayer oldPlayer, boolean par2, CallbackInfo callbackInfo) {
        this.enderTrans = ((GAEntityPlayer) oldPlayer).ga$getInventoryEnderChestTrans();
    }

    @Inject(method = "readEntityFromNBT(Lnet/minecraft/NBTTagCompound;)V", at = @At("RETURN"))
    public void injectReadNBT(NBTTagCompound par1NBTTagCompound, CallbackInfo ci) {
        this.stoneCountManager.read(par1NBTTagCompound);
        this.homeScrollManager.read(par1NBTTagCompound);
        if (par1NBTTagCompound.hasKey("EnderTransItems")) {
            NBTTagList var3 = par1NBTTagCompound.getTagList("EnderTransItems");
            this.enderTrans.loadInventoryFromNBT(var3);
        }
    }


    @Inject(method = "writeEntityToNBT(Lnet/minecraft/NBTTagCompound;)V", at = @At("RETURN"))
    public void injectWriteNBT(NBTTagCompound par1NBTTagCompound, CallbackInfo callback) {
        this.stoneCountManager.write(par1NBTTagCompound);
        this.homeScrollManager.write(par1NBTTagCompound);
        par1NBTTagCompound.setTag("EnderTransItems", this.enderTrans.saveInventoryToNBT());
    }
}
