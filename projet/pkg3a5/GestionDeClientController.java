/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import com.sun.javafx.scene.input.ExtendedInputMethodRequests;
import entities.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ClientDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.controlsfx.control.textfield.TextFields;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static jdk.nashorn.internal.objects.NativeJava.to;
//import static projet.pkg3a5.Mailing.sendMail;
import projet.pkg3a5.clientaf;


/**
 * FXML Controller class
 *
 * @author TOSHIBA
 */
public class GestionDeClientController implements Initializable {
    //private  data ;

    @FXML
    private TableView<clientaf> clienttab;
    @FXML
    private TableColumn colmail;
    @FXML
    private TableColumn nom;
    @FXML
    private TableColumn prenom;
       private ObservableList<clientaf> l;
    @FXML
    private TextField search;
    @FXML
    private TableColumn<?, ?> supprimer;
    @FXML
    private TableColumn<?, ?> qr;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            
            ClientDB  crud = new ClientDB();
            
            
            l = FXCollections.observableArrayList();
            
            l = FXCollections.observableArrayList(crud.getall());
            
            
            
            
            
            
            
            search.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                try {
                                ClientDB  cr = new ClientDB();

                    l = FXCollections.observableArrayList(cr.getalldyn(search.getText()));
                    clienttab.setItems(l);

                    clienttab.refresh();
                } catch (SQLException ex) {
                    Logger.getLogger(GestionDeClientController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            
            
            
            try {
                String ah="ahmed";
                
                List<String> list = crud.getauto();
                TextFields.bindAutoCompletion(search,list);
                
                
                
                
                
                
                for (int i = 0; i < l.size (); i++)
                    
                {l.get(i).getButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    
                    
                    public void handle(ActionEvent event) {
                        String selectedItems = clienttab.getSelectionModel().getSelectedItem().getEmail();
                        System.out.println(selectedItems);
                        crud.delete(selectedItems);
                        String[] to ={selectedItems};

                       // Mailing m=new Mailing();
                      //  m.sendMail("tataouineup1@gmail.com","Tataouineup123@","Compte suspendu","Votre compte a été suuprimé . Merci ",to);
                        
                        clienttab.refresh();
                        
                    }
                    
                    
                    
                });
                
                l.get(i).getQr().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    
                    
                    public void handle(ActionEvent event) {
                        try {                     //   Mailing m=new Mailing();

                            String selectedItems = clienttab.getSelectionModel().getSelectedItem().getEmail();
                            System.out.println(selectedItems);
                            Document document = new Document();
                            PdfWriter writer = null;
                                 String[] to ={selectedItems};

                                writer = PdfWriter.getInstance(document, new FileOutputStream("car.pdf"));
                               document.open();
                            PdfContentByte cb = writer.getDirectContent();
                            BarcodeQRCode barcodeQRCode = new BarcodeQRCode("https://memorynotfound.com", 1000, 1000, null);
                             Image codeQrImage = barcodeQRCode.getImage();
                            codeQrImage.scaleAbsolute(100, 100);
                             document.add(codeQrImage);
                             document.close();
                            //  m.sendMailAtt("tataouineup1@gmail.com","Tataouineup123@","Code Qr","Voici votre carte QR ",to,"car.pdf");

                        
                    }   catch (FileNotFoundException ex) {
                            Logger.getLogger(GestionDeClientController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
                            Logger.getLogger(GestionDeClientController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                    }
                });
                
                
                }
                
                
                
                
                nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                colmail.setCellValueFactory(new PropertyValueFactory<>("email"));
                supprimer.setCellValueFactory(new PropertyValueFactory<>("button"));
                qr.setCellValueFactory(new PropertyValueFactory<>("qr"));

                
                System.out.print(crud.getall().get(0));
                
                
                
                
                
                //clienttab.getItems().clear();
                clienttab.setItems(l);
                  clienttab.refresh();

            } catch (SQLException ex) {
                Logger.getLogger(GestionDeClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                    
          
}
    
    
    
     public void deletebutton(ActionEvent event){  
        String s =null;
        String selectedItems = clienttab.getSelectionModel().getSelectedItem().getEmail();
        System.out.println(selectedItems);}
     

}