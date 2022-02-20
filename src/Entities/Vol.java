/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.sql.*;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Vol {
       private int id_vol ;
     public Date date_depart;	
     public Date date_arrivee;	
     private Time heure_decollage;
     private Time heure_arrivee;
     private String destination	;
     private int nbr_placedispo;
     private int id_avion ;
     private float prix;

    public Vol() {
    }

    public Vol(int id_vol, Date date_depart, Date date_arrivee, Time heure_decollage, Time heure_arrivee, String destination, int nbr_placedispo, int id_avion, float prix) {
        this.id_vol = id_vol;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.heure_decollage = heure_decollage;
        this.heure_arrivee = heure_arrivee;
        this.destination = destination;
        this.nbr_placedispo = nbr_placedispo;
        this.id_avion = id_avion;
        this.prix = prix;
    }

    public Vol(Date date_depart, Date date_arrivee, Time heure_decollage, Time heure_arrivee, String destination, int nbr_placedispo, int id_avion, float prix) {
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.heure_decollage = heure_decollage;
        this.heure_arrivee = heure_arrivee;
        this.destination = destination;
        this.nbr_placedispo = nbr_placedispo;
        this.id_avion = id_avion;
        this.prix = prix;
    }

    
    

    public int getId_vol() {
        return id_vol;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public Time getHeure_decollage() {
        return heure_decollage;
    }

    public Time getHeure_arrivee() {
        return heure_arrivee;
    }

    public String getDestination() {
        return destination;
    }

    public int getNbr_placedispo() {
        return nbr_placedispo;
    }

    public int getId_avion() {
        return id_avion;
    }

    public float getPrix() {
        return prix;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public void setHeure_decollage(Time heure_decollage) {
        this.heure_decollage = heure_decollage;
    }

    public void setHeure_arrivee(Time heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNbr_placedispo(int nbr_placedispo) {
        this.nbr_placedispo = nbr_placedispo;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.date_depart);
        hash = 73 * hash + Objects.hashCode(this.date_arrivee);
        hash = 73 * hash + Objects.hashCode(this.heure_decollage);
        hash = 73 * hash + Objects.hashCode(this.heure_arrivee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vol other = (Vol) obj;
        if (!Objects.equals(this.date_depart, other.date_depart)) {
            return false;
        }
        if (!Objects.equals(this.date_arrivee, other.date_arrivee)) {
            return false;
        }
        if (!Objects.equals(this.heure_decollage, other.heure_decollage)) {
            return false;
        }
        if (!Objects.equals(this.heure_arrivee, other.heure_arrivee)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Vol{" + "id_vol=" + id_vol + ", date_depart=" + date_depart + ", date_arrivee=" + date_arrivee + ", heure_decollage=" + heure_decollage + ", heure_arrivee=" + heure_arrivee + ", destination=" + destination + ", nbr_placedispo=" + nbr_placedispo + ", id_avion=" + id_avion + ", prix=" + prix + '}';
    }
    

    
}
