
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
import java.io.File;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javax.swing.ImageIcon;
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
    private TextField a_prix;
    @FXML
    private TextField a_contact;
    @FXML
    private Button B_import;
    @FXML
    private ImageView a_picture_kol;
    @FXML
    private TextField a_pic;
    @FXML
    private Button B_h_modifer;
    @FXML
    private TextField h_referance_modifer;
    @FXML
    private ComboBox<String> h_combo_recherche;
    @FXML
    private TableColumn<?, ?> h_affiche_model;


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
    h_combo_recherche.setItems(FXCollections.observableArrayList("Referance","Paye","Category"));
     
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
        h_affiche_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        h_affiche_nbrdetoile.setCellValueFactory(new PropertyValueFactory<>("nbr_detoile"));
        h_affiche_nbrsuite.setCellValueFactory(new PropertyValueFactory<>("nbr_suite"));
        h_affiche_nbrparking.setCellValueFactory(new PropertyValueFactory<>("nbr_parking"));
        h_affiche_model.setCellValueFactory(new PropertyValueFactory<>("model_caravane"));
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

        if (h_combo_recherche.getValue() =="Referance")
        {
        hebergement_table.getItems().clear();
        String ref=h_recherche_referance.getText();
        int i;
        i =Integer.parseInt(ref);
        if (i==0){
            loadTableHebegement();}
        else{
        
        List <Hebergement> ls =hs.getByReferanc(i);

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
        }
        }
        else if (h_combo_recherche.getValue() =="Paye")
        {
         hebergement_table.getItems().clear();
      String ref=h_recherche_referance.getText();
         List <Hebergement> ls =hs.getBypaye(ref);
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
      
        }
        else
        {
           hebergement_table.getItems().clear();
          String ref=h_recherche_referance.getText();
        int x;
        x =Integer.parseInt(ref);
        List <Hebergement> ls =hs.getBycateg(x);
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
        System.out.println("d5al");
        }
}

    
//*******************************************************************
    @FXML
    private void C_modifer(MouseEvent event) {
          Category a =  categorie_table.getSelectionModel().getSelectedItem();
        a.setNom_categ(a_category.getText());
        cs.modifier(a);
        categorie_table.getItems().clear();
        loadTablecateg();
    }//modifer catergory 


    @FXML
    private void Import(MouseEvent event) {//3aleh fama jcp 
    }

