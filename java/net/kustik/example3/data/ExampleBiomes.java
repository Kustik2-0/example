package net.kustik.example3.data;

import net.kustik.example3.Example3;
import net.kustik.example3.world.Example3PlacedFeatures;
import net.kustik.example3.world.gen.feature.Example3Feature;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.biome.OverworldBiomeCreator.getSkyColor;

public class ExampleBiomes {

    @Nullable
    private static final MusicSound DEFAULT_MUSIC = null;

    public static Biome createTheVoid(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {
        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);
        lookupBackedBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, Example3PlacedFeatures.HOME_ISLAND);
        return createBiome(false, 0.5F, 0.5F, new SpawnSettings.Builder(), lookupBackedBuilder, DEFAULT_MUSIC);
    }

    private static Biome createBiome(
            boolean precipitation,
            float temperature,
            float downfall,
            SpawnSettings.Builder spawnSettings,
            GenerationSettings.LookupBackedBuilder generationSettings,
            @Nullable MusicSound music
    ) {
        return createBiome(precipitation, temperature, downfall, 4159204, 329011, null, null, spawnSettings, generationSettings, music);
    }

    private static Biome createBiome(
            boolean precipitation,
            float temperature,
            float downfall,
            int waterColor,
            int waterFogColor,
            @Nullable Integer grassColor,
            @Nullable Integer foliageColor,
            SpawnSettings.Builder spawnSettings,
            GenerationSettings.LookupBackedBuilder generationSettings,
            @Nullable MusicSound music
    ) {
        BiomeEffects.Builder builder = new BiomeEffects.Builder()
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .fogColor(12638463)
                .skyColor(getSkyColor(temperature))
                .moodSound(BiomeMoodSound.CAVE)
                .music(music);
        if (grassColor != null) {
            builder.grassColor(grassColor);
        }

        if (foliageColor != null) {
            builder.foliageColor(foliageColor);
        }

        return new Biome.Builder()
                .precipitation(precipitation)
                .temperature(temperature)
                .downfall(downfall)
                .effects(builder.build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    public static final RegistryKey<Biome> MY_VOID = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(Example3.MOD_ID, "my_void"));

    public static void bootstrap(Registerable<Biome> biomeRegisterable){
        RegistryEntryLookup<PlacedFeature> registryEntryLookup = biomeRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> registryEntryLookup2 = biomeRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        biomeRegisterable.register(MY_VOID, createTheVoid(registryEntryLookup, registryEntryLookup2));
    }
}
