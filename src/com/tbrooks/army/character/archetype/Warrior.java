package com.tbrooks.army.character.archetype;

public class Warrior extends Archetype {

    public Warrior() {
        this.archetype = Archetypes.WARRIOR;
        this.range = 1;
        this.healthModifier = 1.3;
        this.damageModifier = 1.2;
        this.speedModifier = 0.9;
    }
}
