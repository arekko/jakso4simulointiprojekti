/*
 * Copyright (C) 2018 Jani Jaala, Topi Matikainen, Andrei Vasilev
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package maxattak.Model;
/**
 *
 * @author Ryhmä 4
 * @author Jani Jaala
 * @author Topi Matikainen
 * @author Andrei Vasilev
 * @author Metropolia University of Applied Sciences
 * @version 0.1a
 * 
 * 
 */

public class Talli {

    
    //Tallin nimi
    private String nimi;
    //Tallin ykkoskuski Kuljettaja olio
    private Kuljettaja ykkoskuski;
    //Tallin kakkoskuski Kuljettaja olio
    private Kuljettaja kakkoskuski;
    //Sarja olio johon kyseinen talli olio kuuluu
    private Sarja tallinSarja;
    //Tallin varallisuus
    private double varallisuus;
    //Taulu tallin sponsoreista
    private Sponsori[] sponssit;
    //Taulu tallin sopimuksista
    private Sopimus[] sopimukset;
    //Tallin sarjapisteet omassa sarjassaan
    private int sarjaPisteet;
    //Tallin omistaja olio
    private Omistaja omistaja;
    //Tallin manageri olio
    private Manageri manageri;
    //True tai false, true jos pelaajan talli
    private boolean pelaajantalli;
    //Taulu tallin auto olioista (tallin omistamat autot)
    private Auto[] autot = new Auto[0];
    //Taulu tallin moottori olioista (tallin omistamat moottorit)
    private Moottori[] moottorit = new Moottori[0];
    //Taulu tallin jarru olioista (tallin omistamat jarrut)
    private Jarrut[] jarrut = new Jarrut[0];
    //Taulu tallin jousitus olioista (tallin omistamat jousitukset)
    private Jousitus[] jouset = new Jousitus[0];
    //Taulu tallin renkaat olioista (tallin omistamat renkaat)
    private Renkaat[] renkaat = new Renkaat[0];
    //Taulu tallin vaihdelaatikko olioista (tallin omistamat vaihdelaatikot)
    private Vaihdelaatikko[] laatikot = new Vaihdelaatikko[0];
    //Taulu tallin turbo olioista (tallin omistamat turbot)
    private Turbo[] turbot = new Turbo[0];
    //Auto olio jossa pidetään tallin ykkoskuskin autoa
    private Auto ykkosauto;
    //Auto olio jossa pidetään tallin kakkoskuskin autoa
    private Auto kakkosauto;
    private Pankki bank = new Pankki(10000);

    /**
     * Pankki met
     *
     *
     */

    public void setSaldo( double saldo ){
        bank.setSaldo(saldo);
    }
    public double getSaldo(){
        return bank.getSaldo();
    }

    public void getLainaa(double laina){
        bank.getLaina(laina);
    }
    public double getKorko(){
        return bank.getKorko();
    }
    public void maksaLainaa(double määrä){
        bank.maksaaLaina(määrä);
    }
    public double getVelka(){
        return bank.getVelka();
    }

    public double getBudjetti(){
        return bank.getBudjetti();
    }


    public void addSaldo(double saldo){
        bank.addSaldo(saldo);
    }
    public void removeSaldo(double saldo){
       bank.removeSaldo(saldo);
    }




    /**
     * Tätä konstruktoria hyödyntää ModelControllerin luoTallit() metodi!
     * @param nimi, tallin nimi
     * @param sarja, tallin sarja
     */
    public Talli(String nimi, Sarja sarja) {
        this.nimi = nimi;
        this.tallinSarja = sarja;
        this.pelaajantalli = false;

    }
    /**
     * Hyödynnetään kun tallille pitää lisätä sarjapisteitä.
     * @param pisteet 
     */
    void addSarjaPisteet(int pisteet) {
        this.sarjaPisteet += pisteet;
    }
    /**
     * Hyödynnetään kun tallille lisätään rahaa esimerkiksi sponsorisopimuksilla
     * Tulonlähteet puuttuvat nykymuotoisesta koodista pääosin joten
     * Speksataan myöhemmissä versioissa tarkemmin
     * 
     * TODO
     * @param tienesti 
     */
    public void addVarallisuus(double tienesti) {
        this.varallisuus += tienesti;
    }
    /**
     * Hyödynnetään kun talli suorittaa hankintoja, kutsuja useasta paikasta
     * @param siirtohinta 
     */
    public void removeVarallisuus(double siirtohinta) {
        this.varallisuus -= siirtohinta;
    }

