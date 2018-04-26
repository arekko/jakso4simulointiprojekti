/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License"). You
 * may not use this file except in compliance with the License. You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */ 

package maxattak;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Angie
 */
public class ScreensFramework extends Application {
    
    /**
     * Nämä String muuttujat ovat ne mitä lisätään ScreensControllerin
     * Hashmappiin
     */
    public static String mainmenuID = "main";
    public static String mainmenuFile = "mainMenu.fxml";
    public static String raceControlID = "racecontrol";
    public static String raceControlFile = "racecontrol.fxml";
    public static String UusiID = "uusipeli";
    public static String UusiFile = "UusiPeli.fxml";
    public static String menuID = "menu";
    public static String menuFile = "menu.fxml";
    public static String pankkiID = "pankki";
    public static String pankkiFile = "pankki.fxml";
    public static String sarjataulukkoID = "sarjataulukko";
    public static String sarjataulukkoFile = "Sarjataulukko.fxml";
    public static String kauppaID = "kauppa";
    public static String kauppaFile = "Kauppa.fxml";
    public static String mekaanikkoID = "mekaanikko";
    public static String mekaanikkoFile = "mekaanikko.fxml";
    public static String carsID = "cars";
    public static String carsFile = "cars.fxml";
    public static String driversID = "drivers";
    public static String driversFile = "drivers.fxml";
    public static String statistiksID = "statistiks";
    public static String statistiksFile = "statistiks.fxml";
    public static String manitsmentID = "manitsment";
    public static String manitsmentFile = "manitsment.fxml";
    public static String sponsorsID = "sponsors";
    public static String sponsorsFile = "sponsors.fxml";
    
    @Override
    public void start(Stage primaryStage) {
        /**
         *  Tässä lisätään kaikki oleellinen ScreensControllerin hashmappiin
         */
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.mainmenuID, ScreensFramework.mainmenuFile);
        mainContainer.loadScreen(ScreensFramework.raceControlID, ScreensFramework.raceControlFile);
        mainContainer.loadScreen(ScreensFramework.UusiID, ScreensFramework.UusiFile);
        mainContainer.loadScreen(ScreensFramework.menuID, ScreensFramework.menuFile);
        mainContainer.loadScreen(ScreensFramework.pankkiID, ScreensFramework.pankkiFile);
        mainContainer.loadScreen(ScreensFramework.sarjataulukkoID, ScreensFramework.sarjataulukkoFile);
        mainContainer.loadScreen(ScreensFramework.kauppaID, ScreensFramework.kauppaFile);
        mainContainer.loadScreen(ScreensFramework.mekaanikkoID, ScreensFramework.mekaanikkoFile);
        mainContainer.loadScreen(ScreensFramework.carsID, ScreensFramework.carsFile);
        mainContainer.loadScreen(ScreensFramework.manitsmentID, ScreensFramework.manitsmentFile);
        mainContainer.loadScreen(ScreensFramework.sponsorsID, ScreensFramework.sponsorsFile);
        
        /**
         * Ladataan ensimmäinen ruutu
         */
        mainContainer.setScreen(ScreensFramework.mainmenuID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
