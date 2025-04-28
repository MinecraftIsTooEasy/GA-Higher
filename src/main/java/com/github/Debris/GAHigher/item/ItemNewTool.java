package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.material.Materials;
import net.minecraft.*;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemNewTool extends Item implements IDamageableItem {
    private Material effective_material;

    protected List materials_effective_against;

    protected List blocks_effective_against;

    protected float d;

    public ItemNewTool() {
        this.blocks_effective_against = new ArrayList();
        this.materials_effective_against = new ArrayList();
    }

    public int getExpReqForLevel(int level, boolean isSword) {
        return isSword ? (200 * level) : (100 * level);
    }

//    @Override
//    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
//        if (par2EntityLivingBase.onClient())
//            Minecraft.setErrorMessage("ItemTool.hitEntity: called on client?");
//        return (!(par3EntityLivingBase instanceof EntityPlayer) || !((EntityPlayer) par3EntityLivingBase).bG.d);
//    }

    public EnumItemInUseAction getItemInUseAction(ItemStack par1ItemStack, EntityPlayer player) {
        if (canBlock())
            return EnumItemInUseAction.BLOCK;
        return null;
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        if (canBlock()) {
            player.setHeldItemInUse();
            return true;
        }
        return false;
    }

    public boolean canBlock() {
        return Configs.wenscConfig.BlncanBlock.ConfigValue;
    }

    public int d_(ItemStack par1ItemStack) {
        if (canBlock())
            return 72000;
        return 0;
    }

//    public float getStrVsBlock(Block block, int metadata, ItemStack itemStack, EntityPlayer player) {
//        return super.isEffectiveAgainstBlock(block, metadata) ? getMultipliedHarvestEfficiency(block, itemStack, player) : super
//                .getStrVsBlock(block, metadata);
//    }

    protected static Class[] weapon_classes = new Class[]{ItemSword.class, ItemBattleAxe.class, ItemWarHammer.class, ItemDagger.class, ItemClub.class, ItemPickaxe.class, ItemCudgel.class, ItemKnife.class};

    protected ItemNewTool(int par1, Material material) {
        super(par1, material, null);
        this.materials_effective_against = new ArrayList<>();
        this.blocks_effective_against = new ArrayList<>();
        if (hasWoodenHandle() && !hasMaterial(Material.wood))
            addMaterial(Material.wood);
        this.effective_material = material;
//        setTextureName("tools/" + material.getName() + "_" + getToolType());
        setTextureName("tools/" + material.getCapitalizedName() + "_" + getToolType());
        setMaxStackSize(1);
        setMaxDamage(getMultipliedDurability());
        this.d = getCombinedDamageVsEntity();
        setReachBonus(0.75F);
    }

//    public boolean isMaxToolLevel(ItemStack itemStack) {
//        return (getMaterialHarvestLevel() * 4 <= getToolLevel(itemStack));
//    }

    public final float getBaseDurability() {
        return 4.0F;
    }

    public boolean isWeapon(Item item) {
        return (item instanceof ItemSword || item instanceof ItemBattleAxe || item instanceof ItemWarHammer);
    }

    public final int getMultipliedDurability() {
        return (int) (getBaseDurability() * getNumComponentsForDurability() * this.effective_material.durability * 100.0F);
    }

    public static boolean isWeapon(ItemStack stack) {
        Item item = stack.getItem();
        return (item instanceof ItemSword || item instanceof ItemBattleAxe || item instanceof ItemWarHammer);
    }

    public float getBaseHarvestEfficiency(Block block) {
        return 4.0F;
    }

//    public boolean onBlockDestroyed(BlockBreakInfo info) {
//        if (info.world.isRemote)
//            Minecraft.setErrorMessage("ItemTool.onBlockDestroyed: called on client?");
//        Block block = info.block;
//        ItemStack item_stack = info.getHarvesterItemStack();
//        if (item_stack.g() && !block.isPortable(info.world, info.getHarvester(), info.x, info.y, info.z) &&
//                !info.isResponsiblePlayerInCreativeMode() && info.getBlockHardness() > 0.0F && super.getStrVsBlock(block, info
//                .getMetadata()) > 1.0F) {
//            if (!(item_stack.b() instanceof ItemSword) && super.isEffectiveAgainstBlock(info.block, info.getMetadata()))
//                addExpForTool(info.getHarvesterItemStack(), info.getResponsiblePlayer(), 1);
//            info.getHarvesterItemStack().tryDamageItem(DamageSource.j,
//                    applyCalculateDurabilityModifier(getToolDecayFromBreakingBlock(info), info
//                            .getHarvesterItemStack()), info.getHarvester());
//            return true;
//        }
//        return false;
//    }

    public float getCombinedDamageVsEntity() {
        return getBaseDamageVsEntity() + getMaterialDamageVsEntity();
    }

    public final float getMultipliedHarvestEfficiency(Block block) {
        return getBaseHarvestEfficiency(block) * getMaterialHarvestEfficiency();
    }

    public int getMaterialHarvestLevel() {
        return 0;
    }

//    public float getMeleeDamageBonus(ItemStack stack) {
//        return getCombinedDamageVsEntity() + ToolModifierTypes.DAMAGE_MODIFIER.getModifierValue(stack.e);
//    }
//
//    private int applyCalculateDurabilityModifier(int origin, ItemStack stack) {
//        NBTTagCompound compound = stack.getTagCompound();
//        return (int) (origin * Math.max(0.0F, 1.0F - ToolModifierTypes.DURABILITY_MODIFIER.getModifierValue(compound)));
//    }

    public float getMaterialDamageVsEntity() {
        return this.effective_material.getDamageVsEntity();
    }

//    private float getAttackDamageBounce(ItemStack stack) {
//        return ToolModifierTypes.DAMAGE_MODIFIER.getModifierValue(stack.e);
//    }

    public void addMaterialsEffectiveAgainst(Material[] materials_effective_against) {
        for (int i = 0; i < materials_effective_against.length; i++) {
            if (!this.materials_effective_against.contains(materials_effective_against[i]))
                this.materials_effective_against.add(materials_effective_against[i]);
        }
    }

    public void addBlocksEffectiveAgainst(Block[] blocks_effective_against) {
        for (int i = 0; i < blocks_effective_against.length; i++) {
            if (!this.blocks_effective_against.contains(blocks_effective_against[i]))
                this.blocks_effective_against.add(blocks_effective_against[i]);
        }
    }

    public float getMaterialHarvestEfficiency() {
        if (this.effective_material == Materials.mitega)
            return 4.0F;
        Minecraft.setErrorMessage("getMaterialHarvestEfficiency: tool material not handled");
        return 0.0F;
    }

//    public boolean isEffectiveAgainstBlock(Block block, int metadata) {
//        return ((this.materials_effective_against.contains(block.cU) || this.blocks_effective_against.contains(block)) && getMaterialHarvestLevel() >= block.getMinHarvestLevel(metadata));
//    }

    public final float getStrVsBlock(Block block, int metadata) {
        if (isEffectiveAgainstBlock(block, metadata))
            return getMultipliedHarvestEfficiency(block);
        return super.getStrVsBlock(block, metadata);
    }

    public final int getToolDecayFromBreakingBlock(BlockBreakInfo info) {
        float block_hardness = info.getBlockHardness();
        if (block_hardness == 0.0F)
            return 0;
        float decay = 100.0F * getBaseDecayRateForBreakingBlock(info.block);
        return Math.max(Math.max((int) (block_hardness * decay), (int) (decay / 20.0F)), 1);
    }

    public boolean hasExpAndLevel() {
        return true;
    }

//    public final float getMultipliedHarvestEfficiency(Block block, ItemStack itemStack, EntityPlayer player) {
//        return getBaseHarvestEfficiency(block) * (getMaterialHarvestEfficiency() + ToolModifierTypes.EFFICIENCY_MODIFIER.getModifierValue(itemStack.q()) + ((player.H() || player.isInRain()) ? ToolModifierTypes.AQUADYNAMIC_MODIFIER.getModifierValue(itemStack.q()) : 0.0F));
//    }

    public boolean n_() {
        return true;
    }

//    public String g() {
//        return getToolMaterial().getName();
//    }

    public Material getToolMaterial() {
        return this.effective_material;
    }

    public Material getMaterialForEnchantment() {
        return getToolMaterial();
    }

    public boolean similarToItemsOfSameClass() {
        return true;
    }

    public boolean hasQuality() {
        return true;
    }

    public boolean hasWoodenHandle() {
        return true;
    }

    public Material getMaterialForDurability() {
        return getToolMaterial();
    }

    public final int getRepairCost() {
        return getNumComponentsForDurability() * 2;
    }

    public float getMeleeDamageBonus() {
        return getCombinedDamageVsEntity();
    }

    public abstract float getBaseDamageVsEntity();

    public abstract float getBaseDecayRateForBreakingBlock(Block paramBlock);

    public abstract float getBaseDecayRateForAttackingEntity(ItemStack paramItemStack);

    public abstract String getToolType();
}