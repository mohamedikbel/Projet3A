/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entite.Avis;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.MaConnexion;

/**
 *
 * @author PC
 */
public class AvisDB {
Connection  C  = MaConnexion.getinstence().getcon(); 
     
     
     public void ajoutersalles(Avis  A){
    
        try {
            Statement st = C.createStatement();
            String query = "insert into avis values("+A.getId()+",'"+A.getObjet()+"','"+A.getProbleme()+"','"+A.getSolution()+"')";
            
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }      
}
