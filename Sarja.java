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
class Sarja {
    private String nimi;
    private int sarjaTaso;
    private double lisenssi;
    private double[] palkintoRahat = new double[3];
    private Talli[] tallit;
    private int kisojaJäljellä;
    private Radat[] sarjanRadat;
    
    Sarja(String nimi, int taso) {
        this.nimi = nimi;
        this.sarjaTaso = taso;
        if (this.sarjaTaso == 1) {
            this.lisenssi = 2000;
        } else {
            this.lisenssi = 2*sarjaTaso*500;
        }
        this.palkintoRahat[0] = this.lisenssi/10;
        this.palkintoRahat[1] = this.palkintoRahat[0] / 2;
        this.palkintoRahat[2] = this.palkintoRahat[0] / 3;
        
        
        
        this.kisojaJäljellä = 10;
        tallit = new Talli[1];
    }
    public void sijoituPisteille (Talli talli, Kuljettaja kuski, int sija) {
        if (sija == 1) {
            talli.addSarjaPisteet(10);
            kuski.addKuskinpisteet(10);
            kuski.addKuskinkokemus();
            talli.addVarallisuus(this.getPalkintoRahat()[0]);
        } else if (sija == 2) {
            talli.addSarjaPisteet(8);
            kuski.addKuskinpisteet(8);
            kuski.addKuskinkokemus();
            talli.addVarallisuus(this.getPalkintoRahat()[1]);
        } else if (sija == 3) {
            talli.addSarjaPisteet(6);
            kuski.addKuskinpisteet(6);
            kuski.addKuskinkokemus();
            talli.addVarallisuus(this.getPalkintoRahat()[2]);
        } else if (sija == 4) {
            talli.addSarjaPisteet(4);
            kuski.addKuskinpisteet(4);
            kuski.addKuskinkokemus();     
        } else if (sija == 5) {
            talli.addSarjaPisteet(2);
            kuski.addKuskinpisteet(2);
            kuski.addKuskinkokemus();
        } else {
            kuski.addKuskinkokemus();
        }
    }
    public void lisaaTalli(Talli talli) { 
        if (this.tallit.length == 1) {
            tallit = new Talli[2];
            this.tallit[0] = talli;
        } else if (this.tallit.length < 4) {
            Talli[] temp = new Talli[tallit.length+1];
            for (int i = 0; i < tallit.length;i++) {
                temp[i] = tallit[i];
            }
            temp[tallit.length-1] = talli;
            
            tallit = temp;
        } else if (this.tallit.length == 4) {
            tallit[tallit.length-1] = talli;
        }
    }
    public boolean sarjassaTilaa () {
        if (this.tallit.length < 4) {
            return true;
        } else if (this.tallit[3] == null) {
            return true;
        }  else {
            return false;
        }
    }
    public Talli[] getTallit() {
        return this.tallit;
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
     * @return the sarjaTaso
     */
    public int getSarjaTaso() {
        return sarjaTaso;
    }

    /**
     * @param sarjaTaso the sarjaTaso to set
     */
    public void setSarjaTaso(int sarjaTaso) {
        this.sarjaTaso = sarjaTaso;
    }

    /**
     * @return the lisenssi
     */
    public double getLisenssi() {
        return lisenssi;
    }

    /**
     * @param lisenssi the lisenssi to set
     */
    public void setLisenssi(double lisenssi) {
        this.lisenssi = lisenssi;
    }

    /**
     * @return the palkintoRahat
     */
    public double[] getPalkintoRahat() {
        return palkintoRahat;
    }

    /**
     * @param palkintoRahat the palkintoRahat to set
     */
    public void setPalkintoRahat(double[] palkintoRahat) {
        this.palkintoRahat = palkintoRahat;
    }

    /**
     * @param tallit the tallit to set
     */
    public void setTallit(Talli[] tallit) {
        this.tallit = tallit;
    }

    /**
     * @return the kisojaJäljellä
     */
    public int getKisojaJäljellä() {
        return kisojaJäljellä;
    }

    /**
     * @param kisojaJäljellä the kisojaJäljellä to set
     */
    public void setKisojaJäljellä(int kisojaJäljellä) {
        this.kisojaJäljellä = kisojaJäljellä;
    }

    /**
     * @return the sarjanRadat
     */
    public Radat[] getSarjanRadat() {
        return sarjanRadat;
    }

    /**
     * @param sarjanRadat the sarjanRadat to set
     */
    public void setSarjanRadat(Radat[] sarjanRadat) {
        this.sarjanRadat = sarjanRadat;
    }
}
