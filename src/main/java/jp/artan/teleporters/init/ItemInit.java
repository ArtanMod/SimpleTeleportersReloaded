package jp.artan.teleporters.init;

import jp.artan.repack.registrate.util.entry.ItemEntry;
import jp.artan.teleporters.SimpleTeleportersReloaded;
import jp.artan.teleporters.data.SimpleTeleportersReloadedRegistrate;
import jp.artan.teleporters.item.TeleportCrystal;

public class ItemInit {
    private static final SimpleTeleportersReloadedRegistrate REGISTRATE = SimpleTeleportersReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static final ItemEntry<TeleportCrystal> ENDER_CRYSTAL = REGISTRATE.item("ender_crystal", TeleportCrystal::new)
            .lang("Ender Crystal")
            .jpLang("エンダークリスタル")
            .addRawLang("teleporters.ender_crystal.click_event", "This crystal is linked at: %1$s, %2$s, %3$s.")
            .addRawJPLang("teleporters.ender_crystal.click_event", "このクリスタルは %1$s, %2$s, %3$s にリンクされています。")
            .addRawLang("teleporters.ender_crystal.unlinked", "This crystal is unlinked.")
            .addRawJPLang("teleporters.ender_crystal.unlinked", "このクリスタルはリンクされていません。")
            .addRawLang("teleporters.ender_crystal.tooltip.linked", "Linked: %1$s, %2$s, %3$s")
            .addRawJPLang("teleporters.ender_crystal.tooltip.linked", "Linked: %1$s, %2$s, %3$s")
            .addRawLang("teleporters.ender_crystal.tooltip.unlinked", "Unlinked")
            .addRawJPLang("teleporters.ender_crystal.tooltip.unlinked", "Unlinked")
            .addRawLang("teleporters.ender_crystal.tooltip.guid", "Sneak right click a block to link.")
            .addRawJPLang("teleporters.ender_crystal.tooltip.guid", "Shift + 右クリックでリンクします。")
            .register();

    public static void register() {
    }
}
