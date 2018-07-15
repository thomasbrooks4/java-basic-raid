package com.tbrooks.army.character;

import com.tbrooks.army.character.archetype.Archetype;
import com.tbrooks.combat.GridTile;

import java.util.List;

public abstract class Character {

    private final int DEFAULT_HEALTH = 100;
    private final int DEFAULT_SPEED = 100;
    private final int DEFAULT_DAMAGE = 30;

    protected Archetype archetype;
    protected String name;
    protected final String id = generateId();

    protected int healthTotal;
    protected int health;
    protected int range;

    protected double healthModifier;
    protected double speedModifier;
    protected double damageModifier;

    protected boolean friendly;
    protected boolean alive;
    protected boolean facingRight;
    protected boolean aimingHigh;
    protected boolean kneeling;
    protected boolean rangedEquipped;
    protected boolean retreating;

    protected GridTile gridTile;
    protected List<GridTile> path;

    protected void initCharacter(final Archetype archetype, final String name, final boolean friendly, final boolean rangedEquipped) {
        this.archetype = archetype;
        this.name = name;

        this.healthTotal = (int)(DEFAULT_HEALTH * this.healthModifier);
        this.health = this.healthTotal;

        this.friendly = friendly;
        this.alive = true;
        this.facingRight = friendly;
        this.aimingHigh = false;
        this.kneeling = false;
        this.rangedEquipped = rangedEquipped;
        this.retreating = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    private String generateId() {
        StringBuilder id = new StringBuilder();
        String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (var i = 0; i < 5; i++)
            id.append(possible.charAt((int)Math.floor(Math.random() * possible.length())));

        return id.toString();
    }

    public String getId() {
        return this.id;
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

    public int getSpeed() {
        return (int)(DEFAULT_SPEED * this.speedModifier);
    }

    public int getDamage() {
        return (int)(DEFAULT_DAMAGE * this.damageModifier);
    }

    public int getRange() {
        return this.range;
    }

    public double getHealthModifier() {
        return this.healthModifier;
    }

    public double getSpeedModifier() {
        return this.speedModifier;
    }

    public double getDamageModifier() {
        return this.damageModifier;
    }

    public boolean isFriendly() {
        return this.friendly;
    }

    public void changeFriendly(final boolean friendly) {
        this.friendly = friendly;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public boolean isFacingRight() {
        return this.facingRight;
    }

    public void turnAround() {
        this.facingRight = !this.facingRight;
    }

    public boolean isAimingHigh() {
        return this.aimingHigh;
    }

    public void changeAimingStance() {
        this.aimingHigh = !this.aimingHigh;
    }

    public boolean isKneeling() {
        return this.kneeling;
    }

    public void changeKneelingStance() {
        this.kneeling = !this.kneeling;
    }

    public Archetype getArchetype() {
        return this.archetype;
    }

    public boolean isRangedEquipped() {
        return this.rangedEquipped;
    }

    public abstract void changeRangedEquipped();

    public boolean isRetreating() {
        return this.retreating;
    }

    public void changeRetreating() {
        this.retreating = !this.retreating;
    }

    public GridTile getGridTile() {
        return this.gridTile;
    }

    public void setGridTile(final GridTile gridTile) {
        this.gridTile = gridTile;
    }

    public List<GridTile> getPath() {
        return this.path;
    }

    public void setPath(final List<GridTile> path) {
        this.path = path;
    }
}
