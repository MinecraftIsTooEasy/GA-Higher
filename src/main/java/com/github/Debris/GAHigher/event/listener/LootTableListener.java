package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.item.Items;
import moddedmite.rustedironcore.api.event.listener.ILootTableRegisterListener;
import net.minecraft.WeightedRandomChestContent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LootTableListener implements ILootTableRegisterListener {
    @Override
    public void onBlackSmithRegister(List<WeightedRandomChestContent> original) {
        original.addAll(BlackSmith.get());
    }

    private static final Supplier<List<WeightedRandomChestContent>> BlackSmith = () -> List.of(
            new WeightedRandomChestContent(Items.leather_skirt.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.copper_skirt.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.iron_skirt.itemID, 0, 1, 1, 5)
    );

    @Override
    public void onDungeonUnderworldRegister(List<WeightedRandomChestContent> original) {
        original.addAll(UnderWorldDungeon.get());
    }

    private static final Supplier<List<WeightedRandomChestContent>> UnderWorldDungeon = () ->
            Arrays.stream(Items.jewelries)
                    .map(x -> new WeightedRandomChestContent(x.itemID, 0, 1, 1, 2))
                    .toList();
}
