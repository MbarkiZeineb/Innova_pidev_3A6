/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import getaway.entities.Avion;
import getaway.entities.Vol;
import getaway.services.AvionService;
import getaway.services.VolService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
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
   
    //tabVol

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
    private ComboBox<String> id_avion;
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
    private TextField id_rech;
    @FXML
    private Button supp;
    @FXML
    private Button modifier;
    @FXML
    private Button r_id;
    @FXML
    private Button stat;
   
    
    //tabavion
    @FXML
    private Button id_button1;

    @FXML
    private TextField nom_avion;

    @FXML
    private TextField nbr_place;

    @FXML
    private TableView<Avion> tb_a;

    @FXML
    private TableColumn<Vol, String> tb_nomavion;

    @FXML
    private TableColumn<Vol, Integer> tb_nbrplace;

    @FXML
    private TextField id_rech1;

    @FXML
    private Button supp1;

    @FXML
    private Button modifier1;

    @FXML
    private Button r_id1;

    @FXML
    private ComboBox<String> id_agence;
   
    
    int index= -1;
  ObservableList<Vol> oblist = FXCollections.observableArrayList();
    ObservableList<Avion> oblist1 = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      afficher1();
     afficher();
     getidagence();
     getida();
     Vol v = tb_v.getSelectionModel().getSelectedItem();
    }    
    
    //****************************************tabVol******************************************************
    public void getida()
    {
        
        String req ="SELECT id_avion from avion";
         try {
            Connection conn = getConnection();
             Statement ste;
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
        
            id_avion.getItems().addAll(rs.getString("id_avion"));
            }}
         catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
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
        
//         List<Timestamp> listDateDepart = ps.getListDateDepartByIdAvion( p.getId_avion(), p.getDate_depart());
//         List<Timestamp> listDateArrive= ps.getListDateArriveByIdAvion( p.getId_avion(), p.getDate_arrivee());
//        boolean volIsPresent= ps.checkVolIsBetweenDateDepartAndArriveIsPossible(listDateArrive, listDateDepart,p.getDate_arrivee(), p.getDate_depart()) ;
//         if(volIsPresent==true) {
//             Alert alert = new Alert(AlertType.WARNING);
//        
//        alert.setTitle("information");
//        alert.setHeaderText(null);
//        alert.setContentText("vol existe déjà!");
//        alert.showAndWait();
         
             //Notifications.create().title("Vol").text(" Vol existe déjà ").show();}
