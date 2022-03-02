/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Hebergement;
import Entities.Reservation;
import Entities.Vol;
import Services.HebergementService;
import Services.ReservationService;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    
       
        loadTableHebegement();

// Setting the maximum date available in the calendar
          
        
        
    
        
        
        
        
        
        
          
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
        h_affiche_datestart.setCellValueFactory(new PropertyValueFactory<>("contact"));
        h_affiche_contact.setCellValueFactory(new PropertyValueFactory<>("nbr_detoile"));
        h_affiche_nbrdetoile.setCellValueFactory(new PropertyValueFactory<>("nbr_suite"));
        h_affiche_nbrsuite.setCellValueFactory(new PropertyValueFactory<>("nbr_parking"));
        h_affiche_nbrparking.setCellValueFactory(new PropertyValueFactory<>("model_caravane"));
        
     hebergement_table.setItems(oblistH);
  
     
  
     
    }
    

    @FXML
    private void addHeb(ActionEvent event) {
         
     
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       try
       {
           //Vol v = Tablevol.getSelectionModel().getSelectedItem();
             java.util.Date parsedd = format.parse(DateD.getValue().toString());
              java.util.Date parseda = format.parse(DateF.getValue().toString());
              java.sql.Date datR = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Date Datedv = new java.sql.Date(parsedd.getTime());
        java.sql.Date Dateav = new java.sql.Date(parseda.getTime());
        //v.getId_vol();
         Reservation r= new Reservation(datR,1, Datedv, Dateav,0,0,0,1,"En attente",Integer.parseInt(idc.getText()),"vol");
      
         rs.ajouterHeb(r);
           
         
    
            //Tablevol.refresh();
       
       }
       
       catch(ParseException e)
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


       try{
             
//        LocalDate DD = h_affiche_datestart.getCellData(index).getValue();
//        LocalDate Df = h_affiche_dateend.getCellData(index).getValue();
//        DateD.setValue(DD);
//        DateF.setValue(Df);
       
        List<LocalDate> listdd = rs.ListeDd(h.getReferance());
       DateD.setDayCellFactory((DatePicker param) -> new DateCell(){
           public void updateItem(LocalDate item, boolean empty) {
               super.updateItem(item, empty);
               
               if (!empty && item != null) {
                   if(listdd.contains(item)) {
                       setDisable(true);
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
       catch(Exception e)
       {
           
           System.out.println(e);
       }
       
       
        
        
       }
      
  
        
    
    
}
