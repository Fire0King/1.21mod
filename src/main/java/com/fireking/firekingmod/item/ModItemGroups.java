package com.fireking.firekingmod.item;

import com.fireking.firekingmod.FireKingMod;
import com.fireking.firekingmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
//    public static final RegistryKey<ItemGroup> FIREKINGMOD_GROUP = register("firekingmod_group");
//
//    private static RegistryKey<ItemGroup> register(String id) {
//        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(FireKingMod.MOD_ID, id));
//    }
//
//    public static void registerModItemGroups() {
//        Registry.register(Registries.ITEM_GROUP, FIREKINGMOD_GROUP,
//                ItemGroup.create(ItemGroup.Row.TOP, 7)
//                        .displayName(Text.translatable("itemGroup.firekingmod_group"))
//                        .icon(() -> new ItemStack(ModItems.ICE_ETHER))
//                        .entries(((displayContext, entries) -> {
//                            entries.add(ModItems.ICE_ETHER);
//                        })).build());
//        FireKingMod.LOGGER.info("Registering FireKing Mod Item Groups");
//    }
    public static final ItemGroup FIREKINGMOD_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(FireKingMod.MOD_ID, "firekingmod_group"),
        ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.firekingmod_group"))
                .icon(() -> new ItemStack(ModItems.ICE_ETHER))
                .entries((displayContext, entries) -> {
                    //Items
                    entries.add(ModItems.ICE_ETHER);
                    entries.add(ModItems.FIRE_ETHER);
                    entries.add(ModItems.ONII_ITEM);
                    entries.add(ModItems.Prospector);

                    entries.add(ModItems.OIL_BUCKET);

                    entries.add(ModItems.STRAWBERRY);
                    entries.add(ModItems.CHEESE);
                    entries.add(ModItems.SUPER_CHEESE);
                    entries.add(ModItems.CORN);

                    entries.add(ModItems.STRAWBERRY_SEEDS);
                    entries.add(ModItems.CORN_SEEDS);

                    entries.add(ModItems.FIRE_ETHER_HOE);
                    entries.add(ModItems.FIRE_ETHER_AXE);
                    entries.add(ModItems.FIRE_ETHER_PICKAXE);
                    entries.add(ModItems.FIRE_ETHER_SHOVEL);
                    entries.add(ModItems.FIRE_ETHER_SWORD);

                    entries.add(ModItems.FIRE_ETHER_HELMET);
                    entries.add(ModItems.FIRE_ETHER_CHESTPLATE);
                    entries.add(ModItems.FIRE_ETHER_LEGGINGS);
                    entries.add(ModItems.FIRE_ETHER_BOOTS);

                    entries.add(ModItems.FIRE_ETHER_HORSE_ARMOR);

                    entries.add(ModItems.HAT);

                    entries.add(ModItems.TEST_MUSIC_DISC);
                    entries.add(ModItems.SENRENBANKA_MUSIC_DISC);
                    //Blocks
                    entries.add(ModBlocks.ICE_ETHER_BLOCK);
                    entries.add(ModBlocks.ICE_ETHER_ORE);
                    entries.add(ModBlocks.ICE_ETHER_BUTTON);
                    entries.add(ModBlocks.ICE_ETHER_DOOR);
                    entries.add(ModBlocks.ICE_ETHER_FENCE);
                    entries.add(ModBlocks.ICE_ETHER_FENCE_GATE);
                    entries.add(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
                    entries.add(ModBlocks.ICE_ETHER_SLAB);
                    entries.add(ModBlocks.ICE_ETHER_STAIRS);
                    entries.add(ModBlocks.ICE_ETHER_TRAPDOOR);
                    entries.add(ModBlocks.ICE_ETHER_WALL);
                }).build());
    public static void registerModItemGroups(){
        FireKingMod.LOGGER.info("Registering FireKing Mod Item Groups");
    }
}
