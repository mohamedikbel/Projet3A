/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.MaConnexion;

/**
 * FXML Controller class
 *
 * @author Amal
 */
public class FXMLPieChartController implements Initializable {

    private PieChart myPieChart;
    private ObservableList<PieChart.Data> data;
    @FXML
    private Button promotionid;
    @FXML
    private Button reclamid;
   
    @FXML
    private BarChart<?, ?> aman;

    /**
     * Initializes the controller class.
     */
    
    private void buildPieChartData() {
        try { 
       
  
            int a=0;
             Connection c ;
            Connection  ds = MaConnexion.getinstence().getcon();
          data = FXCollections.observableArrayList();
           c = ds;
           String SQL = "SELECT COUNT(*),sujet from reclamation group by sujet";
     
              ResultSet rs = c.createStatement().executeQuery(SQL);

              XYChart.Series SER = new XYChart.Series<>();
            while (rs.next()) {
               //data.add(new PieChart.Data(rs.getString(2),rs.getDouble(1)));
            SER.getData().add(new XYChart.Data(rs.getString(2),rs.getDouble(1)));
                
            } 
            
            aman.getData().addAll(SER);
   
           // new PieChart.Data("data1 "+percentage1, percentage1); 
           
            myPieChart.setTitle("Réclamation par Service");
            myPieChart.setData(data);
            myPieChart.setLegendVisible(true);
            
    



       
             //  myPieChart.setData("pourcentage achat",+a);   
               
          
       

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
         buildPieChartData(); 
        
    }    

    private void ViewChart(ActionEvent event) {
          buildPieChartData();
          
    }

    @FXML
    private void SplitPromotion(ActionEvent event) { 
             try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("ajouterPromotion.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promotionid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SplitReclamation(ActionEvent event) { 
                 try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("Reclamation.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           reclamid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
