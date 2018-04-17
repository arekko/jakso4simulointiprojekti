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
package rallimeister5000;
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
class Kuljettaja {
    
    private String nimi;
    private String kansalaisuus;
    private int ajoTaito;
    private int mediaTaito;
    private int sarjaPisteet;
    private int kokemus;
    private double palkka;
    private Talli talli;
    private double siirtohinta;
    private int sopimuksenKesto;
    
    Kuljettaja(String nimi, String kansalaisuus, int ajotaito, int mediataito, int kokemus, int sopimuksenkesto, Talli talli) {
        /*
            Luodaan uusi kuljettaja olio ja kutsutaan metodia joka laskee kuljettajan palkan taitojen ja kokemuksen mukaan
            Mediataidon maksimi arvo on 10 ja ajotaidon maksimi arvo on 10
        */
        this.nimi = nimi;
        this.kansalaisuus = kansalaisuus;
        if (ajotaito <= 10) {
            this.ajoTaito = ajotaito;
        } else {
            this.ajoTaito = 10;
        }
        if (mediataito <= 10) {
            this.mediaTaito = mediataito;
        } else {
            this.mediaTaito = 10;
        }
        this.kokemus = kokemus;
        this.sopimuksenKesto = sopimuksenkesto;
        laskePalkka();
    }

    public void addKuskinpisteet(int pisteet) {
        /*
            Kasvatetaan kuljettajan henkilökohtaisia pisteitä
        */
        this.setSarjaPisteet(this.getSarjaPisteet() + pisteet);
    }

    public void addKuskinkokemus() {
        /*
            Joka kisan jälkeen kasvatetaan kuskin kokemusta ja kutsutaan metodia saaPalkkaa joka
            veloittaa tallilta kuskin palkan verran rahaa
        */
        this.setKokemus(this.getKokemus() + 1);
        saaPalkkaa();
    }

    private void saaPalkkaa() {
        /*
            Veloittaa tallilta kuskin palkan verran rahaa
        */
        this.getTalli().maksaPalkkaa(this.getPalkka());
    }
    public void uusiKausi() {
        /*
            Kun uusi kausi alkaa niin kuljettajan sarjapisteet nollataan
        */
        this.setSarjaPisteet(0);
    }
    public boolean ostaKuljettaja(Talli talli) {
        /*
            Kuljettajan ostaminen toiselta tallilta
        */
        double hinta = talli.neuvottele(this.talli.getManageri(), this);
        if (talli.getVarallisuus() >= hinta && this.talli.hyvaksySiirto(this) == true) {
            this.getTalli().addVarallisuus(hinta);
            talli.removeVarallisuus(hinta);
            this.setTalli(talli);
            return true;
        } else {
            return false;
        }
    }

    private void laskePalkka() {
        /*
            Laskee kuljettajan palkan
        */
        double pohjaPalkka = 500.0;
        pohjaPalkka = pohjaPalkka+(((pohjaPalkka / 10)*this.getKokemus()) + ((pohjaPalkka/2)*this.getAjoTaito())+((pohjaPalkka/2)*this.getMediaTaito()));
        this.setPalkka(pohjaPalkka);
        laskeSiirtohinta();
    }

    private void laskeSiirtohinta() {
        /*
            Laskee kuljettajan siirtohinnan
        */
        this.setSiirtohinta(this.getPalkka() * 3.5);
    }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return the kansalaisuus
     */
    public String getKansalaisuus() {
        return kansalaisuus;
    }

    /**
     * @param kansalaisuus the kansalaisuus to set
     */
    public void setKansalaisuus(String kansalaisuus) {
        this.kansalaisuus = kansalaisuus;
    }

    /**
     * @return the ajoTaito
     */
    public int getAjoTaito() {
        return ajoTaito;
    }

    /**
     * @param ajoTaito the ajoTaito to set
     */
    public void setAjoTaito(int ajoTaito) {
        this.ajoTaito = ajoTaito;
        laskePalkka();
    }

    /**
     * @return the mediaTaito
     */
    public int getMediaTaito() {
        return mediaTaito;
    }

    /**
     * @param mediaTaito the mediaTaito to set
     */
    public void setMediaTaito(int mediaTaito) {
        this.mediaTaito = mediaTaito;
        laskePalkka();
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

    /**
     * @return the kokemus
     */
    public int getKokemus() {
        return kokemus;
    }

    /**
     * @param kokemus the kokemus to set
     */
    public void setKokemus(int kokemus) {
        this.kokemus = kokemus;
        laskePalkka();
    }

    /**
     * @return the palkka
     */
    public double getPalkka() {
        return palkka;
    }

    /**
     * @param palkka the palkka to set
     */
    public void setPalkka(double palkka) {
        this.palkka = palkka;
    }

    /**
     * @return the talli
     */
    public Talli getTalli() {
        return talli;
    }

    /**
     * @param talli the talli to set
     */
    public void setTalli(Talli talli) {
        this.talli = talli;
    }

    /**
     * @return the siirtohinta
     */
    public double getSiirtohinta() {
        return siirtohinta;
    }

    /**
     * @param siirtohinta the siirtohinta to set
     */
    public void setSiirtohinta(double siirtohinta) {
        this.siirtohinta = siirtohinta;
    }
    
}
