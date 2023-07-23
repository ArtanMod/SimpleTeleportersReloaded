package jp.artan.teleporters.block.entity;

import jp.artan.teleporters.block.TeleporterBlock;
import jp.artan.teleporters.init.BlockEntityInit;
import jp.artan.teleporters.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BlockEntityTeleporter extends BlockEntity implements Clearable {
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public BlockEntityTeleporter(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityInit.ENTITY_TELEPORTER.get(), pPos, pBlockState);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    public boolean hasCrystal() {
        return this.getCrystal().getItem() == ItemInit.ENDER_CRYSTAL.get();
    }

    public ItemStack getCrystal() {
        return this.items.get(0);
    }

    public void setCrystal(ItemStack stack) {
        this.items.set(0, stack);
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        ContainerHelper.loadAllItems(pTag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items, true);
    }


    public static void teleport(Level pLevel, BlockPos pPos, BlockState pState, BlockEntityTeleporter pBlockEntity) {
        if(pState.getValue(TeleporterBlock.ON) == 0) return;

        List<ServerPlayer> players = ((ServerLevel)pLevel).players();
        for(ServerPlayer player : players) {
            if(!player.isShiftKeyDown()) continue;

            ItemStack itemStack = pBlockEntity.getCrystal();
            if(pBlockEntity != null && !itemStack.isEmpty() && equalBlockPos(player.m_142538_(), pPos)) {
                CompoundTag tag = itemStack.getTag();
                if(tag != null && tag.getString("dim").equals(pLevel.dimension().location().toString())) {
                    player.teleportTo(tag.getInt("x") + 0.5F, tag.getInt("y") + 1, tag.getInt("z") + 0.5F);
                }
            }
        }
    }

    private static boolean equalBlockPos(BlockPos pos1, BlockPos pos2) {
        return pos1.getX() == pos2.getX() && pos1.getY() == pos2.getY() && pos1.getZ() == pos2.getZ();
    }
}
