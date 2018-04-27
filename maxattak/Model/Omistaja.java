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
public class Omistaja {

    private String nimi;
    private int persoonallisuus;
    private int pelaaja;
    /**
     * 
     * @param nimi
     * @param persoonallisuus 
     */
    public Omistaja(String nimi, int persoonallisuus) {
        this.nimi = nimi;
        this.persoonallisuus = persoonallisuus;
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
     * @return the persoonallisuus
     */
    public int getPersoonallisuus() {
        return persoonallisuus;
    }

    /**
     * @param persoonallisuus the persoonallisuus to set
     */
    public void setPersoonallisuus(int persoonallisuus) {
        this.persoonallisuus = persoonallisuus;
    }

    /**
     * @return the pelaaja
     */
    public int getPelaaja() {
        return pelaaja;
    }

    /**
     * @param pelaaja the pelaaja to set
     */
    public void setPelaaja(int pelaaja) {
        this.pelaaja = pelaaja;
    }
    
}
