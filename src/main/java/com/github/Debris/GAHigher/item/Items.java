package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.GAStart;
import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.client.GACreativeTabs;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.item.api.StandardItem;
import com.github.Debris.GAHigher.item.guilt.*;
import com.github.Debris.GAHigher.item.jewelry.ItemJewelry;
import com.github.Debris.GAHigher.item.jewelry.ItemMagnet;
import com.github.Debris.GAHigher.item.material.Materials;
import com.github.Debris.GAHigher.unsafe.ITEAccessor;
import com.github.Debris.GAHigher.util.ReflectHelper;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items extends Item {

    public static final Item Stones = new StandardItem(getNextItemID(), Material.diamond, "stones").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(1);

    public static final Item Gem_Blue = new StandardItem(getNextItemID(), Material.diamond, "gem_blue").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(100);

    public static final Item Gem_Yellow = new StandardItem(getNextItemID(), Material.diamond, "gem_yellow").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(1000);

    public static final Item Guilt1 = new ItemGuilt1(getNextItemID());

    public static final Item Guilt2 = new ItemGuilt2(getNextItemID());

    public static final Item Guilt3 = new ItemGuilt3(getNextItemID());

    public static final Item Guilt4 = new ItemGuilt4(getNextItemID());

    public static final Item Guilt5 = new ItemGuilt5(getNextItemID());

    public static final Item Guilt6 = new ItemGuilt6(getNextItemID());

    public static final Item Guilt7 = new ItemGuilt7(getNextItemID());

    public static final ItemPickaxe A_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.ancient_metal);

    public static final ItemPickaxe B_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.ancient_metal);

    public static final ItemPickaxe C_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.mithril);

    public static final ItemPickaxe D_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.adamantium);

    public static final ItemPickaxe E_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final ItemFood Zombie_Brain = new ItemZombie_Brain(getNextItemID());

    public static final ItemFood Zombie_Drug = new ItemZombie_Drug(getNextItemID());

    public static final ItemFood Spider_Leg = new ItemSpider_Leg(getNextItemID());

    public static final ItemFood Zombie_Soup = new ItemZombie_Soup(getNextItemID());

    public static final Item Spider_Leg_B = new ItemSpider_Leg_B(getNextItemID());

    public static final Item ColorBag = new ItemColorBag(getNextItemID(), Material.seed, "color_bag");

    public static final Item Drug_BG = new ItemDrug_BG(getNextItemID());

    public static final Item BadApple = new ItemBadApple(getNextItemID());

    public static final Item Creeper_Baby = new ItemCreeper_Baby(getNextItemID());

    public static final Item Creeper_Soul = new ItemCreeper_Soul(getNextItemID());

    public static final ItemFood Drug_ZJ = new ItemDrug_ZJ(getNextItemID());

    public static final Item Stack_Gold_Nether = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item Stack_Gold = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item Stack_Silver = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item Stack_Copper = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item Stack_Iron = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item Stack_Mithril = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item Stack_Adamantium = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item Stack_Torch = new StandardItem(getNextItemID(), Material.seed, "stack_torch");

    public static final Item Stack_Torch_On = new StandardItem(getNextItemID(), Materials.seed, "stack_torch_on");

    public static final Item Stack_Log = new StandardItem(getNextItemID(), Material.seed, "stack_log");

    public static final Item Stack_Leather = new StandardItem(getNextItemID(), Material.diamond, "stack_leather");

    public static final Item GABag = new ItemGABag(getNextItemID(), getBestMaterial());

    public static final Item lavaInPipes = new ItemLavaInPipes(getNextItemID(), Materials.lava);

    public static final Item ringKillerCopper = (new ItemRingKiller(getNextItemID(), Materials.copper, 1)).setUnlocalizedName("ringKillerCopper");

    public static final Item ringKillerIron = (new ItemRingKiller(getNextItemID(), Materials.iron, 2)).setUnlocalizedName("ringKillerIron");

    public static final Item ringKillerAncient = (new ItemRingKiller(getNextItemID(), Materials.ancient_metal, 3)).setUnlocalizedName("ringKillerAncient");

    public static final Item ringKillerMithril = (new ItemRingKiller(getNextItemID(), Materials.mithril, 4)).setUnlocalizedName("ringKillerMithril");

    public static final Item ringKillerAdamantium = (new ItemRingKiller(getNextItemID(), Materials.adamantium, 5)).setUnlocalizedName("ringKillerAdamantium");

    public static final Item ringKillerVibranium = (new ItemRingKiller(getNextItemID(), getBestMaterial(), 6)).setUnlocalizedName("ringKillerVibranium");

    public static final Item pants = new ItemGAMisc(getNextItemID(), "pants");

    public static final ItemConsumables final_key = new ItemConsumables(getNextItemID(), getBestMaterial(), "final_key");

    public static final ItemGAMisc cracked_key = new ItemGAMisc(getNextItemID(), "cracked_key");

    public static final ItemArmor leather_skirt = new ItemArmorSkirt(getNextItemID(), Material.leather, "leather_layer");
    public static final ItemArmor copper_skirt = new ItemArmorSkirt(getNextItemID(), Material.copper, "copper_layer");
    public static final ItemArmor silver_skirt = new ItemArmorSkirt(getNextItemID(), Material.silver, "silver_layer");
    public static final ItemArmor gold_skirt = new ItemArmorSkirt(getNextItemID(), Material.gold, "gold_layer");
    public static final ItemArmor iron_skirt = new ItemArmorSkirt(getNextItemID(), Material.iron, "iron_layer");
    public static final ItemArmor ancient_metal_skirt = new ItemArmorSkirt(getNextItemID(), Material.ancient_metal, "ancient_metal_layer");
    public static final ItemArmor mithril_skirt = new ItemArmorSkirt(getNextItemID(), Material.mithril, "mithril_layer");
    public static final ItemArmor adamantium_skirt = new ItemArmorSkirt(getNextItemID(), Material.adamantium, "adamantium_layer");
    public static final ItemArmor vibranium_skirt = new ItemArmorSkirt(getNextItemID(), getBestMaterial(), "vibranium_layer");

    public static final ItemJewelry item_magnet = new ItemMagnet(getNextItemID());

    public static final ItemJewelry lucky_clover = new ItemJewelry(getNextItemID(), Material.grass, "lucky_clover");

    public static final ItemJewelry bottled_cloud = new ItemJewelry(getNextItemID(), Material.glass, "bottled_cloud");

    public static final ItemJewelry pocket_piston = new ItemJewelry(getNextItemID(), Material.piston, "pocket_piston");

    public static final ItemJewelry[] jewelries = new ItemJewelry[]{item_magnet, lucky_clover, bottled_cloud, pocket_piston};

    private static Material getBestMaterial() {
        if (ModCompat.HAS_ITE) {
            return ITEAccessor.getVibraniumMaterial();
        }
        return Material.adamantium;
    }

    private static ItemRegistryEvent itemRegistryEvent;

    public static void registerModern(ItemRegistryEvent register) {
        itemRegistryEvent = register;
        Item.porkCooked.setXPReward(3 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.fishCooked.setXPReward(3 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.beefCooked.setXPReward(4 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.chickenCooked.setXPReward(3 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.lambchopCooked.setXPReward(2 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.fishLargeCooked.setXPReward(4 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.bakedPotato.setXPReward(Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.bread.setXPReward(Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.wormCooked.setXPReward(Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.ingotIron.setXPReward(20 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotSilver.setXPReward(15 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotCopper.setXPReward(10 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotGold.setXPReward(10 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotAncientMetal.setXPReward(20 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotMithril.setXPReward(40 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotAdamantium.setXPReward(100 * Configs.wenscConfig.OreExpValue.ConfigValue);


        register("stones", Stones).setUnlocalizedName("stones").setMaxStackSize(64);
        register("gem_blue", Gem_Blue).setUnlocalizedName("gem_blue").setMaxStackSize(64);
        register("gem_yellow", Gem_Yellow).setUnlocalizedName("gem_yellow").setMaxStackSize(64);
        register("guilt1", Guilt1).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt2", Guilt2).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt3", Guilt3).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt4", Guilt4).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt5", Guilt5).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt6", Guilt6).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt7", Guilt7).setLowestCraftingDifficultyToProduce(1.0F);
        register("a_pickaxe", A_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("b_pickaxe", B_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("c_pickaxe", C_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("d_pickaxe", D_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("e_pickaxe", E_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("zombie_brain", Zombie_Brain);
        register("zombie_drug", Zombie_Drug).setLowestCraftingDifficultyToProduce(1.0F);
        register("spider_leg", Spider_Leg);
        register("spider_leg_b", Spider_Leg_B).setLowestCraftingDifficultyToProduce(1.0F);
        register("zombie_soup", Zombie_Soup).setLowestCraftingDifficultyToProduce(1.0F);
        register("color_bag", ColorBag);
        register("drug_bg", Drug_BG).setUnlocalizedName("drug_bg").setLowestCraftingDifficultyToProduce(1.0F);
        register("bad_apple", BadApple).setLowestCraftingDifficultyToProduce(1.0F);
        register("drug_zj", Drug_ZJ).setUnlocalizedName("drug_zj").setLowestCraftingDifficultyToProduce(1.0F);
        register("ingots/stack_gold_nether", Stack_Gold_Nether).setUnlocalizedName("stack_gold_nether").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("ingots/stack_gold", Stack_Gold).setUnlocalizedName("stack_gold").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("ingots/stack_silver", Stack_Silver).setUnlocalizedName("stack_silver").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("ingots/stack_copper", Stack_Copper).setUnlocalizedName("stack_copper").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("ingots/stack_iron", Stack_Iron).setUnlocalizedName("stack_iron").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("ingots/stack_mithril", Stack_Mithril).setUnlocalizedName("stack_mithril").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("ingots/stack_adamantium", Stack_Adamantium).setUnlocalizedName("stack_adamantium").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_torch", Stack_Torch).setUnlocalizedName("stack_torch").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_torch_on", Stack_Torch_On).setUnlocalizedName("stack_torch_on").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_log", Stack_Log).setUnlocalizedName("stack_log").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_leather", Stack_Leather).setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("creeper_baby", Creeper_Baby).setUnlocalizedName("creeper_baby");
        register("creeper_soul", Creeper_Soul).setUnlocalizedName("creeper_soul").setCraftingDifficultyAsComponent(1.0E-9F);
        register("ga_bag", GABag).setUnlocalizedName("ga_bag").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_copper", ringKillerCopper).setUnlocalizedName("ring_killer_copper").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_iron", ringKillerIron).setUnlocalizedName("ring_killer_iron").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_ancient", ringKillerAncient).setUnlocalizedName("ring_killer_ancient").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_mithril", ringKillerMithril).setUnlocalizedName("ring_killer_mithril").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_adamantium", ringKillerAdamantium).setUnlocalizedName("ring_killer_adamantium").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_vibranium", ringKillerVibranium).setUnlocalizedName("ring_killer_vibranium").setLowestCraftingDifficultyToProduce(1.0F);
        register("pants", pants);
        register("final_key", final_key);
        register("cracked_key", cracked_key);

        register("skirt/leather_skirt", leather_skirt).setUnlocalizedName("leather_skirt");
        register("skirt/copper_skirt", copper_skirt).setUnlocalizedName("copper_skirt");
        register("skirt/silver_skirt", silver_skirt).setUnlocalizedName("silver_skirt");
        register("skirt/gold_skirt", gold_skirt).setUnlocalizedName("gold_skirt");
        register("skirt/iron_skirt", iron_skirt).setUnlocalizedName("iron_skirt");
        register("skirt/ancient_metal_skirt", ancient_metal_skirt).setUnlocalizedName("ancient_metal_skirt");
        register("skirt/mithril_skirt", mithril_skirt).setUnlocalizedName("mithril_skirt");
        register("skirt/adamantium_skirt", adamantium_skirt).setUnlocalizedName("adamantium_skirt");
        register("skirt/vibranium_skirt", vibranium_skirt).setUnlocalizedName("vibranium_skirt");

        register("item_magnet", item_magnet);
        register("lucky_clover", lucky_clover);
        register("bottled_cloud", bottled_cloud);
        register("pocket_piston", pocket_piston);

        itemRegistryEvent = null;
    }

    public static Item register(String resourceLocation, Item item) {
        itemRegistryEvent.register(GAStart.MOD_ID, resourceLocation, item, GACreativeTabs.GAItem);
//        item.setTextureName(((GAItem) item).getResourceLocationPrefix() + resourceLocation);
        item.setUnlocalizedName(resourceLocation);
        return item;
    }

    public static void registerRecipes(CraftingRecipeRegisterEvent register) {
        List<ItemNugget> vanillaNuggets = List.of(
                Item.goldNugget,
                Item.copperNugget,
                Item.silverNugget,
                Item.ironNugget,
                Item.mithrilNugget,
                Item.adamantiumNugget,
                Item.ancientMetalNugget);
        List<Item> vanillaIngots = List.of(
                Item.ingotGold,
                Item.ingotCopper,
                Item.ingotSilver,
                Item.ingotIron,
                Item.ingotMithril,
                Item.ingotAdamantium,
                Item.ingotAncientMetal);
        List<Item> nuggets = new ArrayList<>(vanillaNuggets);
        List<Item> ingots = new ArrayList<>(vanillaIngots);
        if (ModCompat.HAS_ITE) {
            ITEAccessor.addNuggetToList(nuggets);
            ITEAccessor.addIngotToList(ingots);
        }

        register.registerShapelessRecipe(new ItemStack(Blocks.blockLantern, 1), true, Blocks.torchWood, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget);
        if (Configs.wenscConfig.isRecipeGABag.ConfigValue)
            register.registerShapedRecipe(new ItemStack(GABag, 1), true, "#*#", "*#*", "#*#", ('#'), Blocks.obsidian, ('*'), enderPearl);
        register.registerShapedRecipe(new ItemStack(Item.paper), true, "###", ('#'), Item.stick);
        register.registerShapelessRecipe(new ItemStack(Blocks.blockGotcha, 64, 4), true, Gem_Blue);
        int i;
        for (i = 1; i < 10; i++) {
            register.registerShapelessRecipe(new ItemStack(Block.cobblestone, i), true, new ItemStack(Stones, i));
        }
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful0, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 0));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful1, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 1));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful2, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 2));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful3, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 3));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful4, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 4));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful5, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 5));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful6, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 6));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful7, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 7));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful8, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 8));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful9, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 9));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful10, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 10));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful11, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 11));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful12, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 12));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful13, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 13));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful14, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 14));
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful15, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 15));
        for (i = 0; i < 16; i++) {
            register.registerShapelessRecipe(new ItemStack(Blocks.blockColorful, 64, i), true, Gem_Blue, redstone, new ItemStack(Item.dyePowder, 1, i));
            register.registerShapelessRecipe(new ItemStack(Blocks.blockColorfulBrick, 64, i), true, Gem_Blue, redstone, Blocks.stoneBrick, new ItemStack(Item.dyePowder, 1, i));
            register.registerShapelessRecipe(new ItemStack(Blocks.blockGotcha, 64, i), true, Gem_Blue, new ItemStack(Item.dyePowder, 1, i));
            if (Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue)
                register.registerShapedRecipe(new ItemStack(A_PICKAXE, 1), true, "###", "#I#", "###", ('I'), Item.pickaxeAncientMetal, ('#'), new ItemStack(Blocks.blockGotcha, 1, i));
            register.registerShapelessRecipe(new ItemStack(silk, 4), true, new ItemStack(Block.cloth, 1, i));
        }
        if (Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Guilt1, 1), true, Block.blockCopper, Block.blockSilver, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt2, 1), true, Block.blockSilver, Block.blockDiamond, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt3, 1), true, Block.blockCopper, Block.blockRedstone, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt4, 1), true, Block.blockSilver, Block.blockAncientMetal, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt5, 1), true, Block.blockCopper, Block.blockEmerald, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt6, 1), true, Block.blockSilver, Block.blockNetherQuartz, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt7, 1), true, Block.blockCopper, Block.blockLapis, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(B_PICKAXE), true, A_PICKAXE, Block.blockAncientMetal, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
            register.registerShapelessRecipe(new ItemStack(C_PICKAXE), true, B_PICKAXE, Block.blockMithril, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
            register.registerShapelessRecipe(new ItemStack(D_PICKAXE), true, C_PICKAXE, Block.blockAdamantium, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
        }
        register.registerShapelessRecipe(new ItemStack(Zombie_Drug), true, Zombie_Brain, Zombie_Brain, Zombie_Brain, Block.plantYellow);
        register.registerShapelessRecipe(new ItemStack(Zombie_Drug, 3), true, Zombie_Brain, Zombie_Brain, Zombie_Brain, Item.goldenCarrot);
        register.registerShapelessRecipe(new ItemStack(leather, 1), true, rottenFlesh);
        register.registerShapelessRecipe(new ItemStack(Blocks.cloth, 1), true, silk, silk, silk, silk);
        register.registerShapedRecipe(new ItemStack(Item.poisonousPotato, 1), true, "##", "##", ('#'), Item.seeds);
        if (Configs.wenscConfig.isRecipeRottenSoup.ConfigValue)
            register.registerShapelessRecipe(new ItemStack(Zombie_Soup), true, Item.rottenFlesh, Item.spiderEye, Item.poisonousPotato, new ItemStack(Item.dyePowder, 1, 15));
        register.registerShapelessRecipe(new ItemStack(Spider_Leg_B, 6, 0), true, new ItemStack(Spider_Leg, 6, 0), Item.bakedPotato, Item.snowball);
        if (Configs.wenscConfig.isRecipeGAGoldApple.ConfigValue) {
            register.registerShapedRecipe(new ItemStack(BadApple), true, "##", "##", ('#'), Block.leaves);

            for (Item nugget : nuggets) {
                register.registerShapedRecipe(new ItemStack(Item.appleGold), true, "###", "#N#", "###", ('N'), BadApple, ('#'), nugget);

                if (nugget != Item.goldNugget) {
                    register.registerShapedRecipe(new ItemStack(Item.appleGold), true, "###", "#N#", "###", ('N'), Item.appleRed, ('#'), nugget);
                }
            }

        }
        if (Configs.wenscConfig.isRecipeDrugProtection.ConfigValue)
            register.registerShapelessRecipe(new ItemStack(Drug_ZJ, 2), true, Item.emerald, Item.emerald, Item.egg, Block.plantYellow);
        if (Configs.wenscConfig.isRecipeMineralBag.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Stack_Gold_Nether, 2), true, new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2));
            register.registerShapelessRecipe(new ItemStack(Stack_Gold_Nether, 1), true, new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2));

            RepeatRecipeBuilder.of(Stack_Gold_Nether, new ItemStack(Block.oreGold, 1, 2)).build(register);

            register.registerShapelessRecipe(new ItemStack(Stack_Gold, 2), true, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold);
            register.registerShapelessRecipe(new ItemStack(Stack_Gold, 1), true, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold);

            RepeatRecipeBuilder.of(Stack_Gold, Block.oreGold).build(register);

            register.registerShapelessRecipe(new ItemStack(Stack_Silver, 2), true, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver);
            register.registerShapelessRecipe(new ItemStack(Stack_Silver, 1), true, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver);


            RepeatRecipeBuilder.of(Stack_Silver, Block.oreSilver).build(register);

            register.registerShapelessRecipe(new ItemStack(Stack_Copper, 2), true, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper);
            register.registerShapelessRecipe(new ItemStack(Stack_Copper, 1), true, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper);

            RepeatRecipeBuilder.of(Stack_Copper, Block.oreCopper).build(register);

            register.registerShapelessRecipe(new ItemStack(Stack_Iron, 2), true, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron);
            register.registerShapelessRecipe(new ItemStack(Stack_Iron, 1), true, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron);

            RepeatRecipeBuilder.of(Stack_Iron, Block.oreIron).build(register);

            register.registerShapelessRecipe(new ItemStack(Stack_Mithril, 2), true, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril);
            register.registerShapelessRecipe(new ItemStack(Stack_Mithril, 1), true, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril);


            RepeatRecipeBuilder.of(Stack_Mithril, Block.oreMithril).build(register);

            register.registerShapelessRecipe(new ItemStack(Stack_Adamantium, 2), true, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium);
            register.registerShapelessRecipe(new ItemStack(Stack_Adamantium, 1), true, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium);

            RepeatRecipeBuilder.of(Stack_Adamantium, Block.oreAdamantium).build(register);
        }
        if (Configs.wenscConfig.isRecipeGATorch.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.silk, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.sinew, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.silk, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.sinew, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.silk, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.sinew, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.silk, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.sinew, Item.coal, Item.coal);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));

            RepeatRecipeBuilder.of(Stack_Torch, Block.torchWood).ratio(16).is3X3(false).build(register);

            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 2), true, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch_On, 1), true, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood);
            register.registerShapelessRecipe(new ItemStack(Stack_Torch_On, 2), true, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood);
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 12), true, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On);
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 8), true, Stack_Torch_On, Stack_Torch_On);
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 4), true, Stack_Torch_On);
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, Block.wood, Block.wood, Block.wood, Block.wood);
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1));
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2));
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3));
            register.registerShapelessRecipe(new ItemStack(Stack_Leather, 1, 0), true, new ItemStack(Item.leather, 8, 0), Item.silk);
            register.registerShapelessRecipe(new ItemStack(Stack_Leather, 1, 0), true, new ItemStack(Item.leather, 8, 0), Item.sinew);
            register.registerShapelessRecipe(new ItemStack(Item.leather, 8, 0), true, Stack_Leather);


            RepeatRecipeBuilder.of(Stack_Log, Block.wood).is3X3(false).build(register);

        }
        register.registerShapelessRecipe(new ItemStack(Creeper_Soul), true, Creeper_Baby, Creeper_Baby, Creeper_Baby, Creeper_Baby);
        if (Configs.wenscConfig.isRecipeDrugFull.ConfigValue) {

            for (Item nugget : nuggets) {
                register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, Block.plantYellow, nugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8));
                register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, Item.redstone, new ItemStack(Block.plantYellow, 7), nugget);
            }

        }
        for (i = 0; i < 16; i++) {
            if (i == 0 || i == 1 || i == 2 || i == 5 || i == 7 || i == 8) {
                if (Configs.wenscConfig.isRecipeDrugFull.ConfigValue) {
                    for (Item nugget : nuggets) {
                        register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, Item.redstone, new ItemStack(Block.plantRed, 7, i), nugget);
                    }
                }
                register.registerShapelessRecipe(new ItemStack(Zombie_Drug), true, Zombie_Brain, Zombie_Brain, Zombie_Brain, new ItemStack(Block.plantRed, 1, i));
                if (Configs.wenscConfig.isRecipeDrugProtection.ConfigValue)
                    register.registerShapelessRecipe(new ItemStack(Drug_ZJ, 2), true, Item.emerald, Item.emerald, Item.egg, new ItemStack(Block.plantRed, 1, i));
            }
        }

        for (Item ingot : ingots) {
            if (ingot == Item.ingotIron) continue;
            register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, "I I", "IDI", " I ", ('D'), Block.chest, ('I'), ingot);
        }

        if (Configs.wenscConfig.isRecipeRingKiller.ConfigValue) {
            register.registerShapedRecipe(new ItemStack(ringKillerCopper, 1), true, "###", "#*#", "###", ('#'), swordCopper, ('*'), emerald);
            register.registerShapedRecipe(new ItemStack(ringKillerIron, 1), true, "###", "#*#", "###", ('#'), swordIron, ('*'), ringKillerCopper);
            register.registerShapedRecipe(new ItemStack(ringKillerAncient, 1), true, "###", "#*#", "###", ('#'), swordAncientMetal, ('*'), ringKillerIron);
            register.registerShapedRecipe(new ItemStack(ringKillerMithril, 1), true, "###", "#*#", "###", ('#'), swordMithril, ('*'), ringKillerAncient);
            register.registerShapedRecipe(new ItemStack(ringKillerAdamantium, 1), true, "###", "#*#", "###", ('#'), swordAdamantium, ('*'), ringKillerMithril);
        }

        registerSkirtRecipe(register, leather_skirt, leather);
        registerSkirtRecipe(register, copper_skirt, ingotCopper);
        registerSkirtRecipe(register, silver_skirt, ingotSilver);
        registerSkirtRecipe(register, gold_skirt, ingotGold);
        registerSkirtRecipe(register, iron_skirt, ingotIron);
        registerSkirtRecipe(register, ancient_metal_skirt, ingotAncientMetal);
        registerSkirtRecipe(register, mithril_skirt, ingotMithril);
        registerSkirtRecipe(register, adamantium_skirt, ingotAdamantium);

        // iron to ancient metal
