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

/**
 *
 * @author andrei
 */
public class Säädöt {

    private double moottorin_säätö;
    private double turbon_säätö;
    private double vaihdelaatikon_säätö;
    private double jousituksen_säätö;
    private double renkaiden_säätö;
    private double jarrujen_säätö;

    //Konstruktori
    //Getterit
    public double getMoottorinSäätö() {
        return this.moottorin_säätö;
    }

    public double getTurbonSäätö() {
        return this.turbon_säätö;
    }

    public double getVaihdelaatikonSäätö() {
        return this.vaihdelaatikon_säätö;
    }

    public double getJousituksenSäätö() {
        return this.jousituksen_säätö;
    }

    public double getRenkaidenSäätö() {
        return this.renkaiden_säätö;
    }

    public double getJarrujenSäätö() {
        return this.jarrujen_säätö;
    }

    //Setterit
    public void setMoottorinSäätö(double moottorin_säätö) {
        this.moottorin_säätö = moottorin_säätö;
    }

    public void setTurbonSäätö(double turbon_säätö) {
        this.turbon_säätö = turbon_säätö;
    }

    public void setVaihdelaatikonSäätö(double vaihdelaatikon_säätö) {
        this.vaihdelaatikon_säätö = vaihdelaatikon_säätö;
    }

    public void setJousituksenSäätö(double jousituksen_säätö) {
        this.jarrujen_säätö = jousituksen_säätö;
    }

    public void setRenkaidenSäätö(double renkaiden_säätö) {
        this.renkaiden_säätö = renkaiden_säätö;
    }

    public void setJarrujenSäätö(double jarrujen_säätö) {
        this.jarrujen_säätö = jarrujen_säätö;
    }

    public void vaihtaaMoottorinSäätö(double moottorin_säätö) {
        this.setMoottorinSäätö(moottorin_säätö);
    }

    public void vaihtaaTurbonSäätö(double turbon_säätö) {
        this.setTurbonSäätö(moottorin_säätö);
    }

    public void vaihtaaVaihdelaatikonSäätö(double vaihdelaatikon_säätö) {
        this.setVaihdelaatikonSäätö(vaihdelaatikon_säätö);
    }

    public void vaihtaaJousituksenSäätö(double jousituksen_säätö) {
        this.setJousituksenSäätö(jousituksen_säätö);
    }

    public void vaihtaaRenkaidenSäätö(double moottorin_säätö) {
        this.setRenkaidenSäätö(moottorin_säätö);
    }

    public void vaihtaaJarrujenSäätö(double jarrujen_säätö) {
        this.setJarrujenSäätö(jarrujen_säätö);
    }

}
