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
public class osatJaAutot {
    
    private Jarrut[] jarrut;
    private Moottori[] moottorit;
    private Jousitus[] jousitukset;
    private Renkaat[] renkaat;
    private Auto[] autot;
    private Vaihdelaatikko[] laatikko;
    private Turbo[] turbo;
    /**
     * 
     */
    osatJaAutot() {
        
    }
    /**
     * 
     */
    public void luoJarrut() {
        setJarrut(new Jarrut[10]);
        // Valmistaja, Nimi, jarruteho, massa, osakategoria, hinta
        jarrut[0] = new Jarrut("Mauer", "Stopperi", 0.85, 35.0, 5, 500.0);
        jarrut[1] = new Jarrut("Valmistaja1", "Nimi1", 1, 20, 4, 400);
        jarrut[2] = new Jarrut("Valmistaja2", "Nimi2", 1, 20, 2, 200);
        jarrut[3] = new Jarrut("Valmistaja3", "Nimi3", 1, 20, 4, 400);
        jarrut[4] = new Jarrut("Valmistaja4", "Nimi4", 1, 20, 3, 300);
        jarrut[5] = new Jarrut("Valmistaja5", "Nimi5", 1, 20, 4, 400);
        jarrut[6] = new Jarrut("Valmistaja6", "Nimi6", 1, 20, 1, 100);
        jarrut[7] = new Jarrut("Valmistaja7", "Nimi7", 1, 20, 4, 400);
        jarrut[8] = new Jarrut("Valmistaja8", "Nimi8", 1, 20, 5, 500);
        jarrut[9] = new Jarrut("Valmistaja9", "Nimi9", 1, 20, 4, 400);
    }
        // Valmistaja, Nimi, pito, massa, osakategoria, hinta
    /**
     * 
     */
    public void luoJousitukset() {
        setJousitukset(new Jousitus[10]);
        jousitukset[0] = new Jousitus("Mauer", "Natisija 500", 0.75, 20.0, 5, 300.0);
        jousitukset[1] = new Jousitus ("Valmistaja1", "Nimi1", 1, 20, 1, 100);
        jousitukset[2] = new Jousitus ("Valmistaja2", "Nimi2", 1, 20, 2, 200);
        jousitukset[3] = new Jousitus ("Valmistaja3", "Nimi3", 1, 20, 3, 300);
        jousitukset[4] = new Jousitus ("Valmistaja4", "Nimi4", 1, 20, 4, 400);
        jousitukset[5] = new Jousitus ("Valmistaja5", "Nimi5", 1, 20, 5, 500);
        jousitukset[6] = new Jousitus ("Valmistaja6", "Nimi6", 1, 20, 4, 400);
        jousitukset[7] = new Jousitus ("Valmistaja7", "Nimi7", 1, 20, 4, 400);
        jousitukset[8] = new Jousitus ("Valmistaja8", "Nimi8", 1, 20, 4, 400);
        jousitukset[9] = new Jousitus ("Valmistaja9", "Nimi9", 1, 20, 4, 400);
    }
    /**
     * 
     */
    public void luoRenkaat() {
        setRenkaat(new Renkaat[10]);
        renkaat[0] = new Renkaat("Mokia", "Naakkapelican", 0.15, 30.0, 5, 100.0);
        renkaat[1] = new Renkaat("Valmistaja1", "Nimi1", 1, 30.0, 1, 100.0);
        renkaat[2] = new Renkaat("Valmistaja2", "Nimi2", 1, 30.0, 2, 200.0);
        renkaat[3] = new Renkaat("Valmistaja3", "Nimi3", 1, 30.0, 3, 300.0);
        renkaat[4] = new Renkaat("Valmistaja4", "Nimi4", 1, 30.0, 4, 400.0);
        renkaat[5] = new Renkaat("Valmistaja5", "Nimi5", 1, 30.0, 5, 500.0);
        renkaat[6] = new Renkaat("Valmistaja6", "Nimi6", 1, 30.0, 1, 100.0);
        renkaat[7] = new Renkaat("Valmistaja7", "Nimi7", 1, 30.0, 1, 100.0);
        renkaat[8] = new Renkaat("Valmistaja8", "Nimi8", 1, 30.0, 1, 100.0);
        renkaat[9] = new Renkaat("Valmistaja9", "Nimi9", 1, 30.0, 1, 100.0);
    }
    /**
     * 
     */
    public void luoMoottorit() {
        setMoottorit(new Moottori[10]);
        moottorit[0] = new Moottori("General rotors", "Perusrytkytin", 0.15, 300.0, 5, 100);
        moottorit[1] = new Moottori("Valmistaja1", "nimi1", 1, 300.0, 1, 100);
        moottorit[2] = new Moottori("Valmistaja2", "nimi2", 1, 300.0, 2, 200);
        moottorit[3] = new Moottori("Valmistaja3", "nimi3", 1, 300.0, 3, 300);
        moottorit[4] = new Moottori("Valmistaja4", "nimi4", 1, 300.0, 4, 400);
        moottorit[5] = new Moottori("Valmistaja5", "nimi5", 1, 300.0, 5, 500);
        moottorit[6] = new Moottori("Valmistaja6", "nimi6", 1, 300.0, 1, 100);
        moottorit[7] = new Moottori("Valmistaja7", "nimi7", 1, 300.0, 1, 100);
        moottorit[8] = new Moottori("Valmistaja8", "nimi8", 1, 300.0, 1, 100);
        moottorit[9] = new Moottori("Valmistaja9", "nimi9", 1, 300.0, 1, 100);
    }
    /**
     * 
     */
    public void luoVaihdelaatikot() {
        setLaatikko(new Vaihdelaatikko[10]);
        laatikko[0] = new Vaihdelaatikko("Pseudovalmistaja", "Pseudonimi", 0.25, 100.0, 5, 500);
        laatikko[1] = new Vaihdelaatikko("Valmistaja1", "Nimi1", 1, 100.0, 1, 100);
        laatikko[2] = new Vaihdelaatikko("Valmistaja2", "Nimi2", 1, 100.0, 2, 200);
        laatikko[3] = new Vaihdelaatikko("Valmistaja3", "Nimi3", 1, 100.0, 3, 300);
        laatikko[4] = new Vaihdelaatikko("Valmistaja4", "Nimi4", 1, 100.0, 4, 400);
        laatikko[5] = new Vaihdelaatikko("Valmistaja5", "Nimi5", 1, 100.0, 5, 500);
        laatikko[6] = new Vaihdelaatikko("Valmistaja6", "Nimi6", 1, 100.0, 1, 100);
        laatikko[7] = new Vaihdelaatikko("Valmistaja7", "Nimi7", 1, 100.0, 1, 100);
        laatikko[8] = new Vaihdelaatikko("Valmistaja8", "Nimi8", 1, 100.0, 1, 100);
        laatikko[9] = new Vaihdelaatikko("Valmistaja9", "Nimi9", 1, 100.0, 1, 100);
        
        
    }
    /**
     * 
     */
    public void luoTurbot() {
        setTurbo(new Turbo[10]);
        turbo[0] = new Turbo("Pseudovalmistaja", "Pseudonimi", 0.50, 50.0, 5, 100);
        turbo[1] = new Turbo("Valmistaja1", "Nimi1", 0.50, 50.0, 1, 100);
        turbo[2] = new Turbo("Valmistaja2", "Nimi2", 0.50, 50.0, 2, 200);
        turbo[3] = new Turbo("Valmistaja3", "Nimi3", 0.50, 50.0, 3, 300);
        turbo[4] = new Turbo("Valmistaja4", "Nimi4", 0.50, 50.0, 4, 400);
        turbo[5] = new Turbo("Valmistaja5", "Nimi5", 0.50, 50.0, 5, 500);
        turbo[6] = new Turbo("Valmistaja6", "Nimi6", 0.50, 50.0, 1, 100);
        turbo[7] = new Turbo("Valmistaja7", "Nimi7", 0.50, 50.0, 1, 100);
        turbo[8] = new Turbo("Valmistaja8", "Nimi8", 0.50, 50.0, 1, 100);
        turbo[9] = new Turbo("Valmistaja9", "Nimi9", 0.50, 50.0, 1, 100);
    }
    /**
     * 
     */
    public void luoAutot() {
        setAutot(new Auto[10]);
        autot[0] = new Auto("Vulga","T-500", 800, new Moottori(getMoottorit()[0].getValmistaja(),
        getMoottorit()[0].getNimi(),getMoottorit()[0].getTeho(),getMoottorit()[0].getMassa(),getMoottorit()[0].getOsaKategoria(),getMoottorit()[0].getHinta()), 
                new Jarrut(getJarrut()[0].getValmistaja(),getJarrut()[0].getNimi(),getJarrut()[0].getJarruteho(),getJarrut()[0].getMassa(),getJarrut()[0].getOsaKategoria(),getJarrut()[0].getHinta()),
                new Jousitus (getJousitukset()[0].getValmistaja(),getJousitukset()[0].getNimi(),getJousitukset()[0].getPito(),getJousitukset()[0].getMassa(),getJousitukset()[0].getOsaKategoria(), getJousitukset()[0].getHinta()),
                new Renkaat (getRenkaat()[0].getValmistaja(), getRenkaat()[0].getNimi(), getRenkaat()[0].getPito(), getRenkaat()[0].getMassa(), getRenkaat()[0].getOsaKategoria(), getRenkaat()[0].getHinta()),
                new Vaihdelaatikko (getLaatikko()[0].getValmistaja(),getLaatikko()[0].getNimi(),getLaatikko()[0].getKiihtyvyys(), getLaatikko()[0].getMassa(), getLaatikko()[0].getOsaKategoria(), getLaatikko()[0].getHinta()),
                new Turbo (getTurbo()[0].getValmistaja(), getTurbo()[0].getNimi(), getTurbo()[0].getKiihtyvyys(), getTurbo()[0].getMassa(), getTurbo()[0].getOsaKategoria(), getTurbo()[0].getHinta()), 1000);
        
        autot[1] = new Auto("Merkki1","Malli1", 1000, 
                new Moottori(getMoottorit()[1].getValmistaja(),getMoottorit()[1].getNimi(),getMoottorit()[1].getTeho(),getMoottorit()[1].getMassa(),getMoottorit()[1].getOsaKategoria(),getMoottorit()[1].getHinta()), 
                new Jarrut(getJarrut()[1].getValmistaja(),getJarrut()[1].getNimi(),getJarrut()[1].getJarruteho(),getJarrut()[1].getMassa(),getJarrut()[1].getOsaKategoria(),getJarrut()[1].getHinta()),
                new Jousitus (getJousitukset()[1].getValmistaja(),getJousitukset()[1].getNimi(),getJousitukset()[1].getPito(),getJousitukset()[1].getMassa(),getJousitukset()[1].getOsaKategoria(), getJousitukset()[1].getHinta()),
                new Renkaat (getRenkaat()[1].getValmistaja(), getRenkaat()[1].getNimi(), getRenkaat()[1].getPito(), getRenkaat()[1].getMassa(), getRenkaat()[1].getOsaKategoria(), getRenkaat()[1].getHinta()),
                new Vaihdelaatikko (getLaatikko()[1].getValmistaja(),getLaatikko()[1].getNimi(),getLaatikko()[1].getKiihtyvyys(), getLaatikko()[1].getMassa(), getLaatikko()[1].getOsaKategoria(), getLaatikko()[1].getHinta()),
                new Turbo (getTurbo()[1].getValmistaja(), getTurbo()[1].getNimi(), getTurbo()[1].getKiihtyvyys(), getTurbo()[1].getMassa(), getTurbo()[1].getOsaKategoria(), getTurbo()[1].getHinta()), 1000);
        
        autot[2] = new Auto("Merkki2","Malli2", 1000, 
                new Moottori(getMoottorit()[2].getValmistaja(),getMoottorit()[2].getNimi(),getMoottorit()[2].getTeho(),getMoottorit()[2].getMassa(),getMoottorit()[2].getOsaKategoria(),getMoottorit()[2].getHinta()), 
                new Jarrut(getJarrut()[2].getValmistaja(),getJarrut()[2].getNimi(),getJarrut()[2].getJarruteho(),getJarrut()[2].getMassa(),getJarrut()[2].getOsaKategoria(),getJarrut()[2].getHinta()),
                new Jousitus (getJousitukset()[2].getValmistaja(),getJousitukset()[2].getNimi(),getJousitukset()[2].getPito(),getJousitukset()[2].getMassa(),getJousitukset()[2].getOsaKategoria(), getJousitukset()[2].getHinta()),
                new Renkaat (getRenkaat()[2].getValmistaja(), getRenkaat()[2].getNimi(), getRenkaat()[2].getPito(), getRenkaat()[2].getMassa(), getRenkaat()[2].getOsaKategoria(), getRenkaat()[2].getHinta()),
                new Vaihdelaatikko (getLaatikko()[2].getValmistaja(),getLaatikko()[2].getNimi(),getLaatikko()[2].getKiihtyvyys(), getLaatikko()[2].getMassa(), getLaatikko()[2].getOsaKategoria(), getLaatikko()[2].getHinta()),
                new Turbo (getTurbo()[2].getValmistaja(), getTurbo()[2].getNimi(), getTurbo()[2].getKiihtyvyys(), getTurbo()[2].getMassa(), getTurbo()[2].getOsaKategoria(), getTurbo()[2].getHinta()), 1000);
        
        autot[3] = new Auto("Merkki3","Malli3", 1000, 
                new Moottori(getMoottorit()[3].getValmistaja(),getMoottorit()[3].getNimi(),getMoottorit()[3].getTeho(),getMoottorit()[3].getMassa(),getMoottorit()[3].getOsaKategoria(),getMoottorit()[3].getHinta()), 
                new Jarrut(getJarrut()[3].getValmistaja(),getJarrut()[3].getNimi(),getJarrut()[3].getJarruteho(),getJarrut()[3].getMassa(),getJarrut()[3].getOsaKategoria(),getJarrut()[3].getHinta()),
                new Jousitus (getJousitukset()[3].getValmistaja(),getJousitukset()[3].getNimi(),getJousitukset()[3].getPito(),getJousitukset()[3].getMassa(),getJousitukset()[3].getOsaKategoria(), getJousitukset()[3].getHinta()),
                new Renkaat (getRenkaat()[3].getValmistaja(), getRenkaat()[3].getNimi(), getRenkaat()[3].getPito(), getRenkaat()[3].getMassa(), getRenkaat()[3].getOsaKategoria(), getRenkaat()[3].getHinta()),
                new Vaihdelaatikko (getLaatikko()[3].getValmistaja(),getLaatikko()[3].getNimi(),getLaatikko()[3].getKiihtyvyys(), getLaatikko()[3].getMassa(), getLaatikko()[3].getOsaKategoria(), getLaatikko()[3].getHinta()),
                new Turbo (getTurbo()[3].getValmistaja(), getTurbo()[3].getNimi(), getTurbo()[3].getKiihtyvyys(), getTurbo()[3].getMassa(), getTurbo()[3].getOsaKategoria(), getTurbo()[3].getHinta()), 1000);
        
        autot[4] = new Auto("Merkki4","Malli4", 1000, 
                new Moottori(getMoottorit()[4].getValmistaja(),getMoottorit()[4].getNimi(),getMoottorit()[4].getTeho(),getMoottorit()[4].getMassa(),getMoottorit()[4].getOsaKategoria(),getMoottorit()[4].getHinta()), 
                new Jarrut(getJarrut()[4].getValmistaja(),getJarrut()[4].getNimi(),getJarrut()[4].getJarruteho(),getJarrut()[4].getMassa(),getJarrut()[4].getOsaKategoria(),getJarrut()[4].getHinta()),
                new Jousitus (getJousitukset()[4].getValmistaja(),getJousitukset()[4].getNimi(),getJousitukset()[4].getPito(),getJousitukset()[4].getMassa(),getJousitukset()[4].getOsaKategoria(), getJousitukset()[4].getHinta()),
                new Renkaat (getRenkaat()[4].getValmistaja(), getRenkaat()[4].getNimi(), getRenkaat()[4].getPito(), getRenkaat()[4].getMassa(), getRenkaat()[4].getOsaKategoria(), getRenkaat()[4].getHinta()),
                new Vaihdelaatikko (getLaatikko()[4].getValmistaja(),getLaatikko()[4].getNimi(),getLaatikko()[4].getKiihtyvyys(), getLaatikko()[4].getMassa(), getLaatikko()[4].getOsaKategoria(), getLaatikko()[4].getHinta()),
                new Turbo (getTurbo()[4].getValmistaja(), getTurbo()[4].getNimi(), getTurbo()[4].getKiihtyvyys(), getTurbo()[4].getMassa(), getTurbo()[4].getOsaKategoria(), getTurbo()[4].getHinta()), 1000);
        
        autot[5] = new Auto("Merkki5","Malli5", 1000, 
                new Moottori(getMoottorit()[5].getValmistaja(),getMoottorit()[5].getNimi(),getMoottorit()[5].getTeho(),getMoottorit()[5].getMassa(),getMoottorit()[5].getOsaKategoria(),getMoottorit()[5].getHinta()), 
                new Jarrut(getJarrut()[5].getValmistaja(),getJarrut()[5].getNimi(),getJarrut()[5].getJarruteho(),getJarrut()[5].getMassa(),getJarrut()[5].getOsaKategoria(),getJarrut()[5].getHinta()),
                new Jousitus (getJousitukset()[5].getValmistaja(),getJousitukset()[5].getNimi(),getJousitukset()[5].getPito(),getJousitukset()[5].getMassa(),getJousitukset()[5].getOsaKategoria(), getJousitukset()[5].getHinta()),
                new Renkaat (getRenkaat()[5].getValmistaja(), getRenkaat()[5].getNimi(), getRenkaat()[5].getPito(), getRenkaat()[5].getMassa(), getRenkaat()[5].getOsaKategoria(), getRenkaat()[5].getHinta()),
                new Vaihdelaatikko (getLaatikko()[5].getValmistaja(),getLaatikko()[5].getNimi(),getLaatikko()[5].getKiihtyvyys(), getLaatikko()[5].getMassa(), getLaatikko()[5].getOsaKategoria(), getLaatikko()[5].getHinta()),
                new Turbo (getTurbo()[5].getValmistaja(), getTurbo()[5].getNimi(), getTurbo()[5].getKiihtyvyys(), getTurbo()[5].getMassa(), getTurbo()[5].getOsaKategoria(), getTurbo()[5].getHinta()), 1000);
        
        autot[6] = new Auto("Merkki6","Malli6", 1000, 
                new Moottori(getMoottorit()[6].getValmistaja(),getMoottorit()[6].getNimi(),getMoottorit()[6].getTeho(),getMoottorit()[6].getMassa(),getMoottorit()[6].getOsaKategoria(),getMoottorit()[6].getHinta()), 
                new Jarrut(getJarrut()[6].getValmistaja(),getJarrut()[6].getNimi(),getJarrut()[6].getJarruteho(),getJarrut()[6].getMassa(),getJarrut()[6].getOsaKategoria(),getJarrut()[6].getHinta()),
                new Jousitus (getJousitukset()[6].getValmistaja(),getJousitukset()[6].getNimi(),getJousitukset()[6].getPito(),getJousitukset()[6].getMassa(),getJousitukset()[6].getOsaKategoria(), getJousitukset()[6].getHinta()),
                new Renkaat (getRenkaat()[6].getValmistaja(), getRenkaat()[6].getNimi(), getRenkaat()[6].getPito(), getRenkaat()[6].getMassa(), getRenkaat()[6].getOsaKategoria(), getRenkaat()[6].getHinta()),
                new Vaihdelaatikko (getLaatikko()[6].getValmistaja(),getLaatikko()[6].getNimi(),getLaatikko()[6].getKiihtyvyys(), getLaatikko()[6].getMassa(), getLaatikko()[6].getOsaKategoria(), getLaatikko()[6].getHinta()),
                new Turbo (getTurbo()[6].getValmistaja(), getTurbo()[6].getNimi(), getTurbo()[6].getKiihtyvyys(), getTurbo()[6].getMassa(), getTurbo()[6].getOsaKategoria(), getTurbo()[6].getHinta()), 1000);
        
        autot[7] = new Auto("Merkki7","Malli7", 1000, 
                new Moottori(getMoottorit()[7].getValmistaja(),getMoottorit()[7].getNimi(),getMoottorit()[7].getTeho(),getMoottorit()[7].getMassa(),getMoottorit()[7].getOsaKategoria(),getMoottorit()[7].getHinta()), 
                new Jarrut(getJarrut()[7].getValmistaja(),getJarrut()[7].getNimi(),getJarrut()[7].getJarruteho(),getJarrut()[7].getMassa(),getJarrut()[7].getOsaKategoria(),getJarrut()[7].getHinta()),
                new Jousitus (getJousitukset()[7].getValmistaja(),getJousitukset()[7].getNimi(),getJousitukset()[7].getPito(),getJousitukset()[7].getMassa(),getJousitukset()[7].getOsaKategoria(), getJousitukset()[7].getHinta()),
                new Renkaat (getRenkaat()[7].getValmistaja(), getRenkaat()[7].getNimi(), getRenkaat()[7].getPito(), getRenkaat()[7].getMassa(), getRenkaat()[7].getOsaKategoria(), getRenkaat()[7].getHinta()),
                new Vaihdelaatikko (getLaatikko()[7].getValmistaja(),getLaatikko()[7].getNimi(),getLaatikko()[7].getKiihtyvyys(), getLaatikko()[7].getMassa(), getLaatikko()[7].getOsaKategoria(), getLaatikko()[7].getHinta()),
                new Turbo (getTurbo()[7].getValmistaja(), getTurbo()[7].getNimi(), getTurbo()[7].getKiihtyvyys(), getTurbo()[7].getMassa(), getTurbo()[7].getOsaKategoria(), getTurbo()[7].getHinta()), 1000);
        
        autot[8] = new Auto("Merkki8","Malli8", 1000, 
                new Moottori(getMoottorit()[8].getValmistaja(),getMoottorit()[8].getNimi(),getMoottorit()[8].getTeho(),getMoottorit()[8].getMassa(),getMoottorit()[8].getOsaKategoria(),getMoottorit()[8].getHinta()), 
                new Jarrut(getJarrut()[8].getValmistaja(),getJarrut()[8].getNimi(),getJarrut()[8].getJarruteho(),getJarrut()[8].getMassa(),getJarrut()[8].getOsaKategoria(),getJarrut()[8].getHinta()),
                new Jousitus (getJousitukset()[8].getValmistaja(),getJousitukset()[8].getNimi(),getJousitukset()[8].getPito(),getJousitukset()[8].getMassa(),getJousitukset()[8].getOsaKategoria(), getJousitukset()[8].getHinta()),
                new Renkaat (getRenkaat()[8].getValmistaja(), getRenkaat()[8].getNimi(), getRenkaat()[8].getPito(), getRenkaat()[8].getMassa(), getRenkaat()[8].getOsaKategoria(), getRenkaat()[8].getHinta()),
                new Vaihdelaatikko (getLaatikko()[8].getValmistaja(),getLaatikko()[8].getNimi(),getLaatikko()[8].getKiihtyvyys(), getLaatikko()[8].getMassa(), getLaatikko()[8].getOsaKategoria(), getLaatikko()[8].getHinta()),
                new Turbo (getTurbo()[8].getValmistaja(), getTurbo()[8].getNimi(), getTurbo()[8].getKiihtyvyys(), getTurbo()[8].getMassa(), getTurbo()[8].getOsaKategoria(), getTurbo()[8].getHinta()), 1000);
        
        autot[9] = new Auto("Merkki9","Malli9", 1000, 
                new Moottori(getMoottorit()[9].getValmistaja(),getMoottorit()[9].getNimi(),getMoottorit()[9].getTeho(),getMoottorit()[9].getMassa(),getMoottorit()[9].getOsaKategoria(),getMoottorit()[9].getHinta()), 
                new Jarrut(getJarrut()[9].getValmistaja(),getJarrut()[9].getNimi(),getJarrut()[9].getJarruteho(),getJarrut()[9].getMassa(),getJarrut()[9].getOsaKategoria(),getJarrut()[9].getHinta()),
                new Jousitus (getJousitukset()[9].getValmistaja(),getJousitukset()[9].getNimi(),getJousitukset()[9].getPito(),getJousitukset()[9].getMassa(),getJousitukset()[9].getOsaKategoria(), getJousitukset()[9].getHinta()),
                new Renkaat (getRenkaat()[9].getValmistaja(), getRenkaat()[9].getNimi(), getRenkaat()[9].getPito(), getRenkaat()[9].getMassa(), getRenkaat()[9].getOsaKategoria(), getRenkaat()[9].getHinta()),
                new Vaihdelaatikko (getLaatikko()[9].getValmistaja(),getLaatikko()[9].getNimi(),getLaatikko()[9].getKiihtyvyys(), getLaatikko()[9].getMassa(), getLaatikko()[9].getOsaKategoria(), getLaatikko()[9].getHinta()),
                new Turbo (getTurbo()[9].getValmistaja(), getTurbo()[9].getNimi(), getTurbo()[9].getKiihtyvyys(), getTurbo()[9].getMassa(), getTurbo()[9].getOsaKategoria(), getTurbo()[9].getHinta()), 1000);
    }

