
package rallimeister5000;

class Talli {
    
    //Muuttuja Tallin / Talli olion nimelle
    private String nimi;
    //Kuljettaja luokan olio tallin ykköskuskille
    private Kuljettaja ykkoskuski;
    //Kuljettaja luokan olio tallin kakkoskuskille
    private Kuljettaja kakkoskuski;
    //Sarja luokan olio sisältää kyseisen Talli luokan olion
    private Sarja tallinSarja;
    //Tallien varallisuutta varten
    private double varallisuus;
    //Taulu Sponsoriolioita varten, sisältää siis tallin sponsorit
    private Sponsori[] sponssit;
    //Taulu Sopimusolioita varten, sisältää siis tallin sopimukset, Sponsorisopimukset ja mahdollisesti kuljettien jne. sopimuksia varten
    private Sopimus[] sopimukset;
    //Tallin sarjapisteiden varastointia varten
    private int sarjaPisteet;
    //Tallin Omistaja luokan olio, eli tallin omistaja
    private Omistaja omistaja;
    //Tallin Manageri luokan olio, eli tallin manageri
    private Manageri manageri;
    //Boolean tyypin muuttuja jolla määritetään onko kyseinen Talli olio pelaajan talli olio
    private boolean pelaajantalli;
    //Auto luokan olioiden varastointiin luotu taulu, sisältää siis kaikki tallin omistamat autot
    private Auto[] autot = new Auto[0];
    //Moottori luokan olioiden varastointiin luotu taulu, sisältää siis kaikki tallin omistamat moottorit
    private Moottori[] moottorit = new Moottori[0];
    //Jarrut luokan olioiden varastointiin luotu taulu, sisältää siis kaikki tallin omistamat jarrut
    private Jarrut[] jarrut = new Jarrut[0];
    //Jousitus luokan olioiden varastointiin luotu taulu, sisältää siis kaikki tallin omistamat jousitukset
    private Jousitus[] jouset = new Jousitus[0];
    //Renkaat luokan olioiden varastointii luotu taulu, sisältää siis kaikki tallin omistamat renkaat
    private Renkaat[] renkaat = new Renkaat[0];
    //Auto luokan olio joka kertoo mitä tallin autoista tallin ykköskuljettaja tällä hetkellä ajaa
    private Auto ykkosauto;
    //Auto luokan olio joka kertoo mitä autoista tallin kakkoskuljettaja tällä hetkellä ajaa
    private Auto kakkosauto;

    /**
     * 
     * Kaksi erilaista konstruktoria eri luontitilanteita varten 
     */
    Talli(String nimi) {
        this.nimi = nimi;
        this.pelaajantalli = false;
    }

    Talli(String nimi, Sarja sarja) {
        this.nimi = nimi;
        this.tallinSarja = sarja;
        this.pelaajantalli = false;
    }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return this.nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return the ykkoskuski
     */
    public Kuljettaja getYkkoskuski() {
        return ykkoskuski;
    }

    /**
     * @param ykkoskuski the ykkoskuski to set
     */
    public void setYkkoskuski(Kuljettaja ykkoskuski) {
        this.ykkoskuski = ykkoskuski;
    }

    /**
     * @return the kakkoskuski
     */
    public Kuljettaja getKakkoskuski() {
        return kakkoskuski;
    }

    /**
     * @param kakkoskuski the kakkoskuski to set
     */
    public void setKakkoskuski(Kuljettaja kakkoskuski) {
        this.kakkoskuski = kakkoskuski;
    }

    /**
     * @return the tallinSarja
     */
    public Sarja getTallinSarja() {
        return tallinSarja;
    }

    /**
     * @param tallinSarja the tallinSarja to set
     */
    public void setTallinSarja(Sarja tallinSarja) {
        this.tallinSarja = tallinSarja;
    }

    /**
     * @return the varallisuus
     */
    public double getVarallisuus() {
        return varallisuus;
    }

