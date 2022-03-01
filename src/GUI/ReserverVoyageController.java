/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import Entities.Vol;
import Services.PaiementService;
import Services.ReservationService;
import static java.lang.String.valueOf;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ReserverVoyageController implements Initializable {

    @FXML
    private TextField villeDvoy;
    @FXML
    private TextField VilleDestVoy;
    @FXML
    private TextField dateD;
    @FXML
    private TextField idc;
    @FXML
    private Button Reservervoyage;
    @FXML
    private TextField prixVoy;
    @FXML
    private TextField nbp;
    @FXML
    private TextField dateF;
    private TextField prixTotal;
 ReservationService rs = new ReservationService();
    @FXML
    private TextField prixTotalV;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nbp.setText("0");
    }    

    @FXML
    private void addVoyage(ActionEvent event) {
             
     
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       try
       { //Vol v = Tablevol.getSelectionModel().getSelectedItem();
             java.util.Date parsedd = format.parse(dateD.getText());
              java.util.Date parseda = format.parse(dateF.getText());
              java.sql.Date datR = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Date Datedv = new java.sql.Date(parsedd.getTime());
        java.sql.Date Dateav = new java.sql.Date(parseda.getTime());
        //v.getId_vol();
        // Reservation r= new Reservation(datR,Integer.parseInt(nbp.getText()), Datedv, Dateav,,v,0,0,0,"En attente",Integer.parseInt(idc.getText()),"vol");
      
         //rs.ajouter(r);
           
         //rs.modifiernbplacevoyage(v.getId_vol(),Integer.parseInt(nbp.getText()));
    
            
       
       }
       
       catch(ParseException e)
       {
           System.out.println(e);
       }
        
        
    }

    private void CalculerPrixTotal(InputMethodEvent event) {
//        
//        PaiementService ps = new PaiementService();
//         prixTotalV.setText(""+ps.calculermontantVoyage(1, Integer.parseInt(nbp.getText())));
        
    }

    @FXML
    private void CalculerPrixTotal(KeyEvent event) {
           
        PaiementService ps = new PaiementService();
        try{
            if(nbp.getText()!=null)
        {
       // prixTotalV.setText(valueOf(ps.calculermontantVoyage(1, Integer.parseInt(nbp.getText()))));
        
    }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
    }
}
