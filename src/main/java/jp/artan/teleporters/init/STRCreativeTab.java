package jp.artan.teleporters.init;

import dev.architectury.registry.CreativeTabRegistry;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class STRCreativeTab {
    public static final CreativeModeTab SIMPLE_TELEPORTERS_RELOADED = CreativeTabRegistry.create(SimpleTeleportersReloaded.getResource("simple_teleporters_reloaded"), () -> new ItemStack(STRBlocks.TELEPORTER_BLOCK.get()));

    public static void register() {
    }
}
