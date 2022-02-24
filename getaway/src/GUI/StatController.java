/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import getaway.entities.Vol;
import getaway.services.VolService;
import getaway.utilis.Datasource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javax.activation.DataSource;

/**
 * FXML Controller class
 *
 * @author Malek
 */
public class StatController implements Initializable {
    @FXML
    private BarChart<String,Integer> barChart;

    /**
     * Initializes the controller class.
     */
    
    private Connection con = Datasource.getInstance().getCnx();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      String req =" select a.id_avion , COUNT(v.destination) from vol v join avion a on v.id_avion=a.id_avion group by a.id_avion; ";
        XYChart.Series<String,Integer> series = new XYChart.Series<String,Integer>();
        try {
             PreparedStatement ste = (PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));
            }
            barChart.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        
        
  
}
}