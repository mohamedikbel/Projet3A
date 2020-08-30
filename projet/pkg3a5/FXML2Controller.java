/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import utils.MaConnexion;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class FXML2Controller implements Initializable {

    @FXML
    private BarChart<String, Integer> barchart;
    @FXML
    private Button load;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void load(ActionEvent event) {
         Connection  C  = MaConnexion.getinstence().getcon(); 
    
      String requete;
       
       requete = "SELECT disponibilite, count(*)  FROM salles GROUP BY disponibilite";  
         XYChart.Series<String,Integer> series = new XYChart.Series<>();
            try {
            PreparedStatement ps = C.prepareStatement(requete);
         
           ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()){  
                series.getData().add(new XYChart.Data<>(resultat.getString(1),resultat.getInt(2)));
            }
        barchart.getData().add(series);
    }
            catch (SQLException ex) {
            
            System.out.println("erreur  " + ex.getMessage());
        }
         
    
            }
    }

