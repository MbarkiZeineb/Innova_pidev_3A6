/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.File;  
 
import javafx.scene.Group;  

import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  

/**
 *
 * @author TheBoss'07
 */
public class GestionActivites extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionActivites.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        root.getStylesheets().add(getClass().getResource("Dark.css").toExternalForm());
        primaryStage.setTitle("GetAway");
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
