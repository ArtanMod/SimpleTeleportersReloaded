package jp.artan.teleporters.init;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.client.render.TeleporterRenderer;
import jp.artan.teleporters.entity.BlockEntityTeleporter;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleTeleportersReloaded.REGISTRATE.provider.BLOCK_ENTITY_TYPES;
    public static final RegistrySupplier<BlockEntityType<BlockEntityTeleporter>> ENTITY_TELEPORTER = BLOCK_ENTITY_TYPES.register("teleporter",
            () -> BlockEntityType.Builder.of(BlockEntityTeleporter::new, BlockInit.TELEPORTER_BLOCK.get()).build(null));

    public static void register() {

    }

    public static void initClient() {
        BlockEntityRendererRegistry.register(ENTITY_TELEPORTER.get(), TeleporterRenderer::new);

    }
}
