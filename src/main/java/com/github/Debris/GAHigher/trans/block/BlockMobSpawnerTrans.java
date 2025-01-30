package com.github.Debris.GAHigher.trans.block;

import com.github.Debris.GAHigher.api.Condition;
import com.github.Debris.GAHigher.api.ConditionalMixin;
import com.github.Debris.GAHigher.compat.ModCompat;
import com.github.Debris.GAHigher.config.Configs;
import com.github.Debris.GAHigher.entity.EntityFinalZombieBoss;
import com.github.Debris.GAHigher.entity.EntityZombieBoss;
import com.github.Debris.GAHigher.item.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@ConditionalMixin(require = @Condition(value = ModCompat.ITE))
@Mixin({BlockMobSpawner.class})
public abstract class BlockMobSpawnerTrans extends BlockContainer {
    protected BlockMobSpawnerTrans(int par1, Material par2Material, BlockConstants block_constants) {
        super(par1, par2Material, block_constants);
    }

    @Inject(method = "dropBlockAsEntityItem", at = @At("RETURN"))
    private void summonBoss(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir) {
        if (info.world.isUnderworld() && info.world.rand.nextFloat() < Configs.wenscConfig.zombieBossSpawnPercent.ConfigValue) {
            EntityZombieBoss entityZombieBoss;
            boolean needsEnhance = ((info.getResponsiblePlayer()).inventory.getInventorySlotContainItem(Items.final_key.itemID, true) != -1);
            if (needsEnhance) {
                entityZombieBoss = new EntityFinalZombieBoss(info.world);
            } else {
                entityZombieBoss = new EntityZombieBoss(info.world);
            }
            entityZombieBoss.setPosition(info.x, info.y, info.z);
            entityZombieBoss.refreshDespawnCounter(-9600);
            if (info.getResponsiblePlayer() != null)
                entityZombieBoss.setAttackTarget((EntityLivingBase) info.getResponsiblePlayer());
            entityZombieBoss.entityFX(EnumEntityFX.summoned);
            entityZombieBoss.onSpawnWithEgg(null);
            info.world.spawnEntityInWorld((Entity) entityZombieBoss);
        }
    }
}
