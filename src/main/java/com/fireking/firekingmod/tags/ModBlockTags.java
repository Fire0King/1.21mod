package com.fireking.firekingmod.tags;

import com.fireking.firekingmod.FireKingMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> ORE_LIST = of("ore_list");
    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FireKingMod.MOD_ID, id));
    }
    public static void registerModBlockTags() {
        FireKingMod.LOGGER.info("Registering ModBlockTags");
    }
}
