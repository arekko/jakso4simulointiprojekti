/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak.Model;

/**
 *
 * @author Jani
 */
public class Turbo {
    private String valmistaja;
    private String nimi;
    private double kiihtyvyys;
    private double massa;
    private double hinta;
    private int osaKategoria;
    private int kunto;
    /**
     * 
     * @param val
     * @param nimi
     * @param kiihtyvyys
     * @param massa
     * @param kat
     * @param hin 
     */
    Turbo(String val, String nimi, double kiihtyvyys, double massa, int kat, double hin) {
        this.valmistaja = val;
        this.nimi = nimi;
        this.kiihtyvyys = kiihtyvyys;
        this.massa = massa;
        this.osaKategoria = kat;
        this.hinta = hin;
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