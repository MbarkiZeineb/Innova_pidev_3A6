/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getaway;

import getaway.entities.categorie;
import getaway.entities.voyageOrganise;
import getaway.services.categorieServ;
import getaway.services.voyOrgServ;
import getaway.utils.datasource;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Amal Chibani
 */
public class Getaway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        voyOrgServ vos = new voyOrgServ();
        categorieServ catserv = new categorieServ();
        
        voyageOrganise voyageOrganise1 = new voyageOrganise("tunis","italy","12/2/2022","13/2/2022",17,1,55.3f,"absxc");
        voyageOrganise vo2 = new voyageOrganise("tunis","tunis","12/2/2022","13/2/2022",20,2,14.3f,"bojour");
        /*APPEL de la méthode ajouter de la classe voyOrgServ*/
       // vos.ajouter(voyageOrganise1);

        // vos.ajouter(vo2);
        //System.out.println(vos.afficher());
       // vos.delete(61);
       //vos.update(61,"tunis","hand","12/2/2022","13/2/2022",20,1,14.3f,"abedzc");
       // System.out.println(vos.FindIdVoyById(1));
        //System.out.println(vos.FindVille("italy"));
         System.out.println(vos.TrierParPrix());

    
      // vos.update(vo2);
      categorie cat =new categorie("hi");
      //catserv.ajouter(cat);
     //System.out.println(catserv.afficher());
     //catserv.delete(6);
    // catserv.update(cat);
    
    }
    
}
