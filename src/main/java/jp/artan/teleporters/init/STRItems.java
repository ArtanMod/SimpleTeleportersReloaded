package jp.artan.teleporters.init;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.item.TeleportCrystal;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class STRItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleTeleportersReloaded.MOD_ID);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static final Supplier<TeleportCrystal> ENDER_CRYSTAL = register("ender_crystal", TeleportCrystal::new, new Item.Properties());

    private static <T extends Item> DeferredItem<T> register(String name, Function<Item.Properties, T> item, Item.Properties properties) {
        return ITEMS.registerItem(name, item, properties);
    }
}
