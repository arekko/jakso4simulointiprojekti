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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author soati
 */
public class RacecontrolController implements Initializable, ControlledScreen {
    ScreensController myController;
    
    @FXML
    private Canvas drawTrack;
    @FXML
    private TextFlow fxAjotiedot;
    @FXML
    private Text aika;
    
    //private final ModelController moco = myController.getMoco();
    
    /**
     * Initializes the controller class.
     * @param screenParent
     */
    
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GraphicsContext g = drawTrack.getGraphicsContext2D();
         
        g.setFill(Color.GRAY);
        g.fillRect(0,0,1200,1200);
        
        g.setStroke(Color.GREEN);
        g.setLineWidth(10);
        
        g.strokeLine(100, 20, 100, 200);
        g.strokeLine(100, 200, 150, 250);
        g.strokeLine(150, 250, 70, 300);
 
    }
    @FXML
    public void kovempaaPainettu (ActionEvent event) {
        System.out.println("Kovempaa painettu");
    }
    @FXML
    public void hiljempaaPainettu (ActionEvent event) {
        System.out.println("Hiljempaa painettu");
    }
    @FXML
    public void pidaVauhtiPainettu (ActionEvent event) {
        System.out.println("Pidä vauhti painettu");
    }
    @FXML
    public void simuloiPainettu (ActionEvent event) {
        System.out.println("Simuloi painettu");
        Text teksti = new Text("Testijuttu.\n");
        Text teksti2 = new Text("Testijuttu2.");
        Text teksti3 = new Text("Tekstijuttu3!");
        fxAjotiedot.getChildren().add(teksti);
        fxAjotiedot.getChildren().add(teksti2);
        fxAjotiedot.getChildren().add(teksti3);
        aika.setText("00:00:01");
    }
    
    
}
