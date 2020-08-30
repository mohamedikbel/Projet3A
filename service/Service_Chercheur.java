/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entite.Chercheur;
import entite.Collections;
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
public class Service_Chercheur {
    
    
    
    
    Connection C = MaConnexion.getinstence().getcon();  
    
    
    public void AjouterChercheur(Chercheur CH)
    {
        try {  
               Statement st = C.createStatement();
            String query = "insert into chercheur values("+CH.ID_Chercheur+
                    ",'"+CH.Nom_ch+"','"+CH.Prenom_ch+"','"+CH.Tel_ch+"','"+CH.Email_ch+"'"
                    + ",'"+CH.Cin_ch+"','"+CH.Niveau_E+"','"+CH.ID_Demande+"')";
            st.executeUpdate(query);
            System.out.println("Chercheur ajouter");
        } catch (SQLException ex) {
            System.out.println("Chercheur --- Erreur ajout   --> : "+ ex.getMessage());
        }
    }
    
    public void afficheChercheur() throws SQLException{
        Statement st = C.createStatement();
          String Query ="select * from chercheur";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
              System.out.println("chercheur ID_Chercheur :"+rs.getInt(1)+"   Nom_ch   "+ rs.getString(2)
              +"   Prenom_ch   "+rs.getString(3)
              +"   Tel_ch   "+rs.getInt(4)
              +"   Email_ch   "+rs.getString(5)
              +"   Cin_ch   "+rs.getInt(6)
              +"   Niveau_E   "+rs.getString(7)
              +"   ID_Demande   "+rs.getInt(8)
              );
          }
    }
    
    
    
    public void modifierchercheur(Chercheur CH){
        
          try {  
String query= "update chercheur set   Nom_ch=?,Prenom_ch=? ,Tel_ch=? ,Email_ch=? ,Cin_ch=?  ,Niveau_E=? ,ID_Demande=?  where ID_Chercheur =? ;";
            PreparedStatement stmt= C.prepareStatement(query); 
           
            stmt.setString(1, CH.getNom_ch());
            stmt.setString(2,CH.getPrenom_ch());
             stmt.setInt(3,CH.getTel_ch());
              stmt.setString(4,CH.getEmail_ch());
               stmt.setInt(5,CH.getCin_ch());
                stmt.setString(6,CH.getNiveau_E());
                 stmt.setInt(7,CH.getID_Demande());
                 stmt.setInt(8,CH.getID_Chercheur());
            stmt.executeUpdate();
            System.out.println("Chercheur  modifier");
        } catch (SQLException ex) {
            System.out.println(" Chercheur --  Erreur Modofier :-->  " + ex.getMessage());
        }
    }
    
    
    
    
    
   public void supprimerChercheur(Chercheur CH){
        try {  
            String query = "delete from chercheur where ID_Chercheur=?";
            PreparedStatement stmt=C.prepareStatement(query); 
            stmt.setInt(1,CH.getID_Chercheur());
            stmt.executeUpdate();
            System.out.println("Chercheur supprimer avec succes ");
            
           
        } catch (SQLException ex) {
            System.out.println("Chercheur -- Erreur supprimer   !!: "+ ex.getMessage());
        }
    }
   
   
   
   public void rechercheChercheur(int id) throws SQLException{
        Statement st = C.createStatement();
          String Query ="SELECT * FROM chercheur WHERE ID_Chercheur LIKE '"+id+"%' ";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
           System.out.println("chercheur ID_Chercheur :"+rs.getInt(1)+"   Nom_ch   "+ rs.getString(2)
              +"   Prenom_ch   "+rs.getString(3)
              +"   Tel_ch   "+rs.getInt(4)
              +"   Email_ch   "+rs.getString(5)
              +"   Cin_ch   "+rs.getInt(6)
              +"   Niveau_E   "+rs.getString(7)
              +"   ID_Demande   "+rs.getInt(8)
              );
             
    }
   
   
   
   
    
}
