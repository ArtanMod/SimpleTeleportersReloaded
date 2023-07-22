package jp.artan.teleporters.block.entity;

import jp.artan.teleporters.init.BlockEntityInit;
import jp.artan.teleporters.item.TeleportCrystal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Clearable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityTeleporter extends BlockEntity implements Clearable {
    private ItemStack item = ItemStack.EMPTY;

    public BlockEntityTeleporter(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityInit.ENTITY_TELEPORTER.get(), pPos, pBlockState);
    }

    @Override
    public void clearContent() {
        this.item = ItemStack.EMPTY;
    }

    public void setTeleportCrystal(TeleportCrystal item) {
        this.item = item.getDefaultInstance();
    }
}
