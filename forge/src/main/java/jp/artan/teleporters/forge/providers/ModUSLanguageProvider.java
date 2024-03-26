package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUSLanguageProvider;
import jp.artan.teleporters.init.STRCreativeTab;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class ModUSLanguageProvider extends AbstractUSLanguageProvider {
    public ModUSLanguageProvider(PackOutput output, String modid) {
        super(output, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();

        // ItemGroup
        ResourceLocation creativeTabRL = STRCreativeTab.SIMPLE_TELEPORTERS_RELOADED.getId();
        String id = "itemGroup." + creativeTabRL.getNamespace() + "." + creativeTabRL.getPath();
        this.add(id, "SimpleTeleporters: Reloaded");

        // ToolTip
        this.add("teleporters.ender_crystal.click_event", "This crystal is linked at: %1$s, %2$s, %3$s.");
        this.add("teleporters.ender_crystal.unlinked", "This crystal is unlinked.");
        this.add("teleporters.ender_crystal.tooltip.linked", "Linked: %1$s, %2$s, %3$s");
        this.add("teleporters.ender_crystal.tooltip.unlinked", "Unlinked");
        this.add("teleporters.ender_crystal.tooltip.guid", "Sneak right click a block to link.");
    }
}
