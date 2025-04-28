package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ItemAnimalBag extends ItemIngot {
    private static long timeStamp = 0L;

    private static final String[] Color = new String[]{
            "白", "橙", "品红", "淡蓝", "黄", "黄绿", "粉红", "灰", "淡灰", "青",
            "紫", "蓝", " 棕", "绿", "红", "黑"};

    public ItemAnimalBag(int par1, Material material) {
        super(par1, material);
        setMaxStackSize(1);
        setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        return true;// TODO
//        RaycastCollision rc = player.getSelectedObject(partial_tick, false);
//        if (rc == null)
//            return false;
//        if (player.onClient()) {
//            player.swingArm();
//        } else if (ctrl_is_down) {
//            if (rc.isEntity()) {
//                Entity entity = rc.getEntityHit();
//                int Kind = -1;
//                EntityPig entityPig = null;
//                EntityCow entityCow = null;
//                EntitySheep entitySheep = null;
//                EntityChicken entityChicken = null;
//                EntityOcelot entityOcelot = null;
//                EntityWolf entityWolf = null;
//                EntityInsentient entityInsentient = (EntityInsentient) entity;
//                EntityAnimal entityAnimal = null;
//                EntityAgeable entityAgeable = null;
//                EntityTameableAnimal entityTameableAnimal = null;
//                if (entity instanceof EntityPig) {
//                    Kind = 90;
//                    entityPig = (EntityPig) entity;
//                } else if (entity instanceof EntityCow) {
//                    Kind = 92;
//                    entityCow = (EntityCow) entity;
//                } else if (entity instanceof EntitySheep) {
//                    Kind = 91;
//                    entitySheep = (EntitySheep) entity;
//                } else if (entity instanceof EntityChicken) {
//                    Kind = 93;
//                    entityChicken = (EntityChicken) entity;
//                } else if (entity instanceof EntityOcelot) {
//                    Kind = 98;
//                    entityOcelot = (EntityOcelot) entity;
//                    entityTameableAnimal = (EntityTameableAnimal) entity;
//                    if (!entityTameableAnimal.h_().equals("")) {
//                        player.addChatMessage("§7§o[Server]:不能偷别人的猫猫哦~§r");
//                        return true;
//                    }
//                } else if (entity instanceof EntityWolf) {
//                    Kind = 95;
//                    entityWolf = (EntityWolf) entity;
//                    entityTameableAnimal = (EntityTameableAnimal) entity;
//                    if (!entityTameableAnimal.h_().equals("")) {
//                        player.addChatMessage("§7§o[Server]:不能偷别人的狗狗哦~§r");
//                        return true;
//                    }
//                    if (entityWolf.isHostileToPlayersGA()) {
//                        player.addChatMessage("§7§o[Server]:不能装超凶的狗狗哦~§r");
//                        return true;
//                    }
//                    if (entityWolf.getIs_Witch_Ally()) {
//                        player.addChatMessage("§7§o[Server]:不能偷女巫的狗狗哦~§r");
//                        return true;
//                    }
//                } else {
//                    player.addChatMessage("§7§o[Server]:此生物过于强大~§r");
//                    return true;
//                }
//                if (Kind > 0) {
//                    entityAnimal = (EntityAnimal) entity;
//                    entityAgeable = (EntityAgeable) entity;
//                }
//                ItemStack heldItemStack = player.getHeldItemStack();
//                if (heldItemStack.p()) {
//                    NBTTagCompound tagCompound = heldItemStack.q();
//                    int KindTemp = tagCompound.e("Kind");
//                    if (KindTemp > 0) {
//                        player.addChatMessage("§7§o[Server]:无法装载更多的灵魂~§r");
//                        return true;
//                    }
//                    tagCompound.a("Kind", Kind);
//                    tagCompound.a("nowHealth", entityInsentient.aN());
//                    tagCompound.a("Age", entityAgeable.b());
//                    tagCompound.a("InLove", entityAnimal.getInLove());
//                    tagCompound.a("Breeding", entityAnimal.getBreeding());
//                    tagCompound.a("timeStamp", getSystemTime());
//                    if (Kind == 90) {
//                        int yuezhuxue = 0;
//                        if (entityPig.bT()) {
//                            yuezhuxue = 5;
//                        } else {
//                            yuezhuxue = 6;
//                        }
//                        tagCompound.a("Saddle", yuezhuxue);
//                    } else if (Kind == 92) {
//                        tagCompound.a("milk", entityCow.getMilkGA());
//                    } else if (Kind == 91) {
//                        int yuezhuxue = 0;
//                        if (entitySheep.bU()) {
//                            yuezhuxue = 5;
//                        } else {
//                            yuezhuxue = 6;
//                        }
//                        tagCompound.a("Sheared", yuezhuxue);
//                        tagCompound.a("Color", entitySheep.bT());
//                    } else if (Kind == 93) {
//                        tagCompound.a("max_num_feathers", entityChicken.getMax_Num_Feathers());
//                        tagCompound.a("num_feathers", entityChicken.getNum_Feathers());
//                    } else if (Kind == 98) {
//                        tagCompound.a("CatType", entityOcelot.ca());
//                    } else if (Kind == 95) {
//                        tagCompound.a("CollarColor", (byte) entityWolf.cd());
//                        tagCompound.a("target_countdown", entityWolf.getTargetCountdownGA());
//                        tagCompound.a("hostile_to_players", entityWolf.isHostileToPlayersGA());
//                        tagCompound.a("is_witch_ally", entityWolf.getIs_Witch_Ally());
//                    }
//                    if (entityInsentient.bB()) {
//                        tagCompound.a("CustomName", entityInsentient.bA());
//                    } else {
//                        tagCompound.a("CustomName", "");
//                    }
//                    entity.x();
//                } else {
//                    NBTTagCompound tagCompound = new NBTTagCompound();
//                    tagCompound.a("Kind", Kind);
//                    tagCompound.a("nowHealth", entityInsentient.aN());
//                    tagCompound.a("Age", entityAgeable.b());
//                    tagCompound.a("InLove", entityAnimal.getInLove());
//                    tagCompound.a("Breeding", entityAnimal.getBreeding());
//                    tagCompound.a("timeStamp", getSystemTime());
//                    if (Kind == 90) {
//                        int yuezhuxue = 0;
//                        if (entityPig.bT()) {
//                            yuezhuxue = 5;
//                        } else {
//                            yuezhuxue = 6;
//                        }
//                        tagCompound.a("Saddle", yuezhuxue);
//                    } else if (Kind == 92) {
//                        tagCompound.a("milk", entityCow.getMilkGA());
//                    } else if (Kind == 91) {
//                        int yuezhuxue = 0;
//                        if (entitySheep.bU()) {
//                            yuezhuxue = 5;
//                        } else {
//                            yuezhuxue = 6;
//                        }
//                        tagCompound.a("Sheared", yuezhuxue);
//                        tagCompound.a("Color", entitySheep.bT());
//                    } else if (Kind == 93) {
//                        tagCompound.a("max_num_feathers", entityChicken.getMax_Num_Feathers());
//                        tagCompound.a("num_feathers", entityChicken.getNum_Feathers());
//                    } else if (Kind == 98) {
//                        tagCompound.a("CatType", entityOcelot.ca());
//                    } else if (Kind == 95) {
//                        tagCompound.a("CollarColor", (byte) entityWolf.cd());
//                        tagCompound.a("target_countdown", entityWolf.getTargetCountdownGA());
//                        tagCompound.a("hostile_to_players", entityWolf.isHostileToPlayersGA());
//                        tagCompound.a("is_witch_ally", entityWolf.getIs_Witch_Ally());
//                    }
//                    if (entityInsentient.bB()) {
//                        tagCompound.a("CustomName", entityInsentient.bA());
//                    } else {
//                        tagCompound.a("CustomName", "");
//                    }
//                    heldItemStack.setTagCompound(tagCompound);
//                    entity.x();
//                }
//                return true;
//            }
//        } else if (rc.isBlock()) {
//            float offset_y;
//            EntityAgeable entityAgeable;
//            if (rc.face_hit.isTop()) {
//                if (rc.getBlockHit() instanceof net.minecraft.BlockFence || rc.getBlockHit() instanceof net.minecraft.BlockCobbleWall) {
//                    offset_y = 0.5F;
//                } else if (rc.getBlockHit() instanceof net.minecraft.BlockSoil) {
//                    offset_y = 0.0625F;
//                } else {
//                    rc.getBlockHit().setBlockBoundsBasedOnStateAndNeighbors((IBlockAccess) rc.world, rc.block_hit_x, rc.block_hit_y, rc.block_hit_z);
//                    offset_y = (float) rc.getBlockHit().getBlockBoundsMaxY(Minecraft.getThreadIndex()) - 1.0F;
//                }
//            } else {
//                offset_y = 0.0F;
//            }
//            ItemStack heldItemStack = item_stack;
//            int Kind = -1;
//            boolean isChild = false;
//            if (heldItemStack.p()) {
//                NBTTagCompound tagCompound = heldItemStack.q();
//                Kind = tagCompound.e("Kind");
//                isChild = (tagCompound.e("Age") < 0);
//            }
//            if (Kind < 0)
//                return true;
//            if (rc.getBlockHit().isLiquid() && rc.face_hit.isTop() && EntityTypes.a(heldItemStack.getItemSubtype()) == EntityEarthElemental.class)
//                rc.neighbor_block_y--;
//            Entity entity = spawnCreature(rc.world, Kind, (rc.neighbor_block_x + 0.5F), (rc.neighbor_block_y + offset_y), (rc.neighbor_block_z + 0.5F), Minecraft.inDevMode(), rc.face_hit);
//            if (isChild) {
//                EntityAgeable entityAgeable1 = (EntityAgeable) entity;
//                if (entityAgeable1 != null) {
//                    EntityAgeable newborn = entityAgeable1.a(entityAgeable1);
//                    if (newborn == null)
//                        return false;
//                    newborn.setGrowingAgeToNewborn();
//                    newborn.b(entity.u, entity.v, entity.w, 0.0F, 0.0F);
//                    entity.q.d((Entity) newborn);
//                    entity.x();
//                    entityAgeable = newborn;
//                }
//            }
//            if (entityAgeable != null) {
//                if (entityAgeable instanceof net.minecraft.EntityLiving && heldItemStack.u())
//                    ((EntityInsentient) entityAgeable).a(heldItemStack.s());
//                EntityPig entityPig = null;
//                EntityCow entityCow = null;
//                EntitySheep entitySheep = null;
//                EntityChicken entityChicken = null;
//                EntityOcelot entityOcelot = null;
//                EntityWolf entityWolf = null;
//                EntityInsentient entityInsentient = (EntityInsentient) entityAgeable;
//                EntityTameableAnimal entityTameableAnimal = null;
//                if (entityAgeable instanceof EntityPig) {
//                    entityPig = (EntityPig) entityAgeable;
//                } else if (entityAgeable instanceof EntityCow) {
//                    entityCow = (EntityCow) entityAgeable;
//                } else if (entityAgeable instanceof EntitySheep) {
//                    entitySheep = (EntitySheep) entityAgeable;
//                } else if (entityAgeable instanceof EntityChicken) {
//                    entityChicken = (EntityChicken) entityAgeable;
//                } else if (entityAgeable instanceof EntityOcelot) {
//                    entityOcelot = (EntityOcelot) entityAgeable;
//                } else if (entityAgeable instanceof EntityWolf) {
//                    entityWolf = (EntityWolf) entityAgeable;
//                } else {
//                    player.addChatMessage("§7§o[Server]:未知生物哟~§r");
//                    return true;
//                }
//                if (heldItemStack.p()) {
//                    NBTTagCompound tagCompound = heldItemStack.q();
//                    long timeSpend = getSystemTime() - tagCompound.f("timeStamp");
//                    float nowHealth = tagCompound.g("nowHealth");
//                    ((EntityAnimal) entityAgeable).setHealth((float) (nowHealth + timeSpend / 64.0D), true, null);
//                    ((EntityAnimal) entityAgeable).setInLove(tagCompound.e("InLove"));
//                    entityAgeable.c(tagCompound.e("Age"));
//                    if (Kind == 90) {
//                        int yuezhuxue = tagCompound.e("Saddle");
//                        if (entityPig != null)
//                            entityPig.i((yuezhuxue == 5));
//                    } else if (Kind == 92) {
//                        int yuezhuxue = tagCompound.e("milk");
//                        if (entityCow != null)
//                            entityCow.setMilkGA(yuezhuxue);
//                    } else if (Kind == 91) {
//                        int isSheared = tagCompound.e("Sheared");
//                        int getColor = tagCompound.e("Color");
//                        if (entitySheep != null) {
//                            entitySheep.i((isSheared == 5));
//                            entitySheep.p(getColor);
//                        }
//                    } else if (Kind == 93) {
//                        if (entityChicken != null) {
//                            entityChicken.setMax_Num_Feathers(tagCompound.e("max_num_feathers"));
//                            entityChicken.setNum_Feathers(tagCompound.e("max_num_feathers"));
//                        }
//                    } else if (Kind == 98) {
//                        if (entityOcelot != null)
//                            entityOcelot.p(tagCompound.e("CatType"));
//                    } else if (Kind == 95 &&
//                            entityWolf != null) {
//                        entityWolf.p(tagCompound.c("CollarColor"));
//                        entityWolf.setTarget_countdownGA(tagCompound.e("target_countdown"));
//                    }
//                    if (tagCompound.i("CustomName").length() > 0)
//                        entityInsentient.a(tagCompound.i("CustomName"));
//                }
//                if (heldItemStack.p()) {
//                    NBTTagCompound tagCompound = heldItemStack.q();
//                    tagCompound.a("Kind", -2);
//                }
//                return true;
//            }
//        }
//        return true;
    }

//    public static Entity spawnCreature(World par0World, int par1, double par2, double par4, double par6, boolean check_location, EnumFace face_hit) {
//        if (!Minecraft.inDevMode())
//            check_location = false;
//        if (!EntityTypes.a.containsKey(Integer.valueOf(par1)))
//            return null;
//        Entity var8 = null;
//        for (int var9 = 0; var9 < 1; var9++) {
//            var8 = EntityTypes.a(par1, par0World);
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

    private static long getSystemTime() {
        return System.currentTimeMillis() / 1000L;
    }

    private static String getTimeString(Long timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        return sd;
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
        int Kind = -1;
        int Health = -1;
        String getInLove = "";
        String time = "";
        String KindName = "木有";
        String isSaddle = "";
        String isSheared = "";
        String getColor = "";
        String getMilk = "";
        String getCollarColor = "";
        if (item_stack.hasTagCompound()) {
            NBTTagCompound tagCompound = item_stack.getTagCompound();
            Kind = tagCompound.getInteger("Kind");
            Health = tagCompound.getInteger("nowHealth");
            getInLove = String.valueOf(tagCompound.getString("InLove"));
            time = getTimeString(tagCompound.getLong("timeStamp") * 1000L);
            if (Kind == 90) {
                KindName = "猪猪";
                if (tagCompound.getInteger("Saddle") == 5) {
                    isSaddle = "有";
                } else {
                    isSaddle = "无";
                }
            }
            if (Kind == 92) {
                KindName = "牛牛";
//                getMilk = String.valueOf(tagCompound.e("milk"));
                getMilk = String.valueOf(tagCompound.getInteger("milk"));
            }
            if (Kind == 91) {
                KindName = "羊羊";
                if (tagCompound.getInteger("Sheared") == 5) {
                    isSheared = "无";
                } else {
                    isSheared = "有";
                }
                getColor = Color[tagCompound.getInteger("Color")];
            }
            if (Kind == 93)
                KindName = "鸡";
            if (Kind == 98)
                KindName = "猫猫";
            if (Kind == 95) {
                KindName = "狗狗";
                getCollarColor = String.valueOf(tagCompound.getByte("CollarColor"));
            }
        }
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("生物类型：§b " + KindName + "§r", new Object[0]));
            if (Kind > 0) {
                info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("当前生命：§b " + Health + "§r", new Object[0]));
                info.add(EnumChatFormatting.DARK_PURPLE + Translator.getFormatted("捕获时间：§b " + time + "§r", new Object[0]));
            }
        }
    }
}