package com.github.Debris.GAHigher.command;

import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.util.PriceStacks;
import net.minecraft.CommandBase;
import net.minecraft.ICommandSender;
import net.minecraft.ItemStack;

import java.io.File;

public class CommandPrice extends CommandBase {
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandName() {
        return "price";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.price.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        switch (strings.length) {
            case 1 -> {
                String string = strings[0];
                switch (string) {
                    case "sort" -> PriceStacks.sortList();
                    case "save" -> Configs.saveShopConfigFile(new File(Configs.shopConfigFilePath));
                }
            }
            case 2 -> {
                ItemStack itemStack = CommandBase.getPlayer(iCommandSender, iCommandSender.getCommandSenderName()).getHeldItemStack();
                if (itemStack == null) return;
                if (!Configs.canTrade(itemStack.getItem())) return;
                PriceStacks.handlePriceCommand(itemStack, parseDouble(iCommandSender, strings[0]), parseDouble(iCommandSender, strings[1]));
            }
        }
    }
}
