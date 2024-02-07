package jp.artan.teleporters.forge;

import dev.architectury.platform.forge.EventBuses;
import jp.artan.artansprojectcoremod.forge.providers.ModBuilder;
import jp.artan.artansprojectcoremod.setup.SetupHandler;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.forge.providers.ModBlockModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SimpleTeleportersReloaded.MOD_ID)
public class SimpleTeleportersReloadedForge {
    public SimpleTeleportersReloadedForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(SimpleTeleportersReloaded.MOD_ID, eventBus);
        SimpleTeleportersReloaded.init();
        ModBuilder.register(eventBus, SimpleTeleportersReloaded.REGISTRATE);
        eventBus.addListener(SimpleTeleportersReloadedForge::registerProviders);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::onClientSetup);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        SetupHandler.commonSetup(SimpleTeleportersReloaded.REGISTRATE);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        SimpleTeleportersReloaded.initClient();
    }

    private static void registerProviders(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Model
        generator.addProvider(event.includeClient(), new ModBlockModelProvider(generator, SimpleTeleportersReloaded.MOD_ID, existingFileHelper));
    }
}