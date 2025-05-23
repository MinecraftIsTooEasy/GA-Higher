package com.github.Debris.GAHigher;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.config.GAConfigManyLib;
import com.github.Debris.GAHigher.config.GAInit;
import com.github.Debris.GAHigher.event.GAEventFML;
import com.github.Debris.GAHigher.event.GAEventRIC;
import com.github.Debris.GAHigher.network.GANetwork;
import fi.dy.masa.malilib.event.InitializationHandler;
import moddedmite.rustedironcore.api.util.FabricUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.Version;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class GAStart implements ModInitializer {
    public static final String MOD_ID = "ga-higher";
    public static final String MOD_NAME = "GA-Higher";
    public static final String MOD_VERSION = FabricUtil.getModVersion(MOD_ID).map(Version::getFriendlyString).orElse("?.?.?");
    public static final String NAMESPACE = "ga";

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
