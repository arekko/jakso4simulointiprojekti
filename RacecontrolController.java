/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxattak;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

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
    private Text aika;
    @FXML
    private Slider ekaPace;
    @FXML
    private Slider tokaPace;
    @FXML
    private ListView aiAjat;
    @FXML
    private ListView ykkosAuto;
    @FXML
    private ListView kakkosAuto;
    @FXML
    private ListView kisaTiedot;
    @FXML
    private Label ekaAika;
    @FXML
    private Label tokaAika;
    @FXML
    private Label testiTeksti;
    @FXML
    private Pane newsRuutu;
    @FXML
    private Circle ykkonenRadalla;
    
    Random testi = new Random();
    
    private String[] lista = {"Jarmo has fallen!", "Irma crashed"};
    /**
     * Initializes the controller class.
     * @param screenParent
     */
    
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        testiTeksti.setText(lista[testi.nextInt(lista.length)]);     
        ykkonenRadalla.setCenterX(50);
        ykkonenRadalla.setCenterY(50);
        GraphicsContext g = drawTrack.getGraphicsContext2D();
         
        g.setFill(Color.BLACK);
        g.fillRect(0,0,1200,1200);
        
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
    @FXML
    public void takaisinNappiPainettu (ActionEvent event) {
        myController.setScreen(ScreensFramework.menuID);
        System.out.println("Takaisin nappia painettu");
    }
    @FXML
    public void lopetaNappiPainettu (ActionEvent event) {
        System.out.println("Lopeta nappia painettu");
        System.exit(0);
    }
    @FXML
    public void simuloiNappiPainettu (ActionEvent event) {
        System.out.println("Simuloi painettu");
        
            
        for (int i = 0; i < 10; i++) {
            double alkuX = ykkonenRadalla.getCenterX();
            double alkuY = ykkonenRadalla.getCenterY();
            double x = testi.nextInt(600);
            double y = testi.nextInt(600);
            alkuX = x;
            alkuY = y;
            boolean a = false;
            do {
                TranslateTransition testit = new TranslateTransition();
                testit.setDuration(Duration.seconds(3));
                testit.setNode(ykkonenRadalla);
                testit.setToX(x);
                testit.setToY(y);
                testit.play();
                if (ykkonenRadalla.getCenterX() == alkuX && ykkonenRadalla.getCenterY() == alkuY ) {
                    a = true;
                } else {
                    x = testi.nextDouble();
                    y = testi.nextDouble();
                }
            } while (a = false);
            
        }
    }
    @FXML
    public void okNappiPainettu(ActionEvent event) {
        newsRuutu.setOpacity(0);
        newsRuutu.setDisable(true);
    }
    
    
}
