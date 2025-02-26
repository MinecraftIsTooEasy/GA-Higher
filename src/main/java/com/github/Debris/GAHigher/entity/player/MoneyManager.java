package com.github.Debris.GAHigher.entity.player;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.network.GANetwork;
import com.github.Debris.GAHigher.network.packets.S2C.S2CSyncMoney;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.EntityPlayer;
import net.minecraft.I18n;
import net.minecraft.NBTTagCompound;
import net.minecraft.ServerPlayer;

import java.math.BigDecimal;

public class MoneyManager extends AbstractManager {
    private double money = 0.0D;

    public MoneyManager(EntityPlayer player) {
        super(player);
    }

    @Override
    public void clone(EntityPlayer entityPlayer) {
        this.money = GAEntityPlayer.getMoneyManager(entityPlayer).money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return this.money;
    }

    @Override
    public void write(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setDouble("money", this.money);
    }

    @Override
    public void read(NBTTagCompound nbtTagCompound) {
        if (nbtTagCompound.hasKey("money")) {
            this.money = nbtTagCompound.getDouble("money");
        }
    }

    public String getMoneyText() {
        return I18n.getStringParams("container.shop.money", String.format("%.2f", this.money));
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void addMoneyWithSimplify(double money) {
        this.money += money;
        this.simplify();
    }

    public void subMoney(double money) {
        this.money -= money;
    }

    public void subMoneyWithSimplify(double money) {
        this.money -= money;
        this.simplify();
    }

    public void simplify() {
        BigDecimal two = new BigDecimal(this.money);
        this.money = two.setScale(2, 4).doubleValue();
    }

    @Environment(EnvType.SERVER)
    public void syncToClient() {
        GANetwork.sendToClient((ServerPlayer) this.player, new S2CSyncMoney(this.money));
    }

    @Environment(EnvType.SERVER)
    public static void syncToClient(ServerPlayer player) {
        GANetwork.sendToClient(player, new S2CSyncMoney(GAEntityPlayer.getMoneyManager(player).money));
    }
}
