import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PakketTest {
    private PakkettenBus testBus;
    private BestelBus<Olifant> testBestelBusOlifant;

    @Test
    public void laadPakketMetNegatieveWaardeWeigeren() {
        maakBus();
        Pakket foutPakket = new Pakket("Aike", "Texas spel", -3);
        testBus.laadPakket(foutPakket);
        assertEquals(0, testBus.getLading().size());
    }

    @Test
    public void laadZwaarPakket() {
        maakBus();
        Pakket pakket1 = new Pakket("Aike", "Texas spel", 20);
        Pakket pakket2 = new Pakket("Aike", "Texas spel", 25);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        assertEquals(1, testBus.getLading().size());
    }

    @Test
    public void testTotaalGewicht() {
        maakBus();
        Pakket pakket1 = new Pakket("Aike", "Texas spel", 10);
        Pakket pakket2 = new Pakket("Aike", "Texas spel", 15);
        Pakket pakket3 = new Pakket("Aike", "Texas spel", 12);
        testBus.laadPakket(pakket1);
        testBus.laadPakket(pakket2);
        testBus.laadPakket(pakket3);
        assertEquals(37, testBus.getTotaalGewicht());
    }


    private void maakBus() {
        testBus = new PakkettenBus("Rode bus", 40);
    }

    private void maakOlfiantenBus(){
        testBestelBusOlifant = new BestelBus<>(1000);
    }

    @Test
    public void LaadTeZwareOlifant(){
        maakOlfiantenBus();
        Olifant fatso = new Olifant(1100);
        testBestelBusOlifant.laadDing(fatso);
        assertEquals(0, testBestelBusOlifant.getTotaalGewicht());
    }

    @Test
    public void laadTweeLichteOlifantjes(){
        maakOlfiantenBus();
        Olifant tiny = new Olifant(100);
        Olifant medi = new Olifant(800);
        testBestelBusOlifant.laadDing(tiny);
        testBestelBusOlifant.laadDing(medi);
        assertEquals(900, testBestelBusOlifant.getTotaalGewicht());
    }
    @Test
    public void ZoekZwaarsteDingMiddenWaarde(){
        maakOlfiantenBus();
        Olifant een = new Olifant(10);
        Olifant twee = new Olifant(20);
        Olifant drie = new Olifant(30);
        Olifant vier = new Olifant(40);
        Olifant vijf = new Olifant(50);
        testBestelBusOlifant.laadDing(een);
        testBestelBusOlifant.laadDing(twee);
        testBestelBusOlifant.laadDing(vijf);
        testBestelBusOlifant.laadDing(vier);
        testBestelBusOlifant.laadDing(drie);
        assertEquals(50, testBestelBusOlifant.zoekZwaarsteDing().getGewicht());

    }

}
