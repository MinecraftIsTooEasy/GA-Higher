package com.github.Debris.GAHigher.event;

import com.github.Debris.GAHigher.GAStart;
import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.block.entity.TileEntityItemDuper;
import com.github.Debris.GAHigher.client.render.entity.RenderZombieBoss;
import com.github.Debris.GAHigher.command.CommandForging;
import com.github.Debris.GAHigher.command.CommandItemLevel;
import com.github.Debris.GAHigher.compat.ITECompat;
import com.github.Debris.GAHigher.entity.EntityExchanger;
import com.github.Debris.GAHigher.entity.EntityFinalZombieBoss;
import com.github.Debris.GAHigher.entity.EntityZombieBoss;
import com.github.Debris.GAHigher.entity.EntityZombieDoor;
import com.github.Debris.GAHigher.enums.Achievements;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.item.enchantment.Enchantments;
import com.github.Debris.GAHigher.network.GANetwork;
import com.github.Debris.GAHigher.network.packets.S2C.S2COverlayMessage;
import com.google.common.eventbus.Subscribe;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class GAEventFML {
    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
        Items.registerModern(event);
        Blocks.registerModern(event);
    }

    @Subscribe
    public void onAchievementRegister(AchievementRegistryEvent event) {
        Achievements.registerAchievements();
    }

    //    @Subscribe
    public void handleChatCommand(HandleChatCommandEvent event) {
        String par2Str = event.getCommand();
        EntityPlayer player = event.getPlayer();
        ICommandSender commandListener = event.getListener();
        if (Minecraft.inDevMode()) {
            World world = event.getWorld();
            if (par2Str.startsWith("teleport ")) {
                System.out.println(par2Str);
                String msg = par2Str.substring(9);
                String[] pos = msg.split(" ");
                double[] poses = new double[3];
                int i = 0;
                for (int posLength = pos.length; i < posLength; i++) {
                    String po = pos[i];
                    try {
                        poses[i] = Double.parseDouble(po);
                    } catch (NumberFormatException var13) {
                        var13.printStackTrace();
                    }
                }
                player.setPositionAndUpdate(poses[0], poses[1], poses[2]);
                event.setExecuteSuccess(true);
            }
            if (par2Str.startsWith("xsummon")) {
                int id = Integer.parseInt(par2Str.substring(8));
                Entity entity = EntityList.createEntityByID(id, world);
                if (entity != null) {
                    entity.setPosition(player.posX, player.posY, player.posZ);
                    if (entity instanceof EntityLiving)
                        ((EntityLiving) entity).onSpawnWithEgg(null);
                    world.spawnEntityInWorld(entity);
                    commandListener.sendChatToPlayer(ChatMessageComponent.createFromText("已生成实体 " + entity).setColor(EnumChatFormatting.LIGHT_GRAY));
                } else {
                    commandListener.sendChatToPlayer(ChatMessageComponent.createFromText("无法生成实体:ID为 " + id + " 的实体不存在!").setColor(EnumChatFormatting.DARK_RED));
                }
                event.setExecuteSuccess(true);
            }
            if (par2Str.startsWith("overlayMsg")) {
                String msg = par2Str.substring("overlayMsg".length());
                GANetwork.sendToClient((ServerPlayer) player, new S2COverlayMessage(msg, 16777215, 100));
                event.setExecuteSuccess(true);
            }
            if (par2Str.startsWith("emptyItem")) {
                Item item = Item.itemsList[Integer.parseInt(par2Str.substring("overlayMsg".length()))];
                if (item != null)
                    player.setHeldItemStack(new ItemStack(item, 0, 0));
            }
            if (par2Str.startsWith("give")) {
                System.out.println(par2Str);
                String sid = par2Str.substring(5);
                String[] pos = sid.split(" ");
                int[] poses = new int[3];
                int Rx = 0;
                for (int Rz = pos.length; Rx < Rz; Rx++) {
                    String po = pos[Rx];
                    poses[Rx] = Integer.parseInt(po);
                }
                player.addContainedItem(poses[0]);
                player.dropItem(poses[0], poses[1], 1.0F);
                event.setExecuteSuccess(true);
            }
            if (par2Str.startsWith("addxp")) {
                int id = Integer.parseInt(par2Str.substring(6));
                player.addExperience(id, true, true);
                event.setExecuteSuccess(true);
            }
            if (par2Str.startsWith("setday")) {
                int id = Integer.parseInt(par2Str.substring(7));
                world.setTotalWorldTime(((id - 1) * 24000L));
                player.addChatMessage("[Server]:设置天数=" + id);
                event.setExecuteSuccess(true);
            }
            if (par2Str.startsWith("settime")) {
                int id = Integer.parseInt(par2Str.substring(8));
                long time = world.getTotalWorldTimeAtStartOfToday();
                if (id >= 0 && id < 24) {
                    world.setTotalWorldTime(time + (1000 * id));
                    player.addChatMessage("[Server]:设置时间=" + id);
                } else {
                    player.addChatMessage("[Server]:错误的小时数：" + id);
                }
                event.setExecuteSuccess(true);
            }
            if (par2Str.startsWith("setweather")) {
                int id = Integer.parseInt(par2Str.substring(6));
                world.generateWeatherEvents(world.getHourOfDay(), world.getHourOfDay() + id);
                player.addChatMessage("[Server]:设置天气=" + id);
                event.setExecuteSuccess(true);
            }
        }
        if (par2Str.startsWith("sleep")) {
            StringBuilder notSleepingPlayers = new StringBuilder();
            boolean allSlept = true;
            for (Object o : (player.getWorldServer().getMinecraftServer().getConfigurationManager()).playerEntityList) {
                EntityPlayer currentPlayer = (EntityPlayer) o;
                if (!currentPlayer.inBed()) {
                    allSlept = false;
                    notSleepingPlayers.append(currentPlayer.getEntityName()).append(",");
                }
            }
            if (allSlept) {
                commandListener.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("command.sleep_check.none").setColor(EnumChatFormatting.DARK_GREEN));
            } else {
                commandListener.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("command.sleep_check.msg").addText(notSleepingPlayers.substring(0, notSleepingPlayers.length() - 1)).setColor(EnumChatFormatting.YELLOW));
            }
            event.setExecuteSuccess(true);
        }
    }

    static EntityRegisterEvent entityRegisterEvent;

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event) {
        entityRegisterEvent = event;
        addMapping(EntityZombieDoor.class, "EntityZombieDoor", nextEntityID());
        addMapping(EntityExchanger.class, "EntityExchanger", nextEntityID());
        if (ITECompat.HAS_ITE) {
            addMapping(EntityZombieBoss.class, "EntityZombieBoss", nextEntityID());
            addMapping(EntityFinalZombieBoss.class, "EntityFinalZombieBoss", nextEntityID());
        }
        entityRegisterEvent = null;
    }

    private static int nextEntityID() {
        return IdUtil.getNextEntityID();
    }

    private static void addMapping(Class<? extends Entity> clazz, String name, int id) {
        entityRegisterEvent.register(clazz, GAStart.MOD_ID, name, id);
    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event) {
        if (ITECompat.HAS_ITE) {
            event.register(EntityZombieBoss.class, new RenderZombieBoss());
        }
    }

    @Subscribe
    public void onEnchantmentRegister(EnchantmentRegistryEvent event) {
        Enchantments.init();
    }

    @Subscribe
    public void onCommandRegister(CommandRegisterEvent event) {
        if (ITECompat.HAS_ITE) {
            event.register(new CommandForging());
            event.register(new CommandItemLevel());
        }
    }

    @Subscribe
    public void onTileEntityRegister(TileEntityRegisterEvent event) {
        event.register(TileEntityItemDuper.class, "TileEntityItemDuper");
    }
}
