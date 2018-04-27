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
import java.util.Random;
public class Simulointi {
    
    private Random sattuma = new Random();
    private Sarja sarja;
    private Radat rata;
    /**
     * 
     */
    Simulointi() {
        
    }
    /**
     * 
     * @param sarjat
     * @param rata
     * @return 
     */
    private String simuloi(Sarja[] sarjat, Radat rata) {
        for (int i = 0; i < sarjat.length; i++) {
            this.sarja = sarjat[i];
            Talli[] tallit = this.sarja.getTallit();
            for (int j = 0; j < sarjat.length; i++) {
                if (tallit[j].getPelaajantalli() == false) {
                    boolean crashed = false;
                    Auto ekaAuto = tallit[j].getYkkosauto();
                    Auto tokaAuto = tallit[j].getKakkosauto();
                    Kuljettaja ekaKuski = tallit[j].getYkkoskuski();
                    Kuljettaja tokaKuski = tallit[j].getKakkoskuski();
                    double ekaJarruteho = ekaAuto.getJarruteho();
                    double ekaPito = ekaAuto.getPito();
                    double ekaTeho = ekaAuto.getTeho();
                    double ekaMassa = ekaAuto.getMassa();
                    double tokaJarruteho = tokaAuto.getJarruteho();
                    double tokaPito = tokaAuto.getPito();
                    double tokaTeho = tokaAuto.getTeho();
                    double tokaMassa = tokaAuto.getMassa();
                    
                }
                
            }
            
        }
        
        return "";
    }
    
    /**
     * 
     * @return 
     */
    private String ajaKisa() {
        int ajoMoodi = 2;
        
        if (ajoMoodi == 1) {
            
        }
        
        if (ajoMoodi == 2) {
            
        }
        
        if (ajoMoodi == 3) {
            
        }
        
        return "";
    }
    
}
