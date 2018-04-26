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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author soati
 */
public class UusiPeliController implements Initializable, ControlledScreen {
    
    ScreensController myController;
    @FXML
    private TextField nameField;
    @FXML
    private TextField teamField;
    @FXML
    private Label errorDisplay;
    
    /**
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    /**
     * 
     * @param screenParent 
     */
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void submitNappiPainettu(ActionEvent event) {
        
        String nimi = nameField.getText();
        String talliNimi = teamField.getText();
        if (nimi.length() != 0 && talliNimi.length() != 0) {
            
            if(testaaSyote(nimi) == true && testaaSyote(talliNimi) == true) {
                myController.getMoco().uusiPeli(nimi, talliNimi);
                myController.setScreen(ScreensFramework.menuID);
            } else {
                errorDisplay.setText("Juur input is invaliidi!");
            }
            
            
        } else {
            errorDisplay.setText("Juur input is empti!");
        }
    }
    /**
     * 
     * @param syote
     * @return 
     */
    private boolean testaaSyote(String syote) {
        return true;
    }
    
}
