package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUSLanguageProvider;
import jp.artan.teleporters.init.STRCreativeTab;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.contents.TranslatableContents;

public class ModUSLanguageProvider extends AbstractUSLanguageProvider {
    public ModUSLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();

        // ItemGroup
        String id = ((TranslatableContents) STRCreativeTab.SIMPLE_TELEPORTERS_RELOADED.getDisplayName().getContents()).getKey();
        this.add(id, "SimpleTeleporters: Reloaded");

        // ToolTip
        this.add("teleporters.ender_crystal.click_event", "This crystal is linked at: %1$s, %2$s, %3$s.");
        this.add("teleporters.ender_crystal.unlinked", "This crystal is unlinked.");
        this.add("teleporters.ender_crystal.tooltip.linked", "Linked: %1$s, %2$s, %3$s");
        this.add("teleporters.ender_crystal.tooltip.unlinked", "Unlinked");
        this.add("teleporters.ender_crystal.tooltip.guid", "Sneak right click a block to link.");
    }
}