//        registerUpdateHelmetRecipe(register, helmetAncientMetal, helmetIron, ingotAncientMetal);
//        registerUpdateChestPlateRecipe(register, plateAncientMetal, plateIron, ingotAncientMetal);
//        registerUpdateLeggingsRecipe(register, legsAncientMetal, legsIron, ingotAncientMetal);
        registerUpdateSkirtRecipe(register, ancient_metal_skirt, iron_skirt, ingotAncientMetal);
//        registerUpdateBootsRecipe(register, bootsAncientMetal, bootsIron, ingotAncientMetal);

        // ancient metal to mithril
//        registerUpdateHelmetRecipe(register, helmetMithril, helmetAncientMetal, ingotMithril);
//        registerUpdateChestPlateRecipe(register, plateMithril, plateAncientMetal, ingotMithril);
//        registerUpdateLeggingsRecipe(register, legsMithril, legsAncientMetal, ingotMithril);
        registerUpdateSkirtRecipe(register, mithril_skirt, ancient_metal_skirt, ingotMithril);
//        registerUpdateBootsRecipe(register, bootsMithril, bootsAncientMetal, ingotMithril);

        // mithril to adamantium
//        registerUpdateHelmetRecipe(register, helmetAdamantium, helmetMithril, ingotAdamantium);
//        registerUpdateChestPlateRecipe(register, plateAdamantium, plateMithril, ingotAdamantium);
//        registerUpdateLeggingsRecipe(register, legsAdamantium, legsMithril, ingotAdamantium);
        registerUpdateSkirtRecipe(register, adamantium_skirt, mithril_skirt, ingotAdamantium);
