/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author TOSHIBA
 */
public class menubackController implements Initializable {

    @FXML
    private PieChart piechart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void btnmenu(ActionEvent event) {
    }

    @FXML
    private void btnClientetFormation(ActionEvent event) {
    }

    @FXML
    private void btnEvent(ActionEvent event) {
    }

    @FXML
    private void btnBiblio(ActionEvent event) {
    }

    @FXML
    private void btnMusee(ActionEvent event) throws IOException {
         Parent home =FXMLLoader.load(getClass().getResource("Interface_Bloc_musee_A.fxml"));
         
            Stage primaryS =new Stage();
            Scene scene = new Scene(home);
            primaryS.setScene(scene);
          ((Node)event.getSource()).getScene().getWindow().hide();
            primaryS.show();
             
         
          
    }

    @FXML
    private void btnEspace(ActionEvent event) {
    }

    @FXML
    private void brnReclamationetpromotions(ActionEvent event) {
    }
    
}
