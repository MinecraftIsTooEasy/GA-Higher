package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemDrug_YD extends Item {
  public ItemDrug_YD(int par1) {
    super(par1, Material.seed, "drug_yd");
    setMaxStackSize(64);
    setCraftingDifficultyAsComponent(1.0E-9F);
  }
  
  @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
    if (extended_info) {
      info.add(" ");
      info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("这颗妖丹散逸着灵力", new Object[0]));
      info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("需要在熔炉里炼制", new Object[0]));
    } 
  }
}


/* Location:              D:\download\MITE客户端\客户端-MITE娱乐版GA1.6.1\.minecraft\coremods\MITE-ITEPlugin-GA1.6.1.jar!\net\xiaoyu233\mitemod\miteite\item\ItemDrug_YD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */