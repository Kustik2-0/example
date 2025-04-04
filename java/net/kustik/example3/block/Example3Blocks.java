package net.kustik.example3.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kustik.example3.Example3;
import net.kustik.example3.item.Example3ItemGroup;
import net.kustik.example3.world.tree.BergamotSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class Example3Blocks {

    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).requiresTool()
                    .strength(4.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(3.0f, 3.0f), UniformIntProvider.create(0, 2)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(TIN_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool()
                    .strength(5.0f, 6.0f)));

    public static final Block BERGAMOT_LOG = registerBlock("bergamot_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block BERGAMOT_WOOD = registerBlock("bergamot_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_BERGAMOT_LOG = registerBlock("stripped_bergamot_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_BERGAMOT_WOOD = registerBlock("stripped_bergamot_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block BERGAMOT_PLANKS = registerBlock("bergamot_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block BERGAMOT_LEAVES = registerBlock("bergamot_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

    public static final Block BERGAMOT_SAPLING = registerBlock("bergamot_sapling",
            new SaplingBlock(new BergamotSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, new Identifier(Example3.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Example3.MOD_ID, name), block);
    }

    public static void registerExampleBlocks(){
        Example3.LOGGER.info("Registering Mod Blocks for " + Example3.MOD_ID);
        Example3ItemGroup.addToGroups(TIN_BLOCK.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(TIN_ORE.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(DEEPSLATE_TIN_ORE.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(RAW_TIN_BLOCK.asItem(), Example3ItemGroup.EXAMPLE);

        Example3ItemGroup.addToGroups(BERGAMOT_LOG.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(BERGAMOT_WOOD.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(STRIPPED_BERGAMOT_LOG.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(STRIPPED_BERGAMOT_WOOD.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(BERGAMOT_PLANKS.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(BERGAMOT_LEAVES.asItem(), Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(BERGAMOT_SAPLING.asItem(), Example3ItemGroup.EXAMPLE);
    }
}
