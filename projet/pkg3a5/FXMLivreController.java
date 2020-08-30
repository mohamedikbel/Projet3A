/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.livre;
import service.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Amal
 */
public class FXMLivreController implements Initializable {

    @FXML
    private TableColumn<livre,Integer> libelle_col;
    @FXML
    private TableColumn<livre,String> titre_col;
    @FXML
    private TableColumn<livre, Float> prix_col;
    @FXML
    private TableColumn<livre,String> resume_col;
    @FXML
    private TableColumn<livre,String> photo_col;
    @FXML
    private TableColumn<livre,String> categorie_col;
    @FXML
    private TableColumn<livre,String> auteur_col;
    @FXML
    private TableColumn<livre,Integer> qt_col;
    @FXML
    private TableView<livre> tableee;
         ObservableList <livre> data = FXCollections.observableArrayList();
    @FXML
    private MenuItem promotionid;
    @FXML
    private TextField txlbelle;
    @FXML
    private TextField txtitre;
    @FXML
    private TextField txprix;
    @FXML
    private Button promo;
    @FXML
    private Button promoid;
    @FXML
    private Button reclamid;
    @FXML
    private Label lblHeader;
    @FXML
    private TextField txphoto;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol(); 
           txphoto.setVisible(false);
        // TODO
    }  

     
       private void initCol() {
        libelle_col.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        titre_col.setCellValueFactory(new PropertyValueFactory<>("titre"));
        photo_col.setCellValueFactory(new PropertyValueFactory<>("photo"));
        auteur_col.setCellValueFactory(new PropertyValueFactory<>("nom_auteur"));
        categorie_col.setCellValueFactory(new PropertyValueFactory<>("nom_categorie"));
        qt_col.setCellValueFactory(new PropertyValueFactory<>("qte_vente"));
        prix_col.setCellValueFactory(new PropertyValueFactory<>("prix"));
        resume_col.setCellValueFactory(new PropertyValueFactory<>("resume"));
        ServiceLivre ser = new ServiceLivre() {};
               data = ser.DisplayBooksList();
           tableee.setItems(data);
    
    }

    @FXML
    private void promotionbtn(ActionEvent event) { 
           livre selectedForPromo = tableee.getSelectionModel().getSelectedItem();  
        if (selectedForPromo==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selectionner une promotion");
            alert.setHeaderText("erreur de selection d'une promotion ");
            alert.setContentText("SVP selectioner une promotion ");
            Optional<ButtonType> result = alert.showAndWait();
            return ; 
        }
         
        String libelleStr=Integer.toString(selectedForPromo.getLibelle());
        String prixStr = Float.toString(selectedForPromo.getPrix());
   
      
       
          txlbelle.setText(libelleStr);
          txtitre.setText(selectedForPromo.getTitre());
          txprix.setText(prixStr);
          txphoto.setText(selectedForPromo.getPhoto());
    }

    @FXML
    private void SplitPromotion(ActionEvent event) { 
     
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ajouterPromotion.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load(); //charginah en tant que parent
            AddPromotionController irc=loader.getController(); //instance mel controller jdid bech naadiouhom lel interface jdida
            irc.setLibelleID(Integer.parseInt(txlbelle.getText())); //naadihom lel interface jdida 
            irc.libelleID.setDisable(true);
               
            irc.setTitreIDl(txtitre.getText()); 
            irc.titreIDl.setDisable(true);
            irc.setAncienPrixID(Float.parseFloat(txprix.getText())); 
            irc.ancienPrixID.setDisable(true);
            irc.setPhoto(txphoto.getText());
         
            promo.getScene().setRoot(root); //au hasard recuperer la scene et on a modifier le parent le nouveau parent
        } catch (IOException ex) {
            Logger.getLogger(FXMLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
    }

    @FXML
    private void promo(ActionEvent event) { 
                try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("ajouterPromotion.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promoid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void splitReclam(ActionEvent event) { 
           try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("Reclamation.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           reclamid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
