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

import maxattak.Controller.ModelController;


/**
 *
 * @author Ryhmä 4 / Group 4
 * @author Jani Jaala
 * @author Topi Matikainen
 * @author Andrei Vasilev
 * @author Metropolia Ammattikorkeakoulu
 * @author Metropolia University of Applied Sciences
 * @version 0.5a
 * 
 * 
 */
public class AI {
    
    private Talli talli;
    private ModelController kontti;
    /**
     * 
     * @param kontti 
     */
    public AI(ModelController kontti) {
        this.kontti = kontti;
    }
    /**
     * TODO tarkempi määrittely
     * @param talli Talli jonka omistajan älynystöröitä hierotaan
     */
    public void alustaTallit(Talli talli) {
        int persoona = talli.getOmistaja().getPersoonallisuus();
        double varallisuus = talli.getVarallisuus();
        this.talli = talli;
        Manageri[] managerit = kontti.getVapaatManagerit();
        Mekaanikko[] mekaanikot = kontti.getVapaatMekaanikot();
        osatJaAutot osat = kontti.getOsat();
        Auto[] autot = osat.getAutot();
        Moottori[] motit = osat.getMoottorit();
        Jousitus[] jouset = osat.getJousitukset();
        Renkaat[] renkaat = osat.getRenkaat();
        Vaihdelaatikko[] laatikot = osat.getLaatikko();
        Turbo[] turbot = osat.getTurbo();
        Jarrut[] jarrut = osat.getJarrut();
        Manageri manageri = null;
        Mekaanikko mekaanikko = null;
        
        /**
         * Tehdään valintoja jos Omistajan persoona on 1
         */
        if (persoona == 1) {
            double ratio = 0;
            int indeksi = -1;
            int parasTaito, taito;
            /**
             * Valinnat riippuvat tallin sarjatasosta
             */
            switch (talli.getTallinSarja().getSarjaTaso()) {
                case 1:
                    /**
                     * Hankkii tallille manageri pohjautuen alla oleviin parametreihin.
                     */
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+8000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    /**
                     * Hankkii tallille mekaanikon pohjautuen alla oleviin parametreihin.
                     * TODO
                     */
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+7000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    
                    /**
                     * Hankkii tallille auton pohjautuen alla oleviin parametreihin ja asettaa sen "ykkosautoksi"
                     */
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    /**
                     * Hankkii tallille auton pohjautuen alla oleviin parametreihin ja asettaa "kakkosautoksi"
                     */
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setKakkosauto(talli.getAutot()[1]);
                    }
                    /**
                     * Kutsuu paivitaOsia metodia jos parametrin mukainen tallin valuuttamäärä ylittyy.
                     */
                    if (talli.getVarallisuus() > 5000) {
                        paivitaOsia(persoona,talli.getVarallisuus());
                    }
                    break;
/**
 * KAIKKI TÄSTÄ PISTEESTÄ ALASPÄIN ON KOPIOTA YLLÄOLEVASTA
 * TODO PARAMETRIEN MÄÄRITTELY AI:N MONIPUOLISTAMISEKSI
 */
                //Sarjataso 2
                case 2:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+10000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (talli.getVarallisuus() > 5000) {
                        paivitaOsia(persoona, talli.getVarallisuus());
                    }
                    break;
                case 3:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+12000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (talli.getVarallisuus() > 5000) {
                        paivitaOsia(persoona, talli.getVarallisuus());
                    }
                    break;
                case 4:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+14000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (talli.getVarallisuus() > 5000) {
                        paivitaOsia(persoona, talli.getVarallisuus());
                    }
                    break;
                case 5:   
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }                       
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (talli.getVarallisuus() > 5000) {
                        paivitaOsia(persoona, talli.getVarallisuus());
                    }
                    break;
                default:
                    break;
            }
        }

        if (persoona == 2) {
             double ratio = 0;
            int indeksi = -1;
            int parasTaito, taito;
            switch (talli.getTallinSarja().getSarjaTaso()) {
                case 1:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+8000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setKakkosauto(talli.getAutot()[1]);
                    }
                    break;
                case 2:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+10000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+12000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+14000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 5:   
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }                       
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        if (persoona == 3) {
             double ratio = 0;
            int indeksi = -1;
            int parasTaito, taito;
            switch (talli.getTallinSarja().getSarjaTaso()) {
                case 1:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+8000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setKakkosauto(talli.getAutot()[1]);
                    }
                    break;
                case 2:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+10000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+12000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+14000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 5:   
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }                       
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        if (persoona == 4) {
             double ratio = 0;
            int indeksi = -1;
            int parasTaito, taito;
            switch (talli.getTallinSarja().getSarjaTaso()) {
                case 1:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+8000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setKakkosauto(talli.getAutot()[1]);
                    }
                    break;
                case 2:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+10000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+12000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > managerit[i].getHankintaHinta()+14000) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                case 5:   
                    for (int i = 0; i < managerit.length; i++) {
                        parasTaito = 0;
                        taito = managerit[i].getNeuvotteluTaito();
                        if (taito > parasTaito) {
                            parasTaito = taito;
                            manageri = managerit[i];
                        }                       
                    }
                    talli.ostaManageri(manageri);
                    for (int i = 0; i < mekaanikot.length; i++) {
                        parasTaito = 0;
                        taito = mekaanikot[i].getTaito();
                        if (taito > parasTaito && talli.getVarallisuus() > mekaanikot[i].getHankintaHinta()+8000) {
                            mekaanikko = mekaanikot[i];
                            parasTaito = taito;
                        }
                    }
                    talli.ostaMekaanikko();
                    ratio = 0;
                    indeksi = -1;
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta+2000) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    if (indeksi != -1) {
                        talli.ostaAuto(osat, indeksi);
                        talli.setYkkosauto(talli.getAutot()[0]);
                        indeksi = -1;
                    }
                    
                    for (int i = 0; i < autot.length; i++) {
                        double teho = autot[i].getTeho();
                        double hinta = autot[i].getHinta();
                        double massa = autot[i].getOmaMassa();
                        if (ratio < massa / teho && talli.getVarallisuus() > hinta) {
                            ratio = massa / teho;
                            indeksi = i;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        System.out.println("AiAiAi");
     
    }
    
    
    void paivitaOsia(int persoona, double varallisuus) {
        if (persoona == 1) {
            
        }
        if (persoona == 2) {
            
        }
        if (persoona == 3) {
            
        }
        if (persoona == 4) {
            
        }
    }
    
    void hommaaSponsoreita(int persoona, double varallisuus) {
        if (persoona == 1) {
            
        }
        if (persoona == 2) {
            
        }
        if (persoona == 3) {
            
        }
        if (persoona == 4) {
            
        }
    }
    
    void erotaManageri(Manageri manageri) {
        
    }
    
    void erotaKuljettaja(Kuljettaja kuljettaja) {
        
    }
    
    
}
