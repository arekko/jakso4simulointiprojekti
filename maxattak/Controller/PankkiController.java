

package maxattak.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import maxattak.ControlledScreen;
import maxattak.ScreensFramework;

public class PankkiController implements Initializable, ControlledScreen {

    ScreensController myController;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label moneyStatus;

    @FXML
    private Button moneyButton;

    @FXML
    private TextField moneyInputField;

    @FXML
    private TextField maksaLainaField;

    @FXML
    private Button maksaLainaButton;

    @FXML
    private Label velka;

    @FXML
    private Label lainaMäärä;

    @FXML
    private Label lainanKorko;

    @FXML
    private Button backButton;

    @FXML
    private Label errorMessage;

    @FXML
    private Label errorMessage2;

    @FXML
    private Label budget;

    @FXML
    void backNappiPainettu(ActionEvent event) {
        System.out.println("Back nappi painettu!");
        myController.unloadScreen("menuID");
        myController.loadScreen(ScreensFramework.menuID, ScreensFramework.menuFile);
        myController.setScreen(ScreensFramework.menuID);
    }

    @FXML
    void haeLaina(ActionEvent event) {

    }

    @FXML
    void maksaLainaa(ActionEvent event) {

    }

    @FXML
    void showKorko(DragEvent event) {

    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        moneyButton.setOnAction(event -> {
            String stringInput = moneyInputField.getText().trim();
            if(!stringInput.equals("") && stringInput.matches(".*\\d+.*")){
                double rahaMaara = Double.parseDouble(stringInput);
                if ((rahaMaara <= getBudjetti()) && rahaMaara > 0){
                    moneyInputField.setText("");
                    myController.getMoco().getPelaajanTalli().getLainaa(rahaMaara);
                    päivitäRahat();
                } else {
                    moneyInputField.setText("");
                    errorMessage.setText("Voit hakea 0 - " + getBudjetti() + " $");
                }
            } else {
                moneyInputField.setText("");
                errorMessage.setText("Laita numerot!");
            }
            System.out.println(myController.getMoco().getPelaajanTalli().getBudjetti());
            päivitäVelka();
            päivitäBudjetti();
            showKorko();
        });
        maksaLainaButton.setOnAction(event -> {
            String stringInput = maksaLainaField.getText().trim();
            if(!stringInput.equals("") && stringInput.matches(".*\\d+.*")){
                double rahaMaara = Double.parseDouble(stringInput);
                double velka = myController.getMoco().getPelaajanTalli().getVelka();
                if ( myController.getMoco().getPelaajanTalli().getSaldo() >= rahaMaara  && rahaMaara <= velka){
                    maksaLainaField.setText("");
                    myController.getMoco().getPelaajanTalli().maksaLainaa(rahaMaara);
                    päivitäRahat();
                } else {
                    moneyInputField.setText("");
                    errorMessage2.setText("You dont have enough money!");
                }
            } else {
                moneyInputField.setText("");
                errorMessage2.setText("Laita numerot!");
            }
            päivitäVelka();
            päivitäBudjetti();
        });

    }

    public void päivitäRahat() {
        moneyStatus.setText(" $ " + myController.getMoco().getPelaajanTalli().getSaldo());
    }
    public void päivitäVelka(){
        lainaMäärä.setText("$" + myController.getMoco().getPelaajanTalli().getVelka());
    }
    public void päivitäBudjetti(){
        budget.setText("( $" + myController.getMoco().getPelaajanTalli().getBudjetti() + " )");
    }
    public void showKorko(){
        lainanKorko.setText("% " + myController.getMoco().getPelaajanTalli().getKorko());
    }

    public double getBudjetti(){
        return myController.getMoco().getPelaajanTalli().getBudjetti();
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
        päivitäRahat();
    }





}
