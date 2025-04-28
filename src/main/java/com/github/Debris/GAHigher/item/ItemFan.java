package com.github.Debris.GAHigher.item;

import net.minecraft.*;

public class ItemFan extends ItemNewTool {
    public ItemFan(int par1, Material material) {
        super(par1, material);
        setMaxStackSize(1);
        setCraftingDifficultyAsComponent(1.0F);
    }

    @Override
    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        if (player.onServer()) {
            ItemStack heldItemStack = player.getHeldItemStack();
            if (ctrl_is_down) {
                heldItemStack.setItemDamage(heldItemStack.getItemDamage() + 300);
                for (int i = 0; i < 9 &&
                        player.getWorld().getBlockId(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY + 1.0D), MathHelper.floor_double(player.posZ)) == 0; i++)
                    player.setPositionAndUpdate(player.posX, player.posY + 1.0D, player.posZ);
            } else {
                heldItemStack.setItemDamage(heldItemStack.getItemDamage() + 100);
                for (int i = 0; i < 3 &&
                        player.getWorld().getBlockId(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY + 1.0D), MathHelper.floor_double(player.posZ)) == 0; i++)
                    player.setPositionAndUpdate(player.posX, player.posY + 1.0D, player.posZ);
            }
        }
        return true;
    }

    public String getToolType() {
        return "fan";
    }

//    public float getBaseHarvestEfficiency(Block block) {
//        return (block == Block.V) ? (super.getBaseHarvestEfficiency(block) * 0.5F) : super.getBaseHarvestEfficiency(block);
//    }

    public float getBaseDamageVsEntity() {
        return 3.0F;
    }

    public int getNumComponentsForDurability() {
        return 1;
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