package net.kustik.example3.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class Example3StrippableBlock {
    public static void registerStrippableBlock(){
        StrippableBlockRegistry.register(Example3Blocks.BERGAMOT_LOG, Example3Blocks.STRIPPED_BERGAMOT_LOG);
        StrippableBlockRegistry.register(Example3Blocks.BERGAMOT_WOOD, Example3Blocks.STRIPPED_BERGAMOT_WOOD);
    }
}
