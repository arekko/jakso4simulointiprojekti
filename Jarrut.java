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
class Jarrut {
    
    private String valmistaja;
    private String nimi;
    private double jarruteho;
    private double massa;
    private double hinta;
    private int osaKategoria;
    private int kunto;
    
    Jarrut(String valmistaja, String nimi, double teho, double paino, int kategoria, double hinta) {
        this.valmistaja = valmistaja;
        this.nimi = nimi;
        this.jarruteho = teho;
        this.massa = paino;
        this.hinta = hinta;
        this.osaKategoria = 5;
    }

    /**
     * @return the valmistaja
     */
    public String getValmistaja() {
        return valmistaja;
    }

    /**
     * @param valmistaja the valmistaja to set
     */
    public void setValmistaja(String valmistaja) {
        this.valmistaja = valmistaja;
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
     * @return the massa
     */
    public double getMassa() {
        return massa;
    }

    /**
     * @param massa the massa to set
     */
    public void setMassa(double massa) {
        this.massa = massa;
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
     * @return the osaKategoria
     */
    public int getOsaKategoria() {
        return osaKategoria;
    }

    /**
     * @param osaKategoria the osaKategoria to set
     */
    public void setOsaKategoria(int osaKategoria) {
        this.osaKategoria = osaKategoria;
    }

    /**
     * @return the kunto
     */
    public int getKunto() {
        return kunto;
    }

    /**
     * @param kunto the kunto to set
     */
    public void setKunto(int kunto) {
        this.kunto = kunto;
    }

   
}
