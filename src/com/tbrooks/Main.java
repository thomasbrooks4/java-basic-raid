package com.tbrooks;

import com.tbrooks.army.Army;
import com.tbrooks.army.character.Character;
import com.tbrooks.army.character.archetype.Archer;
import com.tbrooks.army.character.archetype.Heavy;
import com.tbrooks.army.character.archetype.Peasant;
import com.tbrooks.army.character.archetype.Warrior;
import com.tbrooks.combat.CombatGrid;

public class Main {

    public static void main(final String[] args) {
        final CombatGrid combatGrid = new CombatGrid(6, 12);

        final Army playerArmy = new Army(true);
        playerArmy.addCharacter(new Character("Thomas", new Archer(), false));
        playerArmy.addCharacter(new Character("Brianna", new Warrior(), false));
        playerArmy.addCharacter(new Character("Kyle", new Peasant(), false));

        final Army enemyArmy = new Army(false);
        enemyArmy.addCharacter(new Character("Robbie", new Heavy(), true));
        enemyArmy.addCharacter(new Character("Dan", new Peasant(), true));
        enemyArmy.addCharacter(new Character("Nam", new Warrior(), true));

        combatGrid.initializeArmies(playerArmy, enemyArmy);

        System.out.println(combatGrid);

    }
}
