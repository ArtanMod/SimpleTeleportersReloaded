package jp.artan.teleporters;

import jp.artan.artansprojectcoremod.setup.SetupHandler;
import jp.artan.teleporters.config.SimpleTeleportersReloadedConfig;
import jp.artan.teleporters.init.BlockEntityInit;
import jp.artan.teleporters.init.BlockInit;
import jp.artan.teleporters.init.ItemGroupInit;
import jp.artan.teleporters.init.ItemInit;
import net.minecraft.resources.ResourceLocation;

public class SimpleTeleportersReloaded {
    public static final String MOD_ID = "teleporters";
    public static final SimpleTeleportersReloadedRegistrate REGISTRATE = new SimpleTeleportersReloadedRegistrate(MOD_ID);

    public static void init() {
        REGISTRATE.register();
        SimpleTeleportersReloadedConfig.init();

        BlockEntityInit.register();
        ItemGroupInit.register();
        ItemInit.register();
        BlockInit.register();
    }

    public static void initClient() {
        SetupHandler.clientSetup(SimpleTeleportersReloaded.REGISTRATE);
    }

    public static SimpleTeleportersReloadedRegistrate registrate() {
        return REGISTRATE;
    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
