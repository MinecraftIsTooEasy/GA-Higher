package com.github.Debris.GAHigher.block;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.screen.inventory.InventoryEnderChestTrans;
import net.minecraft.*;

public class BlockGotchaChest extends BlockEnderChest {
    public BlockGotchaChest(int par1) {
        super(par1);
        setMinHarvestLevel(0);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offset_x, float offset_y, float offset_z) {
        if (player.onServer())
            if (canOpenChest(world, x, y, z, player)) {
                InventoryEnderChestTrans inventory = ((GAEntityPlayer) player).ga$getInventoryEnderChestTrans();
                TileEntityEnderChest tile_entity = (TileEntityEnderChest) world.getBlockTileEntity(x, y, z);
                if (inventory != null && tile_entity != null) {
                    inventory.setAssociatedChest(tile_entity);
                    player.displayGUIChest(x, y, z, inventory);
                }
            } else {
                world.playSoundAtBlock(x, y, z, "imported.random.chest_locked", 0.2F);
            }
        return true;
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return dropBlockAsEntityItem(info, Items.GABag.itemID, 0, 1, 1.0F);
    }
}
