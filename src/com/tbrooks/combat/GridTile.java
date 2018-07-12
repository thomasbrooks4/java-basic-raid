package com.tbrooks.combat;

import com.tbrooks.army.character.Character;

public class GridTile {
    private Character character;

    public boolean hasCharacter() {
        return this.character != null;
    }

    public Character getCharacter() {
        return this.character;
    }

    public void setCharacter(final Character character) {
        this.character = character;
    }
}
