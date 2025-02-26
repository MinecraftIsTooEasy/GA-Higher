package com.github.Debris.GAHigher.screen.container;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.api.GAItemStack;
import com.github.Debris.GAHigher.entity.player.MoneyManager;
import com.github.Debris.GAHigher.screen.inventory.InventoryShop;
import com.github.Debris.GAHigher.screen.slot.SlotShop;
import net.minecraft.*;

import java.util.ArrayList;

public class ContainerShop extends Container {
    public InventoryShop inventory = new InventoryShop(this);

    public ContainerShop(EntityPlayer player) {
        super(player);
        int row;
        for (row = 0; row < 5; row++) {
            for (int i = 0; i < 9; i++)
                addSlotToContainer(new SlotShop(this, this.inventory, i + row * 9, 8 + i * 18, 18 + row * 18));
        }
        for (row = 0; row < 3; row++) {
            for (int i = 0; i < 9; i++)
                addSlotToContainer(new Slot(player.inventory, i + row * 9 + 9, 8 + i * 18, 140 + row * 18));
        }
        for (int col = 0; col < 9; col++)
            addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 198));
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer) {
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotIndex) {
        Slot slot;
        if (slotIndex >= 45 && (slot = (Slot) this.inventorySlots.get(slotIndex)) != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            double soldPrice = GAItemStack.getPrice(stack).soldPrice();
            if (soldPrice > 0.0D) {
                double totalMoney = stack.stackSize * soldPrice;
                MoneyManager moneyManager = GAEntityPlayer.getMoneyManager(this.player);
                moneyManager.addMoneyWithSimplify(totalMoney);
            }
            slot.putStack(null);
        }// selling item to the shop
        return null;
    }

    public void updatePlayerInventory(EntityPlayer player) {
        ArrayList<ItemStack> itemList = new ArrayList<>();
        for (int index = 0; index < player.openContainer.inventorySlots.size(); index++)
            itemList.add(((Slot) player.openContainer.inventorySlots.get(index)).getStack());
        ((ServerPlayer) player).sendContainerAndContentsToPlayer(player.openContainer, itemList);
    }
}
