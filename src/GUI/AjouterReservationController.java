/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.*;
import Services.ReservationService;
import Services.VolService;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @FXML
    private Button AjouterVol;

     @FXML
    private TableView<Vol> Tablevol;
   
    @FXML
    private TableColumn<Vol, String> destination;

    @FXML
    private TableColumn<Vol, Timestamp> dated;

    @FXML
    private TableColumn<Vol, Timestamp> datef;

    @FXML
    private TableColumn<Vol, Float> prix;

    @FXML
    private TableColumn<Vol, Integer> nbplaceVol;

     @FXML
    private TextField destinationvol;

    @FXML
    private DatePicker datedvol;

    @FXML
    private DatePicker dateavol;

    @FXML
    private TextField nbplaceRvol;

    @FXML
    private TextField prixvolr;
    
 ObservableList<Vol> oblist = FXCollections.observableArrayList();
  
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         loadTableVol();
         
          Vol v = Tablevol.getSelectionModel().getSelectedItem();
        
    }

    @FXML
  void addVoyage(ActionEvent event) {
      Vol v = Tablevol.getSelectionModel().getSelectedItem();
      
      ReservationService rs = new ReservationService();
      //Reservation r= new Reservation(Date.valueOf(dateReservationVoy.getValue()),Integer.parseInt(nbrplace.getText()),, etat, type);
      
      
      
      
    }   
  
   private void loadTableVol() {
     VolService vs = new VolService();
        List<Vol> ls = vs.afficher();
          ls.forEach(e->oblist.add(e));
          System.out.print(oblist);
          dated.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
          datef.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
           destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
            prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            nbplaceVol.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
          
//          
         
   Tablevol.setItems(oblist);
    
       
        
        
    }
   
       void select(MouseEvent event) {
           
          int  = Tablevol.getSelectionModel().getSelectedIndex();
          destinationvol.setText(v.getDestination());
          
          
         
          try {
  
    
    datedvol.setValue(v.getDate_arrivee().toLocalDate());
     dateavol.setValue(v.getDate_arrivee().toLocalDate());
} catch (NullPointerException e) {

              System.out.println(e);}

    

    nbplaceRvol.setText(""+v.getPrix());
    nbplaceRvol.setText("A remplir");
    prixvolr.setText(v.getPrix());
    }

    @FXML
    private void select(javafx.scene.input.MouseEvent event) {
    }

   
    
}
