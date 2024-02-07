package jp.artan.teleporters;

import jp.artan.artansprojectcoremod.ArtanRegistrate;

public class SimpleTeleportersReloadedRegistrate extends ArtanRegistrate<SimpleTeleportersReloadedRegistrate, SimpleTeleportersReloadedGenerateDataInit> {
    protected SimpleTeleportersReloadedRegistrate(String modId) {
        super(modId);
    }

    @Override
    protected SimpleTeleportersReloadedGenerateDataInit createGenerateDataInit() {
        return new SimpleTeleportersReloadedGenerateDataInit();
    }
}
