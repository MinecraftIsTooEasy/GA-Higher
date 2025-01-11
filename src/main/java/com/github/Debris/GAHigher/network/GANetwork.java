package com.github.Debris.GAHigher.network;

import com.github.Debris.GAHigher.GAStart;
import com.github.Debris.GAHigher.network.packets.C2S.C2SOpenShop;
import com.github.Debris.GAHigher.network.packets.C2S.C2SShopIndex;
import com.github.Debris.GAHigher.network.packets.S2C.S2COpenWindow;
import com.github.Debris.GAHigher.network.packets.S2C.S2COverlayMessage;
import com.github.Debris.GAHigher.network.packets.S2C.S2CSyncShopInfo;
import moddedmite.rustedironcore.network.Network;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketReader;
import net.minecraft.ResourceLocation;
import net.minecraft.ServerPlayer;
import net.xiaoyu233.fml.FishModLoader;

public class GANetwork {
    public static final ResourceLocation OpenWindow = new ResourceLocation(GAStart.MOD_ID_COMPACT, "OpenWindow");
    public static final ResourceLocation OverlayMessage = new ResourceLocation(GAStart.MOD_ID_COMPACT, "OverlayMessage");
    public static final ResourceLocation OpenShop = new ResourceLocation(GAStart.MOD_ID_COMPACT, "OpenShop");
    public static final ResourceLocation ShopIndex = new ResourceLocation(GAStart.MOD_ID_COMPACT, "ShopIndex");
    public static final ResourceLocation SyncShopInfo = new ResourceLocation(GAStart.MOD_ID_COMPACT, "SyncShopInfo");

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
        PacketReader.registerClientPacketReader(GANetwork.OpenWindow, S2COpenWindow::new);
        PacketReader.registerClientPacketReader(GANetwork.OverlayMessage, S2COverlayMessage::new);
        PacketReader.registerClientPacketReader(GANetwork.SyncShopInfo, S2CSyncShopInfo::new);
    }

    private static void initServer() {
        PacketReader.registerServerPacketReader(GANetwork.OpenShop, packetByteBuf -> new C2SOpenShop());
        PacketReader.registerServerPacketReader(GANetwork.ShopIndex, C2SShopIndex::new);
    }
}
