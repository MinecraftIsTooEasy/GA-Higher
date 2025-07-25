package com.github.debris.gah.command;

import net.minecraft.CommandBase;
import net.minecraft.ICommandSender;
import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;

public class CommandForging extends CommandBase {
    public CommandForging() {
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    public String getCommandName() {
        return "forging";
    }

    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.forging.usage";
    }

    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        ItemStack itemStack = CommandBase.getPlayer(iCommandSender, iCommandSender.getCommandSenderName()).getHeldItemStack();
        if (itemStack.stackTagCompound != null) {
            NBTTagCompound compound = itemStack.stackTagCompound;
            if (compound.hasKey("forging_grade")) {
                compound.setInteger("forging_grade", CommandBase.parseInt(iCommandSender, strings[0]));
            }
        }

    }
}
