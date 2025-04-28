package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemSoulNewBook extends ItemSoulBook {
    public static final int BOOK_A = 1;

    public static final int BOOK_B = 2;

    public static final int BOOK_C = 3;

    public static final int BOOK_D = 4;

    public static final int BOOK_E = 5;

    public static final int BOOK_F = 6;

    public static final int BOOK_G = 7;

    public static final int BOOK_H = 8;

    public static final int BOOK_I = 9;

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        ItemStack held_item_stack = player.getHeldItemStack();
        return super.onItemRightClick(player, partial_tick, ctrl_is_down);
    }

    public ItemSoulNewBook(int id) {
        super(id);
    }

    public static int getXPReward(ItemStack item_stack) {
        return 0;
    }

    public static NBTTagCompound generateBookContents(int index) {
        NBTTagCompound nbt = new NBTTagCompound();
        NBTTagList pages = new NBTTagList();
        nbt.setTag("pages", pages);
//        nbt.a("pages", (NBTBase) pages);
        if (index == 1) {
            nbt.setTag("author", new NBTTagString("author", " "));
            nbt.setTag("title", new NBTTagString("title", "《长春功》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 2) {
            nbt.setTag("author", new NBTTagString("author", "青元子"));
            nbt.setTag("title", new NBTTagString("title", "《青元剑诀》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 3) {
            nbt.setTag("author", new NBTTagString("author", "大衍神君"));
            nbt.setTag("title", new NBTTagString("title", "《大衍决》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 4) {
            nbt.setTag("author", new NBTTagString("author", "墨居仁"));
            nbt.setTag("title", new NBTTagString("title", "《魔银手》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 5) {
            nbt.setTag("author", new NBTTagString("author", " "));
            nbt.setTag("title", new NBTTagString("title", "《元磁神光》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 6) {
            nbt.setTag("author", new NBTTagString("author", "蛮胡子"));
            nbt.setTag("title", new NBTTagString("title", "《托天魔功》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 7) {
            nbt.setTag("author", new NBTTagString("author", " "));
            nbt.setTag("title", new NBTTagString("title", "《阴阳轮回诀》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 8) {
            nbt.setTag("author", new NBTTagString("author", " "));
            nbt.setTag("title", new NBTTagString("title", "《素女轮回功》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else if (index == 9) {
            nbt.setTag("author", new NBTTagString("author", " "));
            nbt.setTag("title", new NBTTagString("title", "《血灵大法》"));
            pages.appendTag(new NBTTagString("1", " "));
            pages.appendTag(new NBTTagString("2", " "));
            pages.appendTag(new NBTTagString("3", " "));
            nbt.setInteger("xp_reward", 100);
        } else {
            Minecraft.setErrorMessage("generateBook: invalid index " + index);
            return null;
        }
        nbt.setInteger("reference_index", index);
        nbt.setString("flavor_text", "地精科技站出品\nhttps://mitega.gitee.io");
        return nbt;
    }

    public int getBurnTime(ItemStack item_stack) {
        return 0;
    }

    public static ItemStack generateBook(int index) {
        return (new ItemStack(Items.SoulNewBook)).setTagCompound(generateBookContents(index));
    }

    public static int getReferenceIndex(ItemStack item_stack) {
        return (item_stack != null && item_stack.getItem() instanceof net.minecraft.ItemReferencedBook && item_stack.hasTagCompound()) ? item_stack.getTagCompound().getInteger("reference_index") : 0;
    }

    public static boolean isReferencedBook(ItemStack item_stack) {
        return (getReferenceIndex(item_stack) > 0);
    }

    public static int getSignature(ItemStack item_stack) {
        return getReferenceIndex(item_stack);
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        int maxIndex = 9;
        for (int i1 = 1; i1 <= maxIndex; i1++)
            par3List.add(generateBookT(i1));
    }

    public ItemStack generateBookT(int index) {
        return (new ItemStack(this)).setTagCompound(generateBookContents(index));
    }
}