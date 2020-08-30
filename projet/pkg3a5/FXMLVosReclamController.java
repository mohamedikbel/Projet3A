/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.Client;
import entities.Reclamation;
import service.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ClientDB;

/**
 * FXML Controller class
 *
 * @author Amal
 */
public class FXMLVosReclamController implements Initializable {

    @FXML
    private TableColumn<Reclamation,String> SujetCol;
    @FXML
    private TableColumn<Reclamation,String> MessageCol;
    @FXML
    private TableColumn<Reclamation,String> EtatCol;
     int id_client=ReclamationFrontController.getId_client();
     
    @FXML
    private TableView<Reclamation> table;
    @FXML
    private Button promoid;
    @FXML
    private Button reclamid;
    @FXML
    private Label nomid;
    @FXML
    private Label prenomid;
    
         String usr =Client.getCurrentuser();
    ClientDB cl =new ClientDB();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    
            ClientDB cl =new  ClientDB() ;
            String nom;
        try {
            nom = cl.userfname(usr);
           System.out.println("ikbelllll"+nom);
             nomid.setText(nom);

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
            String prenom;
        try {
            prenom = cl.userlname(usr);
            prenomid.setText(prenom);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    } 
    ObservableList <Reclamation> data = FXCollections.observableArrayList();
    
        private void initCol() {
        SujetCol.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        MessageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        EtatCol.setCellValueFactory(new PropertyValueFactory<>("etat")); 

        
       ServiceReclamation  ser = new ServiceReclamation() {};
        
        data = ser.listerclient(id_client);
        table.setItems(null);
        table.setItems(data);
      
    }  

    @FXML
    private void Spllitpromo(ActionEvent event) { 
           try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("Promotionclient.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promoid.getScene().setRoot(root);
        } catch (IOException ex) {
           // Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
    }}

    @FXML
    private void splitreclam(ActionEvent event) { 
         
          try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("ReclamationFront.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           reclamid.getScene().setRoot(root);
        } catch (IOException ex) {
         //   Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    
    

