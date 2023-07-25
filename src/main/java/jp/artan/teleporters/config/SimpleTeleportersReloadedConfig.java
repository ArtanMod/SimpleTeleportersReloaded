package jp.artan.teleporters.config;

import net.minecraftforge.common.ForgeConfigSpec;


public class SimpleTeleportersReloadedConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.ConfigValue<Integer> CONFIG_PARTICLE_AMT_BLOCK;
    public static ForgeConfigSpec.ConfigValue<Boolean> CONFIG_USE_DIRECTION;

    static {
        BUILDER.push("Simple Teleporters Reloaded Mod");
        CONFIG_PARTICLE_AMT_BLOCK = BUILDER.comment("The amount of portal particles that will come out of the teleporter every display tick.")
                .defineInRange("Block", 5, 0, Integer.MAX_VALUE);
        CONFIG_USE_DIRECTION = BUILDER.comment("After teleporting, the player will face the direction they were facing when linking the crystal")
                .define("Teleportation", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
