/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.Client;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.ClientDB;

/**
 * FXML Controller class
 *
 * @author TOSHIBA
 */
public class SetpasseController implements Initializable {

    @FXML
    private AnchorPane enrgistrer;
    @FXML
    private TextField code;
    @FXML
    private TextField noupass;
    @FXML
    private Button enr;
    ClientDB  crud = new ClientDB();


    /**
     * Initializes the controller class.
     * 
     */
        
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
        code.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(crud.userandcode(Client.getCurrentuser(),code.getText()))
           {code.setStyle("-fx-border-color: green");
            
            noupass.setVisible(true);
            noupass.setEditable(true);
            enr.setDisable(false);
            enr.setVisible(true);
                }
            
        });
        // TODO
    }    

    @FXML
    private void enregistrerpass(ActionEvent event) throws SQLException, IOException {
        
        crud.setpass(Client.getCurrentuser(), noupass.getText());
        crud.setrecnull(Client.getCurrentuser());
       
         ((Node)event.getSource()).getScene().getWindow().hide();

         Parent p1 = FXMLLoader.load(getClass().getResource("userlogin.fxml"));
          Scene test1 = new Scene(p1);
          Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
          App1.setScene(test1);
          App1.show();
        
    }
    
  /*  code.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
        
        outputTextArea.appendText("TextField Text Changed (newValue: " + newValue + ")\n");
    }
});*/
    
    
    
}
