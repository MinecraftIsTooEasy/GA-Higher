package com.github.Debris.GAHigher.compat;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinConfigPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String s, String s1) {
        if (s1.equals("com.github.Debris.GAHigher.trans.compat.FastVibraniumWorkbenchMixin")) return ModCompat.HAS_ITE;
        if (s.equals("net.minecraft.BlockMobSpawner")) return ModCompat.HAS_ITE;// zombie boss
        if (s.equals("net.minecraft.BlockWeb")) return ModCompat.HAS_ITE;// zombie boss
        if (s1.equals("net.minecraft.InventoryEffectRenderer")) return ModCompat.HAS_EMI;
        return true;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }
}
