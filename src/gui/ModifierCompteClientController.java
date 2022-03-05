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
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.ComboBox;
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
    private TextField txtQS;

    @FXML
    private TextField txtRepCMod;
    @FXML
    private Button btnmodif;
    
    private Connection conn;
    private int idc;

    public void setIdc(int idc) {
        
        ClientService cs =new ClientService();
    
    Client c= cs.selectmodifier(idc);
     txtnomCMod.setText(c.getNom());
     txtprenomCMOD.setText(c.getPrenom());
     txtemailCMOD.setText(c.getEmail());
     txtmdpCMOD.setText(c.getPwd());
     txtQS.setText(c.getSecurityQ());
      txtRepCMod.setText(c.getAnswer());
        this.idc = idc;
    }
    

    /**
     * Initializes the controller class.
     */
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ClientService cs =new ClientService();
    
    Client c= cs.selectmodifier(idc);
     txtnomCMod.setText(c.getNom());
     txtprenomCMOD.setText(c.getPrenom());
        txtQS.setText(c.getSecurityQ());
      txtRepCMod.setText(c.getAnswer());
     
    }  
      @FXML
    void modifier(ActionEvent event) {
    ClientService cs =new ClientService();
    Client c= cs.selectmodifier(idc);
     c.setEmail(txtemailCMOD.getText());
        c.setNom( txtnomCMod.getText());
        c.setPrenom(txtprenomCMOD.getText());
        c.setPwd(txtmdpCMOD.getText());
c.setAnswer(txtRepCMod.getText());
cs.modifier(c);
     
         
    }
    
}
