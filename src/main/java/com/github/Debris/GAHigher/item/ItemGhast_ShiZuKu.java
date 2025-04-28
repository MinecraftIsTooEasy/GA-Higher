package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

import java.util.List;

public class ItemGhast_ShiZuKu extends Item {
    public ItemGhast_ShiZuKu(int id) {
        super(id, Material.diamond, "shizuku");
        setMaxStackSize(64);
    }

    public static int getExperienceValueWhenSacrificed(ItemStack item_stack) {
//        Item item = item_stack.b();
        return 0;
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        int xp_value = getExperienceValueWhenSacrificed(item_stack);
        if (player.onServer()) {
            player.convertOneOfHeldItem(null);
            player.addExperience(xp_value);
            int count = Constant.GARandom.nextInt(4) + 1;
            player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Item.ghastTear, count, 0));
        } else {
            player.bobItem();
        }
        return true;
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("ミゼラブルの雫", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("春节两千响", new Object[0]));
        }
    }
}