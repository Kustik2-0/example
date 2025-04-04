package net.kustik.example3.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.kustik.example3.world.Example3PlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class Example3OreGeneration {
    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, Example3PlacedFeatures.TIN_ORE_PLACED);
    }
}
