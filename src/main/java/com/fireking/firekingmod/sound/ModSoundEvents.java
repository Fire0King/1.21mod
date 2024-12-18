package com.fireking.firekingmod.sound;

import com.fireking.firekingmod.FireKingMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent PROSPECTOR_FOUND_ORE = register("prospector_found_ore");
    public static final SoundEvent ONII_CALL = register("onii_call");

    public static final SoundEvent BLOCK_BREAK = register("block_break");
    public static final SoundEvent BLOCK_STEP  = register("block_step");
    public static final SoundEvent BLOCK_PLACE = register("block_place");
    public static final SoundEvent BLOCK_HIT = register("block_hit");
    public static final SoundEvent BLOCK_FALL = register("block_fall");

    //方块声音事件组
    public static final BlockSoundGroup BLOCK_SOUND_GROUP = new BlockSoundGroup(1.0F, 1.0F,
            BLOCK_BREAK, BLOCK_STEP, BLOCK_PLACE, BLOCK_HIT, BLOCK_FALL);

    //唱片
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_TEST = registerReference("music_disc.test");
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_SENRENBANKA = registerReference("music_disc.senrenbanka");

    private static SoundEvent register(String name) {
        Identifier id = Identifier.of(FireKingMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    private static RegistryEntry.Reference<SoundEvent> registerReference(String name) {
        Identifier id = Identifier.of(FireKingMod.MOD_ID, name);
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerModSoundEvents() {

    }
}
