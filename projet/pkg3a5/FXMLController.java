/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import Entite.Avis;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;
import service.AvisDB;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField objet;
    @FXML
    private TextField probleme;
    @FXML
    private TextField solution;
    @FXML
    private Button save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save_avis(ActionEvent event) {
       Avis A;
        A = new Avis(0,objet.getText(),probleme.getText(),solution.getText());
        AvisDB cs=new AvisDB(); 
        cs.ajoutersalles(A);
        Notifications.create()
        .title("notification")
        .text("nous avons prendre ca en considération").darkStyle().position(Pos.BOTTOM_CENTER)
                .showWarning();
                
        
    }
    
}
