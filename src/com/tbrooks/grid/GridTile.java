package com.tbrooks.grid;

import com.tbrooks.army.unit.Unit;

public class GridTile implements Comparable<GridTile>{
    private Unit unit;
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
        return this.unit != null;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
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
