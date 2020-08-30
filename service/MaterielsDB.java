/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entite.Materiels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnexion;

/**
 *
 * @author PC
 */
public class MaterielsDB {
    Connection  C  = MaConnexion.getinstence().getcon(); 
     
     
     public void ajoutersalles(Materiels M){
    
        try {
            Statement st = C.createStatement();
            String query = "insert into materiels values("+M.id+",'"+M.nom+"','"+M.quantitee+"','"+M.lieu+"','"+M.etat+"')";
            
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
   public ObservableList<Materiels> affichersalles(){
        ObservableList data = FXCollections.observableArrayList();
        
        try {
            Statement st = C.createStatement();
            String str = "SELECT * FROM materiels";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
            System.out.println("Salles : "+rs.getInt(1)
                    +" | "+rs.getString(2)
                    +" | "+rs.getInt(3)
                    +" | "+rs.getString(4) 
                    +" | "+rs.getString(5));
                    
              data.add(new Materiels(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
            }    
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de l'affichage " + ex.getMessage());
        }      
        return data;
    }
       
        
        
    
    
     public void delete_Salles(Materiels M) {

     
String requete = "delete from materiels where nom = ?";
        try {
            PreparedStatement ps = C.prepareStatement(requete);
            ps.setInt(1,M.getId());
            ps.executeUpdate();
            System.out.println("Materiels supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    
     }
    
   
    public void Modifier_salle(Materiels M) {
   
 PreparedStatement ps ;
          String requete = "update materiels SET quantitee = ?,lieu = ? where  nom =?";
              
            try {
                ps = C.prepareStatement(requete);

                ps.setInt(1, M.getQuantitee());
                ps.setString(2, M.getLieu());
                ps.setString(3,M.getNom());

      
                ps.executeUpdate();
                System.out.println("DONE UPDATE");
            } catch (SQLException ex) {
          //Logger.getLogger(BoutiqueDAO.class.getName()).log(Level.SEVERE, null, ex);

            }}
    
    
    
       public  void afficherOrder(Materiels M){
    
        try {
            Statement st = C.createStatement();
            
            String str;
            str = "select * from materiels order by quantitee ASC ";
            
            ResultSet rs = st.executeQuery(str);
            
             while(rs.next()){
             System.out.println(" nom : "+rs.getString(1)+" quantitee :  "+rs.getInt(2)+" lieu: "+rs.getString(3)+" etat :  "+rs.getString(4));
             }
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
    }
    
    
    
}
