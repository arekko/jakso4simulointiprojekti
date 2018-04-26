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
 *
 *@author tmati
**/
public class mechanicController implements Initializable, ControlledScreen {
    ScreensController myController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
        /**
     * Initializes the controller class.
     */
   @Override
   public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
        /** lopetus-napin painaminen lopettaa pelin
     * @param event 
     */
    @FXML
    public void lopetusNappiPainettu(ActionEvent event) {
        System.out.println("lopetus-nappi painettu");
        System.exit(0);
    }
            /** paluu-napin painaminen palauttaa pelaajan edelliselle valikkotasolle.
     * @param event 
     */
    @FXML
    public void paluuNappiPainettu(ActionEvent event) {
        System.out.println("paluu-nappi painettu");
        myController.setScreen(ScreensFramework.mainmenuID);
    }
    /** auto1bodyfix-napin painaminen korjaa auton 1 koria määrätyn määrän vaihdossa rahaan.
     * 
     * @param event 
     */
    @FXML
    public void auto1bodyfixNappiPainettu(ActionEvent event) {
        System.out.println("Auton 1 koria korjattu!");
    }
    /** auto2bodyfix-napin painaminen korjaa auton 2 koria määrätyn määrän vaihdossa rahaan.
     * 
     * @param event 
     */
    @FXML
    public void auto2bodyfixNappiPainettu(ActionEvent event) {
        System.out.println("Auton 2 koria korjattu!");
    }
    /**
     * auto1enginefix-napin painaminen korjaa auton 1 moottoria määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto1enginefixNappiPainettu(ActionEvent event){
        System.out.println("Auton 1 moottoria korjattu");
    }
    /**
     * auto2enginefix-napin painaminen korjaa auton 2 moottoria määrätyn määrän vaihdossa rahaan.
     * @param event
     */
    @FXML
    public void auto2enginefixNappiPainettu(ActionEvent event) {
        System.out.println("Auton 2 moottoria korjattu!");
    }
    /**
     * auto1moottoritune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 1 moottorin seossuhdetta. Vaikuttaa huippukiihtyvyyteen sekä huippunopeuteen. Ääriarvot kuluttavat moottoria.
     * @param event
     */
    @FXML
    public void auto1moottorituneNappiPainettu(ActionEvent event) {
        System.out.println("Auton 1 moottorin viritysikkuna avattu!");
    }
    /**
     * auto2moottoritune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 2 moottorin seossuhdetta. Vaikuttaa huippukiihtyvyyteen sekä huippunopeuteen. Ääriarvot kuluttavat moottoria.
     * @param event 
     */
    @FXML
    public void auto2moottorituneNappiPainettu(ActionEvent event) {
        System.out.println("Auton 2 moottorin viritysikkuna avattu!");
    }
    /**
     * auto1gearboxfix-napin painaminen korjaa auton 1 vaihdelaatikkoa määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto1gearboxfixNappiPainettu(ActionEvent event) {
        System.out.println("Auton 1 Vaihdelaatikkoa korjattu!");
    }
    /**
     * auto2gearboxfix-napin painaminen korjaa auton 2 vaihdelaatikkoa määritetyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto2gearboxfixNappiPainettu(ActionEvent event) {
        System.out.println("Auton 2 Vaihdelaatikkoa korjattu!");
    }
    /**
     * auto1vaihdelaatikkotune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 1 vaihteiston välitystä. Vaikuttaa kiihtyvyyteen sekä huippunopeuteen.
     * @param event 
     */
    @FXML
    public void auto1vaihdelaatikkotuneNappiPainettu(ActionEvent event) {
        System.out.println("Auton 1 vaihdelaatikon viritysikkuna avattu!");
    }
    /**
     * auto2vaihdelaatikkotune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 2 vaihteiston välitystä. Vaikuttaa kiihtyvyyteen sekä huippunopeuateen.
     * @param event 
     */
    @FXML
    public void auto2vaihdelaatikkotuneNappiPainettu(ActionEvent event) {
        System.out.println("Auton 2 vaihdelaatikon viritysikkuna avattu!");
    }
    /**
     * auto1turbotune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 1 turbon ahtopainetta. Vaikuttaa kiihtyvyyteen sekä huippunopeuteen. Liika paine vahingoittaa turboa.
     * @param event 
     */
    @FXML
    public void auto1turbotuneNappiPainettu (ActionEvent event) {
        System.out.println("Auton 1 turbon viritysikkuna avattu!");
    }
    /**
     * auto2turbotune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 2 turobon ahtopainetta. Vaikuttaa kiihtyvyyteen sekä huippunopeuteen. Liika paine vahingoittaa turboa.2
     * @param event 
     */
    @FXML
    public void auto2turbotuneNappiPainettu(ActionEvent event) {
        System.out.println("Auton 2 turbon viritysikkuna avattu!");
    }
    /**
     * auto1turbofix-napin painaminen korjaa auton 1 turboa määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto1turbofixNappiPainettu (ActionEvent event) {
        System.out.println("Auton 1 turboa korjattu!");
    }
    /**
     * auto2turbofix-napin painaminen korjaa auton 2 turboa määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto2turbofixNappiPainettu (ActionEvent event) {
        System.out.println("Auton 2 turboa korjattu!");
    }
    /**
     * auto1jousitusfix-napin painaminen korjaa auton 1 jousitusta määrätyn verran vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto1jousitusfixNappiPainettu (ActionEvent event) {
        System.out.println("Auton 1 jousitusta korjattu!");
    }
    /**
     * auto2jousitusfixnapin painaminen korjaa auton 2 jousitusta määrätyn verran vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto2jousitusfixNAppiPainettu (ActionEvent event) {
        System.out.println("Auton 2 jousitusta korjattu!");
    }
    /**
     * auto1jousitustune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 1 jousituksen korkeutta. Korkeat jouset sopivat hiekalle ja lumelle, matalat jouset asfaltille.
     * @param event 
     */
    @FXML
    public void auto1jousitustuneNappiPainettu (ActionEvent event) {
        System.out.println("Auton 1 jousituksen viritysikkuna avattu!");
    } 
    /**
     * auto2jousitustune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 2 jousituksen korkeutta. Korkeat jouset sopivat hiekalle ja lumelle, matalat jouset asfaltille.
     * @param event 
     */
    @FXML
    public void auto2jousitustuneNappiPainettu (ActionEvent event) {
        System.out.println("Auton 2 jousituksen viritysikkuna avattu!");
    }
    /**
     * auto1renkaatfix-napin painaminen korjaa auton 1 renkaita määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto1renkaatfixNappiPainettu (ActionEvent event) {
        System.out.println("Auton 1 renkaita korjattu!");
    }
    /**
     * auto2renkaatfix-napin painaminen korjaa auton 2 renkaita määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto2renkaatfixNappiPainettu (ActionEvent event) {
        System.out.println("Auton 2 renkaita korjattu!");
    }
    /**
     * auto1renkaattune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 1 renkaiden ilmanpainetta. Korkea paine sopii paremmin asfaltille, matala hiekalle ja lumelle.
     * @param event 
     */
    @FXML
    public void auto1renkaattuneNappiPainettu (ActionEvent event) {
        System.out.println("Auton 1 renkaiden viritysikkuna avattu!");
    }
    /**
     * auto2renkaattune-napin painaminen avaa erillisen ikkunan jossa voi säätää auton 2 renkaiden ilmanpainetta. Korkea paine sopii paremmin asfaltille, matala hiekalle ja lumelle.
     * @param event 
     */
    @FXML
    public void auto2renkaattuneNappiPainettu (ActionEvent event) {
        System.out.println("Auton 2 renkaiden viritysikkuna avattu!");
        
    }
    /**
     * auto1jarrutfix-napin painaminen korjaa auton 1 jarruja määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto1jarrutfixNappiPainettu (ActionEvent event) {
            System.out.println("Auton 1 jarruja korjattu!");       
    }
    /**
     * auto2jarrutfix-napin painaminen korjaa auton 2 jarruja määrätyn määrän vaihdossa rahaan.
     * @param event 
     */
    @FXML
    public void auto2jarrutfixNappiPainettu (ActionEvent event) {
        System.out.println("Auton 2 jarruja korjattu!");
    }
    /**
     * auto1jarruttune-napin painaminen avaa erillisen ikkunan, jossa voi säätää auton 1 jarrujen painetta.
     * korkea jarrupaine sopii erikoiskokeille, joissa on paljon suoria.
     * matala jarrupaine sopii mutkaisemmille erikoiskokeille. 
     * @param event 
     */
    @FXML
    public void auto1jarruttuneNappiPainettu (ActionEvent event) {
        System.out.println("Auton 1 jarrujen viritysikkuna avattu!");
    }
    /**
     * auto2jarruttune-napin painaminen avaa erillisen ikkunan, jossa voi säätää auton 2 jarrujen painetta.
     * korkea jarrupaine sopii erikoiskokeille, joissa on paljon suoria.
     * matala jarrupaine sopii mutkaisemmille erikoiskokeille.
     * @param event 
     */
    @FXML
    public void auto2jarruttuneNappiPainettu (ActionEvent event) {
        System.out.println("Auton 2 jarrujen viritysikkuna avattu!");
    }
        
        
}