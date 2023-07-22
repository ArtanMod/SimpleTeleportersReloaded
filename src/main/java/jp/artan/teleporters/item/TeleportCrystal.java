package jp.artan.teleporters.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeleportCrystal extends Item {
    public TeleportCrystal(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        CompoundTag tags = pStack.getTag();
        if(tags == null) {
            pTooltipComponents.add(new TranslatableComponent("teleporters.ender_crystal.tooltip.unlinked").withStyle(s -> s.withColor(ChatFormatting.RED)));
            pTooltipComponents.add(new TranslatableComponent("teleporters.ender_crystal.tooltip.guid").withStyle(s -> s.withColor(ChatFormatting.BLUE)));
        } else {
            pTooltipComponents.add(new TranslatableComponent("teleporters.ender_crystal.tooltip.linked", tags.getInt("x"), tags.getInt("y"), tags.getInt("z")).withStyle(s -> s.withColor(ChatFormatting.GREEN)));

        }
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        InteractionHand hand = pContext.getHand();
        BlockState blockstate = level.getBlockState(blockpos);
        if(player.isShiftKeyDown()) {

            // NBTタグを取得し、NULLの場合は新規作成する
            ItemStack itemstack = player.getItemInHand(hand);
            CompoundTag tags = itemstack.getTag();
            if(tags == null) {
                itemstack.setTag(new CompoundTag());
                tags = itemstack.getTag();
            }
            tags.putInt("x", blockpos.getX());
            tags.putInt("y", blockpos.getY());
            tags.putInt("z", blockpos.getZ());
            tags.putString("dim", level.dimension().location().toString());
            tags.putFloat("direction", player.getRotationVector().y);

            if(!level.isClientSide) {
                player.displayClientMessage(new TranslatableComponent("teleporters.ender_crystal.click_event", tags.getInt("x"), tags.getInt("y"), tags.getInt("z")).withStyle(s -> s.withColor(ChatFormatting.GREEN)), true);
            }
            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1, 1);
            return InteractionResult.SUCCESS;
        } else if(hand == InteractionHand.MAIN_HAND) {
            ItemStack itemstack = player.getItemInHand(hand);
            CompoundTag tags = itemstack.getTag();
            if(tags == null) {
                player.displayClientMessage(new TranslatableComponent("teleporters.ender_crystal.unlinked").withStyle(s -> s.withColor(ChatFormatting.RED)), true);
            } else {
                player.displayClientMessage(new TranslatableComponent("teleporters.ender_crystal.click_event", tags.getInt("x"), tags.getInt("y"), tags.getInt("z")).withStyle(s -> s.withColor(ChatFormatting.GREEN)), true);
            }
        }
        return InteractionResult.PASS;
    }
}
