/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.promotion;
import service.servicePromotion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.MaConnexion;

/**
 * FXML Controller class
 *
 * @author Amal
 */
public class AddPromotionController implements Initializable {

    @FXML
    private Label lblHeader;
    @FXML
     TextField titreIDl;
    private TextField nouveauPrixID;
    @FXML
    private Label lbAuteur;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbQteVente;
    @FXML
    private Label lbQteEmprunt;
    @FXML
    private Label lbTitre;
    @FXML
     TextField ancienPrixID;
    @FXML
    private DatePicker dateDebutID;
    @FXML
    private Label lbPhoto;
    @FXML
    private TableView<promotion> tableViewAffichArticle;
    @FXML
    private TextField rechercheCol;
    @FXML
     TextField libelleID;
    @FXML
    private DatePicker dateFinID;
    @FXML
    private TextField reductionID;
    @FXML
    private TableColumn<promotion, Integer> libelleCol;
    @FXML
    private TableColumn<promotion, String> titreCol;
    @FXML
    private TableColumn<promotion, Float> ancienprixCol;
    @FXML
    private TableColumn<promotion, Float> nouveauPrixCol;
    @FXML
    private TableColumn<promotion, Integer> reductionCol;
    @FXML
    private TableColumn<promotion, String> dateDebutCol;
    @FXML
    private TableColumn<promotion, String> dateFinCol;
    @FXML
    private Button btnAjouterCol;
    @FXML
    private Button btnAjouterCol2;
    @FXML
    private TableColumn<promotion,Integer> identifiant;
    @FXML
    private TextField EditID;
    @FXML
    private Label cntReduction;
    @FXML
    private Label cntrDatedeb;
    @FXML
    private Label cntrdates;
    @FXML
    private Label cntr;
    private Button Reclamationbtn;
    @FXML
    private Button promoid;
    @FXML
    private Button reclamid;
    @FXML
    private Button Resetid;
    @FXML
    private Button xlid; 
    @FXML
    private Button livreid;
    @FXML
    private TextField photoid;

    public TextField getTitreIDl() {
        return titreIDl;
    }

    public void setTitreIDl(String titre) {
        this.titreIDl.setText(titre);
    }

    public TextField getAncienPrixID() {
        return ancienPrixID;
    }

    public void setAncienPrixID(Float prix) {
        this.ancienPrixID.setText(""+prix);
    }

    public TextField getLibelleID() {
        return libelleID;
    }

    public void setLibelleID(int libelle) {
        this.libelleID.setText(""+libelle);
    }
    
    public TextField getPhoto() {
        return photoid;
    }

    public void setPhoto(String photo) {
        this.photoid.setText(photo);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         initCol();
         PromoSearch();
         EditID.setVisible(false);
         photoid.setVisible(false);
         Tooltip tExport = new Tooltip("Export to Excel");
        xlid.setTooltip(tExport); 
         
         
       

          
    }
     ObservableList <promotion> data = FXCollections.observableArrayList();
   
     

