package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({BlockTallGrass.class})
public class BlockLongGrassTrans extends BlockPlant {
    protected BlockLongGrassTrans(int id) {
        super(id, Material.grass);
        float size = 0.4F;
        setBlockBoundsForAllThreads((0.5F - size), 0.0D, (0.5F - size), (0.5F + size), 0.800000011920929D, (0.5F + size));
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (!info.wasSelfDropped() && !info.wasNotLegal()) {
            if (info.wasHarvestedByPlayer() && getItemSubtype(info.getMetadata()) == 1) {
                int check = Constant.GARandom.nextInt(100);
                ServerPlayer serverPlayer = info.getResponsiblePlayer().getAsEntityPlayerMP();
                if (check == 0)
                    return dropBlockAsEntityItem(info, Item.pumpkinSeeds.itemID, 0, 1, 1.0F);
                if (check == 1)
                    return dropBlockAsEntityItem(info, Item.pumpkinSeeds.itemID, 0, 1, 1.0F);
                if (check == 3 && serverPlayer.hasFullHealth()) {
                    serverPlayer.setHealth(serverPlayer.getHealthLimit() - 1.0F, true, null);
                    serverPlayer.getWorld().playSoundAtEntity(serverPlayer, "imported.random.level_drain", 1.0F);
                    serverPlayer.addChatMessage("grass.snake.msg");
                }
                return dropBlockAsEntityItem(info, Item.seeds.itemID, 0, 1, 1.0F);
            }
            return 0;
        }
        return super.dropBlockAsEntityItem(info);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        if (world.getBlockId(x, y - 1, z) == dirt.blockID)
            world.setBlock(x, y - 1, z, BlockTallGrass.grass.blockID);
    }
}
