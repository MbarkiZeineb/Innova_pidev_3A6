/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getaway;
import services.*;
import utilis.Connexion;
import entities.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class Getaway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
       
 AdminService as = new AdminService();
 Admin a = new Admin("zeineb", "benfoulen","zou.dj@gmail.com","ariana","zou");
        try {
            //as.ajouter(a);
//as.supprimer(14);
//as.supprimer(new Admin(9,"omay", "benfoulen","oma.dj@gmail.com","ariana","djobi"));
//as.modifier(new Admin(13,"zeineb", "mbarki","zou.dj@gmail.com","manouba","zou"));
//as.activerCompteParAdmin(1);
//as.BanirCompteParAdmin(13);
//as.rechercher("sarra");
//System.out.println(as.afficher());
//as.sendMail("omayma.djebali@esprit.tn");
        } catch (Exception ex) {
            Logger.getLogger(Getaway.class.getName()).log(Level.SEVERE, null, ex);
        }
AgentAerienService ags=new AgentAerienService();
AgentAerien ag=new AgentAerien("ghass", "dj", "123", "ghass.dj@gmail.com", "airfrance");
//ags.supprimer(9);
//ags.ajouter(ag);
//ags.modifier(new AgentAerien(7,"ghass", "dj", "123", "ghass.dj@gmail.com", "airfrance"));
//ags.supprimer(new AgentAerien(10,"ghass", "dj", "123", "ghass.dj@gmail.com", "airfrance"));
//System.out.println(ags.afficher());
//ags.rechercheragent("chelbia");
ClientService cs = new ClientService();
Client c= new Client("malek", "malloc", "12345", "malloc.ha@gmail.com");
//cs.ajouter(c);
//cs.modifier(new Client(9,"salma", "dj", "salouma", "salma.dj@gmail.com", "france"));
//cs.supprimer(new Client(6,"omayma", "dj", "hahah", "oma.dj@gmail.com", "canada"));
//cs.supprimer(9);
//System.out.println(cs.afficher());
//cs.rechercherclient("sinda");
OffreurService os = new OffreurService();
Offreur o = new Offreur("amal", "ch", "chou", "kkkkk",98306322);
//os.ajouter(o);
//os.modifier(new Offreur(7,"amal", "ch", "choco", "amal.ch@gmail.com",98306322));
//os.supprimer(new Offreur(4,"amine", "dj", "khkhkh", "okkk",98306322));
//os.supprimer(2);
//System.out.println(os.afficher());
//os.rechercheroffreur("amine");
    }
    
}
