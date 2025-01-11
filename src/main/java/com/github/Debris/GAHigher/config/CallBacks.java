package com.github.Debris.GAHigher.config;

import com.github.Debris.GAHigher.network.GANetwork;
import com.github.Debris.GAHigher.network.packets.C2S.C2SOpenShop;
import net.minecraft.Minecraft;

public class CallBacks {
    public static void init(Minecraft client) {
        GAConfigManyLib.Shop.getKeybind().setCallback((keyAction, iKeybind) -> {
            GANetwork.sendToServer(new C2SOpenShop());
            return true;
        });

        GAConfigManyLib.OpenConfig.getKeybind().setCallback((keyAction, iKeybind) -> {
            client.displayGuiScreen(GAConfigManyLib.getInstance().getConfigScreen(null));
            return true;
        });
    }
}
