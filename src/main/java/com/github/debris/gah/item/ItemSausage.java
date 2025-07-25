package com.github.debris.gah.item;

import com.github.debris.gah.util.Constant;
import net.minecraft.*;

import java.util.List;

public class ItemSausage extends ItemFood {
    public ItemSausage(int id) {
        super(id, Material.meat, 0, 0, false, false, false, "sausage");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            int dynamic = Constant.GARandom.nextInt(6) + 5;
            if (par3EntityPlayer.getNutritionLimit() - par3EntityPlayer.getNutrition() >= dynamic) {
                par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutrition() + dynamic, true);
            } else {
                int more = dynamic - par3EntityPlayer.getNutritionLimit() - par3EntityPlayer.getNutrition();
                par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutritionLimit(), true);
                par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + more, true);
            }
            par3EntityPlayer.getAsEntityPlayerMP().setProtein(par3EntityPlayer.getAsEntityPlayerMP().getProtein() + 40000);
        }
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
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("+5~10的动态饱食度", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("吃了香肠我心花怒放", new Object[0]));
        }
    }
}