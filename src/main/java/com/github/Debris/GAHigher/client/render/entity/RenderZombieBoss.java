package com.github.Debris.GAHigher.client.render.entity;

import com.github.Debris.GAHigher.entity.EntityZombieBoss;
import net.minecraft.*;

public class RenderZombieBoss extends RenderZombie {
    public void renderBoss(EntityZombieBoss par1EntityZombie, double par2, double par4, double par6, float par8, float par9) {
        BossStatus.setBossStatus((IBossDisplayData) par1EntityZombie, false);
        func_82426_a((EntityZombie) par1EntityZombie, par2, par4, par6, par8, par9);
        func_110827_b((EntityLiving) par1EntityZombie, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        renderBoss((EntityZombieBoss) par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderBoss((EntityZombieBoss) par1Entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderBoss((EntityZombieBoss) par1EntityLiving, par2, par4, par6, par8, par9);
    }
}
