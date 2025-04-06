package jp.artan.teleporters.config;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = SimpleTeleportersReloaded.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SimpleTeleportersReloadedConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.IntValue CONFIG_PARTICLE_AMT_BLOCK = BUILDER
            .comment("The amount of portal particles that will come out of the teleporter every display tick.")
            .defineInRange("particleAmtBlock", 5, 0, Integer.MAX_VALUE);
    private static final ModConfigSpec.BooleanValue CONFIG_USE_DIRECTION = BUILDER
            .comment("After teleporting, the player will face the direction they were facing when linking the crystal.")
            .define("Teleportation", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static int particleAmtBlock;
    public static boolean teleportation;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        particleAmtBlock = CONFIG_PARTICLE_AMT_BLOCK.get();
        teleportation = CONFIG_USE_DIRECTION.get();
    }
}
