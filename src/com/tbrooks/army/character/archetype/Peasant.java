package com.tbrooks.army.character.archetype;

public class Peasant extends Archetype {

    public Peasant() {
        this.archetype = Archetypes.PEASANT;
        this.range = 3;
        this.healthModifier = 1.0;
        this.damageModifier = 1.0;
        this.speedModifier = 1.0;
    }
}
