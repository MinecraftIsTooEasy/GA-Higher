package com.github.debris.gah.event.listener;

import com.github.debris.gah.block.Blocks;
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
