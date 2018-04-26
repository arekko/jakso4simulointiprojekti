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
   private void startraceNappiPainettu(ActionEvent event) {
       System.out.println("Start nappi painettu!");
       myController.setScreen(ScreensFramework.raceControlID);
   }
   @FXML
   private void paluuNappiPainettu(ActionEvent event) {
       System.out.println("Alkumenu nappi painettu!");
       myController.setScreen(ScreensFramework.mainmenuID);
   }
   @FXML
   private void mechanicNappiPainettu(ActionEvent event) {
       System.out.println("Mechanic nappi painettu!");
       myController.setScreen(ScreensFramework.mekaanikkoID);
   }
   @FXML
   private void bankNappiPainettu(ActionEvent event) {
       System.out.println("Pankki nappi painettu!");
       myController.setScreen(ScreensFramework.pankkiID);
   }
   @FXML
   private void cardiilershipNappiPainettu(ActionEvent event) {
       System.out.println("Kauppa nappi painettu");
       myController.setScreen(ScreensFramework.kauppaID);
   }
   @FXML
   private void sarjataulukkoNappiPainettu(ActionEvent event) {
       System.out.println("sarjataulukko nappi painettu!");
       myController.setScreen(ScreensFramework.sarjataulukkoID);
   }
   @FXML
   private void carsNappiPainettu(ActionEvent event) {
       System.out.println("cars nappi painettu!");
       myController.setScreen(ScreensFramework.carsID);
   }
   @FXML
   private void driversNappiPainettu (ActionEvent event) {
       System.out.println("drivers nappi painettu!");
       myController.setScreen(ScreensFramework.driversID);
   }
   @FXML
   private void statistiksNappiPainettu (ActionEvent event){
       System.out.println("statistiks nappi painettu!");
       myController.setScreen(ScreensFramework.statistiksID);
   }
   @FXML
   private void manitsmentNappiPainettu (ActionEvent event) {
       System.out.println("manitsment nappi painettu!");
       myController.setScreen(ScreensFramework.manitsmentID);
   }
   @FXML
   private void sponsorsNappiPainettu (ActionEvent event) {
       System.out.println("sponsors nappi painettu!");
       myController.setScreen(ScreensFramework.sponsorsID);
   }
   @FXML
   private void lopetusNappiPainettu (ActionEvent event) {
       System.out.println("lopetus nappi painettu!");
       System.exit(0);
   }
}
