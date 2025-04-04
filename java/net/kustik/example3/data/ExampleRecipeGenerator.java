package net.kustik.example3.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kustik.example3.block.Example3Blocks;
import net.kustik.example3.item.Example3Items;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ExampleRecipeGenerator extends FabricRecipeProvider {
    public ExampleRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(Example3Items.RAW_TIN), RecipeCategory.MISC, Example3Items.TIN_INGOT,
                0.7f, 200, "tin_ingot");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Example3Items.RAW_TIN,
                RecipeCategory.BUILDING_BLOCKS, Example3Blocks.RAW_TIN_BLOCK);
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC,
                Example3Items.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, Example3Blocks.TIN_BLOCK,
                "tin_ingot_from_tin_block", "tin_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC,
                Example3Items.TIN_NUGGET, RecipeCategory.MISC, Example3Items.TIN_INGOT,
                "tin_ingot_from_nuggets", "tin_ingot");
    }
}
