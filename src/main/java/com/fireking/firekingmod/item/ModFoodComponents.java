package com.fireking.firekingmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6f).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).build();
    public static final FoodComponent SUPER_CHEESE = new FoodComponent.Builder().nutrition(8).saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent CORN = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
}
