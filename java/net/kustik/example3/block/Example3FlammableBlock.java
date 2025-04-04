package net.kustik.example3.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class Example3FlammableBlock {
    public static void registerFlammableBlocks(){
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(Example3Blocks.BERGAMOT_LOG, 5, 5);
        registry.add(Example3Blocks.BERGAMOT_WOOD, 5, 5);
        registry.add(Example3Blocks.STRIPPED_BERGAMOT_LOG, 5, 5);
        registry.add(Example3Blocks.STRIPPED_BERGAMOT_WOOD, 5, 5);
        registry.add(Example3Blocks.BERGAMOT_PLANKS, 5, 20);
        registry.add(Example3Blocks.BERGAMOT_LEAVES, 30, 60);
    }
}
