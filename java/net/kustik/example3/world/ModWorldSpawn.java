package net.kustik.example3.world;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.kustik.example3.Example3;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModWorldSpawn {
    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(ModWorldSpawn::onServerStarted);
    }

    private static void onServerStarted(MinecraftServer server) {
        // Проверим, был ли сервер уже запущен, если нет - значит это новый мир
        ServerWorld overworld = server.getWorld(World.OVERWORLD);
        if (overworld != null && overworld.getPlayers().isEmpty()) {
            // Получаем наше кастомное измерение
            RegistryKey<World> customDimensionKey = Example3Biome.HOME_KEY;
                    // RegistryKey.of(RegistryKeys.WORLD, new Identifier(Example3.MOD_ID, "home_type"));
            ServerWorld customWorld = server.getWorld(customDimensionKey);

            if (customWorld != null) {
                // Переносим всех игроков в новое измерение
                for (ServerPlayerEntity player : overworld.getPlayers()) {
                    teleportPlayerToDimension(player, customWorld, new BlockPos(0, 64, 0));
                }
            }
        }
    }

    // Функция для телепортации игрока в указанное измерение
    private static void teleportPlayerToDimension(ServerPlayerEntity player, ServerWorld destination, BlockPos pos) {
        player.teleport(destination, pos.getX(), pos.getY(), pos.getZ(), player.getYaw(), player.getPitch());
    }
}