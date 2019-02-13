package com.tbrooks.clan.clansmen;

import com.tbrooks.clan.clansmen.archetype.Archetype;
import com.tbrooks.grid.Tile;
import com.tbrooks.pathfinding.Pathfinder;

import java.util.List;

public abstract class Clansmen {

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

    protected boolean selected;
    protected boolean friendly;
    protected boolean alive;
    protected boolean facingRight;
    protected boolean aimingHigh;
    protected boolean kneeling;
    protected boolean rangedEquipped;
    protected boolean retreating;
    protected boolean moving;
    protected boolean attacking;

    protected Pathfinder pathfinder;
    protected Tile tile;
    protected List<Tile> path;

    protected void initClansmen(
            final Archetype archetype,
            final String name,
            final boolean friendly,
            final boolean rangedEquipped) {
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

    // Unique Identifiers
    public Archetype getArchetype() {
        return this.archetype;
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

    // Stats
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

    // Archetype modifiers
    public double getHealthModifier() {
        return this.healthModifier;
    }

    public double getSpeedModifier() {
        return this.speedModifier;
    }

    public double getDamageModifier() {
        return this.damageModifier;
    }

    // Logic Booleans
    public boolean isSelected() {
        return this.selected;
    }

    public void changeSelected() {
        this.selected = !this.selected;
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

    public boolean isMoving() {
        return this.moving;
    }

    protected void startMoving() {
        this.moving = true;
    }

    protected void stopMoving() {
        this.moving = false;
    }

    public boolean isAttacking() {
        return this.attacking;
    }

    protected void startAttacking() {
        this.attacking = true;
    }

    protected void stopAttacking() {
        this.attacking = false;
    }

    // Pathfinding
    public Tile getTile() {
        return this.tile;
    }

    public void setTile(final Tile tile) {
        this.tile = tile;
    }

    // Combat methods
    public void move(final Tile targetTile) {
        this.path = pathfinder.findPath(this.tile, targetTile);

        if (path.size() == 0 || this.tile.equals(targetTile)) {
            stopMoving();
        }
        else {
            startMoving();

            // TODO: Move towards next tile in path
        }
    }

    public void attack(final Clansmen target) {
        if (target.isAlive()) {
            startAttacking();
            target.decreaseHealth(getDamage());
        }
        else {
            stopAttacking();
        }
    }

    public void moveAndAttack(final Clansmen target) {
        Tile targetTile = target.getTile();

        if (Math.abs(this.tile.getX() - targetTile.getX()) > this.range) {
            move(targetTile);
        }
        else {
            attack(target);
        }
    }
}
