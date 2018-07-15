package com.tbrooks.grid;

import com.tbrooks.army.Army;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final GridTile[][] combatGrid;
    private final int rowLength;
    private final int colLength;

    public Grid(final int row, final int col) {
        this.combatGrid = new GridTile[row][col];
        this.rowLength = row;
        this.colLength = col;

        initializeCombatGrid(row, col);
    }

    private void initializeCombatGrid(final int row, final int col) {
        for (int rIndex = 0; rIndex < row; rIndex++) {
            for (int cIndex = 0; cIndex < col; cIndex++) {
                this.combatGrid[rIndex][cIndex] = new GridTile(rIndex, cIndex);
            }
        }
    }

    public void initializeArmies(final Army playerArmy, final Army enemyArmy) {
        for (int i = 0; i < playerArmy.getArmySize(); i++) {
            this.combatGrid[i][0].setUnit(playerArmy.getCharacterAt(i));
            playerArmy.getCharacterAt(i).setGridTile(this.combatGrid[i][0]);
        }

        for (int j = 0; j < enemyArmy.getArmySize(); j++) {
            this.combatGrid[j][this.colLength - 1].setUnit(enemyArmy.getCharacterAt(j));
            enemyArmy.getCharacterAt(j).setGridTile(this.combatGrid[j][this.colLength - 1]);
        }
    }

    public GridTile getTile(final int x, final int y) {
        return (x < this.rowLength && y < this.colLength) ? this.combatGrid[x][y] : null;
    }

    public List<GridTile> getSurroundingTiles(final GridTile gridTile) {
        final List<GridTile> surrounding = new ArrayList<>();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }

                final int checkX = gridTile.getxPos() + x;
                final int checkY = gridTile.getyPos() + y;

                if (0 <= checkX && checkX < rowLength && 0 <= checkY && checkY < colLength) {
                    surrounding.add(combatGrid[checkX][checkY]);
                }
            }
        }

        return surrounding;
    }

    public int getRowLength() {
        return this.rowLength;
    }

    public int getColLength() {
        return this.colLength;
    }

    @Override
    public String toString() {
        final StringBuilder combatGridString = new StringBuilder();

        for (int r = 0; r < this.rowLength; r++) {
            for (int c = 0; c < this.colLength; c++) {
                combatGridString.append(" | ");

                if (this.combatGrid[r][c].hasCharacter()) {
                    combatGridString.append(this.combatGrid[r][c].getUnit().getName());
                }
                else {
                    combatGridString.append("       ");
                }
            }
            combatGridString.append(" |\n");
        }

        return combatGridString.toString();
    }
}
