package com.github.debris.gah.item;

import com.github.debris.gah.api.GAEntityPlayer;
import net.minecraft.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.zip.CRC32;

public class ItemYinYangYu extends Item {
    private static final String[] Dan = new String[]{"金", "木", "水", "火", "土"};

    private static final String[] Yi = new String[]{"风", "雷", "冰", "暗"};

    public ItemYinYangYu(int par1) {
        super(par1, Material.diamond, "yinyangyu");
        setMaxStackSize(1);

        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        if (player.onServer()) {
            ItemStack heldItemStack = player.getHeldItemStack();
            if (ctrl_is_down) {
                String name = player.getCommandSenderName();
                Random R = new Random(getCRC32(name));
                int chance = R.nextInt(1000);
                StringBuilder Soul = new StringBuilder();
                if (chance < 20) {
                    Soul = new StringBuilder(Dan[R.nextInt(Dan.length)]);
                    player.addChatMessage("§7[Server]:§r §6" + name + "§r §b" + Soul + "§r §7属性单灵根§r");
                } else if (chance < 30) {
                    Soul = new StringBuilder(Yi[R.nextInt(Yi.length)]);
                    player.addChatMessage("§7[Server]:§r §6" + name + "§r §b" + Soul + "§r §7属性单灵根§r");
                } else if (chance < 50) {
                    ArrayList<String> Gen = new ArrayList<>(Arrays.asList(new String[]{"金", "木", "水", "火", "土"}));
                    Soul = new StringBuilder();
                    for (int i = 0; i < 2; i++) {
                        int AddOne = R.nextInt(Gen.size());
                        Soul.append(Gen.get(AddOne));
                        Gen.remove(AddOne);
                    }
                    player.addChatMessage("§7[Server]:§r §6" + name + "§r §b" + Soul + "§r §7属性双灵根§r");
                } else if (chance < 70) {
                    ArrayList<String> Gen = new ArrayList<>(Arrays.asList(new String[]{"金", "木", "水", "火", "土"}));
                    Soul = new StringBuilder();
                    for (int i = 0; i < 3; i++) {
                        int AddOne = R.nextInt(Gen.size());
                        Soul.append(Gen.get(AddOne));
                        Gen.remove(AddOne);
                    }
                    player.addChatMessage("§7[Server]:§r §6" + name + "§r §b" + Soul + "§r §7属性三灵根§r");
                } else if (chance < 90) {
                    ArrayList<String> Gen = new ArrayList<>(Arrays.asList(new String[]{"金", "木", "水", "火", "土"}));
                    Soul = new StringBuilder();
                    for (int i = 0; i < 4; i++) {
                        int AddOne = R.nextInt(Gen.size());
                        Soul.append(Gen.get(AddOne));
                        Gen.remove(AddOne);
                    }
                    player.addChatMessage("§7[Server]:§r §6" + name + "§r §b" + Soul + "§r §7属性四灵根§r");
                } else if (chance < 100) {
                    Soul.append("金木水火土");
                    player.addChatMessage("§7[Server]:§r §6" + name + "§r §b" + Soul + "§r §7属性五灵根§r");
                } else {
                    player.addChatMessage("§7[Server]:§r §6" + name + "§r §b" + Soul + "§r §7没有灵根§r");
                }
            } else {
                NBTTagCompound nbtTagCompound = new NBTTagCompound();
                player.writeEntityToNBT(nbtTagCompound);
                List<String> strings = new ArrayList<>();
                ATTRIBUTE_APPENDERS.forEach(x -> x.append(nbtTagCompound, strings));
                strings.add("石粒数：§6" + GAEntityPlayer.getStoneCountManager(player).getStoneCount() + "§r个");
                player.addChatMessage(StringUtils.join(strings, ", "));
            }
        }
        return true;
    }

    public static long getCRC32(String value) {
        CRC32 crc32 = new CRC32();
        crc32.update(value.getBytes());
        return crc32.getValue();
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("阴阳玉", new Object[0]));
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("神社最大的秘宝", new Object[0]));
        }
    }

    private static final List<AttributeAppender> ATTRIBUTE_APPENDERS = List.of(
            new AttributeAppender("UnderWorldTeleportTime", "随机传送：§6%d§r秒"),
            new AttributeAppender("UnderWorldDebuffTime", "地下缓慢：§6%d§r秒"),
            new AttributeAppender("NetherDebuffTime", "地狱疲劳：§6%d§r秒"),
            new AttributeAppender("InRainCounter", "雨水虚弱：§6%d§r秒")
    );

    private record AttributeAppender(String key, String format) {// only support integer now

        void append(NBTTagCompound nbtTagCompound, List<String> info) {
            if (nbtTagCompound.hasKey(this.key)) {
                int integer = nbtTagCompound.getInteger(this.key);
                String formatted = String.format(this.format, integer);
                info.add(formatted);
            }
        }
    }
}