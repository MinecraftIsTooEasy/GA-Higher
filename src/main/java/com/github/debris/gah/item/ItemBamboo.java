package com.github.debris.gah.item;

import com.github.debris.gah.block.Blocks;
import net.minecraft.*;

public class ItemBamboo extends Item {
    private int a;

    public ItemBamboo(int par1, Block par2Block, String texture) {
//        super(par1, par2Block.cU, texture);
        super(par1, par2Block.blockMaterial, texture);
        this.a = par2Block.blockID;
        setMaxStackSize(64);
    }

    @Override
    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        RaycastCollision rc = player.getSelectedObject(partial_tick, false);
        if (rc == null || !rc.isBlock())
            return false;
//        if (player.q.areSkillsEnabled() && this.a == Blocks.BlockBamboo.blockID && !player.hasSkill(Skill.FARMING))
//            return false;
        return player.tryPlaceHeldItemAsBlock(rc, Block.getBlock(this.a));
    }

    public boolean tryPlaceAsBlock(RaycastCollision rc, Block block, EntityPlayer player, ItemStack item_stack) {
        if (block == Blocks.BlockBamboo) {
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
            if (Blocks.BlockBamboo.tryPlaceBlock(rc.world, x, ++y, z, EnumFace.TOP, 0, player, true, true))
                return true;
        }
        return super.tryPlaceAsBlock(rc, block, player, item_stack);
    }
}