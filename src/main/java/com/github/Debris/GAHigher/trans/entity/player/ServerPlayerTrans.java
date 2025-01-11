package com.github.Debris.GAHigher.trans.entity.player;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.api.GAPlayer;
import com.github.Debris.GAHigher.compat.KeepInventoryCompat;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.network.GANetwork;
import com.github.Debris.GAHigher.network.packets.S2C.S2COpenWindow;
import com.github.Debris.GAHigher.network.packets.S2C.S2CSyncShopInfo;
import com.github.Debris.GAHigher.screen.container.ContainerShop;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin({ServerPlayer.class})
public abstract class ServerPlayerTrans extends EntityPlayer implements ICrafting, GAPlayer {
    @Shadow
    private int currentWindowId;

    public ServerPlayerTrans(World par1World, String par2Str) {
        super(par1World, par2Str);
    }

    @Override
    public void ga$DisplayGUIShop() {
        incrementWindowID();
        GANetwork.sendToClient(this.getAsEntityPlayerMP(), new S2COpenWindow(this.currentWindowId, S2COpenWindow.Shop, "shop", 45, false));
        this.openContainer = new ContainerShop(this);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.addCraftingToCrafters(this);
        GANetwork.sendToClient(this.getAsEntityPlayerMP(),new S2CSyncShopInfo(Items.priceStackList.size(), ((GAEntityPlayer) this).getMoneyManager().getMoney()));
    }

    @Shadow
    protected abstract void incrementWindowID();

    @Shadow
    public void sendContainerAndContentsToPlayer(Container container, List list) {
    }

    @Inject(method = "onDeath", at = @At("RETURN"))
    private void onDeath(DamageSource par1DamageSource, CallbackInfo ci) {
        if (this.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) return;
        if (KeepInventoryCompat.canKeepInventory(this)) return;
        ((GAEntityPlayer) ((EntityPlayer) this)).getInventoryJewelry().dropAll();
    }

}
