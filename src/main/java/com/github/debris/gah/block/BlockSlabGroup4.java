package com.github.debris.gah.block;

import net.minecraft.Block;
import net.minecraft.BlockSlab;
import net.minecraft.Icon;
import net.minecraft.Material;

public class BlockSlabGroup4 extends BlockSlab {
  private static String[] types = new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "light_gray" };
  
  public BlockSlabGroup4(int id, Material material) {
    super(id, material);
    setMaxStackSize(64);
    setCushioning(1000.0F);
    setLightValue(0.5F);
  }
  
  public int getGroup() {
    return 4;
  }
  
  public String[] getTypes() {
    return types;
  }
  
  public boolean isValidMetadata(int metadata) {
    return (metadata >= 0 && metadata < 16);
  }
  
  public int getBlockSubtypeUnchecked(int metadata) {
    return metadata & 0x7;
  }
  
  public float getBlockHardness(int metadata) {
    return getModelBlock(metadata).getBlockHardness(metadata);
  }
  
  public Block getModelBlock(int metadata) {
    return Blocks.blockColorful;
  }
  
  public Icon getIcon(int side, int metadata) {
    Block model_block = getModelBlock(metadata & 0x7);
    return model_block.getIcon(side, model_block.getBlockSubtypeUnchecked(metadata & 0x7));
  }
}
