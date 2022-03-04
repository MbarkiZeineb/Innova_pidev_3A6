/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import com.itextpdf.text.Chunk;
import getaway.entities.Avion;
import getaway.entities.Vol;
import getaway.services.AvionService;
import getaway.services.VolService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import java.util.stream.IntStream;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.scene.input.KeyEvent;


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
    private TableColumn<Vol, String> tb_nomagence;
    
     @FXML
    private TableColumn<Vol, Integer> tb_place;
    @FXML
    private TextField id_rech;
    @FXML
    private TextField id_arrivee;
    @FXML
    private TextField id_depart;
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
   
    ObservableList<Vol> listM;
    ObservableList<Vol> dataList;
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
    // supp1.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
    // supp.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
    //     modifier1.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
    // modifier.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
    //     id_button1.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
      //   id_button.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
     //r_id1.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
     //r_id.disableProperty().bind(Bindings.isEmpty(tb_a.getSelectionModel().getSelectedItems()));
     
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
        tb_nomavion.setCellValueFactory(new PropertyValueFactory<>("nom_avion"));
        tb_v.setItems(oblist);
        
      
       
    }   
   

   @FXML
    void ajouter(ActionEvent event) throws Exception {
       VolService ps= new VolService();
        Vol p =new Vol();
         Vol v = tb_v.getSelectionModel().getSelectedItem();
         
       if(isEmpty())
       {return;
        } else {
       // p.setId(Integer.parseInt(id.getText()) );
          p.setDate_depart(Timestamp.valueOf(date_depart.getText()));
        p.setDate_arrivee(Timestamp.valueOf(date_arrivee.getText()));
        p.setPrix(Float.parseFloat(prix.getText()));
        p.setVille_depart(ville_depart.getText());
        p.setVille_arrivee(ville_arrivee.getText());
        p.setId_avion(Integer.parseInt(id_avion.getValue()));
        p.setNbr_placedispo(Integer.parseInt(nbr_placedispo.getText()));
         List<Timestamp> listDateDepart = ps.getListDateDepartByIdAvion( p.getId_avion(), p.getDate_depart());
         List<Timestamp> listDateArrive= ps.getListDateArriveByIdAvion( p.getId_avion(), p.getDate_arrivee());
        boolean volIsPresent= ps.checkVolIsBetweenDateDepartAndArriveIsPossible(listDateArrive, listDateDepart,p.getDate_arrivee(), p.getDate_depart()) ;
         if(volIsPresent==true) {
             System.out.println("vol existe déjà");
             Alert alert = new Alert(AlertType.WARNING);
        
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("vol existe déjà!");
        alert.showAndWait();
//             }
         System.out.println("vol existe déjà");
         }
         else {
       
      
       ps.ajouter(p);
       tb_v.getItems().clear();
       afficher();
       //System.out.println("ajout avec succés");
       //Notifications.create().title("Vol").text(" Vol est Créé ").show();
         
       //tb_v.getItems().clear();
       
       
       Alert alert = new Alert(AlertType.INFORMATION);
        
    alert.setTitle("information");
    alert.setHeaderText(null);
    alert.setContentText("ajout avec succes!");
    alert.showAndWait();
    } }
       }
    
       

    
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


           VolService as = new VolService();
         Vol a=new Vol ();
        
        ObservableList<Vol> Vol = as.rechercherVol(id_rech.getText());
        ObservableList<Vol> listvol = FXCollections.observableArrayList(as.findVolParDest((id_arrivee.getText())));
        ObservableList<Vol> listvol1 = FXCollections.observableArrayList(as.findVolPardepart((id_arrivee.getText())));
       
        tb_datedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tb_datearrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        tb_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tb_villedepart.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
        tb_villearrivee.setCellValueFactory(new PropertyValueFactory<>("ville_arrivee"));
        tb_place.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));

        tb_v.setItems(Vol);

    }   
    
