package model;

public class Pakket implements PakketInterface{

    private String naamVanKind;
    private String cadeau;
    private int gewicht;

    public Pakket(String naamVanKind, String cadeau, int gewicht) {
        this.naamVanKind = naamVanKind;
        this.cadeau = cadeau;
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return String.format("{Kind: %s; cadeau: %s; gewicht: %d}", naamVanKind, cadeau, gewicht);
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
