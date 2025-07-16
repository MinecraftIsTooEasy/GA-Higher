package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.util.Constant;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@SuppressWarnings("OverwriteAuthorRequired")
@Mixin(BlockIce.class)// TODO kill overwrite
public class BlockIceMixin extends BlockBreakable {
    protected BlockIceMixin(int par1, String par2Str, Material par3Material, boolean par4, BlockConstants block_constants) {
        super(par1, par2Str, par3Material, par4, block_constants);
    }

    @Inject(method = "dropBlockAsEntityItem", at = @At("HEAD"))
    private void addLoot(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir) {
        EntityPlayer MMPlayer = info.getHarvester().getAsEntityPlayerMP();
        if (info.wasExploded()) return;

        boolean unNatural = BitHelper.isBitSet(info.getMetadata(), 1);
        int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.free_action, MMPlayer.getHeldItemStack());
        if (k > 8) k = 8;
        if (k <= 0) return;

        if (!unNatural && Constant.GARandom.nextInt(100) < k) {
            MMPlayer.dropItem(Items.Powder_Bing.itemID, 1, 1.0F);
        } else {
            MMPlayer.dropItem(Block.ice.blockID, 1, 1.0F);
        }
    }

    @Overwrite
    public boolean updateTick(World world, int x, int y, int z, Random random) {
        if ((!world.isFreezing(x, z) || world.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11 - lightOpacity[this.blockID]) && BlockSnow.canMelt(world, x, y, z)) {
            if (BitHelper.isBitSet(world.getBlockMetadata(x, y, z), 1))
                return false;
            melt(world, x, y, z);
            return true;
        }
        return false;
    }

    public String getMetadataNotes() {
        return "0=Natural, 1=Placed";
    }

    public boolean isValidMetadata(int metadata) {
        return (metadata >= 0 && metadata < 2);
    }

    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
        return 1;
    }
}
