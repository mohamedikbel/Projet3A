/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.Collections;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MaConnexion;

/**
 *
 * @author User
 */
public class Service_Collections {
    
    
    
    Connection C = MaConnexion.getinstence().getcon();  
    
    
    public void AjouterCollections(Collections Co)
    {
        try {  
               Statement st = C.createStatement();
         
            String query = "insert into collections values("+Co.ID_Collection+",'"+Co.Nom+"','"+Co.Image_C+"','"+Co.Discription+"','"+Co.Date_debut_M+"','"+Co.Date_fin_M+"','"+Co.Type+"','"+Co.ID_Societe+"','"+Co.ID_M+"')";
            st.executeUpdate(query);
            st.executeUpdate(query);
            System.out.println("collections ajouter");
        } catch (SQLException ex) {
            System.out.println("collections --- Erreur ajout   --> : "+ ex.getMessage());
        }
    }
    
    public void afficheCollections() throws SQLException{
        Statement st = C.createStatement();
          String Query ="select * from collections";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
              System.out.println("collection ID_Collection :"+rs.getInt(1)+"   Nom   "+ rs.getString(2)
              +"   Image_C   "+rs.getString(3)
              +"   Discription   "+rs.getString(4)
              +"   Date_debut_M   "+rs.getDate(5)
              +"   Date_fin_M   "+rs.getDate(6)
              +"   Type   "+rs.getString(7)
              +"   ID_Societe   "+rs.getInt(8)
              +"   ID_M   "+rs.getInt(9));
          }
    }
    
    
    
    public void modiffierCollections(Collections Co){
        
          try {  
String query= "update collections set Nom=?,Image_C=? ,Discription=? ,Date_debut_M=? ,Date_fin_M=?  ,Type=? ,ID_Societe=? ,ID_M=?   where ID_Collection =? ;";
            PreparedStatement stmt= C.prepareStatement(query); 
           
            stmt.setString(1, Co.getNom());
            stmt.setString(2,Co.getImage_C());
             stmt.setString(3,Co.getDiscription());
              stmt.setDate(4,Co.getDate_debut_M());
               stmt.setDate(5,Co.getDate_fin_M());
                stmt.setString(6,Co.getType());
                 stmt.setInt(7,Co.getID_Societe());
                  stmt.setInt(8,Co.getID_M());
                   stmt.setInt(9,Co.getID_Collection());
            stmt.executeUpdate();
            System.out.println("Collections modifier");
        } catch (SQLException ex) {
            System.out.println(" Collections --  Erreur Modofier :-->  " + ex.getMessage());
        }
    }
    
    
    
    
    
   public void supprimerCollections(Collections Co){
        try {  
            String query = "delete from collections where ID_Collection=?";
            PreparedStatement stmt=C.prepareStatement(query); 
            stmt.setInt(1,Co.getID_Collection());
            stmt.executeUpdate();
            System.out.println("Collections supprimer avec succes ");
            
           
        } catch (SQLException ex) {
            System.out.println("Collections -- Erreur supprimer   !!: "+ ex.getMessage());
        }
    }
   
   
   
   public void rechercheP(int id) throws SQLException{
        Statement st = C.createStatement();
          String Query ="SELECT * FROM collections WHERE ID_Collection LIKE '"+id+"%' ";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
                System.out.println("collection ID_Collection :"+rs.getInt(1)+"   Nom   "+ rs.getString(2)
              +"   Image_C   "+rs.getString(3)
              +"   Discription   "+rs.getString(4)
              +"   Date_debut_M   "+rs.getDate(5)
              +"   Date_fin_M   "+rs.getDate(6)
              +"   Type   "+rs.getString(7)
              +"   ID_Societe   "+rs.getInt(8)
              +"   ID_M   "+rs.getInt(9));
          }
    }
   
   
   
   
   
   
    
    
    
    
    
    
}
