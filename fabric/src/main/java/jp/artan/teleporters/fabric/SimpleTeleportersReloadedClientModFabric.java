package jp.artan.teleporters.fabric;

import jp.artan.artansprojectcoremod.fabric.setup.FabricSetupHandler;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SimpleTeleportersReloadedClientModFabric implements ClientModInitializer {
    public void onInitializeClient() {
        FabricSetupHandler.clientSetup(SimpleTeleportersReloaded.REGISTRATE);
    }
}
