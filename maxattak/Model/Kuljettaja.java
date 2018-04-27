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
public class Kuljettaja {
    
    //Kuljettaja olion nimi
    private String nimi;
    //Kuljettaja olion kansalaisuus
    private String kansalaisuus;
    //Kuljettaja olion ajotaito
    private int ajoTaito;
    //Kuljettaja olion mediataito
    private int mediaTaito;
    //Kuljettaja olion sarjapisteet (henkilökohtaiset pisteet, jotka yksilövoittoihin)
    private int sarjaPisteet;
    //Kuljettaja olion kokemus
    private int kokemus;
    //Kuljettaja olion palkka, asetetaan metodilla laskePalkka() jota kutsutaan constructorissa
    private double palkka;
    //Kuljettaja olion talli(olio)
    private Talli talli;
    //Kuljettajan siirtohinta (jos kuljettaja halutaan ostaa toisen tallin toimesta), lasketaan metodissa laskesiirtohinta
    //Jota laskePalkka() metodissa.
    private double siirtohinta;
    //Kuljettajan sopimuskauden kesto (kilpailua)
    private int sopimuksenKesto;
    
    /**
     * Luodaan uusi Kuljettaja olio ja jos parametrina saatu ajotaito tai mediataito
     * ylittää 10 niin kyseiset arvot asetetaan 10
     * Kutsutaan laskePalkka() metodia joka Kuljettajan kokemuksen ja taitojen
     * perusteella laskee kuljettajalle palkan
     * 
     * @param nimi, kuljettajalle asetettava nimi
     * @param kansalaisuus, kuljettajalle asetettava kansalaisuus
     * @param ajotaito, kuljettajalle asetettava ajotaito
     * @param mediataito, kuljettajalle asetettava mediataito
     * @param kokemus, kuljettajalle asetettava kokemus
     * @param sopimuksenkesto, kuljettajalle asetettava sopimuksen kesto
     * @param talli, kuljettajalle asetettava talli
     */
    public Kuljettaja(String nimi, String kansalaisuus, int ajotaito, int mediataito, int kokemus, int sopimuksenkesto, Talli talli) {
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
    /**
     * Lisää kuljettajalle pisteet
     * @param pisteet, kuljettajalle lisättävät pisteet
     */
    public void addKuskinpisteet(int pisteet) {
        this.setSarjaPisteet(this.getSarjaPisteet() + pisteet);
    }
    /**
     * Kartuttaan kuljettajat kokemusta yhdellä.
     * Kutsuu saaPalkkaa() metodia
     */
    public void addKuskinkokemus() {
        this.setKokemus(this.getKokemus() + 1);
        saaPalkkaa();
    }
    /**
     * Vähentää Kuljettajan tallin varallisuutta Kuljettajan palkan verran
     */
    private void saaPalkkaa() {
        getTalli().removeVarallisuus(this.getPalkka());
    }
    /**
     * Uuden kisakauden alkaessa kutsuttava metodi joka nollaa Kuljettajan sarjapisteet
     */
    public void uusiKausi() {
        this.setSarjaPisteet(0);
    }
  
    /**
     * Laskee kuljettajan palkan pohjautuen kuljettajan kokemukseen, ajotaitoon ja mediataitoo
     * 
     */
    private void laskePalkka() {
        double pohjaPalkka = 500.0;
        pohjaPalkka = pohjaPalkka+(((pohjaPalkka / 10)*this.getKokemus()) + ((pohjaPalkka/2)*this.getAjoTaito())+((pohjaPalkka/2)*this.getMediaTaito()));
        this.setPalkka(pohjaPalkka);
        laskeSiirtohinta();
    }
    /**
     * Laskee kuljettajan siirtohinnan
     */
    private void laskeSiirtohinta() {
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
      /**
     * 
     * @param talli on kilpaileva talli joka koittaa hankkia kuljettajaa omiin riveihinsä
     * @return määrittelee ostetaanko kuljettaja vai ei
     *
     * Tämä metodi on keskeneräinen ja sitä täydennetään myöhemmissä versioissa
     * 
     */
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
}
