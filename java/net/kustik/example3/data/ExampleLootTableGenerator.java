package net.kustik.example3.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kustik.example3.block.Example3Blocks;
import net.kustik.example3.item.Example3Items;

public class ExampleLootTableGenerator extends FabricBlockLootTableProvider {
    protected ExampleLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(Example3Blocks.RAW_TIN_BLOCK);
        addDrop(Example3Blocks.TIN_BLOCK);

        addDrop(Example3Blocks.TIN_ORE, oreDrops(Example3Blocks.TIN_ORE, Example3Items.RAW_TIN));
        addDrop(Example3Blocks.DEEPSLATE_TIN_ORE, oreDrops(Example3Blocks.DEEPSLATE_TIN_ORE, Example3Items.RAW_TIN));
    }
}
