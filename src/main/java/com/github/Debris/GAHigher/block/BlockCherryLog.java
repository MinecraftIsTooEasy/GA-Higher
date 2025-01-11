//package net.xiaoyu233.mitemod.miteite.block;
//
//import net.minecraft.*;
//
//public class BlockCherryLog extends BlockRotatedPillar {
//
//    private Icon side;
//
//    private Icon top;
//
//    public BlockCherryLog(int id) {
//        super(id, Material.wood);
//        this.modifyMinHarvestLevel(1);
//        this.setHardness(BlockHardness.log);
//        this.setCreativeTab(CreativeTabs.tabBlock);
//    }
//
//    public void registerIcons(IconRegister par1IconRegister) {
//        this.side = par1IconRegister.registerIcon(this.getTextureName() + "_");
//        this.top = par1IconRegister.registerIcon(this.getTextureName() + "_top");
//    }
//
//    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
//        byte var7 = 4;
//        int var8 = var7 + 1;
//        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8)) {
//            for (int var9 = -var7; var9 <= var7; ++var9) {
//                for (int var10 = -var7; var10 <= var7; ++var10) {
//                    for (int var11 = -var7; var11 <= var7; ++var11) {
//                        int dx = par2 + var9;
//                        int dy = par3 + var10;
//                        int dz = par4 + var11;
//                        int var12 = par1World.getBlockId(dx, dy, dz);
//                        if (var12 == Block.leaves.blockID) {
//                            int var13 = par1World.getBlockMetadata(dx, dy, dz);
//                            if ((var13 & 8) == 0) {
//                                par1World.setBlockMetadataWithNotify(dx, dy, dz, var13 | 8, 4);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//
//    @Override
//    protected Icon getSideIcon(int par1) {
//        return this.side;
//    }
//
//    @Override
//    protected Icon getEndIcon(int par1) {
//        return this.top;
//    }
//
//    public int dropBlockAsEntityItem(BlockBreakInfo info) {
//        return info.wasExploded() ? this.dropBlockAsEntityItem(info, Item.stick.itemID, 0, 1, 1.5F) : super.dropBlockAsEntityItem(info);
//    }
//
//    @Override
//    public boolean isValidMetadata(int metadata) {
//        return metadata >= 0 && metadata < 3;
//    }
//
//    @Override
//    public String getMetadataNotes() {
//        return "0 up down, 1 west east, 2 north south";
//    }
//
//    public String getNameDisambiguationForReferenceFile(int metadata) {
//        return "log";
//    }
//}
