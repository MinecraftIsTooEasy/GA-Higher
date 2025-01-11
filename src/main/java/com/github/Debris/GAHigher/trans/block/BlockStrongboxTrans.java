package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.config.Configs;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mixin({BlockStrongbox.class})
public class BlockStrongboxTrans extends Block {
    protected BlockStrongboxTrans(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Override
    public void onBlockAboutToBeBroken(BlockBreakInfo info) {
        EntityPlayer player = info.getResponsiblePlayer();
        if (player != null && !player.inCreativeMode() && info.world.isWorldServer() && !((TileEntityStrongbox) info.tile_entity).isOwner(player)) {
            String POS = "(" + (int) player.posX + "," + (int) player.posY + "," + (int) player.posZ + ")";
            String World = player.getWorld().getDimensionName();
            info.world.getAsWorldServer().getMinecraftServer().getLogAgent().logWarning("Player " + player.getEntityName() + " tried to break personal chest of " + ((TileEntityStrongbox) info.tile_entity).owner_name);
            info.world.getAsWorldServer().getMinecraftServer().getConfigurationManager().sendChatMsg(ChatMessageComponent.createFromTranslationKey("[Server]:").appendComponent(ChatMessageComponent.createFromTranslationKey(" " + player.getEntityName() + " 破坏了 " + ((TileEntityStrongbox) info.tile_entity).owner_name + " 的金属箱子→" + World + POS).setColor(EnumChatFormatting.DARK_RED)));
            if (Configs.wenscConfig.isOpenStrongBoxBreakRecord.ConfigValue)
                try {
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String day = player.getWorld().getDayOfWorld() + "天 ";
                    File file = new File("StrongBox.txt");
                    FileWriter fileWriter = new FileWriter(file.getName(), true);
                    String separator = System.lineSeparator();
                    fileWriter.write("=====================" + separator);
                    fileWriter.write("时间=" + day + formatter.format(date) + separator);
                    fileWriter.write("坐标=" + World + POS + separator);
                    fileWriter.write("破坏者=" + player.getEntityName() + separator);
                    fileWriter.write("所有者=" + ((TileEntityStrongbox) info.tile_entity).owner_name + separator);
                    fileWriter.close();
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
        }
        super.onBlockAboutToBeBroken(info);
    }
}
