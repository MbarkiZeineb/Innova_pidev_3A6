/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Admin;
import entities.Client;
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
import services.AdminService;
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
    void ajouter(ActionEvent event) {
ajout();
    }

    @FXML
    void modifier(ActionEvent event) {
modifier();
    }

    @FXML
    void supprimer(ActionEvent event) {
supprimer();
    }
      @FXML
    void rechercher(ActionEvent event) {
showAdminrech();
    }
   ObservableList<Client> oblist = FXCollections.observableArrayList();
     ClientService cs= new ClientService();
   @FXML
    void ajouterC(ActionEvent event) {
         Client c= new Client(txtnomC.getText(), txtprenomC.getText(), txtmdpC.getText(), txtemailC.getText());
cs.ajouter(c);
tvClient.getItems().clear();
afficherClient();

    }

    @FXML
    void modifierC(ActionEvent event) {
        Client c =  tvClient.getSelectionModel().getSelectedItem();
        System.out.println("ugbvhfvifctuyvr-tv");
        System.out.println(txtnomC.getText());
        c.setEmail(txtemailC.getText());
        c.setNom( txtnomC.getText());
        c.setPrenom(txtprenomC.getText());
        c.toString();
       
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

    }

    //client
     
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
      
   
         
    }
      
    
    
    
    
    
    
    //admin
      public ObservableList<Admin> getadminList(){
        ObservableList<Admin> admins = FXCollections.observableArrayList();
        conn = Connexion.getInstance().getCnx();
        String req = "select * from admin";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(req);
            Admin admin;
            
            while(rs.next()){
                admin = new Admin(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("adresse"),rs.getString("password")); // depuis bd //
              admins.add(admin);
                
               
                
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return admins;
        
    }
        public void showAdmin(){
        ObservableList<Admin> list = getadminList();   
        
        colnom.setCellValueFactory(new PropertyValueFactory<Admin,String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Admin, String>("prenom"));
         coladr.setCellValueFactory(new PropertyValueFactory<Admin, String>("adresse"));
        colemail.setCellValueFactory(new PropertyValueFactory<Admin, String>("email"));
      
        tvadmin.setItems(list);
       

    }
         public ObservableList<Admin> getListrech(String nom){
        ObservableList<Admin> admins = FXCollections.observableArrayList();
        conn = Connexion.getInstance().getCnx();
        String req = "select * from admin where nom='"+nom+"';";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(req);
            Admin admin;
            
            while(rs.next()){
                admin = new Admin(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("adresse"),rs.getString("password")); // depuis bd //
              admins.add(admin);
                
               
                
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return admins;
        
    }
    public void showAdminrech(){
        ObservableList<Admin> list = getListrech(txtrech.getText());   
        
        colnom.setCellValueFactory(new PropertyValueFactory<Admin,String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Admin, String>("prenom"));
         coladr.setCellValueFactory(new PropertyValueFactory<Admin, String>("adresse"));
        colemail.setCellValueFactory(new PropertyValueFactory<Admin, String>("email"));
      
        tvadmin.setItems(list);
       

    }
        
             private void ajout(){
      conn = Connexion.getInstance().getCnx();
        PreparedStatement stm;
        try{
            
            
         
            stm = conn.prepareStatement("INSERT INTO `admin` (`nom`,`prenom`,`email`,`adresse`,`password`)values(?,?,?,?,?)");
            
          
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
              
             else if  (txtmdp.getText().length()<8||(txtmdp.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "votre mdp doit contenir au moins 8 characteres");
             }
            else{
            stm.setString(1, txtnom.getText());
            stm.setString(2, txtprenom.getText());
            stm.setString(4, txtadr.getText());
          stm.setString(3, txtemail.getText());
           stm.setString(5, txtmdp.getText());
int i = stm.executeUpdate();
            System.out.println(i);
       
 
             }

            
            

        }catch (Exception e){
            e.printStackTrace();
        }
       showAdmin();
       
    }
    private void supprimer() {
        conn = Connexion.getInstance().getCnx();
        PreparedStatement stm;

       try {
           stm=conn.prepareStatement("delete from admin where nom=?");
           stm.setString(1, txtnom.getText());
           
           int i=stm.executeUpdate();
           
       }catch (Exception e){
           e.printStackTrace();
       }
       showAdmin();
    }
        
         
        private void modifier() {
         conn = Connexion.getInstance().getCnx();
        PreparedStatement stm;

        try {
            stm = conn.prepareStatement("UPDATE admin SET prenom=?,email=?,adresse=?,password=? WHERE nom=?");
               stm.setString(5, txtnom.getText());
            stm.setString(1, txtprenom.getText());
            stm.setString(3, txtadr.getText());
          stm.setString(2, txtemail.getText());
           stm.setString(4, txtmdp.getText());
              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
        showAdmin();
    }
    
    
  


    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        showAdmin();
        afficherClient();
    }   

    public RegistrationController() {
        
         conn = Connexion.getInstance().getCnx();
    }
    
    
    
}
