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
public class Jarrut {
    
    private String valmistaja;
    private String nimi;
    private double jarruteho;
    private double massa;
    private double hinta;
    private int osaKategoria;
    private int kunto;
    
    /**
     * 
     * @param valmistaja Jarrujen valmistaja, String tyyppinen tunnistetieto. Asetetaan kyseisen jarruolion valmistajaksi.
     * @param nimi Jarrujen nimi, String tyyppinen tunnistetieto. Asetetaan kyseisen jarruolion nimeksi.
     * @param teho Kyseisen jarruolion jarruteho, double tyyppinen muuttuja, jota käytetään laskutoimituksiin.
     * @param paino Kyseisen jarruolion massa, double tyyppinen muuttuja, joka otetaan huomioon Auto-olion kokonaismassan laskennassa.
     * @param kategoria Kyseisen jarruolion osakategoria, osakategoria määrittää osien yhteensopivuuden Auto-olion kanssa.
     * @param hinta  Kyseisen jarruolion hinta, määrittelee ostohinnan / myyntihinnan.
     */
    public Jarrut(String valmistaja, String nimi, double teho, double paino, int kategoria, double hinta) {
        this.valmistaja = valmistaja;
        this.nimi = nimi;
        this.jarruteho = teho;
        this.massa = paino;
        this.hinta = hinta;
        this.osaKategoria = 5;
    }

    /**
     * @return Palauttaa jarruolion valmistajan.
     */
    public String getValmistaja() {
        return valmistaja;
    }

    /**
     * @param valmistaja Asettaa jarruoliolle valmistajan.
     */
    public void setValmistaja(String valmistaja) {
        this.valmistaja = valmistaja;
    }

    /**
     * @return Palauttaa jarruolion nimen.
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi Asettaa jarruoliolle nimen.
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return Palauttaa jarruolion jarrutehon.
     */
    public double getJarruteho() {
        return jarruteho;
    }

    /**
     * @param jarruteho Asettaa jarruolion jarrutehon.
     */
    public void setJarruteho(double jarruteho) {
        this.jarruteho = jarruteho;
    }

    /**
     * @return Palauttaa jarruolion massan.
     */
    public double getMassa() {
        return massa;
    }

    /**
     * @param massa Asettaa jarruoliolle massan.
     */
    public void setMassa(double massa) {
        this.massa = massa;
    }

    /**
     * @return Palauttaa jarruolion hinnan.
     */
    public double getHinta() {
        return hinta;
    }

    /**
     * @param hinta Asettaa jarruoliolle hinnan.
     */
    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    /**
     * @return Palauttaa jarruolion osakategorian.
     */
    public int getOsaKategoria() {
        return osaKategoria;
    }

    /**
     * @param osaKategoria Asettaa jarruoliolle osakategorian.
     */
    public void setOsaKategoria(int osaKategoria) {
        this.osaKategoria = osaKategoria;
    }

    /**
     * @return Palauttaa jarruolion kunnon.
     */
    public int getKunto() {
        return kunto;
    }

    /**
     * @param kunto Asettaa jarruoliolle kunnon.
     */
    public void setKunto(int kunto) {
        this.kunto = kunto;
    }

   
}
