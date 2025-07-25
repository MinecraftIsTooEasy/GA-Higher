package com.github.debris.gah.trans.entity.mob;

import com.github.debris.gah.config.Configs;
import com.github.debris.gah.item.Items;
import com.github.debris.gah.util.Constant;
import com.github.debris.gah.util.RandomUtil;
import net.minecraft.DamageSource;
import net.minecraft.EntityArachnid;
import net.minecraft.EntityMob;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityArachnid.class})
public class EntityArachnidTrans extends EntityMob {
    public EntityArachnidTrans(World par1World) {
        super(par1World);
    }

    @Inject(method = "dropFewItems", at = @At("RETURN"))
    private void addLeg(boolean recently_hit_by_player, DamageSource damage_source, CallbackInfo ci) {
        if (Configs.wenscConfig.isDropSpiderLegs.ConfigValue && Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
            dropItem(Items.Spider_Leg);
        }
        if (recently_hit_by_player) {
            RandomUtil.dropRandomJewelry(this);
        }
    }
}
