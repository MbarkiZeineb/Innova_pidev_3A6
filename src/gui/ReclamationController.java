/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.ReclamationService;
import entities.Reclamation;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.ClientService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReclamationController implements Initializable {

    
    @FXML
    private Button btnajoutRec;

    @FXML
    private TextField txtobj;

    @FXML
    private TextArea txtdesc;
       @FXML
    private Button btnmodifRec;

    @FXML
    private Button btnsuppRec;
    
        @FXML
    private TableView<Reclamation> tvRec;

    @FXML
    private TableColumn<Reclamation, String> colObj;

    @FXML
    private TableColumn<Reclamation, String> colDesc;
    
    
     private int idc;

    public void setIdc(int idc) {
        this.idc = idc;
        afficherRec();
    }
    ObservableList<Reclamation> oblist1 = FXCollections.observableArrayList();  
ReclamationService rs = new ReclamationService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
afficherRec();

    }
    
        @FXML
    void selectRec(MouseEvent event) {
        
          int index= -1;
     index = tvRec.getSelectionModel().getSelectedIndex();
     txtobj.setText(colObj.getCellData(index));
     txtdesc.setText(""+  colDesc.getCellData(index));
          //  System.out.println("aaaaaaa");
  
    }
    
    
    
          private void afficherRec() {
      List <Reclamation> ls =rs.afficherParIdC(idc);
      ls.forEach(e->oblist1.add(e));
      colObj.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("objet"));
        colDesc.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
         
        tvRec.setItems(oblist1);    
    }

    @FXML
    void AjouterRec(ActionEvent event) {

      Reclamation r= new Reclamation(idc,txtobj.getText(),txtdesc.getText());
rs.ajouter(r);
tvRec.getItems().clear();
afficherRec();
            

    }
    
    
        @FXML
    void modifierreclamation(ActionEvent event) {

       
       Reclamation r =  tvRec.getSelectionModel().getSelectedItem();
      
         
        r.setObjet(txtobj.getText());
        r.setDescription(txtdesc.getText());
       
        rs.modifier(r);
        tvRec.getItems().clear();
        afficherRec();
        
    }

    @FXML
    void supprimerRec(ActionEvent event) {

       Reclamation o =  tvRec.getSelectionModel().getSelectedItem();
rs.supprimer(o.getIdR());
tvRec.getItems().clear();
afficherRec(); 
        
    }
    

   
  
    
}
