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
class Auto {
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
    
    
    Auto(String merkki, String malli, double omapaino, Moottori moottori, Jarrut jarrut, Jousitus jousitus, Renkaat renkaat, Vaihdelaatikko laatikko, Turbo turbo, double hinta) {
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
        
    }

    /**
     * @return the merkki
     */
    public String getMerkki() {
        return merkki;
    }

    /**
     * @return the malli
     */
    public String getMalli() {
        return malli;
    }

    /**
     * @return the omaMassa
     */
    public double getOmaMassa() {
        return omaMassa;
    }

    /**
     * @param omaMassa the omaMassa to set
     */
    public void setOmaMassa(double omaMassa) {
        this.omaMassa = omaMassa;
    }

    /**
     * @return the massa
     */
    public double getMassa() {
        return massa;
    }

    /**
     * @param massa the massa to set
     */
    public void setMassa() {
        this.massa = this.massa+this.autonJarrut.getMassa()+this.autonJouset.getMassa()+this.autonMoottori.getMassa()+this.autonRenkaat.getMassa();
    }

    /**
     * @return the pito
     */
    public double getPito() {
        return pito;
    }

    /**
     * @param pito the pito to set
     */
    public void setPito(double pito) {
        this.pito = pito;
    }

    /**
     * @return the jarruteho
     */
    public double getJarruteho() {
        return jarruteho;
    }

    /**
     * @param jarruteho the jarruteho to set
     */
    public void setJarruteho(double jarruteho) {
        this.jarruteho = jarruteho;
    }

    /**
     * @return the teho
     */
    public double getTeho() {
        return teho;
    }

    /**
     * @param teho the teho to set
     */
    public void setTeho(double teho) {
        this.teho = teho;
    }

    /**
     * @return the hinta
     */
    public double getHinta() {
        return hinta;
    }

    /**
     * @param hinta the hinta to set
     */
    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    /**
     * @return the autonMoottori
     */
    public Moottori getAutonMoottori() {
        return autonMoottori;
    }

    /**
     * @param autonMoottori the autonMoottori to set
     */
    public void setAutonMoottori(Moottori autonMoottori) {
        this.autonMoottori = autonMoottori;
    }

    /**
     * @return the autonJarrut
     */
    public Jarrut getAutonJarrut() {
        return autonJarrut;
    }

    /**
     * @param autonJarrut the autonJarrut to set
     */
    public void setAutonJarrut(Jarrut autonJarrut) {
        this.autonJarrut = autonJarrut;
    }

    /**
     * @return the autonJouset
     */
    public Jousitus getAutonJouset() {
        return autonJouset;
    }

    /**
     * @param autonJouset the autonJouset to set
     */
    public void setAutonJouset(Jousitus autonJouset) {
        this.autonJouset = autonJouset;
    }

    /**
     * @return the autonRenkaat
     */
    public Renkaat getAutonRenkaat() {
        return autonRenkaat;
    }

    /**
     * @param autonRenkaat the autonRenkaat to set
     */
    public void setAutonRenkaat(Renkaat autonRenkaat) {
        this.autonRenkaat = autonRenkaat;
    }

    /**
     * @return the autonLaatikko
     */
    public Vaihdelaatikko getAutonLaatikko() {
        return autonLaatikko;
    }

    /**
     * @param autonLaatikko the autonLaatikko to set
     */
    public void setAutonLaatikko(Vaihdelaatikko autonLaatikko) {
        this.autonLaatikko = autonLaatikko;
    }

    /**
     * @return the autonTurbo
     */
    public Turbo getAutonTurbo() {
        return autonTurbo;
    }

    /**
     * @param autonTurbo the autonTurbo to set
     */
    public void setAutonTurbo(Turbo autonTurbo) {
        this.autonTurbo = autonTurbo;
    }
    
    
}
