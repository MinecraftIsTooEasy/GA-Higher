package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemOreBag extends ItemIngot {
    public ItemOreBag(int par1, Material material) {
        super(par1, material);
        setMaxStackSize(1);
        setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        if (player.onServer()) {
            ItemStack heldItemStack = player.getHeldItemStack();
            if (!ctrl_is_down) {
                int count = 0;
                int addcount = 0;
                int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0;
                int id = 0;
                int size = 0;
                for (int i = 0; i < player.inventory.mainInventory.length; i++) {
                    ItemStack itemStack = player.inventory.mainInventory[i];
                    if (itemStack != null) {
                        id = itemStack.itemID;
                        size = itemStack.stackSize;
                        if (id == Block.oreGold.blockID) {
//                        if (id == Block.L.blockID) {
                            if (itemStack.getItemSubtype() == 0) {
                                A += size;
                            } else {
                                G += size;
                            }
                            count += size;
                            player.inventory.setInventorySlotContents(i, null);
                        }
                        if (id == Block.oreSilver.blockID) {
                            B += size;
                            count += size;
                            player.inventory.setInventorySlotContents(i, null);
                        }
                        if (id == Block.oreCopper.blockID) {
                            C += size;
                            count += size;
                            player.inventory.setInventorySlotContents(i, null);
                        }
                        if (id == Block.oreIron.blockID) {
//                        if (id == Block.M.blockID) {
                            D += size;
                            count += size;
                            player.inventory.setInventorySlotContents(i, null);
                        }
                        if (id == Block.oreMithril.blockID) {
                            E += size;
                            count += size;
                            player.inventory.setInventorySlotContents(i, null);
                        }
                        if (id == Block.oreAdamantium.blockID) {
                            F += size;
                            count += size;
                            player.inventory.setInventorySlotContents(i, null);
                        }
                    }
                }
                addcount = count;
                if (heldItemStack.hasTagCompound()) {
                    NBTTagCompound tagCompound = heldItemStack.getTagCompound();
                    count += tagCompound.getInteger("OreCount");
                    A += tagCompound.getInteger("OreA");
                    B += tagCompound.getInteger("OreB");
                    C += tagCompound.getInteger("OreC");
                    D += tagCompound.getInteger("OreD");
                    E += tagCompound.getInteger("OreE");
                    F += tagCompound.getInteger("OreF");
                    G += tagCompound.getInteger("OreG");
                    tagCompound.setInteger("OreCount", count);
                    tagCompound.setInteger("OreA", A);
                    tagCompound.setInteger("OreB", B);
                    tagCompound.setInteger("OreC", C);
                    tagCompound.setInteger("OreD", D);
                    tagCompound.setInteger("OreE", E);
                    tagCompound.setInteger("OreF", F);
                    tagCompound.setInteger("OreG", G);
                } else {
                    NBTTagCompound nbtTagCompound = new NBTTagCompound();
                    nbtTagCompound.setInteger("OreCount", count);
                    nbtTagCompound.setInteger("OreA", A);
                    nbtTagCompound.setInteger("OreB", B);
                    nbtTagCompound.setInteger("OreC", C);
                    nbtTagCompound.setInteger("OreD", D);
                    nbtTagCompound.setInteger("OreE", E);
                    nbtTagCompound.setInteger("OreF", F);
                    nbtTagCompound.setInteger("OreG", G);
                    heldItemStack.setTagCompound(nbtTagCompound);
                }
                player.addChatMessage("§7[Server]:已存储§r §6" + addcount + " §r§7个矿物§r");
            } else if (heldItemStack.hasTagCompound()) {
                NBTTagCompound tagCompound = heldItemStack.getTagCompound();
                int count = tagCompound.getInteger("OreCount");
                int A = tagCompound.getInteger("OreA");
                int B = tagCompound.getInteger("OreB");
                int C = tagCompound.getInteger("OreC");
                int D = tagCompound.getInteger("OreD");
                int E = tagCompound.getInteger("OreE");
                int F = tagCompound.getInteger("OreF");
                int G = tagCompound.getInteger("OreG");
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Block.oreGold.blockID, A, 0));
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Block.oreSilver.blockID, B, 0));
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Block.oreCopper.blockID, C, 0));
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Block.oreIron.blockID, D, 0));
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Block.oreMithril.blockID, E, 0));
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Block.oreAdamantium.blockID, F, 0));
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Block.oreGold.blockID, G, 2));
                tagCompound.setInteger("OreCount", 0);
                tagCompound.setInteger("OreA", 0);
                tagCompound.setInteger("OreB", 0);
                tagCompound.setInteger("OreC", 0);
                tagCompound.setInteger("OreD", 0);
                tagCompound.setInteger("OreE", 0);
                tagCompound.setInteger("OreF", 0);
                tagCompound.setInteger("OreG", 0);
                player.addChatMessage("§7[Server]:已取出§r §6" + count + " §r§7个矿物§r");
            } else {
                player.addChatMessage("§7[Server]:此矿物包尚未使用§r");
            }
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
        int count = 0;
        int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0;
        if (item_stack.hasTagCompound()) {
            NBTTagCompound tagCompound = item_stack.getTagCompound();
            count = tagCompound.getInteger("OreCount");
            A = tagCompound.getInteger("OreA");
            B = tagCompound.getInteger("OreB");
            C = tagCompound.getInteger("OreC");
            D = tagCompound.getInteger("OreD");
            E = tagCompound.getInteger("OreE");
            F = tagCompound.getInteger("OreF");
            G = tagCompound.getInteger("OreG");
        }
        if (extended_info) {
            info.add(" ");
            info.add("§7矿物总数：§r§5 " + count + " §r§7个§r");
            if (A > 0)
                info.add("§8金：§r§6 " + A + " §r§8个§r");
            if (B > 0)
                info.add("§8银：§r§6 " + B + " §r§8个§r");
            if (C > 0)
                info.add("§8铜：§r§6 " + C + " §r§8个§r");
            if (D > 0)
                info.add("§8铁：§r§6 " + D + " §r§8个§r");
            if (E > 0)
                info.add("§8秘银：§r§6 " + E + " §r§8个§r");
            if (F > 0)
                info.add("§8艾德曼：§r§6 " + F + " §r§8个§r");
            if (G > 0)
                info.add("§8地狱金：§r§6 " + G + " §r§8个§r");
        }
    }
}