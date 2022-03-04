/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.*;
import Services.PaiementService;
import Services.ReservationService;
import Services.VolService;
import java.awt.event.MouseEvent;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.valueOf;
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
import java.util.Calendar;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ReserverVolController implements Initializable {


    @FXML
    private Button AjouterVol;

   

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
   @FXML
    private TableView<Vol> tb_v;
    @FXML
    private TableColumn<Vol, Timestamp> tb_datedepart;
    @FXML
    private TableColumn<Vol, Timestamp> tb_datearrivee;
    @FXML
    private TableColumn<Vol, Float> tb_prix;
    @FXML
    private TableColumn<Vol, String> tb_villedepart;
    @FXML
    private TableColumn<Vol, String> tb_villearrivee;
    
     @FXML
    private TableColumn<Vol, Integer> tb_place;
    @FXML
    private TextField villeDepart;
    @FXML
    private TextField prixTotalV;
    @FXML
    private ComboBox<String> modalite;
    private int id=2;
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         ReservationService rs = new ReservationService();
        
        idCvol.setText( rs.NomP(id));
         loadTableVol();
         BooleanBinding booleanBinding =(nbplaceRvol.textProperty().isEqualTo("0")).or(
        prixvolr.textProperty().isEqualTo("")).or(
         dateavol.textProperty().isEqualTo("")).or(
        datedvol.textProperty().isEqualTo("")).or(
        destinationvol.textProperty().isEqualTo("")).or((nbplaceRvol.textProperty().isEqualTo(""))).or((prixTotalV.textProperty().isEqualTo(""))).or(prixTotalV.textProperty().isEqualTo("0"));
         
          nbplaceRvol.setText("0");
          Vol v = tb_v.getSelectionModel().getSelectedItem();
        AjouterVol.disableProperty().bind(booleanBinding);
        
         
          modalite.getItems().addAll("Cache" ,"Cheque","Carte bancaire");
    }


  
   private void loadTableVol() {
      VolService vs = new VolService();
        List<Vol> ls = vs.afficher();
          ls.forEach(e->oblist.add(e));
          System.out.print(oblist);
        tb_datedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tb_datearrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        tb_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tb_villedepart.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
        tb_villearrivee.setCellValueFactory(new PropertyValueFactory<>("ville_arrivee"));
     
        tb_place.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
        tb_v.setItems(oblist);
    
       
        
        
    }
   
  



    @FXML
    private void viderVol(javafx.scene.input.MouseEvent event) {
        
      
           
   destinationvol.clear();

    datedvol.clear();

  dateavol.clear();

    nbplaceRvol.clear();

    prixvolr.clear();
    idCvol.clear();
    villeDepart.clear();
    prixTotalV.clear();
    modalite.getItems().clear();
    tb_v.getItems().clear();
    loadTableVol();
  
    }

    @FXML
    private void addVol(ActionEvent event) {
       
           
          ReservationService rs = new ReservationService();
          PaiementService ps = new PaiementService();
     
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       
       if(nbplaceRvol.getText().matches("^[0-9]+$"))
       {
       try
       { Vol v = tb_v.getSelectionModel().getSelectedItem();
             java.util.Date parsedd = format.parse(datedvol.getText());
              java.util.Date parseda = format.parse(dateavol.getText());
              java.sql.Date datR = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Date Datedv = new java.sql.Date(parsedd.getTime());
        java.sql.Date Dateav = new java.sql.Date(parseda.getTime());
       
           System.out.println(v.getId_vol());
           
         Reservation r= new Reservation(datR,Integer.parseInt(nbplaceRvol.getText()), Datedv, Dateav,0,0,v.getId_vol(),0,"Approuve",id,"Vol");
         if(rs.verifierNbplaceVol(v.getId_vol(),Integer.parseInt(nbplaceRvol.getText())))
         { rs.ajouterVol(r);
         Paiement p = new Paiement(modalite.getValue(),Float.valueOf(prixTotalV.getText()),rs.afficher().get(rs.afficher().size()-1).getId(),datR);
         ps.ajouter(p);
          Notifications.create().title("Reservation Vol").text(" Reservation est Créé ").show();
         rs.modifiernbplacevol(v.getId_vol(),Integer.parseInt(nbplaceRvol.getText()));
        
           tb_v.refresh();
         
         }
          else
          {    
                String s=" Nombre de place non valide il vous reste"+v.getNbr_placedispo();
              
              Notifications.create().title("Reservation Vol").text(s).show();
          }
       
       }
       
       catch(ParseException e)
       {
           System.out.println(e);
       }
    }
       else
       {
           
           
                       Notifications.create().title("Reservation voyage organise ").text(" verifier le champs nbre de place " ) .show();
                       
                       
       }
    
    
    
    
    
    }

    @FXML
    private void selectVOL(javafx.scene.input.MouseEvent event) {
        
        index = tb_v.getSelectionModel().getSelectedIndex();
         
         
          
    destinationvol.setText(tb_villedepart.getCellData(index));
    datedvol.setText(""+  tb_datedepart.getCellData(index));
     dateavol.setText(""+tb_datearrivee.getCellData(index));
     prixvolr.setText(""+ tb_prix.getCellData(index));
     villeDepart.setText(tb_villearrivee.getCellData(index));
         
    }

   
    @FXML
    private void calculetPrixTotal(KeyEvent event) {
        
         
        try{
            if(!nbplaceRvol.getText().equals("0")&&!nbplaceRvol.getText().equals(""))
        { 
            Float prixTT=Integer.parseInt(nbplaceRvol.getText())* Float.parseFloat(prixvolr.getText());
        prixTotalV.setText(valueOf(prixTT));
        
    }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
    }
}
