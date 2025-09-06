package com.fireking.firekingmod.block.custom;

import com.fireking.firekingmod.block.entity.BoxBlockEntity;
import com.fireking.firekingmod.block.entity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractChestBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BoxBlock extends AbstractChestBlock<BoxBlockEntity> {
    public static final MapCodec<BoxBlock> CODEC = createCodec(settings -> new BoxBlock(settings, () -> ModBlockEntities.Box));

    public BoxBlock(Settings settings, Supplier<BlockEntityType<? extends BoxBlockEntity>> blockEntityTypeSupplier) {
        super(settings, blockEntityTypeSupplier);
    }

    @Override
    protected MapCodec<? extends AbstractChestBlock<BoxBlockEntity>> getCodec() {
        return CODEC;
    }

    //两个箱子能合成一个大箱子的相关方法
    @Override
    public DoubleBlockProperties.PropertySource<? extends ChestBlockEntity> getBlockEntitySource(BlockState state, World world, BlockPos pos, boolean ignoreBlocked) {
        return null;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BoxBlockEntity(pos, state);
    }

    //渲染方式
    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    //右键响应
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            NamedScreenHandlerFactory factory = this.createScreenHandlerFactory(state, world, pos);
            if (factory != null) {
                player.openHandledScreen(factory);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.CONSUME;
    }
}
