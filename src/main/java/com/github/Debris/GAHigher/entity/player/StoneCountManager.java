package com.github.Debris.GAHigher.entity.player;

import net.minecraft.EntityPlayer;
import net.minecraft.NBTTagCompound;

public class StoneCountManager extends AbstractManager {
    private long StoneCount = 0;

    public StoneCountManager(EntityPlayer player) {
        super(player);
    }

    public void addStoneCount(int stoneCount) {
        this.StoneCount += stoneCount;
    }

    public long getStoneCount() {
        return StoneCount;
    }

    public void setStoneCount(long stoneCount) {
        StoneCount = stoneCount;
    }

    @Override
    public void read(NBTTagCompound nbtTagCompound) {
        this.StoneCount = nbtTagCompound.getLong("StoneCount");
    }

    @Override
    public void write(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setLong("StoneCount", this.StoneCount);
    }
}
