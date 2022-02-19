/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getaway;

import getaway.entities.Avion;
import getaway.entities.Vol;
import getaway.services.AvionService;
import getaway.services.VolService;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Malek
 */
public class Getaway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VolService vs = new VolService();
//        SimpleDateFormat s = new SimpleDateF
//      
       String SDateR = "2021-03-21";  
       String SDateF = "2021-03-22";
       String SDateM = "2023-10-22";
       String SDateH = "2023-11-22";
       Date DateR=Date.valueOf(SDateR);
       Date DateF=Date.valueOf(SDateF);
       Date DateM=Date.valueOf(SDateM);
       Date DateH=Date.valueOf(SDateH);
       String STimeR="11:1:11";
       String STimeF="15:12:12";
       String STimeH="15:12:44";
       Time TimeR=Time.valueOf(STimeR);
       Time TimeF=Time.valueOf(STimeF);
       Time TimeH=Time.valueOf(STimeH);
       
        Vol v1 = new Vol(DateR,DateF,TimeF,TimeF,"tunisie",10,3, (float) 100.5) ;
        Vol v2 = new Vol(DateR,DateF,TimeR,TimeR,"tunisie",50,5, (float) 80.5) ;
        Vol v3 = new Vol(DateR,DateF,TimeR,TimeR,"Nabeul",20,3, (float) 125.8) ;
        Vol v4 = new Vol(DateR,DateF,TimeR,TimeR,"Nabeul",20,3, (float) 18.8) ;
        Vol v5 = new Vol(DateR,DateF,TimeR,TimeR,"Nabeul",50,5, (float) 60.5) ;
        Vol v6 = new Vol(DateM,DateH,TimeH,TimeH,"Nabeul",60,5, (float) 2222.5) ;
        vs.ajouter(v6);
       //vs.ajouter(v4);
      //modif 1
     // vs.modifier(new Vol(18,DateR,DateF,TimeR,TimeR,"tunisie",50,5, (float)125.8));
     //modif 2
    //    v1.setNbr_placedispo(20);
    //    vs.modifier(v1,15);
      //  System.out.println(vs.afficher());
       //vs.modifier(v);
     //  v.setId_vol(14);
     //sup1
     //vs.supprimer(new Vol(18,DateR,DateF,TimeR,TimeR,"Nabeul",20,3, (float) 125.8));
     //supp2
      //vs.supprimer(12);
      //System.out.println(vs.findVolParId(16));
      //System.out.println(vs.findVolParPrix((float) 100.5));
      //System.out.println(vs.tri_vol());
      
         AvionService as = new AvionService();
         Avion a=new Avion(12,1);
         Avion a1=new Avion(13,1);
         Avion a2=new Avion(500,1);
  //       as.ajouter(a2);
//         as.ajouter(a1);
//        a.setNbr_place(25);
//        as.modifier(a,3);
     //   System.out.println(as.afficher());
     
   //  as.modifier(new Avion(6,888,1));
  // as.supprimer(new Avion(6,888,1));
  
        
        
       
    }
    
}
