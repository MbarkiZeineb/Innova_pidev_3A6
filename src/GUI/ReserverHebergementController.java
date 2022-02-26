/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import Entities.Vol;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
    private CheckBox parking;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        String SDateD="2022-02-01";
         String SDateF="2022-02-16";
        LocalDate ddd= LocalDate.of(2022,02,01);
       LocalDate fff= LocalDate.of(2022,02,16);

// Setting the maximum date available in the calendar
          
    
        
    Date DateDebut=Date.valueOf(SDateD);
    Date DateFin=Date.valueOf(SDateF);
      List<LocalDate> listdd= rs.ListeDd(1);
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
    
}
