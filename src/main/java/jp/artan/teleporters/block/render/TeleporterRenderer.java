package jp.artan.teleporters.block.render;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.teleporters.block.TeleporterBlock;
import jp.artan.teleporters.block.entity.BlockEntityTeleporter;
import jp.artan.teleporters.config.SimpleTeleportersReloadedConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;

import java.util.Random;

public class TeleporterRenderer implements BlockEntityRenderer<BlockEntityTeleporter> {
    public TeleporterRenderer(BlockEntityRendererProvider.Context pContext) {
    }

    @Override
    public void render(BlockEntityTeleporter pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        Integer p = pBlockEntity.getBlockState().getValue(TeleporterBlock.ON);
        if(p == 1) {
            BlockPos pos = pBlockEntity.getBlockPos();
            Random rand = Minecraft.getInstance().level.random;
            for(int i = 0; i < SimpleTeleportersReloadedConfig.CONFIG_PARTICLE_AMT_BLOCK.get(); i++) {
                Minecraft.getInstance().level.addParticle(ParticleTypes.PORTAL,
                        pos.getX() + 0.2F + (rand.nextFloat() / 2),
                        pos.getY() + 0.4F,
                        pos.getZ() + 0.2F + (rand.nextFloat() / 2),
                        0, rand.nextFloat(), 0);
            }
        }
    }
}
