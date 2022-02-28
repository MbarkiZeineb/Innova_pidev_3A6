/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Admin;
import entities.Client;
import entities.Offreur;
import entities.User;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import services.*;
import services.ClientService;
import utilis.Connexion;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class RegistrationController implements Initializable {
private Connection conn;
    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtadr;

    @FXML
    private TextField txtemail;

    @FXML
    private TableView<Admin> tvadmin;

    @FXML
    private TableColumn<Admin, Integer> colid;

    @FXML
    private TableColumn<Admin, String> colnom;

    @FXML
    private TableColumn<Admin, String> colprenom;

    @FXML
    private TableColumn<Admin, String> coladr;

    @FXML
    private TableColumn<Admin, String> colemail;

    @FXML
    private TableColumn<Admin, String> colmdp;

    @FXML
    private Button btnajout;

    @FXML
    private Button btnmodif;

    @FXML
    private Button btnsupp;

    @FXML
    private PasswordField txtmdp;
    
    @FXML
    private TextField txtrech;

    @FXML
    private Button btnrech;
    
     @FXML
    private TextField txtnomC;

    @FXML
    private TextField txtadrC;

    @FXML
    private TextField txtprenomC;

    @FXML
    private TextField txtemailC;

    @FXML
    private TableView<Client> tvClient;

    @FXML
    private TableColumn<Client, String> colnomC;

    @FXML
    private TableColumn<Client, String> colprenomC;

    @FXML
    private TableColumn<Client, String> colemailC;

    @FXML
    private TableColumn<Client, Integer> coletatC;

    @FXML
    private TextField txtrechClient;

    @FXML
    private Button btnrechClient;

    @FXML
    private Button btnajouterC;

    @FXML
    private Button btnmodifierC;

    @FXML
    private Button btnsuppC;
    @FXML
    private PasswordField txtmdpC;
    
    @FXML
    private Button btnBloquer;

    @FXML
    private Button btnActiver;
        @FXML
    private TableColumn<Offreur, String> colnomOF;

    @FXML
    private TableColumn<Offreur, String> colprenomOF;

    @FXML
    private TableColumn<Offreur, String> colemailOF;

    @FXML
    private TableColumn<Offreur, Integer> colTelOF;

    @FXML
    private TextField txtrechOF;

    @FXML
    private Button btnrechOF;

    @FXML
    private Button btnajouterOF;

    @FXML
    private Button btnmodifierOF;

    @FXML
    private Button btnsuppOF;

    @FXML
    private PasswordField txtmdpOF;

    @FXML
    private TextField txtTelOF;
        @FXML
    private TextField txtnomOF;

    @FXML
    private TextField txtprenomOF;

    @FXML
    private TextField txtemailOF;
    
    @FXML
    private TableView<Offreur> tvOffreur;
    
    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
      afficherAdmin();
      afficherClient();
      afficherOffreur();
    }   

    public RegistrationController() {
        
         conn = Connexion.getInstance().getCnx();
    }
    
    
    
    
    //********************************admin*******************************
   
    ObservableList<Admin> oblist1 = FXCollections.observableArrayList();
     AdminService as= new AdminService();
     
     
     
     private void afficherAdmin() {
      List <Admin> ls =as.afficher();
      ls.forEach(e->oblist1.add(e));
      colnom.setCellValueFactory(new PropertyValueFactory<Admin,String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Admin, String>("prenom"));
         colemail.setCellValueFactory(new PropertyValueFactory<Admin, String>("email"));
        coladr.setCellValueFactory(new PropertyValueFactory<Admin, String>("adresse"));
        tvadmin.setItems(oblist1);    
    }
     
     
    @FXML
    void ajouter(ActionEvent event) {

   if(!(txtnom.getText().matches("^[a-zA-Z]+$"))||(txtnom.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre nom");
             }
            if(!(txtprenom.getText().matches("^[a-zA-Z]+$"))||(txtprenom.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre prenom");
             }
              if(!(txtadr.getText().matches("^[a-zA-Z]+$"))||(txtadr.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre adresse");
             }
              if(!(txtemail.getText().matches("^[a-zA-Z@.]+$"))||(txtemail.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre email");
             }
              
             if  (txtmdp.getText().length()<4||(txtmdp.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres");
             }
             else{
      Admin a= new Admin(txtnom.getText(), txtprenom.getText(), txtemail.getText(), txtadr.getText(), txtmdp.getText());
as.ajouter(a);
tvadmin.getItems().clear();
afficherAdmin();}
    }
    
    

    @FXML
    void modifier(ActionEvent event) {

       Admin a =  tvadmin.getSelectionModel().getSelectedItem();
        a.setEmail(txtemail.getText());
        a.setNom( txtnom.getText());
        a.setPrenom(txtprenom.getText());
        a.setAdresse(txtadr.getText());
        a.setPwd(txtmdp.getText());
        as.modifier(a);
        tvadmin.getItems().clear();
        afficherAdmin();
    }
    
    

    @FXML
    void supprimer(ActionEvent event) {

Admin a =  tvadmin.getSelectionModel().getSelectedItem();
as.supprimer(a.getId());
tvadmin.getItems().clear();
afficherAdmin();
    }
    
    
      @FXML
    void rechercher(ActionEvent event) {

List <Admin> ls =as.rechercher(txtrech.getText());
tvadmin.getItems().clear();
  tvadmin.getItems().addAll(ls);
    }
       
    
    @FXML
   private void selectAdmin(javafx.scene.input.MouseEvent event) {
     int index= -1;
     index = tvadmin.getSelectionModel().getSelectedIndex();
     txtnom.setText(colnom.getCellData(index));
     txtprenom.setText(""+  colprenom.getCellData(index));
     txtemail.setText(""+colemail.getCellData(index));
    txtadr.setText(""+coladr.getCellData(index));
    txtmdp.setText("");
      
    }
    
    
   
    //***********************client**************************** 
   
   
   ObservableList<Client> oblist = FXCollections.observableArrayList();
     ClientService cs= new ClientService();
        @FXML
    void Activer(ActionEvent event) {
        Client c =  tvClient.getSelectionModel().getSelectedItem();
        int idCB=c.getId();
as.activerCompteParAdmin(idCB);
tvClient.getItems().clear();
afficherClient();
    }

    @FXML
    void Bloquer(ActionEvent event) {
           Client c =  tvClient.getSelectionModel().getSelectedItem();
        int idCB=c.getId();
as.BanirCompteParAdmin(idCB);
tvClient.getItems().clear();
afficherClient();
    } 
     
   @FXML
    void ajouterC(ActionEvent event) { 
        if(!(txtnomC.getText().matches("^[a-zA-Z]+$"))||(txtnomC.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre nom");
             }
            if(!(txtprenomC.getText().matches("^[a-zA-Z]+$"))||(txtprenomC.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre prenom");
             }
              
              if(!(txtemailC.getText().matches("^[a-zA-Z@.]+$"))||(txtemailC.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre email");
             }
              
             if  (txtmdpC.getText().length()<4||(txtmdpC.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres");
             }
             else{
         Client c= new Client(txtnomC.getText(), txtprenomC.getText(), txtmdpC.getText(), txtemailC.getText());
cs.ajouter(c);
tvClient.getItems().clear();
afficherClient();
             }
}

    
    @FXML
    void modifierC(ActionEvent event) {
        Client c =  tvClient.getSelectionModel().getSelectedItem();
        c.setEmail(txtemailC.getText());
        c.setNom( txtnomC.getText());
        c.setPrenom(txtprenomC.getText());    
cs.modifier(c);
tvClient.getItems().clear();
afficherClient();
    }
    
    

    @FXML
    void supprimerC(ActionEvent event) {
Client c =  tvClient.getSelectionModel().getSelectedItem();
cs.supprimer(c.getId());
tvClient.getItems().clear();
afficherClient();
}
    
    

    @FXML
    void rechercherClient(ActionEvent event) {
List <Client> ls =cs.rechercherclient(txtrechClient.getText());
tvClient.getItems().clear();
  tvClient.getItems().addAll(ls);
  }

 
     
   private void afficherClient() {
      List <Client> ls =cs.afficher();
      ls.forEach(e->oblist.add(e));
      colnomC.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
        colprenomC.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
         colemailC.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        coletatC.setCellValueFactory(new PropertyValueFactory<Client, Integer>("etat"));
        tvClient.setItems(oblist);    
    }
       
   
     @FXML
   private void selectClient(javafx.scene.input.MouseEvent event) {
     int index= -1;
     index = tvClient.getSelectionModel().getSelectedIndex();
     txtnomC.setText(colnomC.getCellData(index));
     txtprenomC.setText(""+  colprenomC.getCellData(index));
     txtemailC.setText(""+colemailC.getCellData(index));
     txtmdpC.setText("");
      
    }
      //***************Offreur*****************************
   
ObservableList<Offreur> oblist2 = FXCollections.observableArrayList();
     OffreurService os= new OffreurService();
   
    @FXML
   private void selectOffreur(javafx.scene.input.MouseEvent event) {
     int index= -1;
     index = tvOffreur.getSelectionModel().getSelectedIndex();
     txtnomOF.setText(colnomOF.getCellData(index));
     txtprenomOF.setText(""+  colprenomOF.getCellData(index));
     txtemailOF.setText(""+colemailOF.getCellData(index));
     txtTelOF.setText(""+colTelOF.getCellData(index));
     txtmdpC.setText("");
      
    }
    
       private void afficherOffreur() {
      List <Offreur> ls =os.afficher();
      ls.forEach(e->oblist2.add(e));
      colnomOF.setCellValueFactory(new PropertyValueFactory<Offreur,String>("nom"));
        colprenomOF.setCellValueFactory(new PropertyValueFactory<Offreur, String>("prenom"));
         colemailOF.setCellValueFactory(new PropertyValueFactory<Offreur, String>("email"));
        colTelOF.setCellValueFactory(new PropertyValueFactory<Offreur, Integer>("numtl"));
        tvOffreur.setItems(oblist2);    
    }
    
   
       @FXML
    void ajouterO(ActionEvent event) {

        
        
        if(!(txtnomOF.getText().matches("^[a-zA-Z]+$"))||(txtnomOF.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre nom");
             }
            if(!(txtprenomOF.getText().matches("^[a-zA-Z]+$"))||(txtprenomOF.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre prenom");
             }
              
              if(!(txtemailOF.getText().matches("^[a-zA-Z@.]+$"))||(txtemailOF.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre email");
             }
              
             if  (txtmdpOF.getText().length()<4||(txtmdpOF.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres");
             }
              if  (txtTelOF.getText().length()<8||(txtTelOF.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre numero de telephone");
             }
             else{
                
         //Offreur o = new Offreur(txtnomOF.getText(), txtprenomOF.getText(), txtmdpOF.getText(), txtemailOF.getText(),txtTelOF.getText());
//os.ajouter(o);
tvOffreur.getItems().clear();
afficherOffreur();
             }
        
        
        
    }
    
    @FXML
    void modifierO(ActionEvent event) {

    }
       @FXML
    void supprimerO(ActionEvent event) {

    }
        @FXML
    void rechercherO(ActionEvent event) {

    }
   
   
   
   
   
   
   
   
   
   
   
   
   
 
    
  


  
    
    
    
}
