package com.github.Debris.GAHigher.registry;

import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.item.Items;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

import java.util.function.Consumer;

public class CraftingRegistry implements Consumer<CraftingRecipeRegisterEvent> {
    @Override
    public void accept(CraftingRecipeRegisterEvent event) {
        Blocks.registerRecipes(event);
        Items.registerRecipes(event);
    }
}
