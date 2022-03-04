/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Reclamation {
    private int idR;
    private int idC;
    private String objet;
    private String description;

    public Reclamation() {
    }

    public Reclamation(int idR, int idC, String objet, String description) {
        this.idR = idR;
        this.idC = idC;
        this.objet = objet;
        this.description = description;
    }

    public Reclamation(int idC, String objet, String description) {
        this.idC = idC;
        this.objet = objet;
        this.description = description;
    }
    

    public int getIdR() {
        return idR;
    }

    public int getIdC() {
        return idC;
    }

    public String getObjet() {
        return objet;
    }

    public String getDescription() {
        return description;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idR=" + idR + ", idC=" + idC + ", objet=" + objet + ", description=" + description + '}';
    }
      

}
