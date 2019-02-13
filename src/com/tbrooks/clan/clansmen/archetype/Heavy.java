package com.tbrooks.clan.clansmen.archetype;

import com.tbrooks.clan.clansmen.Clansmen;

public class Heavy extends Clansmen {

    private final int MELEE_RANGE = 2;

    public Heavy(final String name, final boolean friendly) {
        this.healthModifier = 1.5;
        this.damageModifier = 1.3;
        this.speedModifier = 0.7;

        initClansmen(Archetype.HEAVY, name, friendly, false);

        this.range = MELEE_RANGE;
    }

    public void changeRangedEquipped() {
        // Heavy does not have ranged
    }
}