    /**
     * @return the jarrut
     */
    public Jarrut[] getJarrut() {
        return jarrut;
    }

    /**
     * @param jarrut the jarrut to set
     */
    public void setJarrut(Jarrut[] jarrut) {
        this.jarrut = jarrut;
    }

    /**
     * @return the moottorit
     */
    public Moottori[] getMoottorit() {
        return moottorit;
    }

    /**
     * @param moottorit the moottorit to set
     */
    public void setMoottorit(Moottori[] moottorit) {
        this.moottorit = moottorit;
    }

    /**
     * @return the jousitukset
     */
    public Jousitus[] getJousitukset() {
        return jousitukset;
    }

    /**
     * @param jousitukset the jousitukset to set
     */
    public void setJousitukset(Jousitus[] jousitukset) {
        this.jousitukset = jousitukset;
    }

    /**
     * @return the renkaat
     */
    public Renkaat[] getRenkaat() {
        return renkaat;
    }

    /**
     * @param renkaat the renkaat to set
     */
    public void setRenkaat(Renkaat[] renkaat) {
        this.renkaat = renkaat;
    }

    /**
     * @return the autot
     */
    public Auto[] getAutot() {
        return autot;
    }

    /**
     * @param autot the autot to set
     */
    public void setAutot(Auto[] autot) {
        this.autot = autot;
    }

    /**
     * @return the laatikko
     */
    public Vaihdelaatikko[] getLaatikko() {
        return laatikko;
    }

    /**
     * @param laatikko the laatikko to set
     */
    public void setLaatikko(Vaihdelaatikko[] laatikko) {
        this.laatikko = laatikko;
    }

    /**
     * @return the turbo
     */
    public Turbo[] getTurbo() {
        return turbo;
    }

    /**
     * @param turbo the turbo to set
     */
    public void setTurbo(Turbo[] turbo) {
        this.turbo = turbo;
    }

    /**
     * @return the moottori
     */
}
