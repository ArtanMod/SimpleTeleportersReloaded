package jp.artan.teleporters.init;

import jp.artan.artansprojectcoremod.utils.inject.NonNullSupplier;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.SimpleTeleportersReloadedRegistrate;
import net.minecraft.world.item.CreativeModeTab;

public class ItemGroupInit {
    private static final SimpleTeleportersReloadedRegistrate REGISTRATE = SimpleTeleportersReloaded.registrate();

    public static final NonNullSupplier<CreativeModeTab> DEEP_MOB_LEARNING_RELOADED = REGISTRATE.creativeModeTab("simple_teleporters_reloaded", () -> BlockInit.TELEPORTER_BLOCK.get().asItem())
            .lang("SimpleTeleporters: Reloaded")
            .register();

    public static void register() {
    }
}
