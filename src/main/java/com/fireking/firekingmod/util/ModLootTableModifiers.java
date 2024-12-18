package com.fireking.firekingmod.util;

import com.fireking.firekingmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier STRONGHOLD_LIBRARY =
            Identifier.ofVanilla("chests/stronghold_library");
    private static final Identifier CAT_ID =
            Identifier.ofVanilla("entities/cat");

    public static void modifyLootTable() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (STRONGHOLD_LIBRARY.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.ONII_ITEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));

                tableBuilder.pool(poolBuilder);
            }

            if (CAT_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.SUPER_CHEESE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,5.0f)));

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
