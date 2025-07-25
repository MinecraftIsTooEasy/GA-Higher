package com.github.debris.gah.item;

import net.minecraft.*;

import java.util.List;

public class ItemColorBag extends Item {
    public ItemColorBag(int id, Material material, String texture) {
        super(id, material, texture);
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
    }

    public static float getCraftingDifficultyAsComponent(Material material) {
        return 100.0F;
    }

    public static int getExperienceValueWhenSacrificed(ItemStack item_stack) {
        return 0;
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        int xp_value = getExperienceValueWhenSacrificed(item_stack);
        if (player.onServer()) {
            player.causeBreakingItemEffect(item_stack.getItem(), player.inventory.currentItem);
            player.convertOneOfHeldItem(null);
            player.addExperience(xp_value);
            for (int i = 0; i < 16; i++)
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Item.dyePowder, 1, i));
        } else {
            player.bobItem();
        }
        return true;
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("豪德寺三花的卡片", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("虹龙洞的隐秘道具", new Object[0]));
        }
    }
}
