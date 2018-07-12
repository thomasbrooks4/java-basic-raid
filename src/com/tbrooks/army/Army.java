package com.tbrooks.army;

import com.tbrooks.army.character.Character;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final boolean friendly;
    private final List<Character> army;
    private int armySize;

    public Army(final boolean friendly) {
        this.friendly = friendly;
        this.army = new ArrayList<>();
    }

    public boolean isFriendly() {
        return this.friendly;
    }

    public List<Character> getArmy() {
        return this.army;
    }

    public int getArmySize() {
        return this.army.size();
    }

    public Character getCharacterAt(final int index) {
        return this.army.get(index);
    }

    public void addCharacter(final Character character) {
        this.army.add(character);
    }

    public void removeCharacter(final Character character) {
        this.army.remove(character);
    }

}
