/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import Services.ReservationService;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AjouterReservationController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private DatePicker dateReservationVoy;
    @FXML
    private TextField nbrplace;
    @FXML
    private Button ajouterRVoyage;
    @FXML
    private TextField idclient;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    
    }

    @FXML
  void addVoyage(ActionEvent event) {

      ReservationService rs = new ReservationService();
      Reservation r= new Reservation(Date.valueOf(dateReservationVoy.getValue()),Integer.parseInt(nbrplace.getText()),, etat, type);
      
      
      
      
    }    
    
}
