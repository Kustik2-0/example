package net.kustik.example3.world.gen;

import net.kustik.example3.Example3;

public class Example3WorldGeneration {
    public static void generateExampleWorldGen(){

        //важно! Ключ UNDERGROUND_ORES, если открыть его создание, находится перед ключом VEGETAL_DECORATION
        //поэтому вызывать их надо в соответствующем порядке
        Example3IslandGeneration.generateIsland();
        Example3OreGeneration.generateOres();
        Example3TreeGeneration.generateTrees();
        Example3EntityGeneration.addSpawns();
    }
}
