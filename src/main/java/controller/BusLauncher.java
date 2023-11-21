package controller;

import model.BestelBus;
import model.Pakket;
import model.PakketLezer;
import model.PakkettenBus;

import java.util.List;

public class BusLauncher {

    public static void main(String[] args) {
        PakkettenBus kuBus = new PakkettenBus("rode bus", 170);
        List<Pakket> lijstVanBestand;
        PakketLezer lezerBestand = new PakketLezer();
        lijstVanBestand = lezerBestand.leesPakketLijst("src/main/resources/pakketlijst.txt");
        System.out.println(lijstVanBestand);
        for (Pakket p : lijstVanBestand) {
            kuBus.laadPakket(p);
        }

        BestelBus<Pakket> vetteBus = new BestelBus<>(2000);
        for (Pakket p : lijstVanBestand){
            vetteBus.laadDing(p);
        }

        System.out.println(vetteBus.zoekZwaarsteDing());



    }
}
