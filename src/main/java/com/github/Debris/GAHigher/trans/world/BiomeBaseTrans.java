package com.github.Debris.GAHigher.trans.world;

import com.github.Debris.GAHigher.entity.EntityExchanger;
import com.github.Debris.GAHigher.entity.EntityZombieDoor;
import net.minecraft.BiomeGenBase;
import net.minecraft.SpawnListEntry;
import net.minecraft.WorldGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Random;

@Mixin({BiomeGenBase.class})
public abstract class BiomeBaseTrans {
    @Shadow
    protected List spawnableMonsterList;

    @Inject(method = {"<init>(I)V"}, at = {@At("RETURN")})
    private void injectInit(CallbackInfo callbackInfo) {
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombieDoor.class, 2, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityExchanger.class, 2, 1, 1));
    }

    @Inject(method = "getRandomWorldGenForTrees", at = @At("HEAD"))
    private void addTree(Random par1Random, CallbackInfoReturnable<WorldGenerator> cir) {
    }
}
