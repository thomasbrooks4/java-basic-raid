package com.tbrooks.clan;

import com.tbrooks.clan.clansmen.Clansmen;

import java.util.ArrayList;
import java.util.List;

public class Clan {

    private final boolean friendly;
    private final List<Clansmen> clan;

    public Clan(final boolean friendly) {
        this.friendly = friendly;
        this.clan = new ArrayList<>();
    }

    public boolean isFriendly() {
        return this.friendly;
    }

    public List<Clansmen> getClan() {
        return this.clan;
    }

    public int getArmySize() {
        return this.clan.size();
    }

    public Clansmen getClansmenAt(final int index) {
        return this.clan.get(index);
    }

    public void addUnit(final Clansmen clansmen) {
        this.clan.add(clansmen);
    }

    public void removeUnit(final Clansmen clansmen) {
        this.clan.remove(clansmen);
    }

}
