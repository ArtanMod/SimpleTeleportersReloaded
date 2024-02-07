package jp.artan.teleporters;

import jp.artan.artansprojectcoremod.setup.SetupHandler;
import net.minecraft.resources.ResourceLocation;

public class SimpleTeleportersReloaded {
    public static final String MOD_ID = "teleporters";
    public static final SimpleTeleportersReloadedRegistrate REGISTRATE = new SimpleTeleportersReloadedRegistrate(MOD_ID);

    public static void init() {
        REGISTRATE.register();

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
