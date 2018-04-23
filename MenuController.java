/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author soati
 */
public class MenuController implements Initializable, ControlledScreen {
    ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @Override
   public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
   @FXML
   private void raceControlNappiPainettu(ActionEvent event) {
       myController.setScreen(ScreensFramework.raceControlID);
   }
   @FXML
   private void alkuMenuNappiPainettu(ActionEvent event) {
       myController.setScreen(ScreensFramework.mainmenuID);
   }
   @FXML
   private void varikkoNappiPainettu(ActionEvent event) {
       
   }
   @FXML
   private void pankkiNappiPainettu(ActionEvent event) {
       myController.setScreen(ScreensFramework.pankkiID);
   }
   @FXML
   private void kauppaNappiPainettu(ActionEvent event) {
       
   }
   @FXML
   private void sarjataulukkoNappiPainettu(ActionEvent event) {
       myController.setScreen(ScreensFramework.sarjataulukkoID);
   }
    
}
