package com.github.Debris.GAHigher.config;

import com.github.Debris.GAHigher.GAStart;
import fi.dy.masa.malilib.config.ConfigTab;
import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.ConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.config.options.ConfigInteger;

import java.util.ArrayList;
import java.util.List;

public class GAConfigManyLib extends SimpleConfigs {
    private static final GAConfigManyLib Instance;

    public static GAConfigManyLib getInstance() {
        return Instance;
    }

    public static final List<ConfigHotkey> hotkeys;
    public static final List<ConfigBase<?>> data;
    public static final List<ConfigBase<?>> function;
    public static final List<ConfigBase<?>> values;

    public static final ConfigBoolean OverrideEmi = new ConfigBoolean("是否覆写Emi列数", true, "因为emi有可能挡住珠宝栏, 这个功能会自动设置emi的列数");

    public static final ConfigInteger OverrideEmiColumn = new ConfigInteger("覆写Emi列数", 8, 0, 32, "界面尺寸为自动时生效; 因为emi有可能挡住珠宝栏; 设置成0取消覆写");

    public static final ConfigInteger OverrideEmiColumnWiden = new ConfigInteger("覆写Emi列数(物品栏扩大时)", 4, 0, 32, "界面尺寸为自动时生效; 因为emi有可能挡住珠宝栏; 设置成0取消覆写");

    public static final ConfigInteger DropJewelryRate = new ConfigInteger("饰品掉率", 10000, 1, Integer.MAX_VALUE, "击杀普通怪物时掉率");

    public static final ConfigHotkey Shop = new ConfigHotkey("打开商店", "V", null);

    public static final ConfigHotkey OpenConfig = new ConfigHotkey("打开配置", "G,C", null);

    public static final List<ConfigTab> tabs;

    @Override
    public List<ConfigTab> getConfigTabs() {
        return tabs;
    }

    public GAConfigManyLib() {
        super(GAStart.MOD_ID + "-ManyLib", hotkeys, values);
    }

    static {
        hotkeys = List.of(Shop, OpenConfig);
        data = List.of(DropJewelryRate);
        function = List.of(OverrideEmi, OverrideEmiColumn, OverrideEmiColumnWiden);

        tabs = new ArrayList<>();
        tabs.add(new ConfigTab("游戏数据", data));
        tabs.add(new ConfigTab("功能配置", function));
        tabs.add(new ConfigTab("hotkey", hotkeys));

        values = new ArrayList<>();
        values.addAll(data);
        values.addAll(function);

        Instance = new GAConfigManyLib();
    }
}
