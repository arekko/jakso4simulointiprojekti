/*
 * Copyright (C) 2018 andrei
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

import maxattak.Model.Talli;

/**
 *
 *
 */
public class Varikko {

    private String moottoriInfo;
    private String jarrutInfo;
    private String turboInfo;
    private String vaihdelaatikoInfo;
    private String jousitusInfo;
    private String rengasInfo;


    private double jarrujenKuntoEka, jarrujenKuntoToka;
    private double moottorinKuntoEka, moottorinKuntoToka;
    private double turbonKuntoEka, turbonKuntoToka;
    private double vaihdelaatikonKuntoEka, vaihdelaatikonKuntoToka;
    private double jousituksenKuntoEka, jousituksenKuntoToka;
    private double renkaidenKuntoEka, renkaidenKuntoToka;
    private Talli talli;
    private OsatInfo info = new OsatInfo();

    Varikko(Talli talli) {
        this.talli = talli;

        this.jarrujenKuntoEka = talli.getYkkosauto().getAutonJarrut().getKunto();
        this.jarrujenKuntoToka = talli.getKakkosauto().getAutonJarrut().getKunto();

        this.moottorinKuntoEka = talli.getYkkosauto().getAutonMoottori().getKunto();
        this.moottorinKuntoToka = talli.getKakkosauto().getAutonMoottori().getKunto();

        this.renkaidenKuntoEka = talli.getYkkosauto().getAutonRenkaat().getKunto();
        this.renkaidenKuntoToka = talli.getKakkosauto().getAutonRenkaat().getKunto();

        this.jousituksenKuntoEka = talli.getYkkosauto().getAutonJouset().getKunto();
        this.jousituksenKuntoToka = talli.getKakkosauto().getAutonJouset().getKunto();

        this.turbonKuntoEka = talli.getYkkosauto().getAutonTurbo().getKunto();
        this.turbonKuntoToka = talli.getKakkosauto().getAutonTurbo().getKunto();

        this.vaihdelaatikonKuntoEka = talli.getYkkosauto().getAutonLaatikko().getKunto();
        this.vaihdelaatikonKuntoToka = talli.getKakkosauto().getAutonLaatikko().getKunto();


        this.moottoriInfo = info.getMoottoriInfo();
        this.jarrutInfo = info.getJarrutInfo();
        this.turboInfo = info.getTurboInfo();
        this.vaihdelaatikoInfo = info.getVaihdelaatikoInfo();
        this.jousitusInfo = info.getJousitusInfo();
        this.rengasInfo = info.getRengasInfo();

    }

    /**
     * Päivitetään osien kunnot
     */
    public void päivitäJarrujenKuntoEka(double kunto) {
        this.jarrujenKuntoEka = kunto;
    }

    public void päivitäJarrujenKuntoToka(double kunto) {
        this.jarrujenKuntoToka = kunto;
    }

    public void päivitäMoottorinKuntoEka(double kunto) {
        this.moottorinKuntoEka = kunto;
    }

    public void päivitäMoottorinKuntoToka(double kunto) {
        this.moottorinKuntoToka = kunto;
    }

    public void päivitäRenkaidenKuntoEka(double kunto) {
        this.renkaidenKuntoEka = kunto;
    }

    public void päivitäRenkaidenKuntoToka(double kunto) {
        this.renkaidenKuntoToka = kunto;
    }

    public void päivitäJousituksenKuntoEka(double kunto) {
        this.jousituksenKuntoEka = kunto;
    }

    public void päivitäJousituksenKuntoToka(double kunto) {
        this.jousituksenKuntoToka = kunto;
    }

    public void päivitäTurbonKuntoEka(double kunto) {
        this.turbonKuntoEka = kunto;
    }

    public void päivitäTurbonKuntoToka(double kunto) {
        this.turbonKuntoToka = kunto;
    }

    public void päivitäVaihdelaatikonKuntoEka(double kunto) {
        this.vaihdelaatikonKuntoEka = kunto;
    }

    public void päivitäVaihdelaatikonKuntoToka(double kunto) {
        this.vaihdelaatikonKuntoToka = kunto;
    }


}
