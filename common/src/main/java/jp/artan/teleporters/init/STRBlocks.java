package jp.artan.teleporters.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.block.TeleporterBlock;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class STRBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(SimpleTeleportersReloaded.MOD_ID, Registry.BLOCK_REGISTRY);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SimpleTeleportersReloaded.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
    }
    public static final Supplier<TeleporterBlock> TELEPORTER_BLOCK = register("teleporter", () -> new TeleporterBlock(Block.Properties.of(Material.STONE).lightLevel((bs) -> 1).explosionResistance(1).randomTicks()));

    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> block) {
        RegistrySupplier<T> registeredBlock = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties().tab(STRCreativeTab.SIMPLE_TELEPORTERS_RELOADED)));
        return registeredBlock;
    }
}
