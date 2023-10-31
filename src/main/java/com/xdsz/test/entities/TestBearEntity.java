package com.xdsz.test.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.world.World;

public class TestBearEntity extends PolarBearEntity {
    public TestBearEntity(EntityType<? extends PolarBearEntity> type, World world) {super(type, world);}

    public static AttributeModifierMap.MutableAttribute testBearAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30.00)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }
}
