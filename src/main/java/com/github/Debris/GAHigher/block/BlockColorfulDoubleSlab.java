package com.github.Debris.GAHigher.block;

import net.minecraft.*;

import java.util.List;

public class BlockColorfulDoubleSlab extends BlockDoubleSlab {
  private BlockSlab single_slab;
  
  public BlockColorfulDoubleSlab(int id, BlockSlab single_slab) {
    super(id, single_slab);
    setMaxStackSize(64);
    setCushioning(1000.0F);
    setLightValue(0.75F);
  }
  
  public boolean isValidMetadata(int metadata) {
    return (metadata < 16 && getSingleSlab().isValidMetadata(metadata));
  }
  
  public String getMetadataNotes() {
    return "All bits are used for subtype";
  }
  
  private BlockSlab getSingleSlab() {
    if (this.single_slab == null)
      this.single_slab = (BlockSlab)Block.getBlock(this.blockID + 1); 
    return this.single_slab;
  }
  
  public void registerIcons(IconRegister par1IconRegister) {}
  
  public Icon getIcon(int side, int metadata) {
    return this.single_slab.getIcon(side, metadata);
  }
  
  public int getBlockSubtypeUnchecked(int metadata) {
    return getSingleSlab().getBlockSubtypeUnchecked(metadata);
  }
  
  public int idPicked(World world, int x, int y, int z) {
    return this.single_slab.blockID;
  }
  
  public boolean canBeCarried() {
    return false;
  }
  
  public int dropBlockAsEntityItem(BlockBreakInfo info) {
    if (info.wasExploded()) {
      Object model_block;
      if (this.blockMaterial == Material.stone) {
        model_block = Blocks.blockColorful;
        info.setMetadata(info.getMetadata());
      } else {
        Minecraft.setErrorMessage("dropBlockAsEntityItem: blockMaterial " + this.blockMaterial + " not handled");
        model_block = null;
      } 
      return (model_block == null) ? 0 : ((Block)model_block).dropBlockAsEntityItem(info);
    } 
    return dropBlockAsEntityItem(info, createStackedBlock(info.getMetadata()));
  }
  
  public String getNameDisambiguationForReferenceFile(int metadata) {
    return "double";
  }
  
  public float getBlockHardness(int metadata) {
    return this.single_slab.getBlockHardness(metadata) * 2.0F;
  }
  
  public int getMinHarvestLevel(int metadata) {
    return this.single_slab.getMinHarvestLevel(metadata);
  }
  
  public ItemStack createStackedBlock(int metadata) {
    ItemStack item_stack = this.single_slab.createStackedBlock(metadata);
    item_stack.stackSize *= 2;
    return item_stack;
  }
  
  public void getItemStacks(int id, CreativeTabs creative_tabs, List list) {
    if (creative_tabs == null)
      super.getItemStacks(id, creative_tabs, list); 
  }
}
