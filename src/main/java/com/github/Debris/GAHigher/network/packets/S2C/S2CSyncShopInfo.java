package com.github.Debris.GAHigher.network.packets.S2C;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.network.GANetwork;
import com.github.Debris.GAHigher.util.PriceStacks;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketByteBuf;
import net.minecraft.EntityPlayer;
import net.minecraft.ResourceLocation;

public class S2CSyncShopInfo implements Packet {
    private final int shopSize;

    private final double money;

    public S2CSyncShopInfo(int shopSize, double money) {
        this.shopSize = shopSize;
        this.money = money;
    }

    public S2CSyncShopInfo(PacketByteBuf packetByteBuf) {
        this(packetByteBuf.readInt(), packetByteBuf.readDouble());
    }

    @Override
    public void write(PacketByteBuf packetByteBuf) {
        packetByteBuf.writeInt(this.shopSize);
        packetByteBuf.writeDouble(this.money);
    }

    @Override
    public void apply(EntityPlayer entityPlayer) {
        PriceStacks.shopSize = shopSize;
        GAEntityPlayer.getMoneyManager(entityPlayer).setMoney(this.money);
    }

    @Override
    public ResourceLocation getChannel() {
        return GANetwork.SyncShopInfo;
    }
}
