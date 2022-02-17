/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Reservation;
import Utilis.Datasource;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class IReservationService implements IService<Reservation> {
private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public IReservationService() {
        conn = Datasource.getInstance().getCnx();
    }
 @Override
    public void ajouter(Reservation r) {
   
        String req = "INSERT INTO `reservation` (`date_reservation`,`nbr_place`,`date_debut`,`date_fin`,`id_voyage`,`id_client`,`etat`,`type`) VALUE (?,?,?,?,?,?,?,?)";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_voyage());
              pste.setInt(6,r.getId_client());
              pste.setString(7,r.getEtat());
             pste.setString(8,r.getType());
            pste.executeUpdate();
            System.out.println(" Reservation voyage   créée");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void ajouterVol(Reservation r) {
   
        String req = "INSERT INTO `reservation` (`date_reservation`,`nbr_place`,`date_debut`,`date_fin`,`id_vol`,`id_client`,`etat`,`type`) VALUE (?,?,?,?,?,?,?,?)";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_vol());
              pste.setInt(6,r.getId_client());
              pste.setString(7,r.getEtat());
              pste.setString(8,r.getType());
            pste.executeUpdate();
            System.out.println(" Reservation  vol créée");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void ajouterAct(Reservation r) {
   
        String req = "INSERT INTO `reservation` (`date_reservation`,`nbr_place`,`date_debut`,`date_fin`,`id_activite`,`id_client`,`etat`,`type`) VALUE (?,?,?,?,?,?,?,?)";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_active());
              pste.setInt(6,r.getId_client());
              pste.setString(7,r.getEtat());
              pste.setString(8,r.getType());
            pste.executeUpdate();
            System.out.println(" Reservation  créée");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void ajouterHeb(Reservation r) {
   
        String req = "INSERT INTO `reservation` (`date_reservation`,`nbr_place`,`date_debut`,`date_fin`,`id_hebergement`,`id_client`,`etat`,`type`) VALUE (?,?,?,?,?,?,?,?)";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_hebergement());
              pste.setInt(6,r.getId_client());
              pste.setString(7,r.getEtat());
              pste.setString(8,r.getType());
            pste.executeUpdate();
            System.out.println(" Reservation  créée");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public void modifier(Reservation r, int id) {
       String req = "update Reservation set date_reservation=? , nbr_place=? , date_debut=? , date_fin=? , id_client=? , id_voyage=? , etat=? , type=? where id=?";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_client());
            pste.setInt(6,r.getId_voyage());
            pste.setString(7,r.getEtat());
            pste.setString(8,r.getType());
            pste.setInt(9,id);
            pste.executeUpdate();
            System.out.println(" Reservation  modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifiervol(Reservation r, int id) {
       String req = "update Reservation set date_reservation=? , nbr_place=? , date_debut=? , date_fin=? , id_client=? , id_vol=? , etat=? , type=? where id=?";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_client());
            pste.setInt(6,r.getId_vol());
            pste.setString(7,r.getEtat());
            pste.setString(8,r.getType());
            pste.setInt(9,id);
            pste.executeUpdate();
            System.out.println(" Reservation  modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      
    public void modifierHeb(Reservation r, int id) {
       String req = "update Reservation set date_reservation=? , nbr_place=? , date_debut=? , date_fin=? , id_client=? , id_hebergement=? , etat=? , type=? where id=?";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_client());
            pste.setInt(6,r.getId_hebergement());
            pste.setString(7,r.getEtat());
            pste.setString(8,r.getType());
            pste.setInt(9,id);
            pste.executeUpdate();
            System.out.println(" Reservation  modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierAct(Reservation r, int id) {
       String req = "update Reservation set date_reservation=? , nbr_place=? , date_debut=? , date_fin=? , id_client=? , id_activite=? , etat=?  , type=? where id=?";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
            pste.setDate(3,r.getDate_debut());
            pste.setDate(4,r.getDate_fin());
             pste.setInt(5,r.getId_client());
            pste.setInt(6,r.getId_active());
            pste.setString(7,r.getEtat());
            pste.setString(8,r.getType());
            pste.setInt(9,id);
            pste.executeUpdate();
            System.out.println(" Reservation  modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void supprimer(Reservation r) {
        
        String req = "DELETE FROM `reservation` WHERE id=?";
        try {
             pste = conn.prepareStatement(req);
            pste.setInt(1,r.getId());
            pste.executeUpdate();
            System.out.println(" reservation suprime");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reservation> afficher() {
          List<Reservation> reservations = new ArrayList<>();
        String req = "SELECT * FROM `reservation`";
        
        try {

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setId_client(rs.getInt("id_client"));
                 r.setNbr_place(rs.getInt("nbr_place"));
                r.setId_voyage(rs.getInt("id_voyage"));
                   r.setId_vol(rs.getInt("id_vol"));
                      r.setId_active(rs.getInt("id_activite"));
                r.setId_hebergement(rs.getInt("id_hebergement"));
                r.setEtat(rs.getNString("etat"));
                r.setDate_reservation(rs.getDate("date_reservation"));
                 r.setDate_debut(rs.getDate("date_debut"));
                  r.setDate_fin(rs.getDate("date_fin"));
                reservations.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservations;
    }
    
    //MODIFER NBRE DES PLACES
    
    //Activite
    public void modifiernbplaceA(int id,int nb)
{
    
    String req = "update Activite set `NbrPlace`=`NbrPlace`-? where RefAct=?";
     try {
             pste = conn.prepareStatement(req);
          
               pste.setInt(1,nb);
              pste.setInt(2,id);
            pste.executeUpdate();
            System.out.println(" Nombre de place Activite modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
       //Vol 
    public void modifiernbplacevol(int id,int nb)
{
    
    String req = "update vol  set `nbr_placedispo`=`nbr_placedispo`-? where id_vol=?";
     try {
             pste = conn.prepareStatement(req);
          
               pste.setInt(1,nb);
              pste.setInt(2,id);
            pste.executeUpdate();
            System.out.println(" nombre place vol modifié  ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
   //Voyage 
        
    public void modifiernbplacevoyage(int id,int nb)
{
    
    String req = "update voyageorganise  set `nbrPlace`=`nbrPlace`-? where idVoy=?";
     try {
             pste = conn.prepareStatement(req);
          
               pste.setInt(1,nb);
              pste.setInt(2,id);
            pste.executeUpdate();
            System.out.println(" nombre place voyage modifié ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
}
