/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import Entities.Vol;
import Entities.voyageOrganise;
import Services.PaiementService;
import Services.ReservationService;
import Services.voyOrgServ;
import static java.lang.String.valueOf;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
 ReservationService rs = new ReservationService();
    @FXML
    private TableView<voyageOrganise> tableviewVO;

    @FXML
    private TableColumn<voyageOrganise, String> VilleDep;

    @FXML
    private TableColumn<voyageOrganise, String> villeDest;

    @FXML
    private TableColumn<voyageOrganise, String> DateDeb;

    @FXML
    private TableColumn<voyageOrganise, String> DateFin;

    @FXML
    private TableColumn<voyageOrganise, Integer> nbrPlace;

    @FXML
    private TableColumn<voyageOrganise, Integer> categ;

    @FXML
    private TableColumn<voyageOrganise, Float> prix;

    @FXML
    private TableColumn<voyageOrganise, String> Desc;
    
    voyOrgServ vo = new voyOrgServ();
    @FXML
    private TextField prixTTV;
    @FXML
    private TextField aaaa;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nbp.setText("0");
        
        loadTable();
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
        
         private void loadTable() {
     
            // TODO
       
     ObservableList<voyageOrganise> oblist = FXCollections.observableArrayList();
          List <voyageOrganise> ls =vo.afficher();
          ls.forEach(e->oblist.add(e));
          System.out.print(oblist);
          VilleDep.setCellValueFactory(new PropertyValueFactory<>("villeDepart"));
          villeDest.setCellValueFactory(new PropertyValueFactory<>("villeDest"));
           DateDeb.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
            DateFin.setCellValueFactory(new PropertyValueFactory<>("dateArrive"));
            nbrPlace.setCellValueFactory(new PropertyValueFactory<>("nbrPlace"));
            categ.setCellValueFactory(new PropertyValueFactory<>("idCat"));
            prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            Desc.setCellValueFactory(new PropertyValueFactory<>("description"));
      
    tableviewVO.setItems(oblist);
   
    }
         
           @FXML
    private void selectvol(MouseEvent event) {
         int  index =   tableviewVO.getSelectionModel().getSelectedIndex();
    villeDvoy.setText( VilleDep.getCellData(index));
     VilleDestVoy.setText(villeDest.getCellData(index));
    dateD.setText(DateDeb.getCellData(index));
    dateF.setText(DateDeb.getCellData(index));
   dateF.setText(DateFin.getCellData(index));;
     prixVoy.setText(prix.getCellData(index).toString());
   
    
        }
    

   
        
    

    

    @FXML
    private void CalculerPrixTotal(KeyEvent event) {
        
            
        System.out.println("aaaaaaaaaa");
           
        try{
            
            System.out.println("bbbbbbbbbbbbbbbb");
            
            if(!nbp.getText().equals("0") && !nbp.getText().equals("") )
        { 
            Float prixTT=Integer.parseInt(nbp.getText())* Float.parseFloat(prixVoy.getText());
            
            prixTTV.setText(prixTT.toString());
           
            
        
    }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }}

  

