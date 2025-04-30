package com.github.Debris.GAHigher.block;

import com.github.Debris.GAHigher.GAStart;
import com.github.Debris.GAHigher.client.GACreativeTabs;
import com.github.Debris.GAHigher.material.Materials;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;
import net.xiaoyu233.fml.util.ReflectHelper;

public abstract class Blocks extends Block {
    public static final BlockGotcha BlockGotcha = new BlockGotcha(getNextBlockID(), Material.glass, false);

    // block ga seems to be colorful block so skip it

//    public static final BlockNewTorch BlockNewTorch = (new BlockNewTorch(176, Material.s)).setCraftingDifficultyAsComponent(1.0E-9F);
//    public static final BlockNewTorch BlockNewTorch = (new BlockNewTorch(176, Material.circuits)).setCraftingDifficultyAsComponent(1.0E-9F);

    public static final BlockSlime BlockSlime = new BlockSlime(177);

    public static final BlockTomato BlockTomato = new BlockTomato(178);

    public static final BlockBamboo BlockBamboo = new BlockBamboo(179);

    public static final BlockGotchaChest GotchaBox = new BlockGotchaChest(getNextBlockID());

    public static final Block blockColorful = ReflectHelper.createInstance(BlockColorful.class, new Class[]{int.class, Material.class}, getNextBlockID(), Materials.stone).setUnlocalizedName("blockColorful");

    public static final Block blockColorfulBrick = ReflectHelper.createInstance(BlockColorfulBrick.class, new Class[]{int.class, Material.class}, getNextBlockID(), Materials.stone).setUnlocalizedName("blockColorfulBrick");

    public static final Block blockColorfulWall = new BlockColorfulWall(getNextBlockID(), blockColorful, 0);

    public static final Block blockStairsColorful0 = new BlockStairsColorful(getNextBlockID(), blockColorful, 0);

    public static final Block blockStairsColorful1 = new BlockStairsColorful(getNextBlockID(), blockColorful, 1);

    public static final Block blockStairsColorful2 = new BlockStairsColorful(getNextBlockID(), blockColorful, 2);

    public static final Block blockStairsColorful3 = new BlockStairsColorful(getNextBlockID(), blockColorful, 3);

    public static final Block blockStairsColorful4 = new BlockStairsColorful(getNextBlockID(), blockColorful, 4);

    public static final Block blockStairsColorful5 = new BlockStairsColorful(getNextBlockID(), blockColorful, 5);

    public static final Block blockStairsColorful6 = new BlockStairsColorful(getNextBlockID(), blockColorful, 6);

    public static final Block blockStairsColorful7 = new BlockStairsColorful(getNextBlockID(), blockColorful, 7);

    public static final Block blockStairsColorful8 = new BlockStairsColorful(getNextBlockID(), blockColorful, 8);

    public static final Block blockStairsColorful9 = new BlockStairsColorful(getNextBlockID(), blockColorful, 9);

    public static final Block blockStairsColorful10 = new BlockStairsColorful(getNextBlockID(), blockColorful, 10);

    public static final Block blockStairsColorful11 = new BlockStairsColorful(getNextBlockID(), blockColorful, 11);

    public static final Block blockStairsColorful12 = new BlockStairsColorful(getNextBlockID(), blockColorful, 12);

    public static final Block blockStairsColorful13 = new BlockStairsColorful(getNextBlockID(), blockColorful, 13);

    public static final Block blockStairsColorful14 = new BlockStairsColorful(getNextBlockID(), blockColorful, 14);

    public static final Block blockStairsColorful15 = new BlockStairsColorful(getNextBlockID(), blockColorful, 15);

    public static final BlockSlabGroup4 blockColorfulSingleSlabGroup1 = (BlockSlabGroup4) (new BlockSlabGroup4(getNextBlockID(), Material.stone)).setStepSound(soundStoneFootstep);

    public static final BlockColorfulDoubleSlab blockColorfulDoubleSlabGroup1 = (BlockColorfulDoubleSlab) (new BlockColorfulDoubleSlab(getNextBlockID(), blockColorfulSingleSlabGroup1)).setStepSound(soundStoneFootstep);

    public static final BlockSlabGroup5 blockColorfulSingleSlabGroup2 = (BlockSlabGroup5) (new BlockSlabGroup5(getNextBlockID(), Material.stone)).setStepSound(soundStoneFootstep);

    public static final BlockColorfulDoubleSlab blockColorfulDoubleSlabGroup2 = (BlockColorfulDoubleSlab) (new BlockColorfulDoubleSlab(getNextBlockID(), blockColorfulSingleSlabGroup2)).setStepSound(soundStoneFootstep);

    public static final Block blockItemDuper = new BlockItemDuper(getNextBlockID()).setHardness(3.0F);

    public static final BlockWorkbenchGA blockWorkbenchGA = new BlockWorkbenchGA(getNextBlockID());

