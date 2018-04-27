/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak.Controller;

import maxattak.Model.Sarja;
import maxattak.Model.Sponsori;
import maxattak.Model.Mekaanikko;
import maxattak.Model.Talli;
import maxattak.Model.Manageri;
import maxattak.Model.AI;
import maxattak.Model.Sopimus;
import maxattak.Model.Kuljettaja;
import maxattak.Model.osatJaAutot;
import java.util.Random;

/**
 * ModelController luokka, toimii model tasolla kontrollerina.
 * Ohjaa pelin oliomaailmaa pohjautuen käyttäjän syötteeseen.
 *
 * @author soati
 */
public class ModelController {
    
    private osatJaAutot osat;
    private Talli pelaajanTalli;
    private final Sarja[] ralliSarjat = new Sarja[5];
    private Kuljettaja[] vapaatKuljettajat;
    private Manageri[] vapaatManagerit;
    private Mekaanikko[] vapaatMekaanikot;
    private final Random satunnaistaja = new Random();
    private final AI äly = new AI(this);
    
    
    /**
     * Metodi kutsuu muita metodeja jotka luovat tarpeelliset oliot pelin suorittamiseksi.
     * @param nimi tulee käyttäjän syötteestä uusi peli ruudussa.
     * @param talliNimi tulee käyttäjän syötteestä uusi peli ruudussa.
     * @see #alustaPelaajanTalli(java.lang.String, java.lang.String)
     * 
     */
    public void uusiPeli() {
        System.out.println("uusiPeli() kutsuttu");
        this.osat = new osatJaAutot();
        setVapaatKuljettajat(new Kuljettaja[30]);
        setVapaatManagerit(new Manageri[30]);
        setVapaatMekaanikot(new Mekaanikko[30]);
        this.luoSarjat();
        this.luoTallit();
        this.luoKuljettajat();
        this.luoManagerit();
        this.luoMekaanikot();
        this.luoOmistajat();
        this.luoOsat();
        this.alustaPelaajanTalli();
    }
    /**
     * Metodi luo pelin tarvitsemat Sarja-oliot. Sarjoja on viisi kappaletta.
     * @see maxattak.Sarja#Sarja(java.lang.String, int) 
     */
    public void luoSarjat() {
        System.out.println("luoSarjat() kutsuttu");
        Sarja worldcup = new Sarja("Rallin world cup", 5);
        Sarja ekaDivari = new Sarja("Ensimmäinen divisioona", 4);
        Sarja tokaDivari = new Sarja("Toinen divisioona", 3);
        Sarja kolmasDivari = new Sarja("Kolmas divisioona", 2);
        Sarja neljasDivari = new Sarja("Neljäs divisioona", 1);
        ralliSarjat[0] = worldcup;
        ralliSarjat[1] = ekaDivari;
        ralliSarjat[2] = tokaDivari;
        ralliSarjat[3] = kolmasDivari;
        ralliSarjat[4] = neljasDivari;
        for (Sarja ralliSarjat1 : getRalliSarjat()) {
            System.out.println(ralliSarjat1.getNimi() + " luotu.");
        }
    }
    /**
     * Luo pelin tarvitsemat tallioliot.
     * String taulun tallit indeksiä käydään for loopilla läpi kunnes peliin on generoitu 20 tallioliota satunnaisiin sarjoihin.
     * Hyödynnetään Sarja luokan metoddeja sarjassaTilaa ja lisaaTalli(talli).
     * 
     * @see maxattak.Talli#Talli(java.lang.String, maxattak.Sarja) 
     * @see maxattak.Sarja#sarjassaTilaa()
     * @see maxattak.Sarja#lisaaTalli(maxattak.Talli) 
     */
    public void luoTallit() {
        System.out.println("luoTallit() kutsuttu");
        String[] tallit = {"Toiota", "Otus", "Horsche", "Naudi", "Pia", "Kerrari", "Bercedes Menz", "Blue Ball Racing", "Sitruüna", "Hyndää", "MäcLören", "Force China", "Hans", "Suuber", "Rellu", "Wiljamis", "Fjård", "Meneral Rotors", "Metropöljä", "Nesla"};
        for (int i = 0; i < 20; i++) {
            int sarja = satunnaistaja.nextInt(5);
            boolean tallisaiSarjan = false;
            do {
                if (getRalliSarjat()[sarja].sarjassaTilaa() == true) {

                    Talli talli = new Talli(tallit[i], getRalliSarjat()[sarja]);

                    System.out.println(talli.getNimi() + " luotu ja se sai paikan sarjasta "+this.getRalliSarjat()[sarja].getNimi());
                    getRalliSarjat()[sarja].lisaaTalli(talli);
                    tallisaiSarjan = true;
                } else {
                    sarja = satunnaistaja.nextInt(5);
                }
            } while (tallisaiSarjan != true);
        }
    }
    /**
     * Metodi luo pelin tarvitsemat kuljettaja oliot ja sijoittaa talli ne olioihin
     * 
     * Alustetaan String taulut etunimi, sukunimi ja kansalaisuus.
     * Alustetaan boolean muuttuja kuskisaitallin.
     * Alustetaan String muuttujat nimi ja nat
     * 
     * For looppi ajetaan läpi 40 kertaa (luodaan 40 kuljettaja oliota).
     * 
     * Ajetaan do while looppia läpi kunnes Kuljettaja saa tallin.
     * 
     * String taulu etunimi sisältää listan etunimiä.
     * String taulu sukunimi sisältää listan etunimiä.
     * Näistä molemmista valitaan satunnainen indeksi (satunnaistajalla).
     * Ne yhdistetään yhdeksi stringiksi, josta tulee uuden Kuljettaja olion nimi.
     * 
     * String taulu kansalaisuus sisältää listan kansalaisuuksia.
     * Taulusta valitaan satunnainen indeksi (satunnaistajalla).
     * Tästä tulee uuden kuljettaja olion kansalaisuus.
     * 
     * Edellämainitut tallennetaan String muuttujiin nimi ja nat.
     * 
     * Seuraavaksi ajetaan for loopeilla läpi testit, joissa käydään sarjaoliot ja talliolioita läpi;
     * Aina siihen pisteeseen asti että Kuljettaja oliolla on talli paikka.
     * Tähän hyödynnetään Talli luokan metodikutsuja (tallissaYkkosKuski()),
     * sekä (tallissaKakkosKuski(), jotka palauttavat boolean arvon.
     * Mikäli paluuarvo oli false oli tallissa tilaa uudelle Kuljettaja oliolle.
     * Uusi Kuljettaja olio luodaan ja sille satunnaistetaan taidot (satunnaistajalla).
     * 
     * @see maxattak.Talli
     * @see maxattak.Talli#tallissaYkkosKuski() 
     * @see maxattak.Talli#tallissaKakkosKuski()
     * 
     */
    public void luoKuljettajat() {
       System.out.println("luoKuljettajat() kutsuttu");
       String[] etunimi = {"Aaron", "Abdul", "Adam", "Alberto", "Antti", "Alejandro", "Asta", "Aliisa", "Annika", "Albert", "Aslak", "Bobby", "Bill"};
       String[] sukunimi = {"Johnson", "Al capone", "Hämäläinen", "Hänninen"};
       String[] kansalaisuus = {"FIN", "RUS", "UK", "USA", "FRA", "ITA"};
       boolean kuskisaitallin;
       String nimi, nat;
       for (int i = 0; i < 40; i++) {
           kuskisaitallin = false;
           
           do {
               nimi = etunimi[satunnaistaja.nextInt(etunimi.length-1)]+" "+sukunimi[satunnaistaja.nextInt(sukunimi.length-1)];
               nat = kansalaisuus[satunnaistaja.nextInt(kansalaisuus.length-1)];
               for (int sarja = 0; sarja < 5; sarja++) {
                   for (int talli = 0; talli < 4; talli++) {
                       if (this.getRalliSarjat()[sarja].getTallit()[talli].tallissaYkkosKuski() == false) {
                           this.getRalliSarjat()[sarja].getTallit()[talli].setYkkoskuski(new Kuljettaja(nimi, nat, 1, 1, 1, 1, this.getRalliSarjat()[sarja].getTallit()[talli]));
                           System.out.println(this.getRalliSarjat()[sarja].getTallit()[talli].getYkkoskuski().getNimi()+" sai paikan tallista "+this.getRalliSarjat()[sarja].getTallit()[talli].getNimi());
                           kuskisaitallin = true;
                       }
                       if (this.getRalliSarjat()[sarja].getTallit()[talli].tallissaKakkosKuski() == false && kuskisaitallin == false) {
                           this.getRalliSarjat()[sarja].getTallit()[talli].setKakkoskuski(new Kuljettaja(nimi, nat, 1, 1, 1, 1, this.getRalliSarjat()[sarja].getTallit()[talli]));
                           System.out.println(this.getRalliSarjat()[sarja].getTallit()[talli].getKakkoskuski().getNimi()+" sai paikan tallista "+this.getRalliSarjat()[sarja].getTallit()[talli].getNimi());
                           kuskisaitallin = true;
                       }
                       if (kuskisaitallin) {
                           break;
                       }
                   }
                   if (kuskisaitallin) {
                       break;
                   }
               }
           } while (kuskisaitallin == false);
        }
       /*
            Luodaan 5 kuljettajaa  taitojen ja kokemuksen kera ja 5 kuljettajaa ilman taitoja "free agenteiksi", joita pelaaja voi halutessaan palkata.
       */
       /*for (int i = 0; i < 5; i++) {
           Kuljettaja kuljettaja = new Kuljettaja(etunimi[satunnaistaja.nextInt(etunimi.length-1)]+" "+sukunimi[satunnaistaja.nextInt(sukunimi.length-1)],kansalaisuus[satunnaistaja.nextInt(kansalaisuus.length-1)], 0, 0, 0, 0, this.getFreelancerit());
           this.getVapaatKuljettajat().add(kuljettaja);
       }
       for (int i = 0; i < 5; i++) {
           Kuljettaja kuljettaja = new Kuljettaja(etunimi[satunnaistaja.nextInt(etunimi.length-1)]+" "+sukunimi[satunnaistaja.nextInt(sukunimi.length-1)],kansalaisuus[satunnaistaja.nextInt(kansalaisuus.length-1)], satunnaistaja.nextInt(6)+1, satunnaistaja.nextInt(6)+1, satunnaistaja.nextInt(10)+1, 0, this.getFreelancerit());
           this.getVapaatKuljettajat().add(kuljettaja);
       } 
       */
    }
    /**
     * 
     * Luodaan 30 manageria ja lisätään ne vapaatManagerit tauluun.
     * @see maxattak.Manageri
     *  
    */
    public void luoManagerit() {
        
        String[] etunimi = {"Test"};
        String[] sukunimi = {"Testi"};
        for (int i = 0; i < 30; i++) {
            Manageri mana = new Manageri(etunimi[0]+" "+sukunimi[0], satunnaistaja.nextInt(10));
            this.getVapaatManagerit()[i] = mana;
        }
    }
    /**
     *  Luodaan jokaiselle tallille omistaja
     *  @see maxattak.Omistaja
    */
    public void luoOmistajat() {
        String[] etunimi = {"Test"};
        String[] sukunimi = {"Testi"};
        
        for (Sarja ralliSarjat1 : this.getRalliSarjat()) {
            for (int a = 0; a < ralliSarjat1.getTallit().length - 1; a++) {
                ralliSarjat1.getTallit()[a].setOmistaja(etunimi[0] + " " + sukunimi[0], 4);
            }
        }
    }
    /**
     * Luodaan 30 mekaanikkoa ja sijoitetaan ne vapaatMekaanikot tauluun
     */
    public void luoMekaanikot() {

        String[] etunimi = {"Test"};
        String[] sukunimi = {"Testi"};
        for (int i = 0; i < 30; i++) {
            Mekaanikko meka = new Mekaanikko(etunimi[0]+" "+sukunimi[0], satunnaistaja.nextInt(10));
            this.getVapaatMekaanikot()[i] = meka;
        }
    }
    /**
     * Kutsutaan osatJaAutot luokan metodeja, joilla luodaan autot ja osat
     */
    public void luoOsat() {
        osat.luoMoottorit();
        osat.luoJarrut();
        osat.luoJousitukset();
        osat.luoRenkaat();
        osat.luoVaihdelaatikot();
        osat.luoTurbot();
        osat.luoAutot();
    }
    /**
     *  Luodaan radat rallisarjoihin
     */
    public void luoRadat() {
        
    }
    /*
     *  Luodaan sponsorit peliin
    */
    public void luoSponsorit() {
        String[] sponsorit = {"Motocom","Salamander","Veli","Sponsori4", "Sponsori5", "Sponsori6", "Sponsori7", "Sponsori8", "Sponsori9", "Sponsori10", "Sponsori11", "Sponsori12",
            "Sponsori13", "Sponsori14", "Sponsori15", "Sponsori16", "Sponsori17", "Sponsori18", "Sponsori19", "Sponsori20", "Sponsori21", "Sponsori22", "Sponsori23", "Sponsori24",
            "Sponsori25", "Sponsori26", "Sponsori27", "Sponsori28", "Sponsori29", "Sponsori30", "Sponsori31", "Sponsori32", "Sponsori33", "Sponsori34", "Sponsori35", "Sponsori36",
            "Sponsori37", "Sponsori38", "Sponsori39", "Sponsori40", "Sponsori41", "Sponsori42", "Sponsori43", "Sponsori44", "Sponsori45", "Sponsori46", "Sponsori47", "Sponsori48", 
            "Sponsori49", "Sponsori50"};
        String[] ala = {"Rahoitus", "Tupakka", "Lääketeollisuus", "Virvoitusjuoma", "Autot"};
        for (int i = 0; i < 50; i++) {
            Sponsori sponssi = new Sponsori(sponsorit[i],ala[satunnaistaja.nextInt(ala.length)]);
        }

        
    }
    /*
     *  Luodaan sopimuspohjat peliin
     */
    public void luoSopimukset() {
        Sopimus s1 = new Sopimus(5, 200);
        Sopimus s2 = new Sopimus(10, 500);
        Sopimus s3 = new Sopimus(20, 100);
    }

