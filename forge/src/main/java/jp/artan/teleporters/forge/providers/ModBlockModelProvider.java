package jp.artan.teleporters.forge.providers;

import jp.artan.teleporters.init.BlockInit;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockStateProvider {

    public ModBlockModelProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile model = this.models().getBuilder("teleporter")
                .renderType("cutout")
                .transforms()
                .transform(ItemTransforms.TransformType.GUI).rotation(30, 45, 0).translation(0, 0, 0).scale(0.625F, 0.625F, 0.625F).end()
                .transform(ItemTransforms.TransformType.GROUND).rotation(0, 0, 0).translation(0, 3, 0).scale(0.25F, 0.25F, 0.25F).end()
                .transform(ItemTransforms.TransformType.HEAD).rotation(0, 180, 0).translation(0, 0, 0).scale(1, 1, 1).end()
                .transform(ItemTransforms.TransformType.FIXED).rotation(0, 180, 0).translation(0, 0, 0).scale(0.5F, 0.5F, 0.5F).end()
                .transform(ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND).rotation(75, 315, 0).translation(0, 2.5F, 0).scale(0.375F, 0.375F, 0.375F).end()
                .transform(ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND).rotation(0, 315, 0).translation(0, 0, 0).scale(0.4F, 0.4F, 0.4F).end()
                .end()
                .texture("particle", this.mcLoc("block/nether_portal"))
                .texture("top", this.mcLoc("block/quartz_block_top"))
                .texture("line", this.mcLoc("block/quartz_pillar_top"))
                .texture("gold", this.mcLoc("block/gold_block"))
                .texture("portal", this.mcLoc("block/nether_portal"))
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
        this.getVariantBuilder(BlockInit.TELEPORTER_BLOCK.get())
                .forAllStates(state -> ConfiguredModel.builder().modelFile(model).build());
        this.simpleBlockItem(BlockInit.TELEPORTER_BLOCK.get(), model);
    }
}
