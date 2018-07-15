package com.tbrooks.army.unit.archetype;

import com.tbrooks.army.unit.Unit;

public class Archer extends Unit {

    private final int MELEE_RANGE = 1;
    private final int RANGED_RANGE = 4;

    private boolean bowDrawn;

    public Archer(final String name, final boolean friendly) {
        this.healthModifier = 1.0;
        this.damageModifier = 1.1;
        this.speedModifier = 1.1;

        initUnit(Archetype.ARCHER, name, friendly, true);

        this.range = RANGED_RANGE;
        this.bowDrawn = false;
    }

    public void changeRangedEquipped() {
        this.rangedEquipped = !this.rangedEquipped;

        if (rangedEquipped) {
            this.range = RANGED_RANGE;

            this.damageModifier = 1.1;
            this.speedModifier = 1.1;
        }
        else {
            this.range = MELEE_RANGE;

            this.damageModifier = 0.6;
            this.speedModifier = 1.2;
        }
    }

    public boolean isBowDrawn() {
        return this.bowDrawn;
    }

    public void changeBowStance() {
        this.bowDrawn = !this.bowDrawn;
    }
}
