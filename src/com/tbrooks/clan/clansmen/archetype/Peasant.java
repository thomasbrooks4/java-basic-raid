package com.tbrooks.clan.clansmen.archetype;

import com.tbrooks.clan.clansmen.Clansmen;

public class Peasant extends Clansmen {

    private final int MELEE_RANGE = 2;
    private final int RANGED_RANGE = 3;

    public Peasant(final String name, final boolean friendly) {
        this.healthModifier = 0.8;
        this.damageModifier = 0.9;
        this.speedModifier = 1.0;

        initClansmen(Archetype.PEASANT, name, friendly, false);

        this.range = MELEE_RANGE;
    }

    public void changeRangedEquipped() {
        this.rangedEquipped = !this.rangedEquipped;

        if (rangedEquipped) {
            this.range = RANGED_RANGE;

            this.damageModifier = 0.4;
            this.speedModifier = 1.0;
        }
        else {
            this.range = MELEE_RANGE;

            this.damageModifier = 0.9;
            this.speedModifier = 1.1;
        }
    }
}
