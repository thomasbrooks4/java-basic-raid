package com.tbrooks;

import com.tbrooks.army.Army;
import com.tbrooks.army.unit.archetype.Archer;
import com.tbrooks.army.unit.archetype.Heavy;
import com.tbrooks.army.unit.archetype.Peasant;
import com.tbrooks.army.unit.archetype.Warrior;
import com.tbrooks.grid.Grid;
import com.tbrooks.pathfinding.Pathfinder;

import java.awt.*;

public class Main {

    public static void main(final String[] args) {
        final Grid grid = new Grid(6, 12);

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

        grid.initializeArmies(playerArmy, enemyArmy);
        final Pathfinder pathfinder = new Pathfinder(grid);

        System.out.println(grid);

    }
}
