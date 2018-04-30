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
class Laina {
    
    private double korko;
    private double velka;
    private double budjetti ;

    private Talli talli;
    
    Laina() {
       this.korko = 0.10;
       this.budjetti = 50000;
       this.velka = 0;
    }
    public String lainanTiedot() {
       
        return "";
    }
    public double kasvaKorkoa( double määrä) {
        return määrä + (määrä * korko);
    }

    public void maksaLainaa(double maksuMäärä) {
        this.velka = velka - maksuMäärä;
        addBudjetti(maksuMäärä);
    }

    public void ottaaLainaa( double määrä){
        removeBudjetti(määrä);
        this.velka += kasvaKorkoa(määrä);
    }

    public double getLainanMäärä() {
        return this.velka;
    }

    public double getKorko(){
        return this.korko;
    }
    public double getBudjetti() {
        return this.budjetti;
    }
    public void setBudjetti(double budjetti) {
        this.budjetti = budjetti;
    }

    public void addBudjetti(double määrä){
        budjetti = budjetti + määrä;
    }
    public void removeBudjetti(double määrä){
        budjetti = budjetti - määrä;
    }

}

