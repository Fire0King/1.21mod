package com.fireking.firekingmod.datagen;

import com.fireking.firekingmod.block.ModBlocks;
import com.fireking.firekingmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanProvider extends FabricLanguageProvider {
    public ModZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn",registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        //物品
        translationBuilder.add(ModItems.ICE_ETHER, "冰以太");
        translationBuilder.add(ModItems.FIRE_ETHER, "火以太");
        translationBuilder.add(ModItems.ONII_ITEM, "绫地宁宁起爆器");
        translationBuilder.add(ModItems.Prospector, "探矿器");

        translationBuilder.add(ModItems.OIL_BUCKET, "石油桶");

        translationBuilder.add(ModItems.STRAWBERRY, "草莓");
        translationBuilder.add(ModItems.CHEESE, "奶酪");
        translationBuilder.add(ModItems.SUPER_CHEESE, "神奇奶酪");
        translationBuilder.add(ModItems.CORN, "玉米");

        translationBuilder.add(ModItems.STRAWBERRY_SEEDS, "草莓种子");
        translationBuilder.add(ModItems.CORN_SEEDS, "玉米种子");

        translationBuilder.add(ModItems.TEST_MUSIC_DISC, "测试唱片(影色舞)");
        translationBuilder.add(ModItems.SENRENBANKA_MUSIC_DISC, "以恋结缘");

        translationBuilder.add(ModItems.FIRE_ETHER_AXE, "火以太斧");
        translationBuilder.add(ModItems.FIRE_ETHER_HOE, "火以太锄");
        translationBuilder.add(ModItems.FIRE_ETHER_PICKAXE, "火以太镐");
        translationBuilder.add(ModItems.FIRE_ETHER_SHOVEL, "火以太铲");
        translationBuilder.add(ModItems.FIRE_ETHER_SWORD, "火以太剑");

        translationBuilder.add(ModItems.FIRE_ETHER_HELMET, "火以太头盔");
        translationBuilder.add(ModItems.FIRE_ETHER_CHESTPLATE, "火以太胸甲");
        translationBuilder.add(ModItems.FIRE_ETHER_LEGGINGS, "火以太护腿");
        translationBuilder.add(ModItems.FIRE_ETHER_BOOTS, "火以太靴");

        translationBuilder.add(ModItems.HAT, "帽子");
        //方块
        translationBuilder.add(ModBlocks.ICE_ETHER_BLOCK, "冰以太块");
        translationBuilder.add(ModBlocks.ICE_ETHER_ORE, "冰以太矿石");
        translationBuilder.add(ModBlocks.ICE_ETHER_BUTTON, "冰以太按钮");
        translationBuilder.add(ModBlocks.ICE_ETHER_DOOR, "冰以太门");
        translationBuilder.add(ModBlocks.ICE_ETHER_FENCE, "冰以太栅栏");
        translationBuilder.add(ModBlocks.ICE_ETHER_FENCE_GATE, "冰以太栅栏门");
        translationBuilder.add(ModBlocks.ICE_ETHER_SLAB, "冰以太台阶");
        translationBuilder.add(ModBlocks.ICE_ETHER_STAIRS, "冰以太楼梯");
        translationBuilder.add(ModBlocks.ICE_ETHER_PRESSURE_PLATE, "冰以太压力板");
        translationBuilder.add(ModBlocks.ICE_ETHER_TRAPDOOR, "冰以太活板门");
        translationBuilder.add(ModBlocks.ICE_ETHER_WALL, "冰以太墙");

        //创造物品栏
        translationBuilder.add("itemGroup.firekingmod_group", "Fire_King的模组");
        //物品工具描述
        translationBuilder.add("114514.firekingmod.0d00", "0721");

        translationBuilder.add("item.firekingmod.prospector.shift_tooltip", "右键方块探矿，shift+右键为精准搜索");
        translationBuilder.add("item.firekingmod.prospector.tooltip", "按住\u00A76SHIFT\u00A7r显示更多信息");

        //模组村民
        translationBuilder.add("entity.minecraft.villager.ice_ether_master", "冰以太大师");

        //音效名称
        translationBuilder.add("sounds.firekingmod.prospector_found_ore", "发现矿物");
        translationBuilder.add("sounds.firekingmod.onii_call", "0721");
        translationBuilder.add("sounds.firekingmod.block_break", "破坏方块");
        translationBuilder.add("sounds.firekingmod.block_step", "上方行走");
        translationBuilder.add("sounds.firekingmod.block_place", "放置方块");
        translationBuilder.add("sounds.firekingmod.block_hit", "挖掘方块");
        translationBuilder.add("sounds.firekingmod.block_fall", "掉落方块");

        //唱片播放时下方彩色字幕
        translationBuilder.add("jukebox_song.firekingmod.test", "Test(影色舞)");
        translationBuilder.add("jukebox_song.firekingmod.senrenbanka", "以恋结缘");
    }
}
