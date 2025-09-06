package com.fireking.firekingmod.block.entity;

import com.fireking.firekingmod.FireKingMod;
import com.fireking.firekingmod.block.ModBlocks;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModBlockEntities {
    public static final BlockEntityType<BoxBlockEntity> Box = create("box", BlockEntityType.Builder.create(BoxBlockEntity::new, ModBlocks.BOX));

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return (BlockEntityType) Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FireKingMod.MOD_ID, id), builder.build(type));
    }

    public static void registerBlockEntities() {

    }
}
