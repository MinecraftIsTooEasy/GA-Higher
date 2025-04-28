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
import com.github.Debris.GAHigher.material.Materials;
import com.github.Debris.GAHigher.unsafe.ITEAccessor;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;
import net.xiaoyu233.fml.util.ReflectHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items extends Item {
    public static final ItemFood Eight_Hamburger = new ItemEight_Hamburger(getNextItemID());

    public static final ItemPickaxe GA_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, getNextItemID(), Materials.mitega);

    public static final ItemFood Zombie_Brain = new ItemZombie_Brain(getNextItemID());

    public static final ItemFood Zombie_Drug = new ItemZombie_Drug(getNextItemID());

    public static final ItemFood Zombie_Soup = new ItemZombie_Soup(getNextItemID());

    public static final ItemFood Creeper_Baby = new ItemCreeper_Baby(getNextItemID());

    public static final ItemFood Creeper_Soul = new ItemCreeper_Soul(getNextItemID());

    public static final ItemFood Spider_Leg = new ItemSpider_Leg(getNextItemID());

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

    public static final Item Stones = new StandardItem(getNextItemID(), Material.diamond, "stones").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(1);

    public static final Item Gem_Blue = new StandardItem(getNextItemID(), Material.diamond, "gem_blue").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(100);

    public static final Item Gem_Yellow = new StandardItem(getNextItemID(), Material.diamond, "gem_yellow").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(1000);

    public static final ItemFood Drug_BG = new ItemDrug_BG(getNextItemID());

    public static final ItemFood Drug_ZJ = new ItemDrug_ZJ(getNextItemID());

    //    public static final ItemGaBucket GA_BUCKET = new ItemGaBucket(getNextItemID(), getBestMaterial(), Material.h);
    public static final ItemGaBucket GA_BUCKET = new ItemGaBucket(getNextItemID(), getBestMaterial(), Material.water);

    public static final Item Drug_YD = new ItemDrug_YD(getNextItemID());

    public static final ItemFood Drug_YD_B = new ItemDrug_YD_B(getNextItemID());

    public static final ItemPickaxe A_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.ancient_metal);

    public static final ItemPickaxe B_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.ancient_metal);

    public static final ItemPickaxe C_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.mithril);

    public static final ItemPickaxe D_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), Materials.adamantium);

    public static final ItemPickaxe E_PICKAXE = ReflectHelper.createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, (getNextItemID()), getBestMaterial());

    public static final Item MITEGA_INGOT = ReflectHelper.createInstance(ItemIngot.class, new Class[]{int.class, Material.class}, getNextItemID(), Materials.mitega);

    public static final Item Tomato = new ItemTomato(getNextItemID());

    public static final Item Tomato_Omelette = new ItemTomato_Omelette(getNextItemID());

    public static final Item Tomato_Bad = new ItemTomato_Bad(getNextItemID());

    public static final Item Bamboo = new ItemBamboo(getNextItemID(), Blocks.BlockBamboo, "bamboo");

    public static final Item Sausage = new ItemSausage(getNextItemID());

    public static final Item BadApple = new ItemBadApple(getNextItemID());

    public static final Item GABag = new ItemGABag(getNextItemID(), getBestMaterial());

    public static final Item HellStones = new ItemHellStone(getNextItemID());

    public static final Item Guilt1 = new ItemGuilt1(getNextItemID());

    public static final Item Guilt2 = new ItemGuilt2(getNextItemID());

    public static final Item Guilt3 = new ItemGuilt3(getNextItemID());

    public static final Item Guilt4 = new ItemGuilt4(getNextItemID());

    public static final Item Guilt5 = new ItemGuilt5(getNextItemID());

    public static final Item Guilt6 = new ItemGuilt6(getNextItemID());

    public static final Item Guilt7 = new ItemGuilt7(getNextItemID());

    public static final Item Wither_Medal = ReflectHelper.createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, getNextItemID(), Material.diamond, "wither_medal").setCraftingDifficultyAsComponent(1.0E-9F);

    public static final Item YYY = new ItemYinYangYu(getNextItemID());

    public static final Item Spider_Leg_B = new ItemSpider_Leg_B(getNextItemID());

    public static final Item Powder_JIN = new ItemPowderJin(getNextItemID());

    public static final Item Powder_MU = new ItemPowderMu(getNextItemID());

    public static final Item Powder_SHUI = new ItemPowderShui(getNextItemID());

    public static final Item Powder_HUO = new ItemPowderHuo(getNextItemID());

    public static final Item Powder_TU = new ItemPowderTu(getNextItemID());

    public static final Item Powder_Feng = new ItemPowderFeng(getNextItemID());

    public static final Item Powder_Lei = new ItemPowderLei(getNextItemID());

    public static final Item Powder_Bing = new ItemPowderBing(getNextItemID());

    public static final Item Powder_An = new ItemPowderAn(getNextItemID());

    public static final ItemNugget MITEGA_NUGGET = ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, getNextItemID(), Materials.mitega);

    public static final Item GotchaChest = new ItemGotchaChest(getNextItemID());

    public static final Item ColorBag = new ItemColorBag(getNextItemID(), Material.seed, "color_bag");

    public static final Item Ghast_ShiZuKu = new ItemGhast_ShiZuKu(getNextItemID());

    public static final Item LaTiao = new ItemLaTiao(getNextItemID());

    public static final Item CubeSugar = new ItemCubeSugar(getNextItemID());

    public static final Item HomeScroll = new ItemHomeScroll(getNextItemID(), Material.seed, "home_scroll");

    public static final Item Fan = new ItemFan(getNextItemID(), Materials.mitega);

    public static final Item Core = new ItemCore(getNextItemID());

    public static final Item SoulBook = new ItemSoulBook(getNextItemID());

    public static final Item SoulNewBook = new ItemSoulNewBook(getNextItemID());

    public static final Item Pants = new ItemGAMisc(getNextItemID(), "pants");

    public static final Item SoulBag = new ItemSoulBag(getNextItemID(), Materials.mitega);// TODO container

    public static final Item SummonStaff = new ItemSummonStaff(getNextItemID(), Material.flint);

    public static final Item OreBag = new ItemOreBag(getNextItemID(), Materials.mitega);

    public static final Item PinRuCloth = new ItemPinRuCloth(getNextItemID(), Materials.mitega, false);

    public static final Item Dimension = new ItemDimension(getNextItemID(), Material.diamond);

    public static final Item AnimalBag = new ItemAnimalBag(getNextItemID(), Materials.mitega);

    public static final Item AnimalBall = new ItemAnimalBall(getNextItemID(), Materials.mitega);

    // specific for ga higher

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
        Drug_YD_B.setXPReward(5 * Configs.wenscConfig.MeatExpValue.ConfigValue);


        register("eight_hamburger", Eight_Hamburger).setUnlocalizedName("eight_hamburger").setMaxStackSize(64);
        register("ga_pickaxe", GA_PICKAXE);
        register("zombie_brain", Zombie_Brain).setMaxStackSize(64);
        register("zombie_drug", Zombie_Drug).setMaxStackSize(64).setLowestCraftingDifficultyToProduce(1.0F);
        register("zombie_soup", Zombie_Soup).setMaxStackSize(64).setLowestCraftingDifficultyToProduce(1.0F);
        register("creeper_baby", Creeper_Baby).setMaxStackSize(64);
        register("creeper_soul", Creeper_Soul).setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("spider_leg", Spider_Leg).setMaxStackSize(64);
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
        register("stones", Stones).setUnlocalizedName("stones").setMaxStackSize(64);
        register("gem_blue", Gem_Blue).setUnlocalizedName("gem_blue").setMaxStackSize(64);
        register("gem_yellow", Gem_Yellow).setUnlocalizedName("gem_yellow").setMaxStackSize(64);
        register("drug_bg", Drug_BG).setUnlocalizedName("drug_bg").setMaxStackSize(64).setLowestCraftingDifficultyToProduce(1.0F);
        register("drug_zj", Drug_ZJ).setUnlocalizedName("drug_zj").setMaxStackSize(64).setLowestCraftingDifficultyToProduce(1.0F);
        register("ga_bucket", GA_BUCKET).setUnlocalizedName("ga_bucket").setMaxStackSize(64);
        register("drug_yd", Drug_YD).setUnlocalizedName("drug_yd").setMaxStackSize(64);
        register("drug_yd_b", Drug_YD_B).setUnlocalizedName("drug_yd_b").setMaxStackSize(64);
        register("a_pickaxe", A_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("b_pickaxe", B_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("c_pickaxe", C_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("d_pickaxe", D_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("e_pickaxe", E_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("mitega", MITEGA_INGOT);
        register("tomato", Tomato).setLowestCraftingDifficultyToProduce(1.0F);
        register("tomato_omelette", Tomato_Omelette).setLowestCraftingDifficultyToProduce(1.0F);
        register("tomato_bad", Tomato_Bad).setLowestCraftingDifficultyToProduce(1.0F);
        register("bamboo", Bamboo).setLowestCraftingDifficultyToProduce(1.0F);
        register("sausage", Sausage).setLowestCraftingDifficultyToProduce(1.0F);
        register("bad_apple", BadApple).setLowestCraftingDifficultyToProduce(1.0F);
        register("ga_bag", GABag).setUnlocalizedName("ga_bag").setLowestCraftingDifficultyToProduce(1.0F);
        register("hell_stones", HellStones).setMaxStackSize(64);
        register("guilt1", Guilt1).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt2", Guilt2).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt3", Guilt3).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt4", Guilt4).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt5", Guilt5).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt6", Guilt6).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt7", Guilt7).setLowestCraftingDifficultyToProduce(1.0F);
        register("wither_medal", Wither_Medal).setMaxStackSize(64);
        register("yinyang_orb", YYY).setMaxStackSize(64);
        register("spider_leg_b", Spider_Leg_B).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_jin", Powder_JIN).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_mu", Powder_MU).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_shui", Powder_SHUI).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_huo", Powder_HUO).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_tu", Powder_TU).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_feng", Powder_Feng).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_lei", Powder_Lei).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_bing", Powder_Bing).setLowestCraftingDifficultyToProduce(1.0F);
        register("powder_an", Powder_An).setLowestCraftingDifficultyToProduce(1.0F);
        register("mitega_nugget", MITEGA_NUGGET);
        register("gotchachest", GotchaChest).setMaxStackSize(1);
        register("color_bag", ColorBag).setMaxStackSize(64);
        register("shizuku", Ghast_ShiZuKu).setLowestCraftingDifficultyToProduce(1.0F);
        register("latiao", LaTiao).setLowestCraftingDifficultyToProduce(1.0F);
        register("cubesugar", CubeSugar).setLowestCraftingDifficultyToProduce(1.0F);
        register("home_scroll", HomeScroll).setLowestCraftingDifficultyToProduce(1.0F);
        register("fan", Fan).setLowestCraftingDifficultyToProduce(1.0F);
        register("core", Core).setLowestCraftingDifficultyToProduce(1.0F);
        register("soulbook", SoulBook).setLowestCraftingDifficultyToProduce(1.0F);
        register("soulnewbook", SoulNewBook).setLowestCraftingDifficultyToProduce(1.0F);
        register("pants", Pants).setLowestCraftingDifficultyToProduce(1.0F);
        register("soulbag", SoulBag).setLowestCraftingDifficultyToProduce(1.0F);
        register("summon_staff", SummonStaff).setLowestCraftingDifficultyToProduce(1.0F);
        register("ore_bag", OreBag).setLowestCraftingDifficultyToProduce(1.0F);
        register("pinrucloth", PinRuCloth).setLowestCraftingDifficultyToProduce(1.0F);
        register("dimension", Dimension).setLowestCraftingDifficultyToProduce(1.0F);
        register("animal_bag", AnimalBag).setLowestCraftingDifficultyToProduce(1.0F);
        register("animal_ball", AnimalBall).setLowestCraftingDifficultyToProduce(1.0F);


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

    public static void registerRecipes(CraftingRecipeRegisterEvent event) {
        Item.manure.setCraftingDifficultyAsComponent(0.0F);

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

        if (Configs.wenscConfig.isRecipeGABag.ConfigValue)
            event.registerShapedRecipe(new ItemStack(GABag, 1), true, "#*#", "*#*", "#*#", ('#'), Blocks.obsidian, ('*'), enderPearl);
        event.registerShapedRecipe(new ItemStack(Item.paper), true, "###", ('#'), Item.stick);
        event.registerShapelessRecipe(new ItemStack(Blocks.BlockGotcha, 64, 4), true, Gem_Blue);
        int i;
        for (i = 1; i < 10; i++) {
            event.registerShapelessRecipe(new ItemStack(Block.cobblestone, i), true, new ItemStack(Stones, i));
        }
        for (i = 0; i < 5; i++) {
            event.registerShapedRecipe(new ItemStack(Blocks.BlockSlime, 8), true, "###", "#S#", "###",
                    '#', Block.sand,
                    'S', new ItemStack(Item.slimeBall, 1, i));
        }
        Eight_Hamburger.setCraftingDifficultyAsComponent(ItemRock.getCraftingDifficultyAsComponent(Material.bread) / 4000.0F);
        event.registerShapedRecipe(new ItemStack(Eight_Hamburger, 1), true, "###", "###", "###",
                '#', Item.manure);
        event.registerShapedRecipe(new ItemStack(GA_PICKAXE), true, "###", " S ", " S ",
                '#', MITEGA_INGOT,
                'S', Item.blazeRod);
        GA_PICKAXE.setLowestCraftingDifficultyToProduce(1.0F);


        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful0, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 0));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful1, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 1));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful2, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 2));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful3, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 3));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful4, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 4));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful5, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 5));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful6, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 6));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful7, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 7));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful8, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 8));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful9, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 9));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful10, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 10));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful11, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 11));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful12, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 12));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful13, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 13));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful14, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 14));
        event.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful15, 64), true, Gem_Blue, redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 15));
        for (i = 0; i < 16; i++) {
            event.registerShapelessRecipe(new ItemStack(Blocks.blockColorful, 64, i), true, Gem_Blue, redstone, new ItemStack(Item.dyePowder, 1, i));
            event.registerShapelessRecipe(new ItemStack(Blocks.blockColorfulBrick, 64, i), true, Gem_Blue, redstone, Blocks.stoneBrick, new ItemStack(Item.dyePowder, 1, i));
            event.registerShapelessRecipe(new ItemStack(Blocks.BlockGotcha, 64, i), true, Gem_Blue, new ItemStack(Item.dyePowder, 1, i));
            if (Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue)
                event.registerShapedRecipe(new ItemStack(A_PICKAXE, 1), true, "###", "#I#", "###", ('I'), Item.pickaxeAncientMetal, ('#'), new ItemStack(Blocks.BlockGotcha, 1, i));
            event.registerShapelessRecipe(new ItemStack(silk, 4), true, new ItemStack(Block.cloth, 1, i));
        }
        if (Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue) {
            event.registerShapelessRecipe(new ItemStack(Guilt1, 1), true, Block.blockCopper, Block.blockSilver, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            event.registerShapelessRecipe(new ItemStack(Guilt2, 1), true, Block.blockSilver, Block.blockDiamond, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            event.registerShapelessRecipe(new ItemStack(Guilt3, 1), true, Block.blockCopper, Block.blockRedstone, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            event.registerShapelessRecipe(new ItemStack(Guilt4, 1), true, Block.blockSilver, Block.blockAncientMetal, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            event.registerShapelessRecipe(new ItemStack(Guilt5, 1), true, Block.blockCopper, Block.blockEmerald, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            event.registerShapelessRecipe(new ItemStack(Guilt6, 1), true, Block.blockSilver, Block.blockNetherQuartz, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            event.registerShapelessRecipe(new ItemStack(Guilt7, 1), true, Block.blockCopper, Block.blockLapis, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            event.registerShapelessRecipe(new ItemStack(B_PICKAXE), true, A_PICKAXE, Block.blockAncientMetal, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
            event.registerShapelessRecipe(new ItemStack(C_PICKAXE), true, B_PICKAXE, Block.blockMithril, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
            event.registerShapelessRecipe(new ItemStack(D_PICKAXE), true, C_PICKAXE, Block.blockAdamantium, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
        }

        event.registerShapelessRecipe(new ItemStack(Tomato_Omelette, 1, 0), true, Tomato, Item.egg);
        event.registerShapelessRecipe(new ItemStack(Blocks.BlockTomato, 1, 0), true, Tomato, Item.manure, new ItemStack(Item.dyePowder, 1, 15), Block.dirt);

        event.registerShapedRecipe(new ItemStack(Item.stick), false, "#", "#", "#",
                '#', Bamboo);

        event.registerShapelessRecipe(new ItemStack(Zombie_Drug), true, Zombie_Brain, Zombie_Brain, Zombie_Brain, Block.plantYellow);
        event.registerShapelessRecipe(new ItemStack(Zombie_Drug, 3), true, Zombie_Brain, Zombie_Brain, Zombie_Brain, Item.goldenCarrot);
        event.registerShapelessRecipe(new ItemStack(leather, 1), true, rottenFlesh);
        event.registerShapelessRecipe(new ItemStack(Blocks.cloth, 1), true, silk, silk, silk, silk);
        event.registerShapedRecipe(new ItemStack(Item.poisonousPotato, 1), true, "##", "##", ('#'), Item.seeds);
        if (Configs.wenscConfig.isRecipeRottenSoup.ConfigValue)
            event.registerShapelessRecipe(new ItemStack(Zombie_Soup), true, Item.rottenFlesh, Item.spiderEye, Item.poisonousPotato, new ItemStack(Item.dyePowder, 1, 15));
        event.registerShapelessRecipe(new ItemStack(Spider_Leg_B, 6, 0), true, new ItemStack(Spider_Leg, 6, 0), Item.bakedPotato, Item.snowball);
        event.registerShapelessRecipe(new ItemStack(LaTiao, 1, 0), true, Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh, Item.rottenFlesh);
        event.registerShapelessRecipe(new ItemStack(CubeSugar, 1, 0), true, Item.sugar, Item.sugar, Item.sugar, Item.sugar);
        event.registerShapelessRecipe(new ItemStack(MITEGA_NUGGET, 1, 0), true, Powder_An, Powder_Bing, Powder_Feng, Powder_HUO, Powder_JIN, Powder_Lei, Powder_MU, Powder_SHUI, Powder_TU);
        event.registerShapelessRecipe(new ItemStack(MITEGA_INGOT, 1, 0), true, new ItemStack(MITEGA_NUGGET, 9, 0));
        event.registerShapelessRecipe(new ItemStack(Core, 1, 0), true, new ItemStack(MITEGA_NUGGET, 4, 0));
        event.registerShapedRecipe(new ItemStack(Fan), true, "I  ", "SI ", "ASI",
                'I', Item.paper,
                'S', Item.stick,
                'A', Core);
        event.registerShapedRecipe(new ItemStack(OreBag, 1), true, "III", "I#I", "III",

                'I', Item.leather,
                '#', Core);
        event.registerShapedRecipe(new ItemStack(SummonStaff, 1), true, "I", "#", "#",

                'I', Gem_Blue,
                '#', Item.stick);
        event.registerShapedRecipe(new ItemStack(AnimalBag, 1), true, " I ", "I#I", "I I",

                'I', Item.ingotGold,
                '#', Core);
        event.registerShapelessRecipe(new ItemStack(HomeScroll, 64, 0), true, Gem_Blue, new ItemStack(Item.paper, 4), new ItemStack(Powder_TU, 4));
        if (Configs.wenscConfig.isRecipeGAGoldApple.ConfigValue) {
            event.registerShapedRecipe(new ItemStack(BadApple), true, "##", "##", ('#'), Block.leaves);

            for (Item nugget : nuggets) {
                event.registerShapedRecipe(new ItemStack(Item.appleGold), true, "###", "#N#", "###", ('N'), BadApple, ('#'), nugget);

                if (nugget != Item.goldNugget) {
                    event.registerShapedRecipe(new ItemStack(Item.appleGold), true, "###", "#N#", "###", ('N'), Item.appleRed, ('#'), nugget);
                }
            }

        }
        if (Configs.wenscConfig.isRecipeDrugProtection.ConfigValue)
            event.registerShapelessRecipe(new ItemStack(Drug_ZJ, 2), true, Item.emerald, Item.emerald, Item.egg, Block.plantYellow);
        if (Configs.wenscConfig.isRecipeMineralBag.ConfigValue) {
            event.registerShapelessRecipe(new ItemStack(Stack_Gold_Nether, 2), true, new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2));
            event.registerShapelessRecipe(new ItemStack(Stack_Gold_Nether, 1), true, new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2));

            RepeatRecipeBuilder.of(Stack_Gold_Nether, new ItemStack(Block.oreGold, 1, 2)).build(event);

            event.registerShapelessRecipe(new ItemStack(Stack_Gold, 2), true, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold);
            event.registerShapelessRecipe(new ItemStack(Stack_Gold, 1), true, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold);

            RepeatRecipeBuilder.of(Stack_Gold, Block.oreGold).build(event);

            event.registerShapelessRecipe(new ItemStack(Stack_Silver, 2), true, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver);
            event.registerShapelessRecipe(new ItemStack(Stack_Silver, 1), true, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver);


            RepeatRecipeBuilder.of(Stack_Silver, Block.oreSilver).build(event);

            event.registerShapelessRecipe(new ItemStack(Stack_Copper, 2), true, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper);
            event.registerShapelessRecipe(new ItemStack(Stack_Copper, 1), true, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper);

            RepeatRecipeBuilder.of(Stack_Copper, Block.oreCopper).build(event);

            event.registerShapelessRecipe(new ItemStack(Stack_Iron, 2), true, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron);
            event.registerShapelessRecipe(new ItemStack(Stack_Iron, 1), true, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron);

            RepeatRecipeBuilder.of(Stack_Iron, Block.oreIron).build(event);

            event.registerShapelessRecipe(new ItemStack(Stack_Mithril, 2), true, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril);
            event.registerShapelessRecipe(new ItemStack(Stack_Mithril, 1), true, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril);


            RepeatRecipeBuilder.of(Stack_Mithril, Block.oreMithril).build(event);

            event.registerShapelessRecipe(new ItemStack(Stack_Adamantium, 2), true, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium);
            event.registerShapelessRecipe(new ItemStack(Stack_Adamantium, 1), true, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium);

            RepeatRecipeBuilder.of(Stack_Adamantium, Block.oreAdamantium).build(event);
        }
        if (Configs.wenscConfig.isRecipeGATorch.ConfigValue) {
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.silk, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.sinew, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Block.wood, Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.silk, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.sinew, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 1), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.silk, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.sinew, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 2), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.silk, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.sinew, Item.coal, Item.coal);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new ItemStack(Block.wood, 1, 3), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1));

            RepeatRecipeBuilder.of(Stack_Torch, Block.torchWood).ratio(16).is3X3(false).build(event);

            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch, 2), true, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch_On, 1), true, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood);
            event.registerShapelessRecipe(new ItemStack(Stack_Torch_On, 2), true, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood);
            event.registerShapelessRecipe(new ItemStack(Block.torchWood, 12), true, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On);
            event.registerShapelessRecipe(new ItemStack(Block.torchWood, 8), true, Stack_Torch_On, Stack_Torch_On);
            event.registerShapelessRecipe(new ItemStack(Block.torchWood, 4), true, Stack_Torch_On);
            event.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, Block.wood, Block.wood, Block.wood, Block.wood);
            event.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1));
            event.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2));
            event.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3));
            event.registerShapelessRecipe(new ItemStack(Stack_Leather, 1, 0), true, new ItemStack(Item.leather, 8, 0), Item.silk);
            event.registerShapelessRecipe(new ItemStack(Stack_Leather, 1, 0), true, new ItemStack(Item.leather, 8, 0), Item.sinew);
            event.registerShapelessRecipe(new ItemStack(Item.leather, 8, 0), true, Stack_Leather);


            RepeatRecipeBuilder.of(Stack_Log, Block.wood).is3X3(false).build(event);

        }
        event.registerShapelessRecipe(new ItemStack(Creeper_Soul), true, Creeper_Baby, Creeper_Baby, Creeper_Baby, Creeper_Baby);
        if (Configs.wenscConfig.isRecipeDrugFull.ConfigValue) {

            for (Item nugget : nuggets) {
                event.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, Block.plantYellow, nugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8));
                event.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, Item.redstone, new ItemStack(Block.plantYellow, 7), nugget);
            }

        }
        for (i = 0; i < 16; i++) {
            if (i == 0 || i == 1 || i == 2 || i == 5 || i == 7 || i == 8) {
                if (Configs.wenscConfig.isRecipeDrugFull.ConfigValue) {
                    for (Item nugget : nuggets) {
                        event.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, Item.redstone, new ItemStack(Block.plantRed, 7, i), nugget);
                    }
                }
                event.registerShapelessRecipe(new ItemStack(Zombie_Drug), true, Zombie_Brain, Zombie_Brain, Zombie_Brain, new ItemStack(Block.plantRed, 1, i));
                if (Configs.wenscConfig.isRecipeDrugProtection.ConfigValue)
                    event.registerShapelessRecipe(new ItemStack(Drug_ZJ, 2), true, Item.emerald, Item.emerald, Item.egg, new ItemStack(Block.plantRed, 1, i));
            }
        }

        for (Item ingot : ingots) {
            if (ingot == Item.ingotIron) continue;
            event.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, "I I", "IDI", " I ", ('D'), Block.chest, ('I'), ingot);
        }

        registerSkirtRecipe(event, leather_skirt, leather);
        registerSkirtRecipe(event, copper_skirt, ingotCopper);
        registerSkirtRecipe(event, silver_skirt, ingotSilver);
        registerSkirtRecipe(event, gold_skirt, ingotGold);
        registerSkirtRecipe(event, iron_skirt, ingotIron);
        registerSkirtRecipe(event, ancient_metal_skirt, ingotAncientMetal);
        registerSkirtRecipe(event, mithril_skirt, ingotMithril);
        registerSkirtRecipe(event, adamantium_skirt, ingotAdamantium);

        // iron to ancient metal
