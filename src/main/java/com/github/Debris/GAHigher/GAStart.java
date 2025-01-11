package com.github.Debris.GAHigher;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.config.GAConfigManyLib;
import com.github.Debris.GAHigher.config.GAInit;
import com.github.Debris.GAHigher.event.GAEventFML;
import com.github.Debris.GAHigher.event.GAEventRIC;
import com.github.Debris.GAHigher.network.GANetwork;
import fi.dy.masa.malilib.event.InitializationHandler;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class GAStart implements ModInitializer {

    public static final String MOD_ID = "GA-Higher";
    public static final String MOD_ID_COMPACT = "GA";
    public static final String MOD_VERSION = "15.0.2";

    @Override
    public void onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(new GAEventFML());
        GAEventRIC.registerEvents();
        Configs.loadConfigs();
        GAConfigManyLib.getInstance().load();
        InitializationHandler.getInstance().registerInitializationHandler(new GAInit());
        GANetwork.init();
    }
}