    /**
     * @param varallisuus the varallisuus to set
     */
    public void setVarallisuus(double varallisuus) {
        this.varallisuus = varallisuus;
    }

    /**
     * @return the sponssit
     */
    public Sponsori[] getSponssit() {
        return sponssit;
    }

    /**
     * @param sponssit the sponssit to set
     */
    public void setSponssit(Sponsori[] sponssit) {
        this.sponssit = sponssit;
    }

    /**
     * @return the sopimukset
     */
    public Sopimus[] getSopimukset() {
        return sopimukset;
    }

    /**
     * @param sopimukset the sopimukset to set
     */
    public void setSopimukset(Sopimus[] sopimukset) {
        this.sopimukset = sopimukset;
    }

    /**
     * @return the sarjaPisteet
     */
    public int getSarjaPisteet() {
        return sarjaPisteet;
    }

    /**
     * @param sarjaPisteet the sarjaPisteet to set
     */
    public void setSarjaPisteet(int sarjaPisteet) {
        this.sarjaPisteet = sarjaPisteet;
    }

    public String talliToString() {
        return "";
    }

    void addSarjaPisteet(int pisteet) {
        this.sarjaPisteet += pisteet;
    }

    void addVarallisuus(double tienesti) {
        this.varallisuus += tienesti;
    }

    void maksaPalkkaa(double palkka) {
        this.varallisuus -= palkka;
    }

