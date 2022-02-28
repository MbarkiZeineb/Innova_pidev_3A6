/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import getaway.entities.Avion;
import getaway.entities.Vol;
import getaway.services.VolService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;



/**
 * FXML Controller class
 *
 * @author challakh
 */
public class AjouterVolController implements Initializable {
   

    @FXML
    private Button id_button;
    @FXML
    private TextField date_depart;
    @FXML
    private TextField date_arrivee;
    @FXML
    private TextField prix;
    @FXML
    private TextField ville_depart;
    @FXML
    private TextField ville_arrivee;
    @FXML
    private TextField id_avion;
     @FXML
    private TextField nbr_placedispo;
      
    @FXML
    private TableView<Vol> tb_v;
    @FXML
    private TableColumn<Vol, Integer> tb_id;
    @FXML
    private TableColumn<Vol, Timestamp> tb_datedepart;
    @FXML
    private TableColumn<Vol, Timestamp> tb_datearrivee;
    @FXML
    private TableColumn<Vol, Float> tb_prix;
    @FXML
    private TableColumn<Vol, String> tb_villedepart;
    @FXML
    private TableColumn<Vol, String> tb_villearrivee;
    
     @FXML
    private TableColumn<Vol, Integer> tb_place;
    @FXML
    private TextField id_supp;
    @FXML
    private Button supp;
    @FXML
    private Button modifier;
    @FXML
    private Button r_id;
    @FXML
    private Button stat;
    
    int index= -1;
  ObservableList<Vol> oblist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     afficher();
     Vol v = tb_v.getSelectionModel().getSelectedItem();
    }    
    
    
    public void afficher()
    {
         VolService vs = new VolService();
        List<Vol> ls = vs.afficher();
          ls.forEach(e->oblist.add(e));
          System.out.print(oblist);
        tb_datedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tb_datearrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        tb_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tb_villedepart.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
        tb_villearrivee.setCellValueFactory(new PropertyValueFactory<>("ville_arrivee"));
        //tb_avion.setCellValueFactory(new PropertyValueFactory<>("id_avion"));
        tb_place.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
        tb_v.setItems(oblist);
      
       
    }   

   @FXML
    void ajouter(ActionEvent event) throws Exception {
       VolService ps= new VolService();
        Vol p =new Vol();
        // Vol v = tb_v.getSelectionModel().getSelectedItem();
        //p.setId(Integer.parseInt(id.getText()) );
       
        p.setDate_depart(Timestamp.valueOf(date_depart.getText()));
        p.setDate_arrivee(Timestamp.valueOf(date_arrivee.getText()));
        p.setPrix(Float.parseFloat(prix.getText()));
        p.setVille_depart(ville_depart.getText());
        p.setVille_arrivee(ville_arrivee.getText());
        p.setId_avion(Integer.parseInt(id_avion.getText()));
        p.setNbr_placedispo(Integer.parseInt(nbr_placedispo.getText()));
       ps.ajouter(p);
       System.out.println("ajout avec succés");
       //Notifications.create().title("Vol").text(" Vol est Créé ").show();
       tb_v.refresh();
       afficher();
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        
       
      Vol r=  tb_v.getSelectionModel().getSelectedItem();
      VolService vs = new VolService();
      vs.supprimer(r);
        
        
        
    }

    @FXML
    private void modifier(MouseEvent event) {
         Vol r=  tb_v.getSelectionModel().getSelectedItem();
      VolService vs = new VolService();
      vs.modifier(r);
        
       
    }
    

// private void handleButtonAction(ActionEvent event) throws IOException, SQLException, Exception {
//        
//         if(event.getSource() == supp){
//            supprimer();
//        }
//        else if(event.getSource() == modifier){
//            modifier();
//        }
//        
//    }

    
     public Connection getConnection(){
    Connection conn;
    try{
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/getaway","root","");
        return conn;
    }
    catch(SQLException ex){
        System.out.println("Erreur : " + ex.getMessage());
        return null;
    }
    }
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch(SQLException ex){
        }
        
    }

