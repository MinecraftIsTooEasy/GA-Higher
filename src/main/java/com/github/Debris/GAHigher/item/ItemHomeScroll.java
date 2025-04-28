package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.ThreadHomeScroll;
import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.entity.player.HomeScrollManager;
import net.minecraft.*;

import java.util.List;

public class ItemHomeScroll extends Item {
    private int id;

    private double x;

    private double y;

    private double z;

    public ItemHomeScroll(int id, Material material, String texture) {
        super(id, material, texture);
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        if (player.onServer()) {
            ItemStack heldItemStack = player.getHeldItemStack();
            Item B = player.getModelItem();
            if (!player.onGround) {
                player.addChatMessage("§7§o[Server]:不能在空中使用回城卷轴！§r");
                return false;
            }
            if (ctrl_is_down) {
                double y = player.posY - player.yOffset;
                if (heldItemStack.hasTagCompound()) {
                    NBTTagCompound tagCompound = heldItemStack.getTagCompound();
                    tagCompound.setInteger("dimensionId", player.getWorld().getDimensionId());
                    tagCompound.setDouble("homeScrollX", player.posX);
                    tagCompound.setDouble("homeScrollY", y);
                    tagCompound.setDouble("homeScrollZ", player.posZ);
                } else {
                    NBTTagCompound nbtTagCompound = new NBTTagCompound();
                    nbtTagCompound.setInteger("dimensionId", player.getWorld().getDimensionId());
                    nbtTagCompound.setDouble("homeScrollX", player.posX);
                    nbtTagCompound.setDouble("homeScrollY", y);
                    nbtTagCompound.setDouble("homeScrollZ", player.posZ);
                    heldItemStack.setTagCompound(nbtTagCompound);
                }
                player.addChatMessage("§7§o[Server]:已记录点(§r §6§o" + Translator.getFormatted(MathHelper.floor_double(player.posX) + " , " + MathHelper.floor_double(y) + " , " + MathHelper.floor_double(player.posZ), new Object[0]) + " §r§7§o)§r");
            } else {
                HomeScrollManager homeScrollManager = GAEntityPlayer.getHomeScrollManager(player);
                long homeScrollCD = homeScrollManager.getHomeScrollCD();
                if (homeScrollCD == 0L) {
                    if (heldItemStack.hasTagCompound()) {
                        NBTTagCompound tagCompound = heldItemStack.getTagCompound();
                        int ID = tagCompound.getInteger("dimensionId");
                        double X = tagCompound.getDouble("homeScrollX");
                        double Y = tagCompound.getDouble("homeScrollY");
                        double Z = tagCompound.getDouble("homeScrollZ");
                        player.convertOneOfHeldItem(null);
                        (new ThreadHomeScroll(player.getAsEntityPlayerMP(), ID, X, Y, Z)).start();
                        homeScrollManager.setHomeScrollCD(600L);
                    } else {
                        player.addChatMessage("§7§o[Server]:此卷轴尚未记录回城点§r");
                    }
                } else {
                    player.addChatMessage("§7§o[Server]:卷轴冷却时间： §r§b" + (homeScrollCD / 20L) + "§r 秒");
                }
            }
        } else {
            player.bobItem();
        }
        return true;
    }

    public void a(NBTTagCompound par1NBTTagCompound) {
        this.id = par1NBTTagCompound.getInteger("dimensionId");
        this.x = par1NBTTagCompound.getDouble("homeScrollX");
        this.y = par1NBTTagCompound.getDouble("homeScrollY");
        this.z = par1NBTTagCompound.getDouble("homeScrollZ");
    }

    public void b(NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setInteger("dimensionId", this.id);
        par1NBTTagCompound.setDouble("homeScrollX", this.x);
        par1NBTTagCompound.setDouble("homeScrollY", this.y);
        par1NBTTagCompound.setDouble("homeScrollZ", this.z);
    }

    public int getId() {
        return this.id;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        String WorldID = "null";
        String XYZ = "尚未记录回城点";
        if (item_stack.hasTagCompound()) {
            NBTTagCompound tagCompound = item_stack.getTagCompound();
            int ID = tagCompound.getInteger("dimensionId");
            double X = tagCompound.getDouble("homeScrollX");
            double Y = tagCompound.getDouble("homeScrollY");
            double Z = tagCompound.getDouble("homeScrollZ");
            if (ID == 0) {
                WorldID = "主世界";
            } else if (ID == -1) {
                WorldID = "地狱";
            } else if (ID == 1) {
                WorldID = "末地";
            } else if (ID == -2) {
                WorldID = "地下世界";
            } else {
                WorldID = "天空之城";
            }
            XYZ = MathHelper.floor_double(X) + " , " + MathHelper.floor_double(Y) + " , " + MathHelper.floor_double(Z);
        }
        if (extended_info) {
            info.add(" ");
            if (!WorldID.equals("null"))
                info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted(WorldID, new Object[0]));
            info.add(Translator.getFormatted("(§6" + XYZ + "§r)", new Object[0]));
        }
    }
}