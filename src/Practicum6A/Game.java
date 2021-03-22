package Practicum6A;

import java.util.Objects;
import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwPrijs;

    public Game(String naam, int releaseJaar, double nieuwPrijs){
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwPrijs = nieuwPrijs;
    }

    public String getNaam(){
        return naam;
    }

    public double huidigeWaarde(){
        int releaseJaar1 = LocalDate.now().getYear(); // 1 jaar geleden
        return nieuwPrijs * Math.pow(0.7 , releaseJaar1 - releaseJaar);
    }

    // == is alleen locatie, .equals() = inhoud

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game){
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) &&
                    this.releaseJaar == andereGame.releaseJaar) {

                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    public String toString(){
        String s = String.format("%s, uitgegeven in %d; nieuwprijs: €%.2f nu voor: €%.2f", naam, releaseJaar, nieuwPrijs, huidigeWaarde() );
        return s;
    }
}
