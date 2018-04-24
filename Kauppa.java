/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author soati
 */
public class Kauppa implements Initializable, ControlledScreen {
    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextArea tietoKentta;
    
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
    
    private int ruutu = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    @FXML
    private void ostaAutoNappiPainettu(ActionEvent e) {
        System.out.println("Osta auto nappi painettu");
        String tekstit = "Merkki\t\t\tMalli\t\t\tHinta";
        
        for (int i = 0; i < 10; i++) {
            tekstit = tekstit+"\n"+myController.getMoco().getOsat().getAutot()[i].getMerkki()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getMalli()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getHinta();
        }
        //paivitaTekstiKentta(tekstit);
    }
    @FXML
    private void browseBreaksNappiPainettu(ActionEvent e) {
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
        browseBreaksNappi.setStyle("-fx-background-color: #ffbe6b");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        
        System.out.println("Osta Jarrut painettu1");
    }
    @FXML
    private void browseMotorsNappiPainettu(ActionEvent e) {
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #ffbe6b");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        System.out.println("Osta moottori nappi painettu!");
    }
    @FXML
    private void browseSuspensionNappiPainettu(ActionEvent e) {
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #ffbe6b");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        System.out.println("Osta jousitus nappi painettu!");
    }
    @FXML
    private void browseGearboxNappiPainettu(ActionEvent e) {
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #ffbe6b");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        System.out.println("Osta vaihdelaatikko nappi painettu!");
    }
    @FXML
    private void ostaNappiPainettu(ActionEvent e) {
        int valinta = ostoNäkymä.getSelectionModel().getSelectedIndex();
        if (this.ruutu == 1) {
            if (myController.getMoco().getPelaajanTalli().ostaAuto(myController.getMoco().getOsat(), valinta) == true) {
                moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
            } else {
                popupRuutu.setDisable(false);
                popupRuutu.setOpacity(1);
            }
        }
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
    }
    @FXML
    private void browseCarsNappiPainettu(ActionEvent e) {
        this.ruutu = 1;
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #ffbe6b");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
        ostoNäkymä.getItems().clear();
        //String[] tekstit;
        for (int i = 0; i < 10; i++) {
            ostoNäkymä.getItems().add(myController.getMoco().getOsat().getAutot()[i].getMerkki()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getMalli()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getHinta());
             //tekstit[i] = ""+myController.getMoco().getOsat().getAutot()[i].getMerkki()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getMalli()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getHinta();
                     //+"\n"+myController.getMoco().getOsat().getAutot()[i].getMerkki()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getMalli()+"\t\t\t"+myController.getMoco().getOsat().getAutot()[i].getHinta();
        }
        //ostoNäkymä.getItems().add
    }
    @FXML
    private void browseTurboNappiPainettu(ActionEvent e) {
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #ffbe6b");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #d3d3d3");
    }
    @FXML
    private void browseTiresNappiPainettu(ActionEvent e) {
        moneySituation.setText("$ "+myController.getMoco().getPelaajanTalli().getVarallisuus());
        browseBreaksNappi.setStyle("-fx-background-color: #d3d3d3");
        browseCarsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseSuspensionNappi.setStyle("-fx-background-color: #d3d3d3");
        browseMotorsNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTurboNappi.setStyle("-fx-background-color: #d3d3d3");
        browseGearboxNappi.setStyle("-fx-background-color: #d3d3d3");
        browseTiresNappi.setStyle("-fx-background-color: #ffbe6b");
    }
    @FXML
    private void okNappiPainettu (ActionEvent e) {
        popupRuutu.setOpacity(0);
        popupRuutu.setDisable(true);
    }
    private void paivitaTekstiKentta(String teksti) {
        tietoKentta.setText(teksti);
    }
}
/*myController.getMoco().getPelaajanTalli().ostaAuto(myController.getMoco().getOsat(), 0);
        System.out.println(myController.getMoco().getPelaajanTalli().getVarallisuus());*/