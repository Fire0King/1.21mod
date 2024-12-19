package com.fireking.firekingmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class CustomFluid extends FlowableFluid {
    @Override
    //判断流体自身是否正确
    public boolean matchesType(Fluid fluid) {
        return fluid == getFlowing() || fluid == getStill();
    }

    @Override
    //能否像无限水一样
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    //流体破坏方块时的掉落物生成
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    //能否被替换
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    //流动速度（水为4）
    protected int getMaxFlowDistance(WorldView world) {
        return 4;
    }

    @Override
    //流动距离等级（水为1，即8格）
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    //更新速度（水为5）
    public int getTickRate(WorldView world) {
        return 5;
    }

    @Override
    //爆炸抗性（流体通常都为100）
    protected float getBlastResistance() {
        return 100.0F;
    }
}
