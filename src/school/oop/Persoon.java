package school.oop;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Persoon {
    private final String naam;
    private double budget;
    private final ArrayList<Game> mijnGames = new ArrayList<Game>();

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game g) {

        if (g.huidigeWaarde() <= budget) {
            for (Game item : this.mijnGames) {
                if (item.equals(g)) {
                    return false;
                }
            }
            budget -= g.huidigeWaarde();
            this.mijnGames.add(g);
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if(this.mijnGames.isEmpty())
        {
            return false;
        }
        for (Game item : this.mijnGames) {
            if (item.equals(g)) {
                break;
            }
            return false;
        }
        if (koper.koop(g)) {
            this.mijnGames.remove(g);
            this.budget += g.huidigeWaarde();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String returnString = this.naam + " heeft een budget van " + NumberFormat.getCurrencyInstance().format(this.getBudget()).replaceFirst("\\u00A0", "") + " en bezit de volgende games:";
        for (Game game : this.mijnGames) {
            returnString += "\n";
            returnString += game.toString();

        }
        return returnString;
    }

    // Voor practicum 6B - KEREM
    public Game zoekGameOpNaam(String gNm) {
        Game gevonden = null;

        for (Game game : mijnGames) {
            if (gNm.equals(game.getNaam())) {
                gevonden = game;
            }
        }

}
