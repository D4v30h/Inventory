/*
 * Copyright (C) 2014 David Hodgson <daveoh@daveoh.info>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.daveoh.inventory;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class Inventory extends Application {
    
    
    // UI
    private final AnchorPane root = new AnchorPane();
    private final BorderPane subRoot = new BorderPane();
    private final SplitPane splitHoriz = new SplitPane();
    private final VBox pLeft = new VBox();
    private final VBox pRight = new VBox();
    private final SplitPane splitVert = new SplitPane();
//    private AnchorPane aInfo = new AnchorPane();
    private final HBox pInfo = new HBox();
    private final Text textInfo = new Text("Info");
    private Scene scene;
    // Menu
    final private MenuBar menuBar = new MenuBar();
    final private Menu menuGame = new Menu("File");
    final private MenuItem menuItemExit = new MenuItem("Exit");
    final private Menu menuHelp = new Menu("Help");
    
    @Override
    public void start(Stage primaryStage) {
        setupMenuBar();
        
        // Set up left-right SplitPane
        splitHoriz.setOrientation(Orientation.HORIZONTAL);
        splitHoriz.getItems().addAll(pLeft, pRight);
        //splitHoriz.setPrefSize(640, 320);
        
        // Add content to left and right
        pLeft.getChildren().addAll(new Text("Left"));
        pRight.getChildren().addAll(new Text("Right"));
        
        // Add content to bottom
        pInfo.getChildren().addAll(textInfo);
        
        // Set up top-bottom SplitPane
        splitVert.setOrientation(Orientation.VERTICAL);
        splitVert.getItems().addAll(splitHoriz, pInfo);
        splitVert.setDividerPosition(0, 1.0d);
        
        subRoot.setTop(menuBar);
        subRoot.setCenter(splitVert);
        root.getChildren().addAll(subRoot);
        AnchorPane.setBottomAnchor(subRoot, 0.d);
        AnchorPane.setTopAnchor(subRoot, 0.d);
        AnchorPane.setLeftAnchor(subRoot, 0.d);
        AnchorPane.setRightAnchor(subRoot, 0.d);
        
        // Set up scene
        scene = new Scene(root, 640, 480);
        
        primaryStage.setTitle("Inventory");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void setupMenuBar() {
        // Add menus and items to bar
        menuBar.getMenus().addAll(menuGame, menuHelp);
        menuGame.getItems().addAll(menuItemExit);
        
        // Set up menu items
        menuItemExit.setOnAction((ActionEvent t) -> {
            Platform.exit();
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
