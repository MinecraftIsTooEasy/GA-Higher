package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.item.material.Materials;
import net.minecraft.*;

import java.util.List;

public class ItemGAMisc extends Item {
    String tag = "";

    public ItemGAMisc(int id, String tag) {
        super(id, Materials.invincible, "miscItem");
        this.tag = tag;
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        this.setCraftingDifficultyAsComponent(100.0F);
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    public boolean canCatchFire() {
        return false;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            switch (this.tag) {
                case "pants":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("《海角之恋》", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("胖次东南飞，五里一徘徊", new Object[0]));
                    break;
                case "bad_apple":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("BAD APPLE ! !", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Lotus Land Story", new Object[0]));
                    break;
                case "gowther":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Goat's Sin of Lust", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Gowther", new Object[0]));
                    break;
                case "merlin":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Boar's Sin of Gluttony", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Merlin", new Object[0]));
                    break;
                case "ban":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Fox's Sin of Greed", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Ban", new Object[0]));
                    break;
                case "king":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Grizzly's Sin of Sloth", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("King", new Object[0]));
                    break;
                case "meliodas":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Dragon's Sin of Wrath", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Meliodas", new Object[0]));
                    break;
                case "diane":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Serpent's Sin of Envy", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Diane", new Object[0]));
                    break;
                case "escanor":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Lion's Sin of Pride", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Escanor", new Object[0]));
                    break;
                case "cracked_key":
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("唔哦哦哦哦哦哦！", new Object[0]));
                    info.add(EnumChatFormatting.BROWN + Translator.getFormatted("Niiiiiiiiice!!!", new Object[0]));
                    break;
            }
        }
    }
}
