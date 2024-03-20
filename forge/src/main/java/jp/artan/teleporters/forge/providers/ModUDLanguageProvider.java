package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUDLanguageProvider;
import jp.artan.artansprojectcoremod.utils.lang.LangUtils;
import jp.artan.teleporters.init.STRCreativeTab;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.contents.TranslatableContents;

public class ModUDLanguageProvider extends AbstractUDLanguageProvider {
    public ModUDLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();

        // ItemGroup
        String id = ((TranslatableContents)STRCreativeTab.SIMPLE_TELEPORTERS_RELOADED.getDisplayName().getContents()).getKey();
        this.add(id, LangUtils.toUpsideDownEnglish("SimpleTeleporters: Reloaded"));

        // ToolTip
        this.add("teleporters.ender_crystal.click_event", LangUtils.toUpsideDownEnglish("This crystal is linked at: %1$s, %2$s, %3$s."));
        this.add("teleporters.ender_crystal.unlinked", LangUtils.toUpsideDownEnglish("This crystal is unlinked."));
        this.add("teleporters.ender_crystal.tooltip.linked", LangUtils.toUpsideDownEnglish("Linked: %1$s, %2$s, %3$s"));
        this.add("teleporters.ender_crystal.tooltip.unlinked", LangUtils.toUpsideDownEnglish("Unlinked"));
        this.add("teleporters.ender_crystal.tooltip.guid", LangUtils.toUpsideDownEnglish("Sneak right click a block to link."));
    }
}