//        registerUpdateHelmetRecipe(register, helmetAncientMetal, helmetIron, ingotAncientMetal);
//        registerUpdateChestPlateRecipe(register, plateAncientMetal, plateIron, ingotAncientMetal);
//        registerUpdateLeggingsRecipe(register, legsAncientMetal, legsIron, ingotAncientMetal);
        registerUpdateSkirtRecipe(event, ancient_metal_skirt, iron_skirt, ingotAncientMetal);
//        registerUpdateBootsRecipe(register, bootsAncientMetal, bootsIron, ingotAncientMetal);

        // ancient metal to mithril
//        registerUpdateHelmetRecipe(register, helmetMithril, helmetAncientMetal, ingotMithril);
//        registerUpdateChestPlateRecipe(register, plateMithril, plateAncientMetal, ingotMithril);
//        registerUpdateLeggingsRecipe(register, legsMithril, legsAncientMetal, ingotMithril);
        registerUpdateSkirtRecipe(event, mithril_skirt, ancient_metal_skirt, ingotMithril);
//        registerUpdateBootsRecipe(register, bootsMithril, bootsAncientMetal, ingotMithril);

        // mithril to adamantium
//        registerUpdateHelmetRecipe(register, helmetAdamantium, helmetMithril, ingotAdamantium);
//        registerUpdateChestPlateRecipe(register, plateAdamantium, plateMithril, ingotAdamantium);
//        registerUpdateLeggingsRecipe(register, legsAdamantium, legsMithril, ingotAdamantium);
        registerUpdateSkirtRecipe(event, adamantium_skirt, mithril_skirt, ingotAdamantium);
//        registerUpdateBootsRecipe(register, bootsAdamantium, bootsMithril, ingotAdamantium);


        if (ModCompat.HAS_ITE) {
            ITEAccessor.registerCompatRecipes(event);
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
