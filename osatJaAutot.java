
package rallimeister5000;

class osatJaAutot {
    
    private Jarrut[] jarrut;
    private Moottori[] moottorit;
    private Jousitus[] jousitukset;
    private Renkaat[] renkaat;
    private Auto[] autot;
    private Moottori moottori;
    
    osatJaAutot() {
        
    }
    void luoJarrut() {
        setJarrut(new Jarrut[10]);
        getJarrut()[0] = new Jarrut("Mauer", "Stopperi", 0.85, 35.0, 5, 200.0);
    }

    void luoJousitukset() {
        setJousitukset(new Jousitus[10]);
        getJousitukset()[0] = new Jousitus("Mauer", "Natisija 500", 0.75, 20.0, 5, 300.0);
    }

    void luoRenkaat() {
        setRenkaat(new Renkaat[10]);
        getRenkaat()[0] = new Renkaat("Mokia", "Naakkapelican", 0.15, 30.0, 5, 100.0);
    }

    void luoMoottorit() {
        setMoottorit(new Moottori[10]);
        getMoottorit()[0] = new Moottori("General rotors", "Perusrytkytin", 0.15, 300.0, 5, 100);
    }

    void luoAutot() {
        setAutot(new Auto[10]);
        getAutot()[0] = new Auto("Vulga","T-500", 800, new Moottori(getMoottorit()[0].getValmistaja(),
        getMoottorit()[0].getNimi(),getMoottorit()[0].getTeho(),getMoottorit()[0].getMassa(),getMoottorit()[0].getOsaKategoria(),getMoottorit()[0].getHinta()), 
                new Jarrut(getJarrut()[0].getValmistaja(),getJarrut()[0].getNimi(),getJarrut()[0].getJarruteho(),getJarrut()[0].getMassa(),getJarrut()[0].getOsaKategoria(),getJarrut()[0].getHinta()),
                new Jousitus (getJousitukset()[0].getValmistaja(),getJousitukset()[0].getNimi(),getJousitukset()[0].getPito(),getJousitukset()[0].getMassa(),getJousitukset()[0].getOsaKategoria(), getJousitukset()[0].getHinta()),
                new Renkaat (getRenkaat()[0].getValmistaja(), getRenkaat()[0].getNimi(), getRenkaat()[0].getPito(), getRenkaat()[0].getMassa(), getRenkaat()[0].getOsaKategoria(), getRenkaat()[0].getHinta()), 1000);
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
     * @return the moottori
     */
    public Moottori getMoottori() {
        return moottori;
    }

    /**
     * @param moottori the moottori to set
     */
    public void setMoottori(Moottori moottori) {
        this.moottori = moottori;
    }
    
}
