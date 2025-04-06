package jp.artan.teleporters.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import jp.artan.artansprojectcoremod.config.ModConfigs;

public class SimpleTeleportersReloadedConfig extends ModConfigs {

    private static final SimpleTeleportersReloadedConfig configs = new SimpleTeleportersReloadedConfig();

    public static ConfigEntry<Integer> CONFIG_PARTICLE_AMT_BLOCK;
    public static ConfigEntry<Boolean> CONFIG_USE_DIRECTION;

    private SimpleTeleportersReloadedConfig() {
        super("simple-teleporters-reloaded.toml");
    }

    @Override
    protected void read(CommentedFileConfig commentedFileConfig) {
        CONFIG_PARTICLE_AMT_BLOCK = new ConfigEntry<>("particleAmtBlock", 5, commentedFileConfig)
                .comment("The amount of portal particles that will come out of the teleporter every display tick.");
        CONFIG_USE_DIRECTION = new ConfigEntry<>("Teleportation", true, commentedFileConfig)
                .comment("After teleporting, the player will face the direction they were facing when linking the crystal.");
    }

    public static void init() {
        configs.read();
    }
}
