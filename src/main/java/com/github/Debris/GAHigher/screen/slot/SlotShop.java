package com.github.Debris.GAHigher.screen.slot;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.api.GAItemStack;
import com.github.Debris.GAHigher.entity.player.MoneyManager;
import com.github.Debris.GAHigher.screen.container.ContainerShop;
import com.github.Debris.GAHigher.util.PriceItem;
import net.minecraft.*;

public class SlotShop extends Slot {
    int slotIndex;

    ContainerShop containerShop;

    @Override
    public boolean canTakeStack(EntityPlayer par1EntityPlayer) {
        return false;
    }

    public SlotShop(ContainerShop containerShop, IInventory inventory, int slot_index, int display_x, int display_y) {
        super(inventory, slot_index, display_x, display_y, false);
        setContainer(containerShop);
        this.containerShop = containerShop;
        this.slotIndex = slot_index;
    }

    @Override
    public void onSlotClicked(EntityPlayer entity_player, int button, Container container) {
        super.onSlotClicked(entity_player, button, container);
        MoneyManager moneyManager = ((GAEntityPlayer) entity_player).getMoneyManager();
        if (getStack() != null) {
            ItemStack var5 = getStack().copy();
            PriceItem price = ((GAItemStack) var5).getPrice();
            switch (button) {
                case 0 -> {
                    double buyPrice = price.buyPrice();
                    if (buyPrice > 0.0D) {
                        if (moneyManager.getMoney() - buyPrice >= 0.0D) {
                            moneyManager.subMoney(buyPrice);
                            entity_player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(var5.itemID, 1, var5.getItemSubtype()));
                        } else {
                            this.containerShop.player.addChatMessage("余额不足");
                        }
                    } else {
                        this.containerShop.player.addChatMessage("商店不支持购买此商品");
                    }
                }

                case 1 -> {
                    if (price.buyPrice() > 0.0D) {
                        double totalMoney = var5.getMaxStackSize() * price.buyPrice();
                        if (moneyManager.getMoney() >= totalMoney) {
                            entity_player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(var5.itemID, var5.getMaxStackSize(), var5.getItemSubtype()));
                            moneyManager.subMoneyWithSimplify(totalMoney);
                        } else {
                            int maxStackSize = (int) Math.floor(moneyManager.getMoney() / price.buyPrice());
                            if (maxStackSize > 0) {
                                totalMoney = maxStackSize * price.buyPrice();
                                moneyManager.subMoneyWithSimplify(totalMoney);
                                var5.setStackSize(maxStackSize);
                                entity_player.inventory.addItemStackToInventoryOrDropIt(var5);
                            } else {
                                entity_player.addChatMessage("余额不足");
                            }
                        }
                    } else {
                        entity_player.addChatMessage("商店不支持购买此商品");
                    }
                }
            }
        }
    }

    @Override
    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
        super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack) {
        return false;
    }
}
