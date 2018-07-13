package com.tbrooks;

import com.tbrooks.army.Army;
import com.tbrooks.army.character.Character;
import com.tbrooks.army.character.archetype.Archer;
import com.tbrooks.army.character.archetype.Heavy;
import com.tbrooks.army.character.archetype.Peasant;
import com.tbrooks.army.character.archetype.Warrior;
import com.tbrooks.combat.CombatGrid;
import com.tbrooks.pathfinding.Pathfinder;

import java.awt.Point;

public class Main {

    public static void main(final String[] args) {
        final CombatGrid combatGrid = new CombatGrid(6, 12);

        final Army playerArmy = new Army(true);
        playerArmy.addCharacter(new Character("Thomas ", new Archer(), false));
        playerArmy.addCharacter(new Character("Brianna", new Warrior(), false));
        playerArmy.addCharacter(new Character("  Kyle ", new Peasant(), false));

        final Army enemyArmy = new Army(false);
        enemyArmy.addCharacter(new Character("Robbie ", new Heavy(), true));
        enemyArmy.addCharacter(new Character("  Dan  ", new Peasant(), true));
        enemyArmy.addCharacter(new Character("  Nam  ", new Warrior(), true));

        combatGrid.initializeArmies(playerArmy, enemyArmy);
        final Pathfinder pathfinder = new Pathfinder(combatGrid);
        pathfinder.findPath(new Point(0, 0), new Point(3, 11));

        System.out.println(combatGrid);

    }
}
