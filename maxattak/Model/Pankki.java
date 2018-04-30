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
public class Pankki {
    
//    private String tilinumero;
    private double saldo;
    private boolean lainaHaettu;
    private Laina laina = new Laina();


    public Pankki(double saldo){
        this.saldo = saldo;
        this.lainaHaettu = false;
    }

    public boolean getLainahaettu(){
        return this.lainaHaettu;
    }

    public void setLainaHaettu(boolean lainaHaettu) {
        this.lainaHaettu = lainaHaettu;
    }

    public String lainaTiedustelu() {
        return "";
    }

    public void getLaina( double määrä){
        this.saldo += määrä;
        setLainaHaettu(true);
        laina.ottaaLainaa(määrä);
    }
    public void maksaaLaina(double määrä){
        laina.maksaLainaa(määrä);
        saldo -= määrä;
    }
    public double getVelka(){
        return laina.getLainanMäärä();
    }
    public double getKorko(){
        return laina.getKorko();
    }

    public Double getSaldo(){
        return this.saldo;
    }
    public void setSaldo( double saldo ){
        this.saldo = saldo;
    }
    public void addSaldo(double saldo){
        this.saldo = this.saldo + saldo;
    }
    public void removeSaldo(double saldo){
        this.saldo = this.saldo - saldo;
    }


    public double getBudjetti() {
        return laina.getBudjetti();
    }

    public void setBudjetti(double budjetti) {
        setBudjetti( budjetti );
    }

}

