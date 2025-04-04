package net.kustik.example3.world;

import com.mojang.serialization.Codec;
import net.kustik.example3.Example3;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.FeaturePlacementContext;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;

import java.util.stream.Stream;
/*
public class CustomBiomePlacementModifier extends PlacementModifier {

    private static final Codec<CustomBiomePlacementModifier> CODEC = Codec.unit(CustomBiomePlacementModifier::new);

    @Override
    public Stream<BlockPos> getPositions(FeaturePlacementContext context, Random random, BlockPos pos) {
        Registry<Biome> biomeRegistry = context.getRegistry(RegistryKeys.BIOME);
        Holder<Biome> biome = context.getBiome(pos);
        if (biome.isRegistryKey(RegistryKey.of(RegistryKeys.BIOME, new Identifier(Example3.MOD_ID, "the_void")))){
            return Stream.of(pos);
        }
        return Stream.empty();
    }

    @Override
    public PlacementModifierType<?> getType() {
        return CustomPlacementModifier.CUSTOM_BIOME;
    }
}

 */
