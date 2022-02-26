/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
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
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addact(ActionEvent event) {
        
        
               ReservationService rs = new ReservationService();
     
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       try
       { //Vol v = Tablevol.getSelectionModel().getSelectedItem();
             java.util.Date parsedd = format.parse(DateA.getText());
              java.util.Date parseda = format.parse(DateA.getText());
              java.sql.Date datR = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Date Datedv = new java.sql.Date(parsedd.getTime());
        java.sql.Date Dateav = new java.sql.Date(parseda.getTime());
        //v.getId_vol();
        Reservation r= new Reservation(datR,Integer.parseInt(nbpA.getText()), Datedv, Dateav,0,1,0,0,"En attente",Integer.parseInt(idc.getText()),"vol");
      
         rs.ajouterAct(r);
         rs.modifiernbplaceA(1,Integer.parseInt(nbpA.getText()));
      
    
            
       
       }
       
       catch(ParseException e)
       {
           System.out.println(e);
       }
    }
    
}
