package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

import java.util.List;

public class ItemTomato_Omelette extends ItemFood {
    public ItemTomato_Omelette(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "tomato_omelette");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            if (par3EntityPlayer.getNutritionLimit() - par3EntityPlayer.getNutrition() >= 8) {
                par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutrition() + 8, true);
            } else {
                int more = 8 - par3EntityPlayer.getNutritionLimit() - par3EntityPlayer.getNutrition();
                par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutritionLimit(), true);
                par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + more, true);
            }
            par3EntityPlayer.getAsEntityPlayerMP().setPhytonutrients(par3EntityPlayer.getAsEntityPlayerMP().getPhytonutrients() + 32000);
            par3EntityPlayer.getAsEntityPlayerMP().setProtein(par3EntityPlayer.getAsEntityPlayerMP().getProtein() + 24000);
            if (Constant.GARandom.nextInt(30) == 0)
                par3EntityPlayer.dropItem(Items.Guilt2);
        }
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+8的动态饱食度", new Object[0]));
            info.add("§c◆§r§6◆§r§a◆§r§9◆§r§f◆§r§3◆§r§1◆§r§5◆§r§eM§r§5◆§r§1◆§r§3◆§r§f◆§r§9◆§r§a◆§r§6◆§r§c◆§r");
            info.add(EnumChatFormatting.RED + Translator.getFormatted("495年的波纹", new Object[0]));
        }
    }
}