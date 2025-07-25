package com.github.debris.gah.item;

import com.github.debris.gah.block.Blocks;
import net.minecraft.*;

import java.util.List;

public class ItemSoulBag extends ItemIngot {
    private int a;

    public ItemSoulBag(int par1, Material material) {
        super(par1, material);
        this.a = Blocks.GotchaBox.blockID;
        setMaxStackSize(1);

        setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
    }

    @Override
    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
//        if (player.onServer()) {
//            ItemStack heldItemStack = player.getHeldItemStack();
//            Item B = player.getModelItem();
//            player.addChatMessage("on server");
//            if (heldItemStack.hasTagCompound()) {
//                NBTTagCompound tagCompound = heldItemStack.getTagCompound();
//                if (tagCompound.b("BackpackItems")) {
//                    NBTTagList backpackItems = tagCompound.m("BackpackItems");
//                    player.addChatMessage("has tag");
//                    player.SOULBAG().a("BackpackItems");
//                } else {
//                    NBTTagList list = new NBTTagList("BackpackItems");
//                    player.addChatMessage("renew tag");
//                    player.SOULBAG().a("BackpackItems");
//                }
//            } else {
//                NBTTagCompound nbtTagCompound = new NBTTagCompound();
//                heldItemStack.setTagCompound(nbtTagCompound);
//                NBTTagList list = new NBTTagList("BackpackItems");
//                player.addChatMessage("new tag");
//                player.SOULBAG().a("BackpackItems");
//            }
//            InventorySoulBag SoulBackpack = player.SOULBAG();
//            if (SoulBackpack != null) {
//                player.displayGUIBackpack((EntityPlayer) player);
//                player.addChatMessage("3");
//                return true;
//            }
//        } else {
//            player.bobItem();
//        }
        return true;// TODO
    }

    public static float getCraftingDifficultyAsComponent(Material material) {
        return 400.0F;
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    public boolean isHarmedByLava() {
        return false;
    }

    public boolean isHarmedByPepsin() {
        return false;
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("黄枫谷小学", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("好好学习，天天向上", new Object[0]));
        }
    }
}