package com.fireking.firekingmod.datagen;

import com.fireking.firekingmod.block.ModBlocks;
import com.fireking.firekingmod.block.custom.CornCropBlock;
import com.fireking.firekingmod.block.custom.StrawberryCropBlock;
import com.fireking.firekingmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ICE_ETHER_BLOCK);
        addDrop(ModBlocks.ICE_ETHER_BUTTON);
        addDrop(ModBlocks.ICE_ETHER_DOOR);
        addDrop(ModBlocks.ICE_ETHER_TRAPDOOR);
        addDrop(ModBlocks.ICE_ETHER_FENCE);
        addDrop(ModBlocks.ICE_ETHER_FENCE_GATE);
        addDrop(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
        addDrop(ModBlocks.ICE_ETHER_SLAB);
        addDrop(ModBlocks.ICE_ETHER_STAIRS);
        addDrop(ModBlocks.ICE_ETHER_WALL);

//        addDrop(ModBlocks.ICE_ETHER_ORE, oreDrops(ModBlocks.ICE_ETHER_ORE, ModItems.ICE_ETHER));//一般矿石写法，只掉一个矿物
        addDrop(ModBlocks.ICE_ETHER_ORE, copperOreLikeDrops(ModBlocks.ICE_ETHER_ORE, ModItems.ICE_ETHER));
        //被打掉的时候作物是否成熟的判断
        LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE, 5));
        this.addDrop(ModBlocks.STRAWBERRY_CROP, this.cropDrops(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, builder2));

        LootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CornCropBlock.AGE, 8));
        this.addDrop(ModBlocks.CORN_CROP, this.cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, builder3));
    }

    //矿石掉落方法
    public LootTable.Builder copperOreLikeDrops(Block drop, Item dropItem) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(dropItem)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
