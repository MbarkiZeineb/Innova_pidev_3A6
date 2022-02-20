/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Reservation;
import Entities.Vol;
import Utilis.Datasource;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
    public void modifier(Reservation r) {
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
            pste.setInt(9,r.getId());
            pste.executeUpdate();
            System.out.println(" Reservation  modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifiervol(Reservation r) {
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
            pste.setInt(9,r.getId());
            pste.executeUpdate();
            System.out.println(" Reservation  modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      
    public void modifierHeb(Reservation r) {
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
            pste.setInt(9,r.getId());
            pste.executeUpdate();
            System.out.println(" Reservation  modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierAct(Reservation r) {
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
            pste.setInt(9,r.getId());
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
                  r.setType(rs.getString("type"));
                reservations.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservations;
    }
    
    //MODIFER NBRE DES PLACES
    
    //Activite
    public void modifiernbplaceA(int id,int nb ,String op)
{
    
    String req = "update Activite set `NbrPlace`=`NbrPlace`?? where RefAct=?";
     try {
             pste = conn.prepareStatement(req);
          
               pste.setInt(1,nb);
               pste.setString(2,op);
              pste.setInt(3,id);
            pste.executeUpdate();
            System.out.println(" Nombre de place Activite modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(IReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
       //Vol 
    public void modifiernbplacevol(int id,int nb)
{
    
    String req = "update vol  set `nbr_placedispo`=`nbr_placedispo`- ? where id_vol=?";
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
    //verifier si le nombre de place demande est possible 
    
    //Vol 
      public boolean verifierNbplaceVol(int id , int nb)
  {
      
      VolService vs = new VolService();
      List<Vol> lv= vs.afficher();
      boolean test =lv.stream().filter(v->v.getId_vol()==id).anyMatch(v -> v.getNbr_placedispo() - nb >= 0);
      return test;
  }
    
    //Activite 
      
      
      
      //voyage organise 
      
      
    
    
    
    
    
    
    //Recuperer la liste de reservation par client   
public List<Integer> listeReservationparClient(int id)
{
     List<Reservation> l = this.afficher();
     
     return l.stream().filter(r->r.getId_client()==id).mapToInt(i->i.getId()).boxed().collect(Collectors.toList());
    
}

//Verifier la date debut d'une reservation pour un client 
  public boolean verifierDateReservation(int id ,Date dd )
   {
       
      List<Reservation> l=this.afficher();
   return l.stream().filter(r->r.getId_client()==id).anyMatch(d->d.getDate_debut()==dd);
    
    
   
       
   }
  

  
  //verfier si il existe une reservation au meme temps 
  public boolean  testerdisponibliteH(Date dd , Date df , int id  )
  {
      
        List<Reservation> l = this.afficher();
        
       boolean testd= l.stream().filter(r->r.getType().equals("Hebergement")).filter(r->r.getId_hebergement()==id).anyMatch(d->d.getDate_debut()==dd);
       boolean testf= l.stream().filter(r->r.getType().equals("Hebergement")).filter(r->r.getId_hebergement()==id).anyMatch(d->d.getDate_fin()==df);
       
      
       return testd&&testf;
       
       
       
            }
  
  ///Statistique sur nbre de reservation selon le type 
  
  public void  sataR()       
  {
      List<Reservation> l = this.afficher();
       
    Map<String,List<Reservation>> map = l.stream().filter(e->e.getEtat().equals("Approuve")).collect(Collectors.groupingBy(e->e.getType()));
    
        map.forEach((e,v)->{System.out.println("Type de reservation "+e);
        
            System.out.println(" Nbre de reservation total:"+v.stream().mapToInt(r->r.getNbr_place()).sum());
                });
                
                
                
                
                
                }

}
