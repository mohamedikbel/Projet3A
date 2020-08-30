

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.pkg3a5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.MaterielsDB;
import Entite.Materiels;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.function.Predicate;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

import utils.MaConnexion;
import java.text.*;
import java.awt.print.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javafx.print.PageLayout;
import javafx.print.Printer;
/**
 * FXML Controller class
 *
 * @author PC
 */
public class FXML3Controller implements Initializable {
ObservableList<Materiels> data=FXCollections.observableArrayList();



	FilteredList<Materiels> filteredData=new FilteredList<>(data,e->true);
	
    @FXML
    private TextField nomMat;
    @FXML
    private TextField QutMat;
    @FXML
    private TextField lieuMat;
    @FXML
    private Button Ajoutee;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private TableView<Materiels> table_Mat;
    
    @FXML
    private TableColumn<Materiels, String> nomCol;
    @FXML
    private TableColumn<Materiels, Integer> quantiteeCol;
    @FXML
    private TableColumn<Materiels, String> lieuCol;
     @FXML
    private TableColumn<Materiels, String> etat_Col;

    @FXML
    private ComboBox<String> etat_mat;
    @FXML
    private Button exp_col;
   
        ObservableList<String> list = FXCollections.observableArrayList("disponible","nondisponible");
   
@FXML
    private TextField rechercheCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      MaterielsDB  crud = new    MaterielsDB ();
         
 
       
     //from entity
     nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
     quantiteeCol.setCellValueFactory(new PropertyValueFactory<>("quantitee"));
     lieuCol.setCellValueFactory(new PropertyValueFactory<>("lieu")); 
etat_Col.setCellValueFactory(new PropertyValueFactory<>("etat")); 
   table_Mat.setItems(crud.affichersalles()); // TODO
       
        etat_mat.setItems(list);
  
    } 
   
    @FXML
    private void ajouterMat(ActionEvent event) {
         Materiels M;
        M = new  Materiels(0,nomMat.getText(),Integer.parseInt(QutMat.getText()),lieuMat.getText(),etat_mat.getValue());
     
      MaterielsDB  crud = new    MaterielsDB ();
        crud.ajoutersalles(M); 
         table_Mat.setItems(crud.affichersalles());
        
    }
    

    @FXML
    private void ModifierMat(ActionEvent event) {
       
         Materiels M;
         M = new  Materiels(0,nomMat.getText(),Integer.parseInt(QutMat.getText()),lieuMat.getText(),etat_mat.getValue());
              MaterielsDB  crud = new    MaterielsDB ();
        crud.Modifier_salle(M); 
         table_Mat.setItems(crud.affichersalles());
    }

    @FXML
    private void SupprimerMat(ActionEvent event) {
           MaterielsDB  crud = new    MaterielsDB ();
            Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation Dialog");
alert.setHeaderText("Look, a Confirmation Dialog");
alert.setContentText("Are you ok with this?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    // ... user chose OK
} else {
    // ... user chose CANCEL or closed the dialog
}
        crud.delete_Salles(table_Mat.getSelectionModel().getSelectedItem());
         table_Mat.setItems(crud.affichersalles()); //Affichage après suppression
      
    }

   

   

  
    

      @FXML
    void excel_mat(ActionEvent event) {
    

            }
    
  @FXML
   public void clique_mouse() {   
try
		{
			Materiels salles=(Materiels) table_Mat.getSelectionModel().getSelectedItem();
			String query="select * from materiels ";
		 Connection  C  = MaConnexion.getinstence().getcon(); 
     
     
     
            Statement st = C.createStatement();
         
       
            nomMat.setText(salles.getNom());
            String str = ""+salles.getQuantitee();
         QutMat.setText(str);
         
            lieuMat.setText(salles.getLieu());
               
	   etat_mat.setValue(salles.getEtat());
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
		
         
    }
/*    private void PromoSearch() 
                             {FilteredList<Materiels> filteredData = new FilteredList<>(data, e-> true);
        rechercheCol.setOnKeyReleased(e->{
        rechercheCol.textProperty().addListener((observableValue, oldValue, newValue) ->{
        filteredData.setPredicate((Predicate<? super Materiels>) promo->{
         if (newValue ==null || newValue.isEmpty()){
         return true;
          }
             String lowerCaseFilter= newValue.toLowerCase();
             String red= newValue;
             
          if(promo.getNom().toLowerCase().contains(lowerCaseFilter)){
            return true;   
             }
           else if(String.valueOf(promo.getQuantitee()).contains(newValue)){
            return true;   
                }
            else if(promo.getLieu().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
            else if(promo.getEtat().toLowerCase().contains(lowerCaseFilter)){
            return true;   
                } 
            
           
          
                return false; 
                 } );
                       } );
              SortedList<Materiels> sortedData = new SortedList<>(filteredData);
             sortedData.comparatorProperty().bind(  table_Mat.comparatorProperty());
                  table_Mat.setItems(sortedData);
                  });}*/
    
  @FXML
	public void searchUser()
	{
		rechercheCol.textProperty().addListener((observableValue,oldValue,newValue)->{
			filteredData.setPredicate((Predicate<? super Materiels>)user->{
				if(newValue==null||newValue.isEmpty()){
					return true;
				}
				String lowerCaseFilter=newValue.toLowerCase();
				if(user.getNom().toLowerCase().contains(lowerCaseFilter)){
					return true;
				}
				
                                else return false;
			});
		});
		SortedList<Materiels> sortedData=new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(table_Mat.comparatorProperty());
		table_Mat.setItems(sortedData);
	}
  
  
}