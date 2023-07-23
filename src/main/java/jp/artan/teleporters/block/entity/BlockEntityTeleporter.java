package jp.artan.teleporters.block.entity;

import jp.artan.teleporters.init.BlockEntityInit;
import jp.artan.teleporters.init.ItemInit;
import jp.artan.teleporters.item.TeleportCrystal;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

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
        this.items.clear();
        ContainerHelper.loadAllItems(pTag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items, true);
    }
}
