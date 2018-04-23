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
class Laina {
    
    private double korko;
    private double määrä;
    private int maksuAika;
    private Talli talli;
    
    Laina(Talli talli, double määrä) {
       this.talli = talli;
       this.määrä = määrä;
       this.maksuAika = 0; // To-do
       this.korko = 0; // To-do;
    }
    public String lainanTiedot() {
       
        return "";
    }
    public void kasvaKorkoa() {
        this.määrä = this.määrä + (this.määrä*korko);
    }
    public void maksaLainaa(double määrä) {
        if (this.määrä > määrä) {
            this.määrä -= määrä;
        } else if (this.määrä < määrä) {
            double temp = this.määrä;
            this.määrä = määrä - temp;
            määrä = määrä - temp;
            palautaRahaa(määrä);
        }
        this.määrä -= määrä;
    }
    public void vähennäMaksuaikaa() {
        this.maksuAika--;
    }

    private double palautaRahaa(double määrä) {
        return määrä;
    }
    
}
