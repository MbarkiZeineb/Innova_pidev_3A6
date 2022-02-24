/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author asus
 */
public class Admin extends User {
  
   private String adresse;



    public Admin() {
    }

    public Admin(int id, String nom, String prenom, String email, String adresse, String pwd) {
    super(id, nom, prenom, pwd, email);
        this.adresse = adresse;
      
       
    }

    public Admin(String nom, String prenom, String email, String adresse, String password) {
     super(nom, prenom, password, email);
        this.adresse = adresse;
    }


    public String getAdresse() {
        return adresse;
    }



    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        
        return "Admin{"+super.toString()+ " adresse=" + adresse + '}';
    }


   

    
   
}
