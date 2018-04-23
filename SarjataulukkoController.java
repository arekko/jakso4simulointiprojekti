/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Jani
 */
public class SarjataulukkoController implements Initializable, ControlledScreen {
    
    /**
     * Initializes the controller class.
     */
    ScreensController myController;
    private int sarjanNumero = 0;
    
    @FXML
    private TextFlow sarjaTaulukko;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //alusta(0);
    }
    public void setScreenParent(ScreensController ScreenParent) {
        myController = ScreenParent;
    }
    @FXML
    public void seuraavaNappiPainettu(ActionEvent event) {
        if (sarjanNumero > 4) {
            sarjanNumero = 0;
        } else {
            sarjanNumero++;
        }
        alusta(sarjanNumero);
    }
    @FXML
    public void edellinenNappiPainettu(ActionEvent event) {
        if (sarjanNumero < 0) {
            sarjanNumero = 4;
        } else {
            sarjanNumero--;
        }
        alusta(sarjanNumero);
    }
    @FXML
    public void palaaValikkoonNappiPainettu(ActionEvent event) {
        System.out.println("Palaa valikkoon nappi painettu!");
    }

    /*private void järjestäTaulu(int ekaP, int tokaP, int kolmasP, int neljäsP, String ekaT, String tokaT, String kolmasT, String neljäsT) {
        
        
    }*/

    private void alusta(int sarja) {
        sarjaTaulukko.getChildren().removeAll();
        sarjaTaulukko.getChildren().clear();
        System.out.println("Seuraava nappi painettu!");
        String tuloste;

        String talli1 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[0].getNimi();
        int pist1 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[0].getSarjaPisteet();
        
        String talli2 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[1].getNimi();
        int pist2 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[1].getSarjaPisteet();
        
        String talli3 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[2].getNimi();
        int pist3 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[2].getSarjaPisteet();
        
        String talli4 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[3].getNimi();
        int pist4 = myController.getMoco().getRalliSarjat()[sarja].getTallit()[3].getSarjaPisteet();
        
        tuloste = talli1+"\t"+pist1+"\n"+talli2+"\t"+pist2+"\n"+talli3+"\t"+pist3+"\n"+talli4+"\t"+pist4;
        
        Text teksti = new Text(tuloste);
        sarjaTaulukko.getChildren().add(teksti);
        //järjestäTaulu(pist1, pist2, pist3, pist4, talli1, talli2, talli3, talli4);
    }
}
