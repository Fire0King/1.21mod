package com.fireking.firekingmod.item.custom;

import com.fireking.firekingmod.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    //通过List的遍历来实现一个盔甲材料可以提供多种效果
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.FIRE_ETHER.value(),
                            Arrays.asList(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1000, 1, false, false, true),
                                    new StatusEffectInstance(StatusEffects.SPEED, 1000, 1, false, false, true)))
                    .build();

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    //实时判断的方法
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        //判断是否为客户端，实体是否为玩家，玩家是否穿戴全套盔甲
        if (!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player)) {
            evaluateArmorEffects(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    //实现玩家穿戴对应盔甲提供药水效果的方法
    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();

            if (hasCorrectArmorSet(player, material)) {
                for (StatusEffectInstance effect : effects) {
                    addStatusEffectForMaterial(player,effect);
                }

            }
        }
    }
    //为玩家增加药水效果
    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance effect) {
        //判断是否已拥有此效果
        boolean hasEffect = player.hasStatusEffect(effect.getEffectType());

        if (!hasEffect) {
            player.addStatusEffect(new StatusEffectInstance(effect));
        }
    }
    //判断是否为对应材料的盔甲
    private boolean hasCorrectArmorSet(PlayerEntity player, ArmorMaterial material) {
        //确认物品是ArmorItem的实例，由于鞘翅是能穿戴在盔甲上但是不属于ArmorItem类，没有ArmorMaterial属性，若不写此for循环判断会导致穿戴鞘翅造成游戏崩溃
        for (ItemStack stack : player.getInventory().armor) {
            if (!(stack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();

        return helmet.getMaterial().value() == material &&
                chestplate.getMaterial().value() == material &&
                leggings.getMaterial().value() == material &&
                boots.getMaterial().value() == material;
    }
    //判断是否穿戴全套盔甲
    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);//获取玩家物品栏盔甲物品栏堆栈的三号位盔甲信息（头盔）
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }
}
