package com.github.debris.gah.item.guilt;

import net.minecraft.*;

import java.util.List;

public class ItemGuilt4 extends Item {
    public ItemGuilt4(int par1) {
        super(par1, Material.diamond, "guilt4");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("七罪其四", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("King", new Object[0]));
        }
    }
}
