package com.tbrooks.army.character.archetype;

public abstract class Archetype {
    Archetypes archetype;
    int range;

    public Archetypes getArchetype() {
        return this.archetype;
    }

    public int getRange() {
        return this.range;
    }
}
