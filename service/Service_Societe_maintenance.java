/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entite.Societe_maintenance;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MaConnexion;


/**
 *
 * @author User
 */
public class Service_Societe_maintenance {
    
    
    Connection C = MaConnexion.getinstence().getcon();  
    
    
    public void AjouterSociete_maintenance(Societe_maintenance S)
    {
        try {  
               Statement st = C.createStatement();
            String query = "insert into societe_maintenance values("+S.ID_Societe+",'"+S.Nom+"','"+S.Adresse+"','"+S.Tel+"','"+S.Email+"')";
            st.executeUpdate(query);
            System.out.println("societe_maintenance ajouter");
        } catch (SQLException ex) {
            System.out.println("societe_maintenance -- Erreur ajout   --> : "+ ex.getMessage());
        }
    }
    
    
    public void afficheSociete_maintenance() throws SQLException{
        Statement st = C.createStatement();
          String Query ="select * from societe_maintenance";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
              System.out.println("societe_maintenance  ID_Societe :"+rs.getInt(1)+"   Nom   "+ rs.getString(2)+"   Adresse   "+rs.getString(3)
              +"   Tel   "+ rs.getInt(4)+"   Email   "+ rs.getString(5));
          }
    }
    
    
    
    public void modifierSociete_maintenance(Societe_maintenance S){
        
          try {  
            
            String query= "update societe_maintenance set Nom=? ,Adresse=?  ,Tel=?  ,Email=? where ID_Societe =? ;";
            PreparedStatement stmt= C.prepareStatement(query); 
            
            stmt.setString(1, S.getNom());
            stmt.setString(2,S.getAdresse());
             stmt.setInt(3,S.getTel());
              stmt.setString(4,S.getEmail());
              stmt.setInt(5,S.getID_Societe());
            
            stmt.executeUpdate();
            System.out.println("societe_maintenance modifier");
        } catch (SQLException ex) {
            System.out.println("societe_maintenance --Erreur Modifier :-->  " + ex.getMessage());
        }
    }
    
    
    
    
    
   public void supprimerSociete_maintenance(Societe_maintenance S){
        try {  
            String query = "delete from societe_maintenance where ID_Societe=?";
            PreparedStatement stmt=C.prepareStatement(query); 
            stmt.setInt(1,S.getID_Societe());
            stmt.executeUpdate();
            System.out.println("societe_maintenance supprimer avec succes ");
            
           
        } catch (SQLException ex) {
            System.out.println("societe_maintenance -- Erreur supprimer   !!: "+ ex.getMessage());
        }
    }
   
   
   
   public void rechercheSociete_maintenance(int id) throws SQLException{
        Statement st = C.createStatement();
          String Query ="SELECT * FROM societe_maintenance WHERE ID_Societe LIKE '"+id+"%' ";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
            System.out.println("societe_maintenance  ID_Societe :"+rs.getInt(1)+"   Nom   "+ rs.getString(2)+"   Adresse   "+rs.getString(3)
              +"   Tel   "+ rs.getInt(4)+"   Email   "+ rs.getString(5));
          }
    }
   
   
   
    
}
