package jp.artan.teleporters;

import jp.artan.teleporters.init.STRBlockEntity;
import jp.artan.teleporters.init.STRBlocks;
import jp.artan.teleporters.init.STRCreativeTab;
import jp.artan.teleporters.init.STRItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(SimpleTeleportersReloaded.MOD_ID)
public class SimpleTeleportersReloaded {
    public static final String MOD_ID = "teleporters";

    public SimpleTeleportersReloaded(IEventBus modEventBus, ModContainer modContainer) {
        STRCreativeTab.register(modEventBus);
        STRItems.register(modEventBus);
        STRBlocks.register(modEventBus);
        STRBlockEntity.register(modEventBus);

    }

    public static ResourceLocation getResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
