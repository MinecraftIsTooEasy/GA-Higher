package com.github.Debris.GAHigher.network.packets.C2S;

import com.github.Debris.GAHigher.api.GAPlayer;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.enums.Achievements;
import com.github.Debris.GAHigher.network.GANetwork;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketByteBuf;
import net.minecraft.EntityPlayer;
import net.minecraft.ResourceLocation;

public class C2SOpenShop implements Packet {
    public C2SOpenShop() {
    }

    public C2SOpenShop(PacketByteBuf packetByteBuf) {

    }

    @Override
    public void write(PacketByteBuf packetByteBuf) {

    }

    @Override
    public void apply(EntityPlayer entityPlayer) {
        if (Configs.wenscConfig.isCloseShop.ConfigValue) return;
        ((GAPlayer) entityPlayer).ga$DisplayGUIShop();
        entityPlayer.triggerAchievement(Achievements.openShop);
    }

    @Override
    public ResourceLocation getChannel() {
        return GANetwork.OpenShop;
    }
}
