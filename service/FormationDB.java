/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import projet.pkg3a5.BCrypt;
import utils.MaConnexion;
import entities.Formation;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import projet.pkg3a5.clientaf;
/**
 *
 * @author TOSHIBA
 */
public class FormationDB {
    
    
    
            Connection  C  = MaConnexion.getinstence().getcon();

    
     public void ajouter(Formation f) throws SQLException
     {
        Connection  C  = MaConnexion.getinstence().getcon();

       
            
             try {
            PreparedStatement pst = C.prepareStatement("insert into formation(titre,descri,formateur,date,image) values (?,?,?,?,?)");

            pst.setString(1,f.getTitre());
            pst.setString(2,f.getDesc());
            pst.setString(3,f.getFormateur());
            pst.setString(4,f.getDate());
            pst.setBytes(5,f.getImage());

           

            pst.executeUpdate();
             
             
             }

          
                    
                    
                    catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    
         

     public ObservableList<Formation> getall() throws SQLException
     {Connection  C  = MaConnexion.getinstence().getcon();

           ObservableList<Formation> data= FXCollections.observableArrayList();
            PreparedStatement pst = C.prepareStatement("Select *from formation");
          
            ResultSet rs = pst.executeQuery();    
               while(rs.next()){
                
                
                

                
                    Formation ft = new Formation();
                    ft.setId(rs.getInt(1));
                    ft.setTitre(rs.getString(2));
                    ft.setDesc(rs.getString(3));
                    ft.setFormateur(rs.getString(4));
                    ft.setNbplace(rs.getInt(5));
                    ft.setDate(rs.getString(6));
                    
                     data.add(ft);
               }
               
    return data;}
    
    
    
    
    
    
     public ObservableList<Formation> getalldyn(String titre)  throws SQLException
     {Connection  C  = MaConnexion.getinstence().getcon();

           ObservableList<Formation> data= FXCollections.observableArrayList();
            PreparedStatement pst = C.prepareStatement("Select *from formation WHERE titre LIKE ?");
                       pst.setString(1, titre + "%");

            ResultSet rs = pst.executeQuery();    
               while(rs.next()){
                
                
                

                
                    Formation ft = new Formation();
                    ft.setId(rs.getInt(1));
                    ft.setTitre(rs.getString(2));
                    ft.setDesc(rs.getString(3));
                    ft.setFormateur(rs.getString(4));
                    ft.setNbplace(rs.getInt(5));
                    ft.setDate(rs.getString(6));
                    
                     data.add(ft);
               }
               
    return data;}
    
    
    
    
    
    
    
    
    
}
