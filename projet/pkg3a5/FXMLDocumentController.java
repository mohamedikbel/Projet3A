/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import java.io.ByteArrayOutputStream;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/**
 *
 * @author TOSHIBA
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private AnchorPane root;

    @FXML
    private Label label;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private TextField textname;

    @FXML
    private TextField textlastname;

    @FXML
    private TextField textpass;

    @FXML
    private TextField textemail;

    @FXML
    private TextField texttel;

    @FXML
    private Button button;
     @FXML
    private ImageView imgView;
    @FXML
    private Button imimpo;
    
    String fname;
    Stage stage;
 public static   byte[] pinsertimage=null;
    @FXML
    private Label nomcon;
    @FXML
    private Label prenomcon;
    @FXML
    private Label mailcon;
    @FXML
    private Label telcon;
    @FXML
    private Label imagecon;
    ControleSaisie  cont = new ControleSaisie();

    
     

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
               ClientDB  crud = new ClientDB();
               String uname= textname.getText();
               String lname= textlastname.getText();
               String pass= textpass.getText();
               String email= textemail.getText();
               String num= texttel.getText();
               String image= "aneeeeee";
               String code= "http://www.esprit.tn";
               String roles;
               roles = "user";
         try {if(!crud.exist(textemail.getText())&&cont.isUsername(textname.getText())&&cont.isUsername(textlastname.getText())&&cont.valiemail(textemail.getText())&&cont.isTel(texttel.getText())&&pinsertimage!=null)
         {  crud.sinscrire(uname, lname,pass,email, num, pinsertimage, code, roles);
         
         ((Node)event.getSource()).getScene().getWindow().hide();

         Parent p1 = FXMLLoader.load(getClass().getResource("userlogin.fxml"));
          Scene test1 = new Scene(p1);
          Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
          App1.setScene(test1);
          App1.show();
         
         
         
         }
         
         else{ Notifications NotificationBuilder = Notifications.create()
                    .title("error")
                    .text("verifier vos champs ")
                    .graphic(null)
                    .hideAfter(Duration.seconds(8))
                    .position(Pos.CENTER);
            NotificationBuilder.showError();}
         
         
         
         } catch (SQLException ex) {
             //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        /*   Notifications NotificationBuilder = Notifications.create()
                    .title("error")
                    .text("vous etes inscrits ")
                    .graphic(null)
                    .hideAfter(Duration.seconds(8))
                    .position(Pos.TOP_LEFT);
            NotificationBuilder.showError();*/

    }
    
     @FXML
    private void ImageButtonAction(ActionEvent event) throws IOException {
             FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
           fc.getExtensionFilters().addAll(ext1,ext2);
           File file = fc.showOpenDialog(stage);
          
               BufferedImage bf;
            try {
                bf = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bf, null);
                imgView.setImage(image);
                FileInputStream fin = new FileInputStream(file);
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for(int readnum; (readnum=fin.read(buf)) !=-1;)
            {            
                baos.write(buf,0,readnum);                
            }
            
              pinsertimage=baos.toByteArray();
    }
    catch (IOException ex) {
            }}
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         textname.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(cont.isUsername(textname.getText()))
           {textname.setStyle("-fx-border-color: green");
           nomcon.setText("");
            
       }
            else{ nomcon.setStyle("-fx-skin-color: red");

            nomcon.setText("LE NOM NE DOIT PAS CONTENIR DES CHIFFRES");}
        });
         
          textlastname.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(cont.isUsername(textlastname.getText()))
           {textlastname.setStyle("-fx-border-color: green");
           prenomcon.setText("");
            
       }
            else{ prenomcon.setStyle("-fx-skin-color: red");

            prenomcon.setText("LE   PrenomNOM NE DOIT PAS CONTENIR DES CHIFFRES");}
        });
          
                    textemail.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(cont.valiemail(textemail.getText()))
           {textemail.setStyle("-fx-border-color: green");
           mailcon.setText("");
            
       }
            else{ mailcon.setStyle("-fx-skin-color: red");

            mailcon.setText("L adrese mail doit etre sous la forme expl@exple.com");}
        });

                           texttel.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(cont.isTel(texttel.getText()))
           {texttel.setStyle("-fx-border-color: green");
           telcon.setText("");
            
       }
            else{ telcon.setStyle("-fx-skin-color: red");

            telcon.setText("Le numero doit contenir 8 chiffres");}
        });
        // TODO
    }    

  
    
}
