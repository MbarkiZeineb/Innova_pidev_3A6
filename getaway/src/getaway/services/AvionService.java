/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getaway.services;

import getaway.entities.Avion;
import getaway.utilis.Datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malek
 */
public class AvionService implements IService<Avion>{
     private Connection conn;
    private Statement ste;
    private PreparedStatement pste;
    

    public AvionService() {
        conn = Datasource.getInstance().getCnx();
    }

    @Override
    public void ajouter(Avion A) {
         String req = "INSERT INTO `avion` (`nbr_place`,`id_agence`) VALUE (?,?)";
        try {
            pste = conn.prepareStatement(req);
            pste.setInt(1, A.getNbr_place());
            pste.setInt(2, A.getId_agence());
            
            pste.executeUpdate();
            System.out.println("Avion créée");
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    @Override
    public void modifier(Avion A) {
        
    String req = "UPDATE `avion` SET `nbr_place`=?,`id_agence`=?  WHERE  `id_avion` = "+ A.getId_avion() + "";  
    try {
            pste = conn.prepareStatement(req);
            pste.setInt(1, A.getNbr_place());
            pste.setInt(2, A.getId_agence());
            
            pste.executeUpdate();
            int rowsUpdated = pste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification d'avion a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void supprimer(Avion A) {
         try {
            String req = "DELETE FROM `avion` WHERE `id_avion` = "+ A.getId_avion() + "";
            pste = conn.prepareStatement(req);
            pste.executeUpdate();
            System.out.println("Avion supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
    
    

   

    @Override
    public List<Avion> afficher() {
          List<Avion> Avions = new ArrayList<>();
        String req = "SELECT * FROM `avion`";
        
        try {
            
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Avion a = new Avion();
                a.setId_avion(rs.getInt("id_avion"));
                a.setNbr_place(rs.getInt("nbr_place"));
                a.setId_agence(rs.getInt("id_agence"));
                Avions.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Avions;
    }

    
    public Avion findAvionParId(int id_avion) {

        String req = "SELECT * FROM `avion` WHERE `id_avion`= ? ";
        Avion a = new Avion();
        try {
            
            PreparedStatement preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, id_avion);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
               
                a.setId_avion(rs.getInt(1));
                a.setNbr_place(rs.getInt(2));
                a.setId_agence(rs.getInt(3));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;

    }
   
}
