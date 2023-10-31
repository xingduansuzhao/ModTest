package com.xdsz.test.entities;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * TestBearModel - 星断肃昭
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TestBearModel<T extends Entity> extends EntityModel<T> {
    public float[] modelScale = new float[] { 5.0F, 5.0F, 5.0F};
    public ModelRenderer body;
    public ModelRenderer legBackLeft;
    public ModelRenderer legFrontLeft;
    public ModelRenderer legBackRight;
    public ModelRenderer legFrontRight;
    public ModelRenderer head;

    public TestBearModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(-2.0F, -9.8F, 12.0F);
        this.body.setTextureOffset(0, 19).addBox(-5.0F, -13.0F, -7.0F, 14.0F, 14.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.body.setTextureOffset(39, 0).addBox(-4.0F, -25.0F, -7.0F, 12.0F, 12.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.legBackRight = new ModelRenderer(this, 50, 22);
        this.legBackRight.setRotationPoint(-4.5F, -5.3F, 6.0F);
        this.legBackRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.legBackLeft = new ModelRenderer(this, 50, 22);
        this.legBackLeft.setRotationPoint(4.5F, -5.3F, 6.0F);
        this.legBackLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.legFrontRight = new ModelRenderer(this, 50, 40);
        this.legFrontRight.setRotationPoint(-3.5F, -5.3F, -8.0F);
        this.legFrontRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -9.3F, -16.0F);
        this.head.addBox(-3.5F, -3.0F, -3.0F, 7.0F, 7.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.head.setTextureOffset(0, 44).addBox(-2.5F, 1.0F, -6.0F, 5.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.head.setTextureOffset(26, 0).addBox(-4.5F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.head.setTextureOffset(26, 0).addBox(2.5F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.legFrontLeft = new ModelRenderer(this, 50, 40);
        this.legFrontLeft.setRotationPoint(3.5F, -5.3F, -8.0F);
        this.legFrontLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        matrixStackIn.push();
        matrixStackIn.scale(modelScale[0], modelScale[1], modelScale[2]);
        ImmutableList.of(this.body, this.legBackRight, this.legBackLeft, this.legFrontRight, this.head, this.legFrontLeft).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
        matrixStackIn.pop();
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
