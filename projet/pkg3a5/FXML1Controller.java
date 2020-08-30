/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import Entite.Salles;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import service.SallesDB;
import utils.MaConnexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;


import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class FXML1Controller implements Initializable {
	ObservableList<Salles> data=FXCollections.observableArrayList();

 
    private FileChooser fileChooser;
    private File file2;

    @FXML
    private TextField numero;

    @FXML
    private TextField nom;

    @FXML
    private TextField capacitee;

    @FXML
    private TextField superficie;

    @FXML
    private Button btnAjouterCol;

    @FXML
    private Button btnModifierCol;

    @FXML
    private Button btnSupprimerCol;

    @FXML
    private TextField rechercheCol;

    @FXML
    private TableView<Salles> tv_espaces_table;

    @FXML
    private TableColumn<Salles, Integer> numeroCol;

    @FXML
    private TableColumn<Salles, String> nomCol;

    @FXML
    private TableColumn<Salles, Integer> capaciteeCol;

    @FXML
    private TableColumn<Salles, Integer> superficieCol;

    @FXML
    private TableColumn<Salles, Integer> etageCol;

    @FXML
    private TableColumn<Salles, String> disponibiliteCOL;

    @FXML
    private TableColumn<Salles, String> ImageCOL;

    @FXML
    private TextField etage;

    @FXML
    private ComboBox<String> disponibilitee;

    @FXML
    private ImageView imgVw;
      


    @FXML
    private Button load;

    @FXML
    private TextField path;

   
      ObservableList<String> list = FXCollections.observableArrayList("disponible","nondisponible");
      
        @FXML
    private Button updateImageid;

     @FXML
    private Label erreur;
  
  @FXML
    private Label caractere;
    @FXML
    private Label veification;
     @FXML
    private Label saisie_lab;
  
    /**
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     SallesDB  crud = new   SallesDB ();
 
 
      
       
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("numero")); //from entity
     nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
     capaciteeCol.setCellValueFactory(new PropertyValueFactory<>("capacitee"));
      superficieCol.setCellValueFactory(new PropertyValueFactory<>("superficie")); //from entity
    etageCol.setCellValueFactory(new PropertyValueFactory<>("etage"));
     disponibiliteCOL.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));
     ImageCOL.setCellValueFactory(new PropertyValueFactory<>("path"));
  	
        
 tv_espaces_table.setItems(crud.affichersalles());  // TODO
   disponibilitee.setItems(list);
  
  	
      service.SallesDB cs=new SallesDB(); 
      InputStream input = cs.getPhoto(1);
     Image image = new Image(input);
      
  imgVw.setImage(image);
        
    }

 
	
    
      

    @FXML
    private void AjouterEspaces(ActionEvent event) {
            Salles S;
        S = new Salles(Integer.parseInt(numero.getText()),nom.getText(),Integer.parseInt(capacitee.getText()),Integer.parseInt(superficie.getText()),Integer.parseInt(etage.getText()),disponibilitee.getValue(),path.getText(),null);
        service.SallesDB cs=new SallesDB(); 
   boolean b = cs.isANumber(numero.getText());
   if (b == false){
      System.out.println("afficher "+b);
            erreur.setTextFill(Color.TOMATO);
            erreur.setText("des entier : Check");
        } else {
            erreur.setTextFill(Color.GREEN);
            erreur.setText(" : Good to go");
        }
   
     boolean c = cs.isANumber(capacitee.getText());
   if (c == false){
      System.out.println("afficher "+c);
           caractere.setTextFill(Color.TOMATO);
            caractere.setText("des entiers : Check");
        } else {
         
        }
   
   
   
    boolean e = cs.isANumber(etage.getText());
   if (e == false){
      System.out.println("afficher "+e);
        veification.setTextFill(Color.TOMATO);
            veification.setText("des entiers : Check");
        } else {
           veification.setTextFill(Color.GREEN);
           veification.setText(" : Good to go");
        }
   boolean f = cs.isANumber(superficie.getText());
   if (f == false){
      System.out.println("afficher "+f);
    saisie_lab.setTextFill(Color.TOMATO);
           saisie_lab.setText("des entiers : Check");
        } else {
       saisie_lab.setTextFill(Color.GREEN);
         saisie_lab.setText(" : Good to go");
        }
   

  // erreur.setText("il faut ajouter des chifrres !!");
   
      cs.ajoutersalles(S); 
          tv_espaces_table.setItems(cs.affichersalles());
     
        
     
   
	
        
    

         
        
    }
    

    @FXML
    private void ModifierEspaces(ActionEvent event) {
           Salles S;
        S = new Salles(Integer.parseInt(numero.getText()),nom.getText(),Integer.parseInt(capacitee.getText()),Integer.parseInt(superficie.getText()),Integer.parseInt(etage.getText()),disponibilitee.getValue(),imgVw.toString(),null);
        service.SallesDB ser=new SallesDB(); 
        ser.Modifier_salle(S); 
         tv_espaces_table.setItems(ser.affichersalles());
          
    }

    @FXML
    private void SupprimerEspaces(ActionEvent event) {
            SallesDB cs = new SallesDB();
            Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation Dialog");
alert.setHeaderText("Look, a Confirmation Dialog");
alert.setContentText("you are sure to delete");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    // ... user chose OK
} else {
    // ... user chose CANCEL or closed the dialog
}
        cs.delete_Salles(tv_espaces_table.getSelectionModel().getSelectedItem());
        tv_espaces_table.setItems(cs.affichersalles()); //Affichage après suppression
   
    }

   

  

   

  

  
   


    
      @FXML
    void rechercheparNon(ActionEvent  event) {
 
        service.SallesDB cs=new SallesDB(); 
           cs.afficherOrder();
        tv_espaces_table.setItems(cs.affichersalles()); //Affichage 
}
    
  
	private void PromoSearch() {FilteredList<Salles> filteredData = new FilteredList<>(data, e-> true);
        rechercheCol.setOnKeyReleased(e->{
        rechercheCol.textProperty().addListener((observableValue, oldValue, newValue) ->{
        filteredData.setPredicate((Predicate<? super Salles>) promo->{
         if (newValue ==null || newValue.isEmpty()){
         return true;
          }
             String lowerCaseFilter= newValue.toLowerCase();
             String red= newValue;
             
          if(promo.getNom().toLowerCase().contains(lowerCaseFilter)){
            return true;   
             }
           
              
          if(promo.getDisponibilite().toLowerCase().contains(lowerCaseFilter)){
            return true;   
             }
                
           
          
                return false; 
                 } );
                       } );
              SortedList<Salles> sortedData = new SortedList<>(filteredData);
             sortedData.comparatorProperty().bind( tv_espaces_table.comparatorProperty());
                 tv_espaces_table.setItems(sortedData);
                  });}
         
    @FXML
	public void showOnClick()
	{
    
     try
		{
			Salles salles=(Salles)tv_espaces_table.getSelectionModel().getSelectedItem();
			String query="select * from salles";
		 Connection  C  = MaConnexion.getinstence().getcon(); 
     
     
     
            Statement st = C.createStatement();
         
         String str = ""+salles.getNumero();
         numero.setText(str);
            
            nom.setText(salles.getNom());
             String str2 = ""+salles.getCapacitee();
        capacitee.setText(str2);
             String str3 = ""+salles.getSuperficie();
    superficie.setText(str3);
      String str4 = ""+salles.getEtage();
    etage.setText(str4);
            
	    disponibilitee.setValue(salles.getDisponibilite());
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
			
		
			
    
}
 
    @FXML
    void processUpload(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
                     FileChooser.ExtensionFilter exjpg = new FileChooser.ExtensionFilter("JPG files (.jpg)", ".JPG");
                     FileChooser.ExtensionFilter exjpg2 = new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg");
                     FileChooser.ExtensionFilter expng = new FileChooser.ExtensionFilter("PNG files (.png)", ".PNG");
                     fileChooser.getExtensionFilters().addAll(exjpg,exjpg2, expng);
                     fileChooser.setTitle("Choose an image File");

                     File file = fileChooser.showOpenDialog(null);
                     
                             if (file != null) {
            if (file.length() < 6000000) {
                System.out.print("Condition ok");
                
                ImageView image1 = new ImageView (file.toURI().toString() ); 
                javafx.scene.image.Image img = null;
                                imgVw.setImage(img);
                                imgVw.setFitHeight(150);
                                imgVw.setFitWidth(150);
                               
                                path.setText("C:\\wamp64\\www\\"+file.getName());
                              //  name.setText(file.getName());
                               
                                 
      
                                
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Permiss");
                alert.setHeaderText("Permission denied");
                alert.setContentText("Your Image file is too big to upload \nplease choise another image");
            }


            }

    }
 @FXML
    private void PDF_open(ActionEvent event) throws FileNotFoundException, DocumentException{
       Salles s =   tv_espaces_table.getSelectionModel().getSelectedItem();
            int CurrentSelected = s.getNumero();
           
       System.out.println("CurrentSelected "+CurrentSelected+"  s.getNumero()) "+ s.getNumero());
             
        Document document = new Document() ;
          
          

    
    
        PdfWriter.getInstance(document, new FileOutputStream(new File ("avis.pdf")));
        document.open();
        SallesDB c = new SallesDB();
        document.add(new Paragraph(c.afficher_contrat_id(CurrentSelected)));
        document.close();
        
}
  @FXML
    void Mouse_click_updateImage(MouseEvent event) {
   SallesDB  crud = new   SallesDB ();
  
        if (event.getSource() == updateImageid) {
            //login here
            System.out.println("cliiiiiiiiiiiiiiick");
               //add you loading or delays - ;-)
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
            fileChooser = new FileChooser();
            //fis = new FileInputStream(file);
            fileChooser.getExtensionFilters().addAll(
                   // new FileChooser.ExtensionFilter("Text Files","*txt"),
                    new FileChooser.ExtensionFilter("Image Files","*.png","*.gif","*.jpg")
                  //  new FileChooser.ExtensionFilter("Audio Files","*wav","*.mp3","*.aac"),
                    //new FileChooser.ExtensionFilter("All Files","*.*")
            );
            updateImageid.setFont(Font.font("Sanserif",15));
            updateImageid.setOnAction(e -> {
                 file2 = fileChooser.showOpenDialog( stage.getScene().getWindow());
                try {
                    FileInputStream fin = new FileInputStream(file2);
                    int len = (int)file2.length();
                    //desktop.open(file);
                   //filePath= file.getAbsolutePath();
                   //System.out.println(filePath);
                   crud.UpdatePhoto(1,fin,len);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
               
            });
              
        }
    }

   
}