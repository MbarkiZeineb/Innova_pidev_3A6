/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.AgentAerien;
import entities.encryption;
import static entities.encryption.ALGORITHM;
import static entities.encryption.decrypt;
import static entities.encryption.keyValue;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.crypto.spec.SecretKeySpec;
import services.AgentAerienService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierCompteAgentController implements Initializable {
    
        
private int ida;
     public void setIdc(int ida) {
         
              AgentAerienService as =new AgentAerienService();
    
    AgentAerien a= as.selectmodifier(ida);
     txtnom.setText(a.getNom());
     txtprenom.setText(a.getPrenom());
     txtemail.setText(a.getEmail());
     txtmdp.setText(a.getPwd());
     txtnomAgence.setText(a.getNomAgence());
//        System.out.println(ida);
        this.ida= ida;
    }
    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtnomAgence;
    @FXML
    private PasswordField txtmdp;
   

    @FXML
    private Button btnmodif;

    @FXML
    void modifier(ActionEvent event) throws Exception {
        AgentAerienService as =new AgentAerienService();
    AgentAerien a= as.selectmodifier(ida);
     a.setEmail(txtemail.getText());
        a.setNom( txtnom.getText());
        a.setPrenom(txtprenom.getText());
              String mdpcry = encryption.encrypt(txtmdp.getText(),new SecretKeySpec(keyValue, ALGORITHM));      
       a.setPwd(mdpcry);
         decrypt(mdpcry,new SecretKeySpec(keyValue, ALGORITHM));
        a.setNomAgence(txtnomAgence.getText());

as.modifier(a);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
