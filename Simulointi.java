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
package rallimeister5000;
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
class Simulointi {
    
    private Random sattuma = new Random();
    private Sarja sarja;
    private Radat rata;
    Simulointi() {
        
    }
    private void simuloi(Sarja[] sarjat, Radat rata) {
        for (int i = 0; i < sarjat.length; i++) {
            this.sarja = sarjat[i];
            Talli[] tallit = this.sarja.getTallit();
            this.rata = rata;
            ajaKisa(tallit);
        }
        
    }

    private void ajaKisa(Talli[] tallit) {
        int ekaKuski, tokaKuski;
        double ekaPito, ekaMassa, ekaTeho, ekaJarruteho, tokaPito, tokaMassa, tokaTeho, tokaJarruteho, keli, kitka, pituus;
        
        pituus = rata.getPituus();
        kitka = rata.getKitka();
        keli = rata.getKeli();
        
        for (int i = 0; i < tallit.length; i++) {
            ekaKuski = tallit[i].getYkkoskuski().getAjoTaito();
            ekaPito = tallit[i].getYkkosauto().getPito();
            ekaMassa = tallit[i].getYkkosauto().getMassa();
            ekaTeho = tallit[i].getYkkosauto().getTeho();
            ekaJarruteho = tallit[i].getYkkosauto().getJarruteho();
            
            tokaKuski = tallit[i].getKakkoskuski().getAjoTaito();
            tokaPito = tallit[i].getKakkosauto().getPito();
            tokaMassa = tallit[i].getKakkosauto().getMassa();
            tokaTeho = tallit[i].getKakkosauto().getTeho();
            tokaJarruteho = tallit[i].getKakkosauto().getJarruteho();
            
        }
    }
}
