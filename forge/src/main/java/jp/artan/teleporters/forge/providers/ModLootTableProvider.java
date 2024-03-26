package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractLootTableProvider;
import jp.artan.teleporters.init.STRBlocks;
import net.minecraft.data.PackOutput;

import java.util.function.Function;

public class ModLootTableProvider extends AbstractLootTableProvider {
    public ModLootTableProvider(PackOutput output, String modId) {
        super(output, modId, () -> new BlockLootTable(modId));
    }

    @Override
    protected Function<String, BlockLootTable> getBlockLootTable() {
        return BlockLootTable::new;
    }

    private static class BlockLootTable extends AbstractBlockLoot {

        public BlockLootTable(String modid) {
            super(modid);
        }

        @Override
        protected void generate() {
            this.dropSelf(STRBlocks.TELEPORTER_BLOCK.get());
        }
    }
}
