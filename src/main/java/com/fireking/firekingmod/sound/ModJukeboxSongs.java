package com.fireking.firekingmod.sound;

import com.fireking.firekingmod.FireKingMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public interface ModJukeboxSongs {
    //只有单声道的音频才会在游戏中有左右声道变换与距离衰减效果

    RegistryKey<JukeboxSong> TEST = of("test");
    RegistryKey<JukeboxSong> SENRENBANKA = of("senrenbanka");

    private static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(FireKingMod.MOD_ID, id));
    }

    private static void register(
            Registerable<JukeboxSong> registry, RegistryKey<JukeboxSong> key, RegistryEntry.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput
    ) {
        registry.register(
                key, new JukeboxSong(soundEvent, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), (float)lengthInSeconds, comparatorOutput)
        );
    }
    static void bootstrap(Registerable<JukeboxSong> registry) {
        register(registry, TEST, ModSoundEvents.MUSIC_DISC_TEST, 210, 15);
        register(registry, SENRENBANKA, ModSoundEvents.MUSIC_DISC_SENRENBANKA, 237, 15);
    }
}
