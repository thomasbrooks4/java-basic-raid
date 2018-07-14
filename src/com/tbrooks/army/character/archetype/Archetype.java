package com.tbrooks.army.character.archetype;

public abstract class Archetype {
    Archetypes archetype;
    int range;
    double healthModifier;
    double damageModifier;
    double speedModifier;

    public Archetypes getArchetype() {
        return this.archetype;
    }

    public int getRange() {
        return this.range;
    }

    public double getHealthModifier() {
        return this.healthModifier;
    }

    public double getDamageModifier() {
        return this.damageModifier;
    }

    public double getSpeedModifier() {
        return this.speedModifier;
    }
}
