package com.fireking.firekingmod.datagen;

import com.fireking.firekingmod.item.ModItems;
import com.fireking.firekingmod.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModItemTags.SUGAR_TAG)
                .add(Items.BEETROOT)
                .add(ModItems.CHEESE);
        //盔甲可以被锻造模板装饰
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                //也可以这样写
//                .add(ModItems.FIRE_ETHER_HELMET, ModItems.FIRE_ETHER_CHESTPLATE, ModItems.FIRE_ETHER_LEGGINGS, ModItems.FIRE_ETHER_BOOTS);
                .add(ModItems.FIRE_ETHER_HELMET)
                .add(ModItems.FIRE_ETHER_CHESTPLATE)
                .add(ModItems.FIRE_ETHER_LEGGINGS)
                .add(ModItems.FIRE_ETHER_BOOTS);
        //小白击杀苦力怕掉落的唱片
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.TEST_MUSIC_DISC)
                .add(ModItems.SENRENBANKA_MUSIC_DISC);
    }
}
