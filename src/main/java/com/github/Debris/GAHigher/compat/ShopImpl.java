package com.github.Debris.GAHigher.compat;

import cn.wensc.mitemod.shop.api.ShopItem;
import cn.wensc.mitemod.shop.api.ShopPlugin;
import cn.wensc.mitemod.shop.api.ShopRegistry;
import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.item.jewelry.ItemBauble;
import com.github.Debris.GAHigher.unsafe.ITEAccessor;

public class ShopImpl implements ShopPlugin {
    @Override
    public void register(ShopRegistry registry) {
        ((ShopItem) Items.manure).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.seeds).setSoldPriceForAllSubs(0.25D);
        ((ShopItem) Items.sinew).setSoldPriceForAllSubs(0.25D);
        ((ShopItem) Items.leather).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.silk).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.feather).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.flint).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.chipFlint).setSoldPriceForAllSubs(0.5D);
        ((ShopItem) Items.shardObsidian).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.shardEmerald).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.shardDiamond).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.redstone).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.coal).setSoldPriceForAllSubs(5.0D);
        ((ShopItem) Items.bone).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.gunpowder).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.rottenFlesh).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.spiderEye).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.doorWood).setSoldPriceForAllSubs(10.0D);
        ((ShopItem) Items.doorCopper).setSoldPriceForAllSubs(60.0D);
        ((ShopItem) Items.doorSilver).setSoldPriceForAllSubs(60.0D);
        ((ShopItem) Items.doorGold).setSoldPriceForAllSubs(60.0D);
        ((ShopItem) Items.doorIron).setSoldPriceForAllSubs(120.0D);
        ((ShopItem) Items.doorAncientMetal).setSoldPriceForAllSubs(180.0D);
        ((ShopItem) Items.doorMithril).setSoldPriceForAllSubs(240.0D);
        ((ShopItem) Items.doorAdamantium).setSoldPriceForAllSubs(480.0D);
        ((ShopItem) Items.ingotCopper).setSoldPriceForAllSubs(10.0D);
        ((ShopItem) Items.ingotSilver).setSoldPriceForAllSubs(10.0D);
        ((ShopItem) Items.ingotGold).setSoldPriceForAllSubs(10.0D);
        ((ShopItem) Items.ingotIron).setSoldPriceForAllSubs(20.0D);
        ((ShopItem) Items.ingotAncientMetal).setSoldPriceForAllSubs(30.0D);
        ((ShopItem) Items.ingotMithril).setSoldPriceForAllSubs(40.0D);
        ((ShopItem) Items.ingotAdamantium).setSoldPriceForAllSubs(80.0D);
        ((ShopItem) Items.minecartEmpty).setSoldPriceForAllSubs(100.0D);
        ((ShopItem) Items.saddle).setSoldPriceForAllSubs(5.0D);
        ((ShopItem) Items.copperNugget).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.silverNugget).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.goldNugget).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.ironNugget).setSoldPriceForAllSubs(2.0D);
        ((ShopItem) Items.ancientMetalNugget).setSoldPriceForAllSubs(3.0D);
        ((ShopItem) Items.mithrilNugget).setSoldPriceForAllSubs(4.0D);
        ((ShopItem) Items.adamantiumNugget).setSoldPriceForAllSubs(8.0D);
        ((ShopItem) Items.Drug_BG).setBuyPriceForAllSubs(1.0D).setSoldPriceForAllSubs(1.0D);
        ((ShopItem) Items.Pants).setBuyPriceForAllSubs(9.87654721033E9D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful0.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful1.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful2.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful3.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful4.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful5.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful6.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful7.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful8.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful9.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful10.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful11.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful12.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful13.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful14.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockStairsColorful15.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockColorful.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockColorfulBrick.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockColorfulWall.blockID)).setBuyPriceForAllSubs(2.5D).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.blockColorfulSingleSlabGroup1)).setBuyPriceForAllSubs(1.25D).setSoldPriceForAllSubs(1.25D);
        ((ShopItem) Items.getItem(Blocks.blockColorfulSingleSlabGroup2)).setBuyPriceForAllSubs(1.25D).setSoldPriceForAllSubs(1.25D);
        ((ShopItem) Items.getItem(Blocks.BlockGotcha.blockID)).setSoldPriceForAllSubs(10.0D).setBuyPriceForAllSubs(10.0D);
        ((ShopItem) Items.getItem(Blocks.plantYellow.blockID)).setSoldPriceForAllSubs(0.25D);
        ((ShopItem) Items.getItem(Blocks.plantRed.blockID)).setSoldPriceForAllSubs(0.25D);
        ((ShopItem) Items.getItem(Blocks.leaves.blockID)).setSoldPriceForAllSubs(0.5D);
//        ((ShopItem) Items.getItem(Blocks.leaves1.blockID)).setSoldPrice(0.5D);
        ((ShopItem) Items.getItem(Blocks.planks.blockID)).setSoldPriceForAllSubs(1.25D);
        ((ShopItem) Items.getItem(Blocks.pumpkin.blockID)).setSoldPriceForAllSubs(2.0D);
        ((ShopItem) Items.getItem(Blocks.dirt.blockID)).setSoldPriceForAllSubs(0.5D);
        ((ShopItem) Items.getItem(Blocks.sand.blockID)).setSoldPriceForAllSubs(0.5D);
        ((ShopItem) Items.getItem(Blocks.cobblestone.blockID)).setSoldPriceForAllSubs(2.5D);
        ((ShopItem) Items.getItem(Blocks.stone.blockID)).setSoldPriceForAllSubs(5.0D);
        ((ShopItem) Items.getItem(Blocks.cobblestoneWall.blockID)).setSoldPriceForAllSubs(1.5D);
        ((ShopItem) Items.getItem(Blocks.wood.blockID)).setSoldPriceForAllSubs(5.0D);
//        ((ShopItem) Items.getItem(Blocks.wood1.blockID)).setSoldPrice(5.0D);

        for (ItemBauble jewelry : Items.baubles) {
            registry.registerBuyPrice(jewelry, 1024.0D);
        }

        if (ModCompat.HAS_ITE) {
            ((ShopItem) ITEAccessor.getVibraniumIngot()).setSoldPriceForAllSubs(250.0D);
            ((ShopItem) ITEAccessor.getVibraniumNugget()).setSoldPriceForAllSubs(25.0D);
        }
    }
}
