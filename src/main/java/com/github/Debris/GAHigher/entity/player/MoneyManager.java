package com.github.Debris.GAHigher.entity.player;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import net.minecraft.EntityPlayer;
import net.minecraft.I18n;
import net.minecraft.NBTTagCompound;

import java.math.BigDecimal;

public class MoneyManager extends AbstractManager {
    private double money = 0.0D;

    public MoneyManager(EntityPlayer player) {
        super(player);
    }

    @Override
    public void clone(EntityPlayer entityPlayer) {
        this.money = ((GAEntityPlayer) entityPlayer).getMoneyManager().money;
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
}
