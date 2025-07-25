package com.github.debris.gah.trans.block;

import com.github.debris.gah.item.Items;
import com.github.debris.gah.util.Constant;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@SuppressWarnings("OverwriteAuthorRequired")
@Mixin(BlockNetherrack.class)// TODO kill overwrite
public abstract class BlockNetherrackMixin extends Block {
    protected BlockNetherrackMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (BitHelper.isBitSet(info.getMetadata(), 1))
            return dropBlockAsEntityItem(info, Items.HellStones.itemID);
        EntityPlayer MMPlayer = null;
        try {
            MMPlayer = info.getResponsiblePlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (info.wasExploded() || MMPlayer == null)
            return 0;
        if (BitHelper.isBitSet(info.getMetadata(), 1))
            return super.dropBlockAsEntityItem(info);
        int x = info.x;
        int y = info.y;
        int z = info.z;
        int II = 0;
        int count = 0;
        try {
            II = (info.getHarvesterItem()).itemID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean checkPickaxe = (II == Items.A_PICKAXE.itemID || II == Items.B_PICKAXE.itemID || II == Items.C_PICKAXE.itemID || II == Items.D_PICKAXE.itemID || II == Items.E_PICKAXE.itemID);
        if (checkPickaxe && info.y >= MathHelper.floor_double(MMPlayer.posY - MMPlayer.yOffset)) {
            int dx;
            int dz;
            switch (MMPlayer.getDirectionFromYaw().toString()) {
                case "EAST":
                    for (dx = 0; dx <= 2; dx++) {
                        if (info.world.getBlockId(x + dx, y, z) == 87) {// 87 is netherrack
                            info.world.setBlock(x + dx, y, z, 0, 8, 3);
                            count++;
                        }
                    }
                    break;
                case "WEST":
                    for (dx = -2; dx <= 0; dx++) {
                        if (info.world.getBlockId(x + dx, y, z) == 87) {
                            info.world.setBlock(x + dx, y, z, 0, 8, 3);
                            count++;
                        }
                    }
                    break;
                case "NORTH":
                    for (dz = -2; dz <= 0; dz++) {
                        if (info.world.getBlockId(x, y, z + dz) == 87) {
                            info.world.setBlock(x, y, z + dz, 0, 8, 3);
                            count++;
                        }
                    }
                    break;
                case "SOUTH":
                    for (dz = 0; dz <= 2; dz++) {
                        if (info.world.getBlockId(x, y, z + dz) == 87) {
                            info.world.setBlock(x, y, z + dz, 0, 8, 3);
                            count++;
                        }
                    }
                    break;
            }
            for (int i = 0; i <= count; i++) {
                if (Constant.GARandom.nextInt(100) == 0) {
                    MMPlayer.dropItem(Items.Guilt4, 1);
                    MMPlayer.addExperience(100, true, true);
                    count--;
                }
            }
            if (count > 0) {
                int M1 = Constant.GARandom.nextInt(100);
                int M2 = Constant.GARandom.nextInt(80);
                if (M1 == 0)
                    MMPlayer.addChatMessage("a_pickaxe.msg." + M2);
                MMPlayer.tryDamageHeldItem(DamageSource.generic, count * 160);
                MMPlayer.dropItem(Items.HellStones, count);
            }
        }
        if (Constant.GARandom.nextInt(100) == 0)
            return dropBlockAsEntityItem(info, Items.Guilt4.itemID);
        return dropBlockAsEntityItem(info, Items.HellStones.itemID);
    }

    @Override
    public String getMetadataNotes() {
        return "0=Natural, 1=Placed";
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return (metadata >= 0 && metadata < 2);
    }

    @Override
    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
        return 1;
    }
}
