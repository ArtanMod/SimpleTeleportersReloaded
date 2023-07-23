package jp.artan.teleporters.block;

import jp.artan.teleporters.block.entity.BlockEntityTeleporter;
import jp.artan.teleporters.init.BlockEntityInit;
import jp.artan.teleporters.item.TeleportCrystal;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class TeleporterBlock extends BaseEntityBlock {
    protected static final VoxelShape SHAPE = Block.box(0D, 0.0D, 0D, 16D, 5D, 16D);
    public static final IntegerProperty ON = IntegerProperty.create("on", 0, 1);

    public TeleporterBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ON, 0));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if(blockentity instanceof BlockEntityTeleporter tile) {
            ItemStack stack = pPlayer.getItemInHand(pHand);
            if(tile.hasCrystal()) {
                if(pHand == InteractionHand.MAIN_HAND) {
                    pPlayer.setItemInHand(pHand, tile.getCrystal().copy());
                    pPlayer.playSound(SoundEvents.ARROW_SHOOT, 0.5F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));
                    pLevel.setBlock(pPos, pState.setValue(ON, 0), 2);
                    tile.setCrystal(ItemStack.EMPTY);
                    return InteractionResult.SUCCESS;
                }
            } else {
                if(pHand == InteractionHand.MAIN_HAND && stack.getItem() instanceof TeleportCrystal && stack.getTag() != null) {
                    pPlayer.playSound(SoundEvents.ARROW_SHOOT, 0.5F, 0.4F / (pLevel.random.nextFloat() * 0.4F + 0.8F));
                    pLevel.setBlock(pPos, pState.setValue(ON, 1), 2);
                    tile.setCrystal(stack.copy());
                    stack.shrink(1);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BlockEntityTeleporter tile) {
                Containers.dropContents(pLevel, pPos, tile.getItems());
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ON);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BlockEntityTeleporter(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide) {
            return null;
        }
        return createTickerHelper(pBlockEntityType, BlockEntityInit.ENTITY_TELEPORTER.get(), BlockEntityTeleporter::teleport);
    }
}
