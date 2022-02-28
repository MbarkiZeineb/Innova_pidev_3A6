/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GetAway.entities.Activite;
import GetAway.services.ActiviteService;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    void ajouter(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      affichage();
    }    

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }
    
    ActiviteService as = new ActiviteService();
        ObservableList<Activite> oblist = FXCollections.observableArrayList();
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
}