//        registerUpdateBootsRecipe(register, bootsAdamantium, bootsMithril, ingotAdamantium);


        if (ModCompat.HAS_ITE) {
            ITEAccessor.registerCompatRecipes(register);
        } else {
            vibranium_skirt.setLowestCraftingDifficultyToProduce(adamantium_skirt.getLowestCraftingDifficultyToProduce() * 2);// to suppress the warning
        }
    }

    public static void registerSkirtRecipe(CraftingRecipeRegisterEvent register, Item skirt, Item ingot) {
        register.registerShapedRecipe(new ItemStack(skirt), true, "###", "#A#", "# #",
                '#', ingot,
                'A', silk);
    }

    private static void registerUpdateHelmetRecipe(CraftingRecipeRegisterEvent register, Item upper, Item lower, Item updateIngot) {
        register.registerShapedRecipe(new ItemStack(upper), true, "AAA", "AHA",
                ('A'), updateIngot,
                ('H'), lower).extendsNBT().keepQuality();
    }

    private static void registerUpdateChestPlateRecipe(CraftingRecipeRegisterEvent register, Item upper, Item lower, Item ingot) {
        register.registerShapedRecipe(new ItemStack(upper), true, "APA", "AAA", "AAA",
                ('A'), ingot,
                ('P'), lower).extendsNBT().keepQuality();
    }

    private static void registerUpdateLeggingsRecipe(CraftingRecipeRegisterEvent register, Item upper, Item lower, Item ingot) {
        register.registerShapedRecipe(new ItemStack(upper), true, "AAA", "ALA", "A A",
                ('A'), ingot,
                ('L'), lower).extendsNBT().keepQuality();
    }

    private static void registerUpdateSkirtRecipe(CraftingRecipeRegisterEvent register, Item upper, Item lower, Item ingot) {
        registerUpdateLeggingsRecipe(register, upper, lower, ingot);
    }

    private static void registerUpdateBootsRecipe(CraftingRecipeRegisterEvent register, Item upper, Item lower, Item ingot) {
        register.registerShapedRecipe(new ItemStack(upper), true, "ABA", "A A",
                ('A'), ingot,
                ('B'), lower).extendsNBT().keepQuality();
    }

    public static int getNextItemID() {
        return IdUtil.getNextItemID();
    }

    private static class RepeatRecipeBuilder {
        final int inputID;
        final int inputMeta;

        final int outputID;
        final int outputMeta;

        int ratio = 4;
        boolean is3X3 = true;

        public RepeatRecipeBuilder(int inputID, int inputMeta, int outputID, int outputMeta) {
            this.inputID = inputID;
            this.inputMeta = inputMeta;
            this.outputID = outputID;
            this.outputMeta = outputMeta;
        }

        public static RepeatRecipeBuilder of(Object input, Object output) {
            int[] inputResult = identify(input);
            int[] outputResult = identify(output);
            return new RepeatRecipeBuilder(inputResult[0], inputResult[1], outputResult[0], outputResult[1]);
        }

        private static int[] identify(Object o) {
            if (o instanceof ItemStack itemStack) {
                return new int[]{itemStack.itemID, itemStack.getItemSubtype()};
            }
            if (o instanceof Item item) {
                return new int[]{item.itemID, 0};
            }
            if (o instanceof Block block) {
                return new int[]{block.blockID, 0};
            }
            throw new IllegalArgumentException();
        }

        public RepeatRecipeBuilder is3X3(boolean is3X3) {
            this.is3X3 = is3X3;
            return this;
        }

        public RepeatRecipeBuilder ratio(int ratio) {
            this.ratio = ratio;
            return this;
        }

        private void build(CraftingRecipeRegisterEvent register) {
            for (int i = 1; i <= (this.is3X3 ? 9 : 4); i++) {
                Object[] array = new ItemStack[i];
                Arrays.fill(array, new ItemStack(this.inputID, 1, this.inputMeta));
                register.registerShapelessRecipe(new ItemStack(this.outputID, this.ratio * i, this.outputMeta), true, array);
            }
        }
    }
}