//         System.out.println("vol existe déjà");}
//         else {
       if(isEmpty())
       {return;
        } else {
        p.setDate_depart(Timestamp.valueOf(date_depart.getText()));
        p.setDate_arrivee(Timestamp.valueOf(date_arrivee.getText()));
        p.setPrix(Float.parseFloat(prix.getText()));
        p.setVille_depart(ville_depart.getText());
        p.setVille_arrivee(ville_arrivee.getText());
        p.setId_avion(Integer.parseInt(id_avion.getValue()));
        p.setNbr_placedispo(Integer.parseInt(nbr_placedispo.getText()));
       ps.ajouter(p);
       //System.out.println("ajout avec succés");
       //Notifications.create().title("Vol").text(" Vol est Créé ").show();
         
       //tb_v.getItems().clear();
       afficher();
//       Alert alert = new Alert(AlertType.INFORMATION);
//        
//    alert.setTitle("information");
//    alert.setHeaderText(null);
//    alert.setContentText("ajout avec succes!");
//    alert.showAndWait();
    }  }
       

    
    @FXML
    private void supprimer(ActionEvent event) {
        
       
      Vol r=  tb_v.getSelectionModel().getSelectedItem();
      VolService vs = new VolService();
      vs.supprimer(r);
      tb_v.getItems().clear();
       afficher();
       Alert alert = new Alert(AlertType.INFORMATION);
        
alert.setTitle("intformation");
alert.setHeaderText(null);
alert.setContentText("suppression avec succes!");
alert.showAndWait();
        
        
        
    }
    
    

    @FXML
    private void modifier(ActionEvent event) {
         Vol p=  tb_v.getSelectionModel().getSelectedItem();
      VolService vs = new VolService();
       p.setDate_depart(Timestamp.valueOf(date_depart.getText()));
        p.setDate_arrivee(Timestamp.valueOf(date_arrivee.getText()));
        p.setPrix(Float.parseFloat(prix.getText()));
        p.setVille_depart(ville_depart.getText());
        p.setVille_arrivee(ville_arrivee.getText());
        //p.setId_avion(Integer.parseInt(id_avion.getValue()));
        p.setNbr_placedispo(Integer.parseInt(nbr_placedispo.getText()));
        p.toString();
       
      vs.modifier(p);
      
    tb_v.getItems().clear();
    afficher();
    Alert alert = new Alert(AlertType.INFORMATION);
        
alert.setTitle("intformation");
alert.setHeaderText(null);
alert.setContentText("modification avec succes!");
alert.showAndWait();
        
       
    }
    


    
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



    @FXML
    private void recherche(ActionEvent event) {
         VolService ps = new VolService();
        ResultSet resultset=ps.getall();
        
        ObservableList<Vol> listvol = FXCollections.observableArrayList(ps.findVolParDest((id_rech.getText())));
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
    nbr_placedispo.clear();
    tb_v.getItems().clear();
    afficher();
  
    }
    
     private void warning(String txt) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        Optional<ButtonType> action = alert.showAndWait();
    }

     private boolean isEmpty() {
        
        if (date_depart.getText() == null || date_depart.getText().trim().isEmpty()) {
            warning("Veuillez saisir la date de départ!");
            return true;
        }
        else if (date_arrivee.getText() == null || date_arrivee.getText().trim().isEmpty()) {
            warning("Veuillez saisir la description de la date d'arrivee!");
        }
        else if (prix.getText() == null || prix.getText().trim().isEmpty()) {
            warning("Veuillez saisir le prix du vol!");
            return true;
        }
        else if (ville_depart.getText() == null || ville_depart.getText().trim().isEmpty()) {
            warning("Veuillez saisir la ville de depart!");
            return true;
        }
        
        else if (ville_arrivee.getText() == null || ville_arrivee.getText().trim().isEmpty()) {
            warning("Veuillez saisir la ville d'arrivee!");
            return true;
        }else if (id_avion.getValue() == null ||id_avion.getValue().trim().isEmpty()) {
            warning("Veuillez saisir l'id de l'avion!");
            return true;
        }
        else if (nbr_placedispo.getText() == null || nbr_placedispo.getText().trim().isEmpty()) {
            warning("Veuillez saisir le nombre de place !");
            return true;
        }
 
        else return false;
        return false;
        
    }
     
        //****************************************tabavion******************************************************

    public void afficher1()
    {
         AvionService as = new AvionService();
        List<Avion> ls = as.afficher();
         ls.forEach(e->oblist1.add(e));
          System.out.print(oblist1);
        tb_nomavion.setCellValueFactory(new PropertyValueFactory<>("nom_avion"));
        tb_nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbr_place"));
        tb_a.setItems(oblist1);
      
       
    }   
    
     public void getidagence()
    {
        
        String req ="SELECT id FROM `agent-aerien` ";
         try {
            Connection conn = getConnection();
             Statement ste;
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
        
            id_agence.getItems().addAll(rs.getString("id"));
            }}
         catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
     
     @FXML
    void ajouter1(ActionEvent event)  {
        AvionService as = new AvionService();
        Avion p =new Avion();
       
       if(isEmpty1())
       {return;
        } else {
        p.setNom_avion(nom_avion.getText());
        p.setId_agence(Integer.parseInt(id_agence.getValue()));
        p.setNbr_place(Integer.parseInt(nbr_place.getText()));
       as.ajouter(p);
         
       //tb_v.getItems().clear();
       afficher1();
       Alert alert = new Alert(AlertType.INFORMATION);
        
    alert.setTitle("information");
    alert.setHeaderText(null);
    alert.setContentText("ajout avec succes!");
    alert.showAndWait();
    }  }
    
    
     

     private boolean isEmpty1() {
        
        if (nom_avion.getText() == null || nom_avion.getText().trim().isEmpty()) {
            warning("Veuillez saisir le nom de l'avion!");
            return true;
        }
        else if (id_agence.getValue() == null ||id_agence.getValue().trim().isEmpty()) {
            warning("Veuillez saisir l'id de l'agence!");
        }
        else if (nbr_place.getText() == null || nbr_place.getText().trim().isEmpty()) {
            warning("Veuillez saisir le nombre de place!");
            return true;
        
        }
 
        else return false;
        return false;
        
    }
     
     @FXML
    private void supprimer1(ActionEvent event) {
        
       
      Avion r=  tb_a.getSelectionModel().getSelectedItem();
      AvionService as = new AvionService();
      as.supprimer(r);
      tb_a.getItems().clear();
       afficher1();
       Alert alert = new Alert(AlertType.INFORMATION);
        
alert.setTitle("intformation");
alert.setHeaderText(null);
alert.setContentText("suppression avec succes!");
alert.showAndWait();
        
        
        
    }
    
    

    @FXML
    private void modifier1(ActionEvent event) {
         Avion p=  tb_a.getSelectionModel().getSelectedItem();
      AvionService vs = new AvionService();
        p.setNom_avion(nom_avion.getText());
        p.setNbr_place(Integer.parseInt(nbr_place.getText()));
        p.toString();
       
      vs.modifier(p);
      
    tb_a.getItems().clear();
    afficher1();
    Alert alert = new Alert(AlertType.INFORMATION);
        
alert.setTitle("intformation");
alert.setHeaderText(null);
alert.setContentText("modification avec succes!");
alert.showAndWait();
        
       
    }
    
     @FXML
    private void recherche1(ActionEvent event) {
         AvionService ps = new AvionService();
        ResultSet resultset=ps.getall();
        
        ObservableList<Avion> listavion = FXCollections.observableArrayList(ps.findAvionParnom((id_rech1.getText())));
//        tb_id.setCellValueFactory(new PropertyValueFactory<>("id"));
       
        tb_nomavion.setCellValueFactory(new PropertyValueFactory<>("nom_avion"));
        tb_nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbr_place"));
        tb_a.setItems(listavion);
    }   

    

    @FXML
    private void trier1(ActionEvent event) {
        AvionService ps = new AvionService();
        ResultSet resultset=ps.tri_avion();
        List<Avion> pl = new ArrayList<Avion>();
        try {
            while(resultset.next()){
                Avion p1 = new Avion();
                p1.setNom_avion(resultset.getString("nom_avion"));
                p1.setNbr_place(resultset.getInt("nbr_place"));
               
                pl.add(p1);
                
               
                }
            ObservableList<Avion> listavion = FXCollections.observableArrayList(pl);
//        tb_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_datedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tb_datearrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
      
        tb_a.setItems(listavion);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterVolController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @FXML
    private void selectAVION(javafx.scene.input.MouseEvent event) {
        
        index = tb_a.getSelectionModel().getSelectedIndex();
         
         
          
    nom_avion.setText(tb_nomavion.getCellData(index));
     nbr_place.setText(""+tb_nbrplace.getCellData(index));
         
    }
    
     @FXML
    private void viderAvion(javafx.scene.input.MouseEvent event) {
        
      
           
   nom_avion.clear();
    nbr_place.clear();
    afficher();
  
    }
     
     
     
    }