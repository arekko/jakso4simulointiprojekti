
package rallimeister5000;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    /**
     * @see Alustetaan luokalle tarvittavat
     * @see toistaiseksi alustetaan myös tarpeetonta, älkööt niistä vielä välittäkö
    */
    Rallimeister5000 ralli;
    Manageri manageri;
    private final osatJaAutot osat;
    private Auto auto;
    Sarja[] ralliSarjat = new Sarja[5];
    Omistaja omistaja;
    Mekaanikko mekaanikot;
    Sopimus sopimus;
    Sponsori sponsori;
    Pankki pankki;
    Laina laina;
    Simulointi simuloi;
    Talli pelaajantalli;
    private AI ai = new AI(this);
    private final Talli freelancerit = new Talli("Vapaat");
    private List<Kuljettaja> vapaatKuljettajat = new ArrayList<>();
    private List<Manageri> vapaatManagerit;
    private List<Mekaanikko> vapaatMekaanikot;
    private final Random satunnaistaja = new Random();
    private int state;
    private Ui ui;
    Scanner lukija = new Scanner(System.in);
    /*
     *  Controllerin konstruktori
    */
    Controller() {
        /**
         * Controllerin konstruktori asettaa state 0 ja luo uuden osatJaAutot olion, jonka yhdistää
         * luokkamuuttujaan osat
         * Luo myös Ui luokan olion, jolle lähettää argumenttina itsensä
         */
        this.state = 0;
        this.osat = new osatJaAutot();
        this.ui = new Ui(this);
    }
    /*
     *  Alustetaan uusi peli, kutsutaan relevatit funktiot ja luodaan relevantit listat.
    */
    public void uusiPeli(String pelaaja) {
        /**
         * Luodaan kolme arraylistiä
         * Näiden tarkoitus on pitää sisällään Kuljettaja, Manageri ja Mekaanikko
         * luokkien olioita, jotka eivät ole minkään tallin palveluksessa
         */
        this.vapaatManagerit = new ArrayList<>();
        this.vapaatKuljettajat = new ArrayList<>();
        this.vapaatMekaanikot = new ArrayList<>();
        /**
         * Kutsutaan kaikki tarpeelliset metodit uuden pelin luomiseksi.
        */
        this.luoSarjat();
        this.luoTallit();
        this.luoKuljettajat();
        this.luoManagerit();
        this.luoMekaanikot();
        this.luoOmistajat();
        this.luoOsat();
        this.setState(1);
        this.alustaTallit(pelaaja);
    }
    /*
     *  Luodaan eri rallisarjat
    */
    public void luoSarjat() {
        /**
         * Luodaan 5 kappaletta sarjaluokan olioita
         * Metodikutsu String ja int
         * String sisältää sarjan nimen ja int on sarjataso
         * Neljäs divisioon on alhaisin sarjataso
         * World cup on korkein sarjataso
         */
        Sarja worldcup = new Sarja("Rallin world cup", 5);
        Sarja ekaDivari = new Sarja("Ensimmäinen divisioona", 4);
        Sarja tokaDivari = new Sarja("Toinen divisioona", 3);
        Sarja kolmasDivari = new Sarja("Kolmas divisioona", 2);
        Sarja neljasDivari = new Sarja("Neljäs divisioona", 1);
        /**
         * Luokan oma taulu ralliSarjat saa sisällökseen juuri luodut Sarja tyyppiset oliot.
         */
        ralliSarjat[0] = worldcup;
        ralliSarjat[1] = ekaDivari;
        ralliSarjat[2] = tokaDivari;
        ralliSarjat[3] = kolmasDivari;
        ralliSarjat[4] = neljasDivari;
        /**
         * Nämä oli testailua varten
         */
        System.out.println(ralliSarjat[0].getNimi()+" lisätty");
        System.out.println(ralliSarjat[1].getNimi()+" lisätty");
        System.out.println(ralliSarjat[2].getNimi()+" lisätty");
        System.out.println(ralliSarjat[3].getNimi()+" lisätty");
        System.out.println(ralliSarjat[4].getNimi()+" lisätty");
    }
    /*
     *  Luodaan pelin tallit satunnaistetusti, tallin nimet ovat vakiot, mutta missä sarjassa mikin talli on, on satunnaistettu.
    */
    public void luoTallit() {
        /**
         * String taulu tallit sisältää tallien nimet
         */
        String[] tallit = {"Toiota", "Otus", "Horsche", "Naudi", "Pia", "Kerrari", "Bercedes Menz", "Blue Ball Racing", "Sitruüna", "Hyndää", "MäcLören", "Force China", "Hans", "Suuber", "Rellu", "Wiljamis", "Fjård", "Meneral Rotors", "Metropöljä", "Nesla"};
        for (int i = 0; i < 20; i++) {
            /**
             * int muuttuja sarja luodaan satunnaistamista varten
             * tarkoitus on siis arpoa indeksiä ralliSarjat taulun indeksistä
            */
            int sarja = satunnaistaja.nextInt(4);
            /**
             * Luodaan boolean tyyppinen muuttuja tallisaiSarjan
             * Tämä luodaan koska alla oleva do while looppi pitää jollain purkaa
             */
            boolean tallisaiSarjan = false;
            do {
                /**
                 * Kutsuu Sarja luokan funktiota sarjassaTilaa
                 * Tarkemmin tästä Sarja luokassa
                 * 
                 * Jos kutsun paluuarvo oli true
                 * Luodaan uusi Talli luokan olio joka sijoitetaan satunnaistettuun sarjaan
                 */
                if (ralliSarjat[sarja].sarjassaTilaa() == true) {
                    Talli talli = new Talli(tallit[i]);
                    //System.out.println(talli.getNimi() + " luotu");
                    /**
                     * Talli olio lisätään vielä oikeaan Sarja olioon ja sijoitetaan siellä tauluun
                     * Tämä tehdään siis kutsumalla Sarja luokan metodia lisaaTalli
                     * Tästä tarkemmin Sarja luokassa
                     */
                    ralliSarjat[sarja].lisaaTalli(talli);
                    talli.setTallinSarja(ralliSarjat[sarja]);
                    tallisaiSarjan = true;
                } else {
                    /**
                     * Jos talli ei saanut sarjaa, eli ensimmäiseen arvottuun indeksiin (sarjaolioon) ei mahtunut
                     * luodaan uusi satunnainen kokonaisluku ja koitetaan kunnes sarjalla löytyy paikka
                     */
                    sarja = satunnaistaja.nextInt(5);
                }
                /**
                 * Jos talli sai sarjan do while looppi rikotaan, mutta for looppi jatkuu
                 */
            } while (tallisaiSarjan != true);
        }
    }
    /*
     *  Luodaan talleille kuljettajat, Kuljettajille luodaan satunnainen etunimi ja sukunimi kombinaation
     *  Kuljettajat saavat satunnaisen kansalaisuuden
     *  Kuljettavat vastaanottavat ensimmäisen vapaan tallipaikan ja sarjaluokkaan perustuen
     *  Kuljettajille luodaan taidot ja kokemus satunnaistetusti
     *  Kuljettajille vielä arvotaan joku sopimuksen kesto 1 ja neljän kauden väliin
    */       
    public void luoKuljettajat() {
        /**
         * String tyypin taulu etunimi sisältää satunnaisia etunimiä, joita voi olla rajattomasti
         * String tyypin taulu sukunimi sisältää satunnaisia sukunimiä, joita voi olla rajattomasti
         * String tyypin taulu kansalaisuus sisältää satunnaisia kansalaisuuksia, joita voi olla rajattomasti
         */
       String[] etunimi = {"Aaron", "Abdul", "Adam", "Alberto", "Antti", "Alejandro", "Asta", "Aliisa", "Annika", "Albert", "Aslak", "Bobby", "Bill"};
       String[] sukunimi = {"Johnson", "Al capone", "Hämäläinen", "Hänninen"};
       String[] kansalaisuus = {"FIN", "RUS", "UK", "USA", "FRA", "ITA"};
       /**
        * Alustetaan boolean tyyppinen muuttuja kuskisai, jolla rikotaan for loopit do while loopin sisällä
        */
       boolean kuskisaitallin;
       for (int i = 0; i < 40; i++) {
           kuskisaitallin = false;
           /**
            * Kutsutaan luokan omaa random oliota satunnaistajaa, jolla luodaan satunnainen kokonaisluku
            * Tämä satunnainen kokonaisluku määrää mitä asioita haetaan, tämä pätee molempiin alla olevista
            */
           String nimi = etunimi[satunnaistaja.nextInt(etunimi.length-1)]+" "+sukunimi[satunnaistaja.nextInt(sukunimi.length-1)];
           String nat = kansalaisuus[satunnaistaja.nextInt(kansalaisuus.length-1)];
           
           do {
               for (int sarja = 0; sarja < 5; sarja++) {
                   for (int talli = 0; talli < 4; talli++) {
                       /**
                        * Kutsutaan Talli luokan metodia tallissaYkkosKuski joka palauttaa arvon joko
                        * true tai false, jos tallissa ei ole ykköskuskia, tehdään kuskista tallin ykköskuski.
                        * Sama toistetaan alla mutta kutsumalla Talli luokan metodia tallissaKakkosKuski
                        * 
                        * Näistä metodeista enemmän Talli luokassa
                        */
                       if (this.ralliSarjat[sarja].getTallit()[talli].tallissaYkkosKuski() == false) {
                           this.ralliSarjat[sarja].getTallit()[talli].setYkkoskuski(new Kuljettaja(nimi, nat, 1, 1, 1, 1, this.ralliSarjat[sarja].getTallit()[talli]));
                           kuskisaitallin = true;
                       }
                       else if (this.ralliSarjat[sarja].getTallit()[talli].tallissaKakkosKuski() == false) {
                           this.ralliSarjat[sarja].getTallit()[talli].setKakkoskuski(new Kuljettaja(nimi, nat, 1, 1, 1, 1, this.ralliSarjat[sarja].getTallit()[talli]));
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
            Näitä ei toistaiseksi tarvita joten on kommentoitu pois
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
    /*
     *   Luodaan 30 manageria
    */
    public void luoManagerit() {
        
        /**
         * Luo 30 Manageri luokan oliota samaan tyyliin kuin kuljettajia luotiin
         * 
         */
        String[] etunimi = {"Test"};
        String[] sukunimi = {"Testi"};
        for (int i = 0; i < 30; i++) {
            Manageri mana = new Manageri(etunimi[0]+" "+sukunimi[0], satunnaistaja.nextInt(10));
            /**
             * Lisää luokan arraylistiin vapaatManagerit kyseiset managerit yksitellen iteroissaan for loopin läpi
             */
            this.getVapaatManagerit().add(mana);
        }
    }
    /*
     *  Luodaan jokaiselle tallille omistaja
    */
    public void luoOmistajat() {
        String[] etunimi = {"Test"};
        String[] sukunimi = {"Testi"};
        
        for (int i = 0; i < this.ralliSarjat.length; i++) {
            for (int a = 0; a < this.ralliSarjat[i].getTallit().length - 1; a++) {
                /**
                 * Asetaan jokaiselle tallille omistajaolio kutsumalla Talli luokan metodia setOmistaja
                 * perus setteri, ei kaivanne selityksiä
                 */
                this.ralliSarjat[i].getTallit()[a].setOmistaja(etunimi[0] + " " + sukunimi[0], 4);
            }
        }
    }
    public void luoMekaanikot() {
        /*
            Luodaan 30 mekaanikkoa
        */
        String[] etunimi = {"Test"};
        String[] sukunimi = {"Testi"};
        for (int i = 0; i < 30; i++) {
            /**
             * 30 manageria lisätään luokan arraylistiin vapaatMekaanikot
             */
            Mekaanikko meka = new Mekaanikko(etunimi[0]+" "+sukunimi[0], satunnaistaja.nextInt(10));
            this.getVapaatMekaanikot().add(meka);
        }
    }
    /*
     *  Luodaan peliin "Stock" osat ja autot
     */
    public void luoOsat() {
        /**
         * kutsutaan osatJaAuton luokan metodeja
         * Näistä tarkemmin osatJaAutot luokassa
         */
        getOsat().luoMoottorit();
        getOsat().luoJarrut();
        getOsat().luoJousitukset();
        getOsat().luoRenkaat();
        getOsat().luoAutot();
    }
    /**
     * Luodaan radat rallisarjoihin
     * Lähtökohtaisesti vaatii vielä pohdintaa siitä miten tämä toteutetaan.
     * Keskeinen osa pelin simulointia
     */
    void luoRadat() {
        
    }
    /**
     *  Luodaan sponsorit peliin
     *  Lähtökohtaisesti vaatii vielä pohdintaa siitä miten toteutetaan.
     * 
    */
    void luoSponsorit() {
        
    }
    /**
     *  Luodaan sopimuspohjat peliin
     * Lähtökohtaisesti vaatii vielä pohdintaa miten toteutetaan.
     */
    void luoSopimukset() {
        
    }
    /**
     * 
     * metodin tarkoitus on arpoa satunnainen talli alimmalta sarjatasolta ja kutsua Talli luokan
     * metodia meneKonkurssiin, tästä tulee pelaajan talli
     * Alustetaan talli tämän jälkeen pelaajalle
     */
    void alustaTallit(String pelaaja) {
        this.pelaajantalli = this.ralliSarjat[4].getTallit()[satunnaistaja.nextInt(4)];
        this.pelaajantalli.meneKonkurssiin();
        this.pelaajantalli.setPelaajantalli(true);
        this.pelaajantalli.setOmistaja(pelaaja, 0);
        this.pelaajantalli.setVarallisuus(10000);
        /**
         * Luo jokaiselle tallille lähtövarallisuuden jolla tallit voivat lähteä rakentamaan
         * Rahaa jokainen talli saa 10000 ja se kerrotaan sarjatasolla
         */
        for (int sarja = 0; sarja < this.ralliSarjat.length; sarja++) {
            for (int talli = 0; talli < this.ralliSarjat[sarja].getTallit().length;talli++) {
                this.ralliSarjat[sarja].getTallit()[talli].setVarallisuus(this.ralliSarjat[sarja].getSarjaTaso()*10000);
                ai.alustaTallit(this.ralliSarjat[sarja].getTallit()[talli]);
            }
        }
        /**
         * päivittää pelin staten yhdeksi ja kutsuu ui:n päivitä metodia statella, jotta ui tietää mitä pelaajan näkymään päivitetään
         */
        this.state = 1;
        ui.päivitä(state);
    }
    /*
     *  return the vapaatManagerit
     */
    public List<Manageri> getVapaatManagerit() {
        return vapaatManagerit;
    }
    /*
     * return the vapaatMekaanikot
     */
    public List<Mekaanikko> getVapaatMekaanikot() {
        return vapaatMekaanikot;
    }
    /*
     * return the osat
     */
    public osatJaAutot getOsat() {
        return osat;
    }
    
    /**
     * return the vapaatKuljettajat
     */
    public List<Kuljettaja> getVapaatKuljettajat() {
        return vapaatKuljettajat;
    }
    /**
     * return the state
     */
    public int getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }
    /**
     * kutsuu ui:n metodia päivitä päivittääkseen "alkumenun" pelaajalla, tässä kohtaa state siis 0
    */
    void peliAvattu() {
        ui.päivitä(this.state);
    }
}
