package com.tbrooks.army.character;

import com.tbrooks.army.character.archetype.Archetype;

public class Character {
    private String name;
    private final Archetype archetype;
    private final int healthTotal;
    private int health;
    private boolean alive;
    private boolean facingLeft;

    public Character(final String name, final Archetype archetype, final boolean facingLeft) {
        this.name = name;
        this.archetype = archetype;
        this.healthTotal = 100;
        this.alive = true;
        this.facingLeft = facingLeft;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public int getHealth() {
        return this.health;
    }

    public void increaseHealth(final int amount) {
        if ((this.health + amount) > this.healthTotal) {
            this.health = this.healthTotal;
        }
        else {
            this.health += amount;
        }
    }

    public void decreaseHealth(final int amount) {
        if ((this.health - amount) < 0) {
            this.health = 0;
            this.alive = false;
        }
        else {
            this.health -= amount;
        }
    }

    public boolean isAlive() {
        return this.alive;
    }

    public boolean isFacingLeft() {
        return this.facingLeft;
    }

    public void turnAround() {
        this.facingLeft = !this.facingLeft;
    }

}
