/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Malek
 */
public class NewFXMain extends Application {
    
    @Override
            public void start(Stage primaryStage) throws Exception
       
            { 
                
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
              //  Parent root = FXMLLoader.load(getClass().getResource("Ajoutervol.fxml"));
        
        Scene scene = new Scene(root, 1000, 600);
        
        primaryStage.setTitle("Affichage Vol");
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
