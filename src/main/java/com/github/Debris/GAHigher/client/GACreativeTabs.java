package com.github.Debris.GAHigher.client;

import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.item.Items;
import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import net.minecraft.CreativeTabs;

public class GACreativeTabs {
    public static final CreativeTabs GAItem = new GlacierCreativeTabs("gaHigher.item") {
        @Override
        public int getTabIconItemIndex() {
            return Items.GABag.itemID;
        }
    };
    public static final CreativeTabs GABlock = new GlacierCreativeTabs("gaHigher.block") {
        @Override
        public int getTabIconItemIndex() {
            return Blocks.blockColorful.blockID;
        }
    };
}
