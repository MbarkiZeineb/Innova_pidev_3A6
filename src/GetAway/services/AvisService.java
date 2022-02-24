/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetAway.services;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import GetAway.entities.Avis;
import GetAway.utilis.Datasource;

/**
 *
 * @author TheBoss'07
 */


public class AvisService extends SendSms implements IService<Avis> {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public AvisService() {
        conn = Datasource.getInstance().getCnx();
    }

    
    
    @Override
    public void ajouter(Avis av) {
        String req = "INSERT INTO `Avis` (`Message`,`Date`,`Id`) VALUE ('" + av.getMessage() + "','" + av.getDate() +"', '" + av.getId() +"')";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Avis crée");
            
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void modifier(Avis av) {
       String req = "UPDATE Avis SET Message='" + av.getMessage() +"' WHERE RefAvis='" + av.getRefAvis()+"'";
    try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        System.out.println("Avis Modifié");
    }   catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void supprimer(Avis av) {
        
      String req = "DELETE FROM Avis WHERE RefAvis='" + av.getRefAvis()+"'";
    try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        System.out.println("Avis Supprimer");
    }   catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Avis> afficher() {
        List<Avis> avis = new ArrayList<>();
        String req = "SELECT * FROM `Avis`";
        
        try {
            pste = conn.prepareStatement(req);
            ResultSet rs = pste.executeQuery();
            
//            ste = conn.createStatement();
//            ResultSet rs = ste.executeQuery(req);
            System.out.println("Liste des avis:");
            while(rs.next()){
                Avis av = new Avis();
                av.setRefAvis(rs.getInt(1));
                av.setMessage(rs.getString(2));
                av.setDate(rs.getString(3));
                av.setId(rs.getInt(4));
                
               
                avis.add(av);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return avis;
    }   

    

    
}
