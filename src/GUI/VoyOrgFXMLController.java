/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import getaway.services.*;
import getaway.entities.voyageOrganise;
import java.net.URL;
import java.text.ParseException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
  //
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
    private Button btnAdd;
    
    voyOrgServ vo = new voyOrgServ();
    /**
     * Initializes the controller class.
     */
    
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTable();
       
    }  
   

    @FXML
    void Add(ActionEvent event) throws Exception{

       
        voyOrgServ vos= new voyOrgServ();
       voyageOrganise v =new voyageOrganise();
       
        v.setVilleDepart(VilleDep.getText());
        v.setVilleDest(villeDest.getText());
        v.setPrix(Float.parseFloat(prix.getText()));
        v.setDateDepart(DateDeb.getText());
        v.setDateArrive(DateFin.getText());
        v.setNbrPlace(Integer.parseInt(nbrPlace.getText()));
        v.setIdCat(Integer.parseInt(categ.getText()));
        v.setDescription(Desc.getText());
       vos.ajouter(v);
       System.out.println("ajout avec succés");
       loadTable();
        
    }
    
     
}
