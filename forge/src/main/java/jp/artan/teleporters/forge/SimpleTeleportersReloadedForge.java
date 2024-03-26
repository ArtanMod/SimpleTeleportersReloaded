package jp.artan.teleporters.forge;

import dev.architectury.platform.forge.EventBuses;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.forge.providers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(SimpleTeleportersReloaded.MOD_ID)
public class SimpleTeleportersReloadedForge {
    public SimpleTeleportersReloadedForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(SimpleTeleportersReloaded.MOD_ID, eventBus);
        SimpleTeleportersReloaded.init();
        eventBus.addListener(SimpleTeleportersReloadedForge::registerProviders);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::onClientSetup);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        SimpleTeleportersReloaded.initClient();
    }

    private static void registerProviders(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();

        // Model
        generator.addProvider(event.includeClient(), new ModBlockModelProvider(output, SimpleTeleportersReloaded.MOD_ID, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, SimpleTeleportersReloaded.MOD_ID, existingFileHelper));

        // LootTable
        generator.addProvider(event.includeServer(), new ModLootTableProvider(output, SimpleTeleportersReloaded.MOD_ID));

        // Lang
        generator.addProvider(event.includeClient(), new ModUDLanguageProvider(output, SimpleTeleportersReloaded.MOD_ID));
        generator.addProvider(event.includeClient(), new ModUSLanguageProvider(output, SimpleTeleportersReloaded.MOD_ID));
        generator.addProvider(event.includeClient(), new ModJPLanguageProvider(output, SimpleTeleportersReloaded.MOD_ID));

        // Recipe
        generator.addProvider(event.includeClient(), new ModRecipeProvider(output));
    }
}