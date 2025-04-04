package net.kustik.example3.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kustik.example3.Example3;
import net.kustik.example3.entity.Example3Entities;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Example3Items {

    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new FabricItemSettings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg", new SpawnEggItem(Example3Entities.TIGER, 0xD57E36, 0x1D0D00, new FabricItemSettings()));

    private static Item registerItem (String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Example3.MOD_ID, name), item);
    }

    public static void registerExampleItems(){
        Example3.LOGGER.info("Registering Mod Items for " + Example3.MOD_ID);
        Example3ItemGroup.addToGroups(RAW_TIN, Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(TIN_NUGGET, Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(TIN_INGOT, Example3ItemGroup.EXAMPLE);
        Example3ItemGroup.addToGroups(TIGER_SPAWN_EGG, Example3ItemGroup.EXAMPLE);
    }
}
