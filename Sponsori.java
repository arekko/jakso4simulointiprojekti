
package rallimeister5000;

class Sponsori {
    
    private final String nimi;
    private final String ala;
    private double määrä;
    private int sopimuksenKesto;
    
    Sponsori(String nimi, String ala, int kesto) {
        this.nimi = nimi;
        this.ala = ala;
        this.sopimuksenKesto = kesto;
    }
    
    double maksa() {
        if (this.sopimuksenKesto > 0) {
            return this.määrä;
        }
        return 0;
    }
    
    void aikaEtene() {
        this.sopimuksenKesto--;
    }
    
    boolean puraSopimus() {
        this.sopimuksenKesto = 0;
        return true;
    }
}
