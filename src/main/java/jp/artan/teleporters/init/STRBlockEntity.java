package jp.artan.teleporters.init;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.client.render.TeleporterRenderer;
import jp.artan.teleporters.entity.BlockEntityTeleporter;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class STRBlockEntity {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(SimpleTeleportersReloaded.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static void register() {
        BLOCK_ENTITIES.register();
    }
    public static final RegistrySupplier<BlockEntityType<BlockEntityTeleporter>> ENTITY_TELEPORTER = BLOCK_ENTITIES.register("teleporter",
            () -> BlockEntityType.Builder.of(BlockEntityTeleporter::new, STRBlocks.TELEPORTER_BLOCK.get()).build(null));

    public static void initClient() {
        BlockEntityRendererRegistry.register(ENTITY_TELEPORTER.get(), TeleporterRenderer::new);

    }
}
