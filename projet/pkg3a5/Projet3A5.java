/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;
import java.io.IOException;
import java.net.URL;
 
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
/**
 *
 * @author TOSHIBA
 */
public class Projet3A5 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception  {
        
        Parent root = FXMLLoader.load(getClass().getResource("userlogin.fxml"));
        
        Scene scene = new Scene(root);
        //stage.setTitle("S'INSCRIRE");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
