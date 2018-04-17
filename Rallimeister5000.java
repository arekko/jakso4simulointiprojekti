
package rallimeister5000;
/**
 * 
 * @author ryhmä 4
 * @see Entry point applikaatioon, joka käynnistää Controllerin ja kutsuu Controllerin funktiota peliAvattu()
 */
public class Rallimeister5000 {
    static private Controller kk;
    public static void main(String[] args) {
        Rallimeister5000.kk = new Controller();
        kk.peliAvattu();
    }
}
