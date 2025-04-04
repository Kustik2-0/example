package net.kustik.example3.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kustik.example3.Example3;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Example3ItemGroup {

    public static ItemGroup registerItemGroup(String name, Item icon){
        return FabricItemGroup.builder(new Identifier(Example3.MOD_ID, name))
                .displayName(Text.translatable("itemgroup." + name))
                .icon(() -> new ItemStack(icon))
                .build();
    }

    public static final ItemGroup EXAMPLE = registerItemGroup("example", Items.DIAMOND);

    public static void addToGroups(Item item, ItemGroup... groups){
        for (ItemGroup group:groups){
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        }
    }
}
