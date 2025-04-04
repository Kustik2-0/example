package net.kustik.example3.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.kustik.example3.entity.Example3Entities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class Example3EntityGeneration {
    public static void addSpawns(){
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA), SpawnGroup.CREATURE,
                Example3Entities.TIGER, 35, 1, 2);

        SpawnRestriction.register(Example3Entities.TIGER, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
