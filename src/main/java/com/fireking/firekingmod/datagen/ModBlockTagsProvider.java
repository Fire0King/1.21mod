package com.fireking.firekingmod.datagen;

import com.fireking.firekingmod.block.ModBlocks;
import com.fireking.firekingmod.tags.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

/**
 * 用于生成对应json文件的类
 */
public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ICE_ETHER_BLOCK)
                .add(ModBlocks.ICE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ICE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ICE_ETHER_ORE);

        getOrCreateTagBuilder(ModBlockTags.ORE_LIST)
                .add(ModBlocks.ICE_ETHER_ORE)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.COPPER_ORES);

        //用于实现栅栏等方块之间的连接
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ICE_ETHER_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ICE_ETHER_FENCE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ICE_ETHER_WALL);

        //用于设置按钮是否能被箭，三叉戟等实体射中后按下（按钮的BlockSetType需以木质为前提）
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.ICE_ETHER_BUTTON);

        //栅栏是否为与木质栅栏连接的Tag,不写则只能与原版的下界砖栅栏相互连接
//        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
//                .add(ModBlocks.ICE_ETHER_FENCE);
    }
}
