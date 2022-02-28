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
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;

/**
 *
 * @author Malek
 */
public class Getaway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception {
        // TODO code application logic here
        VolService vs = new VolService();
        
//        SimpleDateFormat s = new SimpleDateF
//  

//
//      String strDate6 = "23-May-2014 17:10:14";
//      SimpleDateFormat sdf6 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

        
        
        Timestamp sqlTimestamp111 = Timestamp.valueOf("2025-10-17 12:20:50");
        Timestamp sqlTimestamp122 = Timestamp.valueOf("2025-10-17 14:57:51");
        // System.out.println(vs.testdate(sqlTimestamp111,sqlTimestamp111,7));

     /*   Vol v5 = new Vol(sqlTimestamp111,sqlTimestamp122,"Nabeul",20,3, (float) 1999.8) ;
        //vs.ajouter(v5);
        Vol v7 = new Vol(sqlTimestamp111,sqlTimestamp122,"Nabeul",20,7, (float) 1999.8) ;
        //vs.ajouter(v7);
         Vol v8 = new Vol(sqlTimestamp111,sqlTimestamp122,"Nabeul",20,7, (float) 1999.8) ;
       // vs.ajouter(v8);
        */
       // Vol v9 = new Vol(sqlTimestamp111,sqlTimestamp122,"france",50,8, (float) 200.1) ;
       // vs.ajouter(v9);
       Timestamp sqlTimestamp11 = Timestamp.valueOf("2021-09-15 21:00:50");
        Timestamp sqlTimestamp12 = Timestamp.valueOf("2021-09-15 22:00:51");
     Vol v4 = new Vol(sqlTimestamp11,sqlTimestamp12,"Allemagne","Tunisie",20,9, (float) 111.2) ;
     vs.ajouter(v4);

   //System.out.println(vs.calculenbvol(8));
    //vs.calculernbreVolparmois();
   // System.out.println(vs.calculnbvolparjr(7,sqlTimestamp11));
    
      //System.out.println(vs.findVolParId(72));
    //System.out.println(vs.findVolParPrix((88.2)));
     //System.out.println(vs.findVolParDest("nabeul"));
      System.out.println(vs.getALLVolsprix((float) 88.2));

//v4.setPrix((float) 88.2);
//vs.modifier1(v4,70);
//vs.supprimer(65);
//System.out.println(vs.afficher());

   // vs.ajouter(v4);
   // vs.modifier(new Vol(sqlTimestamp11,sqlTimestamp12,"Haha",20,3, (float) 10.8) );
   // vs.modifier(new Vol(sqlTimestamp11,sqlTimestamp12,"Allemagne",20,3, (float) 1009.8));
       //vs.ajouter(v4);
      //modif 1
     // vs.modifier(new Vol(18,DateR,DateF,TimeR,TimeR,"tunisie",50,5, (float)125.8));
     //modif 2
    //    v1.setNbr_placedispo(20);
    //    vs.modifier(v1,15);
       //System.out.println(vs.afficher());
       //vs.modifier(v);
     //  v.setId_vol(14);
    
    //v4.setId_vol(81);
    //v4.setVille_depart("tunisie");
    //vs.modifier(v4);
        
    
      
      
         AvionService as = new AvionService();
//         Avion a=new Avion(12,1);
//         Avion a1=new Avion(13,1);
//         Avion a2=new Avion(80,3);
        // System.out.println(as.findAvionParId(3));
        // as.ajouter(a2);
 //         as.ajouter(a1);
//        a.setNbr_place(25);
//        as.modifier(a,3);
     //  System.out.println(as.afficher());
     
   //  as.modifier(new Avion(6,888,1));
  // as.supprimer(new Avion(6,888,1));
  
         //vs.stat();
       
        
        
       
    }
    
}
