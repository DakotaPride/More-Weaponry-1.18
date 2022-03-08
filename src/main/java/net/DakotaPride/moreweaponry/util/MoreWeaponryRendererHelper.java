package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MoreWeaponryRendererHelper {
    public static void setRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.KURO_PLANT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.FRODON_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.FRODON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.NIGHT_CURON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.POTTED_NIGHT_CURON, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.FRODON_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.FRODON_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.POTTED_NIGHT_CURON, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.INTOXICATED_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.INTOXICATED_LARGE_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.INTOXICATED_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.INTOXICATED_TALL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.INTOXICATED_GRASS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.INTOXICATED_POPPY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.INTOXICATED_DANDELION, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponryBlocks.WRETCHED_SKULL, RenderLayer.getCutout());

    }
}