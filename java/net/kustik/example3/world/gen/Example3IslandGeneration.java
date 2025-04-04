package net.kustik.example3.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.kustik.example3.data.ExampleBiomes;
import net.kustik.example3.world.Example3PlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class Example3IslandGeneration {

    public static void generateIsland(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ExampleBiomes.MY_VOID),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, Example3PlacedFeatures.HOME_ISLAND);
    }
}
