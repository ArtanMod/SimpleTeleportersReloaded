package jp.artan.teleporters.init;

import jp.artan.artansprojectcoremod.tabs.CreativeTab;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.data.SimpleTeleportersReloadedRegistrate;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ItemGroupInit {
    private static final SimpleTeleportersReloadedRegistrate REGISTRATE = SimpleTeleportersReloaded.registrate();

    public static final CreativeTab DEEP_MOB_LEARNING_RELOADED = REGISTRATE.tab("simple_teleporters_reloaded", () -> new ItemStack(BlockInit.ENDER_CRYSTAL.get()))
            .lang("SimpleTeleporters: Reloaded")
            .register();

    public static void register() {
    }
}
