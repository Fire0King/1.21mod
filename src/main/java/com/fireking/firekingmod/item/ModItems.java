package com.fireking.firekingmod.item;

import com.fireking.firekingmod.FireKingMod;
import com.fireking.firekingmod.block.ModBlocks;
import com.fireking.firekingmod.block.ModFluids;
import com.fireking.firekingmod.item.custom.HatItem;
import com.fireking.firekingmod.item.custom.ModArmorItem;
import com.fireking.firekingmod.item.custom.ONIIItem;
import com.fireking.firekingmod.item.custom.Prospector;
import com.fireking.firekingmod.sound.ModJukeboxSongs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    //创建物品
    //材料
    public static final Item ICE_ETHER = registerItems("ice_ether", new Item(new Item.Settings()));
    public static final Item FIRE_ETHER = registerItems("fire_ether", new Item(new Item.Settings()));

    //custom
    public static final Item ONII_ITEM = registerItems("onii_item", new ONIIItem(new Item.Settings().maxCount(1), InstrumentTags.GOAT_HORNS));
    public static final Item Prospector = registerItems("prospector", new Prospector(new Item.Settings().maxDamage(127).maxCount(1)));

    //流体桶
    public static final Item OIL_BUCKET = registerItems("oil_bucket",
            new BucketItem(ModFluids.OIL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    //食物
    public static final Item STRAWBERRY = registerItems("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));
    public static final Item CHEESE = registerItems("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item SUPER_CHEESE = registerItems("super_cheese", new Item(new Item.Settings().food(ModFoodComponents.SUPER_CHEESE)));
    public static final Item CORN = registerItems("corn", new Item(new Item.Settings().food(ModFoodComponents.CORN)));

    //种子
    public static final Item STRAWBERRY_SEEDS = registerItems("strawberry_seeds",
            new AliasedBlockItem(ModBlocks.STRAWBERRY_CROP, new Item.Settings()));
    public static final Item CORN_SEEDS = registerItems("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new Item.Settings()));

    //唱片
    public static final Item TEST_MUSIC_DISC = registerItems("test_music_disc",
            new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.TEST)));
    public static final Item SENRENBANKA_MUSIC_DISC = registerItems("senrenbanka_music_disc",
            new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.SENRENBANKA)));

    //武器&工具
    public static final Item FIRE_ETHER_SWORD = registerItems("fire_ether_sword", new SwordItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 3 , -2.0f))));
    public static final Item FIRE_ETHER_SHOVEL = registerItems("fire_ether_shovel", new ShovelItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 1.5f, -3.0f))));
    public static final Item FIRE_ETHER_PICKAXE = registerItems("fire_ether_pickaxe", new PickaxeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 1.5f, -2.8f))));
    public static final Item FIRE_ETHER_AXE = registerItems("fire_ether_axe", new AxeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 6.0f, -3.2f))));
    public static final Item FIRE_ETHER_HOE = registerItems("fire_ether_hoe", new HoeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, -4.0f, 0.0f))));
    //护甲
    //四个其中一个用ModArmorItem实现就行，因为其中将四个护甲都加入了判定
    public static final Item FIRE_ETHER_HELMET = registerItems("fire_ether_helmet", new ModArmorItem(ModArmorMaterials.FIRE_ETHER, ArmorItem.Type.HELMET,
            new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item FIRE_ETHER_CHESTPLATE = registerItems("fire_ether_chestplate", new ArmorItem(ModArmorMaterials.FIRE_ETHER, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item FIRE_ETHER_LEGGINGS = registerItems("fire_ether_leggings", new ArmorItem(ModArmorMaterials.FIRE_ETHER, ArmorItem.Type.LEGGINGS,
            new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item FIRE_ETHER_BOOTS = registerItems("fire_ether_boots", new ArmorItem(ModArmorMaterials.FIRE_ETHER, ArmorItem.Type.BOOTS,
            new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));
    public static final Item HAT = registerItems("hat", new HatItem(HatItem.Type.HAT, new Item.Settings().maxDamage(HatItem.Type.HAT.getMaxDamage(5))));

    //注册物品
    private static Item registerItems(String id, Item item) {
        //非注释行为更简洁的写法（Ctrl+左键点方法可以查看源码）
//        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(FireKingMod.MOD_ID, id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(FireKingMod.MOD_ID, id), item);
    }
    //下方为为原版创造物品栏添加物品的方法
    //创建创造模式的物品栏并将物品加进去
    private static void  addItemToIG(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(ICE_ETHER);
    }
    public static void registerModItems(){
        //使用原版的方法将物品添加进创造模式的原材料物品栏中
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        //打印一行日志
        FireKingMod.LOGGER.info("Registering Items");
    }
}
