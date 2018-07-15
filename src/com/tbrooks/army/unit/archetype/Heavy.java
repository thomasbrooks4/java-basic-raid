package com.tbrooks.army.unit.archetype;

import com.tbrooks.army.unit.Unit;

public class Heavy extends Unit {

    private final int MELEE_RANGE = 2;

    public Heavy(final String name, final boolean friendly) {
        this.healthModifier = 1.5;
        this.damageModifier = 1.3;
        this.speedModifier = 0.7;

        initUnit(Archetype.HEAVY, name, friendly, false);

        this.range = MELEE_RANGE;
    }

    public void changeRangedEquipped() {
        // Heavy does not have ranged
    }
}
