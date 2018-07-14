package com.tbrooks.combat;

import com.tbrooks.army.character.Character;

public class GridTile implements Comparable<GridTile>{
    private Character character;
    private int gCost;
    private int hCost;
    private int xPos;
    private int yPos;
    private GridTile parent;

    public GridTile(final int xPos, final int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean hasCharacter() {
        return this.character != null;
    }

    public Character getCharacter() {
        return this.character;
    }

    public void setCharacter(final Character character) {
        this.character = character;
    }

    public int getgCost() {
        return this.gCost;
    }

    public void setgCost(final int gCost) {
        this.gCost = gCost;
    }

    public int gethCost() {
        return this.hCost;
    }

    public void sethCost(final int hCost) {
        this.hCost = hCost;
    }

    public int getfCost() {
        return this.gCost + this.hCost;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(final int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(final int yPos) {
        this.yPos = yPos;
    }

    public GridTile getParent() {
        return parent;
    }

    public void setParent(final GridTile parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(final GridTile gridTile) {
        return Integer.compare(this.getfCost(), gridTile.getfCost());
    }
}
