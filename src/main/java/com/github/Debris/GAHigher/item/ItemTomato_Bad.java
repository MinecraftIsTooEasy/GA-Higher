package com.github.Debris.GAHigher.item;

import com.github.Debris.GAHigher.entity.EntityTomato_Bad;
import net.minecraft.*;

import java.util.List;

public class ItemTomato_Bad extends Item {
    public ItemTomato_Bad(int id) {
        super(id, Material.snow, "tomato_bad");
        setMaxStackSize(64);
        setCraftingDifficultyAsComponent(1.0F);
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        if (player.onServer()) {
            if (!player.inCreativeMode())
                player.convertOneOfHeldItem(null);
            WorldServer world = player.getWorldServer();
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            world.spawnEntityInWorld(new EntityTomato_Bad(world, player, this));
        } else {
            player.bobItem();
        }
        return true;
    }

    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add("§1" + Translator.getFormatted("+3点投掷伤害§r", new Object[0]));
        }
    }
}