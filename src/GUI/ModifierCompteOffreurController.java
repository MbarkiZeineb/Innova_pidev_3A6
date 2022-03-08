/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Offreur;
import Entities.encryption;
import static Entities.encryption.ALGORITHM;
import static Entities.encryption.decrypt;
import static Entities.encryption.keyValue;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.crypto.spec.SecretKeySpec;
import Services.OffreurService;

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
    
      @FXML
    private Button btnOverview;

    @FXML
    private Button btnGestHeb;

    @FXML
    private Button btnSignout;

    @FXML
    void GestHeb(ActionEvent event) {

    }

    @FXML
    void consulterProfil(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
         try{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		Parent root = loader.load();
		LoginController  e = loader.getController();
               
              
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
