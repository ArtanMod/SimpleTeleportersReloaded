package jp.artan.teleporters;

import jp.artan.teleporters.config.SimpleTeleportersReloadedConfig;
import jp.artan.teleporters.init.STRBlockEntity;
import jp.artan.teleporters.init.STRBlocks;
import jp.artan.teleporters.init.STRCreativeTab;
import jp.artan.teleporters.init.STRItems;
import net.minecraft.resources.ResourceLocation;

public class SimpleTeleportersReloaded {
    public static final String MOD_ID = "teleporters";

    public static void init() {
        SimpleTeleportersReloadedConfig.init();

        STRCreativeTab.register();
        STRItems.register();
        STRBlocks.register();
        STRBlockEntity.register();
    }

    public static void initClient() {
        STRBlockEntity.initClient();
    }


    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
