package advsolar.client.renderers.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelMolecularTransformer extends ModelBase {
    ModelRenderer coreBottom;
    ModelRenderer coreWorkZone;
    ModelRenderer coreTopElectr;
    ModelRenderer coreTopPlate;
    ModelRenderer firstElTop;
    ModelRenderer firstElBottom;
    ModelRenderer firstElPart1;
    ModelRenderer firstElPart2;
    ModelRenderer firstElPart3;
    ModelRenderer firstElPart4;
    ModelRenderer firstElPart5;
    ModelRenderer firstElPart6;
    ModelRenderer firstElPart7;
    ModelRenderer secondElTop;
    ModelRenderer secondElBottom;
    ModelRenderer secondElPart1;
    ModelRenderer secondElPart2;
    ModelRenderer secondElPart3;
    ModelRenderer secondElPart4;
    ModelRenderer secondElPart5;
    ModelRenderer secondElPart6;
    ModelRenderer secondElPart7;
    ModelRenderer thirdElTop;
    ModelRenderer thirdElBottom;
    ModelRenderer thirdElPart1;
    ModelRenderer thirdElPart2;
    ModelRenderer thirdElPart3;
    ModelRenderer thirdElPart4;
    ModelRenderer thirdElPart5;
    ModelRenderer thirdElPart6;
    ModelRenderer thirdElPart7;

    public ModelMolecularTransformer() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.coreBottom = new ModelRenderer(this, 0, 0);
        this.coreBottom.addBox(-5.0F, 4.0F, -5.0F, 10, 3, 10);
        this.coreBottom.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.coreBottom.setTextureSize(128, 64);
        this.coreBottom.mirror = true;
        this.setRotation(this.coreBottom, 0.0F, 0.0F, 0.0F);
        this.coreWorkZone = new ModelRenderer(this, 0, 44);
        this.coreWorkZone.addBox(-3.0F, -4.0F, -3.0F, 6, 9, 6);
        this.coreWorkZone.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.coreWorkZone.setTextureSize(128, 64);
        this.coreWorkZone.mirror = true;
        this.setRotation(this.coreWorkZone, 0.0F, 0.0F, 0.0F);
        this.coreTopElectr = new ModelRenderer(this, 25, 44);
        this.coreTopElectr.addBox(-2.0F, -8.0F, -1.466667F, 3, 2, 3);
        this.coreTopElectr.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.coreTopElectr.setTextureSize(128, 64);
        this.coreTopElectr.mirror = true;
        this.setRotation(this.coreTopElectr, 0.0F, 0.0F, 0.0F);
        this.coreTopPlate = new ModelRenderer(this, 0, 30);
        this.coreTopPlate.addBox(-5.0F, -7.0F, -4.5F, 9, 3, 9);
        this.coreTopPlate.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.coreTopPlate.setTextureSize(128, 64);
        this.coreTopPlate.mirror = true;
        this.setRotation(this.coreTopPlate, 0.0F, 0.0F, 0.0F);
        this.firstElTop = new ModelRenderer(this, 20, 16);
        this.firstElTop.addBox(3.0F, -8.0F, -5.0F, 4, 3, 10);
        this.firstElTop.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElTop.setTextureSize(128, 64);
        this.firstElTop.mirror = true;
        this.setRotation(this.firstElTop, 0.0F, 0.0F, 0.0F);
        this.firstElBottom = new ModelRenderer(this, 49, 16);
        this.firstElBottom.addBox(4.0F, 3.0F, -3.0F, 3, 5, 6);
        this.firstElBottom.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElBottom.setTextureSize(128, 64);
        this.firstElBottom.mirror = true;
        this.setRotation(this.firstElBottom, 0.0F, 0.0F, 0.0F);
        this.firstElPart1 = new ModelRenderer(this, 0, 18);
        this.firstElPart1.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.firstElPart1.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElPart1.setTextureSize(128, 64);
        this.firstElPart1.mirror = true;
        this.setRotation(this.firstElPart1, 0.0F, 3.141593F, -0.6108652F);
        this.firstElPart2 = new ModelRenderer(this, 13, 18);
        this.firstElPart2.addBox(-8.0F, -2.0F, -1.0F, 1, 4, 2);
        this.firstElPart2.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElPart2.setTextureSize(128, 64);
        this.firstElPart2.mirror = true;
        this.setRotation(this.firstElPart2, 0.0F, 3.141593F, -0.3665191F);
        this.firstElPart3 = new ModelRenderer(this, 0, 18);
        this.firstElPart3.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.firstElPart3.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElPart3.setTextureSize(128, 64);
        this.firstElPart3.mirror = true;
        this.setRotation(this.firstElPart3, 0.0F, 3.141593F, -0.296706F);
        this.firstElPart4 = new ModelRenderer(this, 0, 18);
        this.firstElPart4.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.firstElPart4.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElPart4.setTextureSize(128, 64);
        this.firstElPart4.mirror = true;
        this.setRotation(this.firstElPart4, 0.0F, 3.141593F, 0.0F);
        this.firstElPart5 = new ModelRenderer(this, 0, 18);
        this.firstElPart5.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.firstElPart5.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElPart5.setTextureSize(128, 64);
        this.firstElPart5.mirror = true;
        this.setRotation(this.firstElPart5, 0.0F, 3.141593F, 0.296706F);
        this.firstElPart6 = new ModelRenderer(this, 0, 18);
        this.firstElPart6.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.firstElPart6.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElPart6.setTextureSize(128, 64);
        this.firstElPart6.mirror = true;
        this.setRotation(this.firstElPart6, 0.0F, 3.141593F, 0.6108652F);
        this.firstElPart7 = new ModelRenderer(this, 13, 18);
        this.firstElPart7.addBox(-8.0F, -2.0F, -1.0F, 1, 4, 2);
        this.firstElPart7.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.firstElPart7.setTextureSize(128, 64);
        this.firstElPart7.mirror = true;
        this.setRotation(this.firstElPart7, 0.0F, 3.141593F, 0.3665191F);
        this.secondElTop = new ModelRenderer(this, 20, 16);
        this.secondElTop.addBox(3.0F, -8.0F, -5.0F, 4, 3, 10);
        this.secondElTop.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElTop.setTextureSize(128, 64);
        this.secondElTop.mirror = true;
        this.setRotation(this.secondElTop, 0.0F, -2.094395F, 0.0F);
        this.secondElBottom = new ModelRenderer(this, 49, 16);
        this.secondElBottom.addBox(4.0F, 3.0F, -3.0F, 3, 5, 6);
        this.secondElBottom.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElBottom.setTextureSize(128, 64);
        this.secondElBottom.mirror = true;
        this.setRotation(this.secondElBottom, 0.0F, -2.094395F, 0.0F);
        this.secondElPart1 = new ModelRenderer(this, 0, 18);
        this.secondElPart1.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.secondElPart1.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElPart1.setTextureSize(128, 64);
        this.secondElPart1.mirror = true;
        this.setRotation(this.secondElPart1, 0.0F, 1.047198F, -0.6108652F);
        this.secondElPart2 = new ModelRenderer(this, 13, 18);
        this.secondElPart2.addBox(-8.0F, -2.0F, -1.0F, 1, 4, 2);
        this.secondElPart2.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElPart2.setTextureSize(128, 64);
        this.secondElPart2.mirror = true;
        this.setRotation(this.secondElPart2, 0.0F, 1.047198F, -0.3665191F);
        this.secondElPart3 = new ModelRenderer(this, 0, 18);
        this.secondElPart3.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.secondElPart3.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElPart3.setTextureSize(128, 64);
        this.secondElPart3.mirror = true;
        this.setRotation(this.secondElPart3, 0.0F, 1.047198F, -0.296706F);
        this.secondElPart4 = new ModelRenderer(this, 0, 18);
        this.secondElPart4.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.secondElPart4.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElPart4.setTextureSize(128, 64);
        this.secondElPart4.mirror = true;
        this.setRotation(this.secondElPart4, 0.0F, 1.047198F, 0.0F);
        this.secondElPart5 = new ModelRenderer(this, 0, 18);
        this.secondElPart5.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.secondElPart5.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElPart5.setTextureSize(128, 64);
        this.secondElPart5.mirror = true;
        this.setRotation(this.secondElPart5, 0.0F, 1.047198F, 0.296706F);
        this.secondElPart6 = new ModelRenderer(this, 0, 18);
        this.secondElPart6.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.secondElPart6.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElPart6.setTextureSize(128, 64);
        this.secondElPart6.mirror = true;
        this.setRotation(this.secondElPart6, 0.0F, 1.047198F, 0.6108652F);
        this.secondElPart7 = new ModelRenderer(this, 13, 18);
        this.secondElPart7.addBox(-8.0F, -2.0F, -1.0F, 1, 4, 2);
        this.secondElPart7.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.secondElPart7.setTextureSize(128, 64);
        this.secondElPart7.mirror = true;
        this.setRotation(this.secondElPart7, 0.0F, 1.047198F, 0.3665191F);
        this.thirdElTop = new ModelRenderer(this, 20, 16);
        this.thirdElTop.addBox(3.0F, -8.0F, -5.0F, 4, 3, 10);
        this.thirdElTop.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElTop.setTextureSize(128, 64);
        this.thirdElTop.mirror = true;
        this.setRotation(this.thirdElTop, 0.0F, 2.094395F, 0.0F);
        this.thirdElBottom = new ModelRenderer(this, 49, 16);
        this.thirdElBottom.addBox(4.0F, 3.0F, -3.0F, 3, 5, 6);
        this.thirdElBottom.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElBottom.setTextureSize(128, 64);
        this.thirdElBottom.mirror = true;
        this.setRotation(this.thirdElBottom, 0.0F, 2.094395F, 0.0F);
        this.thirdElPart1 = new ModelRenderer(this, 0, 18);
        this.thirdElPart1.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.thirdElPart1.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElPart1.setTextureSize(128, 64);
        this.thirdElPart1.mirror = true;
        this.setRotation(this.thirdElPart1, 0.0F, -1.047198F, -0.6108652F);
        this.thirdElPart2 = new ModelRenderer(this, 0, 18);
        this.thirdElPart2.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.thirdElPart2.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElPart2.setTextureSize(128, 64);
        this.thirdElPart2.mirror = true;
        this.setRotation(this.thirdElPart2, 0.0F, -1.047198F, -0.296706F);
        this.thirdElPart3 = new ModelRenderer(this, 0, 18);
        this.thirdElPart3.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.thirdElPart3.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElPart3.setTextureSize(128, 64);
        this.thirdElPart3.mirror = true;
        this.setRotation(this.thirdElPart3, 0.0F, -1.047198F, 0.0F);
        this.thirdElPart4 = new ModelRenderer(this, 0, 18);
        this.thirdElPart4.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.thirdElPart4.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElPart4.setTextureSize(128, 64);
        this.thirdElPart4.mirror = true;
        this.setRotation(this.thirdElPart4, 0.0F, -1.047198F, 0.296706F);
        this.thirdElPart5 = new ModelRenderer(this, 0, 18);
        this.thirdElPart5.addBox(-9.0F, -1.0F, -2.0F, 2, 2, 4);
        this.thirdElPart5.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElPart5.setTextureSize(128, 64);
        this.thirdElPart5.mirror = true;
        this.setRotation(this.thirdElPart5, 0.0F, -1.047198F, 0.6108652F);
        this.thirdElPart6 = new ModelRenderer(this, 13, 18);
        this.thirdElPart6.addBox(-8.0F, -2.0F, -1.0F, 1, 4, 2);
        this.thirdElPart6.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElPart6.setTextureSize(128, 64);
        this.thirdElPart6.mirror = true;
        this.setRotation(this.thirdElPart6, 0.0F, -1.047198F, 0.3665191F);
        this.thirdElPart7 = new ModelRenderer(this, 13, 18);
        this.thirdElPart7.addBox(-8.0F, -2.0F, -1.0F, 1, 4, 2);
        this.thirdElPart7.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.thirdElPart7.setTextureSize(128, 64);
        this.thirdElPart7.mirror = true;
        this.setRotation(this.thirdElPart7, 0.0F, -1.047198F, -0.3665191F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.coreBottom.render(f5);
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.coreWorkZone.render(f5);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
        this.coreTopElectr.render(f5);
        this.coreTopPlate.render(f5);
        this.firstElTop.render(f5);
        this.firstElBottom.render(f5);
        this.secondElTop.render(f5);
        this.secondElBottom.render(f5);
        this.thirdElTop.render(f5);
        this.thirdElBottom.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
