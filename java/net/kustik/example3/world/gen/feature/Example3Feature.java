package net.kustik.example3.world.gen.feature;

import net.kustik.example3.Example3;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public abstract class Example3Feature<FC extends FeatureConfig> {

    public static final Feature<DefaultFeatureConfig> HOME_ISLAND =
            register("home_island", new HomeIslandFeature(DefaultFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register (String name, F feature){
        return Registry.register(Registries.FEATURE, new Identifier(Example3.MOD_ID, name), feature);
    }
}
