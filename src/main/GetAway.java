/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GetAway.entities.Activite;
import GetAway.entities.Avis;
import GetAway.services.ActiviteService;
import GetAway.services.AvisService;
import GetAway.utilis.Datasource;

/**
 *
 * @author TheBoss'07
 */
public class GetAway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Datasource ds = Datasource.getInstance();
        System.out.println(ds.hashCode());
        
        
        ActiviteService as = new ActiviteService();
        AvisService avs = new AvisService();
        
        
        
        // Ajout Activite
        // Activite a = new Activite("TEST MR", "Bla Bla Bla","1h30",10,"20/01/2022","Sport","Tunis",1);     
        // as.ajouter(a);
        
        // Modifier Activite
        // Activite a = new Activite(4,"Hey", "Hello world","1h30",10,"20/01/2021","Sport","Tunis",1);
        // as.modifier(a);

        // Supprimer Activite
        // Activite a = new Activite(5);
        // as.supprimer(a);

        // Ajout Avis
         Avis av = new Avis ("wtaaedaad","11/02/201",1);
       avs.ajouter(av);
        
        // Modifier Avis
        // Avis av= new Avis(6,"Bla bla");
        // avs.modifier(av);
        
        // Supprimer Avis
//         Avis av = new Avis (8);
//         avs.supprimer(av);

        // Afficher Activites
        System.out.println(as.afficher());
        System.out.println("**********************************************************************************************************************************");
        // Afficher Avis
        System.out.println(avs.afficher());
        //System.out.println(as.recupAdrM());
        //System.out.println(as.rechercherActiviteRef(4));
        
    }
    
}
