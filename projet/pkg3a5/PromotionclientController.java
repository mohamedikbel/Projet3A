/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.promotion;
import service.servicePromotion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Amal
 */
public class PromotionclientController implements Initializable {

    @FXML
    private Label lblHeader;
    @FXML
    private TableColumn<promotion,String> TitreCol;
    @FXML
    private TableColumn<promotion,Float> Ancien_prixCol;
    @FXML
    private TableColumn<promotion,Integer> ReductionCol;
    @FXML
    private TableColumn<promotion, Float> nouveau_prixCol;
    @FXML
    private TableColumn<promotion, String> datedebCol;
    @FXML
    private TableColumn<promotion, String> datefinCol;
    @FXML
    private TableColumn<promotion, Integer> IsbnCol;
     ObservableList <promotion> data = FXCollections.observableArrayList();
    @FXML
    private TableView<promotion> tableee;
    @FXML
    private Label TitreId;
    @FXML
    private Label reductionid;
    @FXML
    private Label ancien_prixid;
    @FXML
    private Label nouveau_prixid;
    @FXML
    private Label datedebid;
    @FXML
    private Label datefinid;
    @FXML
    private ImageView imgid;
    @FXML
    private TableColumn<?, ?> photoid;
    @FXML
    private Button reclamid;
    @FXML
    private Label lblHeader11;
    @FXML
    private Label lblHeader111;
    @FXML
    private Label lblHeader1111;
    @FXML
    private Label lblHeader11111;
    @FXML
    private Label lblHeader11112;
    @FXML
    private Label lblHeader11113;
    @FXML
    private Label lblHeader12;
    @FXML
    private Label nbid;
    @FXML
    private Label lblHeader1;
    @FXML
    private Label lblHeader13;
    @FXML
    private Button consulter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicePromotion ser=new servicePromotion(); 
        ser.client_promoautoo();
        initCol(); 
         nbid.setText("Nous avons "+ser.nombrepromo()+" livres en promotions");
        
         PromoData();
        
       
        // TODO
    }   
        public void initCol() {
        IsbnCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        TitreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        Ancien_prixCol.setCellValueFactory(new PropertyValueFactory<>("ancien_prix"));
        ReductionCol.setCellValueFactory(new PropertyValueFactory<>("nouveau_prix"));
        nouveau_prixCol.setCellValueFactory(new PropertyValueFactory<>("reduction"));
        datedebCol.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        datefinCol.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
         datefinCol.setCellValueFactory(new PropertyValueFactory<>("photo"));
      
           servicePromotion ser = new servicePromotion() {};
           data = ser.lister_client();
           tableee.setItems(data);
        
    } 
        
      private void PromoData() {
        tableee.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends promotion> observable,
                promotion oldValue,
                promotion newValue) -> {
            if (newValue == null) {
              //  editID = 0;
               
                TitreId.setText(null);
                imgid.setImage(null);
                reductionid.setText(null);
                ancien_prixid.setText(null);
                nouveau_prixid.setText(null);
                datedebid.setText(null);
                datefinid.setText(null);
               // test.setText(null);
                
                return;
            }
                     
               
           //    String date = .getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
              TitreId.setText(newValue.getTitre());  
             
             reductionid.setText(String.valueOf(newValue.getReduction()));
             ancien_prixid.setText(String.valueOf(newValue.getAncien_prix())); 
             nouveau_prixid.setText(String.valueOf(newValue.getNouveau_prix())); 
             datedebid.setText(newValue.getDate_debut()); 
             datefinid.setText(newValue.getDate_fin());
              //prix.setText(String.valueOf(newValue.getReference_produit()));
              
      //..\..\..\..\..\Desktop\_RC\cellrenderer\blank.jpg
      
        Image img = new Image("file:///C://Users//TOSHIBA//Pictures//photo/"+newValue.getPhoto()) ;
        System.out.println("file:///C:\\Users\\TOSHIBA\\Pictures\\photo"+newValue.getPhoto());
        imgid.setImage(img);
      
           
        });
    }

    @FXML
    private void splitReclam(ActionEvent event) { 
        
          try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("ReclamationFront.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           reclamid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SplitVos(ActionEvent event) { 
            try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLVosReclam.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           consulter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
