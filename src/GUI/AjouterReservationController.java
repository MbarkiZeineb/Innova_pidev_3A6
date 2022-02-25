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
import static java.lang.String.format;
import static java.lang.String.format;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.text.SimpleDateFormat;
import javafx.beans.binding.BooleanBinding;


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
    private TableColumn<Vol, Float> prixvol;

    @FXML
    private TableColumn<Vol, Integer> nbplaceVol;

     @FXML
    private TextField destinationvol;

    @FXML
    private TextField datedvol;

    @FXML
    private TextField dateavol;

    @FXML
    private TextField nbplaceRvol;

    @FXML
    private TextField prixvolr;
    int index= -1;
    
 ObservableList<Vol> oblist = FXCollections.observableArrayList();
    @FXML
    private TextField idCvol;
  
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         loadTableVol();
         BooleanBinding booleanBinding =(nbplaceRvol.textProperty().isEqualTo("")).or(
        prixvolr.textProperty().isEqualTo("")).or(
         dateavol.textProperty().isEqualTo("")).or(
        datedvol.textProperty().isEqualTo("")).or(
        destinationvol.textProperty().isEqualTo(""));
         
         
          Vol v = Tablevol.getSelectionModel().getSelectedItem();
        AjouterVol.disableProperty().bind(booleanBinding);
    }

    @FXML
  void addVoyage(ActionEvent event)  {
      Vol v = Tablevol.getSelectionModel().getSelectedItem();
      
      ReservationService rs = new ReservationService();
     
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       try
       {
             java.util.Date parsedd = format.parse(datedvol.getText());
              java.util.Date parseda = format.parse(dateavol.getText());
              
        java.sql.Date Datedv = new java.sql.Date(parsedd.getTime());
        java.sql.Date Dateav = new java.sql.Date(parseda.getTime());
        v.getId_vol();
         Reservation r= new Reservation(Datedv,Integer.parseInt(nbplaceRvol.getText()), Datedv, Dateav,0,0,v.getId_vol(),0,"En attente",Integer.parseInt(idCvol.getText()),"vol");
         rs.ajouterVol(r);
         rs.modifiernbplacevol(v.getId_vol(),Integer.parseInt(nbplaceRvol.getText()));
       
       }
       
       catch(ParseException e)
       {
           System.out.println(e);
       }
       
     
       

      
      
      
      
    }   
  
   private void loadTableVol() {
     VolService vs = new VolService();
        List<Vol> ls = vs.afficher();
          ls.forEach(e->oblist.add(e));
          System.out.print(oblist);
          dated.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
          datef.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
           destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
            prixvol.setCellValueFactory(new PropertyValueFactory<>("prix"));
            nbplaceVol.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
          
//          
         
   Tablevol.setItems(oblist);
    
       
        
        
    }
   
  

    @FXML
    private void selectvol(javafx.scene.input.MouseEvent event) {
    
   index = Tablevol.getSelectionModel().getSelectedIndex();
         
         
          
           destinationvol.setText(destination.getCellData(index));
    datedvol.setText(""+dated.getCellData(index));
     dateavol.setText(""+datef.getCellData(index));
     prixvolr.setText(""+prixvol.getCellData(index));
         

}

    @FXML
    private void viderVol(javafx.scene.input.MouseEvent event) {
        
      
           
   destinationvol.clear();

    datedvol.clear();

  dateavol.clear();

    nbplaceRvol.clear();

    prixvolr.clear();
    idCvol.clear();
    
     Tablevol.refresh();
  
    }
}
