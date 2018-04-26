/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak;

/**
 *
 * @author Jani
 */
public class Vaihdelaatikko {
    private String valmistaja;
    private String nimi;
    private double kiihtyvyys;
    private double massa;
    private double hinta;
    private int kunto;
    private int osaKategoria;
    /**
     * 
     * @param val
     * @param nim
     * @param acc
     * @param pai
     * @param kat
     * @param hint 
     */
    Vaihdelaatikko(String val, String nim, double acc, double pai, int kat, double hint) {
        this.valmistaja = val;
        this.nimi = nim;
        this.kiihtyvyys = acc;
        this.massa = pai;
        this.osaKategoria = kat;
        this.hinta = hint;
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
     * @return the kiihtyvyys
     */
    public double getKiihtyvyys() {
        return kiihtyvyys;
    }

    /**
     * @param kiihtyvyys the kiihtyvyys to set
     */
    public void setKiihtyvyys(double kiihtyvyys) {
        this.kiihtyvyys = kiihtyvyys;
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
}