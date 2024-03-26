package jp.artan.teleporters.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.item.TeleportCrystal;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class STRItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SimpleTeleportersReloaded.MOD_ID, Registries.ITEM);

    public static void register() {
        ITEMS.register();
    }

    public static final Supplier<TeleportCrystal> ENDER_CRYSTAL = register("ender_crystal", () -> new TeleportCrystal(new Item.Properties()));

    private static <T extends Item> RegistrySupplier<T> register(String name, Supplier<T> item) {
        RegistrySupplier<T> itemRegister = ITEMS.register(name, () -> {
            T itemInstance = item.get();
            CreativeTabRegistry.append(STRCreativeTab.SIMPLE_TELEPORTERS_RELOADED, itemInstance);
            return itemInstance;
        });
        return itemRegister;
    }
}
