package jp.artan.teleporters.init;

import jp.artan.repack.registrate.providers.RegistrateRecipeProvider;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.block.TeleporterBlock;
import jp.artan.teleporters.data.SimpleTeleportersReloadedRegistrate;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.Direction;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

public class BlockInit {
    private static final SimpleTeleportersReloadedRegistrate REGISTRATE = SimpleTeleportersReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static final BlockEntry<TeleporterBlock> ENDER_CRYSTAL = REGISTRATE.block("teleporter", TeleporterBlock::new)
            .initialProperties(Material.STONE)
            .properties(p -> p.lightLevel((bs) -> 1).explosionResistance(1).randomTicks())
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('X', Blocks.GOLD_BLOCK)
                        .define('Y', ItemInit.ENDER_CRYSTAL.get())
                        .define('Z', Blocks.QUARTZ_BLOCK)
                        .pattern(" X ")
                        .pattern("YZY")
                        .pattern("ZZZ")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.ENDER_CRYSTAL.get()))
                        .save(prov);
            })
            .simpleItem()
            .blockstate((ctx, provider) -> {
                ModelFile model = provider.models().getBuilder("teleporter")
                        .transforms()
                        .transform(ItemTransforms.TransformType.GUI).rotation(30, 45, 0).translation(0, 0, 0).scale(0.625F, 0.625F, 0.625F).end()
                        .transform(ItemTransforms.TransformType.GROUND).rotation(0, 0, 0).translation(0, 3, 0).scale(0.25F, 0.25F, 0.25F).end()
                        .transform(ItemTransforms.TransformType.HEAD).rotation(0, 180, 0).translation(0, 0, 0).scale(1, 1, 1).end()
                        .transform(ItemTransforms.TransformType.FIXED).rotation(0, 180, 0).translation(0, 0, 0).scale(0.5F, 0.5F, 0.5F).end()
                        .transform(ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND).rotation(75, 315, 0).translation(0, 2.5F, 0).scale(0.375F, 0.375F, 0.375F).end()
                        .transform(ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND).rotation(0, 315, 0).translation(0, 0, 0).scale(0.4F, 0.4F, 0.4F).end()
                        .end()
                        .texture("particle", provider.mcLoc("block/nether_portal"))
                        .texture("top", provider.mcLoc("block/quartz_block_top"))
                        .texture("line", provider.mcLoc("block/quartz_pillar_top"))
                        .texture("gold", provider.mcLoc("block/gold_block"))
                        .texture("portal", provider.mcLoc("block/nether_portal"))
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 3.0F, 16.0F)
                        .face(Direction.NORTH).texture("#top").uvs(0.0F, 0.0F, 16.0F, 3.0F).end()
                        .face(Direction.EAST).texture("#top").uvs(0.0F, 0.0F, 16.0F, 3.0F).end()
                        .face(Direction.SOUTH).texture("#top").uvs(0.0F, 0.0F, 14.0F, 2.0F).end()
                        .face(Direction.WEST).texture("#top").uvs(0.0F, 0.0F, 16.0F, 3.0F).end()
                        .face(Direction.UP).texture("#line").uvs(0.0F, 0.0F, 16.0F, 16.0F).end()
                        .face(Direction.DOWN).texture("#top").uvs(0.0F, 0.0F, 16.0F, 16.0F).end()
                        .end()
                        .element().from(1.0F, 3.0F, 1.0F).to(15.0F, 6.0F, 15.0F)
                        .face(Direction.NORTH).texture("#top").uvs(0.0F, 0.0F, 14.0F, 3.0F).end()
                        .face(Direction.EAST).texture("#top").uvs(0.0F, 0.0F, 14.0F, 3.0F).end()
                        .face(Direction.SOUTH).texture("#top").uvs(0.0F, 0.0F, 14.0F, 2.0F).end()
                        .face(Direction.WEST).texture("#top").uvs(0.0F, 0.0F, 14.0F, 3.0F).end()
                        .face(Direction.UP).texture("#line").uvs(1.0F, 1.0F, 15.0F, 15.0F).end()
                        .face(Direction.DOWN).texture("#top").uvs(0.0F, 0.0F, 14.0F, 14.0F).end()
                        .end()
                        .element().from(0.0F, 3.0F, 0.0F).to(2.0F, 5.0F, 2.0F)
                        .face(Direction.NORTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.EAST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.SOUTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.WEST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.UP).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.DOWN).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .end()
                        .element().from(14.0F, 3.0F, 0.0F).to(16.0F, 5.0F, 2.0F)
                        .face(Direction.NORTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.EAST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.SOUTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.WEST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.UP).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.DOWN).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .end()
                        .element().from(14.0F, 3.0F, 14.0F).to(16.0F, 5.0F, 16.0F)
                        .face(Direction.NORTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.EAST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.SOUTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.WEST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.UP).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.DOWN).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .end()
                        .element().from(0.0F, 3.0F, 14.0F).to(2.0F, 5.0F, 16.0F)
                        .face(Direction.NORTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.EAST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.SOUTH).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.WEST).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.UP).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .face(Direction.DOWN).texture("#gold").uvs(0.0F, 0.0F, 2.0F, 2.0F).end()
                        .end()
                        .element().from(4.0F, 6.0F, 4.0F).to(12.0F, 6.2F, 12.0F)
                        .face(Direction.NORTH).texture("#portal").uvs(0.0F, 0.0F, 8.0F, 0.2F).end()
                        .face(Direction.EAST).texture("#portal").uvs(0.0F, 0.0F, 8.0F, 0.2F).end()
                        .face(Direction.SOUTH).texture("#portal").uvs(0.0F, 0.0F, 8.0F, 0.2F).end()
                        .face(Direction.WEST).texture("#portal").uvs(0.0F, 0.0F, 8.0F, 0.2F).end()
                        .face(Direction.UP).texture("#portal").uvs(0.0F, 0.0F, 8.0F, 8.0F).end()
                        .face(Direction.DOWN).texture("#portal").uvs(0.0F, 0.0F, 8.0F, 8.0F).end()
                        .end();
                provider.getVariantBuilder(ctx.get())
                        .forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
                provider.simpleBlockItem(ctx.get(), model);
            })
            .addLayer(() -> RenderType::cutout)
            .lang("Teleporter")
            .jpLang("テレポーター")
            .register();

    public static void register() {
    }
}
