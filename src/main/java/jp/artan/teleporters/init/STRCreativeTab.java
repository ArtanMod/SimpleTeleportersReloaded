package jp.artan.teleporters.init;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class STRCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleTeleportersReloaded.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SIMPLE_TELEPORTERS_RELOADED = createTab("simple_teleporters_reloaded", () -> new ItemStack(STRBlocks.TELEPORTER_BLOCK.get()),
            (params, output) -> {
                output.accept(STRItems.ENDER_CRYSTAL.get());
                output.accept(STRBlocks.TELEPORTER_BLOCK.get());
            });

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private static DeferredHolder<CreativeModeTab, CreativeModeTab> createTab(String name, Supplier<ItemStack> icon, CreativeModeTab.DisplayItemsGenerator displayItemsGenerator) {
        return CREATIVE_MODE_TABS.register(name, () -> CreativeModeTab.builder()
                .icon(icon)
                .title(Component.translatable("itemGroup." + SimpleTeleportersReloaded.MOD_ID + "." + name))
                .displayItems(displayItemsGenerator)
                .build()
        );
    }
}
