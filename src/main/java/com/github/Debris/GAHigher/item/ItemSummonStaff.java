package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.entity.player.StoneCountManager;
import net.minecraft.*;

import java.util.List;

public class ItemSummonStaff extends ItemNewTool {
    private static boolean CD;

    public ItemSummonStaff(int id, Material material) {
        super(id, material);
        setMaxStackSize(1);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    @Override
    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        CD = true;
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        if (player.onServer()) {
            ItemStack heldItemStack = player.getHeldItemStack();
            Item B = player.getModelItem();
            StoneCountManager manager = GAEntityPlayer.getStoneCountManager(player);
            if (ctrl_is_down) {
                if (manager.getStoneCount() == 0L) {
                    player.addChatMessage("§7[Server]:你的石粒数为§r §60§r");
                } else if (manager.getStoneCount() >= 64L) {
                    manager.addStoneCount(-64);
                    player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Items.Stones, 64, 0));
                    player.addChatMessage("§7[Server]:已取出§r §664 §r§7个石粒，现有 §r§6" + manager.getStoneCount() + " §r§7个§r");
                } else {
                    int StoneStack = Math.toIntExact(manager.getStoneCount());
                    manager.setStoneCount(0);
                    player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Items.Stones, StoneStack, 0));
                    player.addChatMessage("§7[Server]:已取出§r §6" + StoneStack + " §r§7个石粒，现有 §r§6" + manager.getStoneCount() + " §r§7个§r");
                }
            } else {
                int count = 0;
                int id = 0;
                int stackSize = 0;
                for (int i = 0; i < player.inventory.mainInventory.length; i++) {
                    ItemStack itemStack = player.inventory.mainInventory[i];
                    if (itemStack != null) {
                        id = itemStack.itemID;
                        stackSize = itemStack.stackSize;
//                        if (id == Items.Stones.itemID || id == Block.B.blockID) {
                        if (id == Items.Stones.itemID || id == Block.stone.blockID) {
                            count += stackSize;
                            player.inventory.setInventorySlotContents(i, null);
                        }
                    }
                }
                if (count > 0) {
                    manager.addStoneCount(count);
                }
                player.addChatMessage("§7[Server]:已存入§r §6" + count + " §r§7个石粒，现有 §r§6" + manager.getStoneCount() + " §r§7个§r");
            }
        } else {
            player.bobItem();
        }
        return true;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("唤物法杖", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("奇妙魔法", new Object[0]));
        }
    }

    public String getToolType() {
        return "summonstaff";
    }

    public float getBaseHarvestEfficiency(Block block) {
        return 
//                (block == Block.V) ? (super.getBaseHarvestEfficiency(block) * 0.5F) : 
                super.getBaseHarvestEfficiency(block);
    }

    public float getBaseDamageVsEntity() {
        return 1.0F;
    }

    public int getNumComponentsForDurability() {
        return 2;
    }

    public float getBaseDecayRateForBreakingBlock(Block block) {
//        if (block == Block.V)
//            return 1.875F;// TODO
        return 1.0F;
    }

    public float getBaseDecayRateForAttackingEntity(ItemStack item_stack) {
        return 1.0F;
    }
}