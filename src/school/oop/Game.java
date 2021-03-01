package school.oop;

import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.time.Year;
import java.util.Locale;

public class Game {
    private final String naam;
    private final int releaseJaar;
    private final double nieuwPrijs;

    public Game(String nm, int rj, double nwpr) {
        this.naam = nm;
        this.releaseJaar = rj;
        this.nieuwPrijs = nwpr;
    }

    public String getNaam() {
        return this.naam;
    }

    public int getReleaseJaar() {
        return this.releaseJaar;
    }

    public double huidigeWaarde() {
        double currentValue = nieuwPrijs;
        for (int count = (Year.now().getValue() - releaseJaar); count != 0; count--) {
            currentValue = currentValue * 0.70;
        }
        return currentValue;
    }

    public boolean equals(Object anderObject) {
        if (anderObject instanceof Game) {


            return ((Game) anderObject).getNaam().equals(this.getNaam()) && ((Game) anderObject).getReleaseJaar() == this.getReleaseJaar();
        }
        return false;
    }

    @Override
    public String toString() {


        return this.naam + ", uitgegeven in " + this.releaseJaar + "; nieuwprijs: " + NumberFormat.getCurrencyInstance().format(this.nieuwPrijs).replaceFirst("\\u00A0", "") + " nu voor: " + NumberFormat.getCurrencyInstance().format(this.huidigeWaarde()).replaceFirst("\\u00A0", "");
    }
}
