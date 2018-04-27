

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak.Controller;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import maxattak.ControlledScreen;
import maxattak.ScreensFramework;

/**
 * Tuo toiminallisuuden menu.fxml tiedostolle. Toimii siis päävalikon controllerina.
 *
 * 
 */
public class MenuController implements Initializable, ControlledScreen {
    ScreensController myController;
    
    
    @FXML
    public Label car1nimiLabel;
    @FXML
    private Label car2nimiLabel;
    @FXML
    private Label kuski1nimiLabel;
    @FXML
    private Label kuski2nimiLabel;
    @FXML
    private Label performance1Label;
    @FXML
    private Label performance2Label;
    @FXML
    private Label ready1Label;
    @FXML
    private Label ready2Label;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    /**
     * 
     * @param screenParent 
     */
    @Override
   public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
        päivitä();
    }
   /**
    * 
    * @param event 
    */
   @FXML
   private void startraceNappiPainettu(ActionEvent event) {
       System.out.println("Start nappi painettu!");
       myController.setScreen(ScreensFramework.raceControlID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void paluuNappiPainettu(ActionEvent event) {
       System.out.println("Alkumenu nappi painettu!");
       myController.setScreen(ScreensFramework.mainmenuID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void mechanicNappiPainettu(ActionEvent event) {
       System.out.println("Mechanic nappi painettu!");
       myController.setScreen(ScreensFramework.mekaanikkoID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void bankNappiPainettu(ActionEvent event) {
       System.out.println("Pankki nappi painettu!");
       myController.setScreen(ScreensFramework.pankkiID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void cardiilershipNappiPainettu(ActionEvent event) {
       System.out.println("Kauppa nappi painettu");
       
       myController.setScreen(ScreensFramework.kauppaID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void sarjataulukkoNappiPainettu(ActionEvent event) {
       System.out.println("sarjataulukko nappi painettu!");
       myController.setScreen(ScreensFramework.sarjataulukkoID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void carsNappiPainettu(ActionEvent event) {
       System.out.println("cars nappi painettu!");
       myController.setScreen(ScreensFramework.carsID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void driversNappiPainettu (ActionEvent event) {
       System.out.println("drivers nappi painettu!");
       myController.setScreen(ScreensFramework.driversID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void statistiksNappiPainettu (ActionEvent event){
       System.out.println("statistiks nappi painettu!");
       myController.setScreen(ScreensFramework.statistiksID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void manitsmentNappiPainettu (ActionEvent event) {
       System.out.println("manitsment nappi painettu!");
       myController.setScreen(ScreensFramework.manitsmentID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void sponsorsNappiPainettu (ActionEvent event) {
       System.out.println("sponsors nappi painettu!");
       myController.setScreen(ScreensFramework.sponsorsID);
   }
   /**
    * 
    * @param event 
    */
   @FXML
   private void lopetusNappiPainettu (ActionEvent event) {
       System.out.println("lopetus nappi painettu!");
       System.exit(0);
   }
   public void päivitä() {
       if (myController.getMoco().getPelaajanTalli().getYkkosauto() != null) {
            car1nimiLabel.setText(myController.getMoco().getPelaajanTalli().getYkkosauto().getMerkki()+" "+myController.getMoco().getPelaajanTalli().getYkkosauto().getMalli());
        }
   }
}

