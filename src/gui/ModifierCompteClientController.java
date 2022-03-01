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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    ClientService cs =new ClientService();
    @FXML
    private void modifier(ActionEvent event) {
      Client c = new Client();
       c.setEmail(txtemailCMOD.getText());
        c.setNom( txtnomCMod.getText());
        c.setPrenom(txtprenomCMOD.getText());
        c.setPwd(txtmdpCMOD.getText());
      cs.modifier(c);
      
        
    }
    
}
