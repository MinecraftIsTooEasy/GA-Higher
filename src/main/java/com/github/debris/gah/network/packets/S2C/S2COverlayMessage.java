package com.github.debris.gah.network.packets.S2C;

import com.github.debris.gah.api.GAGuiIngame;
import com.github.debris.gah.network.GANetwork;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketByteBuf;
import net.minecraft.EntityPlayer;
import net.minecraft.Minecraft;
import net.minecraft.ResourceLocation;

public class S2COverlayMessage implements Packet {
    private final int color;

    private final String msg;

    private final int time;

    public S2COverlayMessage(PacketByteBuf packetByteBuf) {
        this(packetByteBuf.readString(), packetByteBuf.readInt(), packetByteBuf.readInt());
    }

    public S2COverlayMessage(String msg, int color, int time) {
        this.msg = msg;
        this.color = color;
        this.time = time;
    }

    public int getColor() {
        return this.color;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public void write(PacketByteBuf packetByteBuf) {
        packetByteBuf.writeString(this.msg);
        packetByteBuf.writeInt(this.color);
        packetByteBuf.writeInt(this.time);
    }

    @Override
    public void apply(EntityPlayer entityPlayer) {
        ((GAGuiIngame) Minecraft.getMinecraft().ingameGUI).setOverlayMsg(this.getMsg(), this.getTime(), this.getColor());
    }

    @Override
    public ResourceLocation getChannel() {
        return GANetwork.OverlayMessage;
    }
}
