package net.kustik.example3.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.kustik.example3.world.Example3PlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class Example3TreeGeneration {
/*
    public static void generateIsland(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.THE_VOID),
                GenerationStep.Feature.RAW_GENERATION, Example3PlacedFeatures.HOME_ISLAND);
    }

 */
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, Example3PlacedFeatures.BERGAMOT_TREE_PLACED);
    }
}