    /**
     * @return the vapaatKuljettajat
     */
    public Kuljettaja[] getVapaatKuljettajat() {
        return vapaatKuljettajat;
    }

    /**
     * @param vapaatKuljettajat the vapaatKuljettajat to set
     */
    public void setVapaatKuljettajat(Kuljettaja[] vapaatKuljettajat) {
        this.vapaatKuljettajat = vapaatKuljettajat;
    }

    /**
     * @return the vapaatManagerit
     */
    public Manageri[] getVapaatManagerit() {
        return vapaatManagerit;
    }

    /**
     * @param vapaatManagerit the vapaatManagerit to set
     */
    public void setVapaatManagerit(Manageri[] vapaatManagerit) {
        this.vapaatManagerit = vapaatManagerit;
    }

    /**
     * @return the vapaatMekaanikot
     */
    public Mekaanikko[] getVapaatMekaanikot() {
        return vapaatMekaanikot;
    }

    /**
     * @param vapaatMekaanikot the vapaatMekaanikot to set
     */
    public void setVapaatMekaanikot(Mekaanikko[] vapaatMekaanikot) {
        this.vapaatMekaanikot = vapaatMekaanikot;
    }

    /**
     * @return the osat
     */
    public osatJaAutot getOsat() {
        return osat;
    }

    /**
     * @return the ralliSarjat
     */
    public Sarja[] getRalliSarjat() {
        return ralliSarjat;
    }

    /**
     * @return the äly
     */
    public AI getÄly() {
        return äly;
    }

    public void alustaPelaajanTalli() {
        int i = satunnaistaja.nextInt(4);
        this.ralliSarjat[4].getTallit()[i].meneKonkurssiin();
        this.ralliSarjat[4].getTallit()[i].setNimi("");
        this.ralliSarjat[4].getTallit()[i].setOmistaja("", 0);
        this.ralliSarjat[4].getTallit()[i].setVarallisuus(10000);
        this.setPelaajanTalli(ralliSarjat[4].getTallit()[i]);
    }

    /**
     * @return the pelaajanTalli
     */
    public Talli getPelaajanTalli() {
        return pelaajanTalli;
    }

    /**
     * @param pelaajanTalli the pelaajanTalli to set
     */
    public void setPelaajanTalli(Talli pelaajanTalli) {
        this.pelaajanTalli = pelaajanTalli;
    }

}