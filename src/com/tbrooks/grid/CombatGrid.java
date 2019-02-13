package com.tbrooks.grid;

import com.tbrooks.clan.Clan;

import java.util.ArrayList;
import java.util.List;

public class CombatGrid {
    private final Tile[][] combatGrid;
    private final int rowLength;
    private final int colLength;

    public CombatGrid(final int row, final int col) {
        this.combatGrid = new Tile[row][col];
        this.rowLength = row;
        this.colLength = col;

        initializeCombatGrid(row, col);
    }

    private void initializeCombatGrid(final int row, final int col) {
        for (int rIndex = 0; rIndex < row; rIndex++) {
            for (int cIndex = 0; cIndex < col; cIndex++) {
                this.combatGrid[rIndex][cIndex] = new Tile(rIndex, cIndex);
            }
        }
    }

    public void initializeClans(final Clan playerClan, final Clan enemyClan) {
        for (int i = 0; i < playerClan.getArmySize(); i++) {
            this.combatGrid[i][0].setClansmen(playerClan.getClansmenAt(i));
            playerClan.getClansmenAt(i).setTile(this.combatGrid[i][0]);
        }

        for (int j = 0; j < enemyClan.getArmySize(); j++) {
            this.combatGrid[j][this.colLength - 1].setClansmen(enemyClan.getClansmenAt(j));
            enemyClan.getClansmenAt(j).setTile(this.combatGrid[j][this.colLength - 1]);
        }
    }

    public Tile getTile(final int x, final int y) {
        return (x < this.rowLength && y < this.colLength) ? this.combatGrid[x][y] : null;
    }

    public Tile getTile(final Tile tile) {
        return (tile.getX() < this.rowLength && tile.getY() < this.colLength)
                ? this.combatGrid[tile.getX()][tile.getY()] : null;
    }

    public List<Tile> getSurroundingTiles(final Tile tile) {
        final List<Tile> surrounding = new ArrayList<>();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }

                final int checkX = tile.getX() + x;
                final int checkY = tile.getY() + y;

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
                    combatGridString.append(this.combatGrid[r][c].getClansmen().getName());
                }
                else {
                    combatGridString.append(" ");
                }
            }
            combatGridString.append(" |\n");
        }

        return combatGridString.toString();
    }
}