    @FXML
    private void btnAjouterOnAction(ActionEvent event) { 
        boolean b=saisie(); 
        if(b==true) 
        {
        Integer libelle = Integer.parseInt(libelleID.getText()) ; 
        String titre = titreIDl.getText() ; 
        String photo = photoid.getText() ; 
        Float ancienprix = Float.parseFloat(ancienPrixID.getText()) ; 
        Integer reduction = Integer.parseInt(reductionID.getText()) ; 
        String date_debut = dateDebutID.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String date_fin = dateFinID.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); 
 
        promotion p = new promotion(libelle,titre,ancienprix,reduction,date_debut,date_fin,photo);
        servicePromotion serviceDAO = new servicePromotion();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "confirmation d'ajout de promotion", ButtonType.OK);
        a.setTitle("Confirmation");
        a.showAndWait();
        if (a.getResult() == ButtonType.OK) {
        serviceDAO.addpromo(p);
        initCol(); 
        viderr();
        
        } 
        
        }

    } 
      
    public void initCol() {
        libelleCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        
        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        
        ancienprixCol.setCellValueFactory(new PropertyValueFactory<>("ancien_prix"));
        nouveauPrixCol.setCellValueFactory(new PropertyValueFactory<>("nouveau_prix"));
        reductionCol.setCellValueFactory(new PropertyValueFactory<>("reduction"));
        dateDebutCol.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        dateFinCol.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        identifiant.setCellValueFactory(new PropertyValueFactory<>("id"));
           servicePromotion ser = new servicePromotion() {};
           data = ser.lister();
           tableViewAffichArticle.setItems(data);
        
    } 
    
     

  

    
 
 private void PromoSearch() {FilteredList<promotion> filteredData = new FilteredList<>(data, e-> true);
        rechercheCol.setOnKeyReleased(e->{
        rechercheCol.textProperty().addListener((observableValue, oldValue, newValue) ->{
        filteredData.setPredicate((Predicate<? super promotion>) promo->{
         if (newValue ==null || newValue.isEmpty()){
         return true;
          }
             String lowerCaseFilter= newValue.toLowerCase();
             String red= newValue;
             
          if(promo.getTitre().toLowerCase().contains(lowerCaseFilter)){
            return true;   
             }
            else if(promo.getDate_fin().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
            else if(promo.getDate_debut().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
            else if(String.valueOf(promo.getReduction()).contains(newValue)){
            return true;   
                }
           
          
                return false; 
                 } );
                       } );
              SortedList<promotion> sortedData = new SortedList<>(filteredData);
             sortedData.comparatorProperty().bind(tableViewAffichArticle.comparatorProperty());
                   tableViewAffichArticle.setItems(sortedData);
                  });}
 
    


    @FXML
    private void Supprimer(ActionEvent event) { 
                   promotion selectedForUpdate = tableViewAffichArticle.getSelectionModel().getSelectedItem();
        if (selectedForUpdate==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selectionner une promotion");
            alert.setHeaderText("erreur de selection d'une promotion ");
            alert.setContentText("SVP selectioner une promotion ");
            Optional<ButtonType> result = alert.showAndWait();
            return ; 
        }
           promotion selectedForDeletion = tableViewAffichArticle.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression d'une promotion");
            //alert.setHeaderText("erreur de selection d'un livre ");
            alert.setContentText("Voulez vous vraiment supprimer cette promotion :"+selectedForDeletion.getTitre()+" ?");
            Optional<ButtonType> answer = alert.showAndWait();
            if (answer.get()==ButtonType.OK){
              servicePromotion ser=new servicePromotion();
                Boolean ok = ser.supprimer_promo(selectedForDeletion );  
                if (ok){
                    Alert alertConf = new Alert(Alert.AlertType.INFORMATION);
                    alertConf.setTitle("promotion supprimeé");
                    //alert.setHeaderText("erreur de selection d'un livre ");
                    alertConf.setContentText(selectedForDeletion.getTitre()+" est supprimeé avec succes");
                    Optional<ButtonType> rs = alertConf.showAndWait();
                    initCol();
                    
                    
                    
                }else{
                   Alert alertConf = new Alert(Alert.AlertType.INFORMATION);
                    alertConf.setTitle("Suppression echoueé");
                    //alert.setHeaderText("erreur de selection d'un livre ");
                    alertConf.setContentText(selectedForDeletion.getTitre()+" ne peut pas etre supprimeé");
                    Optional<ButtonType> rs = alertConf.showAndWait(); 
                }    
            }else{
                Alert alertConf = new Alert(Alert.AlertType.INFORMATION);
                alertConf.setTitle("Annulation de la suppression d'une promotion");
                //alert.setHeaderText("erreur de selection d'un livre ");
                alertConf.setContentText("Suppression annuleé");
                Optional<ButtonType> rs = alertConf.showAndWait();  
            }
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
         promotion selectedForUpdate = tableViewAffichArticle.getSelectionModel().getSelectedItem();  
        if (selectedForUpdate==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selectionner une promotion");
            alert.setHeaderText("erreur de selection d'une promotion ");
            alert.setContentText("SVP selectioner une promotion ");
            Optional<ButtonType> result = alert.showAndWait();
            return ; 
        }
        int id =selectedForUpdate.getId();
        int libelle =selectedForUpdate.getLibelle();
        String titre = selectedForUpdate.getTitre() ; 
        float prix = selectedForUpdate.getAncien_prix();
        int reduction = selectedForUpdate.getReduction();
        String date_deb = selectedForUpdate.getDate_debut();
        String date_fin = selectedForUpdate.getDate_fin();
       
       
        
        String IdStr=Integer.toString(id);
        String prixStr = Float.toString(prix);
        String libelleStr=Integer.toString(libelle);
        String reductionStr=Integer.toString(reduction);
       // Date datedeb=date_deb.to.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")
        EditID.setText(IdStr);
        libelleID.setText(libelleStr);
        libelleID.setDisable(true);
        titreIDl.setText(titre); 
        titreIDl.setDisable(true);
        ancienPrixID.setText(prixStr);
        ancienPrixID.setDisable(true);
        reductionID.setText(reductionStr);
        dateDebutID.setValue(LOCAL_DATE(date_deb));
        dateFinID.setValue(LOCAL_DATE(date_fin));
       
 
    } 
       public static final LocalDate LOCAL_DATE (String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    @FXML
    private void btnModif(ActionEvent event) { 
               promotion selectedForUpdate = tableViewAffichArticle.getSelectionModel().getSelectedItem();
        if (selectedForUpdate==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selectionner une promotion");
            alert.setHeaderText("erreur de selection d'une promotion ");
            alert.setContentText("SVP selectioner une promotion ");
            Optional<ButtonType> result = alert.showAndWait();
            return ; 
        } 
          boolean b=saisie(); 
        if(b==true) 
        {
       
          promotion p=new promotion(); 
          Integer id = Integer.parseInt(EditID.getText()) ; 
         p.setId(id);
         p.setReduction(Integer.parseInt(reductionID.getText()));
         p.setDate_debut((dateDebutID.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
         //p.setAncien_prix(Float.parse(ancienPrixID.getText())); 
         p.setDate_fin((dateFinID.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
         if(b==true) 
         {
             Alert a = new Alert(Alert.AlertType.INFORMATION, "confirmation de Modification de la promotion ", ButtonType.OK);
        a.setTitle("Confirmation");
        a.showAndWait();
        if (a.getResult() == ButtonType.OK) { 
            servicePromotion ser=new servicePromotion();
            ser.modifierpromo(p);
           tableViewAffichArticle.getItems().clear();
            initCol();
              viderr();
        }

        }   
         
         }
    
       
        
    }
    
    //reporting des données 

    private boolean saisie()  
    {
    boolean a=true;
       
        if(reductionID.getText().isEmpty())
          {
            cntReduction.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            cntReduction.setText("ce champ est obligatoire");
            a=false ;
        } 
        else{
                cntReduction.setStyle("-fx-font-size: 0px;");
                cntReduction.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                reductionID.setStyle("-fx-border-color: green ;");
       
        } 
     
        if(dateDebutID.getValue()==null) 
        {
          cntrDatedeb.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
          cntrDatedeb.setText("ce champ est obligatoire");
            a=false ;
        
        } 
             else{
                cntrDatedeb.setStyle("-fx-font-size: 0px;");
                cntrDatedeb.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                dateDebutID.setStyle("-fx-border-color: green ;");
        } 
        if(dateFinID.getValue()==null) 
        {
           cntrdates.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
          cntrdates.setText("ce champ est obligatoire");
            a=false ;
        
        
        } 
        else 
        {
         cntrdates.setStyle("-fx-font-size: 0px;");
                cntrdates.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                dateFinID.setStyle("-fx-border-color: green ;");
                
        
        } 
            if(Integer.parseInt(reductionID.getText())<0)
          {
            cntReduction.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            cntReduction.setText("saisir un nombre positif");
            a=false ;
        } 
        else{
                cntReduction.setStyle("-fx-font-size: 0px;");
                cntReduction.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                reductionID.setStyle("-fx-border-color: green ;");
        
        } 
             
                 if(((Integer.parseInt(reductionID.getText()))>90)||((Integer.parseInt(reductionID.getText()))<10))
          {
            cntReduction.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            cntReduction.setText("saisir un nombre entre 10% et 90%");
            a=false ;
        } 
        else{
                cntReduction.setStyle("-fx-font-size: 0px;");
                cntReduction.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                reductionID.setStyle("-fx-border-color: green ;");
        
        }
     //   if(!historyDate.after(todayDate) && !futureDate.before(todayDate)) {

        if(dateFinID.getValue().compareTo(dateDebutID.getValue()) <0) 
        { 
            cntr.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
          cntr.setText("date fin doit étre superieur a date début ");
            a=false ;
        
        
        }
        else 
        {
         cntr.setStyle("-fx-font-size: 0px;");
                cntr.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                dateFinID.setStyle("-fx-border-color: green ;");
                 dateDebutID.setStyle("-fx-border-color: green ;");
                
        
        } 
         
 
    return a; 
    } 
    
    private void viderr() 
    {
      libelleID.setText("");
          titreIDl.setText("");
          ancienPrixID.setText("");
          reductionID.setText(""); 
          dateDebutID.setValue(null); 
          dateFinID.setValue(null); 
          tableViewAffichArticle.getSelectionModel().clearSelection();
          cntReduction.setText(""); 
          cntr.setText(""); 
          cntrDatedeb.setText(""); 
          cntrdates.setText("");
          cntReduction.setStyle("-fx-font-size: 0px;");
          cntr.setStyle("-fx-font-size: 0px;");
          cntrdates.setStyle("-fx-font-size: 0px;");
          cntrDatedeb.setStyle("-fx-font-size: 0px;");
          libelleID.setDisable(false);
          titreIDl.setDisable(false);
          ancienPrixID.setDisable(false);
          reductionID.setStyle("-fx-border-color: 0px ;");
          dateDebutID.setStyle("-fx-border-color: 0px ;");
          dateFinID.setStyle("-fx-border-color: 0px ;");
          
    
    }

    
    private void Reclamation(ActionEvent event) {
         try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("Reclamation.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           Reclamationbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    private void Reset(ActionEvent event) { 
         libelleID.setText("");
          titreIDl.setText("");
          ancienPrixID.setText("");
          reductionID.setText(""); 
          dateDebutID.setValue(null); 
          dateFinID.setValue(null); 
          tableViewAffichArticle.getSelectionModel().clearSelection();
          cntReduction.setText(""); 
          cntr.setText(""); 
          cntrDatedeb.setText(""); 
          cntrdates.setText("");
          cntReduction.setStyle("-fx-font-size: 0px;");
          cntr.setStyle("-fx-font-size: 0px;");
          cntrdates.setStyle("-fx-font-size: 0px;");
          cntrDatedeb.setStyle("-fx-font-size: 0px;");
          libelleID.setDisable(false);
          titreIDl.setDisable(false);
          ancienPrixID.setDisable(false);
    
    } 
     private void saveXLSFile(File file) {
        try {
            //System.out.println("Clicked,waiting to export....");
            
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet workSheet = workbook.createSheet("sheet 0");
            
        workSheet.setColumnWidth(1, 25);

        HSSFFont fontBold = workbook.createFont();
        fontBold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        HSSFCellStyle styleBold = workbook.createCellStyle();
        styleBold.setFont(fontBold);
          
            Row row1 = workSheet.createRow((short) 0);
           workSheet.autoSizeColumn(7);
            row1.createCell(0).setCellValue("Id");
            row1.createCell(1).setCellValue("Isbn");
            row1.createCell(2).setCellValue("Titre");
            row1.createCell(3).setCellValue("Ancien prix TND");
            row1.createCell(4).setCellValue("");
            row1.createCell(5).setCellValue("Reduction%");
            row1.createCell(6).setCellValue("");
            row1.createCell(7).setCellValue("Nouveau prix TND"); 
            row1.createCell(8).setCellValue(""); 
            row1.createCell(9).setCellValue("Date début");
            row1.createCell(10).setCellValue("");
            
            row1.createCell(11).setCellValue("Date fin");
          
           
            Row row2;

            String req = "select * from promotion ";
            Connection  ds = MaConnexion.getinstence().getcon();
            Connection c = ds;
            PreparedStatement ps = c.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int a = rs.getRow();
                row2 = workSheet.createRow((short) a); 
               
                row2.createCell(0).setCellValue(rs.getInt(1));
                row2.createCell(1).setCellValue(rs.getInt(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getFloat(4));
                row2.createCell(5).setCellValue(rs.getInt(5));
                row2.createCell(7).setCellValue(rs.getFloat(6));
                row2.createCell(9).setCellValue(rs.getString(7));
                row2.createCell(11).setCellValue(rs.getString(8));
             
               
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();

            
            TrayNotification tn = new TrayNotification("NEW EXCEL FILE", "Specified excel file successfully generated", NotificationType.SUCCESS);
            tn.showAndWait();
        } catch (SQLException | IOException e) {
            TrayNotification tn = new TrayNotification("NEW EXCEL FILE", "Could not generate specified file", NotificationType.ERROR);
            tn.showAndWait();
            System.err.println(e);

        }
    }
        

    @FXML
    private void imprimerxl(ActionEvent event) {
                FileChooser chooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Excel Files(*.xls)", "*.xls");
        chooser.getExtensionFilters().add(filter);
        // Show save dialog
        File file = chooser.showSaveDialog(xlid.getScene().getWindow());
        if (file != null) {
            saveXLSFile(file);

        }
        
    } 
    
  /*  public TextField getReslibelle() {
        return libelleID;
    }
      public TextField getRestitre() {
        return titreIDl;
    } 
       public TextField getResPrix() {
        return ancienPrixID;
    } 
       
    public void setReslibelle(int libelle) {
        this.libelleID.setText(""+libelle);
    }

    public void setResTitre(String titre) {
        this.titreIDl.setText(titre);
    }

    public void setResPrix(Float prix) {
        this.ancienPrixID.setText(""+prix);
    }*/ 

    @FXML
    private void ConsulterLivre(ActionEvent event) { 
                try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLivre.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promoid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
   

}
    