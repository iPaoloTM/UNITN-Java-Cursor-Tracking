/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pannello;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Main
 * @author paoloaliprandi
 */
public class Pannello extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        MyPane pane = new MyPane();
        Scene scene = new Scene(pane,500,500);
        
        primaryStage.setTitle("Pannello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
