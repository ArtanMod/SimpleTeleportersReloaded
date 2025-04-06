package jp.artan.teleporters.providers;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = SimpleTeleportersReloaded.MOD_ID)
public class ModDataGenHandler {

    @SubscribeEvent
    public static void registerProviders(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Model
        generator.addProvider(event.includeClient(), new ModBlockModelProvider(generator, SimpleTeleportersReloaded.MOD_ID, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, SimpleTeleportersReloaded.MOD_ID, existingFileHelper));

        // LootTable
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator, SimpleTeleportersReloaded.MOD_ID));

        // Lang
        generator.addProvider(event.includeClient(), new ModUDLanguageProvider(generator, SimpleTeleportersReloaded.MOD_ID));
        generator.addProvider(event.includeClient(), new ModUSLanguageProvider(generator, SimpleTeleportersReloaded.MOD_ID));
        generator.addProvider(event.includeClient(), new ModJPLanguageProvider(generator, SimpleTeleportersReloaded.MOD_ID));

        // Recipe
        generator.addProvider(event.includeClient(), new ModRecipeProvider(generator));
    }
}
