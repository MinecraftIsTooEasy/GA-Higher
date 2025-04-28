package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.item.Items;
import moddedmite.rustedironcore.api.event.events.TradingRegisterEvent;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.MerchantRecipe;

import java.util.function.Consumer;

public class TradingListener implements Consumer<TradingRegisterEvent> {
    @Override
    public void accept(TradingRegisterEvent event) {
        event.getForProfession(0).ifPresent(villagerSettings ->
                villagerSettings.buyEntry(Blocks.BlockGotcha.blockID, 0.5F)
                        .sellEntry(Items.Tomato.itemID, 0.3F)
        );

        event.getForProfession(2).ifPresent(villagerSettings -> {
            villagerSettings.addEntry((recipeList, villager, rand) -> {
                if (rand.nextFloat() < villager.adjustProbability(0.5F))
                    recipeList.add(new MerchantRecipe(new ItemStack(Items.BadApple, 1), new ItemStack(Item.emerald), new ItemStack(Item.appleGold, 1, 1)));
            });
        });

        event.getForProfession(3).ifPresent(villagerSettings ->
                villagerSettings.addEntry((recipeList, villager, rand) -> {
                    if (rand.nextFloat() < villager.adjustProbability(0.2F)) {
                        recipeList.add(new MerchantRecipe(new ItemStack(Items.MITEGA_INGOT, 9), new ItemStack(Items.MITEGA_NUGGET, 1, 0)));
                    }
                }).addEntry((recipeList, villager, rand) -> {
                    if (rand.nextFloat() < villager.adjustProbability(0.2F)) {
                        recipeList.add(new MerchantRecipe(new ItemStack(Items.MITEGA_NUGGET, 1, 0), new ItemStack(Items.MITEGA_INGOT, 9)));
                    }
                }));// TODO vibranium

        event.getForProfession(4).ifPresent(villagerSettings ->
                villagerSettings.sellEntry(Items.Tomato_Omelette.itemID, 0.3F));
    }
}
