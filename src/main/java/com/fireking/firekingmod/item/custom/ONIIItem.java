package com.fireking.firekingmod.item.custom;

import com.fireking.firekingmod.FireKingMod;
import com.fireking.firekingmod.sound.ModSoundEvents;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ONIIItem extends Item {
    private final TagKey<Instrument> instrumentTag;

    public ONIIItem(Settings settings, TagKey<Instrument> instrumentTag) {
        super(settings);
        this.instrumentTag = instrumentTag;
    }

    private Optional<RegistryEntry<Instrument>> getInstrument(ItemStack stack) {
        RegistryEntry<Instrument> registryEntry = stack.get(DataComponentTypes.INSTRUMENT);
        if (registryEntry != null) {
            return Optional.of(registryEntry);
        } else {
            Iterator<RegistryEntry<Instrument>> iterator = Registries.INSTRUMENT.iterateEntries(this.instrumentTag).iterator();
            return iterator.hasNext() ? Optional.of((RegistryEntry)iterator.next()) : Optional.empty();
        }
    }
    //物品工具说明
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        MutableText mutableText = Text.translatable(Util.createTranslationKey("114514", Identifier.of(FireKingMod.MOD_ID, "0d00")));
        tooltip.add(mutableText.formatted(Formatting.GOLD));
    }
    //物品右键事件
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        Optional<? extends RegistryEntry<Instrument>> optional = this.getInstrument(itemStack);
        if (optional.isPresent()) {
            Instrument instrument = (Instrument)((RegistryEntry)optional.get()).value();
            user.setCurrentHand(hand);
            playSound(world, user, instrument);
            user.getItemCooldownManager().set(this, instrument.useDuration());
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.consume(itemStack);
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }
    //确认播放的音频与声音大小
    private static void playSound(World world, PlayerEntity player, Instrument instrument) {
        SoundEvent soundEvent = ModSoundEvents.ONII_CALL;
        float f = instrument.range() / 16.0F;
        world.playSoundFromEntity(player, player, soundEvent, SoundCategory.RECORDS, f, 1.0F);
        world.emitGameEvent(GameEvent.INSTRUMENT_PLAY, player.getPos(), GameEvent.Emitter.of(player));
    }
}
