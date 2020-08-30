/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Demande_cher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.MaConnexion;

/**
 *
 * @author User
 */
public class Service_Demande_cher {
    
    

    
    Connection C = MaConnexion.getinstence().getcon();  
    
    
    public void AjouterDemande_cher(Demande_cher D)
    {
        try {  
               Statement st = C.createStatement();
            String query = "insert into demande_cher values("+D.ID_Demande+
                    ",'"+D.Discription+"','"+D.Nom_ch+"','"+D.Prenom_ch+"','"+D.Tel_ch+"'"
                    + ",'"+D.Email_ch+"','"+D.Cin_ch+"','"+D.Etat+"','"+D.Date_demande+"','"+D.Niveau_E+"','"+D.ID_Collection+"')";
            st.executeUpdate(query);
            System.out.println("Demande_cher ajouter");
        } catch (SQLException ex) {
            System.out.println("Demande_cher --- Erreur ajout   --> : "+ ex.getMessage());
        }
    }
    
    public void afficheDemande_cher() throws SQLException{
        Statement st = C.createStatement();
          String Query ="select * from demande_cher ";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
              System.out.println("demande_chercheur   ID_Demande :"+rs.getInt(1)+"   Discription   "+ rs.getString(2)
              +"   Nom_ch   "+rs.getString(3)
              +"   Prenom_ch   "+rs.getString(4)
              +"   Tel_ch   "+rs.getInt(5)
              +"   Email_ch   "+rs.getString(6)
              +"   Cin_ch   "+rs.getInt(7)
              +"   Etat   "+rs.getString(8)
              +"   Date_demande   "+rs.getDate(9)
              +"   Niveau_E   "+rs.getString(10)
              +"   ID_Collection   "+rs.getInt(11));
          }
    }
    
    
    
    public void modifierDemande_cher(Demande_cher  D){
        
          try {  
String query= "update demande_cher set  Discription=?,Nom_ch=? ,Prenom_ch=? ,Tel_ch=? ,Email_ch=? ,Cin_ch=? ,Etat=? ,Date_demande=?,Niveau_E=?   ,ID_Collection=?    where ID_Demande =? ;";
            PreparedStatement stmt= C.prepareStatement(query); 
            
            stmt.setString(1,D.getDiscription());
            stmt.setString(2,D.getNom_ch());
             stmt.setString(3,D.getPrenom_ch());
              stmt.setInt(4,D.getTel_ch());
               stmt.setString(5,D.getEmail_ch());
                stmt.setInt(6,D.getCin_ch());
                 stmt.setString(7,D.getEtat());
                  stmt.setDate(8,D.getDate_demande());
                  stmt.setString(9,D.getNiveau_E());
                  stmt.setInt(10,D.getID_Collection());
                  stmt.setInt(11,D.getID_Demande());
            stmt.executeUpdate();
            System.out.println(" Demande_cher modifier");
        } catch (SQLException ex) {
            System.out.println(" Demande_cher --  Erreur Modofier :-->  " + ex.getMessage());
        }
    }
    
    
    
    
    
   public void supprimerDemande_cher(Demande_cher  D){
        try {  
            String query = "delete from demande_cher where ID_Demande=?";
            PreparedStatement stmt=C.prepareStatement(query); 
            stmt.setInt(1,D.getID_Demande());
            stmt.executeUpdate();
            System.out.println("Demande_cher supprimer avec succes ");
            
           
        } catch (SQLException ex) {
            System.out.println("Demande_cher -- Erreur supprimer   !!: "+ ex.getMessage());
        }
    }
   
   
   
   public void rechercheDemande_cher(int id) throws SQLException{
        Statement st = C.createStatement();
          String Query ="SELECT * FROM demande_cher WHERE ID_Demande LIKE '"+id+"%' ";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
               System.out.println("demande_chercheur   ID_Demande :"+rs.getInt(1)+"   Discription   "+ rs.getString(2)
              +"   Nom_ch   "+rs.getString(3)
              +"   Prenom_ch   "+rs.getString(4)
              +"   Tel_ch   "+rs.getInt(5)
              +"   Email_ch   "+rs.getString(6)
              +"   Cin_ch   "+rs.getInt(7)
              +"   Etat   "+rs.getString(8)
              +"   Date_demande   "+rs.getDate(9)
              +"   Niveau_E   "+rs.getString(10)
              +"   ID_Collection   "+rs.getInt(11));
          }
    }
   
   
   
   
   
   
    
    
    
    
    
    
    
}
