package com.tbrooks.army;

import com.tbrooks.army.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final boolean friendly;
    private final List<Unit> army;
    private int armySize;

    public Army(final boolean friendly) {
        this.friendly = friendly;
        this.army = new ArrayList<>();
    }

    public boolean isFriendly() {
        return this.friendly;
    }

    public List<Unit> getArmy() {
        return this.army;
    }

    public int getArmySize() {
        return this.army.size();
    }

    public Unit getCharacterAt(final int index) {
        return this.army.get(index);
    }

    public void addCharacter(final Unit unit) {
        this.army.add(unit);
    }

    public void removeCharacter(final Unit unit) {
        this.army.remove(unit);
    }

}
