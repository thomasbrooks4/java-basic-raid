package com.tbrooks.army.character.archetype;

import com.tbrooks.army.character.Character;

public class Heavy extends Character {

    private final int MELEE_RANGE = 2;

    public Heavy(final String name, final boolean friendly) {
        this.healthModifier = 1.5;
        this.damageModifier = 1.3;
        this.speedModifier = 0.7;

        initCharacter(Archetype.HEAVY, name, friendly, false);

        this.range = MELEE_RANGE;
    }

    public void changeRangedEquipped() {
        // Heavy does not have ranged
    }
}
