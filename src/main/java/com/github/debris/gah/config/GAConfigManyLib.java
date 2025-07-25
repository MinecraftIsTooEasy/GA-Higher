package com.github.debris.gah.config;

import com.github.debris.gah.GAStart;
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


    // hotkey
    public static final ConfigHotkey OpenConfig = new ConfigHotkey("打开配置", "G,C", null);


    public static final List<ConfigTab> tabs;

    @Override
    public List<ConfigTab> getConfigTabs() {
        return tabs;
    }

    public GAConfigManyLib() {
        super(GAStart.MOD_NAME + "-ManyLib", hotkeys, values);
    }

    static {
        hotkeys = List.of(OpenConfig);
        data = List.of(DropJewelryRate);
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
