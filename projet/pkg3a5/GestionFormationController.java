/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import entities.Formation;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static projet.pkg3a5.FXMLDocumentController.pinsertimage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import service.FormationDB;
/**
 * FXML Controller class
 *
 * @author TOSHIBA
 */
public class GestionFormationController implements Initializable {
 public static   byte[] pinsertimage=null;
   Stage stage;


    @FXML
    private Button btn_ajouter;
    @FXML
    private Button image_path;
    @FXML
    private TextField titre;
    @FXML
    private TextArea desc;
    @FXML
    private ComboBox<String> form;
    @FXML
    private DatePicker date;
    @FXML
    private ImageView img;
    @FXML
    private Button modifier_btn;
    @FXML
    private Button newimage;
    @FXML
    private TextField heure_par;
    @FXML
    private TextField minute_par;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> titret;
    @FXML
    private TableColumn<?, ?> descrit;
    @FXML
    private TableColumn<?, ?> formt;
    @FXML
    private TableColumn<?, ?> nbplace;
    @FXML
    private TableColumn<?, ?> datet;
    private ObservableList<Formation> l;
    @FXML
    private TableView<Formation> tableform;
    @FXML
    private TextField forrech;
    @FXML
    private TextField titre1;
    @FXML
    private TextArea desc1;
    @FXML
    private ComboBox<String> form1;
    @FXML
    private DatePicker date1;
    @FXML
    private TextField titre11;


    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        tableform.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
   
    titre1.setText(tableform.getSelectionModel().getSelectedItem().getTitre());
        desc1.setText(tableform.getSelectionModel().getSelectedItem().getDesc());
       // form1.setSelectionModel(tableform.getSelectionModel());
});
     
try {
         FormationDB forma = new FormationDB();
         l = FXCollections.observableArrayList();
         
         l = FXCollections.observableArrayList(forma.getall());
         
               id.setCellValueFactory(new PropertyValueFactory<>("id"));
               titret.setCellValueFactory(new PropertyValueFactory<>("titre"));
               descrit.setCellValueFactory(new PropertyValueFactory<>("desc"));
               formt.setCellValueFactory(new PropertyValueFactory<>("formateur"));
               nbplace.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
               datet.setCellValueFactory(new PropertyValueFactory<>("date"));
               tableform.setItems(l);

         
         
         
         
         
         form.setItems(FXCollections.observableArrayList(
                 "Ikbel sdiri",
                 "Mehdi Dellegi",
                 "Mlayeh Mohamed"
                 
         ));
         // TODO
     } catch (SQLException ex) {
         Logger.getLogger(GestionFormationController.class.getName()).log(Level.SEVERE, null, ex);
     }
     
         forrech.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                try {
                                FormationDB  cr = new FormationDB();

                    l = FXCollections.observableArrayList(cr.getalldyn(forrech.getText()));
                    tableform.setItems(l);

                    tableform.refresh();
                } catch (SQLException ex) {
                    Logger.getLogger(GestionDeClientController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
    }    

    @FXML
    private void ajouterformation(ActionEvent event) throws SQLException {
        
        Formation f =new Formation();
        FormationDB fo =new FormationDB();
        f.setTitre(titre.getText());
        f.setDesc(desc.getText());
        f.setFormateur((String)form.getValue());
        f.setImage(pinsertimage);
         DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         String datee=(date.getValue()).format(formatter_1);
         f.setDate(datee);
         fo.ajouter(f);
        Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Formation Ajouter");
alert.setHeaderText(null);
alert.setContentText("I have a great message for you!");

alert.showAndWait();

        
        
    }

    @FXML
    private void getpathbutton(ActionEvent event) throws IOException {
        
        
          FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
           fc.getExtensionFilters().addAll(ext1,ext2);
           File file = fc.showOpenDialog(stage);
          
               BufferedImage bf;
          
                bf = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bf, null);
                img.setImage(image);
                FileInputStream fin = new FileInputStream(file);
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for(int readnum; (readnum=fin.read(buf)) !=-1;)
            {            
                baos.write(buf,0,readnum);                
            }
            
              pinsertimage=baos.toByteArray();
    }

    @FXML
    private void modifier_formation(ActionEvent event) {
    }

    @FXML
    private void modif_path(ActionEvent event) {
    }

    @FXML
    private void suuprimer_formation(ActionEvent event) {
    }

    @FXML
    private void modifier(KeyEvent event) {
        
        titre1.setText(tableform.getSelectionModel().getSelectedItem().getTitre());
        desc1.setText(tableform.getSelectionModel().getSelectedItem().getDesc());
        //form1.setSelectionModel(((String))tableform.getSelectionModel().getSelectedItem().getFormateur());
        //date1.setValue(tableform.getSelectionModel().getSelectedItem().getDate().tod);
       // nbplace.setText(Integer.parseInt(tableform.getSelectionModel().getSelectedItem().get));
   
    
    }}