    void removeVarallisuus(double siirtohinta) {
        this.varallisuus -= siirtohinta;
    }
    /**
     * 
     * Tämä on lähinnä hahmotelmaa siitä jos pelaaja haluaa ostaa Kuljettajan kilpailevalta tallilta
     * Ei siis todellakaan vielä loppuun asti mietitty tai pakollinen osa kokonaisuutta
     * Luo syvyyttä
     */
    boolean hyvaksySiirto(Kuljettaja kuski) {
        if (kuski == this.ykkoskuski) {
            return false;
        } else if (kuski == this.kakkoskuski) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 
     * Tämäkin on lähinnä hahmotelmaa siitä jos pelaaja haluaa ostaa kuljettajan kilpailevalta tallilta
     * Tässä siis on kyse siitä että tallin oma manageri "kisaa" vastapuolen tallin kanssa
     * Managereiden taitotasoon perustuen lasketaan hinta, oma manageri polkee hintaa
     * Kilpaileva manageri nostaa hintaa nämä vähennetään toisitaan ja lisätään alkuperäiseen
     * hintaan joka miinusta tai plussaa, jos miinusta niin oma manageri voitti neuvottelut
     * jos plussaa niin oma manageri hävisi neuvottelun
     * Voitti kumpi manageri tahansa niin kyseinen Manageri olio kutsuu Manageri luokan metodia lvlUp
     * joka parametrien puitteissa arpoo saako Manageri korkeamman neuvottelutaitotason
     * Tämä ei siis todellakaan pakollinen metodi ole
     * Lähinnä luo peliin syvyyttä
     *  
     */
    public double neuvottele(Manageri kilpailevaManageri, Kuljettaja kuljettaja) {
        int vastus = kilpailevaManageri.getNeuvottelutaito();
        int oma = this.manageri.getNeuvottelutaito();

        double siirtohinta = kuljettaja.getSiirtohinta();
        double alkuphinta = siirtohinta;
        siirtohinta = (siirtohinta - ((siirtohinta / 100) * oma)) + ((siirtohinta / 100) * vastus);

        if (siirtohinta > alkuphinta) {
            kilpailevaManageri.levelUp();
        } else if (siirtohinta < alkuphinta) {
            this.manageri.levelUp();
        }

        return siirtohinta;
    }

    Manageri getManageri() {
        return this.manageri;
    }
    /**
     * 
     * Tarkastaa onko tallissa ykköskuljettajaa 
     */
    boolean tallissaYkkosKuski() {
        if (this.ykkoskuski == null) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 
     * Tarkastaa onko tallissa kakkoskuljettajaa 
     */
    boolean tallissaKakkosKuski() {
        if (this.kakkoskuski == null) {
            return false;
        } else {
            return true;
        }
    }

    void setOmistaja(String nimi, int persoonallisuus) {
        this.omistaja = new Omistaja(nimi, persoonallisuus);
    }

    /**
     * @return the pelaajantalli
     */
    public boolean getPelaajantalli() {
        return pelaajantalli;
    }

    /**
     * @param pelaajantalli the pelaajantalli to set
     */
    public void setPelaajantalli(boolean pelaajantalli) {
        this.pelaajantalli = pelaajantalli;
    }

    public Omistaja getOmistaja() {
        return this.omistaja;
    }
    /**
     * 
     * Kun Talli koittaa ostaa auton niin tarkastetaan onko tallilla riittävä varallisuus
     * kyseisen auton hankintaan
     * 
     * Jos pätäkkää löytyy niin luodaan kyseiselle autolle osat esimerkki olioiden mukaan
     * kuitenkin niin että ne ovat täysin uusia itsenäisiä olioita, jotka siis yksilöi ne juuri tällä tallille
     * Sama tehdään myös autolle.
     *  
     */
    public void ostaAuto(osatJaAutot osat, int i) {
        double hinta = osat.getAutot()[i].getHinta();


        if (this.varallisuus >= hinta) {
            
            uusiMoottori(osat.getAutot()[i].getAutonMoottori());
            uudetJarrut(osat.getAutot()[i].getAutonJarrut());
            uudetJouset(osat.getAutot()[i].getAutonJouset());
            uudetRenkaat(osat.getAutot()[i].getAutonRenkaat());
            uusiAuto(osat.getAutot()[i]);
            this.varallisuus -= hinta;
        }
    }
    /**
     * Luo uuden Auto luokan olion erimerkin mukaiseksi
     * Hyödyntää ennen tätä metodia kutsuttuja osaolioita
     */
    public void uusiAuto(Auto auto) {
        Auto[] temp = new Auto[getAutot().length +1];
        
        for (int i = 0; i < getAutot().length;i++) {
            temp[i] = getAutot()[i];
        }
        temp[temp.length -1] = new Auto(auto.getMerkki(),auto.getMalli(),auto.getMassa(),
                moottorit[moottorit.length-1],
                jarrut[jarrut.length -1],
                jouset[jouset.length -1],
                renkaat[renkaat.length -1],
                auto.getHinta()/2);
        
        autot = temp;
        temp = null;
    }
    /**
     * Toimii samaan tyyliin kuin auton ostaminen, joten en määrittele nyt tarkemmin.
     * Pätee kaikkii tästä alaspäin kunnes seuraava kommenttialue ilmestyy
     *  
     */
    public void ostaMoottori(osatJaAutot osat, int i) {
        double hinta = osat.getMoottorit()[i].getHinta();
        if (this.varallisuus >= hinta) {
            uusiMoottori(osat.getMoottorit()[i]);
            this.varallisuus -= hinta;
        }
    }

    public void uusiMoottori(Moottori stock) {
        Moottori[] temp = new Moottori[getMoottorit().length + 1];

        for (int mo = 0; mo < getMoottorit().length; mo++) {
            temp[mo] = getMoottorit()[mo];
        }
        temp[temp.length - 1] = new Moottori(stock.getValmistaja(), stock.getNimi(), stock.getTeho(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta() / 2);
        moottorit = temp;
        temp = null;
    }

    public void ostaJarrut(osatJaAutot osat,int i) {
        double hinta = osat.getJarrut()[i].getHinta();
        if (this.varallisuus >= hinta) {
            uudetJarrut(osat.getJarrut()[i]);
            this.varallisuus -= hinta;
        }
    }

    public void uudetJarrut(Jarrut stock) {
        Jarrut[] temp = new Jarrut[getJarrut().length + 1];

        for (int i = 0; i < getJarrut().length; i++) {
            temp[i] = getJarrut()[i];
        }
        temp[temp.length - 1] = new Jarrut(stock.getValmistaja(), stock.getNimi(), stock.getJarruteho(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta() / 2);
        jarrut = temp;
        temp = null;
    }

    public void ostaJouset(osatJaAutot osat,int i) {
        double hinta = osat.getJousitukset()[i].getHinta();
        if (this.varallisuus >= hinta) {
            uudetJouset(osat.getJousitukset()[i]);
            this.varallisuus -= hinta;
        }

    }

    private void uudetJouset(Jousitus stock) {
        Jousitus[] temp = new Jousitus[getJouset().length + 1];
        for (int i = 0; i < getJouset().length; i++) {
            temp[i] = getJouset()[i];
        }
        temp[temp.length - 1] = new Jousitus(stock.getValmistaja(), stock.getNimi(), stock.getPito(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta() / 2);
        jouset = temp;
        temp = null;
    }

    public void ostaRenkaat(osatJaAutot osat,int i) {
        double hinta = osat.getRenkaat()[i].getHinta();
        if (this.varallisuus >= hinta) {
            uudetRenkaat(osat.getRenkaat()[i]);
            this.varallisuus -= hinta;
        }
    }

    private void uudetRenkaat(Renkaat stock) {
        Renkaat[] temp = new Renkaat[getRenkaat().length + 1];
        for (int i = 0; i < getRenkaat().length; i++) {
            temp[i] = renkaat[i];
        }
        temp[temp.length - 1] = new Renkaat(stock.getValmistaja(), stock.getNimi(), stock.getPito(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta()/2);
        renkaat = temp;
        temp = null;
    }

    /**
     * @return the autot
     */
    public Auto[] getAutot() {
        return autot;
    }

    /**
     * @return the moottorit
     */
    public Moottori[] getMoottorit() {
        return moottorit;
    }

    /**
     * @return the jarrut
     */
    public Jarrut[] getJarrut() {
        return jarrut;
    }

    /**
     * @return the jouset
     */
    public Jousitus[] getJouset() {
        return jouset;
    }

    /**
     * @return the renkaat
     */
    public Renkaat[] getRenkaat() {
        return renkaat;
    }
    /**
     * Kun rahat loppuu niin talli häviää pelistä, käytetään myös alustamaan satunnainen talli pelaajan talliksi
     */
    void meneKonkurssiin() {
        this.varallisuus = 0;
        this.omistaja = null;
        this.manageri = null;
        this.sarjaPisteet = 0;
        for (Jarrut jarru : jarrut) {
            jarru = null;
        }
        for (Moottori moottori : this.moottorit) {
            moottori = null;
        }
        this.moottorit = new Moottori[0];
        for (Jousitus jousi : this.jouset) {
            jousi = null;
        }
        this.jouset = new Jousitus[0];
        for (Renkaat reng : this.renkaat) {
            reng = null;
        }
        this.renkaat = new Renkaat[0];
        for (Auto auto : this.autot) {
            auto = null;
        }
        this.autot = new Auto[0];
    }

    void ostaManageri(Manageri manageri) {
        
    }
        /**
     * @return the ykkosauto
     */
    public Auto getYkkosauto() {
        return ykkosauto;
    }

    /**
     * @param ykkosauto the ykkosauto to set
     */
    public void setYkkosauto(Auto ykkosauto) {
        this.ykkosauto = ykkosauto;
    }

    /**
     * @return the kakkosauto
     */
    public Auto getKakkosauto() {
        return kakkosauto;
    }

    /**
     * @param kakkosauto the kakkosauto to set
     */
    public void setKakkosauto(Auto kakkosauto) {
        this.kakkosauto = kakkosauto;
    }


  
}
