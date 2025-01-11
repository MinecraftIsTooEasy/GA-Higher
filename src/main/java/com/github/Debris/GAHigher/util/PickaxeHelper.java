package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.item.Items;
import net.minecraft.BlockBreakInfo;
import net.minecraft.EntityPlayer;

public class PickaxeHelper {

    public static boolean isPreciousPickaxe(int itemID) {
        return itemID == Items.B_PICKAXE.itemID || itemID == Items.C_PICKAXE.itemID || itemID == Items.D_PICKAXE.itemID || itemID == Items.E_PICKAXE.itemID;
    }

    public static int performPickaxe(EntityPlayer MMPlayer, BlockBreakInfo info, int II, int count) {
        String var12 = MMPlayer.getDirectionFromYaw().toString();
        byte var13 = getDirection(var12);

        if (II == Items.B_PICKAXE.itemID) {
            count = PickaxeHelper.BLevel(info, var13, count);
        }
        if (II == Items.C_PICKAXE.itemID) {
            count = PickaxeHelper.CLevel(info, var13, count);
        }
        if (II == Items.D_PICKAXE.itemID) {
            count = PickaxeHelper.DLevel(info, var13, count);
        }
        if (II == Items.E_PICKAXE.itemID) {
            count = PickaxeHelper.ELevel(info, var13, count);
        }

        return count;
    }

    private static byte getDirection(String var12) {
        switch (var12.hashCode()) {
            case 2120701:
                if (var12.equals("EAST"))
                    return 0;
                break;
            case 2660783:
                if (var12.equals("WEST"))
                    return 1;
                break;
            case 74469605:
                if (var12.equals("NORTH"))
                    return 2;
                break;
            case 79090093:
                if (var12.equals("SOUTH"))
                    return 3;
                break;
        }
        return -1;
    }


    public static int BLevel(BlockBreakInfo info, byte var13, int count) {
        int x = info.x;
        int y = info.y;
        int z = info.z;
        int dx;
        switch (var13) {
            case 0:
                dx = 0;
                while (dx <= 2) {
                    if (info.world.getBlockId(x + dx, y, z) == 1) {
                        info.world.setBlock(x + dx, y, z, 0, 8, 3);
                        count++;
                    }
                    dx++;
                }
                break;
            case 1:
                dx = -2;
                while (dx <= 0) {
                    if (info.world.getBlockId(x + dx, y, z) == 1) {
                        info.world.setBlock(x + dx, y, z, 0, 8, 3);
                        count++;
                    }
                    dx++;
                }
                break;
            case 2:
                dx = -2;
                while (dx <= 0) {
                    if (info.world.getBlockId(x, y, z + dx) == 1) {
                        info.world.setBlock(x, y, z + dx, 0, 8, 3);
                        count++;
                    }
                    dx++;
                }
                break;
            case 3:
                for (dx = 0; dx <= 2; dx++) {
                    if (info.world.getBlockId(x, y, z + dx) == 1) {
                        info.world.setBlock(x, y, z + dx, 0, 8, 3);
                        count++;
                    }
                }
                break;
        }
        return count;
    }


    public static int CLevel(BlockBreakInfo info, byte var13, int count) {
        int x = info.x;
        int y = info.y;
        int z = info.z;
        int dx;
        switch (var13) {
            case 0:
                for (dx = 0; dx <= 2; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                            info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                            count++;
                        }
                    }
                }
                break;
            case 1:
                dx = -2;
                while (dx <= 0) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                            info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                            count++;
                        }
                    }
                    dx++;
                }
                break;
            case 2:
                dx = -2;
                while (dx <= 0) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                            info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                            count++;
                        }
                    }
                    dx++;
                }
                break;
            case 3:
                for (dx = 0; dx <= 2; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                            info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                            count++;
                        }
                    }
                }
                break;
        }
        return count;
    }


    public static int DLevel(BlockBreakInfo info, byte var13, int count) {
        int x = info.x;
        int y = info.y;
        int z = info.z;

        int dx;
        switch (var13) {
            case 0:
                for (dx = 0; dx <= 2; dx++) {
                    int dy;
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                            info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                            count++;
                        }
                    }
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dx, y, z + dy) == 1) {
                            info.world.setBlock(x + dx, y, z + dy, 0, 8, 3);
                            count++;
                        }
                    }
                }
                break;
            case 1:
                dx = -2;
                while (dx <= 0) {
                    int dy;
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                            info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                            count++;
                        }
                    }
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dx, y, z + dy) == 1) {
                            info.world.setBlock(x + dx, y, z + dy, 0, 8, 3);
                            count++;
                        }
                    }
                    dx++;
                }
                break;
            case 2:
                dx = -2;
                while (dx <= 0) {
                    int dy;
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                            info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                            count++;
                        }
                    }
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dy, y, z + dx) == 1) {
                            info.world.setBlock(x + dy, y, z + dx, 0, 8, 3);
                            count++;
                        }
                    }
                    dx++;
                }
                break;
            case 3:
                for (dx = 0; dx <= 2; dx++) {
                    int dy;
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                            info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                            count++;
                        }
                    }
                    for (dy = -1; dy <= 1; dy++) {
                        if (info.world.getBlockId(x + dy, y, z + dx) == 1) {
                            info.world.setBlock(x + dy, y, z + dx, 0, 8, 3);
                            count++;
                        }
                    }
                }
                break;
        }
        return count;
    }


    public static int ELevel(BlockBreakInfo info, byte var13, int count) {
        int x = info.x;
        int y = info.y;
        int z = info.z;

        int dx;
        switch (var13) {
            case 0:
                for (dx = 0; dx <= 2; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        for (int dz = -1; dz <= 1; dz++) {
                            if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                count++;
                            }
                        }
                    }
                }
                break;
            case 1:
                dx = -2;
                while (dx <= 0) {
                    for (int dy = -1; dy <= 1; dy++) {
                        for (int dz = -1; dz <= 1; dz++) {
                            if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                count++;
                            }
                        }
                    }
                    dx++;
                }
                break;
            case 2:
                dx = -1;
                while (dx <= 1) {
                    for (int dy = -1; dy <= 1; dy++) {
                        for (int dz = -2; dz <= 0; dz++) {
                            if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                count++;
                            }
                        }
                    }
                    dx++;
                }
                break;
            case 3:
                for (dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        for (int dz = 0; dz <= 2; dz++) {
                            if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                count++;
                            }
                        }
                    }
                }
                break;
        }
        return count;
    }
}
