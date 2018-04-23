/*
 * Copyright (C) 2018 
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


class Radat {
    private int[][] rata = new int[10][10];
    private double pituus;
    private double kitka;
    private double keli;

    /**
     * @return the pituus
     */
    public double getPituus() {
        return pituus;
    }

    /**
     * @param pituus the pituus to set
     */
    public void setPituus(double pituus) {
        this.pituus = pituus;
    }

    /**
     * @return the kitka
     */
    public double getKitka() {
        return kitka;
    }

    /**
     * @param kitka the kitka to set
     */
    public void setKitka(double kitka) {
        this.kitka = kitka;
    }

    /**
     * @return the keli
     */
    public double getKeli() {
        return keli;
    }

    /**
     * @param keli the keli to set
     */
    public void setKeli(double keli) {
        this.keli = keli;
    }
}
