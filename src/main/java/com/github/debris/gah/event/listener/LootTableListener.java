package com.github.debris.gah.event.listener;

import com.github.debris.gah.block.Blocks;
import com.github.debris.gah.item.Items;
import moddedmite.rustedironcore.api.event.listener.ILootTableRegisterListener;
import net.minecraft.WeightedRandomChestContent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LootTableListener implements ILootTableRegisterListener {
    private static final Supplier<List<WeightedRandomChestContent>> BlackSmith = () -> List.of(
            new WeightedRandomChestContent(Items.leather_skirt.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.copper_skirt.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.iron_skirt.itemID, 0, 1, 1, 5)
    );

    private static final Supplier<List<WeightedRandomChestContent>> UnderWorldDungeon = () ->
            Arrays.stream(Items.baubles)
                    .map(x -> new WeightedRandomChestContent(x.itemID, 0, 1, 1, 2))
                    .toList();

    @Override
    public void onBlackSmithRegister(List<WeightedRandomChestContent> original) {
        original.addAll(BlackSmith.get());
    }

    @Override
    public void onDungeonUnderworldRegister(List<WeightedRandomChestContent> original) {
        original.addAll(UnderWorldDungeon.get());
        original.add(new WeightedRandomChestContent(Items.Guilt6.itemID, 0, 1, 1, 5));
    }

    @Override
    public void onDungeonOverworldRegister(List<WeightedRandomChestContent> original) {
        original.add(new WeightedRandomChestContent(Items.Guilt5.itemID, 0, 1, 1, 10));
        original.add(new WeightedRandomChestContent(Blocks.BlockTomato.blockID, 0, 1, 5, 5));
    }

    @Override
    public void onFishingRegister(List<WeightedRandomChestContent> original) {
        original.add(new WeightedRandomChestContent(Items.Powder_SHUI.itemID, 0, 1, 1, 10));
        original.add(new WeightedRandomChestContent(Items.Tomato_Bad.itemID, 0, 1, 1, 10));
        original.add(new WeightedRandomChestContent(Items.Bamboo.itemID, 0, 1, 1, 10));
    }

    @Override
    public void onDesertPyramidRegister(List<WeightedRandomChestContent> original) {
        original.add(new WeightedRandomChestContent(Items.YYY.itemID, 0, 1, 1, 1));
        original.add(new WeightedRandomChestContent(Items.Pants.itemID, 0, 1, 1, 1));
    }
}
