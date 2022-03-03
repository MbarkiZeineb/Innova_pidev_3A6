/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.ClientService;
import entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import utilis.Connexion;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierCompteClientController implements Initializable {

    @FXML
    private TextField txtnomCMod;
    @FXML
    private TextField txtemailCMOD;
    @FXML
    private TextField txtprenomCMOD;
    @FXML
    private PasswordField txtmdpCMOD;
    @FXML
    private Button btnmodif;
    
    private Connection conn;

    /**
     * Initializes the controller class.
     */
    
    
    
    public ModifierCompteClientController() {
          conn = Connexion.getInstance().getCnx();
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    ClientService cs =new ClientService();
    @FXML
    private void modifier(ActionEvent event) {
    
        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("UPDATE client SET nom=?, prenom=?, password=? WHERE email=?");
            
            stmt.setString(4, (txtemailCMOD.getText()));
            stmt.setString(3, (txtmdpCMOD.getText())); 
              
           
            stmt.setString(1, txtnomCMod.getText());
            stmt.setString(2, txtprenomCMOD.getText());
           
            


              int i = stmt.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
       
       
      
        
    }
    
}
