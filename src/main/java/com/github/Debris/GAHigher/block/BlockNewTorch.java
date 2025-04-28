//package com.github.Debris.GAHigher.block;
//
//import net.minecraft.*;
//
//import java.util.Random;
//
//public class BlockNewTorch extends BlockMounted {
//    private float crafting_difficulty_as_component;
//
//    protected BlockNewTorch(int par1, Material par2Material) {
//        super(par1, Material.s, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
//        this.crafting_difficulty_as_component = 0.0F;
//        b(true);
//        setMaxStackSize(64);
//        k(10);
//    }
//
//    public BlockNewTorch setCraftingDifficultyAsComponent(float difficulty) {
//        this.crafting_difficulty_as_component = difficulty;
//        return this;
//    }
//
//    public int getBurnTime() {
//        return 3200;
//    }
//
//    public int getHeatLevel() {
//        return 0;
//    }
//
//    public String getMetadataNotes() {
//        String[] array = new String[5];
//        for (int i = 0; i < array.length; i++)
//            array[i] = (i + 1) + "=Mounted " + getDirectionOfSupportBlock(i + 1).getDescriptor(true);
//        return StringHelper.implode(array, ", ", true, false);
//    }
//
//    public boolean isValidMetadata(int metadata) {
//        return (metadata > 0 && metadata < 6);
//    }
//
//    public final int d() {
//        return 2;
//    }
//
//    public EnumFace getFaceMountedTo(int metadata) {
//        if (metadata == 1)
//            return EnumFace.EAST;
//        if (metadata == 2)
//            return EnumFace.WEST;
//        if (metadata == 3)
//            return EnumFace.SOUTH;
//        if (metadata == 4)
//            return EnumFace.NORTH;
//        if (metadata == 5)
//            return EnumFace.TOP;
//        Minecraft.setErrorMessage("getFaceMountedTo: unexpected metadata " + metadata);
//        return null;
//    }
//
//    public final int getDefaultMetadataForFaceMountedTo(EnumFace face) {
//        if (face.isEast())
//            return 1;
//        if (face.isWest())
//            return 2;
//        if (face.isSouth())
//            return 3;
//        if (face.isNorth())
//            return 4;
//        if (face.isTop())
//            return 5;
//        return -1;
//    }
//
//    public boolean updateTick(World world, int x, int y, int z, Random random) {
//        if (super.updateTick(world, x, y, z, random))
//            return true;
//        return false;
//    }
//
//    public void setBlockBoundsBasedOnStateAndNeighbors(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
//        int var7 = par1IBlockAccess.h(par2, par3, par4) & 0x7;
//        float var8 = 0.15F;
//        if (var7 == 1) {
//            setBlockBoundsForCurrentThread(0.0D, 0.20000000298023224D, (0.5F - var8), (var8 * 2.0F), 0.800000011920929D, (0.5F + var8));
//        } else if (var7 == 2) {
//            setBlockBoundsForCurrentThread((1.0F - var8 * 2.0F), 0.20000000298023224D, (0.5F - var8), 1.0D, 0.800000011920929D, (0.5F + var8));
//        } else if (var7 == 3) {
//            setBlockBoundsForCurrentThread((0.5F - var8), 0.20000000298023224D, 0.0D, (0.5F + var8), 0.800000011920929D, (var8 * 2.0F));
//        } else if (var7 == 4) {
//            setBlockBoundsForCurrentThread((0.5F - var8), 0.20000000298023224D, (1.0F - var8 * 2.0F), (0.5F + var8), 0.800000011920929D, 1.0D);
//        } else {
//            var8 = 0.1F;
//            setBlockBoundsForCurrentThread((0.5F - var8), 0.0D, (0.5F - var8), (0.5F + var8), 0.6000000238418579D, (0.5F + var8));
//        }
//    }
//
//    @Override
//    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
//        int var6 = par1World.getBlockMetadata(par2, par3, par4);
//        double var7 = (double)par2 + (double)0.5F;
//        double var9 = (double)par3 + 0.7;
//        double var11 = (double)par4 + (double)0.5F;
//        double var13 = (double)0.22F;
//        double var15 = (double)0.27F;
//        if (var6 == 1) {
//            par1World.spawnParticle(EnumParticle.smoke, var7 - var15, var9 + var13, var11, (double)0.0F, (double)0.0F, (double)0.0F);
//            par1World.spawnParticle(EnumParticle.flame, var7 - var15, var9 + var13, var11, (double)0.0F, (double)0.0F, (double)0.0F);
//        } else if (var6 == 2) {
//            par1World.spawnParticle(EnumParticle.smoke, var7 + var15, var9 + var13, var11, (double)0.0F, (double)0.0F, (double)0.0F);
//            par1World.spawnParticle(EnumParticle.flame, var7 + var15, var9 + var13, var11, (double)0.0F, (double)0.0F, (double)0.0F);
//        } else if (var6 == 3) {
//            par1World.spawnParticle(EnumParticle.smoke, var7, var9 + var13, var11 - var15, (double)0.0F, (double)0.0F, (double)0.0F);
//            par1World.spawnParticle(EnumParticle.flame, var7, var9 + var13, var11 - var15, (double)0.0F, (double)0.0F, (double)0.0F);
//        } else if (var6 == 4) {
//            par1World.spawnParticle(EnumParticle.smoke, var7, var9 + var13, var11 + var15, (double)0.0F, (double)0.0F, (double)0.0F);
//            par1World.spawnParticle(EnumParticle.flame, var7, var9 + var13, var11 + var15, (double)0.0F, (double)0.0F, (double)0.0F);
//        } else {
//            par1World.spawnParticle(EnumParticle.smoke, var7, var9, var11, (double)0.0F, (double)0.0F, (double)0.0F);
//            par1World.spawnParticle(EnumParticle.flame, var7, var9, var11, (double)0.0F, (double)0.0F, (double)0.0F);
//        }
//
//    }
//
//    public int dropBlockAsEntityItem(BlockBreakInfo info) {
//        return super.dropBlockAsEntityItem(info);
//    }
//
//    public void addItemBlockMaterials(ItemBlock item_block) {
//        item_block.addMaterial(new Material[]{Material.wood, Material.coal});
//    }
//
//    public boolean canMountToBlock(int metadata, Block neighbor_block, int neighbor_block_metadata, EnumFace face) {
//        if (face.isTop()) {
//            if (neighbor_block == fence || neighbor_block == netherFence || neighbor_block == cobblestoneWall) {
//                return true;
//            }
//
//            if (neighbor_block != leaves && !(neighbor_block instanceof BlockDirectional) && neighbor_block.isFaceFlatAndSolid(neighbor_block_metadata, face)) {
//                return true;
//            }
//        } else if (face.isSide()) {
//            if (neighbor_block == snow && neighbor_block_metadata > 2) {
//                return true;
//            }
//
//            if (neighbor_block.isSingleSlab()) {
//                if (BlockSlab.isBottom(neighbor_block_metadata)) {
//                    return true;
//                }
//            } else if (neighbor_block instanceof BlockStairs && (neighbor_block_metadata & 4) == 0) {
//                return true;
//            }
//        }
//
//        if (neighbor_block == cloth) {
//            return true;
//        } else if ((neighbor_block instanceof BlockPistonBase || neighbor_block instanceof BlockPistonMoving || neighbor_block instanceof BlockPistonExtension) && face == Block.pistonBase.getFrontFace(neighbor_block_metadata)) {
//            return true;
//        } else {
//            return super.canMountToBlock(metadata, neighbor_block, neighbor_block_metadata, face);
//        }
//    }
//
//    public boolean isSolid(boolean[] is_solid, int metadata) {
//        return false;
//    }
//
//    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
//        return false;
//    }
//}