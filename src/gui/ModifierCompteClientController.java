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
import entities.encryption;
import static entities.encryption.ALGORITHM;
import static entities.encryption.decrypt;
import static entities.encryption.keyValue;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.crypto.spec.SecretKeySpec;
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
    void modifier(ActionEvent event) throws Exception {
    ClientService cs =new ClientService();
    Client c= cs.selectmodifier(idc);
     c.setEmail(txtemailCMOD.getText());
        c.setNom( txtnomCMod.getText());
        c.setPrenom(txtprenomCMOD.getText());
              String mdpcry = encryption.encrypt(txtmdpCMOD.getText(),new SecretKeySpec(keyValue, ALGORITHM));      
       c.setPwd(mdpcry);
         decrypt(mdpcry,new SecretKeySpec(keyValue, ALGORITHM));
       
c.setAnswer(txtRepCMod.getText());
cs.modifier(c);
     
         
    }
    
    
    
        @FXML
    void reclamation(ActionEvent event) throws IOException {
        Stage stage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void reserverActivite(ActionEvent event) {

    }

    @FXML
    void reserverHebergement(ActionEvent event) {

    }

    @FXML
    void reserverVol(ActionEvent event) {

    }

    @FXML
    void reserverVoyageO(ActionEvent event) {

    }
    
        @FXML
    void avis(ActionEvent event) {

    }

    @FXML
    void consulterProfil(ActionEvent event) throws IOException {

    }

    @FXML
    void consulterReservation(ActionEvent event) {

    }
    
       @FXML
    void logout(ActionEvent event) throws IOException {
//  Stage stage = new Stage();
 
//        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        Scene scene =new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    
                      try{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		Parent root = loader.load();
		LoginController  e = loader.getController();
               
              
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}


    }
    
    
    
    
    
    
    
    
    
}
