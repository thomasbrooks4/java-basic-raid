package com.tbrooks.pathfinding;

import com.tbrooks.grid.Grid;
import com.tbrooks.grid.GridTile;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Pathfinder {
    private Grid grid;

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public List<GridTile> findPath (final GridTile startTile, final GridTile endTile) {
        final int queueSize = grid.getRowLength() * grid.getColLength();
        final PriorityQueue<GridTile> openQueue = new PriorityQueue<>(queueSize);
        final Set<GridTile> closedList = new HashSet<>();

        openQueue.add(startTile);

        while (openQueue.size() > 0) {
            final GridTile currentTile = openQueue.remove();
            closedList.add(currentTile);

            if (currentTile.equals(endTile)) {
                return createPath(startTile, endTile);
            }

            final List<GridTile> surroundingTiles = grid.getSurroundingTiles(currentTile);
            for (final GridTile surroundingTile : surroundingTiles) {
                if (surroundingTile.hasCharacter() || closedList.contains(surroundingTile)) {
                    continue;
                }

                final int moveCost = currentTile.getgCost() + getDistance(currentTile, surroundingTile);
                if (moveCost < surroundingTile.getgCost() || !openQueue.contains(surroundingTile)) {
                    surroundingTile.setgCost(moveCost);
                    surroundingTile.sethCost(getDistance(surroundingTile, endTile));
                    surroundingTile.setParent(currentTile);

                    if (!openQueue.contains(surroundingTile)) {
                        openQueue.add(surroundingTile);
                    }
                }
            }
        }

        return null;
    }

    private List<GridTile> createPath(final GridTile startTile, final GridTile endTile) {
        final List<GridTile> path = new ArrayList<>();
        GridTile currentTile = endTile;

        while (currentTile != startTile) {
            path.add(currentTile);
            currentTile = currentTile.getParent();
        }
        Collections.reverse(path);

        return path;
    }

    private int getDistance(final GridTile startTile, final GridTile endTile) {
        final int distanceX = Math.abs(startTile.getxPos() - endTile.getxPos());
        final int distanceY = Math.abs(startTile.getyPos() - endTile.getyPos());

        return (distanceX > distanceY) ? 14 * distanceY + 10 * (distanceX - distanceY)
                : 14 * distanceX + 10 * (distanceY - distanceX);
    }
}
