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
        ((GAItem) Items.manure).setSoldPrice(1.0D);
        ((GAItem) Items.seeds).setSoldPrice(0.25D);
        ((GAItem) Items.sinew).setSoldPrice(0.25D);
        ((GAItem) Items.leather).setSoldPrice(1.0D);
        ((GAItem) Items.silk).setSoldPrice(1.0D);
        ((GAItem) Items.feather).setSoldPrice(1.0D);
        ((GAItem) Items.flint).setSoldPrice(2.5D);
        ((GAItem) Items.chipFlint).setSoldPrice(0.5D);
        ((GAItem) Items.shardObsidian).setSoldPrice(1.0D);
        ((GAItem) Items.shardEmerald).setSoldPrice(2.5D);
        ((GAItem) Items.shardDiamond).setSoldPrice(2.5D);
        ((GAItem) Items.redstone).setSoldPrice(2.5D);
        ((GAItem) Items.coal).setSoldPrice(5.0D);
        ((GAItem) Items.bone).setSoldPrice(1.0D);
        ((GAItem) Items.gunpowder).setSoldPrice(1.0D);
        ((GAItem) Items.rottenFlesh).setSoldPrice(1.0D);
        ((GAItem) Items.spiderEye).setSoldPrice(1.0D);
        ((GAItem) Items.doorWood).setSoldPrice(10.0D);
        ((GAItem) Items.doorCopper).setSoldPrice(60.0D);
        ((GAItem) Items.doorSilver).setSoldPrice(60.0D);
        ((GAItem) Items.doorGold).setSoldPrice(60.0D);
        ((GAItem) Items.doorIron).setSoldPrice(120.0D);
        ((GAItem) Items.doorAncientMetal).setSoldPrice(180.0D);
        ((GAItem) Items.doorMithril).setSoldPrice(240.0D);
        ((GAItem) Items.doorAdamantium).setSoldPrice(480.0D);
        ((GAItem) Items.ingotCopper).setSoldPrice(10.0D);
        ((GAItem) Items.ingotSilver).setSoldPrice(10.0D);
        ((GAItem) Items.ingotGold).setSoldPrice(10.0D);
        ((GAItem) Items.ingotIron).setSoldPrice(20.0D);
        ((GAItem) Items.ingotAncientMetal).setSoldPrice(30.0D);
        ((GAItem) Items.ingotMithril).setSoldPrice(40.0D);
        ((GAItem) Items.ingotAdamantium).setSoldPrice(80.0D);
        ((GAItem) Items.minecartEmpty).setSoldPrice(100.0D);
        ((GAItem) Items.saddle).setSoldPrice(5.0D);
        ((GAItem) Items.copperNugget).setSoldPrice(1.0D);
        ((GAItem) Items.silverNugget).setSoldPrice(1.0D);
        ((GAItem) Items.goldNugget).setSoldPrice(1.0D);
        ((GAItem) Items.ironNugget).setSoldPrice(2.0D);
        ((GAItem) Items.ancientMetalNugget).setSoldPrice(3.0D);
        ((GAItem) Items.mithrilNugget).setSoldPrice(4.0D);
        ((GAItem) Items.adamantiumNugget).setSoldPrice(8.0D);
        ((GAItem) Items.Drug_BG).setBuyPrice(1.0D).setSoldPrice(1.0D);
        ((GAItem) Items.pants).setBuyPrice(9.87654721033E9D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful0.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful1.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful2.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful3.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful4.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful5.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful6.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful7.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful8.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful9.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful10.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful11.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful12.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful13.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful14.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockStairsColorful15.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorful.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorfulBrick.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorfulWall.blockID)).setBuyPrice(2.5D).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.blockColorfulSingleSlabGroup1)).setBuyPrice(1.25D).setSoldPrice(1.25D);
        ((GAItem) Items.getItem(Blocks.blockColorfulSingleSlabGroup2)).setBuyPrice(1.25D).setSoldPrice(1.25D);
        ((GAItem) Items.getItem(Blocks.blockGotcha.blockID)).setSoldPrice(10.0D).setBuyPrice(10.0D);
        ((GAItem) Items.getItem(Blocks.plantYellow.blockID)).setSoldPrice(0.25D);
        ((GAItem) Items.getItem(Blocks.plantRed.blockID)).setSoldPrice(0.25D);
        ((GAItem) Items.getItem(Blocks.leaves.blockID)).setSoldPrice(0.5D);
//        ((GAItem) Items.getItem(Blocks.leaves1.blockID)).setSoldPrice(0.5D);
        ((GAItem) Items.getItem(Blocks.planks.blockID)).setSoldPrice(1.25D);
        ((GAItem) Items.getItem(Blocks.pumpkin.blockID)).setSoldPrice(2.0D);
        ((GAItem) Items.getItem(Blocks.dirt.blockID)).setSoldPrice(0.5D);
        ((GAItem) Items.getItem(Blocks.sand.blockID)).setSoldPrice(0.5D);
        ((GAItem) Items.getItem(Blocks.cobblestone.blockID)).setSoldPrice(2.5D);
        ((GAItem) Items.getItem(Blocks.stone.blockID)).setSoldPrice(5.0D);
        ((GAItem) Items.getItem(Blocks.cobblestoneWall.blockID)).setSoldPrice(1.5D);
        ((GAItem) Items.getItem(Blocks.wood.blockID)).setSoldPrice(5.0D);
//        ((GAItem) Items.getItem(Blocks.wood1.blockID)).setSoldPrice(5.0D);

        for (ItemJewelry jewelry : Items.jewelries) {
            registry.registerBuyPrice(jewelry, 1024.0D);
        }

        if (ModCompat.HAS_ITE) {
            ITECompatImpl.registerPrices();
        }
    }
}
