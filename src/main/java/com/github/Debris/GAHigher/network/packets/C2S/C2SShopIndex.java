package com.github.Debris.GAHigher.network.packets.C2S;

import com.github.Debris.GAHigher.network.GANetwork;
import com.github.Debris.GAHigher.screen.container.ContainerShop;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketByteBuf;
import net.minecraft.Container;
import net.minecraft.EntityPlayer;
import net.minecraft.ResourceLocation;

public class C2SShopIndex  implements Packet {
    private final int index;

    public C2SShopIndex(int index) {
        this.index = index;
    }

    public C2SShopIndex(PacketByteBuf packetByteBuf) {
        this(packetByteBuf.readInt());
    }

    @Override
    public void write(PacketByteBuf packetByteBuf) {
        packetByteBuf.writeInt(this.index);
    }

    @Override
    public void apply(EntityPlayer entityPlayer) {
        Container var16 = entityPlayer.openContainer;
        if (var16 instanceof ContainerShop) {
            ((ContainerShop)var16).inventory.pageIndex = index;
            ((ContainerShop)var16).inventory.initItemList();
        }
    }

    @Override
    public ResourceLocation getChannel() {
        return GANetwork.ShopIndex;
    }
}
