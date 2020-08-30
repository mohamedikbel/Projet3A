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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.Z;
import service.ClientDB;

/**
 * FXML Controller class
 *
 * @author Amal
 */
public class ReclamationFrontController implements Initializable {

    @FXML
    private TextField txnom;
    @FXML
    private TextField txprenom;
    @FXML
    private TextArea txtmessage;
    @FXML
    private TextField txmail;
    @FXML
    private ComboBox<String> comboboxser;
    @FXML
    private Button envoyerid;
    @FXML
    private Label cntnom;
    @FXML
    private Label cntprenom;
    @FXML
    private Label cntrEmail;
    @FXML
    private Label cntrservice;
    @FXML
    private Label messageid;
    private static int id_client; 
    

    public static void setId_client(int id_client) {
        ReclamationFrontController.id_client = id_client;
        
    } 
    
    public static int  getId_client() {
       return  ReclamationFrontController.id_client;
        
    }
    
    private static String name; 
    private static String prenomm;
    @FXML
    private Button promoid;
    @FXML
    private Button vosreclamid;

    /**
     * Initializes the controller class.
     */            String usr =Client.getCurrentuser();
    ClientDB cl =new ClientDB();
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
     

            ClientDB cl =new  ClientDB() ;
            String nom;
        try {
            nom = cl.userfname(usr);
           System.out.println("ikbelllll"+nom);
             txnom.setText(nom);

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
            String prenom;
        try {
            prenom = cl.userlname(usr);
            txprenom.setText(prenom);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setId_client(cl.userid(usr));
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            // TODO
            ObservableList<String> list = FXCollections.observableArrayList("Événement","Achat");
            comboboxser.setItems(list);
       
            
           
        
  
        
    }    
     ObservableList <Reclamation> data = FXCollections.observableArrayList();
      private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
      private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private Matcher matcher;

    @FXML
    private void ajoutereclam(ActionEvent event) throws SQLException { 
         boolean b=saisie(); 
         if(b==true) 
         {
          ClientDB cl =new  ClientDB() ;

         ReclamationFrontController.setId_client(cl.userid(usr));
             
        String nom =txnom.getText();
        String prenom =txprenom.getText(); 
        String mail=txmail.getText(); 
        String message=txtmessage.getText();
        String service=comboboxser.getValue();
        int client= ReclamationFrontController.getId_client();
        
        Reclamation p = new Reclamation(nom, prenom, mail, service, message,client);
        ServiceReclamation reclam = new ServiceReclamation();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "confirmation d'envoie de votre reclamation", ButtonType.OK);
        a.setTitle("Confirmation");
        a.showAndWait();
        if (a.getResult() == ButtonType.OK) {
        reclam.ajouter_reclam(p);
        viderr();
        
        }}}  
        
    private void viderr() 
    {
      txnom.setText("");
          txprenom.setText("");
          txtmessage.setText("");
          txmail.setText(""); 
          comboboxser.setValue(null); 
         
         
          cntnom.setText(""); 
          cntprenom.setText(""); 
          cntrEmail.setText(""); 
          cntrservice.setText("");
          messageid.setText("");
          cntnom.setStyle("-fx-font-size: 0px;");
          cntprenom.setStyle("-fx-font-size: 0px;");
          cntrEmail.setStyle("-fx-font-size: 0px;");
          cntrservice.setStyle("-fx-font-size: 0px;");
          messageid.setStyle("-fx-font-size: 0px;"); 
          txnom.setStyle("-fx-border-color: 0px ;");  
          txprenom.setStyle("-fx-border-color: 0px ;"); 
          txmail.setStyle("-fx-border-color: 0px ;"); 
          txtmessage.setStyle("-fx-border-color: 0px ;");  
          
    
    } 
    private boolean saisie() 
    {
     boolean a=true;
       
        if(txnom.getText().isEmpty())
          {
            cntnom.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            cntnom.setText("ce champ est obligatoire");
            a=false ;
        } 
        else{
                cntnom.setStyle("-fx-font-size: 0px;");
                cntnom.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                txnom.setStyle("-fx-border-color: green ;");
       
        } 
         
              if(txprenom.getText().isEmpty())
          {
            cntprenom.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            cntprenom.setText("ce champ est obligatoire");
            a=false ;
        } 
        else{
                cntprenom.setStyle("-fx-font-size: 0px;");
                cntprenom.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                txprenom.setStyle("-fx-border-color: green ;");
       
        } 
                  if(txmail.getText().isEmpty())
          {
            cntrEmail.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            cntrEmail.setText("ce champ est obligatoire");
            a=false ;
        } 
        else{
                cntrEmail.setStyle("-fx-font-size: 0px;");
                cntrEmail.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                txmail.setStyle("-fx-border-color: green ;");
       
        } 
                  
                    if(comboboxser.getValue()==null)
          {
            cntrservice.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            cntrservice.setText("ce champ est obligatoire");
            a=false ;
        } 
        else{
                cntrservice.setStyle("-fx-font-size: 0px;");
                cntrservice.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                comboboxser.setStyle("-fx-border-color: green ;");
       
        }  
                          if(txtmessage.getText().isEmpty())
          {
            messageid.setStyle("-fx-text-fill: red; -fx-font-size: 12px;-fx-border-color: red ;");
            messageid.setText("ce champ est obligatoire");
            a=false ;
        } 
        else{
                messageid.setStyle("-fx-font-size: 0px;");
                messageid.setText(""); 
                ////METTRE LE BORDURE DE TEXTE FIELD EN VERT 
                txtmessage.setStyle("-fx-border-color: green ;");
       
        } 
         

	// static Pattern object, since pattern is fixed
	
   if(!txmail.getText().isEmpty())
   {
	
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	

		matcher = pattern.matcher(txmail.getText());
		if((matcher.matches()==false))
                {
                  Alert b = new Alert(Alert.AlertType.ERROR, "veuillez saisir un email valide", ButtonType.OK);
        b.setTitle("Email");
        b.showAndWait();
            txmail.setStyle("-fx-border-color: red ;");
        a=false; 
                } 
                else 
                {
                  txmail.setStyle("-fx-border-color: green ;");
                }
   
   }
       
	
                   
         
                
     
         
		
	    	
                 
                     
                        
    
       
         
                        
                        
                        
                        
		
	  
   
         return a; 
         
    
    
    
    
    
    
    }

    @FXML
    private void splitpromo(ActionEvent event) {
    
          try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("Promotionclient.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promoid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void splitVosReclam(ActionEvent event) { 
          try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLVosReclam.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promoid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }
    

