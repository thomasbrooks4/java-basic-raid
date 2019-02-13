package com.tbrooks;

import com.tbrooks.clan.Clan;
import com.tbrooks.clan.clansmen.archetype.Archer;
import com.tbrooks.clan.clansmen.archetype.Heavy;
import com.tbrooks.clan.clansmen.archetype.Peasant;
import com.tbrooks.clan.clansmen.archetype.Warrior;
import com.tbrooks.grid.CombatGrid;
import com.tbrooks.grid.Tile;
import com.tbrooks.pathfinding.Pathfinder;

import java.util.List;

public class Main {

    public static void main(final String[] args) {
        final CombatGrid combatGrid = new CombatGrid(6, 12);

        Archer thomas = new Archer("T", true);
        Warrior brianna = new Warrior("B", true);
        Peasant kyle = new Peasant("K", true);

        Heavy robbie = new Heavy("R", false);
        Peasant dan = new Peasant("D", false);
        Warrior nam = new Warrior("N", false);

        final Clan playerClan = new Clan(true);
        playerClan.addUnit(thomas);
        playerClan.addUnit(brianna);
        playerClan.addUnit(kyle);

        final Clan enemyClan = new Clan(false);
        enemyClan.addUnit(robbie);
        enemyClan.addUnit(dan);
        enemyClan.addUnit(nam);

        combatGrid.initializeClans(playerClan, enemyClan);
        final Pathfinder pathfinder = new Pathfinder(combatGrid);

        System.out.println(combatGrid);

        final List<Tile> TtoN = pathfinder.findPath(thomas.getTile(), nam.getTile());

        for (final Tile tile : TtoN) {
            combatGrid.getTile(tile).setClansmen(new Warrior("P", true));
        }

        System.out.println(combatGrid);
    }
}
