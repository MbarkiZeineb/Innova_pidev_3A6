package GetAway.utilis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheBoss'07
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author remo
 */
public class Datasource {
    private String url = "jdbc:mysql://localhost:3306/getaway";
    private String username = "root";
    private String password = "";
    
    private Connection cnx;
    private static Datasource instance;
    
    private Datasource() {
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
    
    
    public static Datasource getInstance() {
        if(instance == null){
            instance = new Datasource();
        }
        return instance;
    }
}
