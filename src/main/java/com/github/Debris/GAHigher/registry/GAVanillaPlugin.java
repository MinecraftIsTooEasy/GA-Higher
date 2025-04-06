package com.github.Debris.GAHigher.registry;

import com.github.Debris.GAHigher.api.GAItem;
import com.github.Debris.GAHigher.api.GAPlugin;
import com.github.Debris.GAHigher.api.GARegistry;
import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.item.ITECompatImpl;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.item.jewelry.ItemJewelry;

public class GAVanillaPlugin implements GAPlugin {
    @Override
    public void register(GARegistry registry) {
        this.registerPrices(registry);
    }

    private void registerPrices(GARegistry registry) {
        ((GAItem) Items.manure).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.seeds).ga$setSoldPriceForAllSubs(0.25D);
        ((GAItem) Items.sinew).ga$setSoldPriceForAllSubs(0.25D);
        ((GAItem) Items.leather).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.silk).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.feather).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.flint).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.chipFlint).ga$setSoldPriceForAllSubs(0.5D);
        ((GAItem) Items.shardObsidian).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.shardEmerald).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.shardDiamond).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.redstone).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.coal).ga$setSoldPriceForAllSubs(5.0D);
        ((GAItem) Items.bone).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.gunpowder).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.rottenFlesh).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.spiderEye).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.doorWood).ga$setSoldPriceForAllSubs(10.0D);
        ((GAItem) Items.doorCopper).ga$setSoldPriceForAllSubs(60.0D);
        ((GAItem) Items.doorSilver).ga$setSoldPriceForAllSubs(60.0D);
        ((GAItem) Items.doorGold).ga$setSoldPriceForAllSubs(60.0D);
        ((GAItem) Items.doorIron).ga$setSoldPriceForAllSubs(120.0D);
        ((GAItem) Items.doorAncientMetal).ga$setSoldPriceForAllSubs(180.0D);
        ((GAItem) Items.doorMithril).ga$setSoldPriceForAllSubs(240.0D);
        ((GAItem) Items.doorAdamantium).ga$setSoldPriceForAllSubs(480.0D);
        ((GAItem) Items.ingotCopper).ga$setSoldPriceForAllSubs(10.0D);
        ((GAItem) Items.ingotSilver).ga$setSoldPriceForAllSubs(10.0D);
        ((GAItem) Items.ingotGold).ga$setSoldPriceForAllSubs(10.0D);
        ((GAItem) Items.ingotIron).ga$setSoldPriceForAllSubs(20.0D);
        ((GAItem) Items.ingotAncientMetal).ga$setSoldPriceForAllSubs(30.0D);
        ((GAItem) Items.ingotMithril).ga$setSoldPriceForAllSubs(40.0D);
        ((GAItem) Items.ingotAdamantium).ga$setSoldPriceForAllSubs(80.0D);
        ((GAItem) Items.minecartEmpty).ga$setSoldPriceForAllSubs(100.0D);
        ((GAItem) Items.saddle).ga$setSoldPriceForAllSubs(5.0D);
        ((GAItem) Items.copperNugget).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.silverNugget).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.goldNugget).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.ironNugget).ga$setSoldPriceForAllSubs(2.0D);
        ((GAItem) Items.ancientMetalNugget).ga$setSoldPriceForAllSubs(3.0D);
        ((GAItem) Items.mithrilNugget).ga$setSoldPriceForAllSubs(4.0D);
        ((GAItem) Items.adamantiumNugget).ga$setSoldPriceForAllSubs(8.0D);
        ((GAItem) Items.Drug_BG).ga$setBuyPriceForAllSubs(1.0D).ga$setSoldPriceForAllSubs(1.0D);
        ((GAItem) Items.pants).ga$setBuyPriceForAllSubs(9.87654721033E9D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful0.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful1.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful2.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful3.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful4.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful5.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful6.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful7.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful8.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful9.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful10.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful11.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful12.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful13.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful14.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful15.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorful.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorfulBrick.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorfulWall.blockID)).ga$setBuyPriceForAllSubs(2.5D).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorfulSingleSlabGroup1)).ga$setBuyPriceForAllSubs(1.25D).ga$setSoldPriceForAllSubs(1.25D);
        ((GAItem) Items.getItem(Blocks.blockColorfulSingleSlabGroup2)).ga$setBuyPriceForAllSubs(1.25D).ga$setSoldPriceForAllSubs(1.25D);
        ((GAItem) Items.getItem(Blocks.blockGotcha.blockID)).ga$setSoldPriceForAllSubs(10.0D).ga$setBuyPriceForAllSubs(10.0D);
        ((GAItem) Items.getItem(Blocks.plantYellow.blockID)).ga$setSoldPriceForAllSubs(0.25D);
        ((GAItem) Items.getItem(Blocks.plantRed.blockID)).ga$setSoldPriceForAllSubs(0.25D);
        ((GAItem) Items.getItem(Blocks.leaves.blockID)).ga$setSoldPriceForAllSubs(0.5D);
//        ((GAItem) Items.getItem(Blocks.leaves1.blockID)).setSoldPrice(0.5D);
        ((GAItem) Items.getItem(Blocks.planks.blockID)).ga$setSoldPriceForAllSubs(1.25D);
        ((GAItem) Items.getItem(Blocks.pumpkin.blockID)).ga$setSoldPriceForAllSubs(2.0D);
        ((GAItem) Items.getItem(Blocks.dirt.blockID)).ga$setSoldPriceForAllSubs(0.5D);
        ((GAItem) Items.getItem(Blocks.sand.blockID)).ga$setSoldPriceForAllSubs(0.5D);
        ((GAItem) Items.getItem(Blocks.cobblestone.blockID)).ga$setSoldPriceForAllSubs(2.5D);
        ((GAItem) Items.getItem(Blocks.stone.blockID)).ga$setSoldPriceForAllSubs(5.0D);
        ((GAItem) Items.getItem(Blocks.cobblestoneWall.blockID)).ga$setSoldPriceForAllSubs(1.5D);
        ((GAItem) Items.getItem(Blocks.wood.blockID)).ga$setSoldPriceForAllSubs(5.0D);
//        ((GAItem) Items.getItem(Blocks.wood1.blockID)).setSoldPrice(5.0D);

        for (ItemJewelry jewelry : Items.jewelries) {
            registry.registerBuyPrice(jewelry, 1024.0D);
        }

        if (ModCompat.HAS_ITE) {
            ITECompatImpl.registerPrices();
        }
    }
}
