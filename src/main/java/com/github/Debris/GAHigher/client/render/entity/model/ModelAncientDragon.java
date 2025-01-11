package com.github.Debris.GAHigher.client.render.entity.model;

import net.minecraft.*;

public class ModelAncientDragon extends ModelBase {
    private final ModelRenderer bb_main;

    private final ModelRenderer a;

    private final ModelRenderer bone;

    private final ModelRenderer shengti;

    private final ModelRenderer leftArm;

    private final ModelRenderer bone3;

    private final ModelRenderer bone4;

    private final ModelRenderer rightArm;

    private final ModelRenderer bone2;

    private final ModelRenderer bone5;

    private final ModelRenderer rightLeg;

    private final ModelRenderer bone7;

    private final ModelRenderer bone8;

    private final ModelRenderer leftLeg;

    private final ModelRenderer bone6;

    private final ModelRenderer bone9;

    private final ModelRenderer bozi;

    private final ModelRenderer tou;

    private final ModelRenderer bone11;

    private final ModelRenderer bone12;

    private final ModelRenderer bone14;

    private final ModelRenderer bone13;

    private final ModelRenderer bone15;

    private final ModelRenderer bone16;

    private final ModelRenderer bone17;

    private final ModelRenderer bone18;

    private final ModelRenderer bone19;

    private final ModelRenderer bone20;

    private final ModelRenderer bone34;

    private final ModelRenderer bone35;

    private final ModelRenderer bone36;

    private final ModelRenderer bone10;

    private final ModelRenderer weib;

    private final ModelRenderer bone21;

    private final ModelRenderer bone22;

    private final ModelRenderer youchi;

    private final ModelRenderer bone24;

    private final ModelRenderer bone25;

    private final ModelRenderer bone27;

    private final ModelRenderer bone30;

    private final ModelRenderer bone31;

    private final ModelRenderer zuochi;

    private final ModelRenderer bone23;

    private final ModelRenderer bone26;

    private final ModelRenderer bone28;

    private final ModelRenderer bone29;

    private final ModelRenderer bone32;

    private final ModelRenderer bone33;

    private final ModelRenderer jiao;

