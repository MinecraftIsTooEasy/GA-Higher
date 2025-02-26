package com.github.Debris.GAHigher.network.packets.S2C;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.network.GANetwork;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketByteBuf;
import net.minecraft.EntityPlayer;
import net.minecraft.ResourceLocation;

public class S2CSyncMoney implements Packet {
    private final double money;

    public S2CSyncMoney(double money) {
        this.money = money;
    }

    public S2CSyncMoney(PacketByteBuf packetByteBuf) {
        this(packetByteBuf.readDouble());
    }

    @Override
    public void write(PacketByteBuf packetByteBuf) {
        packetByteBuf.writeDouble(this.money);
    }

    @Override
    public void apply(EntityPlayer entityPlayer) {
        GAEntityPlayer.getMoneyManager(entityPlayer).setMoney(this.money);
    }

    @Override
    public ResourceLocation getChannel() {
        return GANetwork.SyncMoney;
    }
}
