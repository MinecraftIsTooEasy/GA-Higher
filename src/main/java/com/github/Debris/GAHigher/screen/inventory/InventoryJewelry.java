package com.github.Debris.GAHigher.screen.inventory;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.api.GAItem;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.entity.player.MoneyManager;
import com.github.Debris.GAHigher.item.ItemRingKiller;
import com.github.Debris.GAHigher.item.jewelry.ItemJewelry;
import com.google.common.collect.ImmutableList;
import net.minecraft.*;

import java.util.List;

public class InventoryJewelry extends InventoryBasic {
//    private static final Logger LOGGER = LogUtil.getLogger();

    private final EntityPlayer player;

    public InventoryJewelry(EntityPlayer player) {
        super("", false, 8);
        this.player = player;
    }

    public void dropAll() {
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack stackInSlot = this.getStackInSlot(i);
            if (stackInSlot != null) {
                this.player.dropPlayerItemWithRandomChoice(stackInSlot, true);
                this.setInventorySlotContents(i, null);
            }
        }
    }

    public List<ItemStack> getJewelry() {
        ImmutableList.Builder<ItemStack> builder = ImmutableList.builder();
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack stackInSlot = this.getStackInSlot(i);
            if (stackInSlot == null) continue;// empty slot
            if (!(stackInSlot.getItem() instanceof ItemJewelry)) continue;// the slot is not ring killer
            builder.add(stackInSlot);
        }
        return builder.build();
    }

    public boolean hasJewelry(Item item) {
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack stackInSlot = this.getStackInSlot(i);
            if (stackInSlot == null) continue;// empty slot
            if (stackInSlot.getItem() == item) return true;
        }
        return false;
    }

    public ItemStack getRingKiller() {
        ItemStack strongestRingKiller = null;
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack stackInSlot = this.getStackInSlot(i);
            if (stackInSlot == null) continue;// empty slot
            if (!(stackInSlot.getItem() instanceof ItemRingKiller)) continue;// the slot is not ring killer
            if (strongestRingKiller == null) {// if null just apply first
                strongestRingKiller = stackInSlot;
                continue;
            }
            if (((ItemRingKiller) stackInSlot.getItem()).getLevel() > ((ItemRingKiller) strongestRingKiller.getItem()).getLevel()) {// choose better one
                strongestRingKiller = stackInSlot;
            }
        }
        return strongestRingKiller;
    }

    public void readFromNBT(NBTTagList par1NBTTagList) {
        for (int var2 = 0; var2 < par1NBTTagList.tagCount(); ++var2) {
            NBTTagCompound var3 = (NBTTagCompound) par1NBTTagList.tagAt(var2);
            int var4 = var3.getByte("Slot") & 255;
            ItemStack var5 = ItemStack.loadItemStackFromNBT(var3);
            if (var5 != null) {
                this.setInventorySlotContents(var4, var5);
            }
        }
    }

    public NBTTagList writeToNBT(NBTTagList nbtTagList) {
        NBTTagCompound tag;
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack stackInSlot = this.getStackInSlot(i);
            if (stackInSlot != null) {
                tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stackInSlot.writeToNBT(tag);
                nbtTagList.appendTag(tag);
            }
        }
        return nbtTagList;
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        if (par1 == 7 && par2ItemStack != null) {
            if (!Configs.wenscConfig.isCloseShop.ConfigValue) {
//                System.out.println(Arrays.toString((Object[]) new Map[]{(par2ItemStack.getItem()).soldPriceArray}));
                double soldPrice = ((GAItem) par2ItemStack.getItem()).getSoldPrice(par2ItemStack.getItemSubtype());
                if (soldPrice > 0.0D && !this.player.worldObj.isRemote) {
                    MoneyManager moneyManager = ((GAEntityPlayer) this.player).getMoneyManager();
                    moneyManager.addMoney(par2ItemStack.stackSize * soldPrice);
                    double now = moneyManager.getMoney();
                    this.player.addChatMessage("现有余额：" + String.format("%.2f", now));
                }
            }
            this.setInventorySlotContents(par1, null);
            return;
        }
        super.setInventorySlotContents(par1, par2ItemStack);
    }
}
