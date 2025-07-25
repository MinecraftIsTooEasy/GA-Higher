package com.github.debris.gah.command;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.ArmorModifierTypes;
import net.xiaoyu233.mitemod.miteite.item.ToolModifierTypes;

import java.util.List;

public class CommandItemLevel extends CommandBase {
    public CommandItemLevel() {
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    public String getCommandName() {
        return "itemLevel";
    }

    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.itemLevel.usage";
    }

    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        if (strings.length != 0 && strings.length < 4) {
            String string = strings[0];
            ItemStack itemStack = getHeldItemStack(iCommandSender);
            NBTTagCompound compound;
            int integer;
            if (string.equals("setLevel") && itemStack.stackTagCompound != null) {
                compound = itemStack.stackTagCompound;
                if (compound.hasKey("tool_level")) {
                    integer = CommandBase.parseInt(iCommandSender, strings[1]);
                    compound.setInteger("tool_level", integer);
                }
            }

            if (string.equals("setXP") && itemStack.stackTagCompound != null) {
                compound = itemStack.stackTagCompound;
                if (compound.hasKey("tool_exp")) {
                    integer = CommandBase.parseInt(iCommandSender, strings[1]);
                    compound.setInteger("tool_exp", integer);
                }
            }

            int posLength;
            NBTTagCompound modifiers;
            String modifierName;
            if (string.equals("addAttrTool") && itemStack.stackTagCompound != null) {
                compound = itemStack.stackTagCompound;
                if (compound.hasKey("modifiers")) {
                    modifierName = strings[1];
                    ToolModifierTypes modifierType = ToolModifierTypes.valueOf(modifierName);
                    posLength = modifierType.getModifierLevel(compound);
                    modifiers = compound.getCompoundTag("modifiers");
                    modifiers.setInteger(modifierType.nbtName, posLength + CommandBase.parseInt(iCommandSender, strings[2]));
                }
            }

            if (string.equals("addAttrArmor") && itemStack.stackTagCompound != null) {
                compound = itemStack.stackTagCompound;
                if (compound.hasKey("modifiers")) {
                    modifierName = strings[1];
                    ArmorModifierTypes modifierType = ArmorModifierTypes.valueOf(modifierName);
                    posLength = modifierType.getModifierLevel(compound);
                    modifiers = compound.getCompoundTag("modifiers");
                    modifiers.setInteger(modifierType.nbtName, posLength + CommandBase.parseInt(iCommandSender, strings[2]));
                }
            }

        } else {
            throw new WrongUsageException(this.getCommandUsage(iCommandSender), new Object[0]);
        }
    }

    private static ItemStack getHeldItemStack(ICommandSender iCommandSender) {
        return CommandBase.getPlayer(iCommandSender, iCommandSender.getCommandSenderName()).getHeldItemStack();
    }

    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        int length = par2ArrayOfStr.length;
        return length == 1 ? CommandBase.getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[]{"setLevel", "setXP", "addAttrTool", "addAttrArmor"}) : null;
    }
}
