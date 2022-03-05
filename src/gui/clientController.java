/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class clientController implements Initializable {

    @FXML
    private Button btnreclamation;
       @FXML
    private Button btnmodifCC;
    private int idc;

    public void setIdc(int idc) {
        System.out.println(idc);
        this.idc = idc;
    }

    @FXML
    void modifierCompte(ActionEvent event) {
      
        
        
           try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCompteClient.fxml"));
		Parent root = loader.load();
		ModifierCompteClientController  e = loader.getController();
               
                e.setIdc(idc);
              
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}
    }
    
        @FXML
    void reclamation(ActionEvent event) {

           try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
		Parent root = loader.load();
		ReclamationController  e = loader.getController();
               
                e.setIdc(idc);
              
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
