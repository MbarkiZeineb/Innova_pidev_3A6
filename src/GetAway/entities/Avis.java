/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetAway.entities;

/**
 *
 * @author TheBoss'07
 */
public class Avis {
    private int RefAvis;
    private String Message;
    private String Date;
    private int Id;

    public Avis() {
    }

    public Avis(int RefAvis, String Message, String Date, int Id) {
        this.RefAvis = RefAvis;
        this.Message = Message;
        this.Date = Date;
        this.Id = Id;
    }

    public Avis(int RefAvis, String Message) {
        this.RefAvis = RefAvis;
        this.Message = Message;
    }

    public Avis(int RefAvis) {
        this.RefAvis = RefAvis;
    }

   
    public Avis(String Message, String Date, int Id) {
        this.Message = Message;
        this.Date = Date;
        this.Id = Id;
    }

    public int getRefAvis() {
        return RefAvis;
    }

    public void setRefAvis(int RefAvis) {
        this.RefAvis = RefAvis;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "{RefAvis= " + RefAvis + ", Message= " + Message + ", Date= " + Date + ", Id= " + Id +"}\n";
    }
    
    
}
