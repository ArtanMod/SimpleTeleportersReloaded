package jp.artan.teleporters.fabric;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import net.fabricmc.api.ModInitializer;

public class SimpleTeleportersReloadedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SimpleTeleportersReloaded.init();
        SimpleTeleportersReloaded.initClient();
    }
}