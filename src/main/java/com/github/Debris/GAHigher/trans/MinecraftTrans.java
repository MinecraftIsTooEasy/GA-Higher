//package net.xiaoyu233.mitemod.miteite.trans;
//
//import net.minecraft.EnumChatFormatting;
//import net.minecraft.Minecraft;
//import net.minecraft.client.main.Main;
//import com.github.Debris.GAHigher.GAStart;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//
//@Mixin({Minecraft.class})
//public class MinecraftTrans {
//    @Overwrite
//    public static String getVersionDescriptor(boolean include_formatting) {
//        String red = include_formatting ? EnumChatFormatting.RED.toString() : "";
//        return "1.6.4-MITE-GA-Higher-" + GAStart.MOD_VERSION + (Main.is_MITE_DS ? "-DS" : "") + " overwrited by wensc, Debris " + (
//                Minecraft.inDevMode() ? (red + " DEV") : "");
//    }
//}
