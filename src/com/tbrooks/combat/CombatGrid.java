package com.tbrooks.combat;

import com.tbrooks.army.Army;

public class CombatGrid {
    private final GridTile[][] combatGrid;
    private final int rowLength;
    private final int colLength;

    public CombatGrid(final int row, final int col) {
        this.combatGrid = new GridTile[row][col];
        this.rowLength = row;
        this.colLength = col;

        initializeCombatGrid(row, col);
    }

    private void initializeCombatGrid(final int row, final int col) {
        for (int rIndex = 0; rIndex < row; rIndex++) {
            for (int cIndex = 0; cIndex < col; cIndex++) {
                this.combatGrid[rIndex][cIndex] = new GridTile();
            }
        }
    }

    public void initializeArmies(final Army playerArmy, final Army enemyArmy) {
        for (int i = 0; i < playerArmy.getArmySize(); i++) {
            this.combatGrid[i][0].setCharacter(playerArmy.getCharacterAt(i));
        }

        for (int j = 0; j < enemyArmy.getArmySize(); j++) {
            this.combatGrid[j][this.colLength - 1].setCharacter(enemyArmy.getCharacterAt(j));
        }
    }

    public GridTile get(final int row, final int col) {
        return (row < this.rowLength && col < this.colLength) ? this.combatGrid[row][col] : null;
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
                    combatGridString.append(this.combatGrid[r][c].getCharacter().getName());
                }
                else {
                    combatGridString.append("Empty");
                }
            }
            combatGridString.append(" |\n");
        }

        return combatGridString.toString();
    }
}
