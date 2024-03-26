package jp.artan.teleporters.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class STRCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(SimpleTeleportersReloaded.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> SIMPLE_TELEPORTERS_RELOADED = createTab("simple_teleporters_reloaded", () -> new ItemStack(STRBlocks.TELEPORTER_BLOCK.get()));

    public static void register() {
        CREATIVE_MODE_TABS.register();
    }

    private static RegistrySupplier<CreativeModeTab> createTab(String name, Supplier<ItemStack> icon) {
        return CREATIVE_MODE_TABS.register(name, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).icon(icon).title(Component.translatable("itemGroup." + SimpleTeleportersReloaded.MOD_ID + "." + name)).build());
    }
}