    public ModelAncientDragon() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.bb_main = new ModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 25, 0.0F, -16.0F, 5.0F, 1, 1, 1, 0.0F));
        this.a = new ModelRenderer(this);
        this.a.setRotationPoint(0.5F, 15.5F, 1.5F);
        setRotationAngle(this.a, -0.7854F, 0.0F, 0.0F);
        this.a.cubeList.add(new ModelBox(this.a, 42, 43, -4.0F, -3.5F, -0.5F, 8, 4, 5, 0.0F));
        this.bone = new ModelRenderer(this);
        this.bone.setRotationPoint(0.5F, 15.5F, 1.5F);
        setRotationAngle(this.bone, 0.7854F, 0.0F, 0.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 33, -4.0F, -8.5F, -8.5F, 8, 5, 5, 0.0F));
        this.shengti = new ModelRenderer(this);
        this.shengti.setRotationPoint(0.5F, 14.5F, -2.5F);
        this.shengti.cubeList.add(new ModelBox(this.shengti, 0, 0, -3.5F, -2.5F, -7.5F, 7, 5, 15, 0.0F));
        this.shengti.cubeList.add(new ModelBox(this.shengti, 0, 43, -0.5F, -3.5F, -1.5F, 1, 1, 1, 0.0F));
        this.shengti.cubeList.add(new ModelBox(this.shengti, 22, 39, -0.5F, -3.5F, 0.5F, 1, 1, 1, 0.0F));
        this.shengti.cubeList.add(new ModelBox(this.shengti, 28, 35, -0.5F, -10.5F, -6.5F, 1, 1, 1, 0.0F));
        this.shengti.cubeList.add(new ModelBox(this.shengti, 28, 33, -0.5F, -3.5F, 2.5F, 1, 1, 1, 0.0F));
        this.shengti.cubeList.add(new ModelBox(this.shengti, 29, 10, -0.5F, -3.5F, 4.5F, 1, 1, 1, 0.0F));
        this.leftArm = new ModelRenderer(this);
        this.leftArm.setRotationPoint(5.0F, 17.1F, -7.0F);
        setRotationAngle(this.leftArm, -0.7854F, -3.0543F, 0.0F);
        this.leftArm.cubeList.add(new ModelBox(this.leftArm, 58, 8, -1.0087F, -1.2346F, -2.0937F, 3, 5, 3, 0.0F));
        this.bone3 = new ModelRenderer(this);
        this.bone3.setRotationPoint(-0.0349F, 3.9304F, 3.3939F);
        setRotationAngle(this.bone3, 1.5708F, 0.0044F, 0.0F);
        this.leftArm.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 52, 60, -0.4466F, -2.4828F, 0.3011F, 2, 5, 2, 0.0F));
        this.bone4 = new ModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -2.0F, -4.0F);
        setRotationAngle(this.bone4, -0.7854F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 56, 4, -1.0F, -1.0F, 6.0F, 3, 1, 3, 0.0F));
        this.rightArm = new ModelRenderer(this);
        this.rightArm.setRotationPoint(-3.0F, 17.7F, -7.2F);
        setRotationAngle(this.rightArm, -0.7679F, 3.1416F, 0.0F);
        this.rightArm.cubeList.add(new ModelBox(this.rightArm, 16, 57, -1.0F, -1.6458F, -2.3755F, 3, 5, 3, 0.0F));
        this.bone2 = new ModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 3.8597F, 2.8473F);
        setRotationAngle(this.bone2, 1.5359F, 0.0F, 0.0F);
        this.rightArm.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 13, 46, 0.0F, -2.6354F, 0.4733F, 2, 5, 2, 0.0F));
        this.bone5 = new ModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, -2.0F, -4.0F);
        setRotationAngle(this.bone5, -0.7854F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 37, -1.0F, -1.0F, 6.0F, 3, 1, 3, 0.0F));
        this.rightLeg = new ModelRenderer(this);
        this.rightLeg.setRotationPoint(-3.0F, 18.0F, 3.5F);
        setRotationAngle(this.rightLeg, 0.6981F, 0.0F, 0.0F);
        this.rightLeg.cubeList.add(new ModelBox(this.rightLeg, 33, 55, -2.0F, -1.0F, 0.5F, 3, 6, 3, 0.0F));
        this.bone7 = new ModelRenderer(this);
        this.bone7.setRotationPoint(-0.5F, 2.0F, -2.0F);
        setRotationAngle(this.bone7, 0.1745F, 0.0F, 0.0F);
        this.rightLeg.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 47, 4, -1.0F, 2.0F, -1.0F, 2, 2, 5, 0.0F));
        this.bone8 = new ModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 1.5F, -3.5F);
        setRotationAngle(this.bone8, 0.6981F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 11, 57, -1.5F, 1.5F, 0.5F, 3, 2, 1, 0.0F));
        this.leftLeg = new ModelRenderer(this);
        this.leftLeg.setRotationPoint(5.0F, 18.0F, 3.5F);
        setRotationAngle(this.leftLeg, 0.6981F, 0.0F, 0.0F);
        this.leftLeg.cubeList.add(new ModelBox(this.leftLeg, 14, 30, -2.0F, -1.0F, 0.5F, 3, 6, 3, 0.0F));
        this.bone6 = new ModelRenderer(this);
        this.bone6.setRotationPoint(-0.5F, 2.0F, -2.0F);
        setRotationAngle(this.bone6, 0.1745F, 0.0F, 0.0F);
        this.leftLeg.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 26, 46, -1.0F, 2.0F, -1.0F, 2, 2, 5, 0.0F));
        this.bone9 = new ModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 1.5F, -3.5F);
        setRotationAngle(this.bone9, 0.6981F, 0.0F, 0.0F);
        this.bone6.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 14, 39, -1.5F, 1.5F, 0.5F, 3, 2, 1, 0.0F));
        this.bozi = new ModelRenderer(this);
        this.bozi.setRotationPoint(0.5F, 10.0F, -9.5F);
        setRotationAngle(this.bozi, -0.4363F, 0.0F, 0.0F);
        this.bozi.cubeList.add(new ModelBox(this.bozi, 0, 27, -1.5F, -4.0F, 0.5F, 3, 7, 3, 0.0F));
        this.bozi.cubeList.add(new ModelBox(this.bozi, 13, 43, -0.5F, -3.0F, 3.5F, 1, 1, 1, 0.0F));
        this.bozi.cubeList.add(new ModelBox(this.bozi, 6, 43, -0.5F, -1.0F, 3.5F, 1, 1, 1, 0.0F));
        this.tou = new ModelRenderer(this);
        this.tou.setRotationPoint(-0.25F, 3.375F, 4.0F);
        setRotationAngle(this.tou, 0.2618F, 0.0F, 0.0F);
        this.bozi.addChild(this.tou);
        this.tou.cubeList.add(new ModelBox(this.tou, 49, 52, -2.25F, -11.375F, -7.5F, 5, 4, 4, 0.0F));
        this.bone11 = new ModelRenderer(this);
        this.bone11.setRotationPoint(-0.25F, 9.625F, 5.5F);
        this.tou.addChild(this.bone11);
        this.bone12 = new ModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone11.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 29, 12, -4.0F, -21.0F, -12.0F, 9, 1, 1, 0.0F));
        this.bone14 = new ModelRenderer(this);
        this.bone14.setRotationPoint(-3.5F, -21.5F, -12.5F);
        setRotationAngle(this.bone14, -0.6981F, -0.2618F, 0.0F);
        this.bone12.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 58, 16, -0.5F, -0.5F, -1.5F, 1, 1, 3, 0.0F));
        this.bone13 = new ModelRenderer(this);
        this.bone13.setRotationPoint(4.5F, -21.5F, -12.5F);
        setRotationAngle(this.bone13, -0.6981F, 0.2618F, 0.0F);
        this.bone12.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 48, -0.5F, -0.5F, -1.5F, 1, 1, 3, 0.0F));
        this.bone15 = new ModelRenderer(this);
        this.bone15.setRotationPoint(0.5F, -21.5F, -13.0F);
        setRotationAngle(this.bone15, -0.6109F, 0.0F, 0.0F);
        this.bone12.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 44, 14, -0.5F, -0.5F, -3.0F, 1, 1, 4, 0.0F));
        this.bone16 = new ModelRenderer(this);
        this.bone16.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(this.bone16, 0.1745F, 0.0F, 0.0F);
        this.bone15.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 11, 9, -0.5F, -4.0F, -3.0F, 1, 4, 1, 0.0F));
        this.bone17 = new ModelRenderer(this);
        this.bone17.setRotationPoint(-1.5F, -21.5F, -8.0F);
        setRotationAngle(this.bone17, 0.4363F, -0.3491F, 0.0F);
        this.bone12.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 0, 43, -0.5F, -0.5F, -2.0F, 1, 1, 4, 0.0F));
        this.bone18 = new ModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone12.addChild(this.bone18);
        this.bone19 = new ModelRenderer(this);
        this.bone19.setRotationPoint(2.5F, -21.5F, -8.0F);
        setRotationAngle(this.bone19, 0.3491F, 0.3491F, 0.0F);
        this.bone18.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 0, 20, -0.5F, -0.5F, -2.0F, 1, 1, 4, 0.0F));
        this.bone20 = new ModelRenderer(this);
        this.bone20.setRotationPoint(-0.5F, -22.5F, -8.5F);
        setRotationAngle(this.bone20, 0.7854F, 0.0F, 0.0F);
        this.bone12.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 40, 59, 0.5F, -1.5F, -4.5F, 1, 1, 5, 0.0F));
        this.bone34 = new ModelRenderer(this);
        this.bone34.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone11.addChild(this.bone34);
        this.bone35 = new ModelRenderer(this);
        this.bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone34.addChild(this.bone35);
        this.bone35.cubeList.add(new ModelBox(this.bone35, 116, 0, -1.0F, -18.5F, -16.0F, 3, 1, 3, 0.0F));
        this.bone35.cubeList.add(new ModelBox(this.bone35, 0, 0, -1.0F, -19.0F, -15.0F, 1, 1, 1, 0.0F));
        this.bone35.cubeList.add(new ModelBox(this.bone35, 0, 0, 1.0F, -19.0F, -15.0F, 1, 1, 1, 0.0F));
        this.bone35.cubeList.add(new ModelBox(this.bone35, 126, 126, 1.0F, -18.0F, -15.0F, 0, 1, 1, 0.0F));
        this.bone35.cubeList.add(new ModelBox(this.bone35, 123, 126, 0.0F, -18.0F, -15.0F, 0, 1, 1, 0.0F));
        this.bone36 = new ModelRenderer(this);
        this.bone36.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(this.bone36, 0.1745F, 0.0F, 0.0F);
        this.bone34.addChild(this.bone36);
        this.bone36.cubeList.add(new ModelBox(this.bone36, 116, 5, -1.0F, -19.5F, -12.0F, 3, 1, 3, 0.0F));
        this.bone10 = new ModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, -3.5F, 0.0F);
        setRotationAngle(this.bone10, -0.2618F, 0.0F, 0.0F);
        this.bozi.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 55, -1.5F, -1.5F, -3.5F, 3, 3, 5, 0.0F));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 21, 43, -0.5F, -1.5F, 2.5F, 1, 1, 1, 0.0F));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 17, 43, -0.5F, -2.5F, -0.5F, 1, 1, 1, 0.0F));
        this.weib = new ModelRenderer(this);
        this.weib.setRotationPoint(0.5F, 8.0F, 4.5F);
        setRotationAngle(this.weib, -0.6981F, 0.0F, 0.0F);
        this.weib.cubeList.add(new ModelBox(this.weib, 0, 0, -1.5F, -3.0F, 1.5F, 3, 7, 3, 0.0F));
        this.weib.cubeList.add(new ModelBox(this.weib, 4, 25, -0.5F, 2.0F, 0.5F, 1, 1, 1, 0.0F));
        this.weib.cubeList.add(new ModelBox(this.weib, 6, 22, -0.5F, -3.0F, 0.5F, 1, 1, 1, 0.0F));
        this.bone21 = new ModelRenderer(this);
        this.bone21.setRotationPoint(-0.25F, 6.25F, 0.75F);
        setRotationAngle(this.bone21, 0.0873F, 0.0F, 0.0F);
        this.weib.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 46, 12, -0.75F, -10.25F, 2.25F, 2, 3, 8, 0.0F));
        this.bone21.cubeList.add(new ModelBox(this.bone21, 0, 22, -0.25F, -11.25F, 2.75F, 1, 1, 1, 0.0F));
        this.bone21.cubeList.add(new ModelBox(this.bone21, 6, 20, -0.25F, -11.25F, 4.75F, 1, 1, 1, 0.0F));
        this.bone21.cubeList.add(new ModelBox(this.bone21, 0, 20, -0.25F, -11.25F, 6.75F, 1, 1, 1, 0.0F));
        this.bone22 = new ModelRenderer(this);
        this.bone22.setRotationPoint(0.125F, 2.3482F, 7.8071F);
        setRotationAngle(this.bone22, 1.3439F, 0.0F, 0.0F);
        this.bone21.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 49, 27, -0.5F, -2.5643F, 9.9234F, 1, 3, 6, 0.0F));
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 12, -0.5F, -3.5F, 13.5F, 1, 1, 1, 0.0F));
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 10, -0.5F, -3.0F, 15.5F, 1, 1, 1, 0.0F));
        this.bone22.cubeList.add(new ModelBox(this.bone22, 9, 0, -0.5F, -1.0F, 15.75F, 1, 1, 1, 0.0F));
        this.youchi = new ModelRenderer(this);
        this.youchi.setRotationPoint(-6.0F, 12.0F, -6.0F);
        setRotationAngle(this.youchi, 0.0F, -0.8727F, 0.0F);
        this.youchi.cubeList.add(new ModelBox(this.youchi, 46, 23, -6.0F, -1.0F, -2.0F, 11, 2, 2, 0.0F));
        this.bone24 = new ModelRenderer(this);
        this.bone24.setRotationPoint(-7.0F, 0.0F, 5.5F);
        setRotationAngle(this.bone24, 0.0F, -0.2618F, 0.0F);
        this.youchi.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 14, 46, -1.0F, 0.0F, -7.25F, 1, 1, 10, 0.0F));
        this.bone25 = new ModelRenderer(this);
        this.bone25.setRotationPoint(-0.5F, -0.5F, 4.5F);
        setRotationAngle(this.bone25, 0.0F, 1.0472F, 0.0F);
        this.youchi.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 0, 30, 1.5F, 0.0F, -6.5F, 1, 1, 12, 0.0F));
        this.bone27 = new ModelRenderer(this);
        this.bone27.setRotationPoint(-3.5F, 0.0F, 9.5F);
        setRotationAngle(this.bone27, 0.0F, 0.5236F, 0.0F);
        this.youchi.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 34, 0, 2.5F, -0.25F, -9.5F, 1, 1, 11, 0.0F));
        this.bone30 = new ModelRenderer(this);
        this.bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(this.bone30, 0.0F, -0.2618F, 0.0F);
        this.youchi.addChild(this.bone30);
        this.bone30.cubeList.add(new ModelBox(this.bone30, 0, 20, -6.0F, 0.25F, 0.0F, 8, 0, 10, 0.0F));
        this.bone31 = new ModelRenderer(this);
        this.bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.youchi.addChild(this.bone31);
        this.bone31.cubeList.add(new ModelBox(this.bone31, 20, 27, -6.0F, 0.25F, 0.0F, 11, 0, 6, 0.0F));
        this.zuochi = new ModelRenderer(this);
        this.zuochi.setRotationPoint(6.0F, 12.0F, -6.0F);
        setRotationAngle(this.zuochi, 0.0F, 0.7854F, 0.0F);
        this.zuochi.cubeList.add(new ModelBox(this.zuochi, 47, 0, -4.0F, -1.0F, -1.0F, 11, 2, 2, 0.0F));
        this.bone23 = new ModelRenderer(this);
        this.bone23.setRotationPoint(5.0F, 0.0F, 5.5F);
        setRotationAngle(this.bone23, 0.0F, 0.1745F, 0.0F);
        this.zuochi.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 29, 43, 2.0F, 0.0F, -5.5F, 1, 1, 11, 0.0F));
        this.bone26 = new ModelRenderer(this);
        this.bone26.setRotationPoint(-27.5F, 0.0F, 80.0F);
        setRotationAngle(this.bone26, 0.0F, 2.5307F, 0.0F);
        this.bone23.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 14, 33, 23.5F, -0.25F, 74.5F, 1, 1, 12, 0.0F));
        this.bone28 = new ModelRenderer(this);
        this.bone28.setRotationPoint(-14.5F, 0.0F, 5.5F);
        setRotationAngle(this.bone28, 0.0F, -1.0472F, 0.0F);
        this.zuochi.addChild(this.bone28);
        this.bone28.cubeList.add(new ModelBox(this.bone28, 0, 43, 5.5F, -0.5F, -19.5F, 1, 1, 11, 0.0F));
        this.bone29 = new ModelRenderer(this);
        this.bone29.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.zuochi.addChild(this.bone29);
        this.bone32 = new ModelRenderer(this);
        this.bone32.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.zuochi.addChild(this.bone32);
        this.bone32.cubeList.add(new ModelBox(this.bone32, 19, 20, -4.0F, 0.25F, 0.0F, 10, 0, 7, 0.0F));
        this.bone33 = new ModelRenderer(this);
        this.bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(this.bone33, 0.0F, 0.1745F, 0.0F);
        this.zuochi.addChild(this.bone33);
        this.bone33.cubeList.add(new ModelBox(this.bone33, 19, 0, -1.0F, 0.0F, 2.0F, 8, 0, 10, 0.0F));
        this.jiao = new ModelRenderer(this);
        this.jiao.setRotationPoint(0.0F, 24.0F, 0.0F);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.bb_main.render(scale);
        this.a.render(scale);
        this.bone.render(scale);
        this.shengti.render(scale);
        this.leftArm.render(scale);
        this.rightArm.render(scale);
        this.rightLeg.render(scale);
        this.leftLeg.render(scale);
        this.bozi.render(scale);
        this.weib.render(scale);
        this.youchi.render(scale);
        this.zuochi.render(scale);
        this.jiao.render(scale);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float f = 1.0F;
        this.rightLeg.rotateAngleX = MathHelper.truncateDoubleToInt((limbSwing * 0.6662F)) * 1.4F * limbSwingAmount / f + 0.75F;
        this.leftLeg.rotateAngleX = MathHelper.truncateDoubleToInt((limbSwing * 0.6662F + 3.1415927F)) * 1.4F * limbSwingAmount / f + 0.75F;
        this.rightLeg.rotateAngleY = 0.0F;
        this.leftLeg.rotateAngleY = 0.0F;
        this.rightLeg.rotateAngleZ = 0.0F;
        this.leftLeg.rotateAngleZ = 0.0F;
        this.rightArm.rotateAngleX = MathHelper.truncateDoubleToInt((limbSwing * 0.6662F)) * 1.4F * limbSwingAmount / 5.0F - 1.0F;
        this.leftArm.rotateAngleX = MathHelper.truncateDoubleToInt((limbSwing * 0.6662F + 3.1415927F)) * 1.4F * limbSwingAmount / 5.0F - 1.0F;
        this.rightArm.rotateAngleY = -185.5F;
        this.leftArm.rotateAngleY = -185.5F;
        this.rightArm.rotateAngleZ = 0.0F;
        this.leftArm.rotateAngleZ = 0.0F;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}