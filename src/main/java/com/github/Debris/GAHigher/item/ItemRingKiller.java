package com.github.Debris.GAHigher.item;

import net.minecraft.*;

import java.util.List;

public class ItemRingKiller extends Item {
    private final int level;

    public ItemRingKiller(int par1, Material material, int level) {
        super(par1, material, null);
        this.level = level;
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabCombat);
        setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    public boolean isHarmedByLava() {
        return false;
    }

    public String getToolType() {
        return "ringKiller";
    }

    public int getRingKillerSkillCoolDownTime() {
        return (7 - this.level) * 10;
    }

    public float getRingKillerSkillRange() {
        return 3.0F;
    }

    public float getRingKillerSkillDamage() {
        return this.level * 0.5F;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormatting.BROWN + Translator.getFormatted("自动范围群体伤害", new Object[0]));
            info.add(EnumChatFormatting.BLUE + Translator.getFormatted("范围" + getRingKillerSkillRange(), new Object[0]));
            info.add(EnumChatFormatting.RED + Translator.getFormatted("伤害" + getRingKillerSkillDamage(), new Object[0]));
            info.add(EnumChatFormatting.LIGHT_PURPLE + Translator.getFormatted("冷却" + (getRingKillerSkillCoolDownTime() / 20.0F) + 'S', new Object[0]));
        }
    }
}
