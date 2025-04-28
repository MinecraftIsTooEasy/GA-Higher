package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemAnimalBall extends ItemIngot {
    private static long timeStamp = 0L;

    public static int Kind = -1;

    public static int nowHealth = 0;

    public static long animalTimeStamp = 0L;

    public static boolean Saddle = false;

    public static int milk = 0;

    public static boolean Sheared = false;

    public static byte Color = 0;

    public static int max_num_feathers = 0;

    public static int num_feathers = 0;

    public static int CatType = 0;

    public static byte CollarColor = 0;

    public static int target_countdown = 0;

    public static boolean hostile_to_players = false;

    public static boolean is_witch_ally = false;

    public ItemAnimalBall(int par1, Material material) {
        super(par1, material);
        setMaxStackSize(1);
        setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
    }

    public void a(NBTTagCompound par1NBTTagCompound) {
        Kind = par1NBTTagCompound.getInteger("Kind");
        nowHealth = par1NBTTagCompound.getInteger("nowHealth");
        animalTimeStamp = par1NBTTagCompound.getLong("animalTimeStamp");
        Saddle = par1NBTTagCompound.getBoolean("Saddle");
        milk = par1NBTTagCompound.getInteger("milk");
        Sheared = par1NBTTagCompound.getBoolean("Sheared");
        Color = par1NBTTagCompound.getByte("Color");
        max_num_feathers = par1NBTTagCompound.getInteger("max_num_feathers");
        num_feathers = par1NBTTagCompound.getInteger("num_feathers");
        CatType = par1NBTTagCompound.getInteger("CatType");
        CollarColor = par1NBTTagCompound.getByte("CollarColor");
        target_countdown = par1NBTTagCompound.getInteger("target_countdown");
        hostile_to_players = par1NBTTagCompound.getBoolean("hostile_to_players");
        is_witch_ally = par1NBTTagCompound.getBoolean("is_witch_ally");
    }

    public void b(NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setInteger("Kind", Kind);
        par1NBTTagCompound.setInteger("nowHealth", nowHealth);
        par1NBTTagCompound.setLong("animalTimeStamp", animalTimeStamp);
        par1NBTTagCompound.setBoolean("Saddle", Saddle);
        par1NBTTagCompound.setInteger("milk", milk);
        par1NBTTagCompound.setBoolean("Sheared", Sheared);
        par1NBTTagCompound.setByte("Color", Color);
        par1NBTTagCompound.setInteger("max_num_feathers", max_num_feathers);
        par1NBTTagCompound.setInteger("num_feathers", num_feathers);
        par1NBTTagCompound.setInteger("CatType", CatType);
        par1NBTTagCompound.setByte("CollarColor", CollarColor);
        par1NBTTagCompound.setInteger("target_countdown", target_countdown);
        par1NBTTagCompound.setBoolean("hostile_to_players", hostile_to_players);
        par1NBTTagCompound.setBoolean("is_witch_ally", is_witch_ally);
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        return true;// TODO
//        RaycastCollision rc = player.getSelectedObject(partial_tick, false);
//        if (rc == null || !rc.isBlock())
//            return false;
//        if (player.onClient()) {
//            player.swingArm();
//        } else if (rc.isBlock()) {
//            float offset_y;
//            if (rc.face_hit.isTop()) {
////                if (rc.getBlockHit() instanceof net.minecraft.BlockFence || rc.getBlockHit() instanceof net.minecraft.BlockCobbleWall) {
//                if (rc.getBlockHit() instanceof net.minecraft.BlockFence || rc.getBlockHit() instanceof net.minecraft.BlockWall) {
//                    offset_y = 0.5F;
////                } else if (rc.getBlockHit() instanceof net.minecraft.BlockSoil) {
//                } else if (rc.getBlockHit() instanceof net.minecraft.BlockDirt) {
//                    offset_y = 0.0625F;
//                } else {
//                    rc.getBlockHit().setBlockBoundsBasedOnStateAndNeighbors((IBlockAccess) rc.world, rc.block_hit_x, rc.block_hit_y, rc.block_hit_z);
//                    offset_y = (float) rc.getBlockHit().getBlockBoundsMaxY(Minecraft.getThreadIndex()) - 1.0F;
//                }
//            } else {
//                offset_y = 0.0F;
//            }
//            ItemStack heldItemStack = player.getHeldItemStack();
//            int Kind = -1;
//            if (heldItemStack.hasTagCompound()) {
//                NBTTagCompound tagCompound = heldItemStack.getTagCompound();
//                Kind = tagCompound.getInteger("Kind");
//            }
//            player.addChatMessage("kind=" + Kind);
//            if (Kind == -1)
//                return true;
////            if (rc.getBlockHit().isLiquid() && rc.face_hit.isTop() && EntityTypes.a(heldItemStack.getItemSubtype()) == EntityEarthElemental.class)
//            if (rc.getBlockHit().isLiquid() && rc.face_hit.isTop() && EntityList.getClassFromID(heldItemStack.getItemSubtype()) == EntityEarthElemental.class)
//                rc.neighbor_block_y--;
//            Entity entity = spawnCreature(rc.world, Kind, (rc.neighbor_block_x + 0.5F), (rc.neighbor_block_y + offset_y), (rc.neighbor_block_z + 0.5F), (Minecraft.inDevMode() && !ctrl_is_down), rc.face_hit);
//            if (entity != null &&
//                    entity instanceof net.minecraft.EntityLiving && heldItemStack.u())
//                ((EntityInsentient) entity).a(heldItemStack.s());
//        } else {
//            return false;
//        }
//        return true;
    }

//    public static Entity spawnCreature(World par0World, int par1, double par2, double par4, double par6, boolean check_location, EnumFace face_hit) {
//        if (!Minecraft.inDevMode())
//            check_location = false;
//        if (!EntityList.entityEggs.containsKey(Integer.valueOf(par1)))
////        if (!EntityTypes.a.containsKey(Integer.valueOf(par1)))
//            return null;
//        Entity var8 = null;
//        for (int var9 = 0; var9 < 1; var9++) {
////            var8 = EntityTypes.a(par1, par0World);
//            var8 = EntityList.createEntityByID(par1, par0World);
//            if (var8 != null && var8 instanceof net.minecraft.EntityLiving) {
//                if (face_hit == EnumFace.BOTTOM && var8.P > 1.0F)
//                    par4 -= (var8.P - 1.0F);
//                EntityInsentient var10 = (EntityInsentient) var8;
//                var8.b(par2, par4, par6, MathHelper.g(par0World.s.nextFloat() * 360.0F), 0.0F);
//                if (var10 instanceof net.minecraft.EntityVillager)
//                    check_location = false;
//                if (check_location) {
//                    double[] resulting_y_pos = new double[1];
//                    if (!SpawnerCreature.canCreatureTypeSpawnAtLocation(var10.getCreatureType(), par0World, var10.getBlockPosX(), var10.getBlockPosY(), var10.getBlockPosZ(), false, resulting_y_pos)) {
//                        if (Minecraft.inDevMode())
//                            System.out.println("spawnCreature: canCreatureTypeSpawnAtLocation() returned false for " + var10.getBlockPosString());
//                        return null;
//                    }
//                    if (!var10.getCanSpawnHere(false)) {
//                        if (Minecraft.inDevMode())
//                            System.out.println("spawnCreature: getCanSpawnHere(false) returned false for " + var10.getBlockPosString());
//                        return null;
//                    }
//                    if (!var10.getCanSpawnHere(true)) {
//                        if (Minecraft.inDevMode())
//                            System.out.println("spawnCreature: getCanSpawnHere() returned false for " + var10.getBlockPosString() + " due to invalid light level (BLV=" + par0World.n(var10.getBlockPosX(), var10.getBlockPosY(), var10.getBlockPosZ()) + ")");
//                        return null;
//                    }
//                }
//                var10.aP = var10.A;
//                var10.aN = var10.A;
//                var10.a((GroupDataEntity) null);
//                par0World.d(var8);
//                var10.makeLivingSound();
//                if (Minecraft.inDevMode())
//                    System.out.println("Spawning " + var10.an() + " from egg, UUID=" + var10.aw());
//            }
//        }
//        return var8;
//    }

    public static long getSystemTime() {
        return System.currentTimeMillis() / 1000L;
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    public boolean isHarmedByLava() {
        return false;
    }

    public boolean isHarmedByPepsin() {
        return false;
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        ItemStack heldItemStack = item_stack;
        int KindTemp = -1;
        if (heldItemStack.hasTagCompound()) {
            NBTTagCompound tagCompound = heldItemStack.getTagCompound();
            KindTemp = tagCompound.getInteger("Kind");
        }
        if (extended_info) {
            info.add(" ");
            if (KindTemp != -1)
                info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("生物类型：§b" + KindTemp + "§r", new Object[0]));
        }
    }
}