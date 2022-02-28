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
public class Client extends User{

   private int etat=1;
    public Client(int id, String nom, String prenom, String pwd, String email, int etat) {
     super(id,nom,prenom,pwd,email);
     
        this.etat = etat;
    }

    public Client(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public Client(String nom, String prenom, String pwd, String email, int etat) {
    super(nom, prenom, pwd, email);
        this.etat = etat;
    }

    public Client(String nom, String prenom, String pwd, String email) {
        super(nom, prenom, pwd, email);
    }

    public Client() {
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Client{" +super.toString()+", etat=" + etat +'}';
    }
   
}
