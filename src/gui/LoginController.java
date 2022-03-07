/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.AgentAerienService;
import services.ClientService;
import services.OffreurService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable {

  
    @FXML
    private TextField txtnom;

    @FXML
    private PasswordField txtmdp;

    @FXML
    private Button btncnx;
    
        @FXML
    private ComboBox combo;
            @FXML
    private Hyperlink linkmdpoublie;
            
                @FXML
    private Hyperlink linkcreerCompte;

    @FXML
    void creernvCompte(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NvCompte.fxml"));
  Stage stage = new Stage();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
            
             @FXML
    void mdpoublie(ActionEvent event) throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("mdpoub.fxml"));
  Stage stage = new Stage();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException  {
String nom = txtnom.getText();
String mdp = txtmdp.getText();
ClientService cs = new ClientService();
AgentAerienService as= new AgentAerienService();
        OffreurService os= new OffreurService();
if(nom.equals("") && mdp.equals("")||nom.equals("")||mdp.equals(""))
{
    JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs vides");
}
else {
    try {
        Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/getaway", "root", "");
        if(combo.getSelectionModel().getSelectedItem().toString()=="Admin"){
         String sql="select * from admin where nom=? and password=?";
PreparedStatement pste=conn.prepareStatement(sql);
pste.setString(1,nom);
pste.setString(2,mdp);
 ResultSet rs = pste.executeQuery();
   if(rs.next()){
                JOptionPane.showMessageDialog(null, "admin and password matched");
                 txtnom.setText("");
                     txtmdp.setText("");
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
  
        
                
               
            }else{
                    JOptionPane.showMessageDialog(null, "admin and password donot matched");
                    txtnom.setText("");
                     txtmdp.setText("");
                    }
    }else if(combo.getSelectionModel().getSelectedItem().toString()=="Client"){
        
         String sql="select * from client where nom=? and password=?";
PreparedStatement pste=conn.prepareStatement(sql);
pste.setString(1,nom);
pste.setString(2,mdp);
 ResultSet rs = pste.executeQuery();
   if(rs.next()){
       if(rs.getInt("etat")==0){
          JOptionPane.showMessageDialog(null, "vous etes bloqué");
          txtnom.setText("");
          txtmdp.setText("");}
       else{
                JOptionPane.showMessageDialog(null, "client and password matched");
//                txtnom.setText("");
//                     txtmdp.setText("");
                     
                      try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCompteClient.fxml"));
		Parent root = loader.load();
		ModifierCompteClientController  e = loader.getController();
                int i=cs.selectidC(txtnom.getText(),txtmdp.getText());
                e.setIdc(i);
              
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}
//                        Stage stage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
//        Scene scene =new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//        rs.getInt("id");
       }      
            }else{
                    JOptionPane.showMessageDialog(null, "client and password donot matched");
                    txtnom.setText("");
                     txtmdp.setText("");
                    }
    }else if(combo.getSelectionModel().getSelectedItem().toString()=="Offreur"){
         String sql="select * from offreur where nom=? and password=?";
PreparedStatement pste=conn.prepareStatement(sql);
pste.setString(1,nom);
pste.setString(2,mdp);
 ResultSet rs = pste.executeQuery();
   if(rs.next()){
                JOptionPane.showMessageDialog(null, "Offreur and password matched");
//                 txtnom.setText("");
//                     txtmdp.setText("");
     try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCompteOffreur.fxml"));
		Parent root = loader.load();
		ModifierCompteOffreurController  e = loader.getController();
                int i=os.selectidO(txtnom.getText(),txtmdp.getText());
                e.setIdc(i);
              
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}
               
            }else{
                    JOptionPane.showMessageDialog(null, "Offreur and password donot matched");
                    txtnom.setText("");
                     txtmdp.setText("");
                    }
    }else if(combo.getSelectionModel().getSelectedItem().toString()=="Agent-Aerien"){
         String sql="select * from `agent-aerien` where nom=? and password=?";
PreparedStatement pste=conn.prepareStatement(sql);
pste.setString(1,nom);
pste.setString(2,mdp);
 ResultSet rs = pste.executeQuery();
   if(rs.next()){
                JOptionPane.showMessageDialog(null, "agent-aerien and password matched");
//                 txtnom.setText("");
//                     txtmdp.setText("");
                    try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCompteAgent.fxml"));
		Parent root = loader.load();
		ModifierCompteAgentController  e = loader.getController();
                int i=as.selectidA(txtnom.getText(),txtmdp.getText());
                e.setIdc(i);
              
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}
            }else{
                    JOptionPane.showMessageDialog(null, "agent-aerien and password donot matched");
                    txtnom.setText("");
                     txtmdp.setText("");
                    }
    }
         
         
         
         
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
           



}
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Admin","Client","Offreur","Agent-Aerien");
        combo.setItems(list);
    
    }
//
//public int getIdClientConn()
//{
//
//}
    
    
}
