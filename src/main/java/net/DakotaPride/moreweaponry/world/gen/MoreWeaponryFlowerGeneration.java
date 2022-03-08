package net.DakotaPride.moreweaponry.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.DakotaPride.moreweaponry.world.features.MoreWeaponryPlacedFeatures;

public class MoreWeaponryFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("PLAINS")),
                GenerationStep.Feature.VEGETAL_DECORATION, MoreWeaponryPlacedFeatures.NIGHT_CURON_KEY);
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("FOREST")),
                GenerationStep.Feature.VEGETAL_DECORATION, MoreWeaponryPlacedFeatures.NIGHT_CURON_KEY);
    }
}