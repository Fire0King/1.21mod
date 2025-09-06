package com.fireking.firekingmod.mixin;

import com.fireking.firekingmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RenderLayers.class)
public class RenderLayersMixin {
    //实现透明图层后方方块渲染的Mixin，FabricAPI是提供相同功能方法的，详见FireKingModClient类中被注释的代码，此二者会冲突
    @Shadow @Final private static Map<Block, RenderLayer> BLOCKS;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void onBlockInit(CallbackInfo ci) {
        BLOCKS.put(ModBlocks.ICE_ETHER_DOOR, RenderLayer.getCutout());
        BLOCKS.put(ModBlocks.ICE_ETHER_TRAPDOOR, RenderLayer.getCutout());
        BLOCKS.put(ModBlocks.STRAWBERRY_CROP, RenderLayer.getCutout());
        BLOCKS.put(ModBlocks.CORN_CROP, RenderLayer.getCutout());
        BLOCKS.put(ModBlocks.BOX, RenderLayer.getCutout());
    }
}
