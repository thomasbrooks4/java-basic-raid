package com.tbrooks.clan.clansmen.archetype;

import com.tbrooks.clan.clansmen.Clansmen;

public class Warrior extends Clansmen {

    private final int MELEE_RANGE = 1;
    private final int RANGED_RANGE = 2;

    private boolean shieldUp;
    private int rangedAmount;

    public Warrior(final String name, final boolean friendly) {
        this.healthModifier = 1.3;
        this.damageModifier = 1.2;
        this.speedModifier = 0.9;

        initClansmen(Archetype.WARRIOR, name, friendly, false);

        this.range = MELEE_RANGE;
        this.shieldUp = false;
    }

    public void changeRangedEquipped() {
        this.rangedEquipped = !this.rangedEquipped;

        if (rangedEquipped) {
            this.range = RANGED_RANGE;

            this.damageModifier = 0.9;
            this.speedModifier = 1.1;
        }
        else {
            this.range = MELEE_RANGE;

            this.damageModifier = 1.2;
            this.speedModifier = 0.9;
        }
    }

    public boolean isShieldUp() {
        return this.shieldUp;
    }

    public void changeShieldStance() {
        this.shieldUp = !this.shieldUp;
    }

    public int getRangedAmount() {
        return this.rangedAmount;
    }

    public boolean rangedRemaining() {
        return this.rangedAmount > 0;
    }

    public void useRanged() {
        if (rangedRemaining()) {
            this.rangedAmount--;
        }
    }
}
