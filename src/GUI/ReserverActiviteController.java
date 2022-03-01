/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import GetAway.entities.Activite;
import Services.ActiviteService;
import Services.PaiementService;
import Services.ReservationService;
import static java.lang.String.valueOf;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ReserverActiviteController implements Initializable {

    @FXML
    private TextField nomA;
    @FXML
    private TextField prixA;
    @FXML
    private TextField nbpA;
    @FXML
    private TextField DateA;
    @FXML
    private TextField prixtotal;
    @FXML
    private Button ReserverA;
    @FXML
    private TextField idc;
     @FXML
    private TableView<Activite> tvactivite;
    @FXML
    private TableColumn<Activite, String> colnom;
    @FXML
    private TableColumn<Activite, String> colduree;
    @FXML
    private TableColumn<Activite, Integer> colnbrp;
    @FXML
    private TableColumn<Activite, String> coldate;
    @FXML
    private TableColumn<Activite, String> coltype;
    @FXML
    private TableColumn<Activite, String> colloc;
    @FXML
    private TableColumn<Activite, Float> colprix;
    @FXML
    private TableColumn<Activite, String> coldesc;
      ActiviteService as = new ActiviteService();
        ObservableList<Activite> oblist = FXCollections.observableArrayList();
        int index;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         BooleanBinding booleanBinding =(nbpA.textProperty().isEqualTo("0")).or(
        prixA.textProperty().isEqualTo("")).or(
         DateA.textProperty().isEqualTo("")).or(
       nomA.textProperty().isEqualTo("").or(nbpA.textProperty().isEqualTo("")));
         
          nbpA.setText("0");
           affichage();
           ReserverA.disableProperty().bind(booleanBinding);
    }    

    @FXML
    private void addact(ActionEvent event) {
        
        
               ReservationService rs = new ReservationService();
     
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       try
       {    Activite A =  tvactivite.getSelectionModel().getSelectedItem();
             java.util.Date parsedd = format.parse(DateA.getText());
              java.util.Date parseda = format.parse(DateA.getText());
              java.sql.Date datR = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Date Datedv = new java.sql.Date(parsedd.getTime());
        java.sql.Date Dateav = new java.sql.Date(parseda.getTime());
         if(rs.verifierNbplaceAct(A.getRefAct(),A.getNbrPlace())==false)
        {
        Reservation r= new Reservation(datR,Integer.parseInt(nbpA.getText()), Datedv, Dateav,0,A.getRefAct(),0,0,"Approuve",Integer.parseInt(idc.getText()),"vol");
      
         rs.ajouterAct(r);
         rs.modifiernbplaceA(A.getRefAct(),Integer.parseInt(nbpA.getText()));
          Notifications.create().title("Reservation Activite ").text(" Reservation est Créé ").show();
        }
          else
          {     Notifications.create().title("Reservation Activite ").text(" Nombre de place non valide  ").show();
          }
    
            
       
       }
       
       catch(ParseException e)
       {
           System.out.println(e);
       }
    }
    
    
    
     private void affichage() {
     
          List<Activite> activites = as.afficher();
        activites.forEach(e->oblist.add(e));
        
        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colduree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
        colnbrp.setCellValueFactory(new PropertyValueFactory<>("NbrPlace"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colloc.setCellValueFactory(new PropertyValueFactory<>("Location"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("Descrip"));
        

        tvactivite.setItems(oblist);
        
    
}

    @FXML
    private void selecteAct(MouseEvent event) {
        
         index =  tvactivite.getSelectionModel().getSelectedIndex();
         
          nomA.setText(colnom.getCellData(index));
         prixA.setText(colprix.getCellData(index).toString());
         DateA.setText(coldate.getCellData(index));
         
   
        
        
        
    }

    @FXML
    private void vider(MouseEvent event) {
        
        
                 
    nomA.clear();

     prixtotal.setText("0");

  prixA.clear();

    DateA.clear();
     nbpA.setText("0");
    tvactivite.getItems().clear();
    affichage();
    }
    
    
    
    

}

