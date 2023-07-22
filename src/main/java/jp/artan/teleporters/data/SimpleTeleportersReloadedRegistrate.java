package jp.artan.teleporters.data;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import jp.artan.artansprojectcoremod.ArtanRegistrate;
import jp.artan.repack.registrate.providers.ProviderType;
import jp.artan.repack.registrate.providers.RegistrateProvider;
import jp.artan.repack.registrate.util.nullness.NonNullConsumer;
import jp.artan.repack.registrate.util.nullness.NonNullSupplier;
import jp.artan.repack.registrate.util.nullness.NonnullType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SimpleTeleportersReloadedRegistrate extends ArtanRegistrate<SimpleTeleportersReloadedRegistrate> {
    private final ListMultimap<ProviderType<?>, @NonnullType NonNullConsumer<? extends RegistrateProvider>> datagens = ArrayListMultimap.create();

    protected SimpleTeleportersReloadedRegistrate(String modid) {
        super(modid);
    }

    public static NonNullSupplier<SimpleTeleportersReloadedRegistrate> lazy(String modid) {
        return NonNullSupplier.lazy(
                () -> new SimpleTeleportersReloadedRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get()
                        .getModEventBus()));
    }

    @Override
    protected SimpleTeleportersReloadedRegistrate registerEventListeners(IEventBus bus) {
        return super.registerEventListeners(bus);
    }
}
