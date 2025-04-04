package net.kustik.example3.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kustik.example3.block.Example3Blocks;
import net.kustik.example3.entity.Example3Entities;
import net.kustik.example3.entity.client.TigerRenderer;
import net.minecraft.client.render.RenderLayer;

public class Example3Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Example3Blocks.BERGAMOT_SAPLING, RenderLayer.getCutout());

        EntityRendererRegistry.register(Example3Entities.TIGER, TigerRenderer::new);
    }
}