//    @FXML
//    private void recherche2() {
//        String req ="SELECT ville_depart from vol";
//         try {
//            Connection conn = getConnection();
//             Statement ste;
//            ste = conn.createStatement();
//            ResultSet rs = ste.executeQuery(req);
//            Vol p =new Vol();
//             List<Vol> Vols = new ArrayList<>();
//            while(rs.next()){
//                
////                Timestamp querydated=rs.getTimestamp("date_depart");
////                Timestamp querydatea=rs.getTimestamp("date_arrivee");
//             String queryvilled=rs.getString("ville_depart");
////                String queryvillea=rs.getString("ville_arrivee");
////                Integer queryplace=rs.getInt("nbr_placedispo");
//               // Float queryprix=rs.getFloat("prix");
////                oblist.add(new Vol(querydated,querydatea,queryvilled,queryvillea,queryplace,queryprix));
//                oblist.add(new Vol(queryvilled));
//                
//                tb_datedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
//                tb_datearrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
//                tb_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
//                tb_villedepart.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
//                tb_villearrivee.setCellValueFactory(new PropertyValueFactory<>("ville_arrivee"));
//                tb_place.setCellValueFactory(new PropertyValueFactory<>("nbr_placedispo"));
//
//                 tb_v.setItems(oblist);
//                 
//                 
//                 FilteredList<Vol> filteredData =new FilteredList<>(oblist,b->true);
//                 id_rech.textProperty().addListener(((observable,oldValue,newValue) -> {filteredData.setPredicate(oblist->
//                 {
//                     if (newValue.isEmpty() || newValue==null)
//                     {return true ;}
//                     String searchKeyword = newValue.toLowerCase();
//                     if(p.getVille_depart().toLowerCase().indexOf(searchKeyword)!=-1)
//                     {return true;}
////                     else if(p.getVille_arrivee().toLowerCase().indexOf(searchKeyword)!=-1)
////                     {return true;}
////                      else if(String.valueOf(p.getNbr_placedispo()).toLowerCase().indexOf(searchKeyword)!=-1)
////                     {return true;}
////                      else if(String.valueOf(p.getPrix()).toLowerCase().indexOf(searchKeyword)!=-1)
////                     {return true;}
////                       else if(String.valueOf(p.getDate_depart()).toLowerCase().indexOf(searchKeyword)!=-1)
////                     {return true;}
////                        else if(String.valueOf(p.getDate_arrivee()).toLowerCase().indexOf(searchKeyword)!=-1)
////                     {return true;}
//                     else 
//                         return false;
//                 
//                 
//                 });
//                 }));
//                
//            }}
//         catch (SQLException ex) {
//            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        
   
    

    

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
    private void selectP(MouseEvent event) {
             
      Avion r=  tb_a.getSelectionModel().getSelectedItem();
      VolService vs= new VolService();
      
    
     try{
         
       tb_a.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->
     {
      
        Vol v = vs.afficher().stream().filter(e->e.getId_avion()==newSelection.getId_avion()).findFirst().get();
        
       
   int a=  IntStream.range(0,tb_v.getItems().size())
     .filter(i -> tb_v.getItems().get(i).getId_avion()==v.getId_avion()).findFirst().getAsInt();
   
    tb_v.getSelectionModel().select(a);
    
     });
       
     }catch(Exception e)
     {
         
         System.out.println(e);
         
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
     
      
    @FXML
    private void telechargerVol() throws IOException,FileNotFoundException, SQLException {
   
        try {
            String file_name="C:\\Users\\Malek\\Desktop\\Gestion_Vol.pdf";
            Document document = new Document();
                
           
            PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(file_name));
           
            document.open();
            document.add(new Chunk(""));
            Connection conn = getConnection();
            
            String query = "SELECT * from vol";
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(query);

            PdfPTable t = new PdfPTable(6);
            PdfPCell c1 = new PdfPCell(new Phrase("date_depart"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("date_arrivee"));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("ville_depart"));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("ville_arrivee"));
            t.addCell(c4);
              PdfPCell c5 = new PdfPCell(new Phrase("prix"));
            t.addCell(c5);
              PdfPCell c6 = new PdfPCell(new Phrase("nbr_placedispo"));
            t.addCell(c6);
           
             
            t.setHeaderRows(6);
            while(rs.next()){
                t.addCell(rs.getString(1));
                t.addCell(rs.getString(2));
                t.addCell(rs.getString(3));
                t.addCell(rs.getString(4));
                t.addCell(rs.getString(5));
                t.addCell(rs.getString(6));
                 
                document.add(t);
            }
            document.close();
            System.out.println("finished");
        } catch (DocumentException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null,"PDF téléchargé ");

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
         
       tb_a.getItems().clear();
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
        
       //Vol v = new Vol();
       Avion a = new Avion();
       
      Avion r=  tb_a.getSelectionModel().getSelectedItem();
      AvionService as = new AvionService();
     
      as.supprimer(r);
      tb_a.getItems().clear();
      tb_v.getItems().clear();
       afficher1();
//       Alert alert = new Alert(AlertType.INFORMATION);
//        
//alert.setTitle("intformation");
//alert.setHeaderText(null);
//alert.setContentText("suppression avec succes!");
//alert.showAndWait();
//      
        
        
        
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