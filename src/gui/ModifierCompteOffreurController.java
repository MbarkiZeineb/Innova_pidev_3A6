/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Offreur;
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
import services.OffreurService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierCompteOffreurController implements Initializable {
    private int idc;
       public void setIdc(int idc) {
        
           OffreurService os =new OffreurService();
    
           Offreur o= os.selectmodifier(idc);
     txtnom.setText(o.getNom());
     txtprenom.setText(o.getPrenom());
     txtemail.setText(o.getEmail());
     txtmdp.setText(o.getPwd());
     txtnumtel.setText(o.getNumtl()+"");
        this.idc = idc;
    }
    
    
    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtnumtel;

    @FXML
    private Button btnmodif;

    @FXML
    private PasswordField txtmdp;

    @FXML
    void modifier(ActionEvent event) throws Exception {
    OffreurService os =new OffreurService();
    Offreur o= os.selectmodifier(idc);
     o.setEmail(txtemail.getText());
        o.setNom( txtnom.getText());
        o.setPrenom(txtprenom.getText());
        
           String mdpcry = encryption.encrypt(txtmdp.getText(),new SecretKeySpec(keyValue, ALGORITHM));      
       o.setPwd(mdpcry);
         decrypt(mdpcry,new SecretKeySpec(keyValue, ALGORITHM));
        
//o.setNumtl(txtnumtel.getText());
os.modifier(o);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
