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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
