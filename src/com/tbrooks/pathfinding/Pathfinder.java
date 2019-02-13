package com.tbrooks.pathfinding;

import com.tbrooks.grid.CombatGrid;
import com.tbrooks.grid.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Pathfinder {

    private final static int MOVE_COST_DIAGONAL = 14;
    private final static int MOVE_COST_STRAIGHT = 10;

    private final CombatGrid combatGrid;

    public Pathfinder(final CombatGrid combatGrid) {
        this.combatGrid = combatGrid;
    }

    public List<Tile> findPath (final Tile startTile, final Tile endTile) {
        final int queueSize = combatGrid.getRowLength() * combatGrid.getColLength();
        final PriorityQueue<Tile> openTiles = new PriorityQueue<>(queueSize, Comparator.comparingInt(Tile::getfCost));
        final Set<Tile> searchedTiles = new HashSet<>();

        startTile.setG(0);
        startTile.setH(getH(startTile, endTile));

        openTiles.add(startTile);

        while (openTiles.size() > 0) {
            final Tile activeTile = openTiles.remove();
            searchedTiles.add(activeTile);

            final List<Tile> surroundingTiles = combatGrid.getSurroundingTiles(activeTile);

            if (surroundingTiles.contains(endTile)) {
                endTile.setParent(activeTile);

                return createPath(startTile, endTile);
            }

            for (final Tile surroundingTile : surroundingTiles) {
                if (surroundingTile.hasCharacter() || searchedTiles.contains(surroundingTile)) {
                    continue;
                }

                final int gCost = activeTile.getG() + getMoveCost(activeTile, surroundingTile);
                if (gCost < surroundingTile.getG() || !openTiles.contains(surroundingTile)) {
                    surroundingTile.setParent(activeTile);
                    surroundingTile.setG(gCost);
                    surroundingTile.setH(getH(surroundingTile, endTile));

                    if (!openTiles.contains(surroundingTile)) {
                        openTiles.add(surroundingTile);
                    }
                }
            }
        }

        return null;
    }

    private List<Tile> createPath(final Tile startTile, final Tile endTile) {
        final List<Tile> path = new ArrayList<>();
        Tile currentTile = endTile;

        while (!currentTile.equals(startTile)) {
            path.add(currentTile);
            currentTile = currentTile.getParent();
        }
        Collections.reverse(path);

        return path;
    }

    private int getH(final Tile startTile, final Tile endTile) {
        return Math.abs(endTile.getX() - startTile.getX()) + Math.abs(endTile.getY() - startTile.getY());
    }

    private int getMoveCost(final Tile startTile, final Tile endTile) {
        final int distanceX = Math.abs(endTile.getX() - startTile.getX());
        final int distanceY = Math.abs(endTile.getY() - startTile.getY());

        return (distanceX == distanceY) ? MOVE_COST_DIAGONAL : MOVE_COST_STRAIGHT;
    }
}
