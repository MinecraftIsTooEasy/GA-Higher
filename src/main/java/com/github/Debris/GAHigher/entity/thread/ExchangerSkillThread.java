package com.github.Debris.GAHigher.entity.thread;

import com.github.Debris.GAHigher.entity.EntityExchanger;
import net.minecraft.EntityPlayer;

public class ExchangerSkillThread extends Thread {
    public EntityPlayer target;

    public EntityExchanger entityExchanger;

    public ExchangerSkillThread(EntityExchanger entityExchanger) {
        this.target = (EntityPlayer) entityExchanger.getEntityToAttack();
        this.entityExchanger = entityExchanger;
    }

    public void run() {
        try {
            Thread.sleep(100L);
            if (this.target != null) {
                double entiX = this.target.posX;
                double entiY = this.target.posY;
                double entiZ = this.target.posZ;
                double currentX = this.entityExchanger.posX;
                double currentY = this.entityExchanger.posY;
                double currentZ = this.entityExchanger.posZ;
                this.entityExchanger.teleportToTarget(entiX, entiY, entiZ);
                this.target.setPositionAndUpdate(currentX, currentY, currentZ);
            }
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }
    }
}
