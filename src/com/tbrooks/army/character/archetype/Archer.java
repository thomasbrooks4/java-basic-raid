package com.tbrooks.army.character.archetype;

public class Archer extends Archetype {

    public Archer() {
        this.archetype = Archetypes.ARCHER;
        this.range = 3;
        this.healthModifier = 0.8;
        this.damageModifier = 1.1;
        this.speedModifier = 1.1;
    }
}
