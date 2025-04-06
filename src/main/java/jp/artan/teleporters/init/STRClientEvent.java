package jp.artan.teleporters.init;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.client.render.TeleporterRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = SimpleTeleportersReloaded.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class STRClientEvent {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(STRBlockEntity.ENTITY_TELEPORTER.get(), TeleporterRenderer::new);
    }
}
