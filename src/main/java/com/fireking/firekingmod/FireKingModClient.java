package com.fireking.firekingmod;

import com.fireking.firekingmod.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FireKingModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //通过fabricAPI提供的Mixin来实现方块的透明贴图后方方块渲染
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICE_ETHER_DOOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICE_ETHER_TRAPDOOR, RenderLayer.getCutout());
    }
}
