package com.github.Debris.GAHigher.entity.player;

import net.minecraft.EntityPlayer;
import net.minecraft.NBTTagCompound;

public abstract class AbstractManager {
    protected final EntityPlayer player;

    public AbstractManager(EntityPlayer player) {
        this.player = player;
    }

    public void tick() {

    }

    public void write(NBTTagCompound nbtTagCompound) {

    }

    public void read(NBTTagCompound nbtTagCompound) {

    }

    public void clone(EntityPlayer entityPlayer) {

    }
}
