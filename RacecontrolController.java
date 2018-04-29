/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak.Controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import maxattak.ControlledScreen;
import maxattak.Model.Auto;
import maxattak.Model.Sarja;
import maxattak.Model.Simulointi;
import maxattak.Model.Talli;
import maxattak.ScreensFramework;

/**
 * Racecontrol.fxml näkymän kontrolleri
 *
 * @author soati
 */
public class RacecontrolController implements Initializable, ControlledScreen {
    ScreensController myController;
    
    @FXML private Canvas drawTrack;
    @FXML private Text aika;

    
    @FXML private TextFlow aiAjat;
    @FXML private ListView kisaTiedot;
    
    /**
     * Popupruutuun liittyvät muuttujat
     */
    @FXML private Pane popupRuutu;
    @FXML private ListView lista;
    /**
     * Virheruutuun liittyvät muuttujat
     */
    @FXML private Pane virheRuutu;
    @FXML private Label virheTeksti;
    /**
     * Ykkösautoon liittyvät muuttujat
     */
    @FXML private Label auto1;
    @FXML private Slider ekaPace;
    @FXML private Label ekaPaceLabel;
    @FXML private Label auto1Kuski;
    @FXML private Label auto1Sijoitus;
    @FXML private Label auto1Performance;
    @FXML private Button changeCar1;
    @FXML private Button ekaReady;
    @FXML private Circle ykkonenRadalla;
    @FXML private Label ekaAika;
    /**
     * Kakkosautoon liittyvät muuttujat
     */
    @FXML private Label auto2;
    @FXML private Slider tokaPace;
    @FXML private Label tokaPaceLabel;
    @FXML private Label auto2Kuski;
    @FXML private Label auto2Sijoitus;
    @FXML private Label auto2Performance;
    @FXML private Button changeCar2;
    @FXML private Button tokaReady;
    @FXML private Circle kakkonenRadalla;
    @FXML private Label tokaAika;
    
