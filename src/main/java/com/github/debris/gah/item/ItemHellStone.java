package com.github.debris.gah.item;

import com.github.debris.gah.block.Blocks;
import net.minecraft.*;

import java.util.List;

public class ItemHellStone extends Item {
    public ItemHellStone(int par1) {
        super(par1, Material.seed, "hell_stones");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        RaycastCollision rc = player.getSelectedObject(partial_tick, false);
        if (rc == null || !rc.isBlock())
            return false;
//        if (player.q.areSkillsEnabled() && this.a == Block.bg.blockID && !player.hasSkill(Skill.FARMING))
//            return false;
        return player.tryPlaceHeldItemAsBlock(rc, Block.netherrack);
    }

    public boolean tryPlaceAsBlock(RaycastCollision rc, Block block, EntityPlayer player, ItemStack item_stack) {
        if (block == Block.netherrack) {
//        if (block == Block.bg) {
            if (rc.getBlockHit() == block) {
                int i = rc.block_hit_x;
                int j = rc.block_hit_y;
                int k = rc.block_hit_z;
                if (Blocks.BlockBamboo.tryPlaceBlock(rc.world, i, ++j, k, EnumFace.TOP, 0, player, true, true))
                    return true;
            }
            int x = rc.neighbor_block_x;
            int y = rc.neighbor_block_y;
            int z = rc.neighbor_block_z;
            if (rc.world.getBlock(x, y, z) != block)
                return super.tryPlaceAsBlock(rc, block, player, item_stack);
            if (block.isLegalAt(rc.world, rc.block_hit_x, rc.block_hit_y, rc.block_hit_z, 0) && block.canReplaceBlock(0, rc.getBlockHit(), rc.block_hit_metadata))
                return super.tryPlaceAsBlock(rc, block, player, item_stack);
//            if (Block.bg.tryPlaceBlock(rc.world, x, ++y, z, EnumFace.TOP, 0, (Entity) player, true, true))
            if (Block.netherrack.tryPlaceBlock(rc.world, x, ++y, z, EnumFace.TOP, 0, player, true, true))
                return true;
        }
        return super.tryPlaceAsBlock(rc, block, player, item_stack);
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
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("白玉楼的地基材料", new Object[0]));
        }
    }
}