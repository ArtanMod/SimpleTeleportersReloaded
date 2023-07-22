package jp.artan.teleporters;

import com.mojang.logging.LogUtils;
import jp.artan.repack.registrate.util.nullness.NonNullSupplier;
import jp.artan.teleporters.data.SimpleTeleportersReloadedRegistrate;
import jp.artan.teleporters.init.BlockInit;
import jp.artan.teleporters.init.ItemGroupInit;
import jp.artan.teleporters.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SimpleTeleportersReloaded.MOD_ID)
public class SimpleTeleportersReloaded {
    public static final String MOD_ID = "teleporters";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final NonNullSupplier<SimpleTeleportersReloadedRegistrate> REGISTRATE = SimpleTeleportersReloadedRegistrate.lazy(MOD_ID);

    public SimpleTeleportersReloaded() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerProviders);

        ItemGroupInit.register();
        ItemInit.register();
        BlockInit.register();
    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static SimpleTeleportersReloadedRegistrate registrate() {
        return REGISTRATE.get();
    }


    public void commonSetup(FMLCommonSetupEvent evt) {
    }

    void registerProviders(GatherDataEvent event) {
    }
}
