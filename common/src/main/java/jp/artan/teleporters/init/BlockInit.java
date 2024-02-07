package jp.artan.teleporters.init;

import jp.artan.artansprojectcoremod.registrate.builder.block.model.BlockModel;
import jp.artan.artansprojectcoremod.utils.RecipeGenUtils;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.SimpleTeleportersReloadedRegistrate;
import jp.artan.teleporters.block.TeleporterBlock;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class BlockInit {
    private static final SimpleTeleportersReloadedRegistrate REGISTRATE = SimpleTeleportersReloaded.registrate().creativeModeTab(ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static final Supplier<TeleporterBlock> TELEPORTER_BLOCK = REGISTRATE.block("teleporter", Material.STONE, TeleporterBlock::new)
            .properties(p -> p.lightLevel((bs) -> 1).explosionResistance(1).randomTicks())
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('X', Blocks.GOLD_BLOCK)
                        .define('Y', ItemInit.ENDER_CRYSTAL.get())
                        .define('Z', Blocks.QUARTZ_BLOCK)
                        .pattern(" X ")
                        .pattern("YZY")
                        .pattern("ZZZ")
                        .unlockedBy("has_item", RecipeGenUtils.has(ItemInit.ENDER_CRYSTAL.get()))
                        .save(prov);
            })
            .simpleItem()
            .blockstate(BlockModel.custom())
            .lang("Teleporter")
            .jpLang("テレポーター")
            .register();

    public static void register() {
    }
}
