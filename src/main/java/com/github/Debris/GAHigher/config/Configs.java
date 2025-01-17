package com.github.Debris.GAHigher.config;

import com.github.Debris.GAHigher.GAStart;
import com.github.Debris.GAHigher.api.GAItem;
import com.github.Debris.GAHigher.api.GAItemStack;
import com.github.Debris.GAHigher.util.PriceStacks;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.minecraft.ItemMap;
import net.minecraft.ItemStack;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Configs {
    public static Map<String, ConfigItem> wenscMap = new HashMap<>();

    public static void loadConfigs() {
        wenscMap.put("BlnGravel", wenscConfig.BlnGravel);
        wenscMap.put("BlnHealth", wenscConfig.BlnHealth);
        wenscMap.put("BlnNutrition", wenscConfig.BlnNutrition);
        wenscMap.put("ExpModifier", wenscConfig.ExpModifier);
        wenscMap.put("MobExpValue", wenscConfig.MobExpValue);
        wenscMap.put("RockExpValue", wenscConfig.RockExpValue);
        wenscMap.put("MeatExpValue", wenscConfig.MeatExpValue);
        wenscMap.put("OreExpValue", wenscConfig.OreExpValue);
        wenscMap.put("MobDropValue", wenscConfig.MobDropValue);
        wenscMap.put("ExpMod", wenscConfig.ExpMod);
        wenscMap.put("netherWartDifficulty", wenscConfig.netherWartDifficulty);
        wenscMap.put("isOpenStrongBoxBreakRecord", wenscConfig.isOpenStrongBoxBreakRecord);
        wenscMap.put("isOpenGAFish", wenscConfig.isOpenGAFish);
        wenscMap.put("isDropZombieBrain", wenscConfig.isDropZombieBrain);
        wenscMap.put("isRecipeRottenSoup", wenscConfig.isRecipeRottenSoup);
        wenscMap.put("isRecipeGAGoldApple", wenscConfig.isRecipeGAGoldApple);
        wenscMap.put("isRecipeGAPickaxe", wenscConfig.isRecipeGAPickaxe);
        wenscMap.put("isDropBlueGem", wenscConfig.isDropBlueGem);
        wenscMap.put("isDropGAStones", wenscConfig.isDropGAStones);
        wenscMap.put("isDropSpiderLegs", wenscConfig.isDropSpiderLegs);
        wenscMap.put("isRecipeGATorch", wenscConfig.isRecipeGATorch);
        wenscMap.put("isRecipeMineralBag", wenscConfig.isRecipeMineralBag);
        wenscMap.put("isRecipeGABag", wenscConfig.isRecipeGABag);
        wenscMap.put("isRecipeRingKiller", wenscConfig.isRecipeRingKiller);
        wenscMap.put("isRecipeDrugProtection", wenscConfig.isRecipeDrugProtection);
        wenscMap.put("isDropCreeper", wenscConfig.isDropCreeper);
        wenscMap.put("isRecipeDrugFull", wenscConfig.isRecipeDrugFull);
        wenscMap.put("isSpawnExchanger", wenscConfig.isSpawnExchanger);
        wenscMap.put("underworldGateOpenDay", wenscConfig.underworldGateOpenDay);
        wenscMap.put("netherGateOpenDay", wenscConfig.netherGateOpenDay);
        wenscMap.put("isCloseShop", wenscConfig.isCloseShop);
        wenscMap.put("enhanceLimit", wenscConfig.enhanceLimit);
        wenscMap.put("boostEnhance", wenscConfig.boostEnhance);
        wenscMap.put("zombieBossSpawnPercent", wenscConfig.zombieBossSpawnPercent);
        String filePth = "config" + File.separator + GAStart.MOD_ID + ".cfg";
        loadFromFile(filePth, (fileObj, properties) -> {
            readConfigFromFile(fileObj, properties);
            packConfigFile(fileObj, properties);
        }, Configs::generateConfigFile);
    }

    public static void loadFromFile(String filePth, BiConsumer<File, Properties> readAction, Consumer<File> generateAction) {
        File fileObj = new File(filePth);
        if (fileObj.exists()) {
            Properties properties = new Properties();
            FileReader fr = null;
            try {
                fr = new FileReader(fileObj);
                properties.load(fr);
                fr.close();
                readAction.accept(fileObj, properties);
            } catch (IOException var7) {
                var7.printStackTrace();
            }
        } else {
            if (!fileObj.getParentFile().exists()) {
                fileObj.getParentFile().mkdirs();
            }
            try {
                if (fileObj.createNewFile()) {
                    fileObj.setExecutable(true);
                    fileObj.setReadable(true);
                    fileObj.setWritable(true);
                    generateAction.accept(fileObj);
                }
            } catch (IOException e) {
                e.printStackTrace();
                JFrame jFrame = new JFrame();
                jFrame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jFrame, "创建wensc.cfg配置文件失败，请尝试在游戏目录中创建config文件夹并重新启动", "错误", 0);
            }
        }
    }

    public static void readConfigFromFile(File file_mite, Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            ConfigItem configItem = wenscMap.get(key);
            if (configItem != null) {
                if (configItem.ConfigValue instanceof Boolean) {
                    configItem.setConfigValue(Boolean.parseBoolean(properties.getProperty(key)));
                } else if (configItem.ConfigValue instanceof Float) {
                    configItem.setConfigValue(Float.parseFloat(properties.getProperty(key)));
                } else if (configItem.ConfigValue instanceof Double) {
                    configItem.setConfigValue(Double.parseDouble(properties.getProperty(key)));
                } else if (configItem.ConfigValue instanceof Integer) {
                    configItem.setConfigValue(Integer.parseInt(properties.getProperty(key)));
                } else {
                    configItem.setConfigValue(properties.getProperty(key));
                }
            }
        }

    }

    public static void packConfigFile(File file, Properties properties) {
        try {
            FileWriter fileWritter = new FileWriter(file, true);
            for (Map.Entry<String, ConfigItem> entry : wenscMap.entrySet()) {
                ConfigItem value = entry.getValue();
                String localValue = properties.getProperty(value.ConfigKey);
                if (localValue == null) {
                    fileWritter.write("// " + value.ConfigComment + "\n");
                    fileWritter.write(value.ConfigKey + "=" + value.ConfigValue + "\n\n");
                }
            }
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateConfigFile(File file) {
        try {
            FileWriter fileWritter = new FileWriter(file);
            fileWritter.write("// MITE-GA-Higher配置文件，说明：【布尔类型：true为开启，false关闭】，在【名称=值】之间/之后不要存在空格或者其他无关字符，【tick：20tick=1秒】\n");
            for (Map.Entry<String, ConfigItem> entry : wenscMap.entrySet()) {
                ConfigItem value = entry.getValue();
                fileWritter.write("// " + value.ConfigComment + "\n");
                fileWritter.write(value.ConfigKey + "=" + value.ConfigValue + "\n\n");
            }
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ConfigItem<T> {
        public String ConfigKey;

        public T ConfigValue;

        public String ConfigComment;

        ConfigItem(String key, T value, String comment) {
            this.ConfigKey = key;
            this.ConfigValue = value;
            this.ConfigComment = comment;
        }

        public T getConfigValue() {
            return this.ConfigValue;
        }

        public void setConfigValue(T configValue) {
            this.ConfigValue = configValue;
        }
    }

    public static class wenscConfig {
        public static ConfigItem<Boolean> BlnGravel = new ConfigItem<>("BlnGravel", (true), "是否增加燧石概率");

        public static ConfigItem<Boolean> BlnHealth = new ConfigItem<>("BlnHealth", (true), "是否开启最大等级500级");

        public static ConfigItem<Boolean> BlnNutrition = new ConfigItem<>("BlnNutrition", (true), "是否开启增加玩家营养值");

        public static ConfigItem<Integer> ExpModifier = new ConfigItem<>("ExpModifier", (5120), "怪经验上限，最大5120");

        public static ConfigItem<Integer> MobExpValue = new ConfigItem<>("MobExpValue", (100), "怪物经验倍率（1-100）");

        public static ConfigItem<Integer> RockExpValue = new ConfigItem<>("RockExpValue", (10), "宝石经验倍率（1-10）");

        public static ConfigItem<Integer> MeatExpValue = new ConfigItem<>("MeatExpValue", (10), "烧肉经验倍率（1-10）");

        public static ConfigItem<Integer> OreExpValue = new ConfigItem<>("OreExpValue", (10), "烧旷经验倍率（1-10）");

        public static ConfigItem<Integer> MobDropValue = new ConfigItem<>("MobDropValue", (100), "娱乐物品掉落几率（1-100）");

        public static ConfigItem<String> ExpMod = new ConfigItem<>("ExpMod", "2", "怪物掉落经验模式，0基础经验，1随天数增加，2随等级增加");

        public static ConfigItem<Integer> netherWartDifficulty = new ConfigItem<>("netherWartDifficulty", (2), "地狱疣生长难度");

        public static ConfigItem<Boolean> isOpenStrongBoxBreakRecord = new ConfigItem<>("isOpenStrongBoxBreakRecord", (true), "是否开启私人箱子破坏记录");

        public static ConfigItem<Boolean> isOpenGAFish = new ConfigItem<>("isOpenGAFish", (true), "是否开启娱乐版钓鱼");

        public static ConfigItem<Boolean> isDropZombieBrain = new ConfigItem<>("isDropZombieBrain", (true), "是否掉落僵尸脑子");

        public static ConfigItem<Boolean> isRecipeRottenSoup = new ConfigItem<>("isRecipeRottenSoup", (true), "是否有腐肉汤配方");

        public static ConfigItem<Boolean> isRecipeGAGoldApple = new ConfigItem<>("isRecipeGAGoldApple", (true), "是否有娱乐版金苹果配方");

        public static ConfigItem<Boolean> isRecipeGAPickaxe = new ConfigItem<>("isRecipeGAPickaxe", (true), "是否有娱乐版镐子配方");

        public static ConfigItem<Boolean> isDropBlueGem = new ConfigItem<>("isDropBlueGem", (true), "是否掉落蓝宝石");

        public static ConfigItem<Boolean> isDropGAStones = new ConfigItem<>("isDropGAStones", (true), "是否掉落石粒");

        public static ConfigItem<Boolean> isDropSpiderLegs = new ConfigItem<>("isDropSpiderLegs", (true), "是否掉落蜘蛛腿");

        public static ConfigItem<Boolean> isRecipeGATorch = new ConfigItem<>("isRecipeGATorch", (true), "是否有娱乐版火把，木材配方");

        public static ConfigItem<Boolean> isRecipeMineralBag = new ConfigItem<>("isRecipeMineralBag", (true), "是否有矿物袋配方");

        public static ConfigItem<Boolean> isRecipeGABag = new ConfigItem<>("isRecipeGABag", (true), "是否有纳戒配方");

        public static ConfigItem<Boolean> isRecipeRingKiller = new ConfigItem<>("isRecipeRingKiller", (true), "是否有魔灵刃配方");

        public static ConfigItem<Boolean> isRecipeDrugProtection = new ConfigItem<>("isRecipeDrugProtection", (true), "是否有筑基丹配方");

        public static ConfigItem<Boolean> isDropCreeper = new ConfigItem<>("isDropCreeper", (true), "是否掉落苦力怕宝宝");

        public static ConfigItem<Boolean> isRecipeDrugFull = new ConfigItem<>("isRecipeDrugFull", (true), "是否有辟谷丹配方");

        public static ConfigItem<Boolean> isSpawnExchanger = new ConfigItem<>("isSpawnExchanger", true, "是否生成转移骷髅");

        public static ConfigItem<Integer> underworldGateOpenDay = new ConfigItem<>("underworldGateOpenDay", (1), "地下世界传送门多少天可以打开(主世界天数)");

        public static ConfigItem<Integer> netherGateOpenDay = new ConfigItem<>("netherGateOpenDay", (1), "地狱传送门多少天可以打开(主世界天数)");

        public static ConfigItem<Boolean> isCloseShop = new ConfigItem<>("isCloseShop", (false), "关闭商店系统");

        public static ConfigItem<Integer> enhanceLimit = new ConfigItem<>("enhanceLimit", (384), "怪物属性增强天数上限");

        public static ConfigItem<Boolean> boostEnhance = new ConfigItem<>("boostEnhance", true, "怪物强化速度翻倍");

        public static ConfigItem<Float> zombieBossSpawnPercent = new ConfigItem<>("zombieBossSpawnPercent", Float.valueOf(1.0F), "挖掘刷怪笼多大几率刷出僵尸BOSS");
    }

    public static void readShopConfigFromFile(File file_mite, Properties properties) {
        PriceStacks.beginLoading();
        try {
            FileWriter fileWriter = new FileWriter(file_mite, true);
            for (Item item : Item.itemsList) {
                if (shouldReadItem(item)) {
                    readOrWritePriceLine(properties, fileWriter, item);
//                        Minecraft.setErrorMessage("配置项：" + item.getItemDisplayName() + " ID: " + item.itemID + " 错误！！！");
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            PriceStacks.endLoading();
            PriceStacks.sortList();
        }
    }

    private static boolean shouldReadItem(Item item) {
        if (item == null) return false;
        if (item instanceof ItemMap) return false;
        if (item instanceof ItemBlock && !((ItemBlock) item).getBlock().canBeCarried()) return false;
        return true;
    }

    public static void readOrWritePriceLine(Properties properties, FileWriter fileWriter, Item item) throws IOException {
        if (item.getHasSubtypes()) {
            List<ItemStack> subs = item.getSubItems();
            for (ItemStack itemStack : subs) {
                writePriceIntoMemory(properties, fileWriter, item, itemStack);
            }
        } else {
            writePriceIntoMemory(properties, fileWriter, item, new ItemStack(item));
        }
    }

    public static void writePriceIntoMemory(Properties properties, FileWriter fileWriter, Item item, ItemStack itemStack) throws IOException {
        int sub = itemStack.getItemSubtype();
        String name = "";
        if (item.getHasSubtypes()) {
            name = itemStack.getUnlocalizedName() + "$" + itemStack.itemID + "$" + sub;
        } else {
            name = itemStack.getUnlocalizedName() + "$" + itemStack.itemID;
        }
        String itemPrice = (String) properties.get(name);
        if (itemPrice != null) {
            String[] soldPriceAndBuyPrice = itemPrice.split(",");
            if (soldPriceAndBuyPrice.length == 2) {
                setPrice(item, sub, itemStack, Double.parseDouble(soldPriceAndBuyPrice[0]), Double.parseDouble(soldPriceAndBuyPrice[1]));
            } else {
                setPrice(item, sub, itemStack, Double.parseDouble(soldPriceAndBuyPrice[0]), 0.0D);
            }
        } else {
            writeShopConfigFormatter(fileWriter, item, itemStack);
        }
    }

    private static void setPrice(Item item, int sub, ItemStack itemStack, double soldPrice, double buyPrice) {
        double soldPriceFromMemory = ((GAItem) item).ga$getSoldPrice(sub);
        if (soldPrice == 0.0D && soldPriceFromMemory > 0.0D) {
            soldPrice = soldPriceFromMemory;
        }
        double buyPriceFromMemory = ((GAItem) item).ga$getBuyPrice(sub);
        if (buyPrice == 0.0D && buyPriceFromMemory > 0.0D) {
            buyPrice = buyPriceFromMemory;
        }

        ((GAItem) item).ga$setSoldPrice(sub, soldPrice);
        ((GAItem) item).ga$setBuyPrice(sub, buyPrice);
        ((GAItemStack) itemStack).setPrice(soldPrice, buyPrice);
        if (soldPrice > 0.0D || buyPrice > 0.0D) {
            PriceStacks.addStack(itemStack);
        }
    }

    public static void writeShopConfigFormatter(FileWriter fileWriter, Item item, ItemStack itemStack) throws IOException {
        int sub = itemStack.getItemSubtype();
        double soldPrice = ((GAItem) item).ga$getSoldPrice(sub);
        double buyPrice = ((GAItem) item).ga$getBuyPrice(sub);
        ((GAItemStack) itemStack).setPrice(soldPrice, buyPrice);
        if (soldPrice > 0.0D || buyPrice > 0.0D)
            PriceStacks.addStack(itemStack);
        if (item.getHasSubtypes()) {
            fileWriter.write("// " + itemStack.getDisplayName() + " ID: " + itemStack.itemID + " meta:" + sub + "\n");
            fileWriter.write(itemStack.getUnlocalizedName() + "$" + item.itemID + "$" + sub + "=" + ((GAItem) item).ga$getSoldPrice(sub) + "," + ((GAItem) item).ga$getBuyPrice(sub) + "\n\n");
        } else {
            fileWriter.write("// " + itemStack.getDisplayName() + " ID: " + item.itemID + "\n");
            fileWriter.write(itemStack.getUnlocalizedName() + "$" + item.itemID + "=" + ((GAItem) item).ga$getSoldPrice(0) + "," + ((GAItem) item).ga$getBuyPrice(0) + "\n\n");
        }
    }

    public static void generateShopConfigFile(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("// MITE-GA-Higher商店配置文件，说明：参数之间使用英文逗号分隔，请严格遵循格式（商品英文名=售出价格,购买价格），价格小于等于0代表不可出售或者不可购买，价格可以为小数，乱改造成无法启动概不负责\n");
            for (Item item : Item.itemsList) {
                if (item != null && (
                        !(item instanceof ItemBlock) || (
                                (ItemBlock) item).getBlock().canBeCarried()))
                    if (!(item instanceof ItemMap))
                        if (item.getHasSubtypes()) {
                            List<ItemStack> subs = item.getSubItems();
                            for (int i = 0; i < subs.size(); i++) {
                                ItemStack itemStack = subs.get(i);
                                writeShopConfigFormatter(fileWriter, item, itemStack);
                            }
                        } else {
                            ItemStack itemStack = new ItemStack(item, 1, 0);
                            writeShopConfigFormatter(fileWriter, item, itemStack);
                        }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            PriceStacks.sortList();
        }
    }

}
