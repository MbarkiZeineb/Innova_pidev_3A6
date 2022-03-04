/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilis.Connexion;

/**
 *
 * @author asus
 */
public class ReclamationService implements IService<Reclamation>{
    private Connection conn;
    private Statement ste;
 private PreparedStatement pste;


    public ReclamationService() {
        conn = Connexion.getInstance().getCnx();
    }
 
    @Override
    public void ajouter(Reclamation r) {
            String req = "INSERT INTO `reclamation` (`idClient`,`objet`,`description`) VALUE ('" + r.getIdC() + "','" + r.getObjet() + "','"+r.getDescription()+ "')";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("reclamation ajoutee");
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Reclamation r) {
              String sql ="UPDATE reclamation SET idClient = '"+r.getIdC()+"',objet = '"
                    +r.getObjet()+"',description = '"+r.getDescription()+"' WHERE idR ="+ r.getIdR()+";";
        
        
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("reclamation modifié");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        
          }

    @Override
    public void supprimer(Reclamation r) {
        
              String req = "DELETE FROM `reclamation` where idR =? ";
    try {
          pste = conn.prepareStatement(req);
            pste.setInt(1, r.getIdR());
            int rowsDeleted = pste.executeUpdate();
            if (rowsDeleted > 0) 
              {
                   System.out.println("reclamation supprime !");
              }
        } catch (SQLException ex) {
        Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
      public void supprimer(int id) {
       String req = "DELETE FROM `reclamation` WHERE idR="+id;
     
          try {
          ste = conn.createStatement();
          ste.executeUpdate(req);
          }catch(SQLException E){
              System.out.println(E.getMessage());
               System.out.println("suppression avec succes !");
          }  
    }
    
    
    

    @Override
    public List<Reclamation> afficher() {
        
              List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT * FROM `reclamation`";
        
        try {
           
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Reclamation r = new Reclamation();
                 r.setIdR(rs.getInt("idR"));
                r.setIdC(rs.getInt("idClient"));
               r.setObjet(rs.getString(3));
             r.setDescription(rs.getString(4)); 

                reclamations.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reclamations; 
    }
}
