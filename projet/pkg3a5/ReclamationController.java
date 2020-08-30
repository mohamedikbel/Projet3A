/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;


import entities.Reclamation;
import entities.promotion;
import static projet.pkg3a5.AddPromotionController.LOCAL_DATE;
import service.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Amal
 */
public class ReclamationController implements Initializable {

    @FXML
    private Label lblHeader;
    @FXML
    private TextField sujetID;
    @FXML
    private Label lbAuteur;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbQteVente;
    @FXML
    private Label lbQteEmprunt;
    @FXML
    private Label lbDateSortie;
    @FXML
    private Label lbTitre;
    @FXML
    private Label lbPhoto;
    @FXML
    private TableView<Reclamation> tableViewAffichArticle;
    @FXML
    private TableColumn<Reclamation, String> nomCol;
    @FXML
    private TableColumn<Reclamation, String> prenomCol;
    @FXML
    private TableColumn<Reclamation, String> MailCol;
    @FXML
    private TableColumn<Reclamation, String> DateCol;
    @FXML
    private TableColumn<Reclamation, String> ServiceCol;
    @FXML
    private TableColumn<Reclamation, String> MessageCol;
    @FXML
    private TableColumn<Reclamation, String> EtatCol;
    @FXML
    private TextField rechercheCol;
    @FXML
    private Button btnmail;
    @FXML
    private TextField mailID;
    @FXML
    private TextArea messageID;
    @FXML
    private MenuItem recupermailId;
    @FXML
    private MenuItem traiterId;
    @FXML
    private TableColumn<Reclamation,Integer> idreclam;
    @FXML
    private MenuItem deleteItem;
    @FXML
    private Button notif;
    @FXML
    private Button statistiquebtn;
    private Button btnPromotion;
    @FXML
    private Button promoid;
    @FXML
    private Button Reclamid;
  //  private int id_client=1; 
    @FXML
    private Button annulerid;
    @FXML
    private Label traiteid;
    @FXML
    private Label nonid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        ReclamSearch();
        affich_alert(); 
        ServiceReclamation ser=new ServiceReclamation();
        traiteid.setText(ser.nombrereclamtraitee()+" Réclamations Traitée");
        nonid.setText(ser.non_traitee()+" non Traitée");
        //notificationevent();
       // test();
       
        
    }
      ObservableList <Reclamation> data = FXCollections.observableArrayList();


    
        private void initCol() {
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        MailCol.setCellValueFactory(new PropertyValueFactory<>("messagerie_electronique"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("datee"));
        ServiceCol.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        MessageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        EtatCol.setCellValueFactory(new PropertyValueFactory<>("etat")); 
        idreclam.setCellValueFactory(new PropertyValueFactory<>("id"));

        
       ServiceReclamation  ser = new ServiceReclamation() {};
        
        data = ser.lister();
        tableViewAffichArticle.setItems(null);
        tableViewAffichArticle.setItems(data);
      
    }  
       /* private void notificationevent() 
        { 
        int b=0; 
        ServiceReclamation ser = new ServiceReclamation(); 
         b=ser.nombrereclamevent(); 
         if(b>=2) 
         {      
                 Notifications notificationBuilder=Notifications.create()
                .title("nouvelle notification")
                .text("le service evenement a atteintreclamations")
                .position(Pos.TOP_LEFT);
                 notificationBuilder.darkStyle();
        
                  notificationBuilder.showWarning();
                
      
         
         }
        }*/ 
    
        
        
       private void ReclamSearch() {FilteredList<Reclamation> filteredData = new FilteredList<>(data, e-> true);
        rechercheCol.setOnKeyReleased(e->{
        rechercheCol.textProperty().addListener((observableValue, oldValue, newValue) ->{
        filteredData.setPredicate((Predicate<? super Reclamation>) reclam->{
         if (newValue ==null || newValue.isEmpty()){
         return true;
          }
             String lowerCaseFilter= newValue.toLowerCase();
             String red= newValue;
             
          if(reclam.getNom().toLowerCase().contains(lowerCaseFilter)){
            return true;   
             }
            else if(reclam.getPrenom().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
            else if(reclam.getMessagerie_electronique().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
         else if(reclam.getSujet().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
           else if(reclam.getEtat().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
          else if(reclam.getDatee().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                }
          
                return false; 
                 } );
                       } );
              SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
             sortedData.comparatorProperty().bind(tableViewAffichArticle.comparatorProperty());
                   tableViewAffichArticle.setItems(sortedData);
                  });}

    @FXML
    private void recuperMaill(ActionEvent event) { 
          Reclamation selectedForUpdate = tableViewAffichArticle.getSelectionModel().getSelectedItem();
        if (selectedForUpdate==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selectionner une Réclamation");
            alert.setHeaderText("erreur de selection d'une Réclamation ");
            alert.setContentText("SVP selectioner une Réclamation ");
            Optional<ButtonType> result = alert.showAndWait();
            return ; 
        }
         
        
        
        String mail = selectedForUpdate.getMessagerie_electronique(); 
      
       ;
       
        
        mailID.setText(mail);
        
    }

    @FXML
    private void Traiter(ActionEvent event) { 
        
         Reclamation selectedForUpdate = tableViewAffichArticle.getSelectionModel().getSelectedItem();
          
            
           
              ServiceReclamation ser=new ServiceReclamation();
                 ser.updateetat(selectedForUpdate.getId() ); 
                    initCol();
                    
                    
                    
                
            
    }

    @FXML
    private void btnMail(ActionEvent event)  {
        
         try{
            String host ="smtp.gmail.com" ;
            String user = "CitedelaculturePI3a5@gmail.com";
            String pass = "amalamal";
            String to = "amal.khalfallah@esprit.tn";
            String from =mailID.getText();
            String subject =sujetID.getText();
            String messageText =messageID.getText();
          
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
            Alert alertConf = new Alert(Alert.AlertType.INFORMATION);
            alertConf.setTitle("Succés d'envoie");
                //alert.setHeaderText("erreur de selection d'un livre ");
            alertConf.setContentText("Succés d'envoie");  
            alertConf.show(); 
         }catch(Exception ex)
        {
            System.out.println(ex);
        }

        
        
        
    }

  
    @FXML
    private void Supprimer(ActionEvent event) { 
             Reclamation selectedForDeletion = tableViewAffichArticle.getSelectionModel().getSelectedItem();
        if (selectedForDeletion==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selectionner une Réclamation");
            alert.setHeaderText("erreur de selection");
            alert.setContentText("SVP selectioner une Réclamation ");
            Optional<ButtonType> result = alert.showAndWait();
            return ; 
        }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression d'une promotion");
            //alert.setHeaderText("erreur de selection d'un livre ");
            alert.setContentText("Voulez vous vraiment supprimer cette promotion :"+selectedForDeletion.getNom()+" ?");
            Optional<ButtonType> answer = alert.showAndWait();
            if (answer.get()==ButtonType.OK){
              ServiceReclamation ser=new ServiceReclamation();
                ser.supprimer_reclam(selectedForDeletion.getId());  
                
                    Alert alertConf = new Alert(Alert.AlertType.INFORMATION);
                    alertConf.setTitle("Réclamation supprimeé");
                    //alert.setHeaderText("erreur de selection d'un livre ");
                    alertConf.setContentText(selectedForDeletion.getNom()+" est supprimeé avec succes");
                    Optional<ButtonType> rs = alertConf.showAndWait();
                    initCol();
                }    
            else{
                Alert alertConf = new Alert(Alert.AlertType.INFORMATION);
                alertConf.setTitle("Annulation de la suppression de la Réclamation ");
                //alert.setHeaderText("erreur de selection d'un livre ");
                alertConf.setContentText("Suppression annuleé");
                Optional<ButtonType> rs = alertConf.showAndWait();  
            }
        
    }

    
    
    public void affich_alert(){
    
    
        int b=0; 
         int a=0;
        ServiceReclamation ser = new ServiceReclamation(); 
         b=ser.nombrereclamevent(); 
         a=ser.nombrereclamachat();
        if(b>=3) 
         { 
                TrayNotification tn = new TrayNotification("Notification","le service des Événements a atteint "+b+" réclamations", NotificationType.ERROR);
            tn.showAndWait();
      
         } 
        if(a>=3){
           TrayNotification tn = new TrayNotification("Notification","le service d'Achat a atteint "+a+" réclamations", NotificationType.ERROR);
            tn.showAndWait();
      
                    
        }
        
         else 
         {
         
            TrayNotification tn = new TrayNotification("NEW Notification", "vous navez pad des nouvelles notifications", NotificationType.SUCCESS);
            tn.showAndWait();
         
         
         }
    
    
    }
    
    
    
    @FXML
    private void notifbtn(ActionEvent event) { 
         int b=0; 
         int a=0;
        ServiceReclamation ser = new ServiceReclamation(); 
         b=ser.nombrereclamevent(); 
         a=ser.nombrereclamachat();
      
        if(b>=3) 
         { 
                TrayNotification tn = new TrayNotification("Notification","le service des Événements a atteint "+b+" réclamations", NotificationType.ERROR);
            tn.showAndWait();
      
         } 
        if(a>=3){
           TrayNotification tn = new TrayNotification("Notification","le service d'Achat a atteint "+a+" réclamations", NotificationType.ERROR);
            tn.showAndWait();
      
                    
        }
        
         else 
         {
         
            TrayNotification tn = new TrayNotification("Notification", "vous navez pad des nouvelles notifications", NotificationType.SUCCESS);
            tn.showAndWait();
         
         
         }
         
         }

    @FXML
    private void ViewChart(ActionEvent event) { 
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLPieChart.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    private void Promotion(ActionEvent event) { 
                try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("ajouterPromotion.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           btnPromotion.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SplitPromo(ActionEvent event) { 
                   try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("ajouterPromotion.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promoid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SplitReclam(ActionEvent event) { 
                        try {
              FXMLLoader loader=new FXMLLoader(getClass().getResource("Reclamation.fxml")); //charger le fichier xml taa affichage
            Parent root=loader.load();
           promoid.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Annuler(ActionEvent event) { 
        sujetID.setText("");
        mailID.setText(""); 
        messageID.setText("");
        
        
    }
    
}