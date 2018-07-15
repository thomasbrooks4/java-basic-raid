package com.tbrooks;

import com.tbrooks.army.Army;
import com.tbrooks.army.character.archetype.Archer;
import com.tbrooks.army.character.archetype.Heavy;
import com.tbrooks.army.character.archetype.Peasant;
import com.tbrooks.army.character.archetype.Warrior;
import com.tbrooks.combat.CombatGrid;
import com.tbrooks.pathfinding.Pathfinder;

import java.awt.*;

public class Main {

    public static void main(final String[] args) {
        final CombatGrid combatGrid = new CombatGrid(6, 12);

        Archer thomas = new Archer("Thomas", true);
        Warrior brianna = new Warrior("Brianna", true);
        Peasant kyle = new Peasant("Kyle", true);

        Heavy robbie = new Heavy("Robbie", false);
        Peasant dan = new Peasant("Dan", false);
        Warrior nam = new Warrior("Nam", false);

        final Army playerArmy = new Army(true);
        playerArmy.addCharacter(thomas);
        playerArmy.addCharacter(brianna);
        playerArmy.addCharacter(kyle);

        final Army enemyArmy = new Army(false);
        enemyArmy.addCharacter(robbie);
        enemyArmy.addCharacter(dan);
        enemyArmy.addCharacter(nam);

        combatGrid.initializeArmies(playerArmy, enemyArmy);
        final Pathfinder pathfinder = new Pathfinder(combatGrid);
        pathfinder.findPath(new Point(0, 0), new Point(3, 11));

        System.out.println(combatGrid);

    }
}
