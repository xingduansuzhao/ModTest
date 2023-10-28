package com.xdsz.test.items;

import com.xdsz.test.Test;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonApple extends Item {
    public PoisonApple() {
        super(new Item.Properties()
                .group(Test.TAB)
                .food(new Food.Builder()
                        .hunger(10)
                        .saturation(1.2f)
                        .effect(new EffectInstance(Effects.NAUSEA, 300, 1), 1)
                        .effect(new EffectInstance(Effects.POISON, 300, 1), 1)
                        .effect(new EffectInstance(Effects.HUNGER, 300, 1), 0.3f)
                        .meat()
                        .setAlwaysEdible()
                        .build())





        );
    }
}
