/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import Utilis.Datasource;
import entities.*;
import Services.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;
import javax.swing.text.html.HTML;

/**
 *
 * @author Rayen
 */
public class Test {

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
        HebergementService HS = new HebergementService(); 
        CategoryService CS = new CategoryService();
        //Category c1= new Category(3,"toktok");
        Hebergement h= new Hebergement( "tunis", "ghazela", (float) 465.54, "String description"," String photo", DateD, DateF, "tact", 84, 48, 4, "String",1 ,1);
//  String paye, String adress, float prix, String description, String photo, Date date_start, Date date_end, String contact, int nbr_detoile, int nbr_suite, int nbr_parking, String model_caravane, int id_confeg ,int offreur  
//     Category C1 = new Category(5,"jcp");
//CS.ajouter(C1);
//HS.ajouter(h);
// System.out.println(HS.afficher());
//HS.supprimer(h);
//System.out.println(HS.afficher());
System.out.println(CS.afficher());
//HS.ajouter(h);
//CS.ajouter(C1);
//       
//        CS.getByReferanc(2);
//        HS.getByReferanc(19);
//CS.modifier(c1);

System.out.println(HS.afficher());
HS.modifier(h);
System.out.println(HS.afficher());

        
 
}
}