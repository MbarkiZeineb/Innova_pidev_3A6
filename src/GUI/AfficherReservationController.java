/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Paiement;
import Entities.Reservation;
import Services.PaiementService;
import Services.ReservationService;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AfficherReservationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
         @FXML
    private AnchorPane tableR;
  @FXML
    private TableView<Reservation> tableRe;
    @FXML
    private TableColumn<Reservation, Date> dateR;

    @FXML
    private TableColumn<Reservation, Integer> nbp;

    @FXML
    private TableColumn<Reservation, Date> dated;

    @FXML
    private TableColumn<Reservation, Date> datef;

   

    private TableColumn<Reservation, Integer> idh;

    @FXML
    private TableColumn<Reservation, String> etat;

    @FXML
    private TableColumn<Reservation, String > type;
    
    
     ObservableList<Reservation> oblist = FXCollections.observableArrayList();
     
     ObservableList<Paiement> oblistp = FXCollections.observableArrayList();
     ReservationService rs= new ReservationService();
     PaiementService ps = new  PaiementService();
    @FXML
    private Button supprimerR;

    @FXML
    private TableView<Paiement> paiment;
    @FXML
    private TableColumn<Paiement,Date> dateP;
    @FXML
    private TableColumn<Paiement, String> modalite;
    @FXML
    private TableColumn<Paiement, Float> montant;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          loadTable();
          loadTableP();
          supprimerR.disableProperty().bind(Bindings.isEmpty(tableRe.getSelectionModel().getSelectedItems()));
        
        
    }    

    private void loadTable() {
     
       
         


            // TODO
       
     
          List <Reservation> ls =rs.afficher();
          List <Paiement> lp =ps.afficher();
          ls.forEach(e->{oblist.add(e);
         // System.out.print(oblist);
          dateR.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
          nbp.setCellValueFactory(new PropertyValueFactory<>("nbr_place"));
           dated.setCellValueFactory(new PropertyValueFactory<>("Date_debut"));
            datef.setCellValueFactory(new PropertyValueFactory<>("Date_fin"));
                  etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
           type.setCellValueFactory(new PropertyValueFactory<>("type")); 
           
          });
          
//          
         
    tableRe.setItems(oblist);
    
       
        
        
    }
    
    
    
    private void loadTableP() {
     
       
         


            // TODO
       
    
        
          List <Paiement> lp =ps.afficher();
         
          lp.forEach(e->{oblistp.add(e);
         System.out.print(oblistp);
           dateP.setCellValueFactory(new PropertyValueFactory<>("date"));
          modalite.setCellValueFactory(new PropertyValueFactory<>("modalite"));
           montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
            
           
          });
          
//          
         
    paiment.setItems(oblistp);
    
       
        
        
    }
    @FXML
    private void Supprimer(ActionEvent event) {
        
       
      Reservation r=  tableRe.getSelectionModel().getSelectedItem();
      Paiement p = new Paiement();
      p.setId_reservation(r.getId());
      ps.supprimer(p);
      rs.supprimer(r);
        
        
        
    }

    @FXML
    private void UpdateTable(MouseEvent event) {
        
        
       tableRe.getItems().clear();
    loadTable();
     paiment.getItems().clear();
     loadTableP();
     
    }

}
