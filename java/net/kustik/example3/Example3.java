package net.kustik.example3;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kustik.example3.block.Example3Blocks;
import net.kustik.example3.block.Example3FlammableBlock;
import net.kustik.example3.block.Example3StrippableBlock;
import net.kustik.example3.entity.Example3Entities;
import net.kustik.example3.entity.custom.TigerEntity;
import net.kustik.example3.item.Example3Items;
import net.kustik.example3.world.ModWorldSpawn;
import net.kustik.example3.world.gen.Example3WorldGeneration;

import java.util.logging.Logger;

public class Example3 implements ModInitializer {

    public static final String MOD_ID = "example3";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        Example3Items.registerExampleItems();
        Example3Blocks.registerExampleBlocks();
        Example3FlammableBlock.registerFlammableBlocks();
        Example3StrippableBlock.registerStrippableBlock();

        Example3WorldGeneration.generateExampleWorldGen();

        FabricDefaultAttributeRegistry.register(Example3Entities.TIGER, TigerEntity.setAttributes());

        //ModWorldSpawn.init();
    }
}
