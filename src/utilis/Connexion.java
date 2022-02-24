/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilis;

import java.sql.*;


/**
 *
 * @author asus
 */
public class Connexion {
        private String url = "jdbc:mysql://localhost:3306/getaway";
    private String username = "root";
    private String password = "";
    
    private Connection cnx;
    private static Connexion instance;

    public Connexion() {
          try {
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("database connected");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public Connection getCnx() {
        return cnx;
    } 
     public static Connexion getInstance() {
        if(instance == null){
            instance = new Connexion();
        }
        return instance;
    }
    
    
}
