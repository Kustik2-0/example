package net.kustik.example3.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kustik.example3.block.Example3Blocks;
import net.kustik.example3.item.Example3Items;
import net.minecraft.data.client.*;

public class ExampleModelProvider extends FabricModelProvider {
    public ExampleModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(Example3Blocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(Example3Blocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Example3Blocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(Example3Blocks.TIN_BLOCK);
        blockStateModelGenerator.registerLog(Example3Blocks.BERGAMOT_LOG)
                .log(Example3Blocks.BERGAMOT_LOG).wood(Example3Blocks.BERGAMOT_WOOD);
        blockStateModelGenerator.registerLog(Example3Blocks.STRIPPED_BERGAMOT_LOG)
                .log(Example3Blocks.STRIPPED_BERGAMOT_LOG).wood(Example3Blocks.STRIPPED_BERGAMOT_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(Example3Blocks.BERGAMOT_PLANKS);
        blockStateModelGenerator.registerSingleton(Example3Blocks.BERGAMOT_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(Example3Blocks.BERGAMOT_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerParentedItemModel(Example3Items.TIGER_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Example3Items.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(Example3Items.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(Example3Items.TIN_INGOT, Models.GENERATED);
    }
}
