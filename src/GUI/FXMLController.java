
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CategoryService;
import Services.HebergementService;
import entities.Category;
import entities.Hebergement;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static sun.net.www.MimeTable.loadTable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class FXMLController implements Initializable {

//all 
    @FXML
    private Button B_hebergement;

    private Pane I_hebergement;
//category
    @FXML
 private TableView<Category> categorie_table;
    @FXML 
    private TableColumn<Category ,Integer > c_id; 
    @FXML 
    private TableColumn<Category ,String > c_nom;
// hebergement affiche
    @FXML
  private TableView<Hebergement> hebergement_table;
     
      @FXML
    private TableColumn<Hebergement, Integer> h_affiche_referance;
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
    @FXML
    private TableColumn<Hebergement, Integer> h_affiche_categ;
    @FXML
    private TableColumn<Hebergement, Integer> h_affiche_offreur;
 
  
//duh
    @FXML
    private Button B_c_supprimer;
    @FXML
    private Button B_c_modifer;
    @FXML
    private Button B_h_ajouter;

    @FXML
    private Button B_h_supp;
    @FXML
    private Button B_h_recherche;
    @FXML
    private TextField h_recherche_referance;
    @FXML
    private Button B_utilisateur;
    @FXML
    private Button B_voyages;
    @FXML
    private Button B_activites;
    @FXML
    private Button B_vols;
    @FXML
    private Button B_reservations;
    @FXML
    private TabPane F_hebergement;
    @FXML
    private Tab ajouter_hebegement;
    @FXML
    private AnchorPane hebergement_ajouter;
    @FXML
    private TextField a_paye;
    @FXML
    private TextArea a_description;
    @FXML
    private TextField a_adress;
    @FXML
    private TextField a_category;
    @FXML
    private DatePicker a_datestart;
    @FXML
    private DatePicker a_dateend;
    @FXML
    private TextField a_modele;
    @FXML
    private TextField a_nbr_suite;
    @FXML
    private TextField a_nbr_parking;
    @FXML
    private TextField a_nbr_detoile;
    @FXML
    private Button B_c_ajouter;
    @FXML
    private ComboBox<?> c_cbox;
    @FXML
    private Button c_b_back;
    @FXML
    private Button c_b_next;
    @FXML
    private TextField a_prix;
    @FXML
    private TextField a_contact;
    @FXML
    private Button B_import;
    @FXML
    private ImageView a_picture_kol;
    @FXML
    private TextField a_pic;


    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private void handelButtonAction(ActionEvent event){
    if (event.getSource()== B_hebergement)  {I_hebergement.toFront();}
    
    }
     
     ObservableList<Category> oblist = FXCollections.observableArrayList();
     CategoryService cs= new CategoryService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    loadTablecateg();//categ
    loadTableHebegement();//heberegement
    
    }    
    
    
    private void loadTablecateg(){//affiche categ 
        List <Category> ls =cs.afficher();
        ls.forEach(e->oblist.add(e));
        System.out.println(oblist);
        c_id.setCellValueFactory(new PropertyValueFactory<>("id_categ"));
        c_nom.setCellValueFactory(new PropertyValueFactory<>("nom_categ"));
     categorie_table.setItems(oblist);
    }
   
ObservableList<Hebergement> oblistH = FXCollections.observableArrayList();
     HebergementService hs= new HebergementService();
    private void loadTableHebegement() {// hebergement affiche
         List <Hebergement> ls =hs.afficher();
        ls.forEach(e->oblistH.add(e));
        System.out.println(oblist);
        h_affiche_referance.setCellValueFactory(new PropertyValueFactory<>("referance"));
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
        h_affiche_categ.setCellValueFactory(new PropertyValueFactory<>("id_confeg"));
        h_affiche_offreur.setCellValueFactory(new PropertyValueFactory<>("offreur"));

     hebergement_table.setItems(oblistH);
     
    }
  

    @FXML
    private void C_suppimer(MouseEvent event) {
        
        
        Category c=  categorie_table.getSelectionModel().getSelectedItem();
      
      cs.supprimer(c);
      categorie_table.getItems().clear();
      loadTablecateg();
    }// supprimer C

    @FXML
    private void h_hebergement(MouseEvent event) {//supprimer hebergement
        Hebergement h = hebergement_table.getSelectionModel().getSelectedItem();
    hs.supprimer(h);
      hebergement_table.getItems().clear();
      loadTableHebegement();
    }//supprimer hebergement
    


    @FXML
    private void C_ajouter(ActionEvent event) {
//        String req ="SELECT MAX(id_categ) FROM `category`";
//        //Integer.valueOf(req);
//        int i=Integer.parseInt(req);
//        i++;
        Category c= new Category(a_category.getText());
        //c.setId_categ(i);
        cs.ajouter(c);
        categorie_table.getItems().clear();
        loadTablecateg();
    }//ajouter categ
@FXML
    private void H_recherche(ActionEvent event) {
        hebergement_table.getItems().clear();
      String ref=h_recherche_referance.getText();
        int i;
        i =Integer.parseInt(ref);
        List <Hebergement> ls =hs.getByReferanc(i));
        ls.forEach(e->oblistH.add(e));
        System.out.println(oblist);
        h_affiche_referance.setCellValueFactory(new PropertyValueFactory<>("referance"));
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
        h_affiche_categ.setCellValueFactory(new PropertyValueFactory<>("id_confeg"));
        h_affiche_offreur.setCellValueFactory(new PropertyValueFactory<>("offreur"));

     hebergement_table.setItems(oblistH);
        
        
    }

    @FXML
    private void Import(MouseEvent event) {
    }

    @FXML
    private void C_modifer(MouseEvent event) {
          Category a =  categorie_table.getSelectionModel().getSelectedItem();
        a.setNom_categ(a_category.getText());
        cs.modifier(a);
        categorie_table.getItems().clear();
        loadTablecateg();
    }

    @FXML
    private void H_ajouter(ActionEvent event) {
        //        Hebergement h= new Hebergement(a_paye.getText(),a_adress.getText(),a_prix.getText(), a_description.getText(),a_picture.get, a_datestart.getValue() ,a_dateend.getValue(),a_contact.getText(), a_nbr_detoile.getText(),a_nbr_suite.getText(),a_nbr_parking.getText(),a_modele.getText(),a_category.getText() ,1);

    }
}
   
    
//    @FXML
//    private void C_modifer(MouseEvent event) {
//           Category a =  categorie_table.getSelectionModel().getSelectedItem();
//        a.setNom_categ(a_category.getText());
//        cs.modifier(a);
//        categorie_table.getItems().clear();
//        loadTablecateg();
//    }
//    
//    @FXML
//    private void Import(MouseEvent event) {
//        
//    }
//    @FXML
//    private void H_ajouter(ActionEvent event) {
//    }

    

