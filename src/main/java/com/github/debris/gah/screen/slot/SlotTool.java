package com.github.debris.gah.screen.slot;

import net.minecraft.IInventory;
import net.minecraft.ItemStack;
import net.minecraft.Slot;

public class SlotTool extends Slot {
    public SlotTool(IInventory inventory, int slot_index, int display_x, int display_y) {
        super(inventory, slot_index, display_x, display_y);
    }

    public boolean isItemValid(ItemStack par1ItemStack) {
        return (par1ItemStack.getItem() instanceof net.minecraft.ItemTool || par1ItemStack.getItem() instanceof net.minecraft.ItemArmor);
    }
}
