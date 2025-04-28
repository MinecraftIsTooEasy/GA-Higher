package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;

import java.util.List;

public class ItemTomato extends ItemFood {
    public ItemTomato(int id) {
        super(id, Material.fruit, 0, 0, false, false, false, "tomato");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            if (par3EntityPlayer.getNutritionLimit() - par3EntityPlayer.getNutrition() >= 4) {
                par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutrition() + 4, true);
            } else {
                int more = 4 - par3EntityPlayer.getNutritionLimit() - par3EntityPlayer.getNutrition();
                par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutritionLimit(), true);
                par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + more, true);
            }
            par3EntityPlayer.getAsEntityPlayerMP().setPhytonutrients(par3EntityPlayer.getAsEntityPlayerMP().getPhytonutrients() + 32000);
            if (Constant.GARandom.nextInt(30) == 0)
                if (Constant.GARandom.nextInt(30) == 0)
                    par3EntityPlayer.dropItem(Items.Guilt2);
        }
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+4的动态饱食度", new Object[0]));
            info.add(EnumChatFormatting.RED + Translator.getFormatted("好红、好红、好甜、好甜", new Object[0]));
        }
    }
}