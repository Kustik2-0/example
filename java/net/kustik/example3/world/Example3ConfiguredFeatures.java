package net.kustik.example3.world;

import net.kustik.example3.Example3;
import net.kustik.example3.block.Example3Blocks;
import net.kustik.example3.world.gen.feature.Example3Feature;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class Example3ConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BERGAMOT_TREE = registryKey("bergamot_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_GEN = registryKey("tin_ore_gen");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HOME_ISLAND = registryKey("home_island");

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Example3.MOD_ID, name));
    }

    private static void register
            (Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
             Feature<DefaultFeatureConfig> feature){
        register(context, key, feature, FeatureConfig.DEFAULT);
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register
            (Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
             F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stonereplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslatereplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overWorldTinOres = List.of
                (OreFeatureConfig.createTarget (stonereplacables, Example3Blocks.TIN_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslatereplacables, Example3Blocks.DEEPSLATE_TIN_ORE.getDefaultState()));

        register(context, BERGAMOT_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Example3Blocks.BERGAMOT_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(Example3Blocks.BERGAMOT_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, TIN_ORE_GEN, Feature.ORE, new OreFeatureConfig(overWorldTinOres, 8));
        register(context, HOME_ISLAND, Example3Feature.HOME_ISLAND);
    }
}
