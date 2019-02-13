package com.tbrooks.grid;

import com.tbrooks.clan.clansmen.Clansmen;

public class Tile {

    private int x;
    private int y;

    private Clansmen clansmen;

    // Pathfinding
    private int g;
    private int h;
    private Tile parent;

    public Tile(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public boolean hasCharacter() {
        return this.clansmen != null;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public Clansmen getClansmen() {
        return this.clansmen;
    }

    public void setClansmen(final Clansmen clansmen) {
        this.clansmen = clansmen;
    }

    // Pathfinding

    public int getG() {
        return this.g;
    }

    public void setG(final int g) {
        this.g = g;
    }

    public int getH() {
        return this.h;
    }

    public void setH(final int h) {
        this.h = h;
    }

    public int getfCost() {
        return this.g + this.h;
    }

    public Tile getParent() {
        return parent;
    }

    public void setParent(final Tile parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Tile)) {
            return false;
        }

        final Tile tile = (Tile)o;

        return (this.getX() == tile.getX() && this.getY() == tile.getY());
    }
}
