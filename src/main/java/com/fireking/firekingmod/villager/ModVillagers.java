package com.fireking.firekingmod.villager;

import com.fireking.firekingmod.FireKingMod;
import com.fireking.firekingmod.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;

public class ModVillagers {
    public static final VillagerProfession ICE_ETHER_MASTER = register("ice_ether_master",
            ModPointOfInterestTypes.ICE_ETHER_KEY, SoundEvents.ENTITY_VILLAGER_WORK_ARMORER);
    public static final PointOfInterestType ICE_ETHER_POI = registerPointOfInterestType("ice_ether_poi", ModBlocks.ICE_ETHER_BLOCK);
    private static VillagerProfession register(String id, RegistryKey<PointOfInterestType> heldWorkstation, @Nullable SoundEvent workSound) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(FireKingMod.MOD_ID, id),
                new VillagerProfession(id, entry -> entry.matchesKey(heldWorkstation), entry -> entry.matchesKey(heldWorkstation),
                        ImmutableSet.of(), ImmutableSet.of(), workSound));
    }
    //fabricAPI提供的生物与方块绑定的方法
    private static PointOfInterestType registerPointOfInterestType(String id, Block block) {
        return PointOfInterestHelper.register(Identifier.of(FireKingMod.MOD_ID, id), 1, 1, block);
    }

    public static void registerModVillagers() {}
}
