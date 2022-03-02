/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GetAway.entities.Activite;
import GetAway.entities.Avis;
import GetAway.services.ActiviteService;
import GetAway.services.AvisService;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author TheBoss'07
 */
public class GestionActivitesController implements Initializable {
    
    

    @FXML
    private Button btnajouter;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtduree;
    @FXML
    private TextField txtnbrp;
    @FXML
    private TableView<Activite> tvactivite;
    @FXML
    private TextArea textdescrip;
    @FXML
    private TextField txttype;
    @FXML
    private DatePicker txtdate;
    @FXML
    private TextField txtprix;
    @FXML
    private TextField txtloc;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TableColumn<Activite, String> colnom;
    @FXML
    private TableColumn<Activite, String> colduree;
    @FXML
    private TableColumn<Activite, Integer> colnbrp;
    @FXML
    private TableColumn<Activite, String> coldate;
    @FXML
    private TableColumn<Activite, String> coltype;
    @FXML
    private TableColumn<Activite, String> colloc;
    @FXML
    private TableColumn<Activite, Float> colprix;
    @FXML
    private TableColumn<Activite, String> coldesc;
    @FXML
    private Button btnvider;
    @FXML
    private Button btnrecherche;
    @FXML
    private TextField txtinput;
    @FXML
    private Button btntri;
    @FXML
    private TableView<Activite> tvavisa;
    @FXML
    private TableView<Avis> tvavis;
    @FXML
    private TableColumn<Activite, String> colnomac;
    @FXML
    private TextField txtnoma;
    @FXML
    private TextArea txtcomment;
    @FXML
    private TableColumn<Avis, String> colmessage;
    @FXML
    private TableColumn<Avis, String> coldateav;
    @FXML
    private TableColumn<?, ?> colnomcl;
    @FXML
    private Button btnmodifierav;
    @FXML
    private Button btnsupprimerav;
    @FXML
    private TableColumn<?, ?> coldescripac;
    @FXML
    private Button btnviderav;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      affichage();
      affichageAv();
      AffActAv();
      Activite a = tvactivite.getSelectionModel().getSelectedItem();
      Avis av = tvavis.getSelectionModel().getSelectedItem();
      Activite ava = tvavisa.getSelectionModel().getSelectedItem();
    }
    
        ActiviteService as = new ActiviteService();
         AvisService avs = new AvisService();
         
        ObservableList<Activite> oblist = FXCollections.observableArrayList();
        ObservableList<Avis> oblistav = FXCollections.observableArrayList();
        
     
    @FXML
    void ajouter(ActionEvent event) throws Exception {
       { Activite a =new Activite();
         String date = txtdate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
         
        a.setNom(txtnom.getText());
        a.setDuree(txtduree.getText());
        a.setNbrPlace(Integer.parseInt(txtnbrp.getText()));
        a.setDate(date);
        a.setType(txttype.getText());
        a.setLocation(txtloc.getText());
        a.setPrix(Float.parseFloat(txtprix.getText()));
        a.setDescrip(textdescrip.getText());
        
        as.ajouter(a);
        
        
        saveAlert(a);
        tvactivite.getItems().clear();
        affichage();

    }
       }
    
    
     @FXML
    private void vider(ActionEvent event) {
        clearFields();
    }
    
        

    @FXML
    private void modifier(ActionEvent event) {
        
         Activite a=  tvactivite.getSelectionModel().getSelectedItem();
      
       String date = txtdate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
         
        a.setNom(txtnom.getText());
        a.setDuree(txtduree.getText());
        a.setNbrPlace(Integer.parseInt(txtnbrp.getText()));
        a.setDate(date);
        a.setType(txttype.getText());
       a.setLocation(txtloc.getText());
        a.setPrix(Float.parseFloat(txtprix.getText()));
      a.setDescrip(textdescrip.getText());
      
     as.modifier(a);
     
    tvactivite.getItems().clear();
    affichage();
  
   
    }

   
    @FXML
    private void supprimer(ActionEvent event) {
        
        Activite a =  tvactivite.getSelectionModel().getSelectedItem();  
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Notification de Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Vous confirmer la suppression ?");
		Optional<ButtonType> action = alert.showAndWait();
        as.supprimer(a);
        tvactivite.getItems().clear();
        affichage();
     

    }
    
    
    public void affichage() {
        List<Activite> activites = as.afficher();
        activites.forEach(e->oblist.add(e));
        
        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colduree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
        colnbrp.setCellValueFactory(new PropertyValueFactory<>("NbrPlace"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colloc.setCellValueFactory(new PropertyValueFactory<>("Location"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("Descrip"));
        

        tvactivite.setItems(oblist);

    }

     @FXML
    private void recherche(ActionEvent event) {
    
       ActiviteService as = new ActiviteService();
         Activite a=new Activite ();
        
        ObservableList<Activite> activ = as.rechercherActivite(txtinput.getText());
        
        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colduree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
        colnbrp.setCellValueFactory(new PropertyValueFactory<>("NbrPlace"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colloc.setCellValueFactory(new PropertyValueFactory<>("Location"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("Descrip"));

        tvactivite.setItems(activ);
    }
    
     private boolean validate(String field, String value, String pattern){
		if(!value.isEmpty()){
			Pattern p = Pattern.compile(pattern);
	        Matcher m = p.matcher(value);
	        if(m.find() && m.group().equals(value)){
	            return true;
	        }else{
	        	validationAlert(field, false);            
	            return false;            
	        }
		}else{
			validationAlert(field, true);            
            return false;
		}        
    }
    
    private boolean emptyValidation(String field, boolean empty){
        if(!empty){
            return true;
        }else{
        	validationAlert(field, true);            
            return false;            
        }
    }	
	
	private void validationAlert(String field, boolean empty){
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Erreur de validation");
        alert.setHeaderText(null);
        if(field.equals("Role")) alert.setContentText("Please Select "+ field);
        else{
        	if(empty) alert.setContentText("Please Enter "+ field);
        	else alert.setContentText("Please Enter Valid "+ field);
        }
        alert.showAndWait();
	}
        
        private void saveAlert(Activite a){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification d'ajout.");
		alert.setHeaderText(null);
		alert.setContentText("L'activite "+a.getNom()+" est ajouter avec succées");
		alert.showAndWait();
	}
	
	private void updateAlert(Activite a){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification de modification.");
		alert.setHeaderText(null);
		alert.setContentText("L'activite"+a.getNom()+" est modifier avec succees");
		alert.showAndWait();
	}

  private void clearFields() {
		txtduree.clear();
		txtnom.clear();
                txtnbrp.clear();
                textdescrip.clear();
                txttype.clear();
                txtdate.getEditor().clear();
                txtprix.clear();
                txtloc.clear();
		
	}

    @FXML
    private void trier(ActionEvent event) {
        ActiviteService as = new ActiviteService();
        as.trierActiviteNbrplace();

       ObservableList <Activite> activites= as.trierActiviteNbrplace();;

        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colduree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
        colnbrp.setCellValueFactory(new PropertyValueFactory<>("NbrPlace"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colloc.setCellValueFactory(new PropertyValueFactory<>("Location"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("Descrip"));
        
        tvactivite.setItems(activites);
    }

   
    @FXML
    private void selectAll(javafx.scene.input.MouseEvent event) {
    int index= -1;
    index = tvactivite.getSelectionModel().getSelectedIndex();
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");     
    LocalDate localDate = LocalDate.parse(coldate.getCellData(index), formatter);
         
 
     txtduree.setText(colduree.getCellData(index));
     txtnom.setText(""+  colnom.getCellData(index));
     txtnbrp.setText(""+colnbrp.getCellData(index));
     textdescrip.setText(""+coldesc.getCellData(index));
     txttype.setText(""+coltype.getCellData(index));
     txtdate.setValue(localDate);
     txtprix.setText(""+colprix.getCellData(index));
     txtloc.setText(""+colloc.getCellData(index));
    }
   /************************************************Avis**********************************************
    */
    
    
    public void affichageAv() {
        List<Avis> avis = avs.afficher();
        avis.forEach(e->oblistav.add(e));
        
        colmessage.setCellValueFactory(new PropertyValueFactory<>("Message"));
        coldateav.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colnomcl.setCellValueFactory(new PropertyValueFactory<>("Id"));

        tvavis.setItems(oblistav);
    
    
    }

    @FXML
    private void modifierAv(ActionEvent event) {
        
         Avis av=  tvavis.getSelectionModel().getSelectedItem();
      av.setMessage(txtcomment.getText());
      
     avs.modifier(av);
     
     Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification de modification.");
		alert.setHeaderText(null);
		alert.setContentText("L'avis est modifier avec succees");
		alert.showAndWait();
     
    tvavis.getItems().clear();
    affichageAv();

    
}
    @FXML
     private void supprimerav(ActionEvent event) {
        
        Avis av =  tvavis.getSelectionModel().getSelectedItem();  
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Notification de Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Vous confirmer la suppression ?");
		Optional<ButtonType> action = alert.showAndWait();
        avs.supprimer(av);
        tvavis.getItems().clear();
        affichageAv();
     

    }
     
    @FXML
    private void selectAllav(javafx.scene.input.MouseEvent event) {
    int index= -1;
    index = tvavis.getSelectionModel().getSelectedIndex();
    
     txtcomment.setText(""+colmessage.getCellData(index));
    }
    
    
    @FXML
    private void selectNom(javafx.scene.input.MouseEvent event) {
    int index= -1;
    index = tvavisa.getSelectionModel().getSelectedIndex();
    
     txtnoma.setText(""+colnomac.getCellData(index));
    }

    public void AffActAv() {
        List<Activite> activites = as.afficher();
        activites.forEach(e->oblist.add(e));
        
        colnomac.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        coldescripac.setCellValueFactory(new PropertyValueFactory<>("Descrip"));
        

        tvavisa.setItems(oblist);

    }

    
    private void clearFieldsAv() {
		txtcomment.clear();
		txtnoma.clear();
	}
    
    @FXML
    private void viderAv(ActionEvent event) {
        clearFieldsAv();
    }
}
