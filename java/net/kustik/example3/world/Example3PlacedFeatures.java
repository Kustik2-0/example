package net.kustik.example3.world;

import net.kustik.example3.Example3;
import net.kustik.example3.block.Example3Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class Example3PlacedFeatures {
    public static final RegistryKey<PlacedFeature> BERGAMOT_TREE_PLACED = registerKey("bergamot_tree_placed");
    public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED = registerKey("tin_ore_placed");
    //public static final RegistryKey<PlacedFeature> HOME_ISLAND = PlacedFeatures.of("home_island");
    public static final RegistryKey<PlacedFeature> HOME_ISLAND = registerKey("home_island");

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Example3.MOD_ID, name));
    }

    private static void register
            (Registerable<PlacedFeature> context,
             RegistryKey<PlacedFeature> key,
             RegistryEntry<ConfiguredFeature<?, ?>> configuration,
             List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register
            (Registerable<PlacedFeature> context,
             RegistryKey<PlacedFeature> key,
             RegistryEntry<ConfiguredFeature<?, ?>> configuration,
             PlacementModifier... modifiers){
        register(context, key, configuration, List.of(modifiers));
    }

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup
                (RegistryKeys.CONFIGURED_FEATURE);
        register(context, BERGAMOT_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(Example3ConfiguredFeatures.BERGAMOT_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2),
                Example3Blocks.BERGAMOT_SAPLING));
        register(context, TIN_ORE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(Example3ConfiguredFeatures.TIN_ORE_GEN),
                Example3OrePlacement.modifiersWithCount(16, //количество залежей на чанк
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, HOME_ISLAND, configuredFeatureRegistryEntryLookup.getOrThrow(Example3ConfiguredFeatures.HOME_ISLAND),
                //PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP);
                BiomePlacementModifier.of());
    }
}
