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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;

/**
 * Ohjaa kaupan toimintaa
 * 
 * @author Jani
 */
public class Kauppa implements Initializable, ControlledScreen {
    ScreensController myController;
    /**
     * Initializes the controller class.
     */ 
    @FXML
    private Button browseBreaksNappi;
    
    @FXML
    private Button browseMotorsNappi;
    
    @FXML
    private Button browseGearboxNappi;
    
    @FXML
    private Button browseCarsNappi;
    
    @FXML
    private Button browseSuspensionNappi;
    
    @FXML
    private Button browseTurboNappi;
    
    @FXML
    private Button browseTiresNappi;
    
    @FXML
    private ListView ostoNäkymä;
    
    @FXML
    private Label moneySituation;
    
    @FXML
    private Pane popupRuutu;
    
    @FXML
    private Label popupLabel;  
    /**
     * Ruutu määräytyy nappien järjestyksen mukaan vasemmalta oikealle
     * 1 = Autot
     * 2 = Moottorit
     * 3 = Vaihdelaatikot
     * 4 = Jarrut
     * 5 = Jousitukset
     * 6 = Turbo
     * 7 = Renkaat
     */
    private int ruutu = 0;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
    /**
     * Käyttäjän painaessa browseCars nappia päivitetään pelaajan varallisuus
     * Kaikkien muiden nappien väri muutetaan harmaaksi ja browseCars napin värin
     * Korostetaan oranssin sävyisellä värillä
     * Tyhjennetään ostonäkymä (jottei kaksi listaa ole päällekkäin)
     * 
     * Populoidaan ostonäkymä for loopilla joka hakee osatJaAutot luokasta
     * Auto luokan oliot, jotka on luotu pohjiksi
     * 
     * @param e 
     */
    @FXML
    private void browseCarsNappiPainettu(ActionEvent e) {
        System.out.println("Browse cars nappi painettu!");
        
        päivitäRahat();
        
        this.ruutu = 1;
        
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #ffbe6b");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        
        ostoNäkymä.getItems().clear();

        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getAutot()[i].getMerkki()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getMalli()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getHinta());
        }
    }
    
    /**
     * Käyttäjän painaessa browseMotors nappia päivitetään pelaajan varallisuus
     * Kaikkien muiden nappien väri muutetaan harmaaksi ja browseMotors napin värin
     * Korostetaan oranssin sävyisellä värillä
     * Tyhjennetään ostonäkymä (jottei kaksi listaa ole päällekkäin)
     * 
     * Populoidaan ostonäkymä for loopilla joka hakee osatJaAutot luokasta
     * Moottori luokan oliot, jotka on luotu pohjiksi
     * @param e 
     */
    @FXML
    private void browseMotorsNappiPainettu(ActionEvent e) {
        System.out.println("Browse moottori nappi painettu!");
        
        päivitäRahat();
        
        this.ruutu = 2;
        
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #ffbe6b");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        
        ostoNäkymä.getItems().clear();
        
        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getMoottorit()[i].getValmistaja()+"\t\t\t"+myController.getMoco().getOsat().getMoottorit()[i].getNimi()+"\t\t\t"+myController.getMoco().getOsat().getMoottorit()[i].getHinta());
        }
    }
    /**
     * Käyttäjän painaessa browseGearbox nappia päivitetään pelaajan varallisuus
     * Kaikkien muiden nappien väri muutetaan harmaaksi ja browseGearbox napin värin
     * Korostetaan oranssin sävyisellä värillä
     * Tyhjennetään ostonäkymä (jottei kaksi listaa ole päällekkäin)
     * 
     * Populoidaan ostonäkymä for loopilla joka hakee osatJaAutot luokasta
     * Vaihdelaatikko luokan oliot, jotka on luotu pohjiksi
     * @param e 
     */
    @FXML
    private void browseGearboxNappiPainettu(ActionEvent e) {
        System.out.println("Browse gearbox nappi painettu!");
        
        päivitäRahat();
        
        this.ruutu = 3;
        
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #ffbe6b");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");

        ostoNäkymä.getItems().clear();
        
        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getLaatikko()[i].getValmistaja()+"\t\t\t"+myController.getMoco().getOsat().getLaatikko()[i].getNimi()+"\t\t\t"+myController.getMoco().getOsat().getLaatikko()[i].getHinta());
        }
    }
    /**
     * Käyttäjän painaessa browseBreaks nappia päivitetään pelaajan varallisuus
     * Kaikkien muiden nappien väri muutetaan harmaaksi ja browseBreaks napin värin
     * Korostetaan oranssin sävyisellä värillä
     * Tyhjennetään ostonäkymä (jottei kaksi listaa ole päällekkäin)
     * 
     * Populoidaan ostonäkymä for loopilla joka hakee osatJaAutot luokasta
     * Jarrut luokan oliot, jotka on luotu pohjiksi
     * 
     * @param e 
     */
    @FXML
    private void browseBreaksNappiPainettu(ActionEvent e) {
        System.out.println("Browse jarrut painettu!");
        
        päivitäRahat();
        
        this.ruutu = 4;
        
        browseBreaksNappi.setStyle("-fx-background-color: #ffbe6b");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        
        ostoNäkymä.getItems().clear();

        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getJarrut()[i].getValmistaja()+"\t\t\t"+myController.getMoco().getOsat().getJarrut()[i].getNimi()+"\t\t\t"+myController.getMoco().getOsat().getJarrut()[i].getHinta());
        }
    }
    /**
     * Käyttäjän painaessa browseSuspension nappia päivitetään pelaajan varallisuus
     * Kaikkien muiden nappien väri muutetaan harmaaksi ja browseSuspension napin värin
     * Korostetaan oranssin sävyisellä värillä
     * Tyhjennetään ostonäkymä (jottei kaksi listaa ole päällekkäin)
     * 
     * Populoidaan ostonäkymä for loopilla joka hakee osatJaAutot luokasta
     * Jousitus luokan oliot, jotka on luotu pohjiksi
     * @param e 
     */
    @FXML
    private void browseSuspensionNappiPainettu(ActionEvent e) {
        System.out.println("Browse suspension nappi painettu!");
        
        päivitäRahat();
        
        this.ruutu = 5;
        
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #ffbe6b");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        
        ostoNäkymä.getItems().clear();
        
        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getJousitukset()[i].getValmistaja()+"\t\t\t"+myController.getMoco().getOsat().getJousitukset()[i].getNimi()+"\t\t\t"+myController.getMoco().getOsat().getJousitukset()[i].getHinta());
        }
    }
    
    /**
     * Käyttäjän painaessa browseTurbo nappia päivitetään pelaajan varallisuus
     * Kaikkien muiden nappien väri muutetaan harmaaksi ja browseTurbo napin värin
     * Korostetaan oranssin sävyisellä värillä
     * Tyhjennetään ostonäkymä (jottei kaksi listaa ole päällekkäin)
     * 
     * Populoidaan ostonäkymä for loopilla joka hakee osatJaAutot luokasta
     * Turbo luokan oliot, jotka on luotu pohjiksi
     * 
     * @param e 
     */
    @FXML
    private void browseTurboNappiPainettu(ActionEvent e) {
        System.out.println("Browse turbo nappi painettu!");
        
        päivitäRahat();
        
        this.ruutu = 6;
        
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #ffbe6b");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        
        ostoNäkymä.getItems().clear();

        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getTurbo()[i].getValmistaja()+"\t\t\t"+myController.getMoco().getOsat().getTurbo()[i].getNimi()+"\t\t\t"+myController.getMoco().getOsat().getTurbo()[i].getHinta());
        }
    }
    /**
     * Käyttäjän painaessa browseTires nappia päivitetään pelaajan varallisuus
     * Kaikkien muiden nappien väri muutetaan harmaaksi ja browseTires napin värin
     * Korostetaan oranssin sävyisellä värillä
     * Tyhjennetään ostonäkymä (jottei kaksi listaa ole päällekkäin)
     * 
     * Populoidaan ostonäkymä for loopilla joka hakee osatJaAutot luokasta
     * Renkaat luokan oliot, jotka on luotu pohjiksi
     *  
     * @param e 
     */
    @FXML
    private void browseTiresNappiPainettu(ActionEvent e) {
        System.out.println("Browse tires nappi painettu!");
        
        this.ruutu = 7;
        
        päivitäRahat();
        
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #ffbe6b");
        
        ostoNäkymä.getItems().clear();
        
        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getRenkaat()[i].getValmistaja()+"\t\t\t"+myController.getMoco().getOsat().getRenkaat()[i].getNimi()+"\t\t\t"+myController.getMoco().getOsat().getRenkaat()[i].getHinta());
        }
    }
    /**
     * Pelaajan painaessa osta nappia haetaan listalta pelaajan valitseman
     * tuotteen indeksi ja switch määrittelee minkä kategorian osa on kyseessä
     * 
     * Pelaajan valitsema tuote yritetään ostaa ja mikäli saadaan paluuarvona true
     * Pelaajalle lisätään kyseinen osa inventaarioon ja laitetaan popup ikkuna
     * Näkyväksi (opacity 1) ja aktoivoidaan ruutu (setdiasabled false))
     * Jossa kerrotaan pelaajalle minkä osan käyttäjä osti
     * 
     * Jos pelaajan varallisuus ei riittäny (saatiin paluuarvona false)
     * Laitetaan popup ikkuna näkyväksi kuten yllä ja nyt ruudulla
     * on teksti joka kertoo pelaajan varallissuuden riittämättömyydestä
     * 
     * @param e 
     */
    @FXML
    private void ostaNappiPainettu(ActionEvent e) {
        int valinta = ostoNäkymä.getSelectionModel().getSelectedIndex();
        switch (this.ruutu) {
            case 1:
                //Auto
                if (myController.getMoco().getPelaajanTalli().ostaAuto(myController.getMoco().getOsat(), valinta) == true) {
                    myController.getMoco().getPelaajanTalli().setYkkosauto(myController.getMoco().getPelaajanTalli().getAutot()[0]);
                    popupLabel.setText("Juu hav bout\n" + myController.getMoco().getOsat().getAutot()[valinta].getMerkki() + " " + myController.getMoco().getOsat().getAutot()[valinta].getMalli() + "\nFör:" + myController.getMoco().getOsat().getAutot()[valinta].getHinta());
                    popupRuutu.setDisable(false);
                    popupRuutu.setOpacity(1);
                } else {
                    error();
                }
                break;
            case 2:
                //Moottori
                if (myController.getMoco().getPelaajanTalli().ostaMoottori(myController.getMoco().getOsat(), valinta) == true) {
                    popupLabel.setText("Juu hav bout\n" + myController.getMoco().getOsat().getMoottorit()[valinta].getValmistaja() + " " + myController.getMoco().getOsat().getMoottorit()[valinta].getNimi() + "\nFör:" + myController.getMoco().getOsat().getMoottorit()[valinta].getHinta());
                    popupRuutu.setDisable(false);
                    popupRuutu.setOpacity(1);
                } else {
                    error();
                }
                break;
            case 3:
                //Vaihdelaatikot
                if (myController.getMoco().getPelaajanTalli().ostaVaihdelaatikko(myController.getMoco().getOsat(), valinta) == true) {
                    popupLabel.setText("Juu hav bout\n" + myController.getMoco().getOsat().getLaatikko()[valinta].getValmistaja() + " " + myController.getMoco().getOsat().getLaatikko()[valinta].getNimi() + "\nFör:" + myController.getMoco().getOsat().getLaatikko()[valinta].getHinta());
                    popupRuutu.setDisable(false);
                    popupRuutu.setOpacity(1);
                } else {
                    error();
                }
                break;
            case 4:
                //Jarrut
                if (myController.getMoco().getPelaajanTalli().ostaVaihdelaatikko(myController.getMoco().getOsat(), valinta) == true) {
                    popupLabel.setText("Juu hav bout\n" + myController.getMoco().getOsat().getJarrut()[valinta].getValmistaja() + " " + myController.getMoco().getOsat().getJarrut()[valinta].getNimi() + "\nFör:" + myController.getMoco().getOsat().getJarrut()[valinta].getHinta());
                    popupRuutu.setDisable(false);
                    popupRuutu.setOpacity(1);
                } else {
                    error();
                }
                break;
            case 5:
                //Jouset
                if (myController.getMoco().getPelaajanTalli().ostaJouset(myController.getMoco().getOsat(), valinta) == true) {
                    popupLabel.setText("Juu hav bout\n" + myController.getMoco().getOsat().getJousitukset()[valinta].getValmistaja() + " " + myController.getMoco().getOsat().getJousitukset()[valinta].getNimi() + "\nFör:" + myController.getMoco().getOsat().getJousitukset()[valinta].getHinta());
                    popupRuutu.setDisable(false);
                    popupRuutu.setOpacity(1);
                } else {
                    error();
                }
                break;
            case 6:
                //Turbot
                if (myController.getMoco().getPelaajanTalli().ostaTurbo(myController.getMoco().getOsat(), valinta) == true) {
                    popupLabel.setText("Juu hav bout\n" + myController.getMoco().getOsat().getTurbo()[valinta].getValmistaja() + " " + myController.getMoco().getOsat().getTurbo()[valinta].getNimi() + "\nFör:" + myController.getMoco().getOsat().getTurbo()[valinta].getHinta());
                    popupRuutu.setDisable(false);
                    popupRuutu.setOpacity(1);
                } else {
                    error();
                }
                break;
            case 7:
                // Renkaat
                if (myController.getMoco().getPelaajanTalli().ostaRenkaat(myController.getMoco().getOsat(), valinta) == true) {
                    popupLabel.setText("Juu hav bout\n" + myController.getMoco().getOsat().getRenkaat()[valinta].getValmistaja() + " " + myController.getMoco().getOsat().getRenkaat()[valinta].getNimi() + "\nFör:" + myController.getMoco().getOsat().getRenkaat()[valinta].getHinta());
                    popupRuutu.setDisable(false);
                    popupRuutu.setOpacity(1);
                } else {
                    error();
                }
                break;
            default:
                popupLabel.setText("Juu did nat tsuus anyting");
                popupRuutu.setDisable(false);
                popupRuutu.setOpacity(1);
                break;
            }
        päivitäRahat();
    }
    
    /**
     * Ok nappi on popup ruudun child elementti joten joka kerta
     * Kun popup ikkuna enabloidaan ja tuodaan näkyviin tulee
     * Myös ok nappi esiin ja aktiiviseksi
     * 
     * Ok napilla pelaaja voi kuitata jokaisen "popup ikkunan"
     * Joka asettaa popup ruudun taas näkymättömiin ja disabloi sen
     * 
     * @param e 
     */    
    @FXML
    private void okNappiPainettu (ActionEvent e) {
        popupRuutu.setOpacity(0);
        popupRuutu.setDisable(true);
    } 
    /**
     * Tuotetaan virhepopup
     */
    public void error() {
        popupLabel.setText("Juu hav nou mani tu pui tis!");
        popupRuutu.setDisable(false);
        popupRuutu.setOpacity(1);
    }
    /**
     * Päivittää oikean yläkulman rahatilanteen
     */
    public void päivitäRahat() {
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
    }

    
}