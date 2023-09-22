package jp.artan.teleporters.init;

import jp.artan.artansprojectcoremod.utils.RegistrateDisplayItemsGenerator;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.data.SimpleTeleportersReloadedRegistrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemGroupInit {
    private static final SimpleTeleportersReloadedRegistrate REGISTRATE = SimpleTeleportersReloaded.registrate();
    public static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleTeleportersReloaded.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DEEP_MOB_LEARNING_RELOADED = TAB_REGISTER.register("simple_teleporters_reloaded", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.simple_teleporters_reloaded"))
                    .displayItems(new DisplayItemsGenerator())
                    .icon(() -> new ItemStack(BlockInit.ENDER_CRYSTAL))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .build());

    public static void register() {
        REGISTRATE.addRawLang("itemGroup.simple_teleporters_reloaded", "Simple Teleporters: Reloaded");
    }

    private static class DisplayItemsGenerator extends RegistrateDisplayItemsGenerator<SimpleTeleportersReloadedRegistrate> {

        public DisplayItemsGenerator() {
            super(SimpleTeleportersReloaded::registrate);
        }

        @Override
        protected RegistryObject<CreativeModeTab> getCreativeTab() {
            return DEEP_MOB_LEARNING_RELOADED;
        }
    }
}
