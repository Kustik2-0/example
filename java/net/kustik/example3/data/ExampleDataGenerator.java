package net.kustik.example3.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kustik.example3.world.Example3ConfiguredFeatures;
import net.kustik.example3.world.Example3PlacedFeatures;
import net.kustik.example3.world.gen.ExampleWorldGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ExampleDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ExampleLootTableGenerator::new);
        pack.addProvider(ExampleRecipeGenerator::new);
        pack.addProvider(ExampleModelProvider::new);
        pack.addProvider(ExampleWorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, Example3ConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, Example3PlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ExampleBiomes::bootstrap);
    }
}
