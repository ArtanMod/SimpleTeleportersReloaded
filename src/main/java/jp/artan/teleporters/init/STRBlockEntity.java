package jp.artan.teleporters.init;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.entity.BlockEntityTeleporter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class STRBlockEntity {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, SimpleTeleportersReloaded.MOD_ID);

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }

    public static final Supplier<BlockEntityType<BlockEntityTeleporter>> ENTITY_TELEPORTER = BLOCK_ENTITIES.register("teleporter",
            () -> new BlockEntityType<>(BlockEntityTeleporter::new, STRBlocks.TELEPORTER_BLOCK.get()));
}
