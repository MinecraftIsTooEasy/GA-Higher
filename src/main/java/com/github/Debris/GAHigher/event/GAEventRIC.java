package com.github.Debris.GAHigher.event;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.event.listener.*;
import com.github.Debris.GAHigher.registry.CraftingRegistry;
import moddedmite.rustedironcore.api.event.Handlers;

public class GAEventRIC extends Handlers {
    public static void registerEvents() {
        if (Configs.wenscConfig.BlnGravel.ConfigValue) {
            GravelDrop.register(new GravelListener());
        }

        SpawnCondition.register(new GASpawnCondition());

        PlayerEvent.register(new PlayerListener());

        PropertiesRegistry.register(new PropertyRegistry());

        Combat.register(new CombatListener());

        PlayerAttribute.register(new PlayerAttributeListener());

        Crafting.register(new CraftingRegistry());

        LootTable.register(new LootTableListener());

        ArmorModel.register(new ArmorModelListener());
    }
}
