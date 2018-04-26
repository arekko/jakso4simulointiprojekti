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

/**
 *  Main menu aka alkumenu luokan Controller
 * 
 */

/**
 *
 * @author Jani
 */
public class mainMenuController implements Initializable, ControlledScreen {
    
    ScreensController myController;
    boolean peliKaynnissa = false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    /**
     * 
     * @param screenParent annetaan frameworkin haltuun
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
    /**
     * @param event Play napin listener, play napin painaminen kutsuu uusipeli id:n jos peli sessio on jo olemassa palauttaa menuun
     */
    @FXML
    public void playNappiPainettu(ActionEvent event) {
        System.out.println("Play nappi painettu");
        if (peliKaynnissa == false) {
            myController.setScreen(ScreensFramework.UusiID);
            peliKaynnissa = true;
        } else {
            myController.setScreen(ScreensFramework.menuID);
        }
    }
    /**
     * @param event TODO tähän tulee pelin lataus toiminallisuus
     */
    @FXML
    public void loadNappiPainettu(ActionEvent event) {
        System.out.println("Load nappi painettu");
    }
    /**
     * 
     * @param event TODO tähän tulee pelin lataus toiminallisuus
     */
    @FXML
    public void saveNappiPainettu(ActionEvent event) {
        System.out.println("Save nappi painettu");
    }
    /**
     * 
     * @param event Exit napin painaminen lopettaa pelin
     */
    @FXML
    public void exitNappiPainettu(ActionEvent event) {
        System.out.println("Exit nappi painettu");
        System.exit(0);
    }
    
}
