/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getawayvoyage;


import Utilis.Datasource;
import Entities.*;
import java.text.SimpleDateFormat;
import Services.*;
import java.text.ParseException;
import java.time.*;

import java.sql.*;

/**
 *
 * @author Asus
 */
public class GetAwayvoyage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    String SDateR="2022-03-31";  
      
        String SDateD="2022-01-20";
         String SDateF="2022-05-26";
        
        
        
        
    Date DateR=Date.valueOf(SDateR);
        
    Date DateD=Date.valueOf(SDateD);
    Date DateF=Date.valueOf(SDateF);
  
  Reservation r5= new Reservation(DateR, 5, DateD, DateF, 0, 0, 0,1,"enA", 1, "hebergment");
           
  Reservation r4= new Reservation(DateR, 12, DateD, DateF, 0, 1,0 ,0,"enA", 1, "hebergment");  
  
             
  Reservation r7= new Reservation(DateR, 10, DateD, DateF,0, 0,2,0,"enA", 1, "hebergment");  
    IReservationService Rs= new IReservationService();
    
        System.out.println(Rs.verifierNbplaceVol(3,11));
   //Rs.ajouterHeb(r5);
//      
//        Paiement p = new Paiement("cheque",0,3,DateD);
//    IPaiementService ps= new  IPaiementService();
//    
//    
////        ps.ajouter(p);
////        Paiement p2= new Paiement();
////  
//////        ps.supprimer(p2);
//////        System.out.println(ps.afficher());
////   p.setMontant(ps.calculermontantActivite(r4));
////        ps.modifier(p,3);
////
////
////Rs.modifiernbplaceA(1,4);
////Rs.modifiernbplacevol(1,2);
////Rs.modifiernbplacevoyage(1,10);
////
////     
////        
////        //Rs.ajouterVol(r7);
////        r7.setNbr_place(12);
////        Rs.modifiervol(r7,14);
////        r7.setId(15);
////        Rs.supprimer(r7);
//
////        System.out.println(Rs.listeR(1));
////        System.out.println(ps.MontantT(Rs.listeR(1)));
////        
////        Rs.modifiernbplacevol(1,2);
//
//  Rs.sataR();
    }
     
}
