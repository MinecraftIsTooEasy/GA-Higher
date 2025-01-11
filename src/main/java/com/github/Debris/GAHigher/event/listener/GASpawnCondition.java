package com.github.Debris.GAHigher.event.listener;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.entity.EntityExchanger;
import moddedmite.rustedironcore.api.event.events.SpawnConditionRegisterEvent;

import java.util.function.Consumer;

public class GASpawnCondition implements Consumer<SpawnConditionRegisterEvent> {
    @Override
    public void accept(SpawnConditionRegisterEvent event) {
        event.register(EntityExchanger.class, (world, x, y, z) -> {
            if (Configs.wenscConfig.isSpawnExchanger.ConfigValue) {
                return EntityExchanger.class;
            }
            return null;
        });
    }
}