    protected Blocks(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    public static int getNextBlockID() {
        return IdUtil.getNextBlockID();
    }

    private static void registerItemBlock(Block block, String resourceLocation) {
        itemRegistryEvent.registerItemBlock(GAStart.MOD_NAME, resourceLocation, block);
        if (block.canBeCarried()) {
            block.setCreativeTab(GACreativeTabs.GABlock);
        }
    }

    private static ItemRegistryEvent itemRegistryEvent;

    public static void registerModern(ItemRegistryEvent register) {
        itemRegistryEvent = register;

        registerItemBlock(BlockGotcha, "gotcha");
//        registerItemBlock((Block)BlockNewTorch, "new_torch_on");
        registerItemBlock(BlockSlime, "block_slime");
        registerItemBlock(BlockTomato, "tomato");
        registerItemBlock(BlockBamboo, "bamboo");
        registerItemBlock(GotchaBox, "gotchabox");
        registerItemBlock(blockColorful, "colorful");
        registerItemBlock(blockColorfulBrick, "colorful_brick");
        registerItemBlock(blockColorfulWall, "colorful_wall");
        registerItemBlock(blockStairsColorful0, "colorful_stair");
        registerItemBlock(blockStairsColorful1, "colorful_stair");
        registerItemBlock(blockStairsColorful2, "colorful_stair");
        registerItemBlock(blockStairsColorful3, "colorful_stair");
        registerItemBlock(blockStairsColorful4, "colorful_stair");
        registerItemBlock(blockStairsColorful5, "colorful_stair");
        registerItemBlock(blockStairsColorful6, "colorful_stair");
        registerItemBlock(blockStairsColorful7, "colorful_stair");
        registerItemBlock(blockStairsColorful8, "colorful_stair");
        registerItemBlock(blockStairsColorful9, "colorful_stair");
        registerItemBlock(blockStairsColorful10, "colorful_stair");
        registerItemBlock(blockStairsColorful11, "colorful_stair");
        registerItemBlock(blockStairsColorful12, "colorful_stair");
        registerItemBlock(blockStairsColorful13, "colorful_stair");
        registerItemBlock(blockStairsColorful14, "colorful_stair");
        registerItemBlock(blockStairsColorful15, "colorful_stair");
        registerItemBlock(blockItemDuper, "item_duper");
        registerItemBlock(blockWorkbenchGA, "mitega");

        itemRegistryEvent = null;
        Item.itemsList[Blocks.blockColorfulSingleSlabGroup1.blockID] = (new ItemSlab(Blocks.blockColorfulSingleSlabGroup1, Blocks.blockColorfulDoubleSlabGroup1, false)).setUnlocalizedName("colorfulSlab");
        Item.itemsList[Blocks.blockColorfulDoubleSlabGroup1.blockID] = (new ItemSlab(Blocks.blockColorfulSingleSlabGroup1, Blocks.blockColorfulDoubleSlabGroup1, true)).setUnlocalizedName("colorfulSlab");
        Item.itemsList[Blocks.blockColorfulSingleSlabGroup2.blockID] = (new ItemSlab(Blocks.blockColorfulSingleSlabGroup2, Blocks.blockColorfulDoubleSlabGroup2, false)).setUnlocalizedName("colorfulSlab");
        Item.itemsList[Blocks.blockColorfulDoubleSlabGroup2.blockID] = (new ItemSlab(Blocks.blockColorfulSingleSlabGroup2, Blocks.blockColorfulDoubleSlabGroup2, true)).setUnlocalizedName("colorfulSlab");
    }

    public static void registerRecipes(CraftingRecipeRegisterEvent register) {
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful0, 9), true, new ItemStack(blockStairsColorful15, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful1, 9), true, new ItemStack(blockStairsColorful0, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful2, 9), true, new ItemStack(blockStairsColorful1, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful3, 9), true, new ItemStack(blockStairsColorful2, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful4, 9), true, new ItemStack(blockStairsColorful3, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful5, 9), true, new ItemStack(blockStairsColorful4, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful6, 9), true, new ItemStack(blockStairsColorful5, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful7, 9), true, new ItemStack(blockStairsColorful6, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful8, 9), true, new ItemStack(blockStairsColorful7, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful9, 9), true, new ItemStack(blockStairsColorful8, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful10, 9), true, new ItemStack(blockStairsColorful9, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful11, 9), true, new ItemStack(blockStairsColorful10, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful12, 9), true, new ItemStack(blockStairsColorful11, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful13, 9), true, new ItemStack(blockStairsColorful12, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful14, 9), true, new ItemStack(blockStairsColorful13, 9));
        register.registerShapelessRecipe(new ItemStack(blockStairsColorful15, 9), true, new ItemStack(blockStairsColorful14, 9));
        for (int i = 0; i < 15; i++) {
            register.registerShapelessRecipe(new ItemStack(BlockGotcha, 1, i + 1), true, new ItemStack(BlockGotcha, 1, i));
            register.registerShapelessRecipe(new ItemStack(blockColorful, 9, i + 1), true, new ItemStack(blockColorful, 9, i));
            register.registerShapelessRecipe(new ItemStack(blockColorfulBrick, 9, i + 1), true, new ItemStack(blockColorfulBrick, 9, i));
        }
        register.registerShapelessRecipe(new ItemStack(BlockGotcha, 1, 0), true, new ItemStack(BlockGotcha, 1, 15));
        register.registerShapelessRecipe(new ItemStack(blockColorful, 9, 0), true, new ItemStack(blockColorful, 9, 15));
        register.registerShapelessRecipe(new ItemStack(blockColorfulBrick, 9, 0), true, new ItemStack(blockColorfulBrick, 9, 15));
        blockWorkbenchGA.registerSimpleRecipe(register);
    }
}
