package com.github.Debris.GAHigher.entity.player;

import net.minecraft.EntityPlayer;
import net.minecraft.NBTTagCompound;

public class HomeScrollManager extends AbstractManager {
    private long HomeScrollCD = 0L;

    public HomeScrollManager(EntityPlayer player) {
        super(player);
    }


    public long getHomeScrollCD() {
        return HomeScrollCD;
    }

    public void setHomeScrollCD(long homeScrollCD) {
        HomeScrollCD = homeScrollCD;
    }

    @Override
    public void write(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setLong("HomeScrollCD", HomeScrollCD);
    }

    @Override
    public void read(NBTTagCompound nbtTagCompound) {
        HomeScrollCD = nbtTagCompound.getLong("HomeScrollCD");
    }
}
