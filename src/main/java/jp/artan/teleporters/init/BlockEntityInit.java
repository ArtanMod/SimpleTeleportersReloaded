package jp.artan.teleporters.init;

import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.block.entity.BlockEntityTeleporter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BET = DeferredRegister.create(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, SimpleTeleportersReloaded.MOD_ID);

    public static final RegistryObject<BlockEntityType<BlockEntityTeleporter>> ENTITY_TELEPORTER = BET.register("teleporter",
            () -> BlockEntityType.Builder.of(BlockEntityTeleporter::new, BlockInit.ENDER_CRYSTAL.get()).build(null));

    public static void register() {

    }
}
