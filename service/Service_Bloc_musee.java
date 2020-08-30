/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author User
 */


import entite.Bloc_musee;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MaConnexion;

public class Service_Bloc_musee {
    
    
    
    Connection C = MaConnexion.getinstence().getcon();  
    
    
    public void AjouterBloc_Musee(Bloc_musee B)
    {
        try {  
               Statement st = C.createStatement();
            String query = "insert into bloc_musee values("+B.ID_M+",'"+B.Nom_Musee_bloc+"')";
            st.executeUpdate(query);
            System.out.println("Bloc Musee est Ajouté    ");
        } catch (SQLException ex) {
            System.out.println("Bloc musee -- Erreur Ajout   --> :  "+ ex.getMessage());
        }
    }
    
    
    public void afficheBloc_Musee() throws SQLException{
        Statement st = C.createStatement();
          String Query ="select * from bloc_musee ";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
              System.out.println("bloc_musee ID_bloc : "+rs.getInt(1)+"   nom_Bloc   "+ rs.getString(2));
          }
    }
    
    
    
    public void modifierBloc_Musee(Bloc_musee B){
        
          try {  
            
            String query= "update bloc_musee set Nom_Musee_Bloc=? where ID_M =? ;";
            PreparedStatement stmt= C.prepareStatement(query); 
             stmt.setString(1, B.getNom_Musee_bloc());
    
            stmt.setInt(2,B.getID_M());
           
            stmt.executeUpdate();
            System.out.println("Bloc_Musee modifier");
        } catch (SQLException ex) {
            System.out.println(" Bloc_Musee-- Erreur Modifier :-->  " + ex.getMessage());
        }
    }
    
    
    
    
    
   public void supprimerBloc_Musee(Bloc_musee B){
        try {  
            String query = "delete from bloc_musee where ID_M=?";
            PreparedStatement stmt=C.prepareStatement(query); 
            stmt.setInt(1,B.getID_M());
            stmt.executeUpdate();
            System.out.println("bloc_musee supprimer avec succes ");
            
           
        } catch (SQLException ex) {
            System.out.println("bloc_musee -- Erreur supprimer   !!: "+ ex.getMessage());
        }
    }
   
   
   
   public void rechercheBloc_Musee(int Id) throws SQLException{
        Statement st = C.createStatement();
          String Query ="SELECT * FROM bloc_musee WHERE ID_M LIKE '"+Id+"%' ";
          ResultSet rs = st.executeQuery(Query);
          while (rs.next())
          {
              System.out.println("bloc_musee ID_bloc : "+rs.getInt(1)+"   nom_Bloc   "+ rs.getString(2));
          }
    }
    
}
