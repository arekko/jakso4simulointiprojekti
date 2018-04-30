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
public class Sopimus {
    private int kesto;
    private double määrä;
    private Talli talli;
    private Sponsori sponssi;
    /**
     * 
     * @param kesto
     * @param määrä 
     */
    public Sopimus(int kesto, double määrä) {
        this.kesto = kesto;
        this.määrä = määrä;
    }
    /**
     * 
     * @return 
     */
    public String haeSopimuspohja() {
        return "";
    }
    /**
     * 
     * @param talli
     * @param sponssi
     * @param kesto 
     */
    public void luoSopimus(Talli talli, Sponsori sponssi, int kesto) {
        this.talli = talli;
        this.sponssi = sponssi;
        this.kesto = kesto;
    }
}