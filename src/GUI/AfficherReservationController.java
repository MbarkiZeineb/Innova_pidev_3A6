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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML
    private TableColumn<Reservation, Integer> idc;

    @FXML
    private TableColumn<Reservation, Integer> idvoy;

    @FXML
    private TableColumn<Reservation, Integer> idact;

    @FXML
    private TableColumn<Reservation, Integer> idvol;

    @FXML
    private TableColumn<Reservation, Integer> idh;

    @FXML
    private TableColumn<Reservation, String> etat;

    @FXML
    private TableColumn<Reservation, String > type;
    
    
     ObservableList<Reservation> oblist = FXCollections.observableArrayList();
     ReservationService rs= new ReservationService();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          loadTable();
        
        
    }    

    private void loadTable() {
     
       
         


            // TODO
       
     
          List <Reservation> ls =rs.afficher();
          ls.forEach(e->oblist.add(e));
          System.out.print(oblist);
          dateR.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
          nbp.setCellValueFactory(new PropertyValueFactory<>("nbr_place"));
           dated.setCellValueFactory(new PropertyValueFactory<>("Date_debut"));
            datef.setCellValueFactory(new PropertyValueFactory<>("Date_fin"));
            idc.setCellValueFactory(new PropertyValueFactory<>("id_client"));
            idvoy.setCellValueFactory(new PropertyValueFactory<>("id_voyage"));
            idact.setCellValueFactory(new PropertyValueFactory<>("id_active"));
            idvol.setCellValueFactory(new PropertyValueFactory<>("id_vol"));
            idh.setCellValueFactory(new PropertyValueFactory<>("id_hebergement"));
           etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
           type.setCellValueFactory(new PropertyValueFactory<>("type"));
//          
         
    tableRe.setItems(oblist);
    
       
        
        
    }
    
}
