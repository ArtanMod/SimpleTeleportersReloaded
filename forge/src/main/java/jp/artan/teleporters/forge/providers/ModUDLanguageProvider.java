package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUDLanguageProvider;
import jp.artan.artansprojectcoremod.utils.lang.LangUtils;
import jp.artan.teleporters.init.STRCreativeTab;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class ModUDLanguageProvider extends AbstractUDLanguageProvider {
    public ModUDLanguageProvider(PackOutput output, String modid) {
        super(output, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();

        // ItemGroup
        ResourceLocation creativeTabRL = STRCreativeTab.SIMPLE_TELEPORTERS_RELOADED.getId();
        String id = "itemGroup." + creativeTabRL.getNamespace() + "." + creativeTabRL.getPath();
        this.add(id, LangUtils.toUpsideDownEnglish("SimpleTeleporters: Reloaded"));

        // ToolTip
        this.add("teleporters.ender_crystal.click_event", LangUtils.toUpsideDownEnglish("This crystal is linked at: %1$s, %2$s, %3$s."));
        this.add("teleporters.ender_crystal.unlinked", LangUtils.toUpsideDownEnglish("This crystal is unlinked."));
        this.add("teleporters.ender_crystal.tooltip.linked", LangUtils.toUpsideDownEnglish("Linked: %1$s, %2$s, %3$s"));
        this.add("teleporters.ender_crystal.tooltip.unlinked", LangUtils.toUpsideDownEnglish("Unlinked"));
        this.add("teleporters.ender_crystal.tooltip.guid", LangUtils.toUpsideDownEnglish("Sneak right click a block to link."));
    }
}
