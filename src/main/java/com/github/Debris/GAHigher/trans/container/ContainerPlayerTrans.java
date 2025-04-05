package com.github.Debris.GAHigher.trans.container;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.screen.inventory.InventoryJewelry;
import net.minecraft.ContainerPlayer;
import net.minecraft.EntityPlayer;
import net.minecraft.MITEContainerCrafting;
import net.minecraft.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ContainerPlayer.class)
public abstract class ContainerPlayerTrans extends MITEContainerCrafting {
    public ContainerPlayerTrans(EntityPlayer player) {
        super(player);
    }

    @Inject(method = "createSlots()V", at = @At("TAIL"))
    public void addJewelrySlots(CallbackInfo callbackInfo) {
        InventoryJewelry inventoryJewelry = GAEntityPlayer.getInventoryJewelry(this.player);
//        for (int i = 0; i < inventoryJewelry.getSizeInventory(); i++) {// old slots
//            this.addSlotToContainer(new Slot(inventoryJewelry, i, 80 + i * 18, 64));
//        }
        int slot_index;
        for (slot_index = 0; slot_index < 4; slot_index++) {
            addSlotToContainer(new Slot(inventoryJewelry, slot_index, 184, 8 + slot_index * 18));
        }
        for (slot_index = 0; slot_index < 3; slot_index++) {
            addSlotToContainer(new Slot(inventoryJewelry, 4 + slot_index, 184, 84 + slot_index * 18));
        }
        addSlotToContainer(new Slot(inventoryJewelry, 7, 184, 142));
    }
}
