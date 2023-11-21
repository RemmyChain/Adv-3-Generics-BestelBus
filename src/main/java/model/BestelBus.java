package model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class BestelBus<Ding extends PakketInterface> {

    private List<Ding> lading;
    private int totaalGewicht;
    private int maximumGewicht;

    public BestelBus(int maximumGewicht){
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadDing(Ding ding) {
        int toelaatbaarGewicht = maximumGewicht - totaalGewicht;
        if (ding.getGewicht() >= 0 && ding.getGewicht() < toelaatbaarGewicht){
            lading.add(ding);
            totaalGewicht += ding.getGewicht();
        }
    }

    public List<Ding> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

    public Ding zoekZwaarsteDing() {
        return recursieveZoeker(0);
    }

    public Ding recursieveZoeker(int index){

        if (lading.isEmpty()){
            throw new NoSuchElementException("er is geen lading");
        }

        if (index == lading.size() - 1){
            return lading.get(index);
        }

        if (lading.get(index).getGewicht() < recursieveZoeker(index + 1).getGewicht()){
            return recursieveZoeker(index + 1);
        }
        return lading.get(index);
    }




}
