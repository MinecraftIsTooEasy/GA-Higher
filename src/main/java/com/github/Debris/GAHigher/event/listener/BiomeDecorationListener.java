package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.block.Blocks;
import moddedmite.rustedironcore.api.event.events.BiomeDecorationRegisterEvent;
import moddedmite.rustedironcore.api.world.Dimension;
import net.minecraft.WorldGenPlants;

import java.util.function.Consumer;

public class BiomeDecorationListener implements Consumer<BiomeDecorationRegisterEvent> {
    @Override
    public void accept(BiomeDecorationRegisterEvent event) {
        event.register(Dimension.OVERWORLD, new WorldGenPlants(Blocks.BlockTomato));
    }
}
