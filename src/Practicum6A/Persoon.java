package Practicum6A;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon(String naam, double budget){
        this.naam = naam;
        this.budget = budget;
        this.mijnGames = new ArrayList<Game>();
    }

    public double getBudget(){
        return budget;
    }

    public boolean koop(Game g){
        if (budget >= g.huidigeWaarde() && !mijnGames.contains(g) ) {
            mijnGames.add(g);
            budget -= g.huidigeWaarde();
            return true;
        } else {
            return false;
        }
    }

    public boolean verkoop(Game g, Persoon koper){
        if (mijnGames.contains(g) && koper.koop(g) ) {
            mijnGames.remove(g);
            budget += g.huidigeWaarde();
            return true;
        }
        return false;
    }

    public Game zoekGameOpNaam(String spel){
        for(Game g:this.mijnGames){
            if(g.getNaam().equals(spel)) {
                return g;
            }
        }
        return null;
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> lijst) {
        ArrayList<Game> nieuwList = new ArrayList<>();
        for (Game g : lijst) {
            for (Game gg : this.mijnGames) {
                if (!(g.getReleaseJaar() == gg.getReleaseJaar() && g.getNaam().equals(gg.getNaam()))) {
                    nieuwList.add(g);
                }
            }
        }

        return nieuwList;
    }

    public String toString(){
        String s = String.format("%s heeft een budget van €%.2f en bezit de volgende games:", naam, budget);
        for(Game game:mijnGames){ // (type naam:deLijst)
            s = s + "\n" + game.toString();                           // += != =+, s = s +
        }
        return s;
    }
}
