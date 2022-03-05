/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.ClientService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class NvCompteController implements Initializable {
    @FXML
    private Button btnvalider;

    @FXML
    private TextField txtnomNVC;

    @FXML
    private TextField txtprenomNVC;

    @FXML
    private TextField txtemailNVC;

    @FXML
    private TextField txtrepNVC;

    @FXML
    private PasswordField txtmdpNVC;

    @FXML
    private ComboBox combosecNVC;
ClientService cs = new ClientService();
    @FXML
    void validerCompte(ActionEvent event) {
               Client c= new Client(combosecNVC.getSelectionModel().getSelectedItem().toString(), txtrepNVC.getText(), txtnomNVC.getText(), txtprenomNVC.getText(), txtmdpNVC.getText(), txtemailNVC.getText());
cs.ajouter(c);
        JOptionPane.showMessageDialog(null, "votre compte est cree avec succes");


    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> list1 = FXCollections.observableArrayList("votre premiere voiture","pays de ton reve","ton idole");
        combosecNVC.setItems(list1);
    }    
    
}
