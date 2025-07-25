package com.github.debris.gah.item;

import net.minecraft.ItemVessel;
import net.minecraft.Material;

public class ItemGaBucket extends ItemVessel {
    public ItemGaBucket(int id, Material material, Material contents) {
        super(id, material, contents, 4, 8, 1, "gabucket");
        setCraftingDifficultyAsComponent(10.0F);
    }

    @Override
    public ItemVessel getPeerForContents(Material material) {
        return this;
    }

    @Override
    public ItemVessel getPeerForVesselMaterial(Material material) {
        return this;
    }
// TODO

//    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
//        int x, y, z;
//        RaycastCollision rc = player.getSelectedObject(partial_tick, true);
//        if (rc == null || !rc.isBlock())
//            return false;
//        if (isEmpty()) {
//            Material material;
//            if (rc.getBlockHitMaterial().d()) {
//                x = rc.block_hit_x;
//                y = rc.block_hit_y;
//                z = rc.block_hit_z;
//                material = rc.getBlockHitMaterial();
//            } else {
//                x = rc.neighbor_block_x;
//                y = rc.neighbor_block_y;
//                z = rc.neighbor_block_z;
//                material = rc.getNeighborOfBlockHitMaterial();
//            }
//            if (material == null || !material.d())
//                return false;
//            if (player.inCreativeMode() && !player.canMineAndEditBlock(x, y, z))
//                return false;
//            if (player.onServer() && (
//                    player.inCreativeMode() || ctrl_is_down))
//                rc.world.i(x, y, z);
//            return true;
//        }
//        ItemStack item_stack = player.getHeldItemStack();
//        if (contains(Material.h)) {
//            Block block = rc.getBlockHit();
//            x = rc.block_hit_x;
//            y = rc.block_hit_y;
//            z = rc.block_hit_z;
//            EnumFace face_hit = rc.face_hit;
//            if (rc.world.getBlock(x, y - 1, z) == Block.aF) {
//                block = rc.world.getBlock(x, --y, z);
//                face_hit = EnumFace.TOP;
//            }
//            if (block == Block.aF && face_hit == EnumFace.TOP) {
//                if (BlockSoil.fertilize(rc.world, x, y, z, player.getHeldItemStack(), player)) {
//                    if (player.onServer() && !player.inCreativeMode())
//                        player.convertOneOfHeldItem(new ItemStack((Item) getEmptyVessel()));
//                    return true;
//                }
//                return false;
//            }
//        }
//        if (!player.inCreativeMode() && (rc.getBlockHitMaterial() == getContents() || rc.getNeighborOfBlockHitMaterial() == getContents())) {
//            if (player.onServer())
//                player.convertOneOfHeldItem(new ItemStack((Item) getEmptyVessel()));
//            return true;
//        }
//        if (rc.getBlockHit().isLiquid() || rc.isBlockHitReplaceableBy(getBlockForContents(), 0)) {
//            x = rc.block_hit_x;
//            y = rc.block_hit_y;
//            z = rc.block_hit_z;
//        } else {
//            x = rc.neighbor_block_x;
//            y = rc.neighbor_block_y;
//            z = rc.neighbor_block_z;
//        }
//        if (!player.canPlayerEdit(x, y, z, item_stack))
//            return false;
//        if (tryPlaceContainedLiquid(rc.world, player, x, y, z, shouldContainedLiquidBePlacedAsSourceBlock(player, ctrl_is_down))) {
//            if (player.onServer() && !player.inCreativeMode())
//                player.convertOneOfHeldItem(new ItemStack((Item) getEmptyVessel()));
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean shouldContainedLiquidBePlacedAsSourceBlock(EntityHuman player, boolean ctrl_is_down) {
//        if (player == null)
//            return false;
//        if (player.inCreativeMode())
//            return true;
//        return (ctrl_is_down && player.bJ >= 100);
//    }
//
//    public Block getBlockForContents() {
//        if (contains(Material.h))
//            return (Block) Block.F;
//        if (contains(Material.i))
//            return (Block) Block.H;
//        Minecraft.setErrorMessage("getBlockForContents: no handler for contents " + getContents());
//        return null;
//    }
//
//    public boolean tryPlaceContainedLiquid(World world, EntityHuman player, int x, int y, int z, boolean allow_placement_of_source_block) {
//        if (isEmpty()) {
//            Minecraft.setErrorMessage("tryPlaceContainedLiquid: bucket is empty");
//            return false;
//        }
//        Material material_in_bucket = getContents();
//        if (material_in_bucket == null) {
//            Minecraft.setErrorMessage("tryPlaceContainedLiquid: material in bucket is null");
//            return false;
//        }
//        Material target_block_material = world.g(x, y, z);
//        if (target_block_material.a())
//            return false;
//        boolean placement_prevented = false;
//        if (material_in_bucket.canDouseFire() && world.getBlock(x, y, z) == Block.aw) {
//            if (!world.I)
//                world.douseFire(x, y, z, null);
//            placement_prevented = true;
//        } else if (material_in_bucket == Material.h && world.t.f) {
//            if (!world.I)
//                world.blockFX(EnumBlockFX.steam, x, y, z);
//            placement_prevented = true;
//        }
//        if (!placement_prevented) {
//            if (player != null && !player.inCreativeMode() && material_in_bucket == target_block_material)
//                return true;
//            if (!world.I) {
//                WorldServer world_server = (WorldServer) world;
//                if (!target_block_material.a() && !target_block_material.d() && !world.c(x, y, z))
//                    world.destroyBlock((new BlockBreakInfo(world, x, y, z)).setFlooded((BlockFluids) getBlockForContents()), true);
//                if (material_in_bucket == Material.h && world.g(x, y, z) == Material.i) {
//                    world.tryConvertLavaToCobblestoneOrObsidian(x, y, z);
//                } else {
//                    if (material_in_bucket == Material.h && world.getBlock(x, y - 1, z) == Block.mantleOrCore) {
//                        world.blockFX(EnumBlockFX.steam, x, y, z);
//                        return true;
//                    }
//                    if (material_in_bucket == Material.i && world.g(x, y, z) == Material.h) {
//                        world.tryConvertWaterToCobblestone(x, y, z);
//                    } else {
//                        if (player == null || !player.inCreativeMode())
//                            if (material_in_bucket == Material.h) {
//                                if (!allow_placement_of_source_block) {
//                                    world.scheduleBlockChange(x, y, z, Block.G.blockID, (getBlockForContents()).blockID, 1, 16);
//                                } else if (!player.inCreativeMode()) {
//                                    player.s(-100);
//                                }
//                            } else if (material_in_bucket == Material.i) {
//                                if (!allow_placement_of_source_block) {
//                                    world.scheduleBlockChange(x, y, z, Block.H.blockID, (getBlockForContents()).blockID, 1, 48);
//                                } else if (!player.inCreativeMode()) {
//                                    player.s(-100);
//                                }
//                            }
//                        world.f(x, y, z, (getBlockForContents()).blockID, 0, 3);
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    public int getSimilarityToItem(Item item) {
//        if (item instanceof ItemBucket) {
//            ItemBucket item_bucket = (ItemBucket) item;
//            if (item_bucket.getContents() == getContents())
//                return 99;
//            if (item_bucket.isEmpty() || isEmpty())
//                return 100 - ((getVesselMaterial() == item_bucket.getVesselMaterial()) ? 2 : 3);
//        }
//        return super.getSimilarityToItem(item);
//    }
//
//    public EnumItemInUseAction getItemInUseAction(ItemStack par1ItemStack, EntityHuman player) {
//        return null;
//    }
//
//    public int getBurnTime(ItemStack item_stack) {
//        if (contains(Material.i))
//            return 3200;
//        return 0;
//    }
//
//    public int getHeatLevel(ItemStack item_stack) {
//        if (contains(Material.i))
//            return 3;
//        return 0;
//    }
//
//    public ItemVessel getPeerForContents(Material contents) {
//        return getPeer(getVesselMaterial(), contents);
//    }
//
//    public ItemVessel getPeerForVesselMaterial(Material vessel_material) {
//        return getPeer(vessel_material, getContents());
//    }
//
//    public int d_(ItemStack par1ItemStack) {
//        return 32;
//    }
}