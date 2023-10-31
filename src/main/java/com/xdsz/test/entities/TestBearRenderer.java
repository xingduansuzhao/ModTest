package com.xdsz.test.entities;

import com.xdsz.test.Test;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TestBearRenderer extends MobRenderer<TestBearEntity, TestBearModel<TestBearEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Test.MOD_ID, "textures/entity/test_bear.png");

    public TestBearRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new TestBearModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(TestBearEntity testBearEntity) {
        return TEXTURE;
    }
}
