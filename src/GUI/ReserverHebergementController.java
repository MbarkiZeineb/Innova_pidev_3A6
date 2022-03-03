/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Hebergement;
import Entities.Paiement;
import Entities.Reservation;
import Entities.Vol;
import Services.HebergementService;
import Services.PaiementService;
import Services.ReservationService;
import static java.lang.String.format;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.util.Callback;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ReserverHebergementController implements Initializable {

    @FXML
    private DatePicker DateD;
    @FXML
    private DatePicker DateF;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField Description;
    @FXML
    private TextField prix;
    @FXML
    private TextField idc;
    @FXML
    private Button ReserverH;
     ReservationService rs = new ReservationService();
        @FXML
  private TableView<Hebergement> hebergement_table;
     
    @FXML
    private TableColumn<Hebergement, String> h_affiche_paye;
    @FXML
    private TableColumn<Hebergement, String> h_affiche_adress;
    @FXML
    private TableColumn<Hebergement, Float> h_affiche_prix;
    @FXML
    private TableColumn<Hebergement, String> h_affiche_description;
    @FXML
    private TableColumn<Hebergement, String> h_affiche_pic;
    @FXML
    private TableColumn<Hebergement, DatePicker> h_affiche_datestart;
    @FXML
    private TableColumn<Hebergement, DatePicker> h_affiche_dateend;
    @FXML
    private TableColumn<Hebergement, String> h_affiche_contact;
    @FXML
    private TableColumn<Hebergement, Integer> h_affiche_nbrdetoile;
    @FXML
    private TableColumn<Hebergement, Integer> h_affiche_nbrsuite;
    @FXML
    private TableColumn<Hebergement, Integer> h_affiche_nbrparking;
ObservableList<Hebergement> oblistH = FXCollections.observableArrayList();
     HebergementService hs= new HebergementService();
     
     @FXML
    private TextField prixtotal;
       @FXML
    private ComboBox<String> modalite;

     
     
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    
       
        loadTableHebegement();

   BooleanBinding bb = Bindings.createBooleanBinding(() -> {
    LocalDate from = DateD.getValue();
    LocalDate to = DateF.getValue();

    // disable, if one selection is missing or from is not smaller than to
    return (from == null || to == null || (from.compareTo(to) >= 0));   
}, 
 DateD.valueProperty(), DateF.valueProperty());

   ReserverH.disableProperty().bind(bb);
          
        modalite.getItems().addAll("Cache" ,"Cheque","Carte bancaire");
        DateD.valueProperty().addListener((observable, oldDate, newDate)->{ 
        DateF.setValue(DateD.getValue().plusDays(1));
        
        });
     
        
        
        
        
        
        
          
    }
       
    private void loadTableHebegement() {// hebergement affiche
         List <Hebergement> ls =hs.afficher();
        ls.forEach(e->oblistH.add(e));
         h_affiche_paye.setCellValueFactory(new PropertyValueFactory<>("paye"));
        h_affiche_adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        h_affiche_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        h_affiche_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        h_affiche_pic.setCellValueFactory(new PropertyValueFactory<>("photo"));
        h_affiche_datestart.setCellValueFactory(new PropertyValueFactory<>("date_start"));
        h_affiche_dateend.setCellValueFactory(new PropertyValueFactory<>("date_end"));
        h_affiche_contact.setCellValueFactory(new PropertyValueFactory<>("nbr_detoile"));
        h_affiche_nbrdetoile.setCellValueFactory(new PropertyValueFactory<>("nbr_suite"));
        h_affiche_nbrsuite.setCellValueFactory(new PropertyValueFactory<>("nbr_parking"));
        h_affiche_nbrparking.setCellValueFactory(new PropertyValueFactory<>("model_caravane"));
        
     hebergement_table.setItems(oblistH);
  
     
  
     
    }
    

    @FXML
    private void addHeb(ActionEvent event) {
          PaiementService ps = new PaiementService();
      Hebergement h = hebergement_table.getSelectionModel().getSelectedItem();
        try

        {     
        java.sql.Date Datedv =Date.valueOf(DateD.getValue());
        java.sql.Date Dateav = Date.valueOf(DateF.getValue());
       
           java.sql.Date datR = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
           
         Reservation r= new Reservation(datR,0, Datedv, Dateav,0,0,0,h.getReferance(),"Approuve",1,"Hebergement");
         if(rs.testerdisponibliteH(Datedv,  Dateav,h.getReferance())&&rs.verifierDateHberg(h.getReferance(), Datedv,  Dateav))
         { rs.ajouterHeb(r);
        
                
      Paiement p = new Paiement(modalite.getValue(),Float.valueOf( prixtotal.getText()),rs.afficher().get(rs.afficher().size()-1).getId(),datR);
         ps.ajouter(p);
          Notifications.create().title("Reservation Vol").text(" Reservation est Créé ").show();
        
        
     
         
         }
          else
          {     Notifications.create().title("Reservation Hebergement ").text(" Date non disponibile   ").show();
          }
       
       }
       
       catch(Exception e)
       {
           System.out.println(e);
       }
        
    }

    @FXML
    private void select(MouseEvent event) {
        
          int index = hebergement_table.getSelectionModel().getSelectedIndex();
        Hebergement h = hebergement_table.getSelectionModel().getSelectedItem();
        Adresse.setText(h_affiche_adress.getCellData(index));
        Description.setText(h_affiche_description.getCellData(index));
        prix.setText(h_affiche_prix.getCellData(index).toString());
 List<LocalDate> listdd = rs.ListeDd(h.getReferance());
        System.out.println(listdd);
       DateD.setDayCellFactory((DatePicker param) -> new DateCell(){
           public void updateItem(LocalDate item, boolean empty) {
               super.updateItem(item, empty);
               
               if (!empty && item != null) {
                   if(listdd.contains(item)) {
                       
                       this.setStyle("-fx-background-color: pink");
                   }
               }
           }
       });
       
       
         DateF.setDayCellFactory((DatePicker param) -> new DateCell(){
           public void updateItem(LocalDate item, boolean empty) {
               super.updateItem(item, empty);
               
               if (!empty && item != null) {
                   if(listdd.contains(item)) {
                       
                       this.setStyle("-fx-background-color:yellow");
                   }
               }
           }
       });

     
      
  
        
    }
    @FXML
    void calculerprix(MouseEvent  event) {
    java.sql.Date Datedv =Date.valueOf(DateD.getValue());
        java.sql.Date Dateav = Date.valueOf(DateF.getValue());
         
         java.util.Date  utilDateD = new java.util.Date(Datedv.getTime());
         java.util.Date  utilDateF = new java.util.Date(Dateav.getTime());
          long diffInMillies = Math.abs( utilDateD.getTime() -  utilDateF.getTime());
             System.out.println(diffInMillies);
             long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
             System.out.println(diff);
             
              Float prixTT=diff* Float.parseFloat(prix.getText());
            
         
             prixtotal.setText(prixTT.toString());
    }

    @FXML
    private void vider(MouseEvent event) {
           DateD.setValue(null);
    DateF.setValue(null);
    Adresse.setText("");
    Description.setText("");
    prix.setText("");
     prixtotal.setText("");    
     modalite.getItems().clear();
    }
    
    
    
}
