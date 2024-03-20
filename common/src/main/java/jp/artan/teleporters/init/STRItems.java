package jp.artan.teleporters.init;

import dev.architectury.registry.registries.DeferredRegister;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.item.TeleportCrystal;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class STRItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SimpleTeleportersReloaded.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        ITEMS.register();
    }

    public static final Supplier<TeleportCrystal> ENDER_CRYSTAL = ITEMS.register("ender_crystal", () -> new TeleportCrystal(new Item.Properties().tab(STRCreativeTab.SIMPLE_TELEPORTERS_RELOADED)));
}