    Manageri getManageri() {
        return this.manageri;
    }
    /**
     * Hyödynnetään ModelControlin luoKuljettajat() metodin toimesta
     * Jos tallissa on jo ykköskuski palautetaan true
     * Jos tallissa ei vielä ole ykköskuskia palautetaan false
     * @return 
     */
    public boolean tallissaYkkosKuski() {
        return this.ykkoskuski != null;
    }
    /**
     * Lue edellisen metodin kommentti
     * @return 
     */
    public boolean tallissaKakkosKuski() {
        return this.kakkoskuski != null;
    }

    /**
     * 
     * Metodia kutsutaan pelaajan valinnan perusteella kaupassa
     * Pelaajalle tulostetaan kaupassa lista joka perustuu pelin alussa
     * Luotuihin Auto olioihin, jotka sijaitsevat osatJaAutot luokan
     * autot nimisessä auto olio taulussa
     * Parametri i perustuu käyttäjän valintaan kaupassa ja se on auto olio taulun
     * indeksi numero, tässä indeksissä olevan auton osat haetaan
     * osatJaAutot luokan tauluista jokaiselle osille ja kaikki nämä
     * tiedot välitetään eteenpäin relevanteille metodeille
     * 
     * uusiMoottori jne. kopioivat osatAutot auto olio taulussa olevasta auto oliosta
     * olevan moottorin (tai muun osan) tiedot ja luovat uuden olion niiden perusteella
     * Jolloin jokainen peliin lisättävä auto on oma olionsa ja kaikki auton osat
     * Ovat omia olioitaan, jotta niitä voidaan käsitellä yksilötasolla
     * 
     * Metodi tosin ensimmäiseksi tarkastaa onko pelaajan / ai:n tallilla riittävästi valuuttaa
     * Jos ei niin palautetaan false
     * Jos autoon oli varaa ja se ostettiin niin palautetaan true
     * 
     * Kaupan controller antaa näistä kussakin tapauksessa asianmukaisen "popupin" pelaajalle
     * 
     * @param osat
     * @param i
     * @return 
     */
    public boolean ostaAuto(osatJaAutot osat, int i) {
        double hinta = osat.getAutot()[i].getHinta();

        if (bank.getSaldo() >= hinta) {
            
            uusiMoottori(osat.getAutot()[i].getAutonMoottori());
            uudetJarrut(osat.getAutot()[i].getAutonJarrut());
            uudetJouset(osat.getAutot()[i].getAutonJouset());
            uudetRenkaat(osat.getAutot()[i].getAutonRenkaat());
            uusiTurbo(osat.getAutot()[i].getAutonTurbo());
            uusiVaihdelaatikko(osat.getAutot()[i].getAutonLaatikko());
            uusiAuto(osat.getAutot()[i]);
//            this.varallisuus -= hinta;
            removeSaldo(hinta);
            return true;
        }
        return false;
        
    }
    /**
     * Luo uuden auto olion ja lisää siihen osat perusuaen osa taulujen viimeksi lisättyihin
     * Arvoihin, sillä ne luotiin juuri kyseistä autoa varten juuri ennen auton luontia
     * @param auto 
     */
    public void uusiAuto(Auto auto) {
        Auto[] temp = new Auto[getAutot().length +1];
        System.out.println(getAutot().length);
        System.arraycopy(getAutot(), 0, temp, 0, getAutot().length);
        System.out.println(temp.length -1);
        temp[temp.length -1] = new Auto(auto.getMerkki(),auto.getMalli(),auto.getMassa(),
                moottorit[moottorit.length-1],
                jarrut[jarrut.length -1],
                jouset[jouset.length -1],
                renkaat[renkaat.length -1],
                getLaatikot()[getLaatikot().length -1],
                getTurbot()[getTurbot().length - 1],
                auto.getHinta()/2);
        
        autot = temp;
        temp = null;
    }
    /**
     * Metodia kutsutaan pelaajan valinnan perusteella kaupassa
     * Pelaajalle tulostetaan kaupassa lista joka perustuu pelin alussa
     * Luotuihin moottori olioihin, jotka sijaitsevat osatJaAutot luokan
     * moottorit nimisessä moottori olio taulussa
     * Parametri i perustuu käyttäjän valintaan kaupassa ja se on moottori olio taulun
     * indeksi numero
     * 
     * Jos tallilla on varaa ostaa kyseinen moottori
     * Moottori välitetään parametrinä uusiMoottori metodille
     * Joka luo uuden moottorin samoilla arvoilla
     * 
     * Metodi tosin ensimmäiseksi tarkastaa onko pelaajan / ai:n tallilla riittävästi valuuttaa
     * Jos ei niin palautetaan false
     * Jos autoon oli varaa ja se ostettiin niin palautetaan true
     * 
     * Kaupan controller antaa näistä kussakin tapauksessa asianmukaisen "popupin" pelaajalle
     * 
     * @param osat
     * @param i
     * @return 
     */
    public boolean ostaMoottori(osatJaAutot osat, int i) {
        double hinta = osat.getMoottorit()[i].getHinta();
        if (bank.getSaldo() >= hinta) {
            uusiMoottori(osat.getMoottorit()[i]);
//            this.varallisuus -= hinta;
            removeSaldo(hinta);
            return true;
        }
        return false;
    }
    /**
     * Parametrin saadun mukaisen olion arvot kopioidaan ja niillä luodaan uusi olio
     * Olion arvot ovat muuten samat, mutta olion hinta on puolet alkuperäisestä
     * 
     * Kopioidaan osataulu ja kasvatetaan sitä yhdellä ja lisätään juuri luotu olio tauluun
     * 
     * @param stock 
     */
    public void uusiMoottori(Moottori stock) {
        Moottori[] temp = new Moottori[getMoottorit().length + 1];

        System.arraycopy(getMoottorit(), 0, temp, 0, getMoottorit().length);
        temp[temp.length - 1] = new Moottori(stock.getValmistaja(), stock.getNimi(), stock.getTeho(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta() / 2);
        moottorit = temp;
        temp = null;
    }
    /**
     * Metodia kutsutaan pelaajan valinnan perusteella kaupassa
     * Pelaajalle tulostetaan kaupassa lista joka perustuu pelin alussa
     * Luotuihin jarrut olioihin, jotka sijaitsevat osatJaAutot luokan
     * jarrut nimisessä jarrut olio taulussa
     * Parametri i perustuu käyttäjän valintaan kaupassa ja se on jarrut olio taulun
     * indeksi numero
     * 
     * Jos tallilla on varaa ostaa kyseiset jarrut
     * jarrut välitetään parametrinä uudetJarrut metodille
     * Joka luo uudet jarrut samoilla arvoilla
     * 
     * Metodi tosin ensimmäiseksi tarkastaa onko pelaajan / ai:n tallilla riittävästi valuuttaa
     * Jos ei niin palautetaan false
     * Jos autoon oli varaa ja se ostettiin niin palautetaan true
     * 
     * Kaupan controller antaa näistä kussakin tapauksessa asianmukaisen "popupin" pelaajalle
     * 
     * @param osat
     * @param i
     * @return 
     */
    public boolean ostaJarrut(osatJaAutot osat,int i) {
        double hinta = osat.getJarrut()[i].getHinta();
        if (bank.getSaldo() >= hinta) {
            uudetJarrut(osat.getJarrut()[i]);
//            this.varallisuus -= hinta;
            removeSaldo(hinta);

            return true;
        }
        return false;
    }
    /**
     * Parametrin saadun mukaisen olion arvot kopioidaan ja niillä luodaan uusi olio
     * Olion arvot ovat muuten samat, mutta olion hinta on puolet alkuperäisestä
     * 
     * Kopioidaan osataulu ja kasvatetaan sitä yhdellä ja lisätään juuri luotu olio tauluun
     * 
     * @param stock 
     */
    public void uudetJarrut(Jarrut stock) {
        Jarrut[] temp = new Jarrut[getJarrut().length + 1];

        System.arraycopy(getJarrut(), 0, temp, 0, getJarrut().length);
        temp[temp.length - 1] = new Jarrut(stock.getValmistaja(), stock.getNimi(), stock.getJarruteho(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta() / 2);
        jarrut = temp;
        temp = null;
    }
    /**
     * Metodia kutsutaan pelaajan valinnan perusteella kaupassa
     * Pelaajalle tulostetaan kaupassa lista joka perustuu pelin alussa
     * Luotuihin jousitus olioihin, jotka sijaitsevat osatJaAutot luokan
     * jousitus nimisessä jousitus olio taulussa
     * Parametri i perustuu käyttäjän valintaan kaupassa ja se on jousitus olio taulun
     * indeksi numero
     * 
     * Jos tallilla on varaa ostaa kyseinen jousitus
     * Moottori välitetään parametrinä uudetJouset metodille
     * Joka luo uuden jousituksen samoilla arvoilla
     * 
     * Metodi tosin ensimmäiseksi tarkastaa onko pelaajan / ai:n tallilla riittävästi valuuttaa
     * Jos ei niin palautetaan false
     * Jos autoon oli varaa ja se ostettiin niin palautetaan true
     * 
     * Kaupan controller antaa näistä kussakin tapauksessa asianmukaisen "popupin" pelaajalle
     * 
     * @param osat
     * @param i
     * @return 
     */
    public boolean ostaJouset(osatJaAutot osat,int i) {
        double hinta = osat.getJousitukset()[i].getHinta();
        if (bank.getSaldo() >= hinta) {
            uudetJouset(osat.getJousitukset()[i]);
//            this.varallisuus -= hinta;
            removeSaldo(hinta);

            return true;
        }
        return false;
    }
    /**
     * Parametrin saadun mukaisen olion arvot kopioidaan ja niillä luodaan uusi olio
     * Olion arvot ovat muuten samat, mutta olion hinta on puolet alkuperäisestä
     * 
     * Kopioidaan osataulu ja kasvatetaan sitä yhdellä ja lisätään juuri luotu olio tauluun
     * 
     * @param stock 
     */
    public void uudetJouset(Jousitus stock) {
        Jousitus[] temp = new Jousitus[getJouset().length + 1];
        System.arraycopy(getJouset(), 0, temp, 0, getJouset().length);
        temp[temp.length - 1] = new Jousitus(stock.getValmistaja(), stock.getNimi(), stock.getPito(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta() / 2);
        jouset = temp;
        temp = null;
    }
    /**
     * Metodia kutsutaan pelaajan valinnan perusteella kaupassa
     * Pelaajalle tulostetaan kaupassa lista joka perustuu pelin alussa
     * Luotuihin renkaat olioihin, jotka sijaitsevat osatJaAutot luokan
     * renkaat nimisessä renkaat olio taulussa
     * Parametri i perustuu käyttäjän valintaan kaupassa ja se on renkaat olio taulun
     * indeksi numero
     * 
     * Jos tallilla on varaa ostaa kyseiset renkaat
     * renkaat välitetään parametrinä uudetRenkaat metodille
     * Joka luo uudet renkaat samoilla arvoilla
     * 
     * Metodi tosin ensimmäiseksi tarkastaa onko pelaajan / ai:n tallilla riittävästi valuuttaa
     * Jos ei niin palautetaan false
     * Jos autoon oli varaa ja se ostettiin niin palautetaan true
     * 
     * Kaupan controller antaa näistä kussakin tapauksessa asianmukaisen "popupin" pelaajalle
     * 
     * @param osat
     * @param i
     * @return 
     */
    public boolean ostaRenkaat(osatJaAutot osat,int i) {
        double hinta = osat.getRenkaat()[i].getHinta();
        if (bank.getSaldo() >= hinta) {
            uudetRenkaat(osat.getRenkaat()[i]);
//            this.varallisuus -= hinta;
            removeSaldo(hinta);

            return true;
        }
        return false;
    }
    /**
     * Parametrin saadun mukaisen olion arvot kopioidaan ja niillä luodaan uusi olio
     * Olion arvot ovat muuten samat, mutta olion hinta on puolet alkuperäisestä
     * 
     * Kopioidaan osataulu ja kasvatetaan sitä yhdellä ja lisätään juuri luotu olio tauluun
     * 
     * @param stock 
     */
    private void uudetRenkaat(Renkaat stock) {
        Renkaat[] temp = new Renkaat[getRenkaat().length + 1];
        System.arraycopy(renkaat, 0, temp, 0, getRenkaat().length);
        temp[temp.length - 1] = new Renkaat(stock.getValmistaja(), stock.getNimi(), stock.getPito(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta()/2);
        renkaat = temp;
        temp = null;
    }
    /**
     * Metodia kutsutaan pelaajan valinnan perusteella kaupassa
     * Pelaajalle tulostetaan kaupassa lista joka perustuu pelin alussa
     * Luotuihin turbo olioihin, jotka sijaitsevat osatJaAutot luokan
     * turbo nimisessä turbo olio taulussa
     * Parametri i perustuu käyttäjän valintaan kaupassa ja se on turbo olio taulun
     * indeksi numero
     * 
     * Jos tallilla on varaa ostaa kyseinen turbo
     * turbo välitetään parametrinä uusiTurbo metodille
     * Joka luo uuden moottorin samoilla arvoilla
     * 
     * Metodi tosin ensimmäiseksi tarkastaa onko pelaajan / ai:n tallilla riittävästi valuuttaa
     * Jos ei niin palautetaan false
     * Jos autoon oli varaa ja se ostettiin niin palautetaan true
     * 
     * Kaupan controller antaa näistä kussakin tapauksessa asianmukaisen "popupin" pelaajalle
     * 
     * @param osat
     * @param i
     * @return 
     */    
    public boolean ostaTurbo(osatJaAutot osat, int i) {
        double hinta = osat.getTurbo()[i].getHinta();
        if (bank.getSaldo() >= hinta) {
            uusiTurbo(osat.getTurbo()[i]);
//            this.varallisuus -= hinta;
            removeSaldo(hinta);

            return true;
        }
        return false;
    }
    /**
     * Parametrin saadun mukaisen olion arvot kopioidaan ja niillä luodaan uusi olio
     * Olion arvot ovat muuten samat, mutta olion hinta on puolet alkuperäisestä
     * 
     * Kopioidaan osataulu ja kasvatetaan sitä yhdellä ja lisätään juuri luotu olio tauluun
     * 
     * @param stock 
     */    
    private void uusiTurbo(Turbo stock) {
        Turbo[] temp = new Turbo[getTurbot().length +1];
        
        System.arraycopy(getTurbot(), 0, temp, 0, getTurbot().length);
        temp[temp.length - 1] = new Turbo(stock.getValmistaja(), stock.getNimi(), stock.getKiihtyvyys(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta()/2);
        
        setTurbot(temp);
    }
    /**
     * Metodia kutsutaan pelaajan valinnan perusteella kaupassa
     * Pelaajalle tulostetaan kaupassa lista joka perustuu pelin alussa
     * Luotuihin vaihdelaatikko olioihin, jotka sijaitsevat osatJaAutot luokan
     * laatikko nimisessä Vaihdelaatikko olio taulussa
     * Parametri i perustuu käyttäjän valintaan kaupassa ja se on Vaihdelaatikko olio taulun
     * indeksi numero
     * 
     * Jos tallilla on varaa ostaa kyseinen vaihdelaatikko
     * vaihdelaatikko välitetään parametrinä uusiVaihdelaatikko metodille
     * Joka luo uuden vaihdelaatikon samoilla arvoilla
     * 
     * Metodi tosin ensimmäiseksi tarkastaa onko pelaajan / ai:n tallilla riittävästi valuuttaa
     * Jos ei niin palautetaan false
     * Jos autoon oli varaa ja se ostettiin niin palautetaan true
     * 
     * Kaupan controller antaa näistä kussakin tapauksessa asianmukaisen "popupin" pelaajalle
     * 
     * @param osat
     * @param i
     * @return 
     */
    public boolean ostaVaihdelaatikko(osatJaAutot osat, int i) {
        double hinta = osat.getLaatikko()[i].getHinta();
        if (bank.getSaldo() >= hinta) {
            uusiVaihdelaatikko(osat.getLaatikko()[i]);
//            this.varallisuus -= hinta;
            removeSaldo(hinta);

            return true;
        }
        return false;
    }
    /**
     * Parametrin saadun mukaisen olion arvot kopioidaan ja niillä luodaan uusi olio
     * Olion arvot ovat muuten samat, mutta olion hinta on puolet alkuperäisestä
     * 
     * Kopioidaan osataulu ja kasvatetaan sitä yhdellä ja lisätään juuri luotu olio tauluun
     * 
     * @param stock 
     */
    private void uusiVaihdelaatikko(Vaihdelaatikko stock) {
        Vaihdelaatikko[] temp = new Vaihdelaatikko[getLaatikot().length +1];
        
        System.arraycopy(getLaatikot(), 0, temp, 0, getLaatikot().length);
        temp[temp.length - 1] = new Vaihdelaatikko(stock.getValmistaja(), stock.getNimi(), stock.getKiihtyvyys(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta()/2);
        
        setLaatikot(temp);
    }
    /**
     * Suoritetaan tallien mennessä konkurssiin
     * Suoritetaan myös pelin alussa ModelControl luokasta satunnaisen
     * Alimman sarjatason tallille joka määritellään ModelController
     * Luokan alustaPelaajanTalli metodin toimesta
     * 
     * Tyhjennetään tallikohtaiset oliotaulut
     * Poistetaan tallin omistaja
     * Poistetaan tallin manageri
     * Poistetaan tallin sarjapisteet
     * 
     */
    public void meneKonkurssiin() {
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
        
        for (Jousitus jousi : this.jouset) {
            jousi = null;
        }
        
        for (Renkaat reng : this.renkaat) {
            reng = null;
        }
        
        for (Auto auto : this.autot) {
            auto = null;
        }
        for (Vaihdelaatikko laatikko : this.getLaatikot()) {
            laatikko = null;
        }
        for (Turbo turbo : this.getTurbot()) {
            turbo = null;
        }
        this.setLaatikot(new Vaihdelaatikko[0]);
        this.autot = new Auto[0];
        this.jarrut = new Jarrut[0];
        this.moottorit = new Moottori[0];
        this.jouset = new Jousitus[0];
        this.renkaat = new Renkaat[0];
    }
    /**
     * TODO
     * @param manageri 
     */
    void ostaManageri(Manageri manageri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * TODO
     */
    void ostaMekaanikko() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @return the laatikot
     */
    public Vaihdelaatikko[] getLaatikot() {
        return laatikot;
    }

    /**
     * @param laatikot the laatikot to set
     */
    public void setLaatikot(Vaihdelaatikko[] laatikot) {
        this.laatikot = laatikot;
    }

    /**
     * @return the turbot
     */
    public Turbo[] getTurbot() {
        return turbot;
    }

    /**
     * @param turbot the turbot to set
     */
    public void setTurbot(Turbo[] turbot) {
        this.turbot = turbot;
    }

    /**
     * @return the ykkosauto
     */
    public Auto getYkkosauto() {
        return ykkosauto;
    }

    /**
     * 
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
    
    public void setOmistaja(String nimi, int persoonallisuus) {
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
     * Tätä hyödynnetään myöhemissä versioissa
     * Liittyy kuljettajien ostamiseen toisilta talleilta
     * 
     * TODO
     * 
     * @param kuski
     * @return 
     */
    public boolean hyvaksySiirto(Kuljettaja kuski) {
        if (kuski == this.ykkoskuski) {
            return false;
        } else if (kuski == this.kakkoskuski) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Myös tätä hyödynnetään myöhemissä versioissa
     * Liittyy kuljettajien ostamiseen toisilta talleilta
     * @param kilpailevaManageri
     * @param kuljettaja
     * @return 
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
  
}

