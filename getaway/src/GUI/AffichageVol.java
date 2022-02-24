/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import getaway.entities.Vol;
import getaway.services.VolService;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
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
public class AffichageVol implements Initializable {

    /**
     * Initializes the controller class.
     */
    
         @FXML
    private AnchorPane tableR;
  @FXML
    private TableView<Vol> tableRe;
    @FXML
    private TableColumn<Vol ,Integer> idV;

    @FXML
    private TableColumn<Vol, String> destination;

    @FXML
    private TableColumn<Vol, Timestamp> dated;

    @FXML
    private TableColumn<Vol, Timestamp> datef;

    @FXML
    private TableColumn<Vol, Float> prix;

    @FXML
    private TableColumn<Vol, Integer> nbplace;

    @FXML
    private TableColumn<Vol, Integer> idA;

    
    
     ObservableList<Vol> oblist = FXCollections.observableArrayList();
     Vol rs= new Vol();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          loadTable();
        
        
    }    

    private void loadTable() {
     
       
         


            // TODO
       
     
        VolService vs = new VolService();
        List<Vol> ls = vs.afficher();
          ls.forEach(e->oblist.add(e));
          System.out.print(oblist);
          
          idV.setCellValueFactory(new PropertyValueFactory<Vol,Integer>("id_vol"));
          dated.setCellValueFactory(new PropertyValueFactory<Vol,Timestamp>("date_depart"));
          datef.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
           destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
            prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            nbplace.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
            idA.setCellValueFactory(new PropertyValueFactory<>("id_avion"));
//          
         
    tableRe.setItems(oblist);
    
       
        
        
    }
    
}