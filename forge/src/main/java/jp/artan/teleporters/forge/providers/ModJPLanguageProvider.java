package jp.artan.teleporters.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractJPLanguageProvider;
import jp.artan.teleporters.init.STRBlocks;
import jp.artan.teleporters.init.STRItems;
import net.minecraft.data.PackOutput;

public class ModJPLanguageProvider extends AbstractJPLanguageProvider {
    public ModJPLanguageProvider(PackOutput output, String modid) {
        super(output, modid);
    }

    @Override
    protected void addTranslations() {

        this.add(STRItems.ENDER_CRYSTAL.get(), "エンダークリスタル");
        this.add(STRBlocks.TELEPORTER_BLOCK.get(), "テレポーター");
        this.add("teleporters.ender_crystal.click_event", "このクリスタルは %1$s, %2$s, %3$s にリンクされています。");
        this.add("teleporters.ender_crystal.unlinked", "このクリスタルはリンクされていません。");
        this.add("teleporters.ender_crystal.tooltip.linked", "Linked: %1$s, %2$s, %3$s");
        this.add("teleporters.ender_crystal.tooltip.unlinked", "Unlinked");
        this.add("teleporters.ender_crystal.tooltip.guid", "Shift + 右クリックでリンクします。");
    }
}
