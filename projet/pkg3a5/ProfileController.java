/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.Client;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static projet.pkg3a5.FXMLDocumentController.pinsertimage;
import service.ClientDB;

/**
 * FXML Controller class
 *
 * @author TOSHIBA
 */
public class ProfileController implements Initializable {

    @FXML
    private Circle impro;
    @FXML
    private TextField username;
    @FXML
    private TextField usermail;
    @FXML
    private Button modif;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField pass1;
    @FXML
    private Button save;
    @FXML
    private TextField username1;
    @FXML
    private AnchorPane photo;
        Stage stage;
    @FXML
    private Button phot;
     public static   byte[] pinsertimage=null;

    public static void setPinsertimage(byte[] pinsertimage) {
        ProfileController.pinsertimage = pinsertimage;
    }



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            
            ClientDB  crud = new ClientDB();
            String usr =Client.getCurrentuser();
            System.out.println(Client.getCurrentuser());
            
            try {
                impro.setFill(new ImagePattern(crud.userimage(usr)));
                
                
                // TODO
            } catch (SQLException ex) {
                //Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            username.setText(crud.userfname(usr));
            username1.setText(crud.userlname(usr));
            pass.setText(crud.userpass(usr));
            pass1.setText(crud.usertel(usr));
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }    

    @FXML
    private void onclickediteur(ActionEvent event) {
        
        username.setEditable(true);
        username1.setEditable(true);
        usermail.setEditable(true);
        pass.setEditable(true);
        pass1.setEditable(true);
        save.setVisible(true);
        save.setDisable(false);
        phot.setVisible(true);
       phot.setDisable(false);


        
        
    }

    @FXML
    private void modif(ActionEvent event) {
        
         ClientDB  crud = new ClientDB();
         String cur=usermail.getText();
         crud.Modifier(username.getText(), username1.getText(),usermail.getText(), pass.getText(),pass1.getText(),cur,pinsertimage);

        username.setEditable(false);
        username1.setEditable(false);
        usermail.setEditable(false);
        pass.setEditable(false);
        pass1.setEditable(false);
        save.setVisible(false);
        save.setDisable(true);
    }

    @FXML
    private void modifphoto(ActionEvent event) throws IOException {
        
         FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
           fc.getExtensionFilters().addAll(ext1,ext2);
           File file = fc.showOpenDialog(stage);
          
               BufferedImage bf;
          
                bf = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bf, null);
                impro.setFill(new ImagePattern(image));
                FileInputStream fin = new FileInputStream(file);
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for(int readnum; (readnum=fin.read(buf)) !=-1;)
            {            
                baos.write(buf,0,readnum);                
            }
            
              pinsertimage=baos.toByteArray();
              setPinsertimage(baos.toByteArray());
        
        
        
    }

    @FXML
    private void btnClientetFormation(ActionEvent event) {
    }

    @FXML
    private void btnEvent(ActionEvent event) {
    }

    @FXML
    private void btnBiblio(ActionEvent event) {
    }

    @FXML
    private void btnMusee(ActionEvent event) {
    }

    @FXML
    private void btnEspace(ActionEvent event) {
    }

    @FXML
    private void brnReclamationetpromotions(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Promotionclient.fxml"));
        
        Scene scene = new Scene(root);
        //stage.setTitle("S'INSCRIRE");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    
}
