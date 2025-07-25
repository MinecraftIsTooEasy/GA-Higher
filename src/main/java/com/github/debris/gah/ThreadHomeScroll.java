package com.github.debris.gah;

import net.minecraft.EntityPlayer;
import net.minecraft.MathHelper;
import net.minecraft.Translator;
import net.minecraft.World;

import java.text.DecimalFormat;

public class ThreadHomeScroll extends Thread {
    private static boolean isRunning;

    private final World world;

    private final EntityPlayer player;

    private int ID = 0;

    private double X = 0.0D;

    private double Y = 0.0D;

    private double Z = 0.0D;

    public ThreadHomeScroll(EntityPlayer player, int ID, Double X, Double Y, Double Z) {
        this.player = player;
        this.ID = ID;
        this.X = X.doubleValue();
        this.Y = Y.doubleValue();
        this.Z = Z.doubleValue();
        this.world = player.getWorld();
    }

    public void run() {
        try {
            Thread.sleep(100L);
//            boolean isInvulnerable = this.player.h;
            boolean isInvulnerable = this.player.isEntityInvulnerable();
            if (this.player.getWorld().getDimensionId() != this.ID) {
                if (!isInvulnerable)
                    this.player.setEntityInvulnerable(true);
//                this.player.b(this.ID);
                this.player.travelToDimension(this.ID);
            }
            this.player.setPositionAndUpdate(this.X, this.Y, this.Z);
            if (!isInvulnerable)
                this.player.setEntityInvulnerable(false);
            this.player.addChatMessage("§7§o[Server]:已传送至(§r §6§o" + Translator.getFormatted(MathHelper.floor_double(this.X) + " , " + MathHelper.floor_double(this.Y) + " , " + MathHelper.floor_double(this.Z)) + " §r§7§o)§r");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String Chufa(long a, long b) {
        DecimalFormat dF = new DecimalFormat("0.0000");
        return dF.format(((float) a / (float) b));
    }

//    private void sendChatMsgToAllPlayers(ChatMessage msg) {
//        this.world.getAsWorldServer().p().af().a(ChatMessage.e("[反作弊]:").a(msg));
//    }
}