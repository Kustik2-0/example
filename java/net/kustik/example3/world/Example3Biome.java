package net.kustik.example3.world;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.kustik.example3.Example3;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Example3Biome {
    public static void generateIsland(ServerWorld world, BlockPos center) {
        // Пример генерации 10 блоков острова
        int radius = 5; // Диаметр острова 10 блоков
        BlockPos.Mutable pos = new BlockPos.Mutable();
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                int distance = x * x + z * z;
                if (distance <= radius * radius) {
                    pos.set(center.getX() + x, center.getY(), center.getZ() + z);
                    world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());

                    // Слои под землей (пример 5 блоков высоты)
                    for (int y = 1; y <= 4; y++) {
                        pos.setY(center.getY() - y);
                        world.setBlockState(pos, Blocks.DIRT.getDefaultState());
                    }
                    pos.setY(center.getY() - 5);
                    world.setBlockState(pos, Blocks.STONE.getDefaultState());
                }
            }
        }

        // Добавим дерево в центр острова
        BlockPos treePos = center.up();
        world.setBlockState(treePos, Blocks.OAK_LOG.getDefaultState());
        world.setBlockState(treePos.up(), Blocks.OAK_LOG.getDefaultState());
        // Добавь листву и ветки
        world.setBlockState(treePos.add(0, 2, 0), Blocks.OAK_LEAVES.getDefaultState());
        // Добавь логику для дерева дальше, если нужно
    }

    public static final RegistryKey<World> HOME_KEY = RegistryKey.of(RegistryKeys.WORLD, new Identifier(Example3.MOD_ID, "home"));

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            ServerWorld world = server.getWorld(HOME_KEY);

            if (world != null) {
                BlockPos center = new BlockPos(0, 64, 0);  // Центр мира
                generateIsland(world, center);
            } else {
                System.out.println("World with HOME_KEY not found!");
            }
        });
    }
}