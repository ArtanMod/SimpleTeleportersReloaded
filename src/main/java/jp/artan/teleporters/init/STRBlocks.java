package jp.artan.teleporters.init;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.block.TeleporterBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class STRBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SimpleTeleportersReloaded.MOD_ID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleTeleportersReloaded.MOD_ID);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
    public static final Supplier<TeleporterBlock> TELEPORTER_BLOCK = register("teleporter", id -> new TeleporterBlock(Block.Properties.ofFullCopy(Blocks.STONE).setId(id).lightLevel((bs) -> 1).explosionResistance(1).randomTicks()));

    private static <T extends Block> DeferredBlock<T> register(String name, Function<ResourceKey<Block>, T> block) {
        ResourceKey<Block> id = ResourceKey.create(Registries.BLOCK, SimpleTeleportersReloaded.getResource(name));
        DeferredBlock<T> registeredBlock = BLOCKS.register(name, () -> block.apply(id));
        ITEMS.registerSimpleBlockItem(registeredBlock);
        return registeredBlock;
    }
}