//    @FXML
//    private void modifier(ActionEvent event) {
//        VolService ps= new VolService();
//        Vol p =new Vol();
//        p.setDate_depart(date_depart.getText());
//        p.setGenre(genre.getText());
//        p.setAge_recommande(Integer.parseInt(age.getText()) );
//        p.setDuree(duree.getText());
//     
//       ps.modifier(p);
//       System.out.println("projection modifier avec succés");
//       afficher();
//    }
//    @FXML
//    private void modifier(){
//    String query = "UPDATE vol SET date_depart = '" + date_depart.getText() + "' , date_arrivee = '" + date_arrivee.getText()+
//                "', prix = '" + prix.getText() +"', ville_depart = '" + ville_depart.getText()+"', ville_arrivee = '" + ville_arrivee.getText()+
//                "', nbr_placedispo = '" + nbr_placedispo.getText() + "' WHERE id_vol = " + id_vol.getText() +"" ;
//            
//    executeQuery(query);
//    afficher();
//    }

    @FXML
    private void recherche(ActionEvent event) {
         VolService ps = new VolService();
        ResultSet resultset=ps.getall();
        
        ObservableList<Vol> listvol = FXCollections.observableArrayList(ps.findVolParDest((id_supp.getText())));
//        tb_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_datedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tb_datearrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        tb_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tb_villedepart.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
        tb_villearrivee.setCellValueFactory(new PropertyValueFactory<>("ville_arrivee"));
        //tb_avion.setCellValueFactory(new PropertyValueFactory<>("id_avion"));
        tb_place.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
        tb_v.setItems(listvol);
    }   

    

    @FXML
    private void trier(ActionEvent event) {
        VolService ps = new VolService();
        ResultSet resultset=ps.tri_vol();
        List<Vol> pl = new ArrayList<Vol>();
        try {
            while(resultset.next()){
                Vol p1 = new Vol();
                p1.setDate_depart(resultset.getTimestamp("date_depart"));
                p1.setDate_arrivee(resultset.getTimestamp("date_arrivee"));
                p1.setPrix(resultset.getFloat("prix"));
                p1.setVille_depart(resultset.getString("ville_depart"));
                p1.setVille_arrivee(resultset.getString("ville_arrivee"));
                p1.setId_avion(resultset.getInt("id_avion"));
                p1.setNbr_placedispo(resultset.getInt("nbr_placedispo"));
               
                pl.add(p1);
                
               
                }
            ObservableList<Vol> listvol = FXCollections.observableArrayList(pl);
//        tb_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_datedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tb_datearrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        tb_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tb_villedepart.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
        tb_villearrivee.setCellValueFactory(new PropertyValueFactory<>("ville_arrivee"));
        //tb_avion.setCellValueFactory(new PropertyValueFactory<>("id_avion"));
        tb_place.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
      
        tb_v.setItems(listvol);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterVolController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @FXML
    private void statistique(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Stat.fxml"));
                       Parent root ;
        try {
            root=loader.load();
             stat.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GUI.StatController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    @FXML
    private void selectVOL(javafx.scene.input.MouseEvent event) {
        
        index = tb_v.getSelectionModel().getSelectedIndex();
         
         
          
    ville_depart.setText(tb_villedepart.getCellData(index));
    ville_arrivee.setText(tb_villearrivee.getCellData(index));
    date_depart.setText(""+ tb_datedepart.getCellData(index));
     date_arrivee.setText(""+ tb_datearrivee.getCellData(index));
     prix.setText(""+ tb_prix.getCellData(index));
     nbr_placedispo.setText(""+tb_place.getCellData(index));
         
    }
    
     @FXML
    private void viderVol(javafx.scene.input.MouseEvent event) {
        
      
           
   ville_depart.clear();
    ville_arrivee.clear();
  date_depart.clear();
    date_arrivee.clear();
    prix.clear();
    id_avion.clear();
    nbr_placedispo.clear();
    tb_v.getItems().clear();
    afficher();
  
    }

    
    }