package com.fireking.firekingmod;

import com.fireking.firekingmod.block.ModBlocks;
import com.fireking.firekingmod.block.ModFluids;
import com.fireking.firekingmod.block.entity.ModBlockEntities;
import com.fireking.firekingmod.item.ModItemGroups;
import com.fireking.firekingmod.item.ModItems;
import com.fireking.firekingmod.mixin.GrassColorsMixin;
import com.fireking.firekingmod.sound.ModSoundEvents;
import com.fireking.firekingmod.tags.ModBlockTags;
import com.fireking.firekingmod.util.ModCustomTrades;
import com.fireking.firekingmod.util.ModLootTableModifiers;
import com.fireking.firekingmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireKingMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "firekingmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//调用方法
		//注册物品
		ModItems.registerModItems();
		//注册创造模式物品栏
		ModItemGroups.registerModItemGroups();
		//注册方块
		ModBlocks.registerModBlocks();
		//注册方块Tags
		ModBlockTags.registerModBlockTags();
		//注册LootTable
		ModLootTableModifiers.modifyLootTable();
		//注册交易列表
		ModCustomTrades.registerModCustomTrades();
		//注册模组村民
		ModVillagers.registerModVillagers();
		//注册声音
		ModSoundEvents.registerModSoundEvents();
		//注册流体
		ModFluids.registerModFluids();
		//注册方块实体
		ModBlockEntities.registerBlockEntities();

		LOGGER.info("Hello Fabric world!");
	}
}