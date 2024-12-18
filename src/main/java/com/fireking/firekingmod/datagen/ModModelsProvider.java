package com.fireking.firekingmod.datagen;

import com.fireking.firekingmod.block.ModBlockFamilies;
import com.fireking.firekingmod.block.ModBlocks;
import com.fireking.firekingmod.block.custom.CornCropBlock;
import com.fireking.firekingmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    //方块    方块的models会连同方块物品的models一起生成（至少在1.21是这样）
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ModBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels).forEach(
                        blockFamily -> blockStateModelGenerator.registerCubeAllModelTexturePool(blockFamily.getBaseBlock())
                                .family(blockFamily));
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_BLOCK);在BlockFamily中基础方块会生成，所以去掉
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_ORE);

        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP, Properties.AGE_5, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.blockStateCollector.accept(
                        VariantsBlockStateSupplier.create(ModBlocks.CORN_CROP)
                                .coordinate(BlockStateVariantMap.create(CornCropBlock.AGE)
                                                .register(stage -> BlockStateVariant.create()
                                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                                        ModBlocks.CORN_CROP, "_stage" + stage, Models.CROSS, TextureMap::cross))
                                                )
                                )
                );
    }
    //物品
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ICE_ETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONII_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.Prospector, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUPER_CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_SEEDS, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_ETHER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_SWORD, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRE_ETHER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRE_ETHER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRE_ETHER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FIRE_ETHER_BOOTS);

        itemModelGenerator.register(ModItems.TEST_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(ModItems.SENRENBANKA_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
    }
}