//    private void h_ajouter(ActionEvent event) {
//     
//
//    }
    @FXML
    private void H_modifer(MouseEvent event) {
        HebergementService HS = new HebergementService(); 
     Hebergement a=  hebergement_table.getSelectionModel().getSelectedItem();
//     java.sql.Date datestart =Date.valueOf(a_datestart.getValue());
//     java.sql.Date dateend = Date.valueOf(a_dateend.getValue());
//            a.setDate_start(datestart);
//            a.setDate_end(dateend);     
//            a.setDate_start(datestart);
//            a.setDate_end(dateend); 
            int nbr1=Integer.parseInt(a_nbr_detoile.getText());
            int nbr2=Integer.parseInt(a_nbr_suite.getText());  
            int nbr3=Integer.parseInt(a_nbr_parking.getText());  
            int nbr4=Integer.parseInt(a_category.getText()); 
            a.setPaye(a_paye.getText());
            a.setAdress(a_adress.getText());
            a.setPrix(Float.parseFloat(a_prix.getText()));
            a.setDescription(a_description.getText());
            a.setPhoto(a_pic.getText());
            a.setContact(a_contact.getText());
            a.setNbr_detoile(nbr1);
            a.setNbr_suite(nbr2);
            a.setNbr_parking(nbr3);
            a.setModel_caravane(a_modele.getText());
            a.setId_confeg(nbr4);
     HS.modifier(a);
     

     categorie_table.getItems().clear();
        loadTablecateg();  
        
//    Hebergement a = hebergement_table.getSelectionModel().getSelectedItem();
//    HebergementService hs = new HebergementService();
//     java.sql.Date datestart =Date.valueOf(a_datestart.getValue());
//     java.sql.Date dateend = Date.valueOf(a_dateend.getValue());
//     int nbr1=Integer.parseInt(a_nbr_detoile.getText());  
//     int nbr2=Integer.parseInt(a_nbr_suite.getText());  
//     int nbr3=Integer.parseInt(a_nbr_parking.getText());  
//     int nbr4=Integer.parseInt(a_category.getText());
//        System.out.println("1");
//            a.setPaye(a_paye.getText());
//            a.setAdress(a_adress.getText());
//            a.setPrix(Float.parseFloat(a_prix.getText()));
//            a.setDescription(a_description.getText());
//            a.setPhoto(a_pic.getText());
//            a.setDate_start(datestart);
//            a.setDate_end(dateend);
//            a.setContact(a_contact.getText());
//            a.setNbr_detoile(nbr1);
//            a.setNbr_suite(nbr2);
//            a.setNbr_parking(nbr3);
//            a.setModel_caravane(a_modele.getText());
//            a.setId_confeg(nbr4);
//            hs.modifier(a);
//        categorie_table.getItems().clear();
//        loadTablecateg();  
    }//// mochkla fel changement fel date 


    @FXML
    private void h_ajouterlast(ActionEvent event) {
             SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     java.sql.Date datestart =Date.valueOf(a_datestart.getValue());
     java.sql.Date dateend = Date.valueOf(a_dateend.getValue());
     int nbr1=Integer.parseInt(a_nbr_detoile.getText());  
     int nbr2=Integer.parseInt(a_nbr_suite.getText());  
     int nbr3=Integer.parseInt(a_nbr_parking.getText());  
     int nbr4=Integer.parseInt(a_category.getText()); 
     Hebergement h= new Hebergement(a_paye.getText(),a_adress.getText(),Float.parseFloat(a_prix.getText()),a_description.getText(),a_pic.getText(),datestart,dateend,a_contact.getText(),nbr1 ,nbr2,nbr3,a_modele.getText(),nbr4,1);
     hs.ajouter(h); 
        hebergement_table.getItems().clear();
        loadTableHebegement();
    }

    @FXML
    private void h_select(MouseEvent event) {
                
          int index = hebergement_table.getSelectionModel().getSelectedIndex();
        Hebergement h = hebergement_table.getSelectionModel().getSelectedItem();
        a_adress.setText(h_affiche_adress.getCellData(index));
        a_paye.setText(h_affiche_paye.getCellData(index));
        a_prix.setText(h_affiche_prix.getCellData(index).toString());
        a_modele.setText((String) h_affiche_model.getCellData(index));
        a_description.setText(h_affiche_description.getCellData(index));
        a_pic.setText(h_affiche_pic.getCellData(index));
       // a_datestart.setValue(h_affiche_datestart.getCellData(index));
        // a_dateend.setValue(h_affiche_datestart.getCellData(index));
        System.out.println("middel ");
        
        a_category.setText(h_affiche_categ.getCellData(index).toString());
        a_nbr_detoile.setText(h_affiche_nbrdetoile.getCellData(index).toString());
        a_nbr_parking.setText(h_affiche_nbrdetoile.getCellData(index).toString());
        a_nbr_suite.setText(h_affiche_nbrsuite.getCellData(index).toString());
        a_contact.setText(h_affiche_contact.getCellData(index));
    }

    @FXML
    private void h_importpath(ActionEvent event) {
        //String url = "https://media.istockphoto.com/photos/downtown-cleveland-hotel-entrance-and-waiting-taxi-cab-picture-id472899538?b=1&k=20&m=472899538&s=170667a&w=0&h=oGDM26vWKgcKA3ARp2da-H4St2dMEhJg23TTBeJgPDE=";
        String url=a_pic.getText();
        System.out.println(url);

            Image image = new Image(url);
            if (image.isError()) {
                System.out.println("Error loading image from "+url);
                
                // image.getException().printStackTrace();
            } else {
                System.out.println("Successfully loaded image from " + url);
                a_picture_kol.setImage(image);
            }
        
//      JFileChooser chooser = new JFileChooser();
//      chooser.showOpenDialog(null);
//      File f  =chooser.getSelectedFile();
//      String filename =f.getAbsolutePath();
//      a_pic.setText(filename);
//      Image getAbolutePath =null;
//      ImageIcon icon = new ImageIcon(filename);
      //Image image = icon.getImage().getScaledInstance(a_picture_kol.getWidth(),a_picture_kol.getHeight(),Image.);
      
      
    }
    

}//end Function
