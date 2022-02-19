/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getaway.services;
import getaway.entities.Vol;
import getaway.utilis.Datasource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malek
 */
public class VolService implements IService<Vol> {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public VolService() {
        conn = Datasource.getInstance().getCnx();
    }

    @Override
    public void ajouter(Vol V) {
        
        
         String req = "INSERT INTO `vol` (`date_depart`,`date_arrivee`,`heure_decollage`,`heure_arrivee`,`destination`,`nbr_placedispo`,`id_avion`,`prix`) VALUE (?,?,?,?,?,?,?,?) ";
         
         try {
            pste = conn.prepareStatement(req);
            pste.setDate(1, V.getDate_depart());
            pste.setDate(2, V.getDate_arrivee());
            pste.setTime(3, V.getHeure_decollage());
            pste.setTime(4,V.getHeure_arrivee());
            pste.setString(5, V.getDestination());
            pste.setInt(6, V.getNbr_placedispo());
            pste.setInt(7, V.getId_avion());
            pste.setFloat(8, V.getPrix());
            
            
            pste.executeUpdate();
            System.out.println("vol créée");
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        }
    
    
    @Override
    public void modifier(Vol V) {
       String req = "UPDATE `vol` SET `date_depart`=?,`date_arrivee`=?,`heure_decollage`=?,`heure_arrivee`=?,`destination`=?,`nbr_placedispo`=?,`id_avion`=? ,`prix`=? WHERE  `vol`.`id_vol` = "+ V.getId_vol() + "";
    
        try {
            pste = conn.prepareStatement(req);

            pste.setDate(1, V.getDate_depart());
            pste.setDate(2, V.getDate_arrivee());
            pste.setTime(3, V.getHeure_decollage());
            pste.setTime(4,V.getHeure_arrivee());
            pste.setString(5, V.getDestination());
            pste.setInt(6, V.getNbr_placedispo());
            pste.setInt(7, V.getId_avion());
            pste.setFloat(8, V.getPrix());

            pste.executeUpdate();
            int rowsUpdated = pste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification du vol a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
    }
    
    @Override
    public void supprimer(Vol V) {
        try {
            String req = "DELETE FROM `vol` WHERE `vol`.`id_vol` =?";
            pste = conn.prepareStatement(req);
            pste.setInt(1,V.getId_vol());
            pste.executeUpdate();
            int rowsUpdated = pste.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("Vol supprimé");
            }

        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
//     @Override
//    public void modifier(Vol V,int id_vol) {
//      String req = "UPDATE `vol` SET `date_depart`=?,`date_arrivee`=?,`heure_decollage`=?,`heure_arrivee`=?,`destination`=?,`nbr_placedispo`=?,`id_avion`=? ,`prix`=? WHERE  `vol`.`id_vol` = "+ String.valueOf(id_vol) + "";
//    
//        try {
//            pste = conn.prepareStatement(req);
//
//            pste.setDate(1, V.getDate_depart());
//            pste.setDate(2, V.getDate_arrivee());
//            pste.setTime(3, V.getHeure_decollage());
//            pste.setTime(4,V.getHeure_arrivee());
//            pste.setString(5, V.getDestination());
//            pste.setInt(6, V.getNbr_placedispo());
//            pste.setInt(7, V.getId_avion());
//            pste.setFloat(8, V.getPrix());
//
//            pste.executeUpdate();
//            int rowsUpdated = pste.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("La modification du vol :" + String.valueOf(id_vol) + " a été éffectuée avec succès ");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      
//      
//      
//    }
//
// 
//     @Override
//    public void supprimer(int id_vol) {
//        try {
//            String req = "DELETE FROM `vol` WHERE `vol`.`id_vol` = " + String.valueOf(id_vol) + "";
//            pste = conn.prepareStatement(req);
//            pste.executeUpdate();
//            System.out.println("Vol supprimé");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    @Override
    public List<Vol> afficher() {
         List<Vol> Vols = new ArrayList<>();
        String req = "SELECT * FROM `vol`";
        
        try {
            
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Vol v = new Vol();
                v.setId_vol(rs.getInt("id_vol"));
                v.setDate_depart(rs.getDate("date_depart"));
                v.setDate_arrivee(rs.getDate("date_arrivee"));
                v.setHeure_decollage(rs.getTime("heure_decollage"));
                v.setHeure_arrivee(rs.getTime("heure_arrivee"));
                v.setDestination(rs.getString("destination"));
                v.setNbr_placedispo(rs.getInt("nbr_placedispo"));
                v.setId_avion(rs.getInt("id_avion"));
                v.setPrix(rs.getFloat("prix"));
                Vols.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Vols;
    }

    public List<Vol> findVolParDest(String destination) {
         List<Vol> Vols = new ArrayList<>();
        String req = "SELECT * FROM `vol` where `destination`= ? ";
        
        try {
            
            PreparedStatement preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1, destination);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Vol v = new Vol();
                v.setId_vol(rs.getInt("id_vol"));
                v.setDate_depart(rs.getDate("date_depart"));
                v.setDate_arrivee(rs.getDate("date_arrivee"));
                v.setHeure_decollage(rs.getTime("heure_decollage"));
                v.setHeure_arrivee(rs.getTime("heure_arrivee"));
                v.setDestination(rs.getString("destination"));
                v.setNbr_placedispo(rs.getInt("nbr_placedispo"));
                v.setId_avion(rs.getInt("id_avion"));
                v.setPrix(rs.getFloat("prix"));
                Vols.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Vols;
    }
    
    
    public Vol findVolParId(int id_vol) {

        String req = "SELECT * FROM `vol` WHERE `id_vol`= ? ";
        Vol v = new Vol();
        try {
            
            PreparedStatement preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, id_vol);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
                v.setId_vol(rs.getInt(1));
                v.setDate_depart(rs.getDate(2));
                v.setDate_arrivee(rs.getDate(3));
                v.setHeure_decollage(rs.getTime(4));
                v.setHeure_arrivee(rs.getTime(5));
                v.setDestination(rs.getString(6));
                v.setNbr_placedispo(rs.getInt(7));
                v.setId_avion(rs.getInt(8));
                v.setPrix(rs.getFloat(9));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return v;

    }
    public List<Vol> findVolParPrix(float prix) {
         List<Vol> Vols = new ArrayList<>();
        String req = "SELECT * FROM `vol` where `prix`= ? ";
        
        try {
            
            PreparedStatement preparedStatement = conn.prepareStatement(req);
            preparedStatement.setFloat(1, prix);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Vol v = new Vol();
                v.setId_vol(rs.getInt("id_vol"));
                v.setDate_depart(rs.getDate("date_depart"));
                v.setDate_arrivee(rs.getDate("date_arrivee"));
                v.setHeure_decollage(rs.getTime("heure_decollage"));
                v.setHeure_arrivee(rs.getTime("heure_arrivee"));
                v.setDestination(rs.getString("destination"));
                v.setNbr_placedispo(rs.getInt("nbr_placedispo"));
                v.setId_avion(rs.getInt("id_avion"));
                v.setPrix(rs.getFloat("prix"));
                Vols.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Vols;
    }
    
    public List<Vol> tri_vol() {
         
        List<Vol> Vols = new ArrayList<>();
         String req = "SELECT * FROM vol ORDER BY prix";
        
        try {
            
            
             ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Vol v = new Vol();
                v.setId_vol(rs.getInt("id_vol"));
                v.setDate_depart(rs.getDate("date_depart"));
                v.setDate_arrivee(rs.getDate("date_arrivee"));
                v.setHeure_decollage(rs.getTime("heure_decollage"));
                v.setHeure_arrivee(rs.getTime("heure_arrivee"));
                v.setDestination(rs.getString("destination"));
                v.setNbr_placedispo(rs.getInt("nbr_placedispo"));
                v.setId_avion(rs.getInt("id_avion"));
                v.setPrix(rs.getFloat("prix"));
                Vols.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Vols;
}
    
   

   
    
    
}
