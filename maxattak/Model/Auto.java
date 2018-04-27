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
 * Auto luokka auto olioiden hallintaan.
 * Auto luokan olioita luodaan peliin tarveperusteisesti ja niiden määrällä ei ole ylärajaa.
 * Luokasta puuttuu toiminallisuutta....
 * 
 */
public class Auto {
    private final String merkki;
    private final String malli;
    private double omaMassa;
    private double massa;
    private double pito;
    private double jarruteho;
    private double teho;
    private double hinta;
    private Moottori autonMoottori;
    private Jarrut autonJarrut;
    private Jousitus autonJouset;
    private Renkaat autonRenkaat;
    private Vaihdelaatikko autonLaatikko;
    private Turbo autonTurbo;
    private int kunto;
    
    /**
     * Luodaan uusi auto olio jolle asetetaan Merkki, Malli, Oma paino, Moottori, Jarrut, Jousitus, Renkaat, Vaihdelaatikko, Turbo, Hinta
     * Asetetaan kaikkien osien kunnoksi ja auton kunnoksi 100.
     * Kutsuu metodia setMassa laskee auton massan.
     * @param merkki Auton merkki.
     * @param malli Auton malli.
     * @param omapaino Auton oma massa.
     * @param moottori Auton moottori, Moottori luokan olio.
     * @param jarrut Auton jarrut, Jarrut luokan olio.
     * @param jousitus Auton jousitus, Jousitus luokan olio.
     * @param renkaat Auton renkaat, Renkaat luokan olio.
     * @param laatikko Auton vaihdelaatikko, Vaihdelaatikko luokan olio.
     * @param turbo Auton turbo, Turbo luokan olio.
     * @param hinta Auton hinta.
     *
     */
    public Auto(String merkki, String malli, double omapaino, Moottori moottori, Jarrut jarrut, Jousitus jousitus, Renkaat renkaat, Vaihdelaatikko laatikko, Turbo turbo, double hinta) {
        this.merkki = merkki;
        this.malli = malli;
        this.omaMassa = omapaino;
        this.autonMoottori = moottori;
        this.autonJarrut = jarrut;
        this.autonJouset = jousitus;
        this.autonRenkaat = renkaat;
        this.autonLaatikko = laatikko;
        this.autonTurbo = turbo;
        this.hinta = hinta;
        
        this.autonMoottori.setKunto(100);
        this.autonJarrut.setKunto(100);
        this.autonJouset.setKunto(100);
        this.autonRenkaat.setKunto(100);
        this.autonLaatikko.setKunto(100);
        this.autonTurbo.setKunto(100);
        this.kunto = 100;
        setMassa();
    }

    /**
     * @return Palauttaa auton merkin.
     */
    public String getMerkki() {
        return merkki;
    }

    /**
     * @return Palauttaa auton mallin.
     */
    public String getMalli() {
        return malli;
    }

    /**
     * @return Palauttaa auton oman massan.
     */
    public double getOmaMassa() {
        return omaMassa;
    }

    /**
     * @param omaMassa Asettaa auton oman massan.
     */
    public void setOmaMassa(double omaMassa) {
        this.omaMassa = omaMassa;
    }

    /**
     * @return Palauttaa auton kokonaismassan, jossa on huomioituna myös auton osien paino.
     */
    public double getMassa() {
        return massa;
    }

    /**
     * Laskee auton kokonaismassan perustuen auton omaan massaan ja osien massaan.
     */
    public void setMassa() {
        this.massa = this.massa+this.autonJarrut.getMassa()+this.autonJouset.getMassa()+this.autonMoottori.getMassa()+this.autonRenkaat.getMassa();
    }

    /**
     * @return Palauttaa auton pidon.
     */
    public double getPito() {
        return pito;
    }

    /**
     * @param pito Asettaa auton pidon.
     */
    public void setPito(double pito) {
        this.pito = pito;
    }

    /**
     * @return Palauttaa auton jarrutehon.
     */
    public double getJarruteho() {
        return jarruteho;
    }

    /**
     * @param jarruteho Asettaa auton jarrutehon.
     */
    public void setJarruteho(double jarruteho) {
        this.jarruteho = jarruteho;
    }

    /**
     * @return Palauttaa auton tehon.
     */
    public double getTeho() {
        return teho;
    }

    /**
     * @param teho Asettaa auton tehon.
     */
    public void setTeho(double teho) {
        this.teho = teho;
    }

    /**
     * @return Palauttaa auton hinnan.
     */
    public double getHinta() {
        return hinta;
    }

    /**
     * @param hinta Asettaa auton hinnan.
     */
    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    /**
     * @return Palauttaa auton moottoriolion.
     */
    public Moottori getAutonMoottori() {
        return autonMoottori;
    }

    /**
     * @param autonMoottori Asettaa autolle moottoriolion.
     */
    public void setAutonMoottori(Moottori autonMoottori) {
        this.autonMoottori = autonMoottori;
    }

    /**
     * @return Palauttaa auton jarruolion.
     */
    public Jarrut getAutonJarrut() {
        return autonJarrut;
    }

    /**
     * @param autonJarrut Asettaa autolle jarruolion.
     */
    public void setAutonJarrut(Jarrut autonJarrut) {
        this.autonJarrut = autonJarrut;
    }

    /**
     * @return Palauttaa auton jousitusolion.
     */
    public Jousitus getAutonJouset() {
        return autonJouset;
    }

    /**
     * @param autonJouset Asettaa autolle jousitusolion.
     */
    public void setAutonJouset(Jousitus autonJouset) {
        this.autonJouset = autonJouset;
    }

    /**
     * @return Palauttaa auton renkaatolion.
     */
    public Renkaat getAutonRenkaat() {
        return autonRenkaat;
    }

    /**
     * @param autonRenkaat Asettaa auton renkaatolion.
     */
    public void setAutonRenkaat(Renkaat autonRenkaat) {
        this.autonRenkaat = autonRenkaat;
    }

    /**
     * @return Palauttaa auton vaihdelaatikko-olio
     */
    public Vaihdelaatikko getAutonLaatikko() {
        return autonLaatikko;
    }

    /**
     * @param autonLaatikko Asettaa autolle vaihdelaatikko-olion.
     */
    public void setAutonLaatikko(Vaihdelaatikko autonLaatikko) {
        this.autonLaatikko = autonLaatikko;
    }

    /**
     * @return the autonTurbo
     * @return Palauttaa auton turbo-olion.
     */
    public Turbo getAutonTurbo() {
        return autonTurbo;
    }

    /**
     * @param autonTurbo the autonTurbo to set
     * @param autonTurbo Asettaa autolle turbo-olion.
     */
    public void setAutonTurbo(Turbo autonTurbo) {
        this.autonTurbo = autonTurbo;
    }
    
    
}
