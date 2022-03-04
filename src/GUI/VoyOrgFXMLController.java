/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import getaway.services.*;
import getaway.entities.voyageOrganise;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Amal Chibani
 */
public class VoyOrgFXMLController implements Initializable {

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

     @FXML
    private TextField txtvilleDep;

    @FXML
    private TextField txtvilleDest;

    @FXML
    private TextField txtdateDeb;

    @FXML
    private TextField txtdateFin;

    @FXML
    private TextField txtnbrPlace;

    @FXML
    private TextField txtCat;

    @FXML
    private TextField txtprix;

    @FXML
    private TextArea txtdesc;
    
 @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnAdd;
    
    @FXML
    private Button btnsearch;

    @FXML
    private TextField txtsearch;
    
     @FXML
    private Button btnsort;

    
    voyOrgServ vos = new voyOrgServ();
    @FXML
    private Button btnstat;
    /**
     * Initializes the controller class.
     */
    
    private void loadTable() {
     
            // TODO
       
     ObservableList<voyageOrganise> oblist = FXCollections.observableArrayList();
          List <voyageOrganise> ls =vos.afficher();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTable();
       
    }  
   

    @FXML
    void Add(ActionEvent event) throws Exception{

       
        voyOrgServ vos= new voyOrgServ();
        if(!(txtvilleDep.getText().matches("^[a-zA-Z]+$"))||(txtvilleDep.getText().equals(""))) {

            JOptionPane.showMessageDialog(null, "verifier votre choix");}
       
        
        if(!(txtvilleDest.getText().matches("^[a-zA-Z]+$"))||(txtvilleDest.getText().equals(""))){

            JOptionPane.showMessageDialog(null, "verifier votre choix");
             }
//        if(!(txtprix.getText().length()==0)) {
//
//            JOptionPane.showMessageDialog(null, "champ vide!");
//             }
        else{
       voyageOrganise v =new voyageOrganise(txtvilleDep.getText(),txtvilleDest.getText(),txtdateDeb.getText(),txtdateFin.getText(),Integer.parseInt(txtnbrPlace.getText()),Integer.parseInt(txtCat.getText()),Float.parseFloat(txtprix.getText()),txtdesc.getText());
         vos.ajouter(v);

      tableviewVO.getItems().clear();
        
      // saveAlert(v);
       // tvactivite.getItems().clear();
       System.out.println("ajout avec succés");
       loadTable();} 
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
//        
//        private void saveAlert(voyageOrganise v){
//		
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Notification d'ajout.");
//		alert.setHeaderText(null);
//		alert.setContentText("L'activite "+v.getIdVoy()+" est ajouter avec succées");
//		alert.showAndWait();
//	}
    
    @FXML
    void deletevo(ActionEvent event) {
        
voyageOrganise v =  tableviewVO.getSelectionModel().getSelectedItem();
vos.delete(v.getIdVoy());
tableviewVO.getItems().clear();
 loadTable();
    }

    @FXML
    void updatevo(ActionEvent event) {
        voyageOrganise v =  tableviewVO.getSelectionModel().getSelectedItem();

        v.setVilleDepart(txtvilleDep.getText());
        v.setVilleDest(txtvilleDest.getText());
        v.setDateDepart(txtdateDeb.getText());
        v.setDateArrive(txtdateFin.getText());
        v.setNbrPlace(Integer.parseInt(txtnbrPlace.getText()));
        v.setPrix(Float.parseFloat(txtprix.getText()));
        v.setIdCat(Integer.parseInt(txtCat.getText()));
        v.setDescription(txtdesc.getText());
        vos.update(v);
        tableviewVO.getItems().clear();
        loadTable();
    }

    @FXML
    private void select(MouseEvent event) {
        
          
    int  index = tableviewVO.getSelectionModel().getSelectedIndex();
     txtvilleDep.setText(VilleDep.getCellData(index));
     txtvilleDest.setText(villeDest.getCellData(index));
     txtdateDeb.setText(DateDeb.getCellData(index));
     txtdateFin.setText(DateFin.getCellData(index));
      txtnbrPlace.setText(""+nbrPlace.getCellData(index));
      txtprix.setText(""+prix.getCellData(index));
      txtCat.setText(""+categ.getCellData(index));
      txtdesc.setText(Desc.getCellData(index));
    }
    
    @FXML
    void searchvo(ActionEvent event) {
    ObservableList<voyageOrganise> oblist = FXCollections.observableArrayList();
     List <voyageOrganise> ls =vos.FindVille(txtsearch.getText());
    tableviewVO.getItems().clear();
    tableviewVO.getItems().addAll(ls);
        
    }
     @FXML
    void sortprix(ActionEvent event) {

         
        vos.TrierParPrix();

       ObservableList <voyageOrganise> oblist= vos.TrierParPrix();

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
    private void statistique(ActionEvent event) {
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Statisique.fxml"));
                       Parent root ;
        try {
            root=loader.load();
             btnstat.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GUI.StatisiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
}
