package com.github.debris.gah.registry;

import com.github.debris.gah.block.Blocks;
import com.github.debris.gah.item.Items;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

import java.util.function.Consumer;

public class CraftingRegistry implements Consumer<CraftingRecipeRegisterEvent> {
    @Override
    public void accept(CraftingRecipeRegisterEvent event) {
        Blocks.registerRecipes(event);
        Items.registerRecipes(event);
    }
}
