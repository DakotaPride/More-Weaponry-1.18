package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.util.MoreWeaponryTags;
import net.minecraft.block.BlockState;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class EndConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>>
            PEPLEX_VEGETATION = ConfiguredFeatures.register("peplex_vegetation",
            Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
            DataPool.<BlockState>builder())));

    public static final RegistryEntry<ConfiguredFeature<VegetationPatchFeatureConfig, ?>>
            PEPLEX_PATCH_BONEMEAL = ConfiguredFeatures.register("peplex_patch_bonemeal",
            Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(MoreWeaponryTags.Blocks.PEPLEX_REPLACEABLE,

            BlockStateProvider.of(MoreWeaponryBlocks.PEPLEX_NYLIUM),
            PlacedFeatures.createEntry(PEPLEX_VEGETATION, new PlacementModifier[0]), VerticalSurfaceType.FLOOR,

            ConstantIntProvider.create(1), 0.0F, 5, 0.6F,



            UniformIntProvider.create(1, 2), 0.75F));


}
