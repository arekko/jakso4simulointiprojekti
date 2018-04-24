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
package maxattak;
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
class Talli {

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

    private String nimi;
    private Kuljettaja ykkoskuski;
    private Kuljettaja kakkoskuski;
    private Sarja tallinSarja;
    private double varallisuus;
    private Sponsori[] sponssit;
    private Sopimus[] sopimukset;
    private int sarjaPisteet;
    private Omistaja omistaja;
    private Manageri manageri;
    private boolean pelaajantalli;
    private Auto[] autot = new Auto[0];
    private Moottori[] moottorit = new Moottori[0];
    private Jarrut[] jarrut = new Jarrut[0];
    private Jousitus[] jouset = new Jousitus[0];
    private Renkaat[] renkaat = new Renkaat[0];
    private Vaihdelaatikko[] laatikot = new Vaihdelaatikko[0];
    private Turbo[] turbot = new Turbo[0];
    private Auto ykkosauto;
    private Auto kakkosauto;

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

    boolean hyvaksySiirto(Kuljettaja kuski) {
        if (kuski == this.ykkoskuski) {
            return false;
        } else if (kuski == this.kakkoskuski) {
            return true;
        } else {
            return false;
        }
    }

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

    boolean tallissaYkkosKuski() {
        if (this.ykkoskuski == null) {
            return false;
        } else {
            return true;
        }
    }

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

    public boolean ostaAuto(osatJaAutot osat, int i) {
        //Auto[] temp = new Auto[this.getAutot().length +1];
        double hinta = osat.getAutot()[i].getHinta();


        if (this.varallisuus >= hinta) {
            
            uusiMoottori(osat.getAutot()[i].getAutonMoottori());
            uudetJarrut(osat.getAutot()[i].getAutonJarrut());
            uudetJouset(osat.getAutot()[i].getAutonJouset());
            uudetRenkaat(osat.getAutot()[i].getAutonRenkaat());
            uusiTurbo(osat.getAutot()[i].getAutonTurbo());
            uusiVaihdelaatikko(osat.getAutot()[i].getAutonLaatikko());
            uusiAuto(osat.getAutot()[i]);
            this.varallisuus -= hinta;
            return true;
        }
        return false;
        
    }
    public void uusiAuto(Auto auto) {
        Auto[] temp = new Auto[getAutot().length +1];
        System.out.println(getAutot().length);
        for (int i = 0; i < getAutot().length;i++) {
            temp[i] = getAutot()[i];
        }
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

    void ostaManageri(Manageri manageri) {
        
    }

    void ostaMekaanikko() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void uusiTurbo(Turbo stock) {
        Turbo[] temp = new Turbo[getTurbot().length +1];
        
        for (int tu = 0; tu < getTurbot().length; tu++) {
            temp[tu] = getTurbot()[tu];
        }
        temp[temp.length - 1] = new Turbo(stock.getValmistaja(), stock.getNimi(), stock.getKiihtyvyys(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta()/2);
        
        setTurbot(temp);
    }

    private void uusiVaihdelaatikko(Vaihdelaatikko stock) {
        Vaihdelaatikko[] temp = new Vaihdelaatikko[getLaatikot().length +1];
        
        for (int va = 0; va < getLaatikot().length; va++) {
            temp[va] = getLaatikot()[va];
        }
        temp[temp.length - 1] = new Vaihdelaatikko(stock.getValmistaja(), stock.getNimi(), stock.getKiihtyvyys(), stock.getMassa(), stock.getOsaKategoria(), stock.getHinta()/2);
        
        setLaatikot(temp);
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

  
}
/*
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
*/