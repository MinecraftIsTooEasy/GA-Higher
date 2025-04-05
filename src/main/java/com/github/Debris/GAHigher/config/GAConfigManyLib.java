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

    // functions
    public static final ConfigBoolean PriceConfigStrongOverride = new ConfigBoolean("商店价格强覆写", true, "强覆写: 完全按配置文件\n 弱覆写: 同时考虑了硬编码");
    public static final ConfigBoolean PriceOnTooltip = new ConfigBoolean("物品价格显示", true);


    // data
    public static final ConfigInteger DropJewelryRate = new ConfigInteger("饰品掉率", 10000, 1, Integer.MAX_VALUE, "击杀普通怪物时掉率");
    public static final ConfigInteger VibraniumWorkbenchSpeed = new ConfigInteger("振金工作台速度", 25, 1, 100, "25为原版极限速度, 再高可能引发崩溃");


    // hotkey
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
        data = List.of(DropJewelryRate, VibraniumWorkbenchSpeed);
        function = List.of(PriceConfigStrongOverride, PriceOnTooltip);

        tabs = new ArrayList<>();
        tabs.add(new ConfigTab("游戏数据", data));
        tabs.add(new ConfigTab("功能配置", function));
        tabs.add(new ConfigTab("热键", hotkeys));

        values = new ArrayList<>();
        values.addAll(data);
        values.addAll(function);

        Instance = new GAConfigManyLib();
    }
}
