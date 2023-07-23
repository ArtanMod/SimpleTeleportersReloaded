package jp.artan.teleporters.init;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.block.render.TeleporterRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimpleTeleportersReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockRendererInit {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityInit.ENTITY_TELEPORTER.get(), TeleporterRenderer::new);
    }
}
