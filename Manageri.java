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
import java.util.Random;
/**
 * Manageriluokan olion hallintaa suunniteltu luokka.
 * @author Jani
 */
public class Manageri {
    private Random ra = new Random();
    private String nimi;
    private Talli talli;
    private int neuvotteluTaito;
    private double hankintaHinta;
    private double palkka;
    
    /**
     * Manageriolion luonti asetetaan parametrin mukaiset arvot uudelle managerilleoliolle ja
     * kutsutaan laskePalkka() metodia, joka laskee managerille palkan pohjautuen Manageriolion neuvotteletaitoon.
     * @param nimi Managerioliolle asetettava nimi.
     * @param taito Managerioliolle asetettava neuvottelutaito.
     */
    Manageri(String nimi, int taito) {
        this.nimi = nimi;
        //this.talli = kontti.getVapaat();
        this.neuvotteluTaito = taito;
        laskePalkka();
    }
  
    /**
     * 
     */
    private void laskePalkka() {
        double pohjapalkka = 200;
        if (this.getPalkka() == 0) {
            pohjapalkka = pohjapalkka+(pohjapalkka*this.getNeuvotteluTaito());
        } else {
            this.setPalkka(this.getPalkka() + (pohjapalkka/4) * this.getNeuvotteluTaito());
        }
        
    }

  /**
     * 
     * @return Palauttaa manageriolion 
     */
    public int getNeuvottelutaito() {
        return this.getNeuvotteluTaito();
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
     * @return the neuvotteluTaito
     */
    public int getNeuvotteluTaito() {
        return neuvotteluTaito;
    }

    /**
     * @param neuvotteluTaito the neuvotteluTaito to set
     */
    public void setNeuvotteluTaito(int neuvotteluTaito) {
        this.neuvotteluTaito = neuvotteluTaito;
    }

    /**
     * @return the hankintaHinta
     */
    public double getHankintaHinta() {
        return hankintaHinta;
    }

    /**
     * @param hankintaHinta the hankintaHinta to set
     */
    public void setHankintaHinta(double hankintaHinta) {
        this.hankintaHinta = hankintaHinta;
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
     * 
     */
    public void levelUp() {
        if(ra.nextInt(10) > 7) {
            this.setNeuvotteluTaito(this.getNeuvotteluTaito() + 1);
            manageriKasvattiTaitoja();
        }
    }
      /**
     * 
     * @return 
     */
    private String manageriKasvattiTaitoja() {
        return "Manageri "+this.getNimi()+" saavutti uuden neuvottelutaitotason("+this.getNeuvotteluTaito()+")";
    }
    
}