    private Simulointi simu;
    private Talli talli;
    private Sarja sarja;
    private int ruutu = 0;
    private int virhe = 0;
    private boolean ekaValmis = false;
    private boolean tokaValmis = false;
    private boolean softLock = true;
    private Random ra = new Random();
    /**
     * 
     * @param screenParent 
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
        talli = myController.getMoco().getPelaajanTalli();
        sarja = talli.getTallinSarja();
        simu = myController.getMoco().getSimulointi();
        päivitä();
    }
    /**
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        GraphicsContext g = drawTrack.getGraphicsContext2D();
         
        g.setFill(Color.BLACK);
        g.fillRect(0,0,drawTrack.getWidth(),drawTrack.getHeight());
        
        g.setStroke(Color.RED);
        g.setLineWidth(10);
        
        g.beginPath();
        g.moveTo(50,50);
        g.lineTo(100, 100);
        g.bezierCurveTo(100, 100, 50, 160, 70, 200);
        g.bezierCurveTo(70, 200, 400, 50, 100, 300);
        g.bezierCurveTo(100, 300, 260, 330, 200, 45);
        g.stroke();
        g.closePath();
        g.setFill(Color.GREEN);
        //g.setStroke(Color.GREEN);
        //g.fillOval(40, 40, 20, 20);
        
       //g.strokeLine(100, 20, 100, 200);
        
        //g.arcTo(100, 200, 150, 250, 15);
        /*
        g.strokeLine(100, 200, 150, 250);
        //g.strokeLine(150, 250, 70, 300);
        g.setLineWidth(10);
        g.beginPath();
        g.lineTo(100, 0);
        g.bezierCurveTo(150, 250, 70, 30, 200, 200);
        g.lineTo(100, 0);
        g.fill();
        g.closePath();
        g.fill();
        */
        
    }
    /**
     * 
     * @param event Palauttaa takaisin päävalikkoon.
     */
    @FXML public void takaisinNappiPainettu (ActionEvent event) {
        myController.setScreen(ScreensFramework.menuID);
        System.out.println("Takaisin nappia painettu");
    }
    /**
     * 
     * @param event Lopettaa ohjelman suorituksen.
     */
    @FXML public void lopetaNappiPainettu (ActionEvent event) {
        System.out.println("Lopeta nappia painettu");
        System.exit(0);
    }
    /**
     * Simulointi painike aloittaa kisan simuloinnin.
     * Jos molemmat autot ja kuljettajat ovat valmiina poistetaan softlock ja
     * kisan simulointi voi alkaa. Jos toinen on valmis poistetaan softlock, mutta
     * ilmoitetaan pelaajalle että vain toinen kuljettajista on valmis.
     * Simuloinnin uudelleen painaminen antaa pelaajan simuloida kisan yhdellä
     * autolla. Jos kumpikaan autoista ei ollut valmis niin pelaaja tehdään tästä tietoiseksi
     * ja pelaaja ei voi simuloida kilpailua.
     * 
     * @param event Simulointi napin painalluksen handler.
     */
    @FXML public void simuloiNappiPainettu (ActionEvent event) {
        System.out.println("Simuloi painettu");
        if (ekaValmis && tokaValmis) {
            softLock = false;
        }
        if (ekaValmis || tokaValmis && softLock == false) {
            double leveys = drawTrack.getWidth();
            double korkeus = drawTrack.getHeight();
            System.out.println(leveys);
            System.out.println(korkeus);
            ykkonenRadalla.setOpacity(1);
            ykkonenRadalla.setDisable(false);
            ykkonenRadalla.setTranslateX(drawTrack.getLayoutX()+30);
            ykkonenRadalla.setTranslateY(drawTrack.getLayoutY()+30);
            System.out.println(drawTrack.getLayoutX());
            System.out.println(drawTrack.getLayoutY());
        } else if (ekaValmis ||tokaValmis) {
            virheRuutu.setOpacity(1);
            virheRuutu.setDisable(false);
            virheTeksti.setText("Juu did nat redi\bouth kaars\nRedi the oter kaar!\nIf juu press simulation\nagen you draiv with one kaar!");
            softLock = false;
            virhe = 3;
        } else {
            virheRuutu.setOpacity(1);
            virheRuutu.setDisable(false);
            virheTeksti.setText("Juu did nat redi kaars!");
            virhe = 4;
        }
        /*Talli[] tallit = sarja.getTallit();
        aiAjat.getChildren().clear();
        List<String> nimet = new ArrayList<>();
        List<Integer> ajat = new ArrayList<>();
        for (Talli alli:tallit) {
            if (alli.getPelaajantalli() != true) {
                Kuljettaja ekaKuski = alli.getYkkoskuski();
                Kuljettaja tokaKuski = alli.getKakkoskuski();
                Auto ekaAuto = alli.getYkkosauto();
                Auto tokaAuto = alli.getKakkosauto();
                
                int eka = simu.laskeAika(ekaKuski, ekaAuto);
                nimet.add(ekaKuski.getNimi());
                ajat.add(eka);
                int toka = simu.laskeAika(tokaKuski, tokaAuto);
                nimet.add(tokaKuski.getNimi());
                ajat.add(toka);
                
                
                int num1 = ra.nextInt(100);
                int num2 = ra.nextInt(100);
                Text toAdd1 = new Text();
                Text toAdd2 = new Text();
                toAdd1.setText(knimi+"\n"+num1+"\n");
                toAdd2.setText(knimi2+"\n"+num2+"\n");
                aiAjat.getChildren().add(toAdd1);
                aiAjat.getChildren().add(toAdd2);        
            }     
        }
        String ff = järjestä(nimet, ajat);**/
    }
    /**
     * Ensimmäisen auton vaihtamisnapin event handler.
     * Asetetaan popup ruutu näkyviin johon haetaan pelaajan omistamat autot.
     * @param e Ensimmäistä auton vaihto nappia painettu.
     */
    @FXML public void changeCar1NappiPainettu(ActionEvent e) {
        this.ruutu = 1;
        popupRuutu.setOpacity(1);
        popupRuutu.setDisable(false);
        lista.getItems().clear();
        if (talli.getAutot().length > 0) {
            for (Auto autot : talli.getAutot()) {
                if (autot == talli.getKakkosauto()) {
                    lista.getItems().remove(autot);
                    lista.getItems().add(autot.getMalli()+" "+autot.getMerkki()+" Kaar is being by oter draiver");
                } else {
                    lista.getItems().add(autot);
                }
            }
        }
        
    }
    /**
     * Toisen auton vaihtamisnapin event handler.
     * Asetetaan popup ruutu näkyviin johon haetaan pelaajan omistamat autot.
     * @param e Toisen auton vaihto nappia painettu.
     */
    @FXML public void changeCar2NappiPainettu(ActionEvent e) {
        this.ruutu = 2;
        popupRuutu.setOpacity(1);
        popupRuutu.setDisable(false);
        lista.getItems().clear();
        if (talli.getAutot().length > 0) {
            for (Auto autot : talli.getAutot()) {
                if (autot == talli.getYkkosauto()) {
                    lista.getItems().remove(autot);
                    lista.getItems().add(autot.getMalli()+" "+autot.getMerkki()+" Kaar is being by oter draiver");
                } else {
                    lista.getItems().add(autot);
                }
            }
        }
    }
    /**
     * Ensimmäinen auto valmis painikkeen event handler.
     * Pelaajan painaessa painiketta katsotaan onko pelaajalla ensimmäistä autoa asetettuna.
     * Jos ensimmäisen auto oli valittanu niin tarkastetaan oliko pelaajalla ensimmäinen kuljettaja.
     * Jos jompikumpi ei toteutunut niin pelaaja saa asianmukaiset virheet.
     * @param e Ensimmäisen auton ready painike.
     */
    @FXML public void ekaReadyPainettu(ActionEvent e) {
        if (talli.getYkkosauto() == null) {
            virhe = 2;
            virheRuutu.setOpacity(1);
            virheRuutu.setDisable(false);
            virheTeksti.setText("Juu häv nat chousen\neny kaars!");
        } else {
            if (talli.getYkkoskuski() == null) {
                virhe = 5;
                virheRuutu.setOpacity(1);
                virheRuutu.setDisable(false);
                virheTeksti.setText("Juu dont häv draiver!");
            } else {
                ekaValmis = true;
                ekaReady.setDisable(true);
                ekaReady.setOpacity(0);
                ekaPace.setDisable(false);
                ekaPace.setOpacity(1);
                changeCar1.setDisable(true);
                changeCar1.setOpacity(0);
                ekaPaceLabel.setOpacity(1);
                ekaPaceLabel.setDisable(false);
            }
        }
    }
    /**
     * Toisen auto valmis painikkeen event handler.
     * Pelaajan painaessa painiketta katsotaan onko pelaajalla toista autoa asetettuna.
     * Jos ensimmäisen auto oli valittanu niin tarkastetaan oliko pelaajalla toinen kuljettaja.
     * Jos jompikumpi ei toteutunut niin pelaaja saa asianmukaiset virheet.
     * @param e Toisen auton ready painike.
     */
    @FXML public void tokaReadyPainettu(ActionEvent e) {
         if (talli.getKakkosauto() == null) {
            virhe = 2;
            virheRuutu.setOpacity(1);
            virheRuutu.setDisable(false);
            virheTeksti.setText("Juu häv nat chousen\neny kaars!");
        } else {
            if (talli.getKakkoskuski() == null) {
                virhe = 5;
                virheRuutu.setOpacity(1);
                virheRuutu.setDisable(false);
                virheTeksti.setText("Juu dont häv draiver!");
            } else {
                tokaValmis = true;
                tokaReady.setDisable(true);
                tokaReady.setOpacity(0);
                tokaPace.setDisable(false);
                tokaPace.setOpacity(1);
                changeCar2.setDisable(true);
                changeCar2.setOpacity(0);
                tokaPaceLabel.setOpacity(1);
                tokaPaceLabel.setDisable(false);
            }
        }
    }
    /**
     * Popup ruudun ok napin event handler.
     * Katsotaan mikä oli pelaajan valinta listalta.
     * Switch pitää kirjaa tuliko pelaaja ensimmäisen vai toisen auton kautta
     * popup ruutuun. Jos pelaaja valitsi ykkösautoksi saman kuin toinen auto tai
     * toisinpäin niin pelaaja saa asianmukaiset virheet.
     * 
     * Jos pelaajalla ei ollut yhtäkään autoa mistä valita pelaaja saa asianmukaisen virheen.
     * 
     * Jos pelaaja välttyi virheiltä niin pelaajan valinta asetetaan voimaan.
     * 
     * @param e Popup ruudun ok nappia painettu.
     */
    @FXML public void okNappiPainettu(ActionEvent e) {
        int valinta = lista.getSelectionModel().getSelectedIndex();
  
           switch (this.ruutu) {
            case 1:
                try {
                    if (talli.getAutot()[valinta] == talli.getKakkosauto()) {
                        virheRuutu.setOpacity(1);
                        virheRuutu.setDisable(false);
                        virheTeksti.setText("Kaar alredi juused\nby oter draiver!");
                        virhe = 6;
                    } else {
                        talli.setYkkosauto(talli.getAutot()[valinta]);
                        popupRuutu.setOpacity(0);
                        popupRuutu.setDisable(true);
                        päivitä();
                        System.out.println("Vaihdetaan ykkösauto!");
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    virheRuutu.setOpacity(1);
                    virheRuutu.setDisable(false);
                    virheTeksti.setText("Juu hav nou kaars!");
                    virhe = 1;
                }
                break;
            case 2:
                try {  
                    if (talli.getAutot()[valinta] == talli.getYkkosauto()) {
                        virheRuutu.setOpacity(1);
                        virheRuutu.setDisable(false);
                        virheTeksti.setText("Kaar alredi juused\nby oter draiver!");
                        virhe = 6;
                    } else {
                        talli.setKakkosauto(talli.getAutot()[valinta]);
                        popupRuutu.setOpacity(0);
                        popupRuutu.setDisable(true);
                        päivitä();
                        System.out.println("Vaihdetaan kakkosauto!");
                    }
                } catch (Exception ex) {
                    virheRuutu.setOpacity(1);
                    virheRuutu.setDisable(false);
                    virheTeksti.setText("Juu hav nou kaars!");
                    virhe = 1;
                }
                break;
            default:
                break;
            
        }
        this.ruutu = 0;
    }/**
     * Virhe popup ruudun ok napin eventhandler.
     * Katsotaan mikä virhe oli kyseessä ja toimitaan sen mukaan.
     * 
     * @param e Virhe popup ruudun ok nappia painettu.
     */
    @FXML public void virheKuittausNappiPainettu(ActionEvent e) {
        switch(this.virhe) {
            case 1:
                virheRuutu.setOpacity(0);
                virheRuutu.setDisable(true);
                popupRuutu.setOpacity(0);
                popupRuutu.setDisable(true);
                break;
            case 2:
                virheRuutu.setOpacity(0);
                virheRuutu.setDisable(true);
                break;
            case 3:
                virheRuutu.setOpacity(0);
                virheRuutu.setDisable(true);
                break;
            case 4:
                virheRuutu.setOpacity(0);
                virheRuutu.setDisable(true);
                break;
            case 5:
                virheRuutu.setOpacity(0);
                virheRuutu.setDisable(true);
                break;
            case 6:
                virheRuutu.setOpacity(0);
                virheRuutu.setDisable(true);
                popupRuutu.setOpacity(0);
                popupRuutu.setDisable(true);
                break;
        }
        
        
    }
    /**
     * Päivittää ruudun näkymän.
     */
    private void päivitä() {
        if (talli.getYkkosauto() != null) {
            auto1.setText("Car 1 - "+talli.getEkaAuto());
        }
        if (talli.getKakkosauto() != null) {
            auto2.setText("Car 2 - "+talli.getTokaAuto());
        }
        if (talli.getYkkoskuski() != null) {
            auto1Kuski.setText(talli.getYkkoskuski().getNimi());
        }
        if (talli.getKakkoskuski() != null) {
            auto2Kuski.setText(talli.getKakkoskuski().getNimi());  
        }
    } 

    /*private String järjestä(List<String> nimet, List<Integer> ajat) {
        for (int i = 0; i < ajat.size();i++) {
            ajat
        }
    }*/


}

