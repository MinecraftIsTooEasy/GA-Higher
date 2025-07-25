package com.github.debris.gah.item;

import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Material;

public class ItemSoulBook extends Item {
    public ItemSoulBook(int par1) {
        super(par1, "soulbook");
        setMaterial(new Material[]{Material.paper, Material.leather});
        setMaxStackSize(1);
    }

    // TODO

//    public static boolean a(NBTTagCompound par0NBTTagCompound) {
//        if (!ItemBookAndQuill.a(par0NBTTagCompound))
//            return false;
//        if (!par0NBTTagCompound.b("title"))
//            return false;
//        String var1 = par0NBTTagCompound.i("title");
//        return (var1 != null && var1.length() <= 16) ? par0NBTTagCompound.b("author") : false;
//    }
//
//    public String l(ItemStack par1ItemStack) {
//        if (par1ItemStack != null && par1ItemStack.p()) {
//            NBTTagCompound var2 = par1ItemStack.q();
//            NBTTagString var3 = (NBTTagString) var2.a("title");
//            if (var3 != null) {
//                String title = var3.toString().trim();
//                if (this instanceof ItemSoulNewBook || title.isEmpty())
//                    return title;
//                title = StringHelper.stripLeading("\"", StringHelper.stripTrailing("\"", title)).trim();
//                if (!title.startsWith("\""))
//                    title = "\"" + title;
//                if (!title.endsWith("\""))
//                    title = title + "\"";
//                return title;
//            }
//        }
//        return super.l(par1ItemStack);
//    }
//
//    @Override
//    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
//        if (item_stack.hasTagCompound()) {
//            NBTTagCompound var5 = item_stack.getTagCompound();
//            NBTTagString var6 = (NBTTagString) var5.a("author");
//            if (var6 != null)
//                par3List.add(EnumChatFormat.h + String.format(LocaleI18n.a("book.byAuthor", new Object[]{var6.a}), new Object[0]));
//        }
//    }
//
//    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
//        ItemStack held_item_stack = player.getHeldItemStack();

    /// /        player.c(held_item_stack);
//        player.c(held_item_stack);
//        return true;
//    }
    public boolean s() {
        return true;
    }

    public boolean e(ItemStack par1ItemStack) {
        return true;
    }

    public boolean canBeRenamed() {
        return false;
    }
}