/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AgentAerienController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;
    
       private int ida; 
    @FXML
    private Button bReclamation;
    public void setIdA(int ida) {
        System.out.println(ida);
        this.ida = ida;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gestionvol(ActionEvent event) throws IOException {
        
       
          try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterVol.fxml"));
		Parent root = loader.load();
		AjouterVolController  e = loader.getController();
                e.setIdagent(ida);
                
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}
      
    }

    
    
    @FXML
    private void consulterProfil(ActionEvent event) {
        
           try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterVol.fxml"));
		Parent root = loader.load();
		AjouterVolController  e = loader.getController();
//                e.setIdc(idc);
		((Button) event.getSource()).getScene().setRoot(root);
		}catch(Exception ex){
			System.out.println(ex);
		}
        
    }

    
    
}
