/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getaway.utils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Amal Chibani
 */
public class datasource {
    private String url = "jdbc:mysql://localhost:3306/pidev";
    private String username = "root";
    private String password = "";
    
    private Connection cnx;
    private static datasource instance;
    
    private datasource() {
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
    
    
    public static datasource getInstance() {
        if(instance == null){
            instance = new datasource();
        }
        return instance;
    }
}
