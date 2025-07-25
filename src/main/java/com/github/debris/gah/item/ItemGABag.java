package com.github.debris.gah.item;

import com.github.debris.gah.block.Blocks;
import net.minecraft.*;

import java.util.List;

public class ItemGABag extends ItemIngot {
    private final int a;

    public ItemGABag(int par1, Material material) {
        super(par1, material);
        this.a = Blocks.GotchaBox.blockID;
        setMaxStackSize(1);
        setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
    }

    @Override
    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        RaycastCollision rc = player.getSelectedObject(partial_tick, false);
        if (rc != null && rc.isBlock())
            return (!player.worldObj.areSkillsEnabled() || this.a != Blocks.GotchaBox.blockID || player.hasSkill(Skill.FARMING)) && player.tryPlaceHeldItemAsBlock(rc, Block.getBlock(this.a));
        return false;
    }

    public boolean tryPlaceAsBlock(RaycastCollision rc, Block block, EntityPlayer player, ItemStack item_stack) {
        if (block == Block.netherrack) {
            if (rc.getBlockHit() == block) {
                int i = rc.block_hit_x;
                int j = rc.block_hit_y;
                int k = rc.block_hit_z;
                j++;
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
            y++;
            if (Block.netherrack.tryPlaceBlock(rc.world, x, y, z, EnumFace.TOP, 0, player, true, true))
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

    public boolean isHarmedByLava() {
        return false;
    }

    public boolean isHarmedByPepsin() {
        return false;
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("方便又好用", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("大家都说好", new Object[0]));
        }
    }
}
