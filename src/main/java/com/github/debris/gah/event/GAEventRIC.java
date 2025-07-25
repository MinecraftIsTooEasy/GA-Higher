package com.github.debris.gah.event;

import com.github.debris.gah.config.Configs;
import com.github.debris.gah.event.listener.*;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.registry.CraftingRegistry;
import moddedmite.rustedironcore.api.event.Handlers;
import net.minecraft.ItemStack;

public class GAEventRIC extends Handlers {
    public static void registerEvents() {
        if (Configs.wenscConfig.BlnGravel.ConfigValue) {
            GravelDrop.register(new GravelListener());
        }

        PlayerEvent.register(new PlayerListener());

        Combat.register(new CombatListener());

        PlayerAttribute.register(new PlayerAttributeListener());

        Crafting.register(new CraftingRegistry());

        LootTable.register(new LootTableListener());

        ArmorModel.register(new ArmorModelListener());

        BiomeDecoration.register(new BiomeDecorationListener());

        Smelting.register(event -> {
            event.register(Items.Drug_YD.itemID, new ItemStack(Items.Drug_YD_B, 1));
        });

        Trading.register(new TradingListener());
    }
}
