package com.tbrooks.army.character.archetype;

public class Heavy extends Archetype {

    public Heavy() {
        this.archetype = Archetypes.HEAVY;
        this.range = 2;
        this.healthModifier = 1.5;
        this.damageModifier = 1.3;
        this.speedModifier = 0.75;
    }
}
