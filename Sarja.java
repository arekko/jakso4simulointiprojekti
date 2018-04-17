
package rallimeister5000;

class Sarja {
    /**
     * Alustetaan luokan muuttujat
     * Nimi on Sarja olion nimi
     * sarjaTaso on Sarja olion sarja taso
     * lisenssi on sarjatason lisenssimaksu, tämä sitä varten
     * kun pelaaja voittaa alemman sarjan on hänen mahdollista
     * siirtyä ylempään sarjaluokaan maksamalla ylemmän sarjan lisenssimaksu
     * palkintoRahat on taulu joka sisältää palkintorahat joita kyseinen
     * Sarja olio myöntää kuljettajille, lähtökohtainen ajatus oli että kolme
     * ensimmäistä palkitaan
     * tallit on taulu kyseisen sarja olion talliolioita varten
     * kisojaJäljellä määrittelee kuinka kauan kautta on ajamatta
     * sarjanRadat tulee sisältää radat luokan oliot joita jokainen sarjaolio tarvitsee
     */
    private String nimi;
    private int sarjaTaso;
    private double lisenssi;
    private double[] palkintoRahat = new double[3];
    private Talli[] tallit;
    private int kisojaJäljellä;
    private Radat[] sarjanRadat;
    
    /**
     * 
     * Luokan konstruktori
     * luodaan uusi Sarja olio, jolle asetetaan lisenssihinnat ja palkintorahat
     * pohjatuen kyseisen sarja olion sarjatasoon
     * Asetaan kisoja jäljellä 10
     * 
     */
    Sarja(String nimi, int taso) {
        this.nimi = nimi;
        this.sarjaTaso = taso;
        if (this.sarjaTaso == 1) {
            this.lisenssi = 2000;
        } else {
            this.lisenssi = 2*sarjaTaso*500;
        }
        this.palkintoRahat[0] = this.lisenssi/10;
        this.palkintoRahat[1] = this.palkintoRahat[0] / 2;
        this.palkintoRahat[2] = this.palkintoRahat[0] / 3;
        
        
        
        this.kisojaJäljellä = 10;
        tallit = new Talli[1];
    }
    /**
     * 
     * Metodi joka asettaa Kuljettaja oliolle ja Talli oliolle kuskien ajamat pisteet
     * Kartuttaa Kuljettaja olion ajoKokemusta yhdellä
     * ja maksaa tallien tienaamat palkintorahat
     */
    public void sijoituPisteille (Talli talli, Kuljettaja kuski, int sija) {
        if (sija == 1) {
            /**
             * Kutsutaan Talli luokan metodia addSarjaPisteet
             * Kutsutaan Kuljettaja luokan metodia addKuskinpisteet
             * Kutsutaan Kuljettaja luokan metodia addKuskinkokemus
             * Kutsutaan Talli luokan metodia addVarallisuus
             */
            talli.addSarjaPisteet(10);
            kuski.addKuskinpisteet(10);
            kuski.addKuskinkokemus();
            talli.addVarallisuus(this.getPalkintoRahat()[0]);
        } else if (sija == 2) {
            talli.addSarjaPisteet(8);
            kuski.addKuskinpisteet(8);
            kuski.addKuskinkokemus();
            talli.addVarallisuus(this.getPalkintoRahat()[1]);
        } else if (sija == 3) {
            talli.addSarjaPisteet(6);
            kuski.addKuskinpisteet(6);
            kuski.addKuskinkokemus();
            talli.addVarallisuus(this.getPalkintoRahat()[2]);
        } else if (sija == 4) {
            talli.addSarjaPisteet(4);
            kuski.addKuskinpisteet(4);
            kuski.addKuskinkokemus();     
        } else if (sija == 5) {
            talli.addSarjaPisteet(2);
            kuski.addKuskinpisteet(2);
            kuski.addKuskinkokemus();
        } else {
            kuski.addKuskinkokemus();
        }
    }
    /**
     * Lisää Talli olion Sarjaolion tauluun ja tarvittaessa kasvattaa
     * Taulun kokoa
     *  
     */
    public void lisaaTalli(Talli talli) { 
        if (this.tallit.length == 1) {
            tallit = new Talli[2];
            this.tallit[0] = talli;
        } else if (this.tallit.length < 4) {
            Talli[] temp = new Talli[tallit.length+1];
            for (int i = 0; i < tallit.length;i++) {
                temp[i] = tallit[i];
            }
            temp[tallit.length-1] = talli;
            
            tallit = temp;
        } else if (this.tallit.length == 4) {
            tallit[tallit.length-1] = talli;
        }
    }
    /**
     * Tarkastaa onko kyseisessä sarjaoliossa vielä tilaa tallille
     * Jos Sarja olion tallit taulu Talli luokan olioista ei ole täysi palautetaan true
     * Jokaiseen Sarjaolioon (rallisarjaan) menee 4 Talli luokan oliota
     */
    public boolean sarjassaTilaa () {
        if (this.tallit.length < 4) {
            return true;
        } else if (this.tallit[3] == null) {
            return true;
        }  else {
            return false;
        }
    }
    public Talli[] getTallit() {
        return this.tallit;
    }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return the sarjaTaso
     */
    public int getSarjaTaso() {
        return sarjaTaso;
    }

    /**
     * @param sarjaTaso the sarjaTaso to set
     */
    public void setSarjaTaso(int sarjaTaso) {
        this.sarjaTaso = sarjaTaso;
    }

    /**
     * @return the lisenssi
     */
    public double getLisenssi() {
        return lisenssi;
    }

    /**
     * @param lisenssi the lisenssi to set
     */
    public void setLisenssi(double lisenssi) {
        this.lisenssi = lisenssi;
    }

    /**
     * @return the palkintoRahat
     */
    public double[] getPalkintoRahat() {
        return palkintoRahat;
    }

    /**
     * @param palkintoRahat the palkintoRahat to set
     */
    public void setPalkintoRahat(double[] palkintoRahat) {
        this.palkintoRahat = palkintoRahat;
    }

    /**
     * @param tallit the tallit to set
     */
    public void setTallit(Talli[] tallit) {
        this.tallit = tallit;
    }

    /**
     * @return the kisojaJäljellä
     */
    public int getKisojaJäljellä() {
        return kisojaJäljellä;
    }

    /**
     * @param kisojaJäljellä the kisojaJäljellä to set
     */
    public void setKisojaJäljellä(int kisojaJäljellä) {
        this.kisojaJäljellä = kisojaJäljellä;
    }

    /**
     * @return the sarjanRadat
     */
    public Radat[] getSarjanRadat() {
        return sarjanRadat;
    }

    /**
     * @param sarjanRadat the sarjanRadat to set
     */
    public void setSarjanRadat(Radat[] sarjanRadat) {
        this.sarjanRadat = sarjanRadat;
    }
}
