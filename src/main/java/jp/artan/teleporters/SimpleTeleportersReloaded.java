package jp.artan.teleporters;

import jp.artan.teleporters.config.SimpleTeleportersReloadedConfig;
import jp.artan.teleporters.init.STRBlockEntity;
import jp.artan.teleporters.init.STRBlocks;
import jp.artan.teleporters.init.STRCreativeTab;
import jp.artan.teleporters.init.STRItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(SimpleTeleportersReloaded.MOD_ID)
public class SimpleTeleportersReloaded {
    public static final String MOD_ID = "teleporters";

    public SimpleTeleportersReloaded(IEventBus modEventBus, ModContainer modContainer) {
        SimpleTeleportersReloadedConfig.init();

        STRCreativeTab.register();
        STRItems.register();
        STRBlocks.register();
        STRBlockEntity.register();

        modEventBus.addListener(this::onClientSetup);
    }

    public static void onClientSetup(final FMLClientSetupEvent event) {
        STRBlockEntity.initClient();
    }


    public static ResourceLocation getResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
