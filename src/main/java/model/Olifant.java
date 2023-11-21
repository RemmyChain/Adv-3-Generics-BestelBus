package model;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class Olifant implements PakketInterface{

    private final int gewicht;

    public Olifant(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public int getGewicht() {
        return this.gewicht;
    }

    @Override
    public int compareTo(PakketInterface anderePakketInterface) {
        if (this.gewicht > anderePakketInterface.getGewicht()){
            return 1;
        } else if (this.gewicht < anderePakketInterface.getGewicht()){
            return -1;
        }
        return 0;
    }
}
