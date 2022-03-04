/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Admin;
import entities.Client;
import entities.Offreur;
import entities.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private ComboBox combosecurity;

    @FXML
    private TextField txtrep;

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
    
    //agent aerien

 @FXML
    private TextField txtnomAG;

    @FXML
    private TextField txtprenomAG;

    @FXML
    private TextField txtemailAG;
    
    @FXML
    private PasswordField txtmdpAG;

    @FXML
    private TextField txtNomAgence; 
    @FXML
    private TextField txtrechAG;

    @FXML
    private TableView<AgentAerien> tvAgent;

    @FXML
    private TableColumn<AgentAerien, String> colnomAG;

    @FXML
    private TableColumn<AgentAerien, String> colprenomAG;

    @FXML
    private TableColumn<AgentAerien, String> colemailAG;

    @FXML
    private TableColumn<AgentAerien, String> colNomAgence;

    @FXML
    private Button btnrechAG;

    @FXML
    private Button btnajouterAG;

    @FXML
    private Button btnmodifierAG;

    @FXML
    private Button btnsuppAG;

    
    @FXML
    private Button btnActualiser;
    
    @FXML
    private TextField txtnbtot;
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
      afficherAdmin();
      afficherClient();
      afficherOffreur();
       afficherAgent();
       nbtotalAdmin();
       
        ObservableList<String> list1 = FXCollections.observableArrayList("votre premiere voiture","pays de ton reve","ton idole");
        combosecurity.setItems(list1);
       
    }   

    public RegistrationController() {
        
         conn = Connexion.getInstance().getCnx();
    }
    
    
    
    
    //********************************admin*******************************
   
    ObservableList<Admin> oblist1 = FXCollections.observableArrayList();
     AdminService as= new AdminService();
     
        @FXML
    void Actualiser(ActionEvent event) {
nbtotalAdmin();
    }
    
    
    public void nbtotalAdmin(){
    try {
        PreparedStatement pst=conn.prepareStatement("select count(id) from admin");
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {
      int calcul = rs.getInt("count(id)");
      txtnbtot.setText(String.valueOf(calcul));
      }
        
    } catch (SQLException ex) {
        Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }
     
     
     
     
    
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
         if  (txtmdp.getText().length()<4||(txtmdp.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres ");
             }
         else{
        a.setEmail(txtemail.getText());
        a.setNom( txtnom.getText());
        a.setPrenom(txtprenom.getText());
        a.setAdresse(txtadr.getText());
        a.setPwd(txtmdp.getText());
        as.modifier(a);
        tvadmin.getItems().clear();
        afficherAdmin();}
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
                 if(!(txtrep.getText().matches("^[a-zA-Z@.]+$"))||(txtrep.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre reponse");
             }
              
             if  (txtmdpC.getText().length()<4||(txtmdpC.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres");
             }
             else{
         Client c= new Client(combosecurity.getSelectionModel().getSelectedItem().toString(), txtrep.getText(), txtnomC.getText(), txtprenomC.getText(), txtmdpC.getText(), txtemailC.getText());
cs.ajouter(c);
tvClient.getItems().clear();
afficherClient();
             }
}

    
    @FXML
    void modifierC(ActionEvent event) {
        Client c =  tvClient.getSelectionModel().getSelectedItem();
           if  (txtmdpC.getText().length()<4||(txtmdpC.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres ");
             }
             if(!(txtrep.getText().matches("^[a-zA-Z@.]+$"))||(txtrep.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre reponse");
             }
else{
        c.setEmail(txtemailC.getText());
        c.setNom( txtnomC.getText());
        c.setPrenom(txtprenomC.getText());  
        c.setSecurityQ(combosecurity.getSelectionModel().getSelectedItem().toString());
        c.setAnswer(txtrep.getText());
cs.modifier(c);
tvClient.getItems().clear();
afficherClient();
           }
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
      txtrep.setText("");
     ObservableList<String> list1 = FXCollections.observableArrayList("veuillez choisir une question","votre premiere voiture","pays de ton reve","ton idole");
        combosecurity.setItems(list1);
             
              
              
              
      
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
     txtmdpOF.setText("");
      
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
         int num = Integer.parseInt(txtTelOF.getText());
         Offreur o = new Offreur(txtnomOF.getText(), txtprenomOF.getText(), txtmdpOF.getText(), txtemailOF.getText(),num);
os.ajouter(o);
tvOffreur.getItems().clear();
afficherOffreur();
             }   
    }
    
    @FXML
    void modifierO(ActionEvent event) {
        Offreur o =  tvOffreur.getSelectionModel().getSelectedItem();
         if  (txtmdpOF.getText().length()<4||(txtmdpOF.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres");
             }
         else{
        o.setEmail(txtemailOF.getText());
        o.setNom( txtnomOF.getText());
        o.setPrenom(txtprenomOF.getText());    
        o.setNumtl(Integer.parseInt(txtTelOF.getText()));
        o.setPwd(txtmdpOF.getText());
        
os.modifier(o);
tvOffreur.getItems().clear();
afficherOffreur();
         }
        
    }
       @FXML
    void supprimerO(ActionEvent event) {
Offreur o =  tvOffreur.getSelectionModel().getSelectedItem();
os.supprimer(o.getId());
tvOffreur.getItems().clear();
afficherOffreur();
    }
        @FXML
    void rechercherO(ActionEvent event) {
List <Offreur> ls =os.rechercheroffreur(txtrechOF.getText());
tvOffreur.getItems().clear();
  tvOffreur.getItems().addAll(ls);
    }
    
    
    
    //*******************************agent aerien*************************************************
    
   ObservableList<AgentAerien> oblist3 = FXCollections.observableArrayList();
     AgentAerienService ags= new AgentAerienService(); 
     
         @FXML
    void ajouterAG(ActionEvent event) {
 if(!(txtnomAG.getText().matches("^[a-zA-Z]+$"))||(txtnomAG.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre nom");
             }
            if(!(txtprenomAG.getText().matches("^[a-zA-Z]+$"))||(txtprenomAG.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre prenom");
             }
              
              if(!(txtemailAG.getText().matches("^[a-zA-Z@.]+$"))||(txtemailAG.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre email");
             }
              
             if  (txtmdpAG.getText().length()<4||(txtmdpAG.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres");
             }
               if(!(txtNomAgence.getText().matches("^[a-zA-Z]+$"))||(txtNomAgence.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier votre nom d'agence ");
             }
             else{
AgentAerien ag = new AgentAerien(txtnomAG.getText(), txtprenomAG.getText(), txtmdpAG.getText(), txtemailAG.getText(), txtNomAgence.getText());
ags.ajouter(ag);
tvAgent.getItems().clear();
afficherAgent();
             }   
    }
    
    @FXML
    void modifierAG(ActionEvent event) {
      AgentAerien ag =  tvAgent.getSelectionModel().getSelectedItem();
         if  (txtmdpAG.getText().length()<4||(txtmdpAG.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 4 characteres");
             }
         else{
        ag.setEmail(txtemailAG.getText());
        ag.setNom( txtnomAG.getText());
        ag.setPrenom(txtprenomAG.getText());    
        ag.setPwd(txtmdpAG.getText());
        ag.setNomAgence(txtNomAgence.getText());
        
ags.modifier(ag);
tvAgent.getItems().clear();
afficherAgent();
         }
    }
    
        @FXML
    void rechercherAG(ActionEvent event) {
List <AgentAerien> ls =ags.rechercheragent(txtrechAG.getText());
tvAgent.getItems().clear();
  tvAgent.getItems().addAll(ls);
    }
    
    
        @FXML
    void selectAgent(MouseEvent event) {
     int index= -1;
     index = tvAgent.getSelectionModel().getSelectedIndex();
     txtnomAG.setText(colnomAG.getCellData(index));
     txtprenomAG.setText(""+  colprenomAG.getCellData(index));
     txtemailAG.setText(""+colemailAG.getCellData(index));
     txtNomAgence.setText(""+colNomAgence.getCellData(index));
     txtmdpAG.setText("");
    }
    
        private void afficherAgent() {
      List <AgentAerien> ls =ags.afficher();
      ls.forEach(e->oblist3.add(e));
      colnomAG.setCellValueFactory(new PropertyValueFactory<AgentAerien,String>("nom"));
        colprenomAG.setCellValueFactory(new PropertyValueFactory<AgentAerien, String>("prenom"));
         colemailAG.setCellValueFactory(new PropertyValueFactory<AgentAerien, String>("email"));
       colNomAgence.setCellValueFactory(new PropertyValueFactory<AgentAerien, String>("nomAgence"));
        tvAgent.setItems(oblist3);    
    }
    
    @FXML
    void supprimerAG(ActionEvent event) {
AgentAerien ag =  tvAgent.getSelectionModel().getSelectedItem();
ags.supprimer(ag.getId());
tvAgent.getItems().clear();
afficherAgent();
    }
    
    
    
     
     
   
   
   
   
   
   
   
   
   
   
   
   
   
 
    
  


  
    
    
    
}
