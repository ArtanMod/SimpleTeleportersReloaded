package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractItemModelProvider;
import jp.artan.teleporters.init.STRItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends AbstractItemModelProvider {
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(STRItems.ENDER_CRYSTAL.get());
    }
}
