package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractRecipeProvider;
import jp.artan.artansprojectcoremod.utils.RecipeGenUtils;
import jp.artan.teleporters.init.STRBlocks;
import jp.artan.teleporters.init.STRItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public final class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, STRBlocks.TELEPORTER_BLOCK.get())
                .define('X', Blocks.GOLD_BLOCK)
                .define('Y', STRItems.ENDER_CRYSTAL.get())
                .define('Z', Blocks.QUARTZ_BLOCK)
                .pattern(" X ")
                .pattern("YZY")
                .pattern("ZZZ")
                .unlockedBy("has_item", has(STRItems.ENDER_CRYSTAL.get()))
                .save(consumer);
        RecipeGenUtils.Cooking.smelting(RecipeCategory.MISC, STRItems.ENDER_CRYSTAL::get, () -> Items.ENDER_EYE, consumer);
    }
}
