package com.fireking.firekingmod.datagen;

import com.fireking.firekingmod.FireKingMod;
import com.fireking.firekingmod.block.ModBlocks;
import com.fireking.firekingmod.item.ModItems;
import com.fireking.firekingmod.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    //熔炼配方的List，右边为被熔炼物
    private static final List<ItemConvertible> ICE_ETHER = List.of(ModBlocks.ICE_ETHER_ORE, Items.ICE);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //1分9,9合1的可逆的配方（如铁与铁块）
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ICE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_BLOCK);

        //熔炉
        offerSmelting(exporter, ICE_ETHER, RecipeCategory.MISC, ModItems.ICE_ETHER,
                0.5f, 200, "ice_ether");
        //高炉
        offerBlasting(exporter, ICE_ETHER, RecipeCategory.MISC, ModItems.ICE_ETHER,
                0.5f, 100, "ice_ether");
        //营火(前为被熔炼物，后为产物)
        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                600, Items.ROTTEN_FLESH, Items.LEATHER, 0.35f);

        //有序合成
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 3)//合成获得的物品与数量
                .pattern("###")
//                .input('#', Ingredient.ofItems(Items.BEETROOT))
                .input('#', ModItemTags.SUGAR_TAG)
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.BEETROOT))//与进度相关的配方解锁
                .offerTo(exporter, Identifier.of(FireKingMod.MOD_ID, "beetroot_to_sugar"));//后面的字符串为文件名
        //无序合成
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_ORE)
                .input(ModItems.ICE_ETHER)
                .input(Items.STONE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STONE))
                .offerTo(exporter, Identifier.of(FireKingMod.MOD_ID, "ice_ether_ore"));
    }
}
