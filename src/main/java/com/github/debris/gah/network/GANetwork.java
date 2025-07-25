package com.github.debris.gah.network;

import com.github.debris.gah.GAStart;
import com.github.debris.gah.network.packets.S2C.S2COverlayMessage;
import moddedmite.rustedironcore.network.Network;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketReader;
import net.minecraft.ResourceLocation;
import net.minecraft.ServerPlayer;
import net.xiaoyu233.fml.FishModLoader;

public class GANetwork {
    public static final ResourceLocation OverlayMessage = new ResourceLocation(GAStart.NAMESPACE, "OverlayMessage");

    public static void sendToClient(ServerPlayer player, Packet packet) {
        Network.sendToClient(player, packet);
    }

    public static void sendToServer(Packet packet) {
        Network.sendToServer(packet);
    }

    public static void init() {
        if (!FishModLoader.isServer()) {
            initClient();
        }
        initServer();
    }

    private static void initClient() {
        PacketReader.registerClientPacketReader(GANetwork.OverlayMessage, S2COverlayMessage::new);
    }

    private static void initServer() {
    }
}
