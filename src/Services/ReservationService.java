/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Reservation;
import Entities.*;
import GetAway.entities.Activite;
import Utilis.Datasource;
import Entities.Hebergement;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Asus
 */
public class ReservationService implements IService<Reservation> {
private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public ReservationService() {
        conn = Datasource.getInstance().getCnx();
    }
 @Override
    public void ajouter(Reservation r) {
      
         
           
        String req = "INSERT INTO `reservation` (`date_reservation`,`nbr_place`,`id_voyage`,`id_client`,`etat`,`type`) VALUE (?,?,?,?,?,?)";
        try {
             pste = conn.prepareStatement(req);
            pste.setDate(1,r.getDate_reservation());
            pste.setInt(2,r.getNbr_place());
             pste.setInt(3,r.getId_voyage());
              pste.setInt(4,r.getId_client());
              pste.setString(5,r.getEtat());
             pste.setString(6,r.getType());
            pste.executeUpdate();
            System.out.println(" Reservation voyage   créée");
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void ajouterVol(Reservation r) {
        
         
         
          
        if(this.verifierNbplaceVol(r.getId_vol(),r.getNbr_place()))
        {
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
              modifiernbplacevol(r.getId_vol(),r.getNbr_place());
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }}
         else
            
        {
            
            System.out.println(" nbre de place non valide ");
        }
    }
      public void ajouterAct(Reservation r) {
   if(this.verifierNbplaceAct(r.getId_active(),r.getNbr_place()))
        {
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
   else 
              System.out.println("nbre de place non disponible ");
      
      }
      
      public void ajouterHeb(Reservation r) {
   if ( this.testerdisponibliteH(r.getDate_debut(),r.getDate_fin(),r.getId_hebergement() ) && this.verifierDateHberg(r.getId_hebergement(),r.getDate_debut(), r.getDate_fin()) ) 
   {
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   else
       
              System.out.println("echec d'ajout ");
      
      
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservations;
    }
    
    //MODIFER NBRE DES PLACES
    
    //Activite
    public void modifiernbplaceA(int id,int nb ,String op)
{
    
    String req = "update Activite set `NbrPlace`=`NbrPlace` - ? where RefAct=?";
     try {
             pste = conn.prepareStatement(req);
          
               pste.setInt(1,nb);
            
              pste.setInt(2,id);
            pste.executeUpdate();
            System.out.println(" Nombre de place Activite modifie ");
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
       //Vol 
    public void modifiernbplacevol(int id,int nb)
{
    System.out.println("test");
    String req = "update vol  set `nbr_placedispo`= `nbr_placedispo` - ? where id_vol=?";
     try {
             pste = conn.prepareStatement(req);
          
               pste.setInt(1,nb);
              pste.setInt(2,id);
            pste.executeUpdate();
            System.out.println(" nombre place vol modifié  ");
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
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
    
  
            public boolean verifierNbplaceAct(int id , int nb)
  {
      
      ActiviteService as = new ActiviteService();
      List<Activite> lv= as.afficher();
      boolean test =lv.stream().filter(v->v.getRefAct()==id).anyMatch(v -> v.getNbrPlace()- nb >= 0);
      return test;
  }
      
      
      //voyage organise 
      
//            public boolean verifierNbplaceVoyage(int id , int nb)
//  {
//      
////      VolService vs = new VolService();
////      List<Vol> lv= vs.afficher();
////      boolean test =lv.stream().filter(v->v.getId_vol()==id).anyMatch(v -> v.getNbr_placedispo() - nb >= 0);
////      return test;
//  }
    
    
    
    
    
    
    //Recuperer la liste de reservation par client   
public List<Integer> listeReservationparClient(int id)
{
     List<Reservation> l = this.afficher();
     
     return l.stream().filter(r->r.getId_client()==id).filter(r->r.getEtat().equals("Approuve")).mapToInt(i->i.getId()).boxed().collect(Collectors.toList());
    
}


  public boolean verifierDateHberg(int id ,Date dd , Date df)
   {
       HebergementService hs = new HebergementService();
     List<Hebergement> l =hs.afficher();
       System.out.println(l);
     l=l.stream().filter(h->h.getReferance()==id).limit(1).collect(Collectors.toList());
     
       System.out.println(dd.after(l.get(0).getDate_start()));
       System.out.println(l.get(0).getDate_start());
       System.out.println("aaa"+ df.before(l.get(0).getDate_end()));
         return(  dd.equals(l.get(0).getDate_start())|| dd.after(l.get(0).getDate_start()) )&&( df.equals(l.get(0).getDate_end())|| df.before(l.get(0).getDate_end()));
     
   
   
       
   }
  

  
  //verfier si il existe une reservation au meme temps 
  public boolean  testerdisponibliteH(Date dd , Date df , int id  )
  {
      
        List<Reservation> l = this.afficher();
        
        List<LocalDate> dated=l.stream().filter(e->e.getId_hebergement()==id).map(e->e.getDate_debut().toLocalDate()).collect(Collectors.toList());
          List<LocalDate> datef=l.stream().filter(e->e.getId_hebergement()==id).map(e->e.getDate_fin().toLocalDate()).collect(Collectors.toList());
           
          for ( int i=0 ; i<dated.size(); i++)
          {
        if(dated.get(i).compareTo(dd.toLocalDate())<0 && datef.get(i).compareTo(dd.toLocalDate())>0 ||
      dated.get(i).compareTo(df.toLocalDate())<0 && datef.get(i).compareTo(df.toLocalDate())>0 ||
       dated.get(i).compareTo(dd.toLocalDate())<0 && datef.get(i).compareTo(df.toLocalDate())>0 ||
        dated.get(i).compareTo(dd.toLocalDate())>0 &&datef.get(i).compareTo(df.toLocalDate())<0  || dated.get(i).equals(dd.toLocalDate()) &&datef.get(i).equals(df.toLocalDate()) )
      
    {
      return false;
    
    
    }
        
     
         }
          
         return true;  
       
          
  }  
       
       
       
       

  
  ///Statistique sur nbre de reservation selon le type 
  
  public  Map<String,List<Reservation>>  sataR()       
  {
      List<Reservation> l = this.afficher();
       
   return  l.stream().filter(e->e.getEtat().equals("Approuve")).collect(Collectors.groupingBy(e->e.getType()));
   
                
                
                }

}
