/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.encryption;
import static Entities.encryption.ALGORITHM;
import static Entities.encryption.decrypt;
import static Entities.encryption.keyValue;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import Utilis.*;
import javax.crypto.spec.SecretKeySpec;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class MdpoubController implements Initializable {

    private Connection conn;
    @FXML
    private TextField txtemailmdpoub;

    @FXML
    private TextField txtrepmdpoub;

    @FXML
    private TextField txtquestion;

    @FXML
    private PasswordField txtnouvmdp;

    @FXML
    private Button btnconfirm;

    @FXML
    private Button btncherch;

    public MdpoubController() {
        conn = Datasource.getInstance().getCnx();
    }

    @FXML
    void chercher(ActionEvent event) {
        String email = txtemailmdpoub.getText();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select securityQ from user where email = '" + email + "'");
            if (rs.next()) {
                txtquestion.setText(rs.getString("securityQ"));

            } else {
                JOptionPane.showMessageDialog(null, "verifiez votre email");
                conn.close();
                rs.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(MdpoubController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void confirmer(ActionEvent event) throws Exception {
        String email = txtemailmdpoub.getText();
        String quest = txtquestion.getText();

        String mdpcry = encryption.encrypt(txtnouvmdp.getText(), new SecretKeySpec(keyValue, ALGORITHM));

        decrypt(mdpcry, new SecretKeySpec(keyValue, ALGORITHM));
        String rep = txtrepmdpoub.getText();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from client where email = '" + email + "' and answer = '" + rep + "'");
            if (rs.next()) {
                st.executeUpdate("update client set password= '" + mdpcry + "' where email= '" + email + "' and answer = '" + rep + "' ");
                JOptionPane.showMessageDialog(null, "mot de passe modifié avec succes ");

            } else {
                JOptionPane.showMessageDialog(null, "verifiez votre email ou votre reponse ");

            }

        } catch (SQLException ex) {
            Logger.getLogger(MdpoubController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